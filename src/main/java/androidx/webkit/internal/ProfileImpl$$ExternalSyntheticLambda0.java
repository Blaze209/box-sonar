package androidx.webkit.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class ProfileImpl$$ExternalSyntheticLambda0 implements Executor {
    public final /* synthetic */ Handler f$0;

    public /* synthetic */ ProfileImpl$$ExternalSyntheticLambda0(Handler handler) {
        this.f$0 = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f$0.post(runnable);
    }
}
