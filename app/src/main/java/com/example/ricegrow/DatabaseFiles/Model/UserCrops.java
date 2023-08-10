package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.ricegrow.DatabaseFiles.Converter.DateConverter;
import com.example.ricegrow.DatabaseFiles.Converter.IntegerListConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "user_crops",
        foreignKeys = {@ForeignKey(entity = Users.class, parentColumns = "id", childColumns = "user_id", onDelete = ForeignKey.CASCADE),
                        @ForeignKey(entity =  Crops.class, parentColumns = "id", childColumns = "crop_id")})
@TypeConverters({DateConverter.class, IntegerListConverter.class})
public class UserCrops implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_id")
    private String userId;
    @ColumnInfo(name = "crop_id")
    private int cropId;
    private String name;
    private int color;
    @ColumnInfo(name = "sowing_amount")
    private double sowingAmount;
    @ColumnInfo(name = "sowing_date")
    private LocalDate sowingDate;
    @ColumnInfo(name = "sowed_area")
    private double sowedArea;
    @ColumnInfo(name = "expected_harvest_date")
    private LocalDate expectedHarvestDate;
    @ColumnInfo(name = "growth_period")
    private int growthPeriod;
    @ColumnInfo(name = "plan_stages")
    private List<Integer> planStages;



    @Ignore
    public UserCrops(String userId, int cropId, String name, int color, double sowingAmount, LocalDate sowingDate, double sowedArea, LocalDate expectedHarvestDate, int growthPeriod) {
        this.userId = userId;
        this.cropId = cropId;
        this.name = name;
        this.color = color;
        this.sowingAmount = sowingAmount;
        this.sowingDate = sowingDate;
        this.sowedArea = sowedArea;
        this.expectedHarvestDate = expectedHarvestDate;
        this.growthPeriod = growthPeriod;
    }

    public UserCrops(int cropId, String name, int color, double sowingAmount, LocalDate sowingDate, double sowedArea, LocalDate expectedHarvestDate, int growthPeriod, List<Integer> planStages) {
        this.cropId = cropId;
        this.name = name;
        this.color = color;
        this.sowingAmount = sowingAmount;
        this.sowingDate = sowingDate;
        this.sowedArea = sowedArea;
        this.expectedHarvestDate = expectedHarvestDate;
        this.growthPeriod = growthPeriod;
        this.planStages = planStages;
    }

    @Ignore
    public UserCrops() {
    }

    @Ignore
    protected UserCrops(Parcel in) {
        id = in.readInt();
        userId = in.readString();
        cropId = in.readInt();
        name = in.readString();
        color = in.readInt();
        sowingAmount = in.readDouble();
        sowedArea = in.readDouble();
        growthPeriod = in.readInt();
        sowingDate = LocalDate.parse(in.readString()); // Convert String back to LocalDate
        expectedHarvestDate = LocalDate.parse(in.readString()); // Convert String back to LocalDate
        planStages = new ArrayList<>();
        in.readList(planStages, Integer.class.getClassLoader());
    }


    @Ignore
    public static final Creator<UserCrops> CREATOR = new Creator<UserCrops>() {
        @Override
        public UserCrops createFromParcel(Parcel in) {
            return new UserCrops(in);
        }

        @Override
        public UserCrops[] newArray(int size) {
            return new UserCrops[size];
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public double getSowingAmount() {
        return sowingAmount;
    }

    public void setSowingAmount(double sowingAmount) {
        this.sowingAmount = sowingAmount;
    }

    public LocalDate getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(LocalDate sowingDate) {
        this.sowingDate = sowingDate;
    }

    public double getSowedArea() {
        return sowedArea;
    }

    public void setSowedArea(double sowedArea) {
        this.sowedArea = sowedArea;
    }

    public LocalDate getExpectedHarvestDate() {
        return expectedHarvestDate;
    }

    public void setExpectedHarvestDate(LocalDate expectedHarvestDate) {
        this.expectedHarvestDate = expectedHarvestDate;
    }

    public int getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(int growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    public List<Integer> getPlanStages() {
        return planStages;
    }

    public void setPlanStages(List<Integer> planStages) {
        this.planStages = planStages;
    }

    @Override
    public String toString() {
        return "UserCrops{" +
                "id=" + id +
                ", user_id=" + userId +
                ", crop_id=" + cropId +
                ", planting_volume=" + sowingAmount +
                ", planted_area=" + sowedArea +
                '}';
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
        dest.writeString(userId);
        dest.writeInt(cropId);
        dest.writeString(name);
        dest.writeInt(color);
        dest.writeDouble(sowingAmount);
        dest.writeDouble(sowedArea);
        dest.writeInt(growthPeriod);
        dest.writeString(sowingDate.toString()); // Convert LocalDate to String
        dest.writeString(expectedHarvestDate.toString()); // Convert LocalDate to String
        dest.writeList(planStages);
    }
}
