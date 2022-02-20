package com.biscuit.commands.task;

import java.io.IOException;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.Task;
import com.biscuit.models.enums.Status;

public class ChangeStatusTask implements Command {

	Task t = null;
	Status state = null;


	public ChangeStatusTask(Task t, Status state) {
		super();
		this.t = t;
		this.state = state;
	}


	@Override
	public boolean execute() throws IOException {

		Status oldState = t.state;

		t.state = state;

		t.save();

		System.out.println(ColorCodes.GREEN + "State of task " + t.title + " has been changed from " + oldState + " to "
				+ t.state + ColorCodes.RED);
		String messageSentOnSlack = "State of task " + t.title;
		messageSentOnSlack+= "\n" + "Has been changed from " + oldState + " to " + t.state;
		ConnectSlack.sendSlackMessage(t.project.getSlackChannelName(), t.project.getSlackToken(), messageSentOnSlack);

		return true;
	}

}
