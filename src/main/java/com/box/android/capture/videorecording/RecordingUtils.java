package com.box.android.capture.videorecording;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecordingUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/box/android/capture/videorecording/RecordingUtils;", "", "<init>", "()V", "parseElapsedTime", "", "elapsedTime", "", "formatTimeText", "time", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordingUtils {
    public static final int $stable = 0;
    public static final RecordingUtils INSTANCE = new RecordingUtils();

    private RecordingUtils() {
    }

    public final String parseElapsedTime(long elapsedTime) {
        return formatTimeText(elapsedTime);
    }

    private final String formatTimeText(long time) {
        String strValueOf = String.valueOf(TimeUnit.MILLISECONDS.toHours(time));
        String strPadStart = StringsKt.padStart(strValueOf, Math.max(2, strValueOf.length()), '0');
        String strValueOf2 = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(time));
        return strPadStart + ":" + StringsKt.padStart(strValueOf2, Math.max(2, strValueOf2.length()), '0') + ":" + StringsKt.padStart(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(time) % TimeUnit.MINUTES.toSeconds(1L)), 2, '0');
    }
}
