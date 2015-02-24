package com.whd;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.whd.Util.WHD_AUTH_TYPE;
import com.whd.autogen.session.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vikramp
 */
public class WhdAuth {
    private static final Logger logger = LoggerFactory.getLogger(WhdAuth.class);
    
    private String username;
    private String password;
    private String sessionKey;
    private String apiKey;
    
    private WHD_AUTH_TYPE authType;
    
    private String whdUrl;
    
    /**
     *
     * @param uri
     */
    public WhdAuth(String uri) {
        this.whdUrl = uri+Util.whdUrn;
        clearAllVars();
    }
    
    /**
     *
     * @param uri
     * @param type
     * @param username
     * @param token
     */
    public WhdAuth(String uri, WHD_AUTH_TYPE type, String username, String token) {
        this.whdUrl = uri+Util.whdUrn;
        this.username = username;
        
        switch (type){
            case PASSWORD:
                this.authType = type;
                this.password = token;
                break;
            case SESSION_KEY:
                this.authType = type;
                if(token != null)
                    this.sessionKey = token;
                break;
            case API_KEY:
                this.authType = type;
                this.apiKey = token;
                break;
        }
    }
    
    /**
     * sends POST to WHD with username and password to obtain SessionKey
     *  Note: session key will be store in private variable.
     * @throws WhdException if authentication fails
     */
    public void authenticate() throws WhdException{
        logger.debug("authenticate()");
        
        logger.debug("WHD URL: {}", whdUrl);
        
        HashMap<String, String> getVars = new HashMap<>();
        getVars.put("username", username);
        getVars.put("password", password);
        
        switch (authType){
            case SESSION_KEY:
                this.sessionKey = getSessionKey(username, password);
                break;
            case PASSWORD:
                getSessionKey(username, password); // Don't save the session key, but verify credentials
                break;
            case API_KEY:
            default:
                // Do nothing
                logger.debug("");
                break;
        }
            
        logger.debug("Authenticated!");
    }
    
    /**
     * Send DELETE to WHD server with sessionkey to deactivate the sessionkey (if being used)
     *  Note: all authentication tokens in this object will be cleared
     * 
     * @return
     */
    public void close() {
        logger.debug("close()");
        
        if(authType == WHD_AUTH_TYPE.SESSION_KEY){
            logger.debug("using sessionkey, will try to deactivate it");
            HashMap<String, String> getVars = new HashMap<>();
            getVars.put("sessionKey", sessionKey);
            
            try {
                HttpResponse<JsonNode> req = Unirest.delete(whdUrl)
                        .header("accept", "application/json")
                        .routeParam("resource_type", "Session")
                        .queryString("username", username)
                        .queryString("sessionKey", sessionKey)
                        .asJson();
                
                logger.debug(req.toString());
                
            } catch (UnirestException ex) {
                logger.error(ex.getMessage());
            }
        }
        clearAllVars();
    }
    
    /**
     * Obtains a session key by querying 
     *   [WHDURI]/helpdesk/WebObjects/Helpdesk.woa/ra/Session?username=[username]&password=[password]
     * 
     * @param username
     * @param password
     * @return String sessionKey
     * @throws WhdException
     */
    public String getSessionKey(String username, String password) throws WhdException{
        try{
            HttpResponse<String> resp = Unirest.get(whdUrl)
                    .header("accept", "application/json")
                    .routeParam("resource_type", "Session")
                    .queryString("username", username)
                    .queryString("password", password)
                    .asString();
            
            Util.processResponseForException(resp);
            Session s = Util.jsonMapper.readValue(resp.getBody(), Session.class);
            return s.getSessionKey();
        }
        catch(UnirestException e){
            throw new WhdException("Error Authenticating to WHD: "+e.getMessage(), e);
        }
        catch( IOException e){
            throw Util.processJsonMapperIOException(e);
        }
    }
    
    /**
     * Clears all authentication tokens
     * 
     * @return
     */
    private void clearAllVars() {
        username = "";
        password = "";
        apiKey = "";
        sessionKey = "";
    }
    
    /**
     * Returns a Map of authentication parameters used while accessing 
     * the ReST API
     * 
     * @return map of authentication parameters
     */
    public Map<String, Object> generateAuthUrlParams(){
        Map<String, Object> urlParams = new HashMap<>();

        urlParams.put("username", username);
        switch (authType){
            case SESSION_KEY:
                urlParams.put("sessionKey", sessionKey);
                break;
            case PASSWORD:
                urlParams.put("password", password);
                break;
            case API_KEY:
                urlParams.put("apiKey", apiKey);
                break;
        }
        return urlParams;
    }

    /**
     *
     * @return
     */
    public String getWhdUrl() {
        return whdUrl;
    }
    
}
