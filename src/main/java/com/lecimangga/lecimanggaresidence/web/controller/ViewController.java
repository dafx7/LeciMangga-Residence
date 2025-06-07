package com.lecimangga.lecimanggaresidence.web.controller;

import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller untuk menangani permintaan halaman web (views).
 */

@Controller
public class ViewController {

//    url/hubungi-kami
    @GetMapping("/hubungi-kami")
    public String showHubungiKami(Model model) {
        model.addAttribute("hubungiKamiForm", new HubungiKamiForm());
        return "hubungi-kami";
    }


    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/lokasi")
    public String showLokasi() {
        return "lokasi";
    }
}
