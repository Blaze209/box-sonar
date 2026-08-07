package com.box.android.boxai.voice;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/voice/AudioUtils;", "", "<init>", "()V", "RMS_SILENCE_VALUE", "", "RMS_MAX_VALUE", "resampleAndNormalizeAudioLevel", "Lkotlinx/coroutines/flow/Flow;", "rmsSamplesFlow", "sampleInterval", "Lkotlin/time/Duration;", "resampleAndNormalizeAudioLevel-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "audioLevelFromRmsSamples", "rmsSamples", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioUtils {
    public static final int $stable = 0;
    public static final AudioUtils INSTANCE = new AudioUtils();
    private static final float RMS_MAX_VALUE = 10.0f;
    private static final float RMS_SILENCE_VALUE = 0.0f;

    private AudioUtils() {
    }

    /* JADX INFO: renamed from: resampleAndNormalizeAudioLevel-HG0u8IE, reason: not valid java name */
    public final Flow<Float> m12124resampleAndNormalizeAudioLevelHG0u8IE(Flow<Float> rmsSamplesFlow, long sampleInterval) {
        Intrinsics.checkNotNullParameter(rmsSamplesFlow, "rmsSamplesFlow");
        return FlowKt.flowOn(FlowKt.flow(new AudioUtils$resampleAndNormalizeAudioLevel$1(sampleInterval, rmsSamplesFlow, null)), Dispatchers.getMain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float audioLevelFromRmsSamples(List<Float> rmsSamples) {
        if (rmsSamples.isEmpty()) {
            return 0.0f;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : rmsSamples) {
            if (!Float.isNaN(((Number) obj).floatValue())) {
                arrayList.add(obj);
            }
        }
        return RangesKt.coerceIn((((float) CollectionsKt.averageOfFloat(arrayList)) - 0.0f) / 10.0f, 0.0f, 1.0f);
    }
}
