package com.example.demo.api;

import com.example.demo.model.HrManager;
import com.example.demo.service.HrManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/hrmanager")
@CrossOrigin(origins = "http://localhost:4200")
public class HrManagerController {
    @Autowired
    private HrManagerService hrManagerService;

    @GetMapping
    public List<HrManager> getAll(){
        return hrManagerService.getAll();
    }

    @GetMapping("status/{bool}")
    public List<HrManager> findAllByStatus(@PathVariable("bool") Boolean bool){
        return hrManagerService.findAllByStatus(bool);
    }

    @GetMapping("id/{id}")
    public HrManager find(@PathVariable("id") Long id){
        return hrManagerService.find(id);
    }

    @PostMapping
    public void add(@RequestBody HrManager hrManager){
        hrManagerService.add(hrManager);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        hrManagerService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody HrManager hrManager){
        hrManagerService.update(hrManager);
    }
}
