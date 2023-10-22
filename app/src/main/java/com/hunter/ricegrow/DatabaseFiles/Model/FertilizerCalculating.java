package com.hunter.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "fertilizer_calculating")
public class FertilizerCalculating implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "n_ratio")
    private int NRatio;
    @ColumnInfo(name = "p_ratio")
    private int PRatio;
    @ColumnInfo(name = "k_ratio")
    private int KRatio;
    private String unit;
    private double area;
    @ColumnInfo(name = "urea_amount")
    private int ureaAmount;
    @ColumnInfo(name = "mop_amount")
    private int mopAmount;
    @ColumnInfo(name = "dap_amount")
    private int dapAmount;

    public FertilizerCalculating(int NRatio, int PRatio, int KRatio, String unit, double area, int ureaAmount, int mopAmount, int dapAmount) {
        this.NRatio = NRatio;
        this.PRatio = PRatio;
        this.KRatio = KRatio;
        this.unit = unit;
        this.area = area;
        this.ureaAmount = ureaAmount;
        this.mopAmount = mopAmount;
        this.dapAmount = dapAmount;
    }

    @Ignore
    public FertilizerCalculating() {
    }


    @Ignore
    protected FertilizerCalculating(Parcel in) {
        id = in.readInt();
        NRatio = in.readInt();
        PRatio = in.readInt();
        KRatio = in.readInt();
        unit = in.readString();
        area = in.readDouble();
        ureaAmount = in.readInt();
        mopAmount = in.readInt();
        dapAmount = in.readInt();
    }

    @Ignore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(NRatio);
        dest.writeInt(PRatio);
        dest.writeInt(KRatio);
        dest.writeString(unit);
        dest.writeDouble(area);
        dest.writeInt(ureaAmount);
        dest.writeInt(mopAmount);
        dest.writeInt(dapAmount);
    }

    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }

    @Ignore
    public static final Creator<FertilizerCalculating> CREATOR = new Creator<FertilizerCalculating>() {
        @Override
        public FertilizerCalculating createFromParcel(Parcel in) {
            return new FertilizerCalculating(in);
        }

        @Override
        public FertilizerCalculating[] newArray(int size) {
            return new FertilizerCalculating[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNRatio() {
        return NRatio;
    }

    public void setNRatio(int NRatio) {
        this.NRatio = NRatio;
    }

    public int getPRatio() {
        return PRatio;
    }

    public void setPRatio(int PRatio) {
        this.PRatio = PRatio;
    }

    public int getKRatio() {
        return KRatio;
    }

    public void setKRatio(int KRatio) {
        this.KRatio = KRatio;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getUreaAmount() {
        return ureaAmount;
    }

    public void setUreaAmount(int ureaAmount) {
        this.ureaAmount = ureaAmount;
    }

    public int getMopAmount() {
        return mopAmount;
    }

    public void setMopAmount(int mopAmount) {
        this.mopAmount = mopAmount;
    }

    public int getDapAmount() {
        return dapAmount;
    }

    public void setDapAmount(int dapAmount) {
        this.dapAmount = dapAmount;
    }


}
