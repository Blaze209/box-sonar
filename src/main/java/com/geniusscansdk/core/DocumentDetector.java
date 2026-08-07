package com.geniusscansdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.soloader.MinElf;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public abstract class DocumentDetector {
    protected long nativeHandle;

    public enum Mode {
        FAST,
        PRECISE
    }

    private static native Quadrangle detectDocumentFromBitmap(long j, Bitmap bitmap) throws LicenseException, ProcessingException;

    private static native Quadrangle detectDocumentFromBuffer(long j, byte[] bArr, int i, int i2, int i3) throws LicenseException, ProcessingException;

    private static native Quadrangle detectDocumentFromFile(long j, String str) throws LicenseException, ProcessingException;

    protected void finalize() {
        this.nativeHandle = 0L;
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }

    public static DocumentDetector create(Context context, Mode mode) {
        if (isArm32Device()) {
            GeniusScanSDK.getLogger().debug("ARM 32 device, fallback to legacy document detection");
            return new LegacyDocumentDetector();
        }
        GeniusScanSDK.getLogger().debug("Using regular document detection");
        return new CnnDocumentDetector(context, mode);
    }

    private static boolean isArm32Device() {
        GeniusScanSDK.getLogger().debug("Supported ABIs: " + Arrays.toString(Build.SUPPORTED_ABIS));
        return Build.SUPPORTED_ABIS != null && Build.SUPPORTED_ABIS.length > 0 && Build.SUPPORTED_ABIS[0].equals(MinElf.ISA.ARM);
    }

    public static DocumentDetector create(Context context) {
        return create(context, Mode.PRECISE);
    }

    public Quadrangle detectDocument(File file) throws LicenseException, ProcessingException {
        return detectDocumentFromFile(this.nativeHandle, file.getAbsolutePath());
    }

    public Quadrangle detectDocument(Bitmap bitmap) throws LicenseException, ProcessingException {
        return detectDocumentFromBitmap(this.nativeHandle, bitmap);
    }

    public Quadrangle detectDocument(byte[] bArr, int i, int i2, int i3) throws LicenseException, ProcessingException {
        return detectDocumentFromBuffer(this.nativeHandle, bArr, i, i2, i3);
    }

    static {
        System.loadLibrary("gssdk-core");
    }
}
