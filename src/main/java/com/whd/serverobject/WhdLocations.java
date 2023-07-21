package com.whd.serverobject;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whd.WhdApi;
import com.whd.WhdAuth;
import com.whd.WhdException;
import com.whd.autogen.LocationDefinition;
import com.whd.autogen.ticket.WhdTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdLocations {

    private static final Logger logger = LoggerFactory.getLogger(WhdLocations.class);

    private final BiMap<Integer, String> locationMap;

    public WhdLocations(WhdAuth auth) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        for(LocationDefinition loc : WhdApi.getLocationList(auth)) {
            mapBuilder.put(loc.getId(), loc.getLocationName());
        }

        locationMap = mapBuilder.build();
    }

    public WhdLocations(WhdAuth auth, List<String> locationPrefixes) throws WhdException {
        ImmutableBiMap.Builder<Integer, String> mapBuilder = new ImmutableBiMap.Builder<>();

        Map<Integer, String> tmpMap = new HashMap<>();
        Map<String, Integer> tmpMapRev = new HashMap<>();

        for (String locPrefix : locationPrefixes) {
            logger.trace("getting locations with prefix: {}", locPrefix);
            List<LocationDefinition> locations = WhdApi.searchLocations(auth, "(locationName like '" + locPrefix + "*') and ((deleted = null) or (deleted = 0))");

            if (locations != null) {
                for (LocationDefinition loc : locations) {

                    tmpMap.put(loc.getId(), loc.getLocationName());

                    if(tmpMapRev.containsKey(loc.getLocationName())) {
                        logger.warn ("Found duplicate location for {} ({}), skipping..", loc.getLocationName(), loc.getId());
                        tmpMap.remove(loc.getId());
                    } else {
                        tmpMapRev.put(loc.getLocationName(), loc.getId());
                    }
                }
            }
        }

        for (Integer k : tmpMap.keySet()) {
            mapBuilder.put(k, tmpMap.get(k));
        }
        locationMap = mapBuilder.build();
    }

    public String getLocationName(WhdTicket whdTicket) throws WhdException {
        if (whdTicket.getLocation() != null)
            return whdTicket.getLocation().getLocationName();
        else if (whdTicket.getLocationId() != null)
            return locationMap.get(whdTicket.getLocationId());
        else throw new WhdException("Ticket location is not set in WHD or " +
                    "Exception trying to retrieve location from ticket");
    }

    public String getLocationName(Integer id) {
        return locationMap.get(id);
    }

    public Integer getLocationId(String locName) {
        return locationMap.inverse().get(locName);
    }

    public BiMap<Integer, String> getLocationMap() {
        return locationMap;
    }
}
