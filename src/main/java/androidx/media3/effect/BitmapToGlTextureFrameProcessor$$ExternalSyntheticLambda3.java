package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda3 implements VideoFrameProcessingTaskExecutor.ErrorListener {
    public final /* synthetic */ Consumer f$0;

    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.ErrorListener
    public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
        this.f$0.accept(videoFrameProcessingException);
    }
}
