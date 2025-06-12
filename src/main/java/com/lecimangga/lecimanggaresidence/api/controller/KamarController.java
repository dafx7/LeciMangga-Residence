package com.lecimangga.lecimanggaresidence.api.controller;


import com.lecimangga.lecimanggaresidence.api.model.Kamar;
import com.lecimangga.lecimanggaresidence.api.respository.KamarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kamar")
public class KamarController {

    @Autowired
    KamarRepository kamarRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public List<Kamar> getAll(){
        return kamarRepository.getKamar();
    }

    @GetMapping("/tipe-kamar")
    public List<Kamar> getFilteredKamar(
            @RequestParam(name = "harga",required = false) String harga,
            @RequestParam(name = "token",required = false) String token,
            @RequestParam(name = "orang", required = false) String orang
    ){
        if (harga == null && token == null && orang == null) {
            return kamarRepository.getKamar();
        } else {
            return kamarRepository.getFilteredKamar(harga, token, orang);
        }
    }

}
