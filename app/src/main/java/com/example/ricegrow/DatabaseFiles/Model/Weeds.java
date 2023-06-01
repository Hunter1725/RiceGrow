package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "weeds")
public class Weeds {
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
}
