package com.box.android.preview.previewtype.video;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.Formatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoTimeFormatter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/previewtype/video/VideoTimeFormatter;", "", "<init>", "()V", "formatTime", "", "timeMs", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoTimeFormatter {
    public static final int $stable = 0;
    public static final VideoTimeFormatter INSTANCE = new VideoTimeFormatter();

    private VideoTimeFormatter() {
    }

    public final String formatTime(long timeMs) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        if (timeMs == -9223372036854775807L) {
            timeMs = 0;
        }
        String str = timeMs < 0 ? CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR : "";
        long jAbs = Math.abs(timeMs) / ((long) 1000);
        long j = 60;
        long j2 = jAbs % j;
        long j3 = (jAbs / j) % j;
        long j4 = jAbs / ((long) 3600);
        sb.setLength(0);
        if (j4 > 0) {
            String string = formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString();
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = formatter.format("%s%02d:%02d", str, Long.valueOf(j3), Long.valueOf(j2)).toString();
        Intrinsics.checkNotNull(string2);
        return string2;
    }
}
