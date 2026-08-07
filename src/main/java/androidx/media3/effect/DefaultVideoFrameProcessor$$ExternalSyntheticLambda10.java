package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class DefaultVideoFrameProcessor$$ExternalSyntheticLambda10 implements GlShaderProgram.ErrorListener {
    public final /* synthetic */ VideoFrameProcessor.Listener f$0;

    @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
    public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
        this.f$0.onError(videoFrameProcessingException);
    }
}
