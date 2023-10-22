package com.hunter.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "crops")
public class Crops implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String descriptionEn;
    private String descriptionVi;
    @ColumnInfo(name = "growth_period")
    private int growthPeriod;
    @ColumnInfo(name = "selling_price")
    private double sellingPrice;
    @ColumnInfo(name = "salt_tolerance")
    private double saltTolerance;
    @ColumnInfo(name = "crop_image")
    private String cropImage;

    public Crops(String name, String descriptionEn, String descriptionVi, int growthPeriod, double sellingPrice, double saltTolerance, String cropImage) {
        this.name = name;
        this.descriptionEn = descriptionEn;
        this.descriptionVi = descriptionVi;
        this.growthPeriod = growthPeriod;
        this.sellingPrice = sellingPrice;
        this.saltTolerance = saltTolerance;
        this.cropImage = cropImage;
    }

    @Ignore
    public Crops() {
    }

    @Ignore
    protected Crops(Parcel in) {
        id = in.readInt();
        name = in.readString();
        descriptionEn = in.readString();
        descriptionVi = in.readString();
        growthPeriod = in.readInt();
        sellingPrice = in.readDouble();
        saltTolerance = in.readDouble();
        cropImage = in.readString();
    }

    @Ignore
    public static final Creator<Crops> CREATOR = new Creator<Crops>() {
        @Override
        public Crops createFromParcel(Parcel in) {
            return new Crops(in);
        }

        @Override
        public Crops[] newArray(int size) {
            return new Crops[size];
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

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionVi() {
        return descriptionVi;
    }

    public void setDescriptionVi(String descriptionVi) {
        this.descriptionVi = descriptionVi;
    }

    public int getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(int growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getSaltTolerance() {
        return saltTolerance;
    }

    public void setSaltTolerance(double saltTolerance) {
        this.saltTolerance = saltTolerance;
    }

    public String getCropImage() {
        return cropImage;
    }

    public void setCropImage(String cropImage) {
        this.cropImage = cropImage;
    }

    @Override
    public String toString() {
        return "Crops{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + descriptionEn + '\'' +
                ", growth_period=" + growthPeriod +
                ", selling_price=" + sellingPrice +
                ", optimal_temperature=" + saltTolerance +
                ", crop_image='" + cropImage + '\'' +
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
        dest.writeString(name);
        dest.writeString(descriptionEn);
        dest.writeString(descriptionVi);
        dest.writeInt(growthPeriod);
        dest.writeDouble(sellingPrice);
        dest.writeDouble(saltTolerance);
        dest.writeString(cropImage);
    }
}
