package com.spring.flux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.flux.service.VideoService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class VideoHandler {

	@Autowired
	private VideoService service;

	public Mono<ServerResponse> watchVideo(ServerRequest request) {
		String rangeHeader = request.headers().firstHeader("Range");
		log.error("first header - " + rangeHeader);
		return ServerResponse.ok().body(service.getVideo(request.queryParam("v").get()), Resource.class);
	}

}
