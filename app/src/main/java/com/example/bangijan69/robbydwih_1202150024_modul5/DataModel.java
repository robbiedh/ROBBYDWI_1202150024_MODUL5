package com.example.bangijan69.robbydwih_1202150024_modul5;

/**
 * Created by bangijan69 on 3/25/2018.
 */

public class DataModel {
    String Todo;
    String Deskripsi;
    String pioriy;
    DataModel(String Todo,String Deskripsi,String pioriy){
        this.Todo=Todo;
        this.Deskripsi=Deskripsi;
        this.pioriy=pioriy;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public String getPioriy() {
        return pioriy;
    }

    public String getTodo() {
        return Todo;
    }


}
