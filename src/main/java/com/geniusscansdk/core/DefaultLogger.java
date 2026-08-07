package com.geniusscansdk.core;

import android.util.Log;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/DefaultLogger;", "Lcom/geniusscansdk/core/Logger;", "<init>", "()V", "log", "", "message", "", "severity", "Lcom/geniusscansdk/core/Logger$Severity;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultLogger extends Logger {

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Logger.Severity.values().length];
            try {
                iArr[Logger.Severity.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Logger.Severity.Debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Logger.Severity.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Logger.Severity.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Logger.Severity.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.geniusscansdk.core.Logger
    public void log(String message, Logger.Severity severity) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(severity, "severity");
        int i = WhenMappings.$EnumSwitchMapping$0[severity.ordinal()];
        if (i == 1) {
            Log.v("GeniusScanSDK", message);
            return;
        }
        if (i == 2) {
            Log.d("GeniusScanSDK", message);
            return;
        }
        if (i == 3) {
            Log.i("GeniusScanSDK", message);
        } else if (i == 4) {
            Log.w("GeniusScanSDK", message);
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            Log.e("GeniusScanSDK", message);
        }
    }
}
