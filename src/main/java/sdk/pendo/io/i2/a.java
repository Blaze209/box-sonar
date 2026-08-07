package sdk.pendo.io.i2;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"\u0004\b\u0007\u0010\u001c¨\u0006 "}, d2 = {"Lsdk/pendo/io/i2/a;", "", "", "e", "Lsdk/pendo/io/i2/d;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/i2/d;)V", "", "toString", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "", "Z", "()Z", "cancelable", "c", "Lsdk/pendo/io/i2/d;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "d", "J", "()J", "(J)V", "nextExecuteNanoTime", "<init>", "(Ljava/lang/String;Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public abstract class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean cancelable;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private d queue;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private long nextExecuteNanoTime;

    public a(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getCancelable() {
        return this.cancelable;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getNextExecuteNanoTime() {
        return this.nextExecuteNanoTime;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final d getQueue() {
        return this.queue;
    }

    public abstract long e();

    public String toString() {
        return this.name;
    }

    public /* synthetic */ a(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final void a(d queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        d dVar = this.queue;
        if (dVar == queue) {
            return;
        }
        if (dVar != null) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.queue = queue;
    }

    public final void a(long j) {
        this.nextExecuteNanoTime = j;
    }
}
