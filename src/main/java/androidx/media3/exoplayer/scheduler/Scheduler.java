package androidx.media3.exoplayer.scheduler;

/* JADX INFO: loaded from: classes8.dex */
public interface Scheduler {
    boolean cancel();

    Requirements getSupportedRequirements(Requirements requirements);

    boolean schedule(Requirements requirements, String str, String str2);
}
