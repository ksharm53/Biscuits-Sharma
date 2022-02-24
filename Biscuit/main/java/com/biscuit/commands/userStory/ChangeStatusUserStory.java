package com.biscuit.commands.userStory;

import java.io.IOException;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.UserStory;
import com.biscuit.models.enums.Status;
import com.biscuit.utility.Constants;

public class ChangeStatusUserStory implements Command {

	UserStory us = null;
	Status state = null;


	public ChangeStatusUserStory(UserStory us, Status state) {
		super();
		this.us = us;
		this.state = state;
	}


	@Override
	public boolean execute() throws IOException {

		Status oldState = us.state;

		us.state = state;

		us.save();
		
		ConnectSlack.sendSlackMessage(us.project.getSlackChannelName(), us.project.getSlackToken(),Constants.EDIT_USERSTORY_STATUS_MESSAGE + us.title + " has been changed by buiscuit");

		System.out.println(ColorCodes.GREEN + "State of user story " + us.title + " has been changed from " + oldState
				+ " to " + us.state + ColorCodes.RED);

		return true;
	}

}
