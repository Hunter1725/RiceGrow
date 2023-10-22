package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "diseases_stages",
        primaryKeys = {"stage_id", "disease_id"},
        foreignKeys = {@ForeignKey(entity = Diseases.class, parentColumns = "id", childColumns = "disease_id"),
                @ForeignKey(entity = Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class DiseasesStages {
    @ColumnInfo(name = "stage_id")
    private int stageId;
    @ColumnInfo(name = "disease_id")
    private int diseaseId;

    public DiseasesStages(int stageId, int diseaseId) {
        this.stageId = stageId;
        this.diseaseId = diseaseId;
    }

    @Ignore
    public DiseasesStages() {
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }
}
