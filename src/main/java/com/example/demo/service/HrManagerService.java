package com.example.demo.service;

import com.example.demo.dao.HrManagerRepository;
import com.example.demo.model.HrManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HrManagerService {

    @Autowired
    private HrManagerRepository hrManagerRepository;

    public List<HrManager> getAll(){return hrManagerRepository.findAll();}

    public List<HrManager> findAllByStatus(Boolean bool){
        return hrManagerRepository.findAllByStatus(bool);
    }

    public HrManager find(Long id){
        return hrManagerRepository.findById(id).orElseThrow(() -> new IllegalStateException("user dosen't exist!"));
    }

    public void add(HrManager hrManager){

        hrManagerRepository.save(hrManager);

    }

    public void delete(Long id){
        if(!hrManagerRepository.existsById(id)){
            throw new IllegalStateException("hr manager with id " + id + " dosen't exist!");
        }
        hrManagerRepository.deleteById(id);
    }

    @Transactional
    public void update(HrManager hrManager) {
        HrManager updatedHrManager = hrManagerRepository.findById(hrManager.getId()).orElseThrow(() -> new IllegalStateException("student with id " + hrManager.getId() + " not found!"));

        updatedHrManager.setStatus(hrManager.getStatus());
        updatedHrManager.setFirstName(hrManager.getFirstName());
        updatedHrManager.setLastName(hrManager.getLastName());

        hrManagerRepository.save(updatedHrManager);
    }

}
