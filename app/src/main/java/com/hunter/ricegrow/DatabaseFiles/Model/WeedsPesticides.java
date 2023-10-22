package com.hunter.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "weeds_pesticides",
        primaryKeys = {"pesticide_id", "weed_id"},
        foreignKeys = {@ForeignKey(entity = Weeds.class, parentColumns = "id", childColumns = "weed_id"),
                @ForeignKey(entity = Pesticides.class, parentColumns = "id", childColumns = "pesticide_id")})
public class WeedsPesticides {
    @ColumnInfo(name = "pesticide_id")
    private int pesticideId;
    @ColumnInfo(name = "weed_id")
    private int weedId;

    public WeedsPesticides(int pesticideId, int weedId) {
        this.pesticideId = pesticideId;
        this.weedId = weedId;
    }

    @Ignore
    public WeedsPesticides() {
    }

    public int getPesticideId() {
        return pesticideId;
    }

    public void setPesticideId(int pesticideId) {
        this.pesticideId = pesticideId;
    }

    public int getWeedId() {
        return weedId;
    }

    public void setWeedId(int weedId) {
        this.weedId = weedId;
    }
}
