package com.biscuit.commands.taiga.impl;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.biscuit.commands.taiga.TaigaProjectIfs;

import io.fabric8.taiga.ProjectDTO;


public class AddTaigaProjectImplTest {

	TaigaProjectIfs addTaigaProjectImpl;
	ProjectDTO projectResponse;
	ProjectDTO projectRequest;

	@Before
	public void setUp() throws Exception {		
		
		projectRequest= new ProjectDTO();
		projectRequest.setDescription("Test Java Description");
		projectRequest.setName("Test Java");
		
		addTaigaProjectImpl= new TaigaProjectImpl();
		
	}

	@Test(expected = ClassNotFoundException.class)
	public void testClassAvailability() throws ClassNotFoundException{

		Class.forName("TaigaProjectImpl");
	}

	@Test
	public void testAddEmployeeWithoutHeader_success() throws URISyntaxException 
	{
		projectResponse=addTaigaProjectImpl.addTaigaProject(projectRequest);
		
		Assert.assertEquals("Test Java", projectResponse.getName());
	}


}
