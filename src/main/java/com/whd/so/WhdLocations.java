package com.whd.so;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whd.autogen.LocationDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdLocations {

    private static final Logger logger = LoggerFactory.getLogger(WhdLocations.class);

    private final BiMap<Integer, String> locationMap;

    public WhdLocations(List<LocationDefinition> locationDefs) {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        for(LocationDefinition loc : locationDefs) {
            mapBuilder.put(loc.getId(), loc.getLocationName());
        }

        locationMap = mapBuilder.build();
    }

    public String getLocationName(Integer id) {
        return locationMap.get(id);
    }

    public Integer getLocationId(String locName) {
        return locationMap.inverse().get(locName);
    }
}
