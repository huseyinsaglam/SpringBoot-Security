package com.example.petclinicapp.web;


import com.example.petclinicapp.model.Owner;
import com.example.petclinicapp.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {

    @Autowired
    PetClinicService petClinicService;

    @RequestMapping(value="/owner/{id}",method = RequestMethod.GET)
    public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id) {

        Owner findbyid = petClinicService.findOwner(id);

        // return new ResponseEntity<Owner>(findbyid, HttpStatus.OK);

        return ResponseEntity.ok(findbyid);
    }

    @RequestMapping(value="/owners",method = RequestMethod.GET)
    public ResponseEntity<List <Owner> > getOwners() {

        List <Owner> findOwners = petClinicService.findOwnerss();

        return new ResponseEntity<List <Owner>>(findOwners, HttpStatus.OK);
    }


    @RequestMapping(value="/ownerss",method = RequestMethod.GET)
    public ResponseEntity<List <Owner> > getOwnersBySurname(@RequestParam("surname") String surname) {

        List <Owner> findOwnersSurname = petClinicService.findOwners(surname);

        return new ResponseEntity<List<Owner>>(findOwnersSurname, HttpStatus.OK);

        //return ResponseEntity.ok(findOwners);
    }


    @RequestMapping(value="/ownerpost", method=RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Owner owner)
    {
       // productRepo.put(product.getId(), product);
        petClinicService.createOwner(owner);
        return new ResponseEntity<>("Owner is created successfully",
                HttpStatus.CREATED);
    }


}




