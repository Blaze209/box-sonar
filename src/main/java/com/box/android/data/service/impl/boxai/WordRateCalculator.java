package com.box.android.data.service.impl.boxai;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: BoxAiStreamingRateLimiter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/service/impl/boxai/WordRateCalculator;", "", "<init>", "()V", "previousDelay", "", "getWordDelay", "Lkotlin/time/Duration;", "bufferSize", "", "getWordDelay-5sfh64U", "(I)J", "getTargetWordDelay", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class WordRateCalculator {
    private static final float DELAY_SMOOTHING_FACTOR = 0.15f;
    private static final float INITIAL_DELAY = 50.0f;
    private static final float MAX_DELAY = 100.0f;
    private static final float MIN_DELAY = 10.0f;
    private float previousDelay = 50.0f;

    /* JADX INFO: renamed from: getWordDelay-5sfh64U, reason: not valid java name */
    public final long m12570getWordDelay5sfh64U(int bufferSize) {
        float targetWordDelay = getTargetWordDelay(bufferSize);
        float f = this.previousDelay;
        float f2 = f + ((targetWordDelay - f) * 0.15f);
        this.previousDelay = f2;
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration((long) f2, DurationUnit.MILLISECONDS);
    }

    private final float getTargetWordDelay(int bufferSize) {
        return RangesKt.coerceAtLeast(MAX_DELAY / (bufferSize + 1), 10.0f);
    }
}
