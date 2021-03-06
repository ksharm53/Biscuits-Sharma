package com.biscuit.commands.task;

import java.io.IOException;
import java.util.Date;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.externalServices.ConnectSlack;
import com.biscuit.models.Project;
import com.biscuit.models.Task;
import com.biscuit.models.UserStory;
import com.biscuit.models.enums.Status;

import jline.console.ConsoleReader;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.Completer;
import jline.console.completer.NullCompleter;
import jline.console.completer.StringsCompleter;

public class AddTaskToUserStory implements Command {

	ConsoleReader reader = null;
	Project project = null;
	UserStory userStory = null;
	Task task = new Task();


	public AddTaskToUserStory(ConsoleReader reader, Project project, UserStory userStory) {
		super();
		this.reader = reader;
		this.project = project;
		this.userStory = userStory;
	}


	public boolean execute() throws IOException {
		StringBuilder description = new StringBuilder();
		String prompt = reader.getPrompt();

		task.project = project;
		setTitle();
		setDescription(description);
		task.state = Status.OPEN;
		setTime();
		
		// changes to add happiness index to a task
		setHappiness();
		setBusinessValue();
		task.initiatedDate = new Date();
		task.plannedDate = new Date(0);
		task.dueDate = new Date(0);

		reader.setPrompt(prompt);

		userStory.tasks.add(task);
		project.save();

		reader.println();
		reader.println(ColorCodes.GREEN + "Task \"" + task.title + "\" has been added!" + ColorCodes.RESET);
		String messageSentOnSlack = "Task created for " + userStory.title;
		messageSentOnSlack+= "\n" + "Task title: " + task.title;
 		messageSentOnSlack+= "\n" + "Description: " + task.description;
		ConnectSlack.sendSlackMessage(project.getSlackChannelName(), project.getSlackToken(), messageSentOnSlack);

		return false;
	}


	/**
	 * Method to add happiness index to a task
	 * @throws IOException 
	 */
	private void setHappiness() throws IOException {
		String line;
		Completer oldCompleter = (Completer) reader.getCompleters().toArray()[0];

		Completer happinessCompleter = new ArgumentCompleter(new StringsCompleter("sad", "mad", "confused", "happy"), new NullCompleter());

		reader.removeCompleter(oldCompleter);
		reader.addCompleter(happinessCompleter);

		reader.setPrompt(ColorCodes.BLUE + "\nhappiness value:\n" + ColorCodes.YELLOW + "(hit Tab to see an example)\n" + ColorCodes.RESET);

		while ((line = reader.readLine()) != null) {
			line = line.trim();

			try {
				task.happinessIndex = String.valueOf(line);
				break;
			} catch (NumberFormatException e) {
				System.out.println(ColorCodes.RED + "invalid value: must be a text value!" + ColorCodes.RESET);
			}
		}

		reader.removeCompleter(happinessCompleter);
		reader.addCompleter(oldCompleter);	
		
	}
	private void setBusinessValue() throws IOException{
		String busVal;
		Completer oldCompleter = (Completer) reader.getCompleters().toArray()[0];
		Completer taskCompleter = new ArgumentCompleter (new  StringsCompleter("X-Small", "Small","Medium","Large","X-Large","XX-Large"), new NullCompleter());
		reader.removeCompleter(oldCompleter);
		reader.addCompleter(taskCompleter);
		reader.setPrompt(ColorCodes.BLUE+"\nbusiness value for the task:\n"+ColorCodes.YELLOW+"(hit tab to see the values)\n"+ColorCodes.RESET);
		
		while((busVal=reader.readLine())!=null) {
			busVal = busVal.trim().toUpperCase();
			break;
		}
		//reader.removeCompleter(taskCompleter);
		//reader.addCompleter(oldCompleter);
		
		
	}


	private void setTime() throws IOException {
		String line;
		Completer oldCompleter = (Completer) reader.getCompleters().toArray()[0];

		Completer timeCompleter = new ArgumentCompleter(new StringsCompleter("1", "1.5", "2", "2.25", "3"), new NullCompleter());

		reader.removeCompleter(oldCompleter);
		reader.addCompleter(timeCompleter);

		reader.setPrompt(ColorCodes.BLUE + "\nestimated time (in hours):\n" + ColorCodes.YELLOW + "(hit Tab to see an example)\n" + ColorCodes.RESET);

		while ((line = reader.readLine()) != null) {
			line = line.trim();

			try {
				task.estimatedTime = Float.valueOf(line);
				break;
			} catch (NumberFormatException e) {
				System.out.println(ColorCodes.RED + "invalid value: must be a float value!" + ColorCodes.RESET);
			}
		}

		reader.removeCompleter(timeCompleter);
		reader.addCompleter(oldCompleter);
	}


	private void setDescription(StringBuilder description) throws IOException {
		String line;
		reader.setPrompt(ColorCodes.BLUE + "\ndescription:\n" + ColorCodes.YELLOW + "(\\q to end writing)\n" + ColorCodes.RESET);

		while ((line = reader.readLine()) != null) {
			if (line.equals("\\q")) {
				break;
			}
			description.append(line).append("\n");
			reader.setPrompt("");
		}

		task.description = description.toString();
	}


	private void setTitle() throws IOException {
		reader.setPrompt(ColorCodes.BLUE + "title: " + ColorCodes.RESET);
		task.title = reader.readLine();
	}

}
