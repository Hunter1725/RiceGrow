package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "crop_diseases",
        primaryKeys = {"crop_id", "disease_id"},
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id"),
                @ForeignKey(entity = Diseases.class, parentColumns = "id", childColumns = "disease_id")})
public class CropDiseases {
    @ColumnInfo(name = "crop_id")
    private int cropId;
    @ColumnInfo(name = "disease_id")
    private int diseaseId;

    public CropDiseases(int cropId, int diseaseId) {
        this.cropId = cropId;
        this.diseaseId = diseaseId;
    }

    @Ignore
    public CropDiseases() {
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }
}
