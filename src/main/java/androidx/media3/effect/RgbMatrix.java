package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: classes8.dex */
public interface RgbMatrix extends GlEffect {
    float[] getMatrix(long j, boolean z);

    @Override // androidx.media3.effect.GlEffect
    default BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return DefaultShaderProgram.create(context, ImmutableList.of(), ImmutableList.of(this), z);
    }
}
