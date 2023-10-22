package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "deftox_stage",
        primaryKeys = {"deftox_id", "stage_id"},
        foreignKeys = {@ForeignKey(entity = DeficienciesToxicities.class, parentColumns = "id", childColumns = "deftox_id"),
                @ForeignKey(entity = Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class DeftoxStage {
    @ColumnInfo(name = "deftox_id")
    private int deftoxId;
    @ColumnInfo(name = "stage_id")
    private int stageId;

    public DeftoxStage(int deftoxId, int stageId) {
        this.deftoxId = deftoxId;
        this.stageId = stageId;
    }

    @Ignore
    public DeftoxStage() {
    }

    public int getDeftoxId() {
        return deftoxId;
    }

    public void setDeftoxId(int deftoxId) {
        this.deftoxId = deftoxId;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }
}
