package com.lecimangga.lecimanggaresidence.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller untuk menangani permintaan halaman web (views).
 */

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

}
