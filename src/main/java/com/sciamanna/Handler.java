package com.sciamanna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sciamanna.model.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);
		//Response responseBody = new Response("Hello Cute! Your function executed successfully!", input);

		Task t1 = new Task ("t001", "Iron", false);
		Task t2 = new Task ("t002", "Hang Clothes", false);
		//Task t3 = null;
		//System.out.println(t3.getDescription());

		List<Task> tasks = new ArrayList<>();
		tasks.add(t1);
		tasks.add(t2);
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(tasks)
				.build();
	}
}
