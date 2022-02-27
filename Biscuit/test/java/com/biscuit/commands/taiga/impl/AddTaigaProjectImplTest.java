package com.biscuit.commands.taiga.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.biscuit.utility.Constants;

import io.fabric8.taiga.ProjectDTO;

@RunWith(MockitoJUnitRunner.class)
public class AddTaigaProjectImplTest {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	TaigaProjectImpl addTaigaProjectImpl;

	@Mock
	ProjectDTO projectResponse;

	ProjectDTO projectRequest;
	String taigaAPIUrl;
	URI uri;
	HttpHeaders headers;	
	HttpEntity <ProjectDTO> requestEntity;

	@Before
	public void setUp() throws Exception {		

		projectRequest= new ProjectDTO();
		projectRequest.setDescription("Test Java Description");
		projectRequest.setName("Test Java");

		taigaAPIUrl = Constants.ADD_TAIGA_API_URL;
		uri = new URI(taigaAPIUrl);

		headers = new HttpHeaders(); 
		headers.set(Constants.AUTHORIZATION,Constants.BEARER + Constants.ACCESS_TOKEN);
		headers.setContentType(MediaType.APPLICATION_JSON);

		requestEntity = new HttpEntity<ProjectDTO>(projectRequest, headers);

	}

	@Test(expected = ClassNotFoundException.class)
	public void testClassAvailability() throws ClassNotFoundException{

		Class.forName("TaigaProjectImpl");
	}

	@Test
	public void testAddEmployeeWithoutHeader_success() throws URISyntaxException 
	{

		projectResponse= new ProjectDTO();
		projectResponse.setDescription("Test Java Description");
		projectResponse.setName("Test Java");

		Mockito.when(this.restTemplate.postForObject(Matchers.anyObject(), Matchers.any(),
				Matchers.<Class<ProjectDTO>>any()/* , Matchers.<Object>anyVararg() */))
		.thenReturn(projectResponse);

		addTaigaProjectImpl= new TaigaProjectImpl(this.restTemplate);

		projectResponse=addTaigaProjectImpl.addTaigaProject(projectRequest);
		Assert.assertEquals("Test Java", projectResponse.getName());
	}


}
