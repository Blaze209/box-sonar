package androidx.test.espresso;

/* JADX INFO: loaded from: classes9.dex */
public interface IdlingResource {

    public interface ResourceCallback {
        void onTransitionToIdle();
    }

    String getName();

    boolean isIdleNow();

    void registerIdleTransitionCallback(ResourceCallback callback);
}
