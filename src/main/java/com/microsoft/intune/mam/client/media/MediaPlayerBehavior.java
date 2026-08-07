package com.microsoft.intune.mam.client.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MediaPlayerBehavior {
    void initialize(HookedMediaPlayer hookedMediaPlayer);

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(Context context, Uri uri, Map<String, String> map, List<HttpCookie> list) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(String str) throws IllegalStateException, IOException, IllegalArgumentException;
}
