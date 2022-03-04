package com.biscuit.commands.taiga;

import org.springframework.http.ResponseEntity;
import com.biscuit.models.ProjectResponse;
import io.fabric8.taiga.ProjectDTO;

public interface TaigaProjectIfs {

	ProjectDTO addTaigaProject(ProjectDTO projectResponse,String token);

	ResponseEntity<ProjectResponse> getbyTaigaProjectSlug(String slug);

}
