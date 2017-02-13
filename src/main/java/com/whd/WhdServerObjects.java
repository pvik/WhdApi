package com.whd;

import com.whd.serverobject.WhdLocations;
import com.whd.serverobject.WhdPriority;
import com.whd.serverobject.WhdRequestType;
import com.whd.serverobject.WhdStatus;

import java.util.List;

/**
 * Created by vikramp on 2/12/17.
 */
public class WhdServerObjects {

    private final WhdLocations locations;
    private final WhdPriority priority;
    private final WhdRequestType requestType;
    private final WhdStatus status;

    public WhdServerObjects() throws WhdException {
        throw new WhdException("Invalid invocation of WhdServerObjects");
    }

    public WhdServerObjects(WhdAuth auth)
            throws WhdException {
        this.locations = new WhdLocations(auth);

        this.priority = new WhdPriority(auth);
        this.requestType = new WhdRequestType(auth);
        this.status = new WhdStatus(auth);
    }

    public WhdServerObjects(WhdAuth auth, List<String> locationPrefixes)
            throws WhdException {
        this.locations = new WhdLocations(auth, locationPrefixes);

        this.priority = new WhdPriority(auth);
        this.requestType = new WhdRequestType(auth);
        this.status = new WhdStatus(auth);
    }

    public WhdLocations getLocations() {
        return locations;
    }

    public WhdPriority getPriority() {
        return priority;
    }

    public WhdRequestType getRequestType() {
        return requestType;
    }

    public WhdStatus getStatus() {
        return status;
    }
}
