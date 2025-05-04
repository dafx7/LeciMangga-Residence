package com.lecimangga.lecimanggaresidence.api.controller;


import com.lecimangga.lecimanggaresidence.api.model.Kamar;
import com.lecimangga.lecimanggaresidence.api.respository.KamarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kamar")
public class KamarController {

    @Autowired
    KamarRepository kamarRepository;

    @CrossOrigin(origins = "http://localhost:51118")
    @GetMapping
    public List<Kamar> getAll(){
        return kamarRepository.getKamar();
    }

}
