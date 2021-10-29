package com.example.demo.service;

import com.example.demo.dao.SkillRepository;
import com.example.demo.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAll(){

        return skillRepository.findAll();
    }

    public Skill find(Long id){
        return skillRepository.findById(id).orElseThrow(() -> new IllegalStateException("user dosen't exist!"));
    }

    public void add(Skill skill){
        skillRepository.save(skill);
    }

    public void delete(Long id){
        if(!skillRepository.existsById(id)){
            throw new IllegalStateException("hr manager with id " + id + " dosen't exist!");
        }
        skillRepository.deleteById(id);
    }

    @Transactional
    public void update(Skill skill) {
        skillRepository.save(skill);
    }
}
