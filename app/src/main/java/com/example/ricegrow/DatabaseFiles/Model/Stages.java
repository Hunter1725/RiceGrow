package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Update;

@Entity(tableName = "stages")
public class Stages implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int order;
    private String description;
    @ColumnInfo(name = "stage_image")
    private String stageImage;

    public Stages(String name, int order, String description, String stageImage) {
        this.name = name;
        this.order = order;
        this.description = description;
        this.stageImage = stageImage;
    }

    @Ignore
    public Stages() {
    }

    @Ignore
    protected Stages(Parcel in) {
        id = in.readInt();
        name = in.readString();
        order = in.readInt();
        description = in.readString();
        stageImage = in.readString();
    }

    @Ignore
    public static final Creator<Stages> CREATOR = new Creator<Stages>() {
        @Override
        public Stages createFromParcel(Parcel in) {
            return new Stages(in);
        }

        @Override
        public Stages[] newArray(int size) {
            return new Stages[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStageImage() {
        return stageImage;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setStageImage(String stageImage) {
        this.stageImage = stageImage;
    }


    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }

    @Ignore
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(order);
        dest.writeString(description);
        dest.writeString(stageImage);
    }
}
