package com.lecimangga.lecimanggaresidence.api.controller;

import com.lecimangga.lecimanggaresidence.api.model.StatistikData;
import com.lecimangga.lecimanggaresidence.api.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatistikApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/statistik")
    public StatistikData getStatistik() {
        StatistikData data = new StatistikData();

        // Data Dummy
        data.setTotalPenghuniAktif(userRepository.countAktif());
        data.setTotalPenghuniBaru(5);
        data.setTotalPenghuniKeluar(2);

        data.setPemesananKamar(new StatistikData.ChartData(18, 17));
        data.setPembayaran(new StatistikData.ChartData(30, 4));
        data.setMetodePembayaran(new StatistikData.ChartData(25, 9));

        Map<String, BigDecimal> pendapatanMap = new HashMap<>();
        pendapatanMap.put("Januari", new BigDecimal(1500000));
        pendapatanMap.put("Februari", new BigDecimal(1900000));
        pendapatanMap.put("Maret", new BigDecimal(1100000));
        pendapatanMap.put("April", new BigDecimal(1400000));
        pendapatanMap.put("Mei", new BigDecimal(2000000));
        data.setPendapatan(pendapatanMap);

        return data;
    }
}
