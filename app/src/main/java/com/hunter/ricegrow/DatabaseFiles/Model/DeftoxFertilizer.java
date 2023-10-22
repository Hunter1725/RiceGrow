package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "deftox_fertilizer",
        primaryKeys = {"deftox_id", "fertilizer_id"},
        foreignKeys = {@ForeignKey(entity = DeficienciesToxicities.class, parentColumns = "id", childColumns = "deftox_id"),
                @ForeignKey(entity = Fertilizers.class, parentColumns = "id", childColumns = "fertilizer_id")})
public class DeftoxFertilizer {
    @ColumnInfo(name = "deftox_id")
    private int deftoxId;
    @ColumnInfo(name = "fertilizer_id")
    private int fertilizerId;

    public DeftoxFertilizer(int deftoxId, int fertilizerId) {
        this.deftoxId = deftoxId;
        this.fertilizerId = fertilizerId;
    }

    @Ignore
    public DeftoxFertilizer() {
    }

    public int getDeftoxId() {
        return deftoxId;
    }

    public void setDeftoxId(int deftoxId) {
        this.deftoxId = deftoxId;
    }

    public int getFertilizerId() {
        return fertilizerId;
    }

    public void setFertilizerId(int fertilizerId) {
        this.fertilizerId = fertilizerId;
    }
}
