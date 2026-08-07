package com.geniusscansdk.camera;

import com.geniusscansdk.core.RotationAngle;

/* JADX INFO: loaded from: classes13.dex */
public interface ImageCaptureCallback {
    void onError(Exception exc);

    void onImageCaptured(byte[] bArr, RotationAngle rotationAngle);
}
