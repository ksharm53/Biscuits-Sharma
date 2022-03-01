package com.biscuit.commands.taiga.impl;

import java.net.URI;
import java.util.Collections;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.biscuit.commands.taiga.TaigaProjectIfs;
import com.biscuit.models.ProjectResponse;
import com.biscuit.utility.Constants;

import io.fabric8.taiga.ProjectDTO;

public class TaigaProjectImpl implements TaigaProjectIfs{	

	Logger logger = Logger.getLogger(TaigaProjectImpl.class.getName()); 
	RestTemplate restTemplate = new RestTemplate();

	public TaigaProjectImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public TaigaProjectImpl() {
		super();
	}

	@Override
	public ProjectDTO addTaigaProject(ProjectDTO project)
	{ 
		try { 

			String taigaAPIUrl =Constants.ADD_TAIGA_API_URL; 
			URI uri = new URI(taigaAPIUrl);

			HttpHeaders headers = new HttpHeaders(); 
			headers.set(Constants.AUTHORIZATION,Constants.BEARER + Constants.ACCESS_TOKEN);
			headers.setContentType(MediaType.APPLICATION_JSON);

			System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

			MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
			restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

			HttpEntity <ProjectDTO> requestEntity = new HttpEntity<ProjectDTO>(project, headers); 

			return restTemplate.postForObject(uri,requestEntity,ProjectDTO.class);

		} catch (Exception ex) { 
			logger.info(ex.getMessage()); 
		}

		return null;
	}


	@Override
	public ResponseEntity<ProjectResponse> getbyTaigaProjectSlug(String slugName)
	{ 
		try { 

			String taigaAPIUrl =Constants.GET_TAIGA_SLUG_NAME_API_URL; 

			HttpHeaders headers = new HttpHeaders(); 
			headers.set(Constants.AUTHORIZATION,Constants.BEARER + Constants.ACCESS_TOKEN);
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
			restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

			HttpEntity<Void> requestEntity = new HttpEntity<>(headers); 

			return restTemplate.exchange(taigaAPIUrl,HttpMethod.GET,requestEntity, ProjectResponse.class,slugName);

		} catch (Exception ex) { 
			logger.info(ex.getMessage()); 
		}

		return null;
	}

}
