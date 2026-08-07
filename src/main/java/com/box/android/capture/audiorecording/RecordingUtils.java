package com.box.android.capture.audiorecording;

import com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecordingUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/box/android/capture/audiorecording/RecordingUtils;", "", "<init>", "()V", "parseElapsedTime", "", "elapsedTime", "", "formatTimeText", "time", "parseLeftTime", "leftTime", "getRecordedFileSize", "environment", "Lcom/box/android/capture/audiorecording/cpl/AudioCaptureEnvironment;", "getRecordedFileDurationInMinutes", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordingUtils {
    public static final int $stable = 0;
    public static final RecordingUtils INSTANCE = new RecordingUtils();

    private RecordingUtils() {
    }

    public final String parseElapsedTime(long elapsedTime) {
        return formatTimeText(elapsedTime);
    }

    private final String formatTimeText(long time) {
        String strValueOf = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(time));
        return StringsKt.padStart(strValueOf, Math.max(2, strValueOf.length()), '0') + ":" + StringsKt.padStart(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(time) % TimeUnit.MINUTES.toSeconds(1L)), 2, '0') + "." + ((TimeUnit.MILLISECONDS.toMillis(time) % TimeUnit.SECONDS.toMillis(1L)) / ((long) 100));
    }

    public final String parseLeftTime(long leftTime) {
        if (leftTime < 50) {
            return formatTimeText(leftTime);
        }
        return CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + formatTimeText(leftTime);
    }

    public final long getRecordedFileSize(AudioCaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        return environment.getRecordingFileManager().getRecordingFile().length();
    }

    public final String getRecordedFileDurationInMinutes(AudioCaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(RecorderService.INSTANCE.getFileDuration(environment.getRecordingFileManager().getRecordingFile()) / 60000)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
