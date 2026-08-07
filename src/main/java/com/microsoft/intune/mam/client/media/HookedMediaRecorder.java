package com.microsoft.intune.mam.client.media;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedMediaRecorder {
    void realPrepare() throws IOException;

    void realSetOutputFile(File file);

    void realSetOutputFile(FileDescriptor fileDescriptor);

    void realSetOutputFile(String str);

    void realStart();

    void realStop();
}
