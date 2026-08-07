package com.microsoft.intune.mam.client.media;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface MediaRecorderBehavior {
    void initialize(HookedMediaRecorder hookedMediaRecorder);

    void prepare() throws IOException;

    void setOutputFile(File file);

    void setOutputFile(FileDescriptor fileDescriptor);

    void setOutputFile(String str);

    void start();

    void stop();
}
