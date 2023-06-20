package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "pests")
public class Pests implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @ColumnInfo(name = "science_name")
    private String scienceName;
    private String lifecycle;
    private String symptoms;
    private String description;
    @ColumnInfo(name = "control_methods")
    private String controlMethods;
    @ColumnInfo(name = "pest_image")
    private String pestImage;

    public Pests(String name, String scienceName, String lifecycle, String symptoms, String description, String controlMethods, String pestImage) {
        this.name = name;
        this.scienceName = scienceName;
        this.lifecycle = lifecycle;
        this.symptoms = symptoms;
        this.description = description;
        this.controlMethods = controlMethods;
        this.pestImage = pestImage;
    }

    @Ignore
    public Pests() {
    }

    @Ignore
    protected Pests(Parcel in) {
        id = in.readInt();
        name = in.readString();
        scienceName = in.readString();
        lifecycle = in.readString();
        symptoms = in.readString();
        description = in.readString();
        controlMethods = in.readString();
        pestImage = in.readString();
    }

    @Ignore
    public static final Creator<Pests> CREATOR = new Creator<Pests>() {
        @Override
        public Pests createFromParcel(Parcel in) {
            return new Pests(in);
        }

        @Override
        public Pests[] newArray(int size) {
            return new Pests[size];
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

    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
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

    public String getControlMethods() {
        return controlMethods;
    }

    public void setControlMethods(String controlMethods) {
        this.controlMethods = controlMethods;
    }

    public String getPestImage() {
        return pestImage;
    }

    public void setPestImage(String pestImage) {
        this.pestImage = pestImage;
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
        dest.writeString(scienceName);
        dest.writeString(lifecycle);
        dest.writeString(symptoms);
        dest.writeString(description);
        dest.writeString(controlMethods);
        dest.writeString(pestImage);
    }
}
