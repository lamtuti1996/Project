package com.azportal.service.warning.http;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class HTTPServiceConfig extends ResourceConfig {
	public HTTPServiceConfig() {
		packages("com.azportal.service.warning.httpcontroller");
//		packages("com.azplay.azportal.httpcontroller.impl");
        register(ObjectMapperContextResolver.class);
        register(JacksonFeature.class);
	}


}
