package com.lecimangga.lecimanggaresidence.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

//    url/hubungi-kami
    @GetMapping("/hubungi-kami")
    public String showHubungiKami() {
        return "hubungi-kami";
    }


    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/tipe-kamar")
    public String showTipeKamar() {return "tipe-kamar";}

}
