package com.whd;

import com.whd.so.WhdLocations;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdServerObjects {

    private final WhdLocations locations ;

    public WhdServerObjects() throws WhdException {
        throw new WhdException("Invalid invocation of WhdServerObjects");
    }

    public WhdServerObjects(WhdAuth auth) throws WhdException {
        this.locations = new WhdLocations(WhdApi.getLocationList(auth));
    }
}
