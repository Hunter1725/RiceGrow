package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "crop_pests",
        primaryKeys = {"crop_id", "pest_id"},
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id"),
                @ForeignKey(entity = Pests.class, parentColumns = "id", childColumns = "pest_id")})
public class CropPests {
    @ColumnInfo(name = "crop_id")
    private int cropId;
    @ColumnInfo(name = "pest_id")
    private int pestId;

    public CropPests(int cropId, int pestId) {
        this.cropId = cropId;
        this.pestId = pestId;
    }

    @Ignore
    public CropPests() {
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getPestId() {
        return pestId;
    }

    public void setPestId(int pestId) {
        this.pestId = pestId;
    }
}
