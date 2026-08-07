package com.geniusscansdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GeniusScanSDK.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J*\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0012H\u0007J\u0018\u0010\u0017\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J \u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0007J \u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0016H\u0007J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0019\u0010(\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082 J\t\u0010)\u001a\u00020\fH\u0082 J\u0011\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0016H\u0082 J)\u0010,\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0012H\u0082 J!\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0016H\u0082 J!\u00100\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0082 J!\u00101\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0016H\u0082 R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00063"}, d2 = {"Lcom/geniusscansdk/core/GeniusScanSDK;", "", "<init>", "()V", "logger", "Lcom/geniusscansdk/core/Logger;", "getLogger$annotations", "getLogger", "()Lcom/geniusscansdk/core/Logger;", "setLogger", "(Lcom/geniusscansdk/core/Logger;)V", "setLicenseKey", "", "context", "Landroid/content/Context;", "licenseKey", "", "autoRefresh", "", "checkInitialization", "setJPGQuality", "jpgQuality", "", "rotateImage", "imageToRotatePath", "rotatedImagePath", "angle", "Lcom/geniusscansdk/core/RotationAngle;", "isBinary", "Landroid/graphics/Bitmap;", "image", "scaleImage", "inPath", "outPath", "scalingRatio", "", "maxImageSize", "checkFileExists", "path", "checkParentFolderExists", "GSLInit", "GSLCheckInitialization", "GSLSetJPGQuality", "jpegQuality", "GSLRotateImage", "GSLRotateImageFromBitmap", "input", "output", "GSLScaleImage", "GSLScaleImageToFit", "DefaultLicenseKeySetter", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeniusScanSDK {
    public static final GeniusScanSDK INSTANCE = new GeniusScanSDK();
    private static Logger logger = new DefaultLogger();

    private final native void GSLCheckInitialization() throws LicenseException;

    /* JADX INFO: Access modifiers changed from: private */
    public final native void GSLInit(Context context, String licenseKey) throws LicenseException;

    private final native void GSLRotateImage(String inPath, String outPath, int angle, boolean isBinary) throws LicenseException, ProcessingException;

    private final native void GSLRotateImageFromBitmap(Bitmap input, Bitmap output, int angle) throws LicenseException, ProcessingException;

    private final native void GSLScaleImage(String inPath, String outPath, float scalingRatio) throws LicenseException, ProcessingException;

    private final native void GSLScaleImageToFit(String inPath, String outPath, int maxImageSize) throws LicenseException, ProcessingException;

    private final native void GSLSetJPGQuality(int jpegQuality);

    @JvmStatic
    public static /* synthetic */ void getLogger$annotations() {
    }

    @JvmStatic
    public static final void rotateImage(String imageToRotatePath, String rotatedImagePath, RotationAngle angle) throws LicenseException, ProcessingException, IOException {
        Intrinsics.checkNotNullParameter(imageToRotatePath, "imageToRotatePath");
        Intrinsics.checkNotNullParameter(rotatedImagePath, "rotatedImagePath");
        Intrinsics.checkNotNullParameter(angle, "angle");
        rotateImage$default(imageToRotatePath, rotatedImagePath, angle, false, 8, null);
    }

    private GeniusScanSDK() {
    }

    static {
        System.loadLibrary("gssdk-core");
    }

    public static final Logger getLogger() {
        return logger;
    }

    public static final void setLogger(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "<set-?>");
        logger = logger2;
    }

    @JvmStatic
    public static final void setLicenseKey(Context context, String licenseKey, boolean autoRefresh) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        new LicenseKeyInitializer(context, null, null, null, null, null, 62, null).setLicenseKey(licenseKey, autoRefresh);
    }

    @JvmStatic
    public static final void setLicenseKey(Context context, String licenseKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        setLicenseKey(context, licenseKey, true);
    }

    @JvmStatic
    public static final void checkInitialization() throws LicenseException {
        INSTANCE.GSLCheckInitialization();
    }

    @JvmStatic
    public static final void setJPGQuality(int jpgQuality) {
        if (jpgQuality < 0 || jpgQuality >= 101) {
            throw new IllegalArgumentException("JPG quality must be between 0 and 100".toString());
        }
        INSTANCE.GSLSetJPGQuality(jpgQuality);
    }

    public static /* synthetic */ void rotateImage$default(String str, String str2, RotationAngle rotationAngle, boolean z, int i, Object obj) throws LicenseException, ProcessingException, IOException {
        if ((i & 8) != 0) {
            z = false;
        }
        rotateImage(str, str2, rotationAngle, z);
    }

    @JvmStatic
    public static final void rotateImage(String imageToRotatePath, String rotatedImagePath, RotationAngle angle, boolean isBinary) throws LicenseException, ProcessingException, IOException {
        Intrinsics.checkNotNullParameter(imageToRotatePath, "imageToRotatePath");
        Intrinsics.checkNotNullParameter(rotatedImagePath, "rotatedImagePath");
        Intrinsics.checkNotNullParameter(angle, "angle");
        GeniusScanSDK geniusScanSDK = INSTANCE;
        geniusScanSDK.checkFileExists(imageToRotatePath);
        geniusScanSDK.checkParentFolderExists(rotatedImagePath);
        geniusScanSDK.GSLRotateImage(imageToRotatePath, rotatedImagePath, angle.getClockwiseDegrees(), isBinary);
    }

    @JvmStatic
    public static final Bitmap rotateImage(Bitmap image, RotationAngle angle) throws LicenseException, ProcessingException {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(angle, "angle");
        if (angle == RotationAngle.ROTATION_90_CW || angle == RotationAngle.ROTATION_90_CCW) {
            int height = image.getHeight();
            int width = image.getWidth();
            Bitmap.Config config = image.getConfig();
            Intrinsics.checkNotNull(config);
            bitmapCreateBitmap = Bitmap.createBitmap(height, width, config);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(image);
        }
        Intrinsics.checkNotNull(bitmapCreateBitmap);
        INSTANCE.GSLRotateImageFromBitmap(image, bitmapCreateBitmap, angle.getClockwiseDegrees());
        return bitmapCreateBitmap;
    }

    @JvmStatic
    public static final void scaleImage(String inPath, String outPath, float scalingRatio) throws LicenseException, ProcessingException, IOException {
        Intrinsics.checkNotNullParameter(inPath, "inPath");
        Intrinsics.checkNotNullParameter(outPath, "outPath");
        GeniusScanSDK geniusScanSDK = INSTANCE;
        geniusScanSDK.checkFileExists(inPath);
        geniusScanSDK.checkParentFolderExists(outPath);
        geniusScanSDK.GSLScaleImage(inPath, outPath, scalingRatio);
    }

    @JvmStatic
    public static final void scaleImage(String inPath, String outPath, int maxImageSize) throws LicenseException, ProcessingException, IOException {
        Intrinsics.checkNotNullParameter(inPath, "inPath");
        Intrinsics.checkNotNullParameter(outPath, "outPath");
        GeniusScanSDK geniusScanSDK = INSTANCE;
        geniusScanSDK.checkFileExists(inPath);
        geniusScanSDK.checkParentFolderExists(outPath);
        geniusScanSDK.GSLScaleImageToFit(inPath, outPath, maxImageSize);
    }

    private final void checkFileExists(String path) throws IOException {
        if (!new File(path).exists()) {
            throw new IOException("File does not exist: " + path);
        }
    }

    private final void checkParentFolderExists(String path) throws IOException {
        File parentFile = new File(path).getParentFile();
        if (parentFile == null) {
            throw new IOException("No parent file for: " + path);
        }
        if (parentFile.exists() && parentFile.isDirectory()) {
            return;
        }
        throw new IOException("Folder does not exist: " + parentFile.getPath());
    }

    /* JADX INFO: compiled from: GeniusScanSDK.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/GeniusScanSDK$DefaultLicenseKeySetter;", "Lcom/geniusscansdk/core/LicenseKeySetter;", "<init>", "()V", "setLicenseKey", "", "context", "Landroid/content/Context;", "licenseKey", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultLicenseKeySetter implements LicenseKeySetter {
        @Override // com.geniusscansdk.core.LicenseKeySetter
        public void setLicenseKey(Context context, String licenseKey) throws LicenseException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
            GeniusScanSDK.INSTANCE.GSLInit(context, licenseKey);
        }
    }
}
