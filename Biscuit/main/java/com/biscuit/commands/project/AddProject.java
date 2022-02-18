package com.biscuit.commands.project;

import java.io.IOException;
import java.util.Scanner;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.Project;
import com.biscuit.models.Dashboard;

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
		//StringBuilder github = new StringBuilder();
		StringBuilder team_members = new StringBuilder();
		String line,line2;
		String prompt = reader.getPrompt();
		
		project.backlog.project = project;
		
		reader.setPrompt(ColorCodes.BLUE + "project name: " + ColorCodes.RESET);
		project.name = reader.readLine();
		reader.setPrompt(ColorCodes.BLUE + "\ndescription: " + ColorCodes.YELLOW + "\n(\\q to end writing)\n" + ColorCodes.RESET);

		while ((line = reader.readLine()) != null) {
			if (line.equals("\\q")) {
				break;
			}
			description.append(line).append("\n");
			reader.setPrompt("");
		}
		System.out.println(ColorCodes.BLUE +"Do you want to add team members?"+ ColorCodes.RESET);
		System.out.println(ColorCodes.BLUE + "Press 'y' for yes and 'n' for no."+ColorCodes.RESET);
		Scanner scan = new Scanner (System.in);
		char member = scan.next().charAt(0);
		System.out.println(member);
		//System.out.println("How many members are in the team? ");
		//Scanner sc = new Scanner (System.in);
		//int no_of_members = sc.nextInt();
		//System.out.println(no_of_members);
		if (member =='y') {
			
			reader.setPrompt(ColorCodes.GREEN + "\nType names: " + ColorCodes.YELLOW + "\n(\\q to end writing)\n" + ColorCodes.RESET);

			while ((line2 = reader.readLine()) != null) {
				if (line2.equals("\\q")) {
					break;
				}
				team_members.append(line2).append("\n");
				reader.setPrompt("");
			}
		}
		else {
			System.out.println("Okay");
		}
		
		reader.setPrompt(ColorCodes.GREEN + "\ngithub url: " + ColorCodes.RESET);
		
		project.github= reader.readLine();
		
		//while ((line1 = reader.readLine()) != null) {
		//	if (line1.equals("\\q")) {
		//		break;
		//	}
		//	github.append(line1).append("\n");
		//	reader.setPrompt("");
		//}

		project.description = description.toString();
		//project.github= github.toString();
		project.team_members = team_members.toString();

		ConnectSlack connectionSlack = new ConnectSlack();
		connectionSlack.addSlackInformationToProject(project,reader);

		reader.setPrompt(prompt);

		dashboard.addProject(project);

		dashboard.save();
		project.save();

		reader.println();
		reader.println(ColorCodes.GREEN + "Project \"" + project.name + "\" has been added!" + ColorCodes.RESET);
		connectionSlack.sendSlackMessage(project.getSlackChannelName(), project.getSlackToken(),project.toString());
		return false;
	}


}
