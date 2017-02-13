package com.whd.so;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.whd.WhdApi;
import com.whd.WhdAuth;
import com.whd.WhdException;
import com.whd.autogen.RequestTypeDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdRequestType {

    private static final Logger logger = LoggerFactory.getLogger(WhdLocations.class);

    private final BiMap<Integer, String> requestTypeMap;
    private final Map<Integer, RequestTypeDefinition> requestTypeDefinitionMap;

    public WhdRequestType(WhdAuth auth) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        List<RequestTypeDefinition> reqTypeLst = WhdApi.getRequestTypeDefinitions(auth);

        ImmutableMap.Builder<Integer, RequestTypeDefinition> reqTypeDefMapBuilder = new ImmutableMap.Builder<>();

        for (RequestTypeDefinition p : reqTypeLst) {
            reqTypeDefMapBuilder.put(p.getId(), p);
        }

        requestTypeDefinitionMap = reqTypeDefMapBuilder.build();

        for (RequestTypeDefinition p : reqTypeLst) {
            mapBuilder.put(p.getId(), getCompleteRequestTypeLabel(p));
        }

        requestTypeMap = mapBuilder.build();
    }

    public String getRequestTypeName(Integer id) {
        return requestTypeMap.get(id);
    }

    public Integer getRequestTypeId(String reqTypeName) {
        return requestTypeMap.inverse().get(reqTypeName);
    }

    public BiMap<Integer, String> getRequestTypeMap() {
        return requestTypeMap;
    }

    public String getHeadParentLabel(Integer id) {
        RequestTypeDefinition f = requestTypeDefinitionMap.get(id);
        if (f.getParentId() == null) {
            return f.getProblemTypeName();
        } else {
            return getHeadParentLabel(f.getParentId());
        }
    }

    public String getSecondTierClassification(String problemTypeStr) {
        if (problemTypeStr.contains("/")) {
            int begIndex = problemTypeStr.indexOf('/') + 1;
            int endIndex = problemTypeStr.indexOf('/', begIndex);
            endIndex = (endIndex == -1) ? problemTypeStr.length() : endIndex;

            return problemTypeStr.substring(begIndex, endIndex);
        } else return null;
    }

    private String getCompleteRequestTypeLabel(RequestTypeDefinition f) {
        if (f.getParentId() == null) {
            return f.getProblemTypeName();
        } else {
            return String.format("%s/%s",
                    getCompleteRequestTypeLabel(requestTypeDefinitionMap.get(f.getParentId())),
                    f.getProblemTypeName());
        }
    }

    private String getSecondTierClassification(RequestTypeDefinition f) {
        return getSecondTierClassification(getCompleteRequestTypeLabel(f));
    }

}
