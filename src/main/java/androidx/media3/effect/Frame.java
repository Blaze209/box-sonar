package androidx.media3.effect;

/* JADX INFO: loaded from: classes8.dex */
public interface Frame {

    public interface Metadata {
    }

    Metadata getMetadata();

    void release(SyncFenceCompat syncFenceCompat);
}
