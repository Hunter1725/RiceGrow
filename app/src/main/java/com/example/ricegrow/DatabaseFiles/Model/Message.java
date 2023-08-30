package com.example.ricegrow.DatabaseFiles.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "message")
public class Message {
    @Ignore
    public static String SENT_BY_ME = "me";
    @Ignore
    public static String SENT_BY_BOT = "bot";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String message;
    private String sentBy;
    private long createdAt;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message(String message, String sentBy, long createdAt) {
        this.message = message;
        this.sentBy = sentBy;
        this.createdAt = createdAt;
    }

    @Ignore
    public Message() {
    }
}
