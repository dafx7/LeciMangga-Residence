package com.lecimangga.lecimanggaresidence.api.controller;


import com.lecimangga.lecimanggaresidence.api.model.Kamar;
import com.lecimangga.lecimanggaresidence.api.model.Pemesanan;
import com.lecimangga.lecimanggaresidence.api.respository.KamarRepository;
import com.lecimangga.lecimanggaresidence.api.respository.PemesananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pesan-kamar")
public class PesanKamarController {

    @Autowired
    PemesananRepository pemesananRepository;
    @Autowired
    private KamarRepository kamarRepository;

    @PostMapping("/submit")
    public String insertPemesananKamar(@ModelAttribute Pemesanan form){
        try{
            form.setStatus("menunggu");
            pemesananRepository.insertFormPemesanan(form);
            System.out.println(form);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/tipe-kamar";
    }
}
