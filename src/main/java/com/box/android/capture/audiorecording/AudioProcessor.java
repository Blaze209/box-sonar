package com.box.android.capture.audiorecording;

import kotlin.Metadata;

/* JADX INFO: compiled from: AudioProcessor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/capture/audiorecording/AudioProcessor;", "", "<init>", "()V", "CONVERSION_FACTOR", "", "REFERNECE_PRESSURE", "NOISE_CUTOFF", "", "MAX_DB", "", "normalizeAmplitude", "amplitude", "normalize", "power", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioProcessor {
    public static final int $stable = 0;
    private static final double CONVERSION_FACTOR = 51805.5336d;
    public static final AudioProcessor INSTANCE = new AudioProcessor();
    private static final float MAX_DB = 90.0f;
    private static final int NOISE_CUTOFF = 45;
    private static final double REFERNECE_PRESSURE = 2.0E-5d;

    private final double normalize(double power) {
        if (power > 90.0d) {
            return 1.0d;
        }
        if (power <= 45.0d) {
            return 0.0d;
        }
        return (power - ((double) 45)) / ((double) MAX_DB);
    }

    private AudioProcessor() {
    }

    public final double normalizeAmplitude(int amplitude) {
        return normalize(((double) 20) * Math.log10((((double) amplitude) / CONVERSION_FACTOR) / REFERNECE_PRESSURE));
    }
}
