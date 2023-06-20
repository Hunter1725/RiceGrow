package com.example.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "fertilizers")
public class Fertilizers implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String manufacturer;
    private String composition;
    @ColumnInfo(name = "usage_instructions")
    private String usageInstructions;
    @ColumnInfo(name = "recommended_usage")
    private double recommendedUsage;
    @ColumnInfo(name = "fert_image")
    private String fertImage;

    public Fertilizers(String name, String manufacturer, String composition, String usageInstructions, double recommendedUsage, String fertImage) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.composition = composition;
        this.usageInstructions = usageInstructions;
        this.recommendedUsage = recommendedUsage;
        this.fertImage = fertImage;
    }

    @Ignore
    public Fertilizers() {
    }

    @Ignore
    protected Fertilizers(Parcel in) {
        id = in.readInt();
        name = in.readString();
        manufacturer = in.readString();
        composition = in.readString();
        usageInstructions = in.readString();
        recommendedUsage = in.readDouble();
        fertImage = in.readString();
    }

    @Ignore
    public static final Creator<Fertilizers> CREATOR = new Creator<Fertilizers>() {
        @Override
        public Fertilizers createFromParcel(Parcel in) {
            return new Fertilizers(in);
        }

        @Override
        public Fertilizers[] newArray(int size) {
            return new Fertilizers[size];
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

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public double getRecommendedUsage() {
        return recommendedUsage;
    }

    public void setRecommendedUsage(double recommendedUsage) {
        this.recommendedUsage = recommendedUsage;
    }

    public String getFertImage() {
        return fertImage;
    }

    public void setFertImage(String fertImage) {
        this.fertImage = fertImage;
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
        dest.writeString(usageInstructions);
        dest.writeDouble(recommendedUsage);
        dest.writeString(fertImage);
    }
}
