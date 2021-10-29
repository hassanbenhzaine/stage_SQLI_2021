package com.example.demo.service;

import com.example.demo.dao.CollaboratorRepository;
import com.example.demo.dao.HrManagerRepository;
import com.example.demo.dao.SkillRepository;
import com.example.demo.model.Collaborator;
import com.example.demo.model.HrManager;
import com.example.demo.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CollaboratorService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private HrManagerRepository hrManagerRepository;

    @Autowired
    private SkillRepository skillRepository;

    public List<Collaborator> getAll(){
        return collaboratorRepository.findAll();
    }

    public Collaborator find(Long id){
        return collaboratorRepository.findById(id).orElseThrow(() -> new IllegalStateException("user dosen't exist!"));
    }

    public void add(Collaborator collaborator){

        Optional<HrManager> hrManager = hrManagerRepository.findById(collaborator.getHrManagerId());
        if(!hrManager.isPresent()){
            throw new IllegalStateException("hrManager with id " + collaborator.getHrManagerId() + "dosen't exist!");
        }

//        List<Skill> skills = skillRepository.findAllByIds(collaborator.getSkillsIds());

        collaborator.setHrManager(hrManager.get());

        collaboratorRepository.save(collaborator);

    }

    public void delete(Long id){
        if(!collaboratorRepository.existsById(id)){
            throw new IllegalStateException("collaborator with id " + id + " dosen't exist!");
        }

        collaboratorRepository.deleteById(id);
    }


    @Transactional
    public void update(Collaborator collaborator) {
        Collaborator collaboratorToUpdate = collaboratorRepository.findById(collaborator.getId()).orElseThrow(() -> new IllegalStateException("student with id " + collaborator.getId() + " not found!"));

        Optional<HrManager> hrManager = hrManagerRepository.findById(collaborator.getHrManagerId());
        if(!hrManager.isPresent()){
            throw new IllegalStateException("hrManager with id " + collaborator.getHrManagerId() + "dosen't exist!");
        }

        collaboratorToUpdate.setAppPosition(collaborator.getAppPosition());
        collaboratorToUpdate.setSalary(collaborator.getSalary());
        collaboratorToUpdate.setOldHrManager(collaboratorToUpdate.getHrManager());
        collaboratorToUpdate.setHrManager(hrManager.get());

        collaboratorRepository.save(collaboratorToUpdate);
    }
}
