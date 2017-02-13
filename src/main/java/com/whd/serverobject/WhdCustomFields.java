package com.whd.serverobject;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whd.WhdApi;
import com.whd.WhdAuth;
import com.whd.WhdException;
import com.whd.autogen.CustomFieldDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vikramp on 2/13/17.
 */
public class WhdCustomFields {
    private static final Logger logger = LoggerFactory.getLogger(WhdCustomFields.class);

    private final BiMap<Integer, String> customFieldMap;

    public WhdCustomFields(WhdAuth auth) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        for(CustomFieldDefinition p : WhdApi.getCustomFieldDefinitions(auth)) {
            mapBuilder.put(p.getId(), p.getLabel().replace(" ", ""));
        }

        customFieldMap = mapBuilder.build();
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
