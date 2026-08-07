package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeApplicationService {
    public abstract String appName();

    public abstract String computerReadableVersion();

    public abstract String databaseDirectory();

    public abstract NativeDataProvider getAsset(NativeAssetDescriptor nativeAssetDescriptor);

    public abstract Float getMaxImageMemoryRatio();

    public abstract String getOcrTrainedDataPath(NativeOcrLanguage nativeOcrLanguage);

    public abstract long getPhysicalMemory();

    public abstract String getPspdfkitLibraryPath();

    public abstract ArrayList<String> getSystemFontPaths();

    public abstract String humanReadableVersion();

    public abstract boolean isDevelopmentBuild();

    public abstract boolean isSimulator();

    public abstract String osName();

    public abstract String removeApplicationPath(String str);

    public abstract void showAlert(String str, String str2, EnumSet<NativeAlertOptions> enumSet);

    public abstract String temporaryDirectory();
}
