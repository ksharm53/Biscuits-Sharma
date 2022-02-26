package com.biscuit.commands.project;

import java.io.IOException;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.Dashboard;
import com.biscuit.models.Project;

import jline.console.ConsoleReader;

public class EditProject implements Command {

	ConsoleReader reader = null;
	Project p = new Project();


	public EditProject(ConsoleReader reader, Project p) {
		super();
		this.reader = reader;
		this.p = p;
	}


	public boolean execute() throws IOException {
		String prompt = reader.getPrompt();
		String oldName;

		oldName = p.name;

		setName();
		setDescription();
		setTeam_Members();
		setGithub();


		try {
			Dashboard.getInstance().renameProject(oldName, p.name);
			Dashboard.getInstance().save();
		} catch (IOException e) {
			System.out.println("project with name \"" + p.name + "\" is already existed!");
			p.name = oldName;
		}

		p.save();
		
		// This will avoid multiple invocation of 
		if(p.getSlackToken().isEmpty() || p.getSlackChannelName().isEmpty()) {
			
			ConnectSlack.addSlackInformationToProject(p,reader);
		}
		
		ConnectSlack.sendSlackMessage(p.getSlackChannelName(), p.getSlackToken(),p.toString());

		reader.setPrompt(prompt);

		return true;
	}


	private void setDescription() throws IOException {
		StringBuilder description = new StringBuilder();
		String line;
		String prompt = ColorCodes.BLUE + "description: " + ColorCodes.YELLOW + "(\\q to end writing) " + ColorCodes.RESET;
		String preload = p.description.replace("\n", "<newline>").replace("!", "<exclamation-mark>");

		reader.resetPromptLine(prompt, preload, 0);
		reader.print("\r");

		while ((line = reader.readLine()) != null) {
			if (line.equals("\\q")) {
				break;
			}
			description.append(line).append("\n");
			reader.setPrompt("");
		}

		p.description = description.toString().replace("<newline>", "\n").replace("<exclamation-mark>", "!");
	}
	
	private void setTeam_Members() throws IOException {
		StringBuilder team_members = new StringBuilder();
		String line2;
		String prompt = ColorCodes.GREEN + "Member Names: " + ColorCodes.YELLOW + "(\\q to end writing) " + ColorCodes.RESET;
		String preload = p.team_members.replace("\n", "<newline>").replace("!", "<exclamation-mark>");

		reader.resetPromptLine(prompt, preload, 0);
		reader.print("\r");

		while ((line2 = reader.readLine()) != null) {
			if (line2.equals("\\q")) {
				break;
			}
			team_members.append(line2).append("\n");
			reader.setPrompt("");
		}

		p.team_members = team_members.toString().replace("<newline>", "\n").replace("<exclamation-mark>", "!");
	}
  
	private void setGithub() throws IOException{
		StringBuilder github = new StringBuilder();
		String line1;
		String prompt = ColorCodes.BLUE + "github url: " + ColorCodes.YELLOW + "(\\q to end writing " + ColorCodes.RESET;
		String preload = p.github.replace("\n", "<newline>").replace("!", "<exclamation-mark>");
		
		reader.resetPromptLine(prompt, preload, 0);
		reader.print("\r");
		
		while ((line1 = reader.readLine()) != null) {
			if (line1.equals("\\q")) {
				break;
			}
			github.append(line1).append("\n");
			reader.setPrompt("");
		}
		
		p.github = github.toString().replace("<newline>", "\n").replace("<exclamation-mark>","!");
		
		}


	private void setName() throws IOException {
		String prompt = ColorCodes.BLUE + "name: " + ColorCodes.RESET;
		String preload = p.name;

		reader.resetPromptLine(prompt, preload, 0);
		reader.print("\r");

		p.name = reader.readLine();
	}


}
