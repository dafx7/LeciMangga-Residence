package com.lecimangga.lecimanggaresidence.web.controller;

import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import com.lecimangga.lecimanggaresidence.api.respository.HubungiKamiFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hubungi-kami")
public class HubungiKamiFormWebController {

    @Autowired
    HubungiKamiFormRepository form;

    @PostMapping("/insert")
    public String insertHubungiKamiForm(@ModelAttribute HubungiKamiForm hubungiKamiForm) {
        form.insertHubungiKamiForm(hubungiKamiForm);
        return "redirect:/hubungi-kami";
    }




}
