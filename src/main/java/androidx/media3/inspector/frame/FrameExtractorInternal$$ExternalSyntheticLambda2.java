package androidx.media3.inspector.frame;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class FrameExtractorInternal$$ExternalSyntheticLambda2 implements Executor {
    public final /* synthetic */ Handler f$0;

    public /* synthetic */ FrameExtractorInternal$$ExternalSyntheticLambda2(Handler handler) {
        this.f$0 = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f$0.post(runnable);
    }
}
