package androidx.room.coroutines;

import android.database.SQLException;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConnectionPool.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*BQ\u0012@\u0010\u0003\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004j\b\u0012\u0002\b\u0003\u0018\u0001`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001b0\u0005H\u0096@¢\u0006\u0002\u0010 JK\u0010!\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\"\u001a\u00020\u00172-\u0010\u001e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b$H\u0096@¢\u0006\u0002\u0010%JK\u0010&\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\"\u001a\u00020\u00172-\u0010\u001e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b$H\u0082@¢\u0006\u0002\u0010%J\u000e\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)RM\u0010\u0003\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004j\b\u0012\u0002\b\u0003\u0018\u0001`\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011¨\u0006+"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "transactionWrapper", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "Landroidx/room/coroutines/TransactionWrapper;", "delegate", "Landroidx/sqlite/SQLiteConnection;", "<init>", "(Lkotlin/jvm/functions/Function2;Landroidx/sqlite/SQLiteConnection;)V", "getTransactionWrapper", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getDelegate", "()Landroidx/sqlite/SQLiteConnection;", "nestedTransactionCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/room/concurrent/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentTransactionType", "Landroidx/room/Transactor$SQLiteTransactionType;", "rawConnection", "getRawConnection", "usePrepared", "R", "sql", "", "block", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "type", "Landroidx/room/TransactionScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "inTransaction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PassthroughTransactor", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PassthroughConnection implements Transactor, RawConnectionAccessor {
    private Transactor.SQLiteTransactionType currentTransactionType;
    private final SQLiteConnection delegate;
    private AtomicInteger nestedTransactionCount;
    private final Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> transactionWrapper;

    /* JADX INFO: compiled from: PassthroughConnectionPool.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$transaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: PassthroughConnectionPool.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.PassthroughConnection", f = "PassthroughConnectionPool.kt", i = {0}, l = {127}, m = SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, n = {"success"}, s = {"I$0"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PassthroughConnection.this.transaction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$usePrepared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PassthroughConnectionPool.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.PassthroughConnection", f = "PassthroughConnectionPool.kt", i = {0, 0}, l = {89, 91}, m = "usePrepared", n = {"sql", "block"}, s = {"L$0", "L$1"})
    static final class C08441<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08441(Continuation<? super C08441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PassthroughConnection.this.usePrepared(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PassthroughConnection(Function2<? super Function1<? super Continuation<Object>, ? extends Object>, ? super Continuation<Object>, ? extends Object> function2, SQLiteConnection delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.transactionWrapper = function2;
        this.delegate = delegate;
        this.nestedTransactionCount = new AtomicInteger(0);
    }

    public final Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> getTransactionWrapper() {
        return this.transactionWrapper;
    }

    public final SQLiteConnection getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.room.PooledConnection
    public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) throws Exception {
        C08441 c08441;
        Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> function2;
        if (continuation instanceof C08441) {
            c08441 = (C08441) continuation;
            if ((c08441.label & Integer.MIN_VALUE) != 0) {
                c08441.label -= Integer.MIN_VALUE;
            } else {
                c08441 = new C08441(continuation);
            }
        } else {
            c08441 = new C08441(continuation);
        }
        Object objInTransaction = c08441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08441.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInTransaction);
            c08441.L$0 = str;
            c08441.L$1 = function1;
            c08441.label = 1;
            objInTransaction = inTransaction(c08441);
            if (objInTransaction != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objInTransaction);
            return objInTransaction;
        }
        function1 = (Function1) c08441.L$1;
        str = (String) c08441.L$0;
        ResultKt.throwOnFailure(objInTransaction);
        if (((Boolean) objInTransaction).booleanValue() && (function2 = this.transactionWrapper) != null) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, function1, null);
            c08441.L$0 = null;
            c08441.L$1 = null;
            c08441.label = 2;
            Object objInvoke = function2.invoke(anonymousClass2, c08441);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
        SQLiteStatement sQLiteStatementPrepare = this.delegate.prepare(str);
        try {
            R rInvoke = function1.invoke(sQLiteStatementPrepare);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            return rInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$usePrepared$2, reason: invalid class name */
    /* JADX INFO: compiled from: PassthroughConnectionPool.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.PassthroughConnection$usePrepared$2", f = "PassthroughConnectionPool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<SQLiteStatement, R> $block;
        final /* synthetic */ String $sql;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$sql = str;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PassthroughConnection.this.new AnonymousClass2(this.$sql, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SQLiteStatement sQLiteStatementPrepare = PassthroughConnection.this.getDelegate().prepare(this.$sql);
            try {
                Object objInvoke = this.$block.invoke(sQLiteStatementPrepare);
                AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
                return objInvoke;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(sQLiteStatementPrepare, th);
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        Function2<Function1<? super Continuation<Object>, ? extends Object>, Continuation<Object>, Object> function3 = this.transactionWrapper;
        if (function3 != null) {
            Object objInvoke = function3.invoke(new C08452(sQLiteTransactionType, function2, null), continuation);
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return objInvoke;
        }
        return transaction(sQLiteTransactionType, function2, continuation);
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.PassthroughConnection$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PassthroughConnectionPool.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.PassthroughConnection$withTransaction$2", f = "PassthroughConnectionPool.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    static final class C08452 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ Function2<TransactionScope<R>, Continuation<? super R>, Object> $block;
        final /* synthetic */ Transactor.SQLiteTransactionType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08452(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C08452> continuation) {
            super(1, continuation);
            this.$type = sQLiteTransactionType;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PassthroughConnection.this.new C08452(this.$type, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((C08452) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
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
            this.label = 1;
            Object objTransaction = PassthroughConnection.this.transaction(this.$type, this.$block, this);
            return objTransaction == coroutine_suspended ? coroutine_suspended : objTransaction;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:58:0x00c7 A[Catch: SQLException -> 0x00cf, TryCatch #1 {SQLException -> 0x00cf, blocks: (B:56:0x00bf, B:58:0x00c7, B:59:0x00c9), top: B:68:0x00bf }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <R> Object transaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ConnectionPool.RollbackException rollbackException;
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
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        int i2 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                int i3 = WhenMappings.$EnumSwitchMapping$0[sQLiteTransactionType.ordinal()];
                if (i3 == 1) {
                    SQLite.execSQL(this.delegate, "BEGIN DEFERRED TRANSACTION");
                } else if (i3 == 2) {
                    SQLite.execSQL(this.delegate, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    SQLite.execSQL(this.delegate, "BEGIN EXCLUSIVE TRANSACTION");
                }
                if (this.nestedTransactionCount.incrementAndGet() > 0) {
                    this.currentTransactionType = sQLiteTransactionType;
                }
                PassthroughTransactor passthroughTransactor = new PassthroughTransactor();
                anonymousClass1.I$0 = 1;
                anonymousClass1.label = 1;
                objInvoke = function2.invoke(passthroughTransactor, anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            if (this.nestedTransactionCount.decrementAndGet() == 0) {
                this.currentTransactionType = null;
            }
            if (i2 != 0) {
                SQLite.execSQL(this.delegate, "END TRANSACTION");
                return objInvoke;
            }
            SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            return objInvoke;
        } catch (Throwable th) {
            try {
                if (th instanceof ConnectionPool.RollbackException) {
                    Object result = th.getResult();
                    if (this.nestedTransactionCount.decrementAndGet() == 0) {
                        this.currentTransactionType = null;
                    }
                    SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
                    return result;
                }
                try {
                    throw th;
                } catch (Throwable th2) {
                    rollbackException = th;
                    th = th2;
                    if (this.nestedTransactionCount.decrementAndGet() == 0) {
                        this.currentTransactionType = null;
                    }
                    SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                rollbackException = null;
            }
            try {
                if (this.nestedTransactionCount.decrementAndGet() == 0) {
                    this.currentTransactionType = null;
                }
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } catch (SQLException e) {
                if (rollbackException == null) {
                    throw e;
                }
                ExceptionsKt.addSuppressed(rollbackException, e);
            }
            throw th;
        }
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.currentTransactionType != null || this.delegate.inTransaction());
    }

    /* JADX INFO: compiled from: PassthroughConnectionPool.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0096@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection$PassthroughTransactor;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", "<init>", "(Landroidx/room/coroutines/PassthroughConnection;)V", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", "block", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNestedTransaction", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollback", "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class PassthroughTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public PassthroughTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PassthroughConnection.this.getRawConnection();
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) {
            return PassthroughConnection.this.usePrepared(str, function1, continuation);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
            PassthroughConnection passthroughConnection = PassthroughConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = passthroughConnection.currentTransactionType;
            if (sQLiteTransactionType != null) {
                return passthroughConnection.transaction(sQLiteTransactionType, function2, continuation);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // androidx.room.TransactionScope
        public Object rollback(T t, Continuation<?> continuation) throws ConnectionPool.RollbackException {
            throw new ConnectionPool.RollbackException(t);
        }
    }
}
