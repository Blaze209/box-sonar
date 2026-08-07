package com.microsoft.intune.mam.client.media;

import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MediaMetadataRetrieverBehavior {
    void initialize(HookedMediaMetadataRetriever hookedMediaMetadataRetriever);

    void setDataSource(Context context, Uri uri) throws IllegalArgumentException;

    void setDataSource(MediaDataSource mediaDataSource) throws IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalArgumentException;

    void setDataSource(String str) throws IllegalArgumentException;

    void setDataSource(String str, Map<String, String> map) throws IllegalArgumentException;
}
