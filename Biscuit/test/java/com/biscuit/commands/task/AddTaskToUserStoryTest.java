
package com.biscuit.commands.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.biscuit.utility.Constants;
import com.biscuit.utility.Utility;

public class AddTaskToUserStoryTest{

	@Test(expected = ClassNotFoundException.class)
	public void testClassAvailability() throws ClassNotFoundException{

		Class.forName("AddTaskToUserStory");
	}

	@Test
	public void validateMethods() throws ClassNotFoundException {
		Class<?> tasksClass = Class.forName(Constants.TASKS_IMPL);

		Method[] tasksMethods = tasksClass.getDeclaredMethods();
		List<String> actualMethodList = Utility.getMethodNames(tasksMethods);

		assertEquals(6, actualMethodList.size());
		assertTrue(actualMethodList.containsAll(Arrays.asList("setBusinessValue")));

	}
	
	
	@Test
	public void validateInterface() throws ClassNotFoundException {
		Class<?> tasksClass = Class.forName(Constants.TASKS_IMPL);

		Class<?>[] taigaInterfaces = tasksClass.getInterfaces();

		assertEquals(1, taigaInterfaces.length);
		assertEquals("Command", taigaInterfaces[0].getSimpleName());

	}

}
