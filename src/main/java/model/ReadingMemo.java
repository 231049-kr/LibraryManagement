package model;

import java.sql.Timestamp;

public class ReadingMemo {
    private int memoId;
    private String title;
    private String memoText;
    private Timestamp createdAt;

    public ReadingMemo(int memoId, String title, String memoText, Timestamp createdAt) {
        this.memoId = memoId;
        this.title = title;
        this.memoText = memoText;
        this.createdAt = createdAt;
    }

    // Getter/Setter
    public int getMemoId() { return memoId; }
    public String getTitle() { return title; }
    public String getMemoText() { return memoText; }
    public Timestamp getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "ReadingMemo{" +
                "memoId=" + memoId +
                ", title='" + title + '\'' +
                ", memoText='" + memoText + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}