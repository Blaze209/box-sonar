package androidx.media3.effect;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class DefaultVideoCompositor$$ExternalSyntheticLambda2 implements VideoFrameProcessingTaskExecutor.Task {
    public final /* synthetic */ DefaultVideoCompositor f$0;

    public /* synthetic */ DefaultVideoCompositor$$ExternalSyntheticLambda2(DefaultVideoCompositor defaultVideoCompositor) {
        this.f$0 = defaultVideoCompositor;
    }

    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
    public final void run() throws Throwable {
        this.f$0.maybeComposite();
    }
}
