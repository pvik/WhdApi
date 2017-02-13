package com.whd.serverobject;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whd.WhdApi;
import com.whd.WhdAuth;
import com.whd.WhdException;
import com.whd.autogen.StatusTypeDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdStatus {

    private static final Logger logger = LoggerFactory.getLogger(WhdLocations.class);

    private final BiMap<Integer, String> statusMap;

    public WhdStatus(WhdAuth auth) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        for(StatusTypeDefinition p : WhdApi.getStatusTypeDefinitions(auth)) {
            mapBuilder.put(p.getId(), p.getStatusTypeName());
        }

        statusMap = mapBuilder.build();
    }

    public String getStatusName(Integer id) {
        return statusMap.get(id);
    }

    public Integer getStatusId(String locName) {
        return statusMap.inverse().get(locName);
    }

    public BiMap<Integer, String> getStatusMap() {
        return statusMap;
    }
}
