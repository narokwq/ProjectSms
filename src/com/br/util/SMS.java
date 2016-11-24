package com.br.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;



public class SMS {
	
	public static final String ACCOUNT_SID = "ACfc639876a005815c0467296f8a4b651f";  
	public static final String AUTH_TOKEN = "85c1fff58372bb3f6ffe936e7a4b641e";
	 
	public static void enviarSms(String tel){
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
		 
		 // Build the parameters 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Hello from Java"));
		 params.add(new BasicNameValuePair("To", "+55"+tel));
		 params.add(new BasicNameValuePair("From", "+12568294994"));
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = null;
		try {
			message = messageFactory.create(params);
			 System.out.println(message.getSid()); 
		} catch (TwilioRestException e) {
		} 
		
		
	}
}
