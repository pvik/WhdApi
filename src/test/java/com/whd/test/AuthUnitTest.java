package com.whd.test;

import com.whd.Util;
import com.whd.WhdAuth;
import com.whd.WhdException;
import org.junit.Test;

public class AuthUnitTest {
    
    @Test
    public void testAuthenticatePassword() throws WhdException {
        WhdAuth auth = new WhdAuth(TestDetails.whdUri, Util.WhdAuthType.PASSWORD, TestDetails.username, TestDetails.password);
        // If authenticate() fails, then WhdException will be thrown, 
        //     failing the test case
        auth.authenticate();
    }
    
    @Test
    public void testAuthenticateSessionKey() throws WhdException {
        WhdAuth auth = new WhdAuth(TestDetails.whdUri, Util.WhdAuthType.PASSWORD, TestDetails.username,  null);
        // If authenticate() fails, then WhdException will be thrown, 
        //     failing the test case
        auth.authenticate(TestDetails.password);
    }
    
    @Test
    public void testAuthenticateApiKey() {
        WhdAuth auth = new WhdAuth(TestDetails.whdUri, Util.WhdAuthType.PASSWORD, TestDetails.username,  TestDetails.apiKey);
        // TODO: Assert if auth is valid, how??
    }
    
    @Test(expected=WhdException.class)
    public void testAuthenticateSessionKeyFail() throws WhdException {
        WhdAuth auth = new WhdAuth(TestDetails.whdUri, Util.WhdAuthType.PASSWORD, TestDetails.username,  null);
        auth.authenticate(TestDetails.password+"abc");
    }
    
    @Test(expected=WhdException.class)
    public void testAuthenticatePasswordFail() throws WhdException {
        WhdAuth auth = new WhdAuth(TestDetails.whdUri, Util.WhdAuthType.PASSWORD, TestDetails.username, TestDetails.password+ "abc");
        auth.authenticate();
    }
    
    
}