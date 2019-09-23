package com.example.posttest_pwpb;

public class Data {
    String dataid;
    String datatitle;
    String dataisi;


    public Data(){

    }

    public Data(String dataid,String datatitle, String dataisi) {
        this.dataid= dataid;
        this.datatitle = datatitle;
        this.dataisi = dataisi;

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
