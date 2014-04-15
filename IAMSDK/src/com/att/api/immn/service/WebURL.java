package com.att.api.immn.service;

/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4: */

/*
 * ====================================================================
 * LICENSE: Licensed by AT&T under the 'Software Development Kit Tools
 * Agreement.' 2014.
 * TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTIONS:
 * http://developer.att.com/sdk_agreement/
 *
 * Copyright 2014 AT&T Intellectual Property. All rights reserved.
 * For more information contact developer.support@att.com
 * ====================================================================
 */

//package com.att.api.aab.service;

import org.json.JSONException;
import org.json.JSONObject;

public final class WebURL {
    public final String type;
    public final String url;
    public final Boolean preferred;

    public WebURL(String type, String url, Boolean preferred) {
        this.type = type;
        this.url = url;
        this.preferred = preferred;
    }

    public Boolean isPreferred() {
        return preferred;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public JSONObject toJson() {
        JSONObject jobj = new JSONObject();

        final String[] keys = { "type", "url", "preferred" };
        String prefString = null;
        if (isPreferred() != null) {
            prefString = isPreferred() ? "TRUE" : "FALSE";
        }
        final String[] values = { getType(), getUrl(), prefString };

        for (int i = 0; i < keys.length; ++i) {
            if (values[i] == null) continue;
            try {
				jobj.put(keys[i], values[i]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return jobj;
    }

    public static WebURL valueOf(JSONObject jobj) {
        String type = null;
		try {
			type = jobj.has("type") ? jobj.getString("type") : null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = null;
		try {
			url = jobj.has("url") ? jobj.getString("url") : null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Boolean pref = null;
		try {
			pref = jobj.has("preferred") ? jobj.getBoolean("preferred") : null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new WebURL(type, url, pref);
    }

}
