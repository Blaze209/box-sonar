package androidx.room.coroutines;

import androidx.collection.CircularArray;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: ConnectionPoolImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005H\u0086@¢\u0006\u0004\b!\u0010\"J\u000e\u0010#\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020 H\u0002J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020 J\u0012\u0010)\u001a\u00020 2\n\u0010*\u001a\u00060+j\u0002`,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/room/coroutines/Pool;", "", "capacity", "", "connectionFactory", "Lkotlin/Function0;", "Landroidx/sqlite/SQLiteConnection;", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "getCapacity", "()I", "getConnectionFactory", "()Lkotlin/jvm/functions/Function0;", BoxFile.FIELD_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "size", "isClosed", "", "connections", "", "Landroidx/room/coroutines/ConnectionWithLock;", "[Landroidx/room/coroutines/ConnectionWithLock;", "connectionPermits", "Lkotlinx/coroutines/sync/Semaphore;", "availableConnections", "Landroidx/collection/CircularArray;", "acquireWithTimeout", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Lkotlin/time/Duration;", "onTimeout", "", "acquireWithTimeout-KLykuaI", "(JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOpenNewConnectionLocked", "recycle", "connection", HeaderElements.CLOSE, "dump", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class Pool {
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;
    private final Function0<SQLiteConnection> connectionFactory;
    private final Semaphore connectionPermits;
    private final ConnectionWithLock[] connections;
    private boolean isClosed;
    private final ReentrantLock lock;
    private int size;

    /* JADX INFO: renamed from: androidx.room.coroutines.Pool$acquire$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", i = {}, l = {236}, m = "acquire", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pool.this.acquire(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Pool(int i, Function0<? extends SQLiteConnection> connectionFactory) {
        Intrinsics.checkNotNullParameter(connectionFactory, "connectionFactory");
        this.capacity = i;
        this.connectionFactory = connectionFactory;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i];
        this.connectionPermits = SemaphoreKt.Semaphore$default(i, 0, 2, null);
        this.availableConnections = new CircularArray<>(i);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final Function0<SQLiteConnection> getConnectionFactory() {
        return this.connectionFactory;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072 A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x006e, B:30:0x0072, B:32:0x0078, B:34:0x007c, B:37:0x0081), top: B:43:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0076  */
    /* JADX WARN: Code duplicated, block: B:32:0x0078 A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x006e, B:30:0x0072, B:32:0x0078, B:34:0x007c, B:37:0x0081), top: B:43:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:34:0x007c A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x006e, B:30:0x0072, B:32:0x0078, B:34:0x007c, B:37:0x0081), top: B:43:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0081 A[Catch: all -> 0x0082, TRY_LEAVE, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x006e, B:30:0x0072, B:32:0x0078, B:34:0x007c, B:37:0x0081), top: B:43:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:24:0x005f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x005d
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: acquireWithTimeout-KLykuaI, reason: not valid java name */
    public final java.lang.Object m10939acquireWithTimeoutKLykuaI(long r8, kotlin.jvm.functions.Function0<kotlin.Unit> r10, kotlin.coroutines.Continuation<? super androidx.room.coroutines.ConnectionWithLock> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r7, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L35
            goto L5f
        L35:
            r11 = move-exception
            goto L69
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.ResultKt.throwOnFailure(r11)
        L42:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            androidx.room.coroutines.Pool$acquireWithTimeout$2 r2 = new androidx.room.coroutines.Pool$acquireWithTimeout$2     // Catch: java.lang.Throwable -> L64
            r2.<init>(r11, r7, r4)     // Catch: java.lang.Throwable -> L64
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch: java.lang.Throwable -> L64
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L64
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L64
            r0.J$0 = r8     // Catch: java.lang.Throwable -> L64
            r0.label = r3     // Catch: java.lang.Throwable -> L64
            java.lang.Object r2 = kotlinx.coroutines.TimeoutKt.m16319withTimeoutKLykuaI(r8, r2, r0)     // Catch: java.lang.Throwable -> L64
            if (r2 != r1) goto L5d
            return r1
        L5d:
            r2 = r10
            r10 = r11
        L5f:
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r4
            goto L6e
        L64:
            r2 = move-exception
            r6 = r2
            r2 = r10
            r10 = r11
            r11 = r6
        L69:
            r6 = r11
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r6
        L6e:
            boolean r5 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L82
            if (r5 == 0) goto L76
            r10.invoke()     // Catch: java.lang.Throwable -> L82
            goto L7f
        L76:
            if (r0 != 0) goto L81
            T r0 = r11.element     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L7f
            T r7 = r11.element     // Catch: java.lang.Throwable -> L82
            return r7
        L7f:
            r0 = r2
            goto L42
        L81:
            throw r0     // Catch: java.lang.Throwable -> L82
        L82:
            r8 = move-exception
            T r9 = r11.element
            androidx.room.coroutines.ConnectionWithLock r9 = (androidx.room.coroutines.ConnectionWithLock) r9
            if (r9 == 0) goto L8c
            r7.recycle(r9)
        L8c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.m10939acquireWithTimeoutKLykuaI(long, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object acquire(Continuation<? super ConnectionWithLock> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore semaphore = this.connectionPermits;
            anonymousClass1.label = 1;
            if (semaphore.acquire(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        try {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.isClosed) {
                    SQLite.throwSQLiteException(21, "Connection pool is closed");
                    throw new KotlinNothingValueException();
                }
                if (this.availableConnections.isEmpty()) {
                    tryOpenNewConnectionLocked();
                }
                ConnectionWithLock connectionWithLockPopFirst = this.availableConnections.popFirst();
                reentrantLock.unlock();
                return connectionWithLockPopFirst;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.connectionPermits.release();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock(this.connectionFactory.invoke(), null, 2, 0 == true ? 1 : 0);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i = this.size;
        this.size = i + 1;
        connectionWithLockArr[i] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    public final void recycle(ConnectionWithLock connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connection);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void dump(StringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int size = this.availableConnections.size();
            for (int i = 0; i < size; i++) {
                listCreateListBuilder.add(this.availableConnections.get(i));
            }
            List listBuild = CollectionsKt.build(listCreateListBuilder);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.capacity + ", ");
            builder.append("permits=" + this.connectionPermits.getAvailablePermits() + ", ");
            builder.append("queue=(size=" + listBuild.size() + ")[" + CollectionsKt.joinToString$default(listBuild, null, null, null, 0, null, null, 63, null) + AbstractJsonLexerKt.END_LIST);
            builder.append(")").append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i3];
                i2++;
                builder.append("\t\t[" + i2 + "] - " + (connectionWithLock != null ? connectionWithLock.toString() : null)).append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(builder);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
