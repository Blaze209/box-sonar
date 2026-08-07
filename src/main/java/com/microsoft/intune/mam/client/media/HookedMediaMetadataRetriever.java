package com.microsoft.intune.mam.client.media;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedMediaMetadataRetriever {
    MediaMetadataRetriever asMediaMetadataRetriever();

    void realSetDataSource(Context context, Uri uri) throws IllegalArgumentException;

    void realSetDataSource(MediaDataSource mediaDataSource) throws IllegalArgumentException;

    void realSetDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException;

    void realSetDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalArgumentException;

    void realSetDataSource(String str) throws IllegalArgumentException;

    void realSetDataSource(String str, Map<String, String> map) throws IllegalArgumentException;
}
