package com.whd;

import com.whd.so.WhdLocations;
import com.whd.so.WhdPriority;

import java.util.List;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdServerObjects {

    private final WhdLocations locations;
    private final WhdPriority whdPriority;

    public WhdServerObjects() throws WhdException {
        throw new WhdException("Invalid invocation of WhdServerObjects");
    }

    public WhdServerObjects(WhdAuth auth)
            throws WhdException {
        this.locations = new WhdLocations(auth);

        this.whdPriority = new WhdPriority(auth);
    }

    public WhdServerObjects(WhdAuth auth, List<String> locationPrefixes)
            throws WhdException {
        this.locations = new WhdLocations(auth, locationPrefixes);

        this.whdPriority = new WhdPriority(auth);
    }

    public WhdLocations getLocations() {
        return locations;
    }

    public WhdPriority getPriority() {
        return whdPriority;
    }
}
