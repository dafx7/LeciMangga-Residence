package com.lecimangga.lecimanggaresidence.api.controller;

import com.lecimangga.lecimanggaresidence.api.model.HubungiKamiForm;
import com.lecimangga.lecimanggaresidence.api.respository.HubungiKamiFormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hubungiform")
public class HubungiKamiFormController {

    private static final Logger log = LoggerFactory.getLogger(HubungiKamiFormController.class);
    @Autowired
    HubungiKamiFormRepository hubungiKamiFormRepository;

    @PostMapping()
    public void insertHubungiKami(@ModelAttribute HubungiKamiForm form) {
        try{
            hubungiKamiFormRepository.insertHubungiKamiForm(form);
            log.info("HubungiKamiForm inserted successfully");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    @GetMapping()
    public List<HubungiKamiForm> getHubungiKamiForm() {
        try{
            List<HubungiKamiForm> result = hubungiKamiFormRepository.getHubungiKamiForm();
            log.info("HubungiKamiForm get succesfully");
            return result;
        } catch (Exception e) {
            log.warn(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteHubungiKamiForm(@PathVariable int id) {
        try{
            HubungiKamiForm find = hubungiKamiFormRepository.getHubungiKamiFormById(id);
            hubungiKamiFormRepository.deleteHubungiKamiForm(find);
            log.info("HubungiKamiForm " + find.toString() + " deleted successfully");
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }



}
