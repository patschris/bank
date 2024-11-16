package com.trial.utilities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@ApplicationScoped
public class ResponseUtility {

	public Response okOrEmpty(Object entity) {
		return Response.ok(entity != null ? entity : Map.of()).build();
	}
}