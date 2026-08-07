package com.geniusscansdk.camera;

import com.geniusscansdk.core.RotationAngle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public abstract class FileImageCaptureCallback implements ImageCaptureCallback {
    private final File outputFile;

    public abstract void onImageCaptured(RotationAngle rotationAngle);

    public FileImageCaptureCallback(File file) {
        this.outputFile = file;
    }

    @Override // com.geniusscansdk.camera.ImageCaptureCallback
    public void onImageCaptured(byte[] bArr, RotationAngle rotationAngle) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            System.gc();
            onImageCaptured(rotationAngle);
        } catch (IOException e) {
            onError(e);
        }
    }
}
