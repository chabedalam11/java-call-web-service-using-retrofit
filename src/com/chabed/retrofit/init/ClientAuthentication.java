package com.chabed.retrofit.init;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClientAuthentication {
	
	public String getToken() throws Exception{
		
		
		URL url = new URL("http://100.43.0.11:9003/login");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST"); 
		http.setDoOutput(true);
		
		byte[] out = "{\"username\":\"medisys\",\"password\":\"123\"}" .getBytes(StandardCharsets.UTF_8);
		int length = out.length;

		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		}
		
		
		StringBuilder builder = new StringBuilder();
		builder.append(http.getResponseCode())
		       .append(" ")
		       .append(http.getResponseMessage())
		       .append("\n");

		Map<String, List<String>> map = http.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : map.entrySet())
		{
		    if (entry.getKey() == null) 
		        continue;
		    builder.append( entry.getKey())
		           .append(": ");

		    List<String> headerValues = entry.getValue();
		    Iterator<String> it = headerValues.iterator();
		    if (it.hasNext()) {
		        builder.append(it.next());

		        while (it.hasNext()) {
		            builder.append(", ")
		                   .append(it.next());
		        }
		    }

		    builder.append("\n");
		}

		//System.out.println("builder:: " + builder);
		List<String> tokenList = map.get("Authorization");
		//System.out.println("token is  : " + tokenList.get(0));
		return tokenList.get(0);
	
		
	}
}
