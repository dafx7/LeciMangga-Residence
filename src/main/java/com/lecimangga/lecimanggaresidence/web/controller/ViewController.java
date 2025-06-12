package com.lecimangga.lecimanggaresidence.web.controller;

import com.lecimangga.lecimanggaresidence.api.controller.KamarController;
import com.lecimangga.lecimanggaresidence.api.model.Csrf;
import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import com.lecimangga.lecimanggaresidence.api.model.Kamar;
import com.lecimangga.lecimanggaresidence.api.model.Pemesanan;
import com.lecimangga.lecimanggaresidence.api.respository.CsrfRepository;
import com.lecimangga.lecimanggaresidence.api.respository.KamarRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controller untuk menangani permintaan halaman web (views).
 */

@Controller
public class ViewController {
    @Autowired
    CsrfRepository csrfRepository;

//  url/hubungi-kami
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

    @Autowired
    KamarRepository kamarRepository;

    @GetMapping("/tipe-kamar")
    public String getFilteredKamar(
            @RequestParam(name = "harga",required = false) String harga,
            @RequestParam(name = "token",required = false) String token,
            @RequestParam(name = "orang", required = false) String orang,
            Model model
    ){
        List<Kamar> listKamar;
        if (harga == null && token == null && orang == null) {
            listKamar = kamarRepository.getKamar();
        } else {
            listKamar = kamarRepository.getFilteredKamar(harga, token, orang);
        }
        model.addAttribute("listKamar", listKamar);
        return "tipe-kamar";
    }

    @GetMapping("/pesan-sekarang")
    public String getPesanSekarang(@RequestParam(required = false) String jenis, Model model) {
        Pemesanan pemesanan = new Pemesanan();
        pemesanan.setJenis(jenis);
        model.addAttribute("form", pemesanan);
        model.addAttribute("jenis", jenis);
        List<Kamar> listKamar = kamarRepository.getKamar();
        int maxPenghuni = 1;
        for (Kamar kamar : listKamar) {
            if (kamar.getJenisKamar().equals(jenis)) {
                maxPenghuni = kamar.getMaxOrang();
                break;
            }
        }
        model.addAttribute("maxPenghuni", maxPenghuni);
        model.addAttribute("listKamar",listKamar);
        return "pesan-sekarang";
    }

    @GetMapping("/dashboard-penghuni")
    public String showDashboard() {return "dashboard-penghuni";}
}