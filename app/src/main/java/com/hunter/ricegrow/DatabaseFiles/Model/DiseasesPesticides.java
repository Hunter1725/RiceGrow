package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "diseases_pesticides",
        primaryKeys = {"pesticide_id", "disease_id"},
        foreignKeys = {@ForeignKey(entity = Diseases.class, parentColumns = "id", childColumns = "disease_id"),
                @ForeignKey(entity = Pesticides.class, parentColumns = "id", childColumns = "pesticide_id")})
public class DiseasesPesticides {
    @ColumnInfo(name = "pesticide_id")
    private int pesticideId;
    @ColumnInfo(name = "disease_id")
    private int diseaseId;

    public DiseasesPesticides(int pesticideId, int diseaseId) {
        this.pesticideId = pesticideId;
        this.diseaseId = diseaseId;
    }

    @Ignore
    public DiseasesPesticides() {
    }

    public int getPesticideId() {
        return pesticideId;
    }

    public void setPesticideId(int pesticideId) {
        this.pesticideId = pesticideId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }
}
