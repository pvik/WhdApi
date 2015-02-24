package com.whd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import java.io.IOException;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import org.apache.http.HttpStatus;

public class Util {
    
    public static final String whdUrn = "/helpdesk/WebObjects/Helpdesk.woa/ra/{resource_type}";
    
    public static final ObjectMapper jsonMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    
    public enum WHD_AUTH_TYPE {PASSWORD, SESSION_KEY, API_KEY};
    
    /**
     *
     * @param e
     * @throws com.whd.WhdException
     */
    public static void processResponseForException(HttpResponse e) throws WhdException {
        WhdException wex = new WhdException("Web Help Desk RestAPI Exception");
        
        int statusCode = e.getStatus();
        
        switch(statusCode){
            case HttpStatus.SC_NOT_FOUND:
            case HttpStatus.SC_GATEWAY_TIMEOUT:
            case HttpStatus.SC_BAD_GATEWAY:
                wex.setExceptionType(WhdExceptionType.SERVER_UNREACHABLE);
                break;
            case HttpStatus.SC_UNAUTHORIZED:
                wex.setExceptionType(WhdExceptionType.AUTH_FAILURE);
                wex.setComment("Unable to Authenticate to Web Help Desk!");
                break;
            case HttpStatus.SC_FORBIDDEN:
                wex.setExceptionType(WhdExceptionType.PERMISSION_FAILURE);
                break;
            case HttpStatus.SC_INTERNAL_SERVER_ERROR:
                wex.setExceptionType(WhdExceptionType.SERVER_ERROR);
                break;
            case HttpStatus.SC_BAD_REQUEST:
                wex.setExceptionType(WhdExceptionType.INVALID_REQUEST);
                wex.setComment("Invalid Request to Web Help Desk: "+e.getBody().toString());
                break;
        }
        
        if(wex.exceptionType != null)
            throw wex;
    }
    
    /**
     *
     * @param e
     * @return
     */
    public static WhdException processJsonMapperIOException(IOException e){
        WhdException wex = new WhdException(e);
        wex .setExceptionType(WhdExceptionType.MALFORMED_RESPONSE);
        wex.setComment("Unable to process response from Web Help Desk: "+getStackTrace(e));
        return wex;
    }
}
