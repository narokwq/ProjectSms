package com.br.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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
		 params.add(new BasicNameValuePair("To", format(tel)));
		 params.add(new BasicNameValuePair("From", "+12568294994"));
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		try {
			 Message message= messageFactory.create(params);
		} catch (TwilioRestException e) {
			System.out.println(e);
		} 
	}
	
	public static String format(String telefone){
		String telefoneFormatado = "";
		for (int i = 0; i < telefone.length(); i++) {
			if(Character.isDigit(telefone.charAt(i))){
				telefoneFormatado += telefone.charAt(i);
			}
		}
		return telefoneFormatado;
	}
	
	
	public static void enviarLocasms(String tel, String message){
		try {
			String urlString = String.format("http://54.173.24.177/painel/api.ashx?action=sendsms&lgn=83987182544&pwd=253620&msg=%s&numbers=%s", URLEncoder.encode(message, "UTF-8"), tel);
			System.out.println(urlString);
//			URL url = new URL(urlString);
//			URLConnection conn = url.openConnection();
//			conn.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
