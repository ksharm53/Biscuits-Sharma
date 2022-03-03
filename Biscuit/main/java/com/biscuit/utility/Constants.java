package com.biscuit.utility;

public final class Constants {

	public static final String ADD_TAIGA_API_URL = "https://api.taiga.io/api/v1/projects";
	public static final String AUTHORIZATION ="Authorization";
	public static final String BEARER ="Bearer ";
	public static final String ACCESS_TOKEN ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjQ2Mjg0MjA1LCJqdGkiOiI2M2MyOTZkNDM5ZTE0NzA1YWNlNWIwOTAxYzc5NzExOCIsInVzZXJfaWQiOjUwMTU3M30.Is8OhH4AEDM1C0TrT0Uh4Ldp_9xDYho36hfsFs8yqvk";
	public static final String RELEASE_ADD_MESSAGE = " : Release Added by Buiscuit";
	public static final String RELEASE_EDIT_MESSAGE = " : Release Edited by Buiscuit";
	public static final String TASK_ADD_MESSAGE = "Task created for: ";
	public static final String ADD_USERSTORY_MESSAGE = "UserStory added to backlog by Buiscuit: ";
	public static final String EDIT_USERSTORY_MESSAGE = "UserStory edited by Buiscuit: ";
	public static final String EDIT_USERSTORY_STATUS_MESSAGE = "State of user story ";
	public static final String GET_TAIGA_SLUG_NAME_API_URL = "https://api.taiga.io/api/v1/projects/by_slug?slug={slug}";
	public static final String ADD_PROJECT_SUCCESS = "Project added successfully to Taiga. Please log in to https://taiga.io/ to access this project.";
	public static final String ADD_PROJECT_FAILURE = "Error Saving project. Please try again.";
	
	public static final String TASKS_IMPL = "com.biscuit.commands.task.AddTaskToUserStory";

	
}
