package com.biscuit.commands.taiga.impl;

import java.io.IOException;
import java.util.logging.Logger;

import com.biscuit.ColorCodes;
import com.biscuit.commands.Command;
import com.biscuit.commands.Exceptions.TaigaProjectNotSavedException;

import io.fabric8.taiga.ProjectDTO;
import jline.console.ConsoleReader;

public class AddTaigaProject implements Command {

	Logger logger = Logger.getLogger(AddTaigaProject.class.getName()); 
	ConsoleReader reader = null;
	ProjectDTO projectRequest = null;

	@Override
	public boolean execute() throws IOException {

		try {
		StringBuilder description= new StringBuilder();
		TaigaProjectImpl taigaProject= new TaigaProjectImpl();
		ProjectDTO response;
		String prompt = reader.getPrompt();
		
		reader.setPrompt(ColorCodes.BLUE + "Taiga Project Name: " + ColorCodes.RESET);
		projectRequest.setName(reader.readLine());
		
		projectRequest.setDescription(setDescription(description));

		reader.setPrompt(prompt);
		
		response=taigaProject.addTaigaProject(projectRequest);
		
		if(null == response) {
			throw new TaigaProjectNotSavedException("Taiga Project with Name: "+ projectRequest.getName() + " is not saved.");
		}
		
		reader.println();
		reader.println(ColorCodes.GREEN + "Taiga Project \"" + projectRequest.getName() + "\" has been added successfully !" + ColorCodes.RESET);
		
		}
		catch(TaigaProjectNotSavedException ex) {
			logger.info(ex.getLocalizedMessage());
		}
		return false;
	}
	
	private String setDescription(StringBuilder description) throws IOException {
		String line;
		reader.setPrompt(ColorCodes.BLUE + "\nTaiga Project description:\n" + ColorCodes.YELLOW + "(\\q to end writing)\n" + ColorCodes.RESET);

		while ((line = reader.readLine()) != null) {
			if (line.equals("\\q")) {
				break;
			}
			description.append(line).append("\n");
			reader.setPrompt("");
		}

		return description.toString();
	}

}
