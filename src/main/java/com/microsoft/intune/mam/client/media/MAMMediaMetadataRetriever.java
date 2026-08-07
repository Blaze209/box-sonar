package com.microsoft.intune.mam.client.media;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MAMMediaMetadataRetriever extends MediaMetadataRetriever implements HookedMediaMetadataRetriever {
    final MediaMetadataRetrieverBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public MediaMetadataRetriever asMediaMetadataRetriever() {
        return this;
    }

    public MAMMediaMetadataRetriever() {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = (MediaMetadataRetrieverBehavior) MAMComponents.get(MediaMetadataRetrieverBehavior.class);
        this.mBehavior = mediaMetadataRetrieverBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.initialize(this);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IllegalArgumentException {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = this.mBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.setDataSource(fileDescriptor, j, j2);
        } else {
            super.setDataSource(fileDescriptor, j, j2);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(String str) throws IllegalStateException, SecurityException, IllegalArgumentException {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = this.mBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.setDataSource(str);
        } else {
            super.setDataSource(str);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(Context context, Uri uri) throws IllegalStateException, SecurityException, IllegalArgumentException {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = this.mBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.setDataSource(context, uri);
        } else {
            super.setDataSource(context, uri);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IllegalArgumentException {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = this.mBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.setDataSource(fileDescriptor);
        } else {
            super.setDataSource(fileDescriptor);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(String str, Map<String, String> map) throws IllegalStateException, SecurityException, IllegalArgumentException {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = this.mBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.setDataSource(str, map);
        } else {
            super.setDataSource(str, map);
        }
    }

    @Override // android.media.MediaMetadataRetriever
    public void setDataSource(MediaDataSource mediaDataSource) throws IllegalArgumentException {
        MediaMetadataRetrieverBehavior mediaMetadataRetrieverBehavior = this.mBehavior;
        if (mediaMetadataRetrieverBehavior != null) {
            mediaMetadataRetrieverBehavior.setDataSource(mediaDataSource);
        } else {
            super.setDataSource(mediaDataSource);
        }
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public final void realSetDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalArgumentException {
        super.setDataSource(fileDescriptor, j, j2);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public final void realSetDataSource(String str) throws IllegalArgumentException {
        super.setDataSource(str);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public final void realSetDataSource(Context context, Uri uri) throws IllegalStateException, IllegalArgumentException {
        super.setDataSource(context, uri);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public final void realSetDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException {
        super.setDataSource(fileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public final void realSetDataSource(String str, Map<String, String> map) throws IllegalStateException, IllegalArgumentException {
        super.setDataSource(str, map);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaMetadataRetriever
    public final void realSetDataSource(MediaDataSource mediaDataSource) throws IllegalArgumentException {
        super.setDataSource(mediaDataSource);
    }
}
