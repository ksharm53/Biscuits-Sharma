package com.biscuit.commands.project;

import java.io.IOException;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.Dashboard;
import com.biscuit.models.Project;

import jline.console.ConsoleReader;

public class AddProject implements Command {

	Dashboard dashboard = Dashboard.getInstance();
	Project project = new Project();
	ConsoleReader reader = null;


	public AddProject(ConsoleReader reader) {
		super();
		this.reader = reader;
	}


	public boolean execute() throws IOException {

		StringBuilder description = new StringBuilder();
		StringBuilder team_members = new StringBuilder();
		String line,line2,line1;
		boolean yes = false;
		String prompt = reader.getPrompt();

		project.backlog.project = project;

		reader.setPrompt(ColorCodes.BLUE + "project name: " + ColorCodes.RESET);
		project.name = reader.readLine();
		reader.setPrompt(ColorCodes.BLUE + "\ndescription: " + ColorCodes.YELLOW + "\n(\\q to end writing)\n" + ColorCodes.RESET);

		while ((line = reader.readLine()) != null) {
			if (line.contains("\\q")) {
				break;
			}
			description.append(line).append("\n");
			reader.setPrompt("");
		}

		reader.setPrompt(ColorCodes.BLUE + " Do you want to add team members" + "? [Y/n] " + ColorCodes.RESET);
		line1 = reader.readLine();

		yes = (line1.toLowerCase().equals("y"));

		if (yes) {

			reader.setPrompt(ColorCodes.GREEN + "\nType names: " + ColorCodes.YELLOW + "\n(\\q to end writing)\n" + ColorCodes.RESET);

			while ((line2 = reader.readLine()) != null) {
				if (line2.contains("\\q")) {
					break;
				}
				team_members.append(line2).append("\n");
				reader.setPrompt("");
				reader.setPrompt("Please add the role for "+line2+ ": ");
				role= reader.readLine();
				team_members.append(role);
				break;
			}

		}
		else {
			System.out.println("Okay");
		}

		reader.setPrompt(ColorCodes.GREEN + "\ngithub url: " + ColorCodes.RESET);

		project.github= reader.readLine();

		project.description = description.toString();
		project.team_members = team_members.toString();

		ConnectSlack.addSlackInformationToProject(project,reader);

		reader.setPrompt(prompt);

		dashboard.addProject(project);

		dashboard.save();
		project.save();

		reader.println();
		reader.println(ColorCodes.GREEN + "Project \"" + project.name + "\" has been added!" + ColorCodes.RESET);
		ConnectSlack.sendSlackMessage(project.getSlackChannelName(), project.getSlackToken(),project.toString());
		return false;
	}


}
