package com.lecimangga.lecimanggaresidence.api.model;

import java.math.BigDecimal;
import java.util.Map;

public class StatistikData {
    private int totalPenghuniAktif;
    private int totalPenghuniBaru;
    private int totalPenghuniKeluar;
    private ChartData pemesananKamar;
    private ChartData pembayaran;
    private ChartData metodePembayaran;
    private Map<String, BigDecimal> pendapatan;

    public static class ChartData {
        private int val1;
        private int val2;

        public ChartData(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public int getVal1() {
            return val1;
        }

        public int getVal2() {
            return val2;
        }
    }

    public Map<String, BigDecimal> getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(Map<String, BigDecimal> pendapatan) {
        this.pendapatan = pendapatan;
    }

    public ChartData getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(ChartData metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public ChartData getPemesananKamar() {
        return pemesananKamar;
    }

    public void setPemesananKamar(ChartData pemesananKamar) {
        this.pemesananKamar = pemesananKamar;
    }

    public int getTotalPenghuniKeluar() {
        return totalPenghuniKeluar;
    }

    public void setTotalPenghuniKeluar(int totalPenghuniKeluar) {
        this.totalPenghuniKeluar = totalPenghuniKeluar;
    }

    public int getTotalPenghuniBaru() {
        return totalPenghuniBaru;
    }

    public void setTotalPenghuniBaru(int totalPenghuniBaru) {
        this.totalPenghuniBaru = totalPenghuniBaru;
    }

    public int getTotalPenghuniAktif() {
        return totalPenghuniAktif;
    }

    public void setTotalPenghuniAktif(int totalPenghuniAktif) {
        this.totalPenghuniAktif = totalPenghuniAktif;
    }

    public ChartData getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(ChartData pembayaran) {
        this.pembayaran = pembayaran;
    }
}
