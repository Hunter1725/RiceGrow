package com.hunter.ricegrow.DatabaseFiles.Model;

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
    private String manufacturerEn;
    private String manufacturerVi;
    private String compositionEn;
    private String compositionVi;
    @ColumnInfo(name = "usage_instructions")
    private String usageInstructionsEn;
    private String usageInstructionsVi;
    @ColumnInfo(name = "recommended_usage")
    private double recommendedUsage;
    @ColumnInfo(name = "fert_image")
    private String fertImage;

    public Fertilizers(String name, String manufacturerEn, String manufacturerVi, String compositionEn, String compositionVi, String usageInstructionsEn, String usageInstructionsVi, double recommendedUsage, String fertImage) {
        this.name = name;
        this.manufacturerEn = manufacturerEn;
        this.manufacturerVi = manufacturerVi;
        this.compositionEn = compositionEn;
        this.compositionVi = compositionVi;
        this.usageInstructionsEn = usageInstructionsEn;
        this.usageInstructionsVi = usageInstructionsVi;
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
        manufacturerEn = in.readString();
        manufacturerVi = in.readString();
        compositionEn = in.readString();
        compositionVi = in.readString();
        usageInstructionsEn = in.readString();
        usageInstructionsVi = in.readString();
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

    public String getManufacturerEn() {
        return manufacturerEn;
    }

    public void setManufacturerEn(String manufacturerEn) {
        this.manufacturerEn = manufacturerEn;
    }

    public String getCompositionEn() {
        return compositionEn;
    }

    public void setCompositionEn(String compositionEn) {
        this.compositionEn = compositionEn;
    }

    public String getUsageInstructionsEn() {
        return usageInstructionsEn;
    }

    public void setUsageInstructionsEn(String usageInstructionsEn) {
        this.usageInstructionsEn = usageInstructionsEn;
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

    public String getManufacturerVi() {
        return manufacturerVi;
    }

    public void setManufacturerVi(String manufacturerVi) {
        this.manufacturerVi = manufacturerVi;
    }

    public String getCompositionVi() {
        return compositionVi;
    }

    public void setCompositionVi(String compositionVi) {
        this.compositionVi = compositionVi;
    }

    public String getUsageInstructionsVi() {
        return usageInstructionsVi;
    }

    public void setUsageInstructionsVi(String usageInstructionsVi) {
        this.usageInstructionsVi = usageInstructionsVi;
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
        dest.writeString(manufacturerEn);
        dest.writeString(manufacturerVi);
        dest.writeString(compositionEn);
        dest.writeString(compositionVi);
        dest.writeString(usageInstructionsEn);
        dest.writeString(usageInstructionsVi);
        dest.writeDouble(recommendedUsage);
        dest.writeString(fertImage);
    }
}
