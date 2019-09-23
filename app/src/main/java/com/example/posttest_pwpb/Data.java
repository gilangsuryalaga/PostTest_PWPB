package com.example.posttest_pwpb;

public class Data {
    String tanggal;
    String dataid;
    String datatitle;
    String dataisi;


    public Data(){

    }

    public Data(String tanggal, String dataid, String datatitle, String dataisi) {
        this.tanggal = tanggal;
        this.dataid = dataid;
        this.datatitle = datatitle;
        this.dataisi = dataisi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDataid() {
        return dataid;
    }

    public String getDatatitle() {
        return datatitle;
    }

    public String getDataisi() {
        return dataisi;
    }
}
