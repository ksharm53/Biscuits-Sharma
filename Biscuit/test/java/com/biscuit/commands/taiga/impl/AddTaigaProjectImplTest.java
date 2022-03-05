package com.biscuit.commands.taiga.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.biscuit.models.ProjectResponse;

import io.fabric8.taiga.ProjectDTO;

@RunWith(MockitoJUnitRunner.class)
public class AddTaigaProjectImplTest {


	@InjectMocks
	TaigaProjectImpl addTaigaProjectImpl;
	
	@Mock
	RestTemplate restTemplate;

	@Mock
	ProjectDTO projectResponse;

	@Mock
	ResponseEntity<ProjectResponse> responseEntity;
	
	@Mock
	ProjectResponse responseBody;

	ProjectDTO projectRequest;
	HttpEntity <ProjectDTO> requestEntity;

	ResponseEntity<ProjectResponse> getProjectResponse;
	String authToken;

	@Before
	public void setUp() throws Exception {		
		
		projectRequest= new ProjectDTO();
		projectRequest.setDescription("Test Java Description");
		projectRequest.setName("Test Java");

	}

	@Test(expected = ClassNotFoundException.class)
	public void testClassAvailability() throws ClassNotFoundException{

		Class.forName("TaigaProjectImpl");
	}

	@Test
	public void validateMethods() throws ClassNotFoundException {
		Class<?> TaigaProjectClass = Class.forName("com.biscuit.commands.taiga.impl.TaigaProjectImpl");

		Method[] taigaMethods = TaigaProjectClass.getDeclaredMethods();
		List<String> actualMethodList = getMethodNames(taigaMethods);

		assertEquals(2, actualMethodList.size());
		assertTrue(actualMethodList.containsAll(Arrays.asList("addTaigaProject")));

	}


	@Test
	public void validateInterface() throws ClassNotFoundException {
		Class<?> TaigaProjectClass = Class.forName("com.biscuit.commands.taiga.impl.TaigaProjectImpl");

		Class<?>[] taigaInterfaces = TaigaProjectClass.getInterfaces();

		assertEquals(1, taigaInterfaces.length);
		assertEquals("TaigaProjectIfs", taigaInterfaces[0].getSimpleName());

	}

	@Test
	public void validateConstructors() throws ClassNotFoundException {
		Class<?> TaigaProjectClass = Class.forName("com.biscuit.commands.taiga.impl.TaigaProjectImpl");

		Constructor<?>[] taigaConstructors = TaigaProjectClass.getConstructors();

		assertEquals(2, taigaConstructors.length);
		assertEquals("com.biscuit.commands.taiga.impl.TaigaProjectImpl", taigaConstructors[0].getName());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetByTaigaSlugFailure() throws URISyntaxException 
	{				

		responseBody= new ProjectResponse();
		responseBody.setName("Beta project");
		responseBody.setSlug("kanavsharma-beta-project");

		responseEntity= new ResponseEntity<>(responseBody,HttpStatus.OK);	
		addTaigaProjectImpl= new TaigaProjectImpl(this.restTemplate);
		
		doReturn(responseEntity).when(this.restTemplate).exchange(
			    any(String.class), 
			    any(HttpMethod.class), 
			    any(HttpEntity.class),              
			    any(Class.class),
			    any(String.class)
			);
		
		responseEntity= addTaigaProjectImpl.getbyTaigaProjectSlug("kanavsharma-beta-project");	

		ProjectResponse actualReponseBody= responseEntity.getBody();

		assertEquals("kanavsharma-beta-project", actualReponseBody.getSlug());
		assertEquals("Beta project", actualReponseBody.getName());

	}

	@Test
	public void testAddProjectSuccess() throws URISyntaxException 
	{

		projectResponse= new ProjectDTO();
		projectResponse.setDescription("Test Java Description");
		projectResponse.setName("Test Java");

		Mockito.when(this.restTemplate.postForObject(Matchers.anyObject(), Matchers.any(),
				Matchers.<Class<ProjectDTO>>any()))
		.thenReturn(projectResponse);

		addTaigaProjectImpl= new TaigaProjectImpl(this.restTemplate);

		projectResponse=addTaigaProjectImpl.addTaigaProject(projectRequest,authToken);
		Assert.assertEquals("Test Java", projectResponse.getName());
	}	


	/**
	 * @param methods
	 * @return
	 * 
	 * Utility method to get List out of Array
	 */
	private static List<String> getMethodNames(Method[] methods) {
		List<String> methodNames = new ArrayList<>();
		for (Method method : methods)
			methodNames.add(method.getName());
		return methodNames;
	}

}
