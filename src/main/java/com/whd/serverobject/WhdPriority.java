package com.whd.serverobject;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whd.WhdApi;
import com.whd.WhdAuth;
import com.whd.WhdException;
import com.whd.autogen.PriorityTypeDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdPriority {

    private static final Logger logger = LoggerFactory.getLogger(WhdLocations.class);

    private final BiMap<Integer, String> priorityMap;

    public WhdPriority(WhdAuth auth) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        for(PriorityTypeDefinition p : WhdApi.getPriorityTypeDefinitions(auth)) {
            mapBuilder.put(p.getId(), p.getPriorityTypeName());
        }

        priorityMap = mapBuilder.build();
    }

    public String getPriorityName(Integer id) {
        return priorityMap.get(id);
    }

    public Integer getPriorityId(String locName) {
        return priorityMap.inverse().get(locName);
    }

    public BiMap<Integer, String> getPriorityMap() {
        return priorityMap;
    }
}
