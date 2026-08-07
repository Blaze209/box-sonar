package com.microsoft.intune.mam.client.media;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMediaRecorderBehavior implements MediaRecorderBehavior {
    private HookedMediaRecorder mRecorder;

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void initialize(HookedMediaRecorder hookedMediaRecorder) {
        this.mRecorder = hookedMediaRecorder;
    }

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void prepare() throws IOException {
        this.mRecorder.realPrepare();
    }

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void start() {
        this.mRecorder.realStart();
    }

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void stop() {
        this.mRecorder.realStop();
    }

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void setOutputFile(FileDescriptor fileDescriptor) {
        this.mRecorder.realSetOutputFile(fileDescriptor);
    }

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void setOutputFile(File file) {
        this.mRecorder.realSetOutputFile(file);
    }

    @Override // com.microsoft.intune.mam.client.media.MediaRecorderBehavior
    public void setOutputFile(String str) {
        this.mRecorder.realSetOutputFile(str);
    }
}
