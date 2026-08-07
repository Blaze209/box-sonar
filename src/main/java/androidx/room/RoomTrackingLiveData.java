package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.hermes.intl.Constants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RoomTrackingLiveData.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001bH\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0000H¦@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002!\"¨\u0006#"}, d2 = {"Landroidx/room/RoomTrackingLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", TtmlNode.RUBY_CONTAINER, "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "tableNames", "", "", "<init>", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;Z[Ljava/lang/String;)V", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "observer", "Landroidx/room/InvalidationTracker$Observer;", Constants.COLLATION_INVALID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "computing", "registeredObserver", "launchContext", "Lkotlin/coroutines/CoroutineContext;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidated", "compute", "onActive", "onInactive", "Landroidx/room/RoomCallableTrackingLiveData;", "Landroidx/room/RoomLambdaTrackingLiveData;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class RoomTrackingLiveData<T> extends LiveData<T> {
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final CoroutineContext launchContext;
    private final InvalidationTracker.Observer observer;
    private final AtomicBoolean registeredObserver;

    /* JADX INFO: renamed from: androidx.room.RoomTrackingLiveData$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RoomTrackingLiveData.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomTrackingLiveData", f = "RoomTrackingLiveData.android.kt", i = {0}, l = {82}, m = "refresh", n = {"computed"}, s = {"I$0"})
    static final class C08401 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RoomTrackingLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08401(RoomTrackingLiveData<T> roomTrackingLiveData, Continuation<? super C08401> continuation) {
            super(continuation);
            this.this$0 = roomTrackingLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.refresh(this);
        }
    }

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(roomDatabase, invalidationLiveDataContainer, z, strArr);
    }

    public abstract Object compute(Continuation<? super T> continuation);

    protected final RoomDatabase getDatabase() {
        return this.database;
    }

    protected final boolean getInTransaction() {
        return this.inTransaction;
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, String[] strArr) {
        EmptyCoroutineContext queryContext;
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        if (!roomDatabase.inCompatibilityMode()) {
            queryContext = EmptyCoroutineContext.INSTANCE;
        } else if (z) {
            queryContext = roomDatabase.getTransactionContext$room_runtime();
        } else {
            queryContext = roomDatabase.getQueryContext();
        }
        this.launchContext = queryContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x0061 A[Catch: all -> 0x002d, Exception -> 0x002f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x0029, B:28:0x0061), top: B:45:0x0029, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x006c A[LOOP:0: B:26:0x0059->B:31:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:35:0x007a A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #1 {all -> 0x002d, blocks: (B:12:0x0029, B:26:0x0059, B:28:0x0061, B:35:0x007a, B:32:0x006e, B:33:0x0077), top: B:45:0x0029, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0057 -> B:26:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0089 -> B:40:0x008a). Please report as a decompilation issue!!! */
    public final Object refresh(Continuation<? super Unit> continuation) {
        C08401 c08401;
        int i;
        if (continuation instanceof C08401) {
            c08401 = (C08401) continuation;
            if ((c08401.label & Integer.MIN_VALUE) != 0) {
                c08401.label -= Integer.MIN_VALUE;
            } else {
                c08401 = new C08401(this, continuation);
            }
        } else {
            c08401 = new C08401(this, continuation);
        }
        Object objCompute = c08401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c08401.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCompute);
            if (this.registeredObserver.compareAndSet(false, true)) {
                this.database.getInvalidationTracker().addWeakObserver(this.observer);
            }
            if (this.computing.compareAndSet(false, true)) {
                objCompute = null;
                i = 0;
                while (this.invalid.compareAndSet(true, false)) {
                    c08401.I$0 = 1;
                    c08401.label = 1;
                    objCompute = compute(c08401);
                    if (objCompute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 1;
                }
                if (i != 0) {
                    postValue(objCompute);
                }
                this.computing.set(false);
            } else {
                i = 0;
            }
            if (i != 0) {
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = c08401.I$0;
        try {
            try {
                ResultKt.throwOnFailure(objCompute);
                while (this.invalid.compareAndSet(true, false)) {
                    c08401.I$0 = 1;
                    c08401.label = 1;
                    objCompute = compute(c08401);
                    if (objCompute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 1;
                }
                if (i != 0) {
                    postValue(objCompute);
                }
                this.computing.set(false);
                if (i != 0 || !this.invalid.get()) {
                    return Unit.INSTANCE;
                }
                if (this.computing.compareAndSet(false, true)) {
                    objCompute = null;
                    i = 0;
                    while (this.invalid.compareAndSet(true, false)) {
                        c08401.I$0 = 1;
                        c08401.label = 1;
                        objCompute = compute(c08401);
                        if (objCompute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 1;
                    }
                    if (i != 0) {
                        postValue(objCompute);
                    }
                    this.computing.set(false);
                } else {
                    i = 0;
                }
                if (i != 0) {
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                throw new RuntimeException("Exception while computing database live data.", e);
            }
        } catch (Throwable th) {
            this.computing.set(false);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidated() {
        boolean zHasActiveObservers = hasActiveObservers();
        if (this.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), this.launchContext, null, new AnonymousClass1(this, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomTrackingLiveData$invalidated$1, reason: invalid class name */
    /* JADX INFO: compiled from: RoomTrackingLiveData.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomTrackingLiveData$invalidated$1", f = "RoomTrackingLiveData.android.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RoomTrackingLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomTrackingLiveData<T> roomTrackingLiveData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomTrackingLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.refresh(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        this.container.onActive(this);
        BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), this.launchContext, null, new C08391(this, null), 2, null);
    }

    /* JADX INFO: renamed from: androidx.room.RoomTrackingLiveData$onActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RoomTrackingLiveData.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomTrackingLiveData$onActive$1", f = "RoomTrackingLiveData.android.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    static final class C08391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RoomTrackingLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08391(RoomTrackingLiveData<T> roomTrackingLiveData, Continuation<? super C08391> continuation) {
            super(2, continuation);
            this.this$0 = roomTrackingLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08391(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.refresh(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }
}
