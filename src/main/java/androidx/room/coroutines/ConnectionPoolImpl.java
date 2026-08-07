package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.box.android.common.utilities.BoxCommonConstants;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: ConnectionPoolImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ@\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010+\u001a\u00020\u001b2\"\u0010,\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0/\u0012\u0006\u0012\u0004\u0018\u0001000-H\u0096@¢\u0006\u0002\u00101J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u0002052\u0006\u0010+\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u000205H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", BoxCommonConstants.EXTRA_FILE_NAME, "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "maxNumOfReaders", "", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "connectionElementKey", "Landroidx/room/coroutines/ConnectionElementKey;", "connectionThreadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "", "()Z", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime", "()J", "setTimeout-LRDsOJo$room_runtime", "(J)V", "J", "onTimeout", "getOnTimeout$room_runtime", "()I", "setOnTimeout$room_runtime", "(I)V", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "", HeaderElements.CLOSE, "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final ConnectionElementKey connectionElementKey;
    private final ThreadLocal<PooledConnectionImpl> connectionThreadLocal;
    private final SQLiteDriver driver;
    private int onTimeout;
    private final Pool readers;
    private long timeout;
    private final Pool writers;

    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", i = {2, 2, 2, 2, 2, 3, 3}, l = {120, 124, Token.SET_REF_OP, Token.XMLATTR}, m = "useConnection", n = {"block", "pool", "connection", "currentContext", "isReadOnly", "pool", "connection"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, this);
        }
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    /* JADX INFO: renamed from: getTimeout-UwyO8pc$room_runtime, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* JADX INFO: renamed from: setTimeout-LRDsOJo$room_runtime, reason: not valid java name */
    public final void m10938setTimeoutLRDsOJo$room_runtime(long j) {
        this.timeout = j;
    }

    /* JADX INFO: renamed from: getOnTimeout$room_runtime, reason: from getter */
    public final int getOnTimeout() {
        return this.onTimeout;
    }

    public final void setOnTimeout$room_runtime(int i) {
        this.onTimeout = i;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.connectionElementKey = new ConnectionElementKey();
        this.connectionThreadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.onTimeout = 2;
        this.driver = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return driver.open(fileName);
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i, int i2) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.connectionElementKey = new ConnectionElementKey();
        this.connectionThreadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.onTimeout = 2;
        if (i <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Maximum number of writers must be greater than 0".toString());
        }
        this.driver = driver;
        this.readers = new Pool(i, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConnectionPoolImpl._init_$lambda$4(driver, fileName);
            }
        });
        this.writers = new Pool(i2, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return driver.open(fileName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection sQLiteConnectionOpen = sQLiteDriver.open(str);
        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
        return sQLiteConnectionOpen;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0139  */
    /* JADX WARN: Code duplicated, block: B:71:0x0145 A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #5 {all -> 0x018f, blocks: (B:64:0x012a, B:69:0x013a, B:71:0x0145, B:79:0x0183, B:80:0x018e), top: B:107:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0169  */
    /* JADX WARN: Code duplicated, block: B:77:0x0171  */
    /* JADX WARN: Code duplicated, block: B:79:0x0183 A[Catch: all -> 0x018f, TRY_ENTER, TryCatch #5 {all -> 0x018f, blocks: (B:64:0x012a, B:69:0x013a, B:71:0x0145, B:79:0x0183, B:80:0x018e), top: B:107:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, androidx.room.coroutines.PooledConnectionImpl] */
    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object useConnection(boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        AnonymousClass1 anonymousClass1;
        Pool pool;
        Ref.ObjectRef objectRef;
        Throwable th;
        Pool pool2;
        CoroutineContext coroutineContext;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function3;
        ConnectionElementKey connectionElementKey;
        Pool pool3;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        PooledConnectionImpl pooledConnectionImpl;
        final boolean z2 = z;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z3 = true;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i == 3) {
                z2 = anonymousClass1.Z$0;
                connectionElementKey = (ConnectionElementKey) anonymousClass1.L$5;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) anonymousClass1.L$4;
                CoroutineContext coroutineContext2 = (CoroutineContext) anonymousClass1.L$3;
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) anonymousClass1.L$2;
                pool3 = (Pool) anonymousClass1.L$1;
                function3 = (Function2) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    objectRef2 = objectRef4;
                    objectRef = objectRef5;
                    coroutineContext = coroutineContext2;
                    try {
                        ConnectionWithLock connectionWithLockMarkAcquired = ((ConnectionWithLock) objWithContext).markAcquired(coroutineContext);
                        if (this.readers != this.writers || !z2) {
                            z3 = false;
                        }
                        objectRef2.element = new PooledConnectionImpl(connectionElementKey, connectionWithLockMarkAcquired, z3);
                        if (objectRef.element != 0) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        CoroutineContext coroutineContextCreateConnectionContext = createConnectionContext((PooledConnectionImpl) objectRef.element);
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(function3, objectRef, null);
                        anonymousClass1.L$0 = pool3;
                        anonymousClass1.L$1 = objectRef;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 4;
                        objWithContext = BuildersKt.withContext(coroutineContextCreateConnectionContext, anonymousClass4, anonymousClass1);
                        if (objWithContext != coroutine_suspended) {
                            objectRef3 = objectRef;
                            pool2 = pool3;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        pool2 = pool3;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectRef = objectRef5;
                    pool2 = pool3;
                    throw th;
                }
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef3 = (Ref.ObjectRef) anonymousClass1.L$1;
            pool2 = (Pool) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objWithContext);
            } catch (Throwable th4) {
                objectRef = objectRef3;
                th = th4;
            }
            pooledConnectionImpl = (PooledConnectionImpl) objectRef3.element;
            if (pooledConnectionImpl != null) {
                pooledConnectionImpl.markRecycled();
                pooledConnectionImpl.getDelegate().markReleased();
                pool2.recycle(pooledConnectionImpl.getDelegate());
            }
            return objWithContext;
        }
        ResultKt.throwOnFailure(objWithContext);
        if (isClosed()) {
            SQLite.throwSQLiteException(21, "Connection pool is closed");
            throw new KotlinNothingValueException();
        }
        PooledConnectionImpl connectionWrapper = this.connectionThreadLocal.get();
        if (connectionWrapper == null) {
            ConnectionElement connectionElement = (ConnectionElement) anonymousClass1.get$context().get(this.connectionElementKey);
            connectionWrapper = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
        }
        if (connectionWrapper != null) {
            if (!z2 && connectionWrapper.getIsReadOnly()) {
                SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                throw new KotlinNothingValueException();
            }
            if (anonymousClass1.get$context().get(this.connectionElementKey) == null) {
                CoroutineContext coroutineContextCreateConnectionContext2 = createConnectionContext(connectionWrapper);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(function2, connectionWrapper, null);
                anonymousClass1.label = 1;
                Object objWithContext2 = BuildersKt.withContext(coroutineContextCreateConnectionContext2, anonymousClass2, anonymousClass1);
                if (objWithContext2 != coroutine_suspended) {
                    return objWithContext2;
                }
            } else {
                anonymousClass1.label = 2;
                Object objInvoke = function2.invoke(connectionWrapper, anonymousClass1);
                if (objInvoke != coroutine_suspended) {
                    return objInvoke;
                }
            }
        } else {
            if (z2) {
                pool = this.readers;
            } else {
                pool = this.writers;
            }
            objectRef = new Ref.ObjectRef();
            try {
                coroutineContext = anonymousClass1.get$context();
                ConnectionElementKey connectionElementKey2 = this.connectionElementKey;
                long j = this.timeout;
                Function0<Unit> function0 = new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConnectionPoolImpl.useConnection$lambda$6(this.f$0, z2);
                    }
                };
                anonymousClass1.L$0 = function2;
                anonymousClass1.L$1 = pool;
                anonymousClass1.L$2 = objectRef;
                anonymousClass1.L$3 = coroutineContext;
                anonymousClass1.L$4 = objectRef;
                anonymousClass1.L$5 = connectionElementKey2;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.label = 3;
                Object objM10939acquireWithTimeoutKLykuaI = pool.m10939acquireWithTimeoutKLykuaI(j, function0, anonymousClass1);
                if (objM10939acquireWithTimeoutKLykuaI != coroutine_suspended) {
                    function3 = function2;
                    connectionElementKey = connectionElementKey2;
                    pool3 = pool;
                    objWithContext = objM10939acquireWithTimeoutKLykuaI;
                    objectRef2 = objectRef;
                    ConnectionWithLock connectionWithLockMarkAcquired2 = ((ConnectionWithLock) objWithContext).markAcquired(coroutineContext);
                    if (this.readers != this.writers) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    objectRef2.element = new PooledConnectionImpl(connectionElementKey, connectionWithLockMarkAcquired2, z3);
                    if (objectRef.element != 0) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    CoroutineContext coroutineContextCreateConnectionContext3 = createConnectionContext((PooledConnectionImpl) objectRef.element);
                    AnonymousClass4 anonymousClass5 = new AnonymousClass4(function3, objectRef, null);
                    anonymousClass1.L$0 = pool3;
                    anonymousClass1.L$1 = objectRef;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 4;
                    objWithContext = BuildersKt.withContext(coroutineContextCreateConnectionContext3, anonymousClass5, anonymousClass1);
                    if (objWithContext != coroutine_suspended) {
                        objectRef3 = objectRef;
                        pool2 = pool3;
                        pooledConnectionImpl = (PooledConnectionImpl) objectRef3.element;
                        if (pooledConnectionImpl != null) {
                            pooledConnectionImpl.markRecycled();
                            pooledConnectionImpl.getDelegate().markReleased();
                            pool2.recycle(pooledConnectionImpl.getDelegate());
                        }
                        return objWithContext;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                pool2 = pool;
            }
        }
        return coroutine_suspended;
        try {
            throw th;
        } catch (Throwable th6) {
            try {
                PooledConnectionImpl pooledConnectionImpl2 = (PooledConnectionImpl) objectRef.element;
                if (pooledConnectionImpl2 == null) {
                    throw th6;
                }
                pooledConnectionImpl2.markRecycled();
                pooledConnectionImpl2.getDelegate().markReleased();
                pool2.recycle(pooledConnectionImpl2.getDelegate());
                throw th6;
            } catch (Throwable th7) {
                ExceptionsKt.addSuppressed(th, th7);
                throw th6;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ PooledConnectionImpl $confinedConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, PooledConnectionImpl pooledConnectionImpl, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$confinedConnection = pooledConnectionImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, this.$confinedConnection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function2<Transactor, Continuation<? super R>, Object> function2 = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object objInvoke = function2.invoke(pooledConnectionImpl, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useConnection$lambda$6(ConnectionPoolImpl connectionPoolImpl, boolean z) {
        connectionPoolImpl.onTimeout(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$4, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", i = {}, l = {Token.XMLATTR}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ Ref.ObjectRef<PooledConnectionImpl> $connection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Ref.ObjectRef<PooledConnectionImpl> objectRef, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$connection = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$block, this.$connection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.room.coroutines.ConnectionPoolImpl$useConnection$4<R> for r3v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                return r4
            Lf:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function2<androidx.room.Transactor, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r3.$block
                kotlin.jvm.internal.Ref$ObjectRef<androidx.room.coroutines.PooledConnectionImpl> r1 = r3.$connection
                T r1 = r1.element
                r3.label = r2
                java.lang.Object r3 = r4.invoke(r1, r3)
                if (r3 != r0) goto L29
                return r0
            L29:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl connection) {
        return new ConnectionElement(this.connectionElementKey, connection).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.connectionThreadLocal, connection));
    }

    private final void onTimeout(boolean isReadOnly) {
        String str = isReadOnly ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.").append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:").append('\n');
        this.readers.dump(sb);
        try {
            SQLite.throwSQLiteException(5, sb.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e) {
            int i = this.onTimeout;
            if (i == 1) {
                throw e;
            }
            if (i != 2) {
                return;
            }
            e.printStackTrace();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }
}
