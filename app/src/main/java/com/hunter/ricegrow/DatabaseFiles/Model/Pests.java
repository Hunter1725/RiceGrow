package com.hunter.ricegrow.DatabaseFiles.Model;

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
    private String nameEn;
    private String nameVi;
    @ColumnInfo(name = "science_name")
    private String scienceNameEn;
    private String scienceNameVi;
    private String lifecycleEn;
    private String lifecycleVi;
    private String symptomsEn;
    private String symptomsVi;
    private String descriptionEn;
    private String descriptionVi;
    @ColumnInfo(name = "control_methods")
    private String controlMethodsEn;
    private String controlMethodsVi;
    @ColumnInfo(name = "pest_image")
    private String pestImage;

    public Pests(String nameEn, String nameVi, String scienceNameEn, String scienceNameVi, String lifecycleEn, String lifecycleVi, String symptomsEn, String symptomsVi, String descriptionEn, String descriptionVi, String controlMethodsEn, String controlMethodsVi, String pestImage) {
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.scienceNameEn = scienceNameEn;
        this.scienceNameVi = scienceNameVi;
        this.lifecycleEn = lifecycleEn;
        this.lifecycleVi = lifecycleVi;
        this.symptomsEn = symptomsEn;
        this.symptomsVi = symptomsVi;
        this.descriptionEn = descriptionEn;
        this.descriptionVi = descriptionVi;
        this.controlMethodsEn = controlMethodsEn;
        this.controlMethodsVi = controlMethodsVi;
        this.pestImage = pestImage;
    }

    @Ignore
    public Pests() {
    }

    @Ignore
    protected Pests(Parcel in) {
        id = in.readInt();
        nameEn = in.readString();
        nameVi = in.readString();
        scienceNameEn = in.readString();
        scienceNameVi = in.readString();
        lifecycleEn = in.readString();
        lifecycleVi = in.readString();
        symptomsEn = in.readString();
        symptomsVi = in.readString();
        descriptionEn = in.readString();
        descriptionVi = in.readString();
        controlMethodsEn = in.readString();
        controlMethodsVi = in.readString();
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

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getScienceNameEn() {
        return scienceNameEn;
    }

    public void setScienceNameEn(String scienceNameEn) {
        this.scienceNameEn = scienceNameEn;
    }

    public String getLifecycleEn() {
        return lifecycleEn;
    }

    public void setLifecycleEn(String lifecycleEn) {
        this.lifecycleEn = lifecycleEn;
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

    public String getControlMethodsEn() {
        return controlMethodsEn;
    }

    public void setControlMethodsEn(String controlMethodsEn) {
        this.controlMethodsEn = controlMethodsEn;
    }

    public String getPestImage() {
        return pestImage;
    }

    public void setPestImage(String pestImage) {
        this.pestImage = pestImage;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getLifecycleVi() {
        return lifecycleVi;
    }

    public void setLifecycleVi(String lifecycleVi) {
        this.lifecycleVi = lifecycleVi;
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

    public String getControlMethodsVi() {
        return controlMethodsVi;
    }

    public void setControlMethodsVi(String controlMethodsVi) {
        this.controlMethodsVi = controlMethodsVi;
    }

    public String getScienceNameVi() {
        return scienceNameVi;
    }

    public void setScienceNameVi(String scienceNameVi) {
        this.scienceNameVi = scienceNameVi;
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
        dest.writeString(scienceNameEn);
        dest.writeString(scienceNameVi);
        dest.writeString(lifecycleEn);
        dest.writeString(lifecycleVi);
        dest.writeString(symptomsEn);
        dest.writeString(symptomsVi);
        dest.writeString(descriptionEn);
        dest.writeString(descriptionVi);
        dest.writeString(controlMethodsEn);
        dest.writeString(controlMethodsVi);
        dest.writeString(pestImage);
    }
}
