package com.papasmurfie.test3practise2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AvtobusDataModel implements Parcelable {
    private String imeShof;
    private String markaAvtobus;
    private String napravlenie;
    private String chasTrugvane;
    private String status;

    public AvtobusDataModel(String imeShof, String markaAvtobus, String napravlenie, String chasTrugvane, String status) {
        this.imeShof = imeShof;
        this.markaAvtobus = markaAvtobus;
        this.napravlenie = napravlenie;
        this.chasTrugvane = chasTrugvane;
        this.status = status;
    }

    protected AvtobusDataModel(Parcel in) {
        imeShof = in.readString();
        markaAvtobus = in.readString();
        napravlenie = in.readString();
        chasTrugvane = in.readString();
        status = in.readString();
    }

    public static final Creator<AvtobusDataModel> CREATOR = new Creator<AvtobusDataModel>() {
        @Override
        public AvtobusDataModel createFromParcel(Parcel in) {
            return new AvtobusDataModel(in);
        }

        @Override
        public AvtobusDataModel[] newArray(int size) {
            return new AvtobusDataModel[size];
        }
    };

    public String getImeShof() {
        return imeShof;
    }

    public void setImeShof(String imeShof) {
        this.imeShof = imeShof;
    }

    public String getMarkaAvtobus() {
        return markaAvtobus;
    }

    public void setMarkaAvtobus(String markaAvtobus) {
        this.markaAvtobus = markaAvtobus;
    }

    public String getNapravlenie() {
        return napravlenie;
    }

    public void setNapravlenie(String napravlenie) {
        this.napravlenie = napravlenie;
    }

    public String getChasTrugvane() {
        return chasTrugvane;
    }

    public void setChasTrugvane(String chasTrugvane) {
        this.chasTrugvane = chasTrugvane;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(imeShof);
        parcel.writeString(markaAvtobus);
        parcel.writeString(napravlenie);
        parcel.writeString(chasTrugvane);
        parcel.writeString(status);
    }
}
