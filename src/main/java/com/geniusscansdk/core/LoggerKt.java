package com.geniusscansdk.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"fromJNI", "Lcom/geniusscansdk/core/Logger$Severity;", "Lcom/geniusscansdk/core/JNILoggerSeverity;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LoggerKt {

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JNILoggerSeverity.values().length];
            try {
                iArr[JNILoggerSeverity.VERBOSELEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JNILoggerSeverity.INFOLEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JNILoggerSeverity.DEBUGLEVEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JNILoggerSeverity.WARNLEVEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JNILoggerSeverity.ERRORLEVEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger.Severity fromJNI(JNILoggerSeverity jNILoggerSeverity) {
        int i = WhenMappings.$EnumSwitchMapping$0[jNILoggerSeverity.ordinal()];
        if (i == 1) {
            return Logger.Severity.Verbose;
        }
        if (i == 2) {
            return Logger.Severity.Info;
        }
        if (i == 3) {
            return Logger.Severity.Debug;
        }
        if (i == 4) {
            return Logger.Severity.Warn;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return Logger.Severity.Error;
    }
}
