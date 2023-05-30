package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

@Entity(tableName = "pest_pesticides",
        primaryKeys = {"pesticide_id", "pest_id"},
        foreignKeys = {@ForeignKey(entity = Pests.class, parentColumns = "id", childColumns = "pest_id"),
                @ForeignKey(entity = Pesticides.class, parentColumns = "id", childColumns = "pesticide_id")})
public class PestsPesticides {
    @ColumnInfo(name = "pesticide_id")
    private int pesticideId;
    @ColumnInfo(name = "pest_id")
    private int pestId;

    public PestsPesticides(int pesticideId, int pestId) {
        this.pesticideId = pesticideId;
        this.pestId = pestId;
    }

    @Ignore
    public PestsPesticides() {
    }

    public int getPesticideId() {
        return pesticideId;
    }

    public void setPesticideId(int pesticideId) {
        this.pesticideId = pesticideId;
    }

    public int getPestId() {
        return pestId;
    }

    public void setPestId(int pestId) {
        this.pestId = pestId;
    }
}
