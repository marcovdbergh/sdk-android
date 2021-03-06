package com.playhaven.sampleapp.examples;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import com.playhaven.src.common.PHAPIRequest;
import com.playhaven.src.publishersdk.open.PHPublisherOpenRequest;

/** Tests the publisher open request to the server and post status messages.*/
public class PublisherOpenView extends ExampleView implements PHAPIRequest.Delegate {
	private PHPublisherOpenRequest request;
	
	@Override
	public void onCreate(Bundle savedInstance) {
		//setup list adapter, etc.
		super.onCreate(savedInstance);
		
		setTitle("Open Request");
	}
	
	@Override
	public void startRequest() {
		super.startRequest();
		
		request = new PHPublisherOpenRequest(this, this);
	
		request.send();

	}
	
	///////////////////////////////////////////////////////////////
	////////////////////////// Delegate Methods ///////////////////
	public void requestSucceeded(PHAPIRequest request, JSONObject responseData) {
		try {
			String formattedJson = responseData.toString(2);
			super.addMessage(String.format("Success with response: %s", formattedJson));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	public void requestFailed(PHAPIRequest request, Exception e) {
		super.addMessage(String.format("Failed with error: %s", e.toString()));
	}
	
}