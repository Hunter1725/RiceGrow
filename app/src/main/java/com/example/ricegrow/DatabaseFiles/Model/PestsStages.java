package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "pests_stages",
        primaryKeys = {"stage_id", "pest_id"},
        foreignKeys = {@ForeignKey(entity = Pests.class, parentColumns = "id", childColumns = "pest_id"),
                @ForeignKey(entity = Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class PestsStages {
    @ColumnInfo(name = "stage_id")
    private int stageId;
    @ColumnInfo(name = "pest_id")
    private int pestId;

    public PestsStages(int stageId, int pestId) {
        this.stageId = stageId;
        this.pestId = pestId;
    }

    @Ignore
    public PestsStages() {
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public int getPestId() {
        return pestId;
    }

    public void setPestId(int pestId) {
        this.pestId = pestId;
    }
}
