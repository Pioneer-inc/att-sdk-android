package com.att.aabsampleapp;

public class Config {
	public static final String appScope = "AAB";
	public static final String fqdn = "https://api.att.com";

	// Enter the following details from the application created in
	// http://developer.att.com
	public static final String clientID = UPDATE_APP_KEY;
	public static final String secretKey = UPDATE_APP_KEY;
	public static final String redirectUri = UPDATE_APP_KEY;
	// Testers can test the customParam functionality by setting this config value to following combinations
	// "" - default behavior - do not send any custom_param
	// "bypass_onnetwork_auth"
	// "suppress_landing_page"
	// "bypass_onnetwork_auth,suppress_landing_page"
	public static final String customParam = "";
	// lowerTokenExpiryTimeTo parameter can be used to developer to lower access token expiry time
	// keep it as -1, if you do not want to override the expiration value returned by AT&T's API
	public static final long lowerTokenExpiryTimeTo = -1;
}
