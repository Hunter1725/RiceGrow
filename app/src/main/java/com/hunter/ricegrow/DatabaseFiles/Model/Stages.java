package com.hunter.ricegrow.DatabaseFiles.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "stages")
public class Stages implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nameEn;
    private String nameVi;
    private int order;
    private String descriptionEn;
    private String descriptionVi;
    @ColumnInfo(name = "stage_image")
    private String stageImage;
    private boolean selected;

    public Stages(String nameEn, String nameVi, int order, String descriptionEn, String descriptionVi, String stageImage) {
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.order = order;
        this.descriptionEn = descriptionEn;
        this.descriptionVi = descriptionVi;
        this.stageImage = stageImage;
        this.selected = false;
    }

    @Ignore
    public Stages() {
    }

    @Ignore
    protected Stages(Parcel in) {
        id = in.readInt();
        nameEn = in.readString();
        nameVi = in.readString();
        order = in.readInt();
        descriptionEn = in.readString();
        descriptionVi = in.readString();
        stageImage = in.readString();
        selected = in.readByte() != 0;
    }

    @Ignore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nameEn);
        dest.writeString(nameVi);
        dest.writeInt(order);
        dest.writeString(descriptionEn);
        dest.writeString(descriptionVi);
        dest.writeString(stageImage);
        dest.writeByte((byte) (selected ? 1 : 0));
    }

    @Ignore
    @Override
    public int describeContents() {
        return 0;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
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
}
