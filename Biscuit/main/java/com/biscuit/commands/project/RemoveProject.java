package com.biscuit.commands.project;

import java.io.IOException;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.Dashboard;
import com.biscuit.models.Project;

import jline.console.ConsoleReader;

public class RemoveProject implements Command {

	Dashboard dashboard = Dashboard.getInstance();
	Project project;
	ConsoleReader reader = null;


	public RemoveProject(ConsoleReader reader, Project project) {
		super();
		this.reader = reader;
		this.project = project;
	}


	public boolean execute() throws IOException {

		String line;
		boolean yes = false;
		String prompt = reader.getPrompt();
		reader.setPrompt(ColorCodes.BLUE + "Are you sure you want to remove " + project.name + "? [Y/n] " + ColorCodes.RESET);
		line = reader.readLine();

		if (!isValid_YN(line)) {
			System.out.println("Removing is cancelled!");
			reader.setPrompt(prompt);
			return true;
		}

		yes = (line.toLowerCase().equals("y"));

		if (!yes) {
			System.out.println("Removing is cancelled!");
			reader.setPrompt(prompt);
			return true;
		}

		// only remove project form dash board
		dashboard.removeProject(project);
		dashboard.save();

		reader.println();
		reader.println(ColorCodes.GREEN + "Project \"" + project.name + "\" has been removed!" + ColorCodes.RESET);

		reader.setPrompt(ColorCodes.BLUE + "Do you want to delete files related to " + project.name + "? [Y/n] " + ColorCodes.RESET);
		line = reader.readLine();

		if (!isValid_YN(line)) {
			System.out.println("deleting is cancelled!");
			reader.setPrompt(prompt);
			return true;
		}

		yes = (line.toLowerCase().equalsIgnoreCase("y"));

		if (yes) {
			// delete project files
			project.delete();
			project = null;

			reader.setPrompt(prompt);
			return true;
		}


		// This will avoid multiple invocation of
		if(project.getSlackToken().isEmpty() ||
				project.getSlackChannelName().isEmpty()) {

			ConnectSlack.addSlackInformationToProject(project,reader); 
		}


		reader.setPrompt(prompt);

		ConnectSlack.sendSlackMessage(project.getSlackChannelName(), project.getSlackToken(),project.toString());

		return true;
	}


	private boolean isValid_YN(String line) {
		return line.length() == 1 && (line.toLowerCase().equals("y") || line.toLowerCase().equals("n"));
	}

}
