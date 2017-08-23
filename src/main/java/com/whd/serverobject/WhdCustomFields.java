package com.whd.serverobject;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whd.WhdApi;
import com.whd.WhdAuth;
import com.whd.WhdException;
import com.whd.autogen.CustomFieldDefinition;
import com.whd.autogen.ticket.CustomField;
import com.whd.autogen.ticket.WhdTicket;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by vikramp on 2/13/17.
 */
public class WhdCustomFields {
    private static final Logger log = LoggerFactory.getLogger(WhdCustomFields.class);

    private final BiMap<Integer, String> customFieldMap;

    public WhdCustomFields(WhdAuth auth) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        for(CustomFieldDefinition p : WhdApi.getCustomFieldDefinitions(auth)) {
            mapBuilder.put(p.getId(), p.getLabel().replace(" ", ""));
        }

        customFieldMap = mapBuilder.build();
    }

    public String getCustomField(WhdTicket ticket, String customFieldName) throws WhdException {
        log.debug("Getting Custom field for field name: {}", customFieldName);

        Integer custFieldId;
        if (customFieldMap.inverse().containsKey(customFieldName.replace(" ", "")))
            custFieldId = customFieldMap.inverse().get(customFieldName.replace(" ", ""));
        else
            throw new WhdException("Custom Field not present in WHD instance");

        log.debug("Field ID: {}", custFieldId);

        // First check the List<CustomField> for custom field
        for (CustomField cf : ticket.getCustomFields()) {
            if (cf.getDefinitionId() == custFieldId) {
                return cf.getRestValue();
            }
        }

        return null; // return null if no custom field value is found in ticket
    }

    public void setCustomField(WhdTicket ticket, String customFieldName, String fieldVal) throws WhdException {
        log.debug("Getting Custom field for field name: {}", customFieldName);
        try {
            Integer custFieldId;
            if (customFieldMap.inverse().containsKey(customFieldName.replace(" ", "")))
                custFieldId = customFieldMap.inverse().get(customFieldName.replace(" ", ""));
            else
                throw new WhdException("Custom Field not present in WHD instance");

            log.debug("Field ID: {}", custFieldId);

            if (ticket.getCustomFields() == null) {
                ticket.setCustomFields(new ArrayList<>());
            }

            boolean exists = false;
            for (CustomField cField : ticket.getCustomFields()) {
                if (cField.getDefinitionId() == custFieldId) {
                    cField.setRestValue(fieldVal);
                    exists = true;
                }
            }

            if (!exists) {
                CustomField custField = new CustomField();
                custField.setDefinitionId(custFieldId);
                custField.setRestValue(fieldVal);

                ticket.getCustomFields().add(custField);
            }

        } catch ( SecurityException | IllegalArgumentException ex) {
            log.error(ExceptionUtils.getStackTrace(ex));
            throw new WhdException(ex);
        }
    }

    public String getCustomFieldName(Integer id) {
        return customFieldMap.get(id);
    }

    public Integer getCustomFieldId(String locName) {
        return customFieldMap.inverse().get(locName);
    }

    public BiMap<Integer, String> getCustomFieldMap() {
        return customFieldMap;
    }
}
