package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "crop_deftox",
        primaryKeys = {"crop_id", "deftox_id"},
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id"),
                        @ForeignKey(entity = DeficienciesToxicities.class, parentColumns = "id", childColumns = "deftox_id")})
public class CropDeftox {
    @ColumnInfo(name = "crop_id")
    private int cropId;

    @ColumnInfo(name = "deftox_id")
    private int deftoxId;

    public CropDeftox(int cropId, int deftoxId) {
        this.cropId = cropId;
        this.deftoxId = deftoxId;
    }

    @Ignore
    public CropDeftox() {
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getDeftoxId() {
        return deftoxId;
    }

    public void setDeftoxId(int deftoxId) {
        this.deftoxId = deftoxId;
    }
}
