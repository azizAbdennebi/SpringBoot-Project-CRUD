package ensit.dep.info.projects.api.projectPackage;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
@RequestMapping(path="projectApi")
public class ProjectController {

    final private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //final private ProjectRepository projectRepository;

   /* public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/getProjects")
    public List<Project> GetProject() {
        return List.of(
                new Project((long) 1.0F, "application mobile", LocalDate.of(2022, 04, 20),
                        LocalDate.of(2022, 04, 27),
                        (long) 1, 20.0F, Type.PFA2)
                , new Project()
        );
    }
/*
    @GetMapping("/getProjectsFromDB")
    public List<Project> GetProjectsFromDB() {
        return this.projectRepository.findAll();
    }*/

    //@PostMapping (value= )

    @DeleteMapping(value = "/deleteProject/{id}")
    public String deleteProject(@PathVariable long id){
        if (!projectService.deleteProject(id)){
            return "Project not found";
        }
        return "Project deleted successfullyyy !";
    }

  //  @PutMapping("/updateProject/{id}")
  @RequestMapping(value = "/updateProject/{id}",consumes = "application/json", method=RequestMethod.PUT)
    public String updateProject(@RequestBody Project proj, @PathVariable long id) {
        Project orig = projectService.getProject(id);
        if (orig != null){
            // Merging new and old
            if (proj.getDate_begining()==null) proj.setDate_begining(orig.getDate_begining());
            if (proj.getDate_finishing()==null) proj.setDate_finishing(orig.getDate_finishing());
            if (proj.getProjectType()==null) proj.setProjectType(orig.getProjectType());
            if (proj.getDes()==null) proj.setDes(orig.getDes());
            if (proj.getGroupeNumber()==null) proj.setGroupeNumber(orig.getGroupeNumber());
            if (proj.getNote_evaluation()==null) proj.setNote_evaluation(orig.getNote_evaluation());

            projectService.updateProject(id,proj);
            return "Project updated successfullyyy !";
        }

        return "Project not found";
    }


    @GetMapping("/getProjectsFromDB")
    public List<Project> GetProjectsFromDB() {
        return projectService.findProjects();
    }
}
