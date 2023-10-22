package com.hunter.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "activities",
        foreignKeys = {@ForeignKey(entity = Stages.class, parentColumns = "id", childColumns = "stage_id")})
public class Activities implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "stage_id")
    private int stageId;
    private String nameEn;
    private String nameVi;
    private String descriptionEn;
    private String descriptionVi;
    private int duration;
    @ColumnInfo(name = "activity_image")
    private String activityImage;

    public Activities(int stageId, String nameEn, String nameVi, String descriptionEn, String descriptionVi, int duration, String activityImage) {
        this.stageId = stageId;
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.descriptionEn = descriptionEn;
        this.descriptionVi = descriptionVi;
        this.duration = duration;
        this.activityImage = activityImage;
    }

    @Ignore
    public Activities() {
    }

    @Ignore
    protected Activities(Parcel in) {
        id = in.readInt();
        stageId = in.readInt();
        nameEn = in.readString();
        nameVi = in.readString();
        descriptionEn = in.readString();
        descriptionVi = in.readString();
        duration = in.readInt();
        activityImage = in.readString();
    }

    @Ignore
    public static final Creator<Activities> CREATOR = new Creator<Activities>() {
        @Override
        public Activities createFromParcel(Parcel in) {
            return new Activities(in);
        }

        @Override
        public Activities[] newArray(int size) {
            return new Activities[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getActivityImage() {
        return activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getDescriptionVi() {
        return descriptionVi;
    }

    public void setDescriptionVi(String descriptionVi) {
        this.descriptionVi = descriptionVi;
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
        dest.writeInt(stageId);
        dest.writeString(nameEn);
        dest.writeString(nameVi);
        dest.writeString(descriptionEn);
        dest.writeString(descriptionVi);
        dest.writeInt(duration);
        dest.writeString(activityImage);
    }
}
