package com.box.android.common.utilities;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkVersionProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/common/utilities/SdkVersionProvider;", "", "<init>", "()V", "sdkVersion", "", "getSdkVersion", "()I", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SdkVersionProvider {
    public static final SdkVersionProvider INSTANCE = new SdkVersionProvider();
    private static final int sdkVersion = Build.VERSION.SDK_INT;

    private SdkVersionProvider() {
    }

    public final int getSdkVersion() {
        return sdkVersion;
    }
}
