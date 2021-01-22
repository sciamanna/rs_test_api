package com.sciamanna;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sciamanna.model.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;


public class SaveTaskHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	private static final Logger LOG = LogManager.getLogger(SaveTaskHandler.class);

	@Override
	//public ApiGatewayResponse handleRequest(ApiGatewayResponse, Context context) {
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
		LOG.info("received the request");
		//Response responseBody = new Response("Hello Cute! Your function executed successfully!", input);

		String userId = request.getPathParameters().get("userId");
		String requestBody = request.getBody();

		ObjectMapper objMapper = new ObjectMapper();
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		response.setStatusCode(200);

		try {
			Task t = objMapper.readValue(requestBody, Task.class);
			LOG.debug ("Saved task: " + t.getDescription());
			response.setBody("Task Saved");
		} catch (IOException e) {
			LOG.error("unable to marchall JSON for adding a task", e);
		}
		return response;
	}
}
