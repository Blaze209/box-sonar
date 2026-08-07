package androidx.media3.session;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class MediaLibrarySessionImpl$$ExternalSyntheticLambda2 implements Executor {
    public final /* synthetic */ MediaLibrarySessionImpl f$0;

    public /* synthetic */ MediaLibrarySessionImpl$$ExternalSyntheticLambda2(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        this.f$0 = mediaLibrarySessionImpl;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f$0.postOrRunOnApplicationHandler(runnable);
    }
}
