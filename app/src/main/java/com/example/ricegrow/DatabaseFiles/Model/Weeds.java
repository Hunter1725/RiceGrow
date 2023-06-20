package com.example.ricegrow.DatabaseFiles.Model;

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
    private String name;
    @ColumnInfo(name = "geographical_distribution")
    private String geographicalDistribution;
    private String morphology;
    private String ecology;
    private String impact;
    @ColumnInfo(name = "control_methods")
    private String controlMethods;
    private String weed_image;

    public Weeds(String name, String geographicalDistribution, String morphology, String ecology, String impact, String controlMethods, String weed_image) {
        this.name = name;
        this.geographicalDistribution = geographicalDistribution;
        this.morphology = morphology;
        this.ecology = ecology;
        this.impact = impact;
        this.controlMethods = controlMethods;
        this.weed_image = weed_image;
    }

    @Ignore
    public Weeds() {
    }

    @Ignore
    protected Weeds(Parcel in) {
        id = in.readInt();
        name = in.readString();
        geographicalDistribution = in.readString();
        morphology = in.readString();
        ecology = in.readString();
        impact = in.readString();
        controlMethods = in.readString();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeographicalDistribution() {
        return geographicalDistribution;
    }

    public void setGeographicalDistribution(String geographicalDistribution) {
        this.geographicalDistribution = geographicalDistribution;
    }

    public String getMorphology() {
        return morphology;
    }

    public void setMorphology(String morphology) {
        this.morphology = morphology;
    }

    public String getEcology() {
        return ecology;
    }

    public void setEcology(String ecology) {
        this.ecology = ecology;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getControlMethods() {
        return controlMethods;
    }

    public void setControlMethods(String controlMethods) {
        this.controlMethods = controlMethods;
    }

    public String getWeed_image() {
        return weed_image;
    }

    public void setWeed_image(String weed_image) {
        this.weed_image = weed_image;
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
        dest.writeString(geographicalDistribution);
        dest.writeString(morphology);
        dest.writeString(ecology);
        dest.writeString(impact);
        dest.writeString(controlMethods);
        dest.writeString(weed_image);
    }
}
