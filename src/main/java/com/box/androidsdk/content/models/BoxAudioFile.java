package com.box.androidsdk.content.models;

import android.app.PendingIntent;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes13.dex */
public class BoxAudioFile extends BoxFile {
    private static final String FIELD_ARTIST = "artist";
    private static final String FIELD_DURATION = "duration";
    private static final String FIELD_TITLE = "title";
    private transient PendingIntent mPendingIntent;
    private transient Bitmap mThumbnail;

    public BoxAudioFile(BoxFile boxFile) {
        createFromJson(boxFile.toJson());
    }

    public BoxAudioFile setArtist(String str) {
        set(FIELD_ARTIST, str);
        return this;
    }

    public String getArtist() {
        return getPropertyAsString(FIELD_ARTIST);
    }

    public BoxAudioFile setTitle(String str) {
        set("title", str);
        return this;
    }

    public String getTitle() {
        return getPropertyAsString("title");
    }

    public BoxAudioFile setDuration(String str) {
        set("duration", str);
        return this;
    }

    public String getDuration() {
        return getPropertyAsString("duration");
    }

    public BoxAudioFile setThumbnail(Bitmap bitmap) {
        this.mThumbnail = bitmap;
        return this;
    }

    public Bitmap getThumbnail() {
        return this.mThumbnail;
    }

    public BoxAudioFile setPendingIntent(PendingIntent pendingIntent) {
        this.mPendingIntent = pendingIntent;
        return this;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }
}
