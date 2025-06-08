package com.lecimangga.lecimanggaresidence.web.controller;

import com.lecimangga.lecimanggaresidence.api.model.Csrf;
import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import com.lecimangga.lecimanggaresidence.api.respository.CsrfRepository;
import com.lecimangga.lecimanggaresidence.api.respository.HubungiKamiFormRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.Instant;

@Controller
@RequestMapping("/hubungi-kami")
public class HubungiKamiFormWebController {

    private static final Logger log = LogManager.getLogger(HubungiKamiFormWebController.class);
    @Autowired
    HubungiKamiFormRepository form;

    @Autowired
    CsrfRepository csrfRepo;

    @PostMapping("/insert")
    public String insertHubungiKamiForm(@ModelAttribute HubungiKamiForm hubungiKamiForm, @RequestParam("csrfToken") String csrfToken, RedirectAttributes redirectAttributes){
        Csrf csrf = csrfRepo.getCsrfToken(csrfToken);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (csrf != null && csrf.getExpiresAt().after(now)){
            form.insertHubungiKamiForm(hubungiKamiForm);
            csrfRepo.deleteCsrfToken(csrf);
            csrfRepo.deleteExpiredCsrfTokens();
            redirectAttributes.addFlashAttribute("message", true);
        } else {
            redirectAttributes.addFlashAttribute("message", false);
            log.error("Invalid csrf token");
        }
        return "redirect:/hubungi-kami";
    }




}
