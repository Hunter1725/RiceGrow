package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "deficiencies_toxicities")
public class DeficienciesToxicities implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String symptoms;
    private String description;
    @ColumnInfo(name = "prevention_methods")
    private String preventionMethods;
    @ColumnInfo(name = "deftox_image")
    private String deftoxImage;

    public DeficienciesToxicities(String name, String symptoms, String description, String preventionMethods, String deftoxImage) {
        this.name = name;
        this.symptoms = symptoms;
        this.description = description;
        this.preventionMethods = preventionMethods;
        this.deftoxImage = deftoxImage;
    }

    @Ignore
    public DeficienciesToxicities() {
    }

    @Ignore
    protected DeficienciesToxicities(Parcel in) {
        id = in.readInt();
        name = in.readString();
        symptoms = in.readString();
        description = in.readString();
        preventionMethods = in.readString();
        deftoxImage = in.readString();
    }

    @Ignore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(symptoms);
        dest.writeString(description);
        dest.writeString(preventionMethods);
        dest.writeString(deftoxImage);
    }

    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }

    @Ignore
    public static final Creator<DeficienciesToxicities> CREATOR = new Creator<DeficienciesToxicities>() {
        @Override
        public DeficienciesToxicities createFromParcel(Parcel in) {
            return new DeficienciesToxicities(in);
        }

        @Override
        public DeficienciesToxicities[] newArray(int size) {
            return new DeficienciesToxicities[size];
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

    public String getDeftoxImage() {
        return deftoxImage;
    }

    public void setDeftoxImage(String deftoxImage) {
        this.deftoxImage = deftoxImage;
    }
}
