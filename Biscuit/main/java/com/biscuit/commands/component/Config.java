package com.biscuit.commands.component;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.fabric8.taiga.ProjectDTO;

@Component
public class Config {

	RestTemplate restTemplate = new RestTemplate();
	
	public ProjectDTO addTaigaProject(RestTemplate restTemplate, URI uri, HttpEntity <ProjectDTO> requestEntity) {

		this.restTemplate= restTemplate;
		return restTemplate.postForObject(uri,requestEntity,ProjectDTO.class);

	}
}
