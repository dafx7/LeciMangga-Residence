package com.lecimangga.lecimanggaresidence.web.controller;

import com.lecimangga.lecimanggaresidence.api.model.Csrf;
import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import com.lecimangga.lecimanggaresidence.api.respository.CsrfRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;

/**
 * Controller untuk menangani permintaan halaman web (views).
 */

@Controller
public class ViewController {
    @Autowired
    CsrfRepository csrfRepository;

//    url/hubungi-kami
    @GetMapping("/hubungi-kami")
    public String showHubungiKami(Model model, HttpSession session ) {
        String csrfToken = (String) session.getAttribute("_csrf");
        if (csrfToken == null) {
            Csrf csrf = csrfRepository.createCsrfToken();
            csrfToken = csrf.getToken();
            csrfRepository.insertCsrfToken(csrf);
            session.setAttribute("_csrf", csrfToken);
        } else{
            Csrf csrf = csrfRepository.getCsrfToken(csrfToken);
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if (csrf == null || csrf.getExpiresAt().before(now) ) {
                csrf = csrfRepository.createCsrfToken();
                csrfToken = csrf.getToken();
                csrfRepository.insertCsrfToken(csrf);
                session.setAttribute("_csrf", csrfToken);
            }
        }

        model.addAttribute("csrfToken", csrfToken);
        model.addAttribute("hubungiKamiForm", new HubungiKamiForm());
        model.getAttribute("message");
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

    @GetMapping("/dashboard-penghuni")
    public String showDashboard() {return "dashboard-penghuni";}
}
