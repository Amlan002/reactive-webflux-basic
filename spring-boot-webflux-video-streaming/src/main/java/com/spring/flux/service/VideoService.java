package com.spring.flux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class VideoService {

	private final String format = "classpath:videos/%s.mp4";

	@Autowired
	private ResourceLoader resourceLoader;

	public Mono<Resource> getVideo(String vName) {
		return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(format, vName)));
	}

}
