package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.SpeedProviderUtil;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public final class SpeedChangeEffect implements GlEffect {
    private final SpeedProvider speedProvider;

    public SpeedChangeEffect(final float f) {
        Preconditions.checkArgument(f > 0.0f);
        this.speedProvider = new SpeedProvider() { // from class: androidx.media3.effect.SpeedChangeEffect.1
            @Override // androidx.media3.common.audio.SpeedProvider
            public long getNextSpeedChangeTimeUs(long j) {
                return -9223372036854775807L;
            }

            @Override // androidx.media3.common.audio.SpeedProvider
            public float getSpeed(long j) {
                return f;
            }
        };
    }

    public SpeedChangeEffect(SpeedProvider speedProvider) {
        this.speedProvider = speedProvider;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return new SpeedChangeShaderProgram(this.speedProvider);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.speedProvider.getSpeed(0L) == 1.0f && this.speedProvider.getNextSpeedChangeTimeUs(0L) == -9223372036854775807L;
    }

    @Override // androidx.media3.common.Effect
    public long getDurationAfterEffectApplied(long j) {
        return SpeedProviderUtil.getDurationAfterSpeedProviderApplied(this.speedProvider, j);
    }
}
