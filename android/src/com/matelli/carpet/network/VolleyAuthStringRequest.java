package com.matelli.carpet.network;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

public class VolleyAuthStringRequest extends StringRequest {
	
	Context context;

    public VolleyAuthStringRequest(int method, String url, 
            Response.Listener<String> listener,
            Response.ErrorListener errorListener, Context context) {
        super(method, url, listener, errorListener);
        this.context = context;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
    	Map<String, String> headers = new HashMap<String, String>();  
		
    	headers.put("Accept-Charset", "UTF-8");
		headers.put("device_id", "DSK324JDSK4DFS23UK");
		headers.put("device_code", "android");
		
		return headers;
    }
    
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, "UTF-8");

            return Response.success(jsonString,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

}
