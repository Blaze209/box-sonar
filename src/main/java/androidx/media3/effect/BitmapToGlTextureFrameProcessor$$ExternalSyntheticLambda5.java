package androidx.media3.effect;

import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda5 implements Consumer {
    public final /* synthetic */ GlShaderProgram f$0;

    @Override // androidx.media3.common.util.Consumer
    public final void accept(Object obj) {
        this.f$0.releaseOutputFrame((GlTextureInfo) obj);
    }
}
