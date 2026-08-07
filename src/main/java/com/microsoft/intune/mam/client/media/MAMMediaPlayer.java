package com.microsoft.intune.mam.client.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MAMMediaPlayer extends MediaPlayer implements HookedMediaPlayer {
    final MediaPlayerBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public MediaPlayer asMediaPlayer() {
        return this;
    }

    public MAMMediaPlayer() {
        MediaPlayerBehavior mediaPlayerBehavior = (MediaPlayerBehavior) MAMComponents.get(MediaPlayerBehavior.class);
        this.mBehavior = mediaPlayerBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.initialize(this);
        }
    }

    public static MediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceHolder, AudioAttributes audioAttributes, int i) {
        MAMMediaPlayer mAMMediaPlayer = new MAMMediaPlayer();
        try {
            mAMMediaPlayer.setAudioAttributes(audioAttributes);
            mAMMediaPlayer.setAudioSessionId(i);
            mAMMediaPlayer.setDataSource(context, uri);
            mAMMediaPlayer.setDisplay(surfaceHolder);
            mAMMediaPlayer.prepare();
            return mAMMediaPlayer;
        } catch (IOException | IllegalArgumentException | SecurityException unused) {
            return null;
        }
    }

    public static MediaPlayer create(Context context, Uri uri, SurfaceHolder surfaceHolder) {
        MAMMediaPlayer mAMMediaPlayer = new MAMMediaPlayer();
        try {
            mAMMediaPlayer.setDataSource(context, uri);
            if (surfaceHolder != null) {
                mAMMediaPlayer.setDisplay(surfaceHolder);
            }
            mAMMediaPlayer.prepare();
            return mAMMediaPlayer;
        } catch (IOException | IllegalArgumentException | SecurityException unused) {
            return null;
        }
    }

    public static MediaPlayer create(Context context, int i, AudioAttributes audioAttributes, int i2) {
        return MediaPlayer.create(context, i, audioAttributes, i2);
    }

    public static MediaPlayer create(Context context, int i) {
        return MediaPlayer.create(context, i);
    }

    public static MediaPlayer create(Context context, Uri uri) {
        return create(context, uri, null);
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayerBehavior mediaPlayerBehavior = this.mBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.setDataSource(str);
        } else {
            super.setDataSource(str);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayerBehavior mediaPlayerBehavior = this.mBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.setDataSource(context, uri, map);
        } else {
            super.setDataSource(context, uri, map);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map, List<HttpCookie> list) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayerBehavior mediaPlayerBehavior = this.mBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.setDataSource(context, uri, map, list);
        } else {
            super.setDataSource(context, uri, map, list);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
        MediaPlayerBehavior mediaPlayerBehavior = this.mBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.setDataSource(fileDescriptor, j, j2);
        } else {
            super.setDataSource(fileDescriptor, j, j2);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        MediaPlayerBehavior mediaPlayerBehavior = this.mBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.setDataSource(fileDescriptor);
        } else {
            super.setDataSource(fileDescriptor);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        MediaPlayerBehavior mediaPlayerBehavior = this.mBehavior;
        if (mediaPlayerBehavior != null) {
            mediaPlayerBehavior.setDataSource(assetFileDescriptor);
        } else {
            super.setDataSource(assetFileDescriptor);
        }
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public final void realSetDataSource(String str) throws IllegalStateException, IOException, IllegalArgumentException {
        super.setDataSource(str);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public final void realSetDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
        super.setDataSource(fileDescriptor, j, j2);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public final void realSetDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        super.setDataSource(fileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public final void realSetDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, IllegalArgumentException {
        super.setDataSource(context, uri, map);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public final void realSetDataSource(Context context, Uri uri, Map<String, String> map, List<HttpCookie> list) throws IllegalStateException, IOException, IllegalArgumentException {
        super.setDataSource(context, uri, map, list);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaPlayer
    public final void realSetDataSource(AssetFileDescriptor assetFileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        super.setDataSource(assetFileDescriptor);
    }
}
