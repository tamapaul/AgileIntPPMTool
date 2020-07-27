package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID " + project.getProjectIdentifier() + " already exists.");
		}
	}
	
	public Project findByProjectIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);
		if(project == null) {
			throw new ProjectIdException("Project ID " + projectId + " does not exist.");
		}
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);
		if(project == null) {
			throw new ProjectIdException("Cannot delete Project with ID " + projectId + " as it does not exist.");
		}
		projectRepository.delete(project);
	}
}
