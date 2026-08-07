package sdk.pendo.io.u;

/* JADX INFO: loaded from: classes5.dex */
public interface a {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(a aVar);

    boolean isRunning();

    void pause();
}
