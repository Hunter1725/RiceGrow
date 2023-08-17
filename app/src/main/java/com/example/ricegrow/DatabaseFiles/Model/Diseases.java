package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "diseases")
public class Diseases implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nameEn;
    private String nameVi;
    private String symptomsEn;
    private String symptomsVi;
    private String descriptionEn;
    private String descriptionVi;
    @ColumnInfo(name = "prevention_methods")
    private String preventionMethodsEn;
    private String preventionMethodsVi;
    @ColumnInfo(name = "disease_image")
    private String diseaseImage;

    public Diseases(String nameEn, String nameVi, String symptomsEn, String symptomsVi, String descriptionEn, String descriptionVi, String preventionMethodsEn, String preventionMethodsVi, String diseaseImage) {
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.symptomsEn = symptomsEn;
        this.symptomsVi = symptomsVi;
        this.descriptionEn = descriptionEn;
        this.descriptionVi = descriptionVi;
        this.preventionMethodsEn = preventionMethodsEn;
        this.preventionMethodsVi = preventionMethodsVi;
        this.diseaseImage = diseaseImage;
    }

    @Ignore
    public Diseases() {
    }

    @Ignore
    protected Diseases(Parcel in) {
        id = in.readInt();
        nameEn = in.readString();
        nameVi = in.readString();
        symptomsEn = in.readString();
        symptomsVi = in.readString();
        descriptionEn = in.readString();
        descriptionVi = in.readString();
        preventionMethodsEn = in.readString();
        preventionMethodsVi = in.readString();
        diseaseImage = in.readString();
    }

    @Ignore
    public static final Creator<Diseases> CREATOR = new Creator<Diseases>() {
        @Override
        public Diseases createFromParcel(Parcel in) {
            return new Diseases(in);
        }

        @Override
        public Diseases[] newArray(int size) {
            return new Diseases[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getSymptomsEn() {
        return symptomsEn;
    }

    public void setSymptomsEn(String symptomsEn) {
        this.symptomsEn = symptomsEn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getPreventionMethodsEn() {
        return preventionMethodsEn;
    }

    public void setPreventionMethodsEn(String preventionMethodsEn) {
        this.preventionMethodsEn = preventionMethodsEn;
    }

    public String getDiseaseImage() {
        return diseaseImage;
    }

    public void setDiseaseImage(String diseaseImage) {
        this.diseaseImage = diseaseImage;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getSymptomsVi() {
        return symptomsVi;
    }

    public void setSymptomsVi(String symptomsVi) {
        this.symptomsVi = symptomsVi;
    }

    public String getDescriptionVi() {
        return descriptionVi;
    }

    public void setDescriptionVi(String descriptionVi) {
        this.descriptionVi = descriptionVi;
    }

    public String getPreventionMethodsVi() {
        return preventionMethodsVi;
    }

    public void setPreventionMethodsVi(String preventionMethodsVi) {
        this.preventionMethodsVi = preventionMethodsVi;
    }

    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }

    @Ignore
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nameEn);
        dest.writeString(nameVi);
        dest.writeString(symptomsEn);
        dest.writeString(symptomsVi);
        dest.writeString(descriptionEn);
        dest.writeString(descriptionVi);
        dest.writeString(preventionMethodsEn);
        dest.writeString(preventionMethodsVi);
        dest.writeString(diseaseImage);
    }
}
