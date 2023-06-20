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

@Entity(tableName = "stages",
        foreignKeys = {@ForeignKey(entity = Crops.class, parentColumns = "id", childColumns = "crop_id")})
public class Stages implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "crop_id")
    private int cropId;
    private String name;
    private String description;
    private int duration;
    private int order;
    private boolean state;
    @ColumnInfo(name = "start_date")
    private String startDate;
    @ColumnInfo(name = "end_date")
    private String endDate;
    @ColumnInfo(name = "stage_image")
    private String stageImage;

    public Stages(int cropId, String name, String description, int duration, int order, boolean state, String startDate, String endDate, String stageImage) {
        this.cropId = cropId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.order = order;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stageImage = stageImage;
    }

    @Ignore
    public Stages() {
    }

    @Ignore
    protected Stages(Parcel in) {
        id = in.readInt();
        cropId = in.readInt();
        name = in.readString();
        description = in.readString();
        duration = in.readInt();
        order = in.readInt();
        state = in.readByte() != 0;
        startDate = in.readString();
        endDate = in.readString();
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

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getOrder() {
        return order;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStageImage() {
        return stageImage;
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
        dest.writeInt(cropId);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(duration);
        dest.writeInt(order);
        dest.writeByte((byte) (state ? 1 : 0));
        dest.writeString(startDate);
        dest.writeString(endDate);
        dest.writeString(stageImage);
    }
}
