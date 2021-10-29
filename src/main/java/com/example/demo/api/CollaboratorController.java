package com.example.demo.api;

import com.example.demo.model.Collaborator;
import com.example.demo.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/collaborator")
@CrossOrigin(origins = "http://localhost:4200")
public class CollaboratorController {
    @Autowired
    private CollaboratorService collaboratorService;

    @GetMapping
    public List<Collaborator> getAll(){ return collaboratorService.getAll();  }

    @GetMapping("{id}")
    public Collaborator find(@PathVariable("id") Long id){
        return collaboratorService.find(id);
    }

    @PostMapping
    public void add(@RequestBody Collaborator collaborator){
        collaboratorService.add(collaborator);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        collaboratorService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Collaborator collaborator){
        collaboratorService.update(collaborator);
    }


}
