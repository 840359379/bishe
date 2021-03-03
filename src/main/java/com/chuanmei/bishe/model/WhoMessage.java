package com.chuanmei.bishe.model;

import java.util.Date;

public class WhoMessage {
    private String from;

    private String to;

    private String content;

    private Date time;

    public WhoMessage() {
    }

    public WhoMessage(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "InMessage{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public WhoMessage(String from, String to, String content, Date time) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.time = time;
    }
}
