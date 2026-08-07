package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0002R\u001a\u0010\f\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00070\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/s2/w;", "", "Lsdk/pendo/io/s2/v;", "b", "segment", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/concurrent/atomic/AtomicReference;", "", "I", "getMAX_SIZE", "()I", "MAX_SIZE", "c", "Lsdk/pendo/io/s2/v;", "LOCK", "d", "HASH_BUCKET_COUNT", "", "e", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class w {
    public static final w a = new w();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final int MAX_SIZE = 65536;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final v LOCK = new v(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final int HASH_BUCKET_COUNT;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final AtomicReference<v>[] hashBuckets;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        AtomicReference<v>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    private w() {
    }

    private final AtomicReference<v> a() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1))];
    }

    @JvmStatic
    public static final v b() {
        AtomicReference<v> atomicReferenceA = a.a();
        v vVar = LOCK;
        v andSet = atomicReferenceA.getAndSet(vVar);
        if (andSet == vVar) {
            return new v();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new v();
        }
        atomicReferenceA.set(andSet.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String);
        andSet.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = null;
        andSet.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = 0;
        return andSet;
    }

    @JvmStatic
    public static final void a(v segment) {
        AtomicReference<v> atomicReferenceA;
        v vVar;
        v andSet;
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String != null || segment.prev != null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.shared || (andSet = (atomicReferenceA = a.a()).getAndSet((vVar = LOCK))) == vVar) {
            return;
        }
        int i = andSet != null ? andSet.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String : 0;
        if (i >= MAX_SIZE) {
            atomicReferenceA.set(andSet);
            return;
        }
        segment.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String = andSet;
        segment.pos = 0;
        segment.com.box.androidsdk.content.models.BoxIterator.FIELD_LIMIT java.lang.String = i + 8192;
        atomicReferenceA.set(segment);
    }
}
