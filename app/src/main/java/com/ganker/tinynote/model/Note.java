package com.ganker.tinynote.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jackson on 3/13/16.
 */
public class Note {
    private UUID uuid;
    private String title;
    private String content;
    private Date date;
    private String tag;

    public Note(){
        uuid = UUID.randomUUID();
        date = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
