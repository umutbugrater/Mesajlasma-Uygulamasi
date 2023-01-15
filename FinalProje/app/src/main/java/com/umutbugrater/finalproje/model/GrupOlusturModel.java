package com.umutbugrater.finalproje.model;

public class GrupOlusturModel {
    String grupAdi;
    String grupAciklama;

    public GrupOlusturModel() {
    }

    public GrupOlusturModel(String grupAdi, String grupAciklama) {
        this.grupAdi = grupAdi;
        this.grupAciklama = grupAciklama;
    }


    public String getGrupAdi() {
        return grupAdi;
    }

    public void setGrupAdi(String grupAdi) {
        this.grupAdi = grupAdi;
    }

    public String getGrupAciklama() {
        return grupAciklama;
    }

    public void setGrupAciklama(String grupAciklama) {
        this.grupAciklama = grupAciklama;
    }
}
