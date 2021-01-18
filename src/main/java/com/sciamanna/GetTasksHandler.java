package com.sciamanna;
//package com.amazonaws.services.lambda.runtime.events;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sciamanna.model.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


//public class GetTasksHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {
public class GetTasksHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	private static final Logger LOG = LogManager.getLogger(GetTasksHandler.class);

	@Override
	//public ApiGatewayResponse handleRequest(ApiGatewayResponse, Context context) {
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
		LOG.info("received the request");
		//Response responseBody = new Response("Hello Cute! Your function executed successfully!", input);

		String userId = request.getPathParameters().get("userId");
		List<Task> tasks = new ArrayList<>();
		if(userId.equals("abc123")){
			Task t1 = new Task ("t001", "Iron", false);
			tasks.add(t1);
		}else {
			Task t2 = new Task ("t002", "Hang Clothes", false);
			tasks.add(t2);
		}

		//Task t3 = null;
		//System.out.println(t3.getDescription());

		/*return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(tasks)
				.build();*/

		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		response.setStatusCode(200);

		  ObjectMapper objectMapper = new ObjectMapper();
		try {
			String responseBody = objectMapper.writeValueAsString(tasks);
			response.setBody(responseBody);
		}
		catch (JsonProcessingException e) {
			LOG.error("Unable to marshall tasks array", e);
		}
		return response;
	}
}
