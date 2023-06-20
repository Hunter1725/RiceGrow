package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "pesticides")
public class Pesticides implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String manufacturer;
    private String composition;
    private String category;
    @ColumnInfo(name = "usage_instructions")
    private String usageInstructions;
    @ColumnInfo(name = "pesticide_per_bottle")
    private double pesticidePerBottle;
    @ColumnInfo(name = "water_per_hectare")
    private double waterPerHectare;
    @ColumnInfo(name = "pesticide_image")
    private String pesticideImage;

    public Pesticides(String name, String manufacturer, String composition, String category, String usageInstructions, double pesticidePerBottle, double waterPerHectare, String pesticideImage) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.composition = composition;
        this.category = category;
        this.usageInstructions = usageInstructions;
        this.pesticidePerBottle = pesticidePerBottle;
        this.waterPerHectare = waterPerHectare;
        this.pesticideImage = pesticideImage;
    }

    @Ignore
    public Pesticides() {
    }

    @Ignore
    protected Pesticides(Parcel in) {
        id = in.readInt();
        name = in.readString();
        manufacturer = in.readString();
        composition = in.readString();
        category = in.readString();
        usageInstructions = in.readString();
        pesticidePerBottle = in.readDouble();
        waterPerHectare = in.readDouble();
        pesticideImage = in.readString();
    }

    @Ignore
    public static final Creator<Pesticides> CREATOR = new Creator<Pesticides>() {
        @Override
        public Pesticides createFromParcel(Parcel in) {
            return new Pesticides(in);
        }

        @Override
        public Pesticides[] newArray(int size) {
            return new Pesticides[size];
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public double getWaterPerHectare() {
        return waterPerHectare;
    }

    public void setWaterPerHectare(double waterPerHectare) {
        this.waterPerHectare = waterPerHectare;
    }

    public double getPesticidePerBottle() {
        return pesticidePerBottle;
    }

    public void setPesticidePerBottle(double pesticidePerBottle) {
        this.pesticidePerBottle = pesticidePerBottle;
    }

    public String getPesticideImage() {
        return pesticideImage;
    }

    public void setPesticideImage(String pesticideImage) {
        this.pesticideImage = pesticideImage;
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
        dest.writeString(manufacturer);
        dest.writeString(composition);
        dest.writeString(category);
        dest.writeString(usageInstructions);
        dest.writeDouble(pesticidePerBottle);
        dest.writeDouble(waterPerHectare);
        dest.writeString(pesticideImage);
    }
}
