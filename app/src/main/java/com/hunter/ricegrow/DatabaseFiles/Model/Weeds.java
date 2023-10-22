package com.hunter.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "weeds")
public class Weeds implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nameEn;
    private String nameVi;
    @ColumnInfo(name = "geographical_distribution")
    private String geographicalDistributionEn;
    private String geographicalDistributionVi;
    private String morphologyEn;
    private String morphologyVi;
    private String ecologyEn;
    private String ecologyVi;
    private String impactEn;
    private String impactVi;
    @ColumnInfo(name = "control_methods")
    private String controlMethodsEn;
    private String controlMethodsVi;
    private String weed_image;

    public Weeds(String nameEn, String nameVi, String geographicalDistributionEn, String geographicalDistributionVi, String morphologyEn, String morphologyVi, String ecologyEn, String ecologyVi, String impactEn, String impactVi, String controlMethodsEn, String controlMethodsVi, String weed_image) {
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.geographicalDistributionEn = geographicalDistributionEn;
        this.geographicalDistributionVi = geographicalDistributionVi;
        this.morphologyEn = morphologyEn;
        this.morphologyVi = morphologyVi;
        this.ecologyEn = ecologyEn;
        this.ecologyVi = ecologyVi;
        this.impactEn = impactEn;
        this.impactVi = impactVi;
        this.controlMethodsEn = controlMethodsEn;
        this.controlMethodsVi = controlMethodsVi;
        this.weed_image = weed_image;
    }

    @Ignore
    public Weeds() {
    }

    @Ignore
    protected Weeds(Parcel in) {
        id = in.readInt();
        nameEn = in.readString();
        nameVi = in.readString();
        geographicalDistributionEn = in.readString();
        geographicalDistributionVi = in.readString();
        morphologyEn = in.readString();
        morphologyVi = in.readString();
        ecologyEn = in.readString();
        ecologyVi = in.readString();
        impactEn = in.readString();
        impactVi = in.readString();
        controlMethodsEn = in.readString();
        controlMethodsVi = in.readString();
        weed_image = in.readString();
    }

    @Ignore
    public static final Creator<Weeds> CREATOR = new Creator<Weeds>() {
        @Override
        public Weeds createFromParcel(Parcel in) {
            return new Weeds(in);
        }

        @Override
        public Weeds[] newArray(int size) {
            return new Weeds[size];
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

    public String getGeographicalDistributionEn() {
        return geographicalDistributionEn;
    }

    public void setGeographicalDistributionEn(String geographicalDistributionEn) {
        this.geographicalDistributionEn = geographicalDistributionEn;
    }

    public String getMorphologyEn() {
        return morphologyEn;
    }

    public void setMorphologyEn(String morphologyEn) {
        this.morphologyEn = morphologyEn;
    }

    public String getEcologyEn() {
        return ecologyEn;
    }

    public void setEcologyEn(String ecologyEn) {
        this.ecologyEn = ecologyEn;
    }

    public String getImpactEn() {
        return impactEn;
    }

    public void setImpactEn(String impactEn) {
        this.impactEn = impactEn;
    }

    public String getControlMethodsEn() {
        return controlMethodsEn;
    }

    public void setControlMethodsEn(String controlMethodsEn) {
        this.controlMethodsEn = controlMethodsEn;
    }

    public String getWeed_image() {
        return weed_image;
    }

    public void setWeed_image(String weed_image) {
        this.weed_image = weed_image;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getGeographicalDistributionVi() {
        return geographicalDistributionVi;
    }

    public void setGeographicalDistributionVi(String geographicalDistributionVi) {
        this.geographicalDistributionVi = geographicalDistributionVi;
    }

    public String getMorphologyVi() {
        return morphologyVi;
    }

    public void setMorphologyVi(String morphologyVi) {
        this.morphologyVi = morphologyVi;
    }

    public String getEcologyVi() {
        return ecologyVi;
    }

    public void setEcologyVi(String ecologyVi) {
        this.ecologyVi = ecologyVi;
    }

    public String getImpactVi() {
        return impactVi;
    }

    public void setImpactVi(String impactVi) {
        this.impactVi = impactVi;
    }

    public String getControlMethodsVi() {
        return controlMethodsVi;
    }

    public void setControlMethodsVi(String controlMethodsVi) {
        this.controlMethodsVi = controlMethodsVi;
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
        dest.writeString(geographicalDistributionEn);
        dest.writeString(geographicalDistributionVi);
        dest.writeString(morphologyEn);
        dest.writeString(morphologyVi);
        dest.writeString(ecologyEn);
        dest.writeString(ecologyVi);
        dest.writeString(impactEn);
        dest.writeString(impactVi);
        dest.writeString(controlMethodsEn);
        dest.writeString(controlMethodsVi);
        dest.writeString(weed_image);
    }
}
