package com.example.petclinicapp.dao;

import com.example.petclinicapp.model.Owner;

import java.util.List;

public interface OwnerRepository {

    List<Owner> findAll();
    Owner findById(Long id);
    List<Owner> findByLastName(String lastName);
    void create(Owner owner);
    Owner update(Owner owner);
    void delete(Long id);
}
