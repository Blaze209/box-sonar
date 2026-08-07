package sdk.pendo.io.r5;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0002\u0006\u0017B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0010J\u0013\u0010\u0006\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/r5/l;", "", "", "Lsdk/pendo/io/r5/l$a;", "clicks", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "x1", "y1", "x2", "y2", "x", "y", "", "timestamp", "(FFJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "", "b", "Ljava/util/List;", "clickBuffer", "<init>", "()V", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class l {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<a> clickBuffer = new ArrayList();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\n\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/r5/l$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "F", "b", "()F", "x", "c", "y", "", "J", "()J", "timestamp", "<init>", "(FFJ)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final float x;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final float y;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final long timestamp;

        public a(float f, float f2, long j) {
            this.x = f;
            this.y = f2;
            this.timestamp = j;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final float getY() {
            return this.y;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Float.compare(this.x, aVar.x) == 0 && Float.compare(this.y, aVar.y) == 0 && this.timestamp == aVar.timestamp;
        }

        public int hashCode() {
            return (((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "ClickEvent(x=" + this.x + ", y=" + this.y + ", timestamp=" + this.timestamp + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.analytics.RageClickDetector", f = "RageClickDetector.kt", i = {0, 0, 0, 0, 0}, l = {81}, m = "recordClick", n = {"this", "$this$withLock_u24default$iv", "x", "y", "timestamp"}, s = {"L$0", "L$1", "F$0", "F$1", "J$0"})
    static final class c extends ContinuationImpl {
        Object a;
        Object b;
        float c;
        float d;
        long e;
        /* synthetic */ Object f;
        int h;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return l.this.a(0.0f, 0.0f, 0L, this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.analytics.RageClickDetector", f = "RageClickDetector.kt", i = {0, 0}, l = {81}, m = "reset", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    static final class d extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return l.this.a(this);
        }
    }

    private final float a(float x1, float y1, float x2, float y2) {
        float f = x2 - x1;
        float f2 = y2 - y1;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private final boolean a(List<a> clicks) {
        if (clicks.size() != 4) {
            return false;
        }
        a aVar = clicks.get(0);
        int size = clicks.size();
        for (int i = 1; i < size; i++) {
            if (a(aVar.getX(), aVar.getY(), clicks.get(i).getX(), clicks.get(i).getY()) > 30.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(float f, float f2, long j, Continuation<? super Boolean> continuation) {
        c cVar;
        Mutex mutex;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.h = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.h;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            cVar.a = this;
            cVar.b = mutex;
            cVar.c = f;
            cVar.d = f2;
            cVar.e = j;
            cVar.h = 1;
            if (mutex.lock(null, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = cVar.e;
            f2 = cVar.d;
            f = cVar.c;
            Mutex mutex2 = (Mutex) cVar.b;
            l lVar = (l) cVar.a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = lVar;
        }
        try {
            a aVar = new a(f, f2, j);
            if (!this.clickBuffer.isEmpty() && j - ((a) CollectionsKt.last((List) this.clickBuffer)).getTimestamp() > 1000) {
                this.clickBuffer.clear();
            }
            this.clickBuffer.add(aVar);
            if (this.clickBuffer.size() > 4) {
                this.clickBuffer.remove(0);
            }
            if (this.a(this.clickBuffer)) {
                this.clickBuffer.clear();
            } else {
                z = false;
            }
            return Boxing.boxBoolean(z);
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation<? super Unit> continuation) {
        d dVar;
        Mutex mutex;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.e = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            dVar.a = this;
            dVar.b = mutex;
            dVar.e = 1;
            if (mutex.lock(null, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) dVar.b;
            l lVar = (l) dVar.a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = lVar;
        }
        try {
            this.clickBuffer.clear();
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}
