package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class OverlayEffect implements GlEffect {
    private final ImmutableList<TextureOverlay> overlays;

    public OverlayEffect(List<TextureOverlay> list) {
        this.overlays = ImmutableList.copyOf((Collection) list);
    }

    @Override // androidx.media3.effect.GlEffect
    public BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new OverlayShaderProgram(context, z, this.overlays);
    }
}
