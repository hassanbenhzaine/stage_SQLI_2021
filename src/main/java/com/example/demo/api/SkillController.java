package com.example.demo.api;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> getAll(){
        return skillService.getAll();
    }

    @GetMapping("{id}")
    public Skill find(@PathVariable("id") Long id){
        return skillService.find(id);
    }

    @PostMapping
    public void add(@RequestBody Skill skill){
        skillService.add(skill);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        skillService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Skill Skill){
        skillService.update(Skill);
    }

}
