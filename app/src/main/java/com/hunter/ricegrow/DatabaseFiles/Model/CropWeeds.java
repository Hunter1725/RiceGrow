package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "crop_weeds",
        primaryKeys = {"crop_id", "weed_id"},
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id"),
                @ForeignKey(entity = Weeds.class, parentColumns = "id", childColumns = "weed_id")})
public class CropWeeds {
    @ColumnInfo(name = "crop_id")
    private int cropId;
    @ColumnInfo(name = "weed_id")
    private int weedId;

    public CropWeeds(int cropId, int weedId) {
        this.cropId = cropId;
        this.weedId = weedId;
    }

    @Ignore
    public CropWeeds() {
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getWeedId() {
        return weedId;
    }

    public void setWeedId(int weedId) {
        this.weedId = weedId;
    }
}
