package external.sdk.pendo.io.glide.request;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        a(boolean z) {
            this.isComplete = z;
        }

        boolean b() {
            return this.isComplete;
        }
    }

    boolean canNotifyCleared(sdk.pendo.io.u.a aVar);

    boolean canNotifyStatusChanged(sdk.pendo.io.u.a aVar);

    boolean canSetImage(sdk.pendo.io.u.a aVar);

    b getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(sdk.pendo.io.u.a aVar);

    void onRequestSuccess(sdk.pendo.io.u.a aVar);
}
