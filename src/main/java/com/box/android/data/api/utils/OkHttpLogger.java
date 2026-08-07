package com.box.android.data.api.utils;

import android.util.Log;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: compiled from: OkHttpLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/api/utils/OkHttpLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "()V", "log", "", "message", "", "resolveLogLevel", "", "okHttpLog", FirebaseAnalytics.Param.LEVEL, "t", "", "logChunk", "chunk", "canEncode", "", "isBinaryContentType", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OkHttpLogger implements HttpLoggingInterceptor.Logger {

    @Deprecated
    public static final String CHARSET_ISO = "ISO-8859-1";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAX_LOG_LENGTH = 4000;

    @Deprecated
    public static final String TAG = "OkHttp";

    /* JADX INFO: compiled from: OkHttpLogger.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/android/data/api/utils/OkHttpLogger$Companion;", "", "<init>", "()V", "MAX_LOG_LENGTH", "", "TAG", "", "CHARSET_ISO", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        okHttpLog$default(this, message, resolveLogLevel(message), null, 4, null);
    }

    private final int resolveLogLevel(String message) {
        return (StringsKt.startsWith$default(message, "-->", false, 2, (Object) null) || StringsKt.startsWith$default(message, "<--", false, 2, (Object) null)) ? 3 : 2;
    }

    static /* synthetic */ void okHttpLog$default(OkHttpLogger okHttpLogger, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        okHttpLogger.okHttpLog(str, i, th);
    }

    private final void okHttpLog(String message, int level, Throwable t) {
        int iMin;
        CharsetEncoder charsetEncoderNewEncoder = Charset.forName("ISO-8859-1").newEncoder();
        if (t != null) {
            message = message + "\n" + Log.getStackTraceString(t);
        }
        int i = 0;
        boolean z = false;
        while (i < message.length()) {
            Integer numValueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) message, '\n', i, false, 4, (Object) null));
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : message.length();
            while (true) {
                iMin = Math.min(iIntValue, i + 4000);
                String strSubstring = message.substring(i, iMin);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String string = StringsKt.trim((CharSequence) strSubstring).toString();
                String str = string;
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "Content-Type", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "application/octet-stream", false, 2, (Object) null)) {
                    z = true;
                }
                logChunk(level, string, charsetEncoderNewEncoder.canEncode(str), z);
                if (iMin >= iIntValue) {
                    break;
                } else {
                    i = iMin;
                }
            }
            i = iMin + 1;
        }
    }

    private final void logChunk(int level, String chunk, boolean canEncode, boolean isBinaryContentType) {
        if (canEncode) {
            BoxLogUtils.log(level, TAG, chunk);
        } else if (StringsKt.startsWith$default(chunk, "--", false, 2, (Object) null)) {
            BoxLogUtils.log(level, TAG, chunk);
        } else if (isBinaryContentType) {
            BoxLogUtils.log(level, TAG, "############ BINARY DATA (skipping) ############");
        }
    }
}
