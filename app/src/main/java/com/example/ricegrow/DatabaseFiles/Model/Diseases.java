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
    private String name;
    private String symptoms;
    private String description;
    @ColumnInfo(name = "prevention_methods")
    private String preventionMethods;
    @ColumnInfo(name = "disease_image")
    private String diseaseImage;

    public Diseases(String name, String symptoms, String description, String preventionMethods, String diseaseImage) {
        this.name = name;
        this.symptoms = symptoms;
        this.description = description;
        this.preventionMethods = preventionMethods;
        this.diseaseImage = diseaseImage;
    }

    @Ignore
    public Diseases() {
    }

    @Ignore
    protected Diseases(Parcel in) {
        id = in.readInt();
        name = in.readString();
        symptoms = in.readString();
        description = in.readString();
        preventionMethods = in.readString();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreventionMethods() {
        return preventionMethods;
    }

    public void setPreventionMethods(String preventionMethods) {
        this.preventionMethods = preventionMethods;
    }

    public String getDiseaseImage() {
        return diseaseImage;
    }

    public void setDiseaseImage(String diseaseImage) {
        this.diseaseImage = diseaseImage;
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
        dest.writeString(name);
        dest.writeString(symptoms);
        dest.writeString(description);
        dest.writeString(preventionMethods);
        dest.writeString(diseaseImage);
    }
}
