package com.lecimangga.lecimanggaresidence.web.controller;

import com.lecimangga.lecimanggaresidence.api.model.Pemesanan;
import com.lecimangga.lecimanggaresidence.api.model.Ruangan;
import com.lecimangga.lecimanggaresidence.api.model.Transaksi;
import com.lecimangga.lecimanggaresidence.api.model.User;
import com.lecimangga.lecimanggaresidence.api.respository.PemesananRepository;
import com.lecimangga.lecimanggaresidence.api.respository.RuanganRepository;
import com.lecimangga.lecimanggaresidence.api.respository.TransaksiRepository;
import com.lecimangga.lecimanggaresidence.api.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin-dashboard")
public class AdminDashboardController {

    @Autowired private UserRepository userRepository;
    @Autowired private RuanganRepository ruanganRepository;
    @Autowired private PemesananRepository pemesananRepository;
    @Autowired private TransaksiRepository transaksiRepository;

    @GetMapping("/kelola-penghuni")
    public String showKelolaPenghuni(@RequestParam(name = "search", required = false) String query, Model model) {
        List<User> penghuniList = userRepository.findAllWithSearch(query);
        model.addAttribute("penghuni", penghuniList);
        model.addAttribute("query", query);
        model.addAttribute("newUser", new User());
        model.addAttribute("activePage", "pengelolaanAkun");

        return "admin_dashboard/kelola_penghuni";
    }

    @PostMapping("/tambah-penghuni")
    public String tambahPenghuni(@ModelAttribute("newUser") User user, RedirectAttributes redirectAttributes) {
        userRepository.saveUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Akun baru berhasil ditambahkan!");
        return "redirect:/admin-dashboard/kelola-penghuni";
    }

    @GetMapping("/edit-penghuni/{id}")
    public String showEditPenghuniForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id);
        if (user == null) {
            return "redirect:/admin-dashboard/kelola-penghuni";
        }
        List<Ruangan> ruanganList = ruanganRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("kamarList", ruanganList);

        // FIX: Also set the active page here so the sidebar stays highlighted.
        model.addAttribute("activePage", "pengelolaanAkun");

        return "admin_dashboard/edit_penghuni";
    }

    @PostMapping("/edit-penghuni/{id}")
    public String updatePenghuni(@PathVariable("id") Integer id, @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        user.setId(id);
        userRepository.updateUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Data penghuni berhasil diperbarui!");
        return "redirect:/admin-dashboard/kelola-penghuni";
    }

    @GetMapping("/hapus-penghuni/{id}")
    public String hapusPenghuni(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        userRepository.deleteUserById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Akun berhasil dihapus.");
        return "redirect:/admin-dashboard/kelola-penghuni";
    }

    @GetMapping("/pemesanan-kamar")
    public String showPemesananKamar(Model model) {
        List<Pemesanan> pemesananList = pemesananRepository.findAll();
        model.addAttribute("pemesananList", pemesananList);
        model.addAttribute("activePage", "pemesananKamar"); // Untuk highlight sidebar
        return "admin_dashboard/pemesanan_kamar";
    }

    @GetMapping("/pemesanan/konfirmasi/{id}")
    public String konfirmasiPemesanan(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        pemesananRepository.updateStatus(id, "diterima");
        redirectAttributes.addFlashAttribute("successMessage", "Pemesanan berhasil dikonfirmasi!");
        return "redirect:/admin-dashboard/pemesanan-kamar";
    }

    @GetMapping("/pemesanan/tolak/{id}")
    public String tolakPemesanan(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        pemesananRepository.updateStatus(id, "ditolak");
        redirectAttributes.addFlashAttribute("successMessage", "Pemesanan telah ditolak.");
        return "redirect:/admin-dashboard/pemesanan-kamar";
    }

    @GetMapping("/validasi-pembayaran")
    public String showValidasiPembayaran(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Transaksi> transaksiList = transaksiRepository.findAll(search);
        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("search_query", search);
        model.addAttribute("activePage", "validasiPembayaran");
        return "admin_dashboard/validasi_pembayaran";
    }

    @GetMapping("/pembayaran/konfirmasi/{id}")
    public String konfirmasiPembayaran(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        transaksiRepository.updateStatus(id, "diterima");
        redirectAttributes.addFlashAttribute("successMessage", "Pembayaran berhasil divalidasi!");
        return "redirect:/admin-dashboard/validasi-pembayaran";
    }

    @GetMapping("/pembayaran/tolak/{id}")
    public String tolakPembayaran(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        transaksiRepository.updateStatus(id, "ditolak");
        redirectAttributes.addFlashAttribute("successMessage", "Pembayaran telah ditolak.");
        return "redirect:/admin-dashboard/validasi-pembayaran";
    }

    @GetMapping("/statistik")
    public String statistik(Model model) {
        model.addAttribute("activePage", "statistik");
        return "admin_dashboard/statistik";
    }
}