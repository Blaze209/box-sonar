package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
public final class TimestampWrapper implements GlEffect {
    public final long endTimeUs;
    public final GlEffect glEffect;
    public final long startTimeUs;

    public TimestampWrapper(GlEffect glEffect, long j, long j2) {
        Preconditions.checkArgument(j >= 0 && j2 >= 0, "startTimeUs and endTimeUs must be non-negative.");
        Preconditions.checkArgument(j2 > j, "endTimeUs should be after startTimeUs.");
        this.glEffect = glEffect;
        this.startTimeUs = j;
        this.endTimeUs = j2;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new TimestampWrapperShaderProgram(context, z, this);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.glEffect.isNoOp(i, i2);
    }
}
