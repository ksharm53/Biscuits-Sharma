package com.biscuit.commands.taiga.impl;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.biscuit.commands.taiga.RegisterNewUser;
import com.biscuit.models.RegisterTaiga;
import com.biscuit.models.RegisterTaigaResponse;

public class RegisterNewUserImplTest {

	private RegisterNewUser registerNewUserImpl;
	RegisterTaiga registerTaiga;
	RegisterTaigaResponse response;

	@Before
	public void setUp() throws Exception {
		registerNewUserImpl= new RegisterNewUserImpl();
		
		registerTaiga= new RegisterTaiga("true", "test-registerkana@email.com", "test", "password", "public", "test-usernamekana");
	}

	@Test(expected = ClassNotFoundException.class)
	public void testClassAvailability() throws ClassNotFoundException{

		Class.forName("RegisterNewUserImpl");
	}

	@Test
	public void testAddEmployeeWithoutHeader_success() throws URISyntaxException 
	{
		response=registerNewUserImpl.register(registerTaiga);
		
		Assert.assertEquals("testEmail", response.getEmail());
	}


}
