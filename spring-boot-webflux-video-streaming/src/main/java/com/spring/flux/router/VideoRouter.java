package com.spring.flux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.flux.handler.VideoHandler;

@Configuration
public class VideoRouter {

	@Autowired
	private VideoHandler handler;

	@Bean
	public RouterFunction<ServerResponse> videoroute() {
		return RouterFunctions.route(RequestPredicates.GET("/video"), handler::watchVideo);
	}
}
