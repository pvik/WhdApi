package com.whd;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import java.io.IOException;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;
import org.apache.http.HttpStatus;

public class Util {
    
    public static final String whdUrn = "/helpdesk/WebObjects/Helpdesk.woa/ra/{resource_type}";
    
    public static final ObjectMapper jsonMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);//
    
    public enum WhdAuthType {PASSWORD, SESSION_KEY, API_KEY};
    
    /**
     *
     * @param e
     * @throws com.whd.WhdException
     */
    public static void processResponseForException(HttpResponse e) throws WhdException {
        int statusCode = e.getStatus();
        
        switch(statusCode){
            case HttpStatus.SC_NOT_FOUND:
            case HttpStatus.SC_GATEWAY_TIMEOUT:
            case HttpStatus.SC_BAD_GATEWAY:
                throw new WhdException(WhdExceptionType.SERVER_UNREACHABLE,
                        "Unable to reach Web Help Desk Server!\n" +
                                e.getStatusText() + " : " +
                                e.getBody());
            case HttpStatus.SC_UNAUTHORIZED:
                throw new WhdException(WhdExceptionType.AUTH_FAILURE,
                        "Unable to Authenticate to Web Help Desk!\n" +
                                e.getStatusText() + " : " +
                                e.getBody());
            case HttpStatus.SC_FORBIDDEN:
                throw new WhdException(WhdExceptionType.PERMISSION_FAILURE,
                        "Insufficient permissions to perform operation on Web Help Desk Server!\n" +
                                e.getStatusText() + " : " +
                                e.getBody());
            case HttpStatus.SC_INTERNAL_SERVER_ERROR:
                throw new WhdException(WhdExceptionType.SERVER_ERROR,
                        "Web Help Desk Server Error!\n" +
                                e.getStatusText() + " : " +
                                e.getBody());
            case HttpStatus.SC_BAD_REQUEST:
                throw new WhdException(WhdExceptionType.INVALID_REQUEST,
                        "Invalid Request to Web Help Desk!\n" +
                                e.getStatusText() + " : " +
                                e.getBody());
        }
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
