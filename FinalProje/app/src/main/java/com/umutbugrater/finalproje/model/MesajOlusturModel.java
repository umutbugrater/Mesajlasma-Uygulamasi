package com.umutbugrater.finalproje.model;

public class MesajOlusturModel {
    String baslik;
    String aciklama;

    public MesajOlusturModel() {
    }

    public MesajOlusturModel(String baslik, String aciklama) {
        this.baslik = baslik;
        this.aciklama = aciklama;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
