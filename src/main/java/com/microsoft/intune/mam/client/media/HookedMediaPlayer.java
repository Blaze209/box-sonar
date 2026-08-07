package com.microsoft.intune.mam.client.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedMediaPlayer {
    MediaPlayer asMediaPlayer();

    void realSetDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException;

    void realSetDataSource(Context context, Uri uri, Map<String, String> map, List<HttpCookie> list) throws IllegalStateException, IOException, IllegalArgumentException;

    void realSetDataSource(AssetFileDescriptor assetFileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException;

    void realSetDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException;

    void realSetDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException;

    void realSetDataSource(String str) throws IllegalStateException, IOException, IllegalArgumentException;
}
