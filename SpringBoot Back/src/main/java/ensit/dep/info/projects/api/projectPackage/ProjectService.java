package ensit.dep.info.projects.api.projectPackage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    final private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public  boolean deleteProject(long id){
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateProject(long id,Project proj) {
        proj.setId(id);
        projectRepository.save(proj);
        return true;
    }

    public Project getProject(long id){
        if (projectRepository.existsById(id)){
            return projectRepository.getById(id);
        }
        return null;
    }

    public List<Project> findProjects()
    {
        return this.projectRepository.findAll();
    }
}
