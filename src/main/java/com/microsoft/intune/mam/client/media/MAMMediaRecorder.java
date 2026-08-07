package com.microsoft.intune.mam.client.media;

import android.media.MediaRecorder;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MAMMediaRecorder extends MediaRecorder implements HookedMediaRecorder {
    final MediaRecorderBehavior mBehavior;

    public MAMMediaRecorder() {
        MediaRecorderBehavior mediaRecorderBehavior = (MediaRecorderBehavior) MAMComponents.get(MediaRecorderBehavior.class);
        this.mBehavior = mediaRecorderBehavior;
        mediaRecorderBehavior.initialize(this);
    }

    @Override // android.media.MediaRecorder
    public void prepare() throws IOException {
        this.mBehavior.prepare();
    }

    @Override // android.media.MediaRecorder
    public void start() {
        this.mBehavior.start();
    }

    @Override // android.media.MediaRecorder
    public void stop() {
        this.mBehavior.stop();
    }

    @Override // android.media.MediaRecorder
    public void setOutputFile(FileDescriptor fileDescriptor) {
        this.mBehavior.setOutputFile(fileDescriptor);
    }

    @Override // android.media.MediaRecorder
    public void setOutputFile(File file) {
        this.mBehavior.setOutputFile(file);
    }

    @Override // android.media.MediaRecorder
    public void setOutputFile(String str) {
        this.mBehavior.setOutputFile(str);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaRecorder
    public void realPrepare() throws IOException {
        super.prepare();
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaRecorder
    public void realStart() {
        super.start();
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaRecorder
    public void realStop() {
        super.stop();
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaRecorder
    public void realSetOutputFile(FileDescriptor fileDescriptor) {
        super.setOutputFile(fileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaRecorder
    public void realSetOutputFile(File file) {
        super.setOutputFile(file);
    }

    @Override // com.microsoft.intune.mam.client.media.HookedMediaRecorder
    public void realSetOutputFile(String str) {
        super.setOutputFile(str);
    }
}
