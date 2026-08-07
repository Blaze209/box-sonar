package androidx.media3.common.audio;

/* JADX INFO: loaded from: classes8.dex */
public interface SpeedProvider {
    public static final SpeedProvider DEFAULT = new SpeedProvider() { // from class: androidx.media3.common.audio.SpeedProvider.1
        @Override // androidx.media3.common.audio.SpeedProvider
        public long getNextSpeedChangeTimeUs(long j) {
            return -9223372036854775807L;
        }

        @Override // androidx.media3.common.audio.SpeedProvider
        public float getSpeed(long j) {
            return 1.0f;
        }
    };

    long getNextSpeedChangeTimeUs(long j);

    float getSpeed(long j);
}
