package com.example.petclinicapp.service.impl;


import com.example.petclinicapp.dao.OwnerRepository;
import com.example.petclinicapp.model.Owner;
import com.example.petclinicapp.service.PetClinicService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetClinicServiceImpl implements PetClinicService {


    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> findOwnerss() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    @Secured(value = { "ROLE_USER", "ROLE_EDITOR" })
    public Owner findOwner(Long id){
        Owner owner = ownerRepository.findById(id);

        return owner;
    }

    @Override
    public void createOwner(Owner owner) {
        ownerRepository.create(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerRepository.update(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.delete(id);
    }

}



