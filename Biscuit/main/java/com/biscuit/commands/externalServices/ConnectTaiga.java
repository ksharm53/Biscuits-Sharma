package com.biscuit.commands.externalServices;

import java.io.IOException;
import java.util.logging.Logger;
import com.biscuit.ColorCodes;
import com.biscuit.commands.Exceptions.TaigaProjectNotSavedException;
import com.biscuit.commands.taiga.TaigaProjectIfs;
import com.biscuit.commands.taiga.impl.TaigaProjectImpl;
import com.biscuit.models.Project;
import com.biscuit.utility.Constants;

import io.fabric8.taiga.ProjectDTO;
import jline.console.ConsoleReader;

/**
 * @author ksharm53
 *
 */
public class ConnectTaiga {

	Logger logger = Logger.getLogger(ConnectTaiga.class.getName());


	/**
	 * @param project
	 * @param reader
	 * @throws IOException
	 * 
	 * Method to add project to Taiga.
	 */
	public static void addProjectToTaiga (Project project, ConsoleReader reader) throws IOException {

		String line;
		TaigaProjectIfs taigaProject= new TaigaProjectImpl();
		ProjectDTO projectresponse;
		try {
			reader.setPrompt(ColorCodes.BLUE + "Do you want to add this Project to Taiga? [Y] Yes \t [N] No:" + ColorCodes.RESET);

			line = reader.readLine();
			if (line.equalsIgnoreCase("Y")) {
				
				reader.setPrompt(ColorCodes.BLUE + "Please add authorization token: " + ColorCodes.RESET);
				
				String token = reader.readLine();

				projectresponse=taigaProject.addTaigaProject(createDTO(project), token);
				if(null ==projectresponse)
				{
					throw new TaigaProjectNotSavedException("Unable to save project with name : " + project.name);
				}

				reader.println(ColorCodes.GREEN + Constants.ADD_PROJECT_SUCCESS + ColorCodes.RESET);
			}
		}
		catch(TaigaProjectNotSavedException ex)
		{
			reader.println(ColorCodes.RED + Constants.ADD_PROJECT_FAILURE + ColorCodes.RESET);
		}	
	}

	/**
	 * @param project
	 * @return
	 */
	private static ProjectDTO createDTO(Project project) {

		ProjectDTO projectRequest= new ProjectDTO();
		projectRequest.setDescription(project.description);
		projectRequest.setName(project.name);

		return projectRequest;
	}
}
