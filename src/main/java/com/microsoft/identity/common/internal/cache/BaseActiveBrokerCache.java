package com.microsoft.identity.common.internal.cache;

import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/BaseActiveBrokerCache;", "Lcom/microsoft/identity/common/internal/cache/IActiveBrokerCache;", "storage", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "", BoxFile.FIELD_LOCK, "Lkotlinx/coroutines/sync/Mutex;", "(Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;Lkotlinx/coroutines/sync/Mutex;)V", "clearCachedActiveBroker", "", "getCachedActiveBroker", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "setCachedActiveBroker", "brokerData", "setCachedActiveBrokerWithoutLock", "setShouldUseAccountManagerForTheNextMilliseconds", "timeInMillis", "", "shouldUseAccountManager", "", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseActiveBrokerCache implements IActiveBrokerCache {
    public static final String ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY = "ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY";
    public static final String ACTIVE_BROKER_CACHE_SIGHASH_KEY = "ACTIVE_BROKER_CACHE_SIGHASH_KEY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY = "SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY";
    private final Mutex lock;
    private final INameValueStorage<String> storage;

    public BaseActiveBrokerCache(INameValueStorage<String> storage, Mutex lock) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.storage = storage;
        this.lock = lock;
    }

    /* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/BaseActiveBrokerCache$Companion;", "", "()V", BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY, "", BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_SIGHASH_KEY, BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY, "isNotExpired", "", "expiryDate", "", "(Ljava/lang/Long;)Z", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isNotExpired(Long expiryDate) {
            return expiryDate != null && System.currentTimeMillis() < expiryDate.longValue();
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$getCachedActiveBroker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$getCachedActiveBroker$1", f = "BaseActiveBrokerCache.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C18101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C18101(Continuation<? super C18101> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C18101(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrokerData> continuation) {
            return ((C18101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BaseActiveBrokerCache.this.lock;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex2;
                this.L$1 = baseActiveBrokerCache2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                baseActiveBrokerCache = baseActiveBrokerCache2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                String str2 = (String) baseActiveBrokerCache.storage.get(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY);
                String str3 = (String) baseActiveBrokerCache.storage.get(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_SIGHASH_KEY);
                String str4 = str2;
                if (str4 != null && str4.length() != 0 && (str = str3) != null && str.length() != 0) {
                    return new BrokerData(str2, str3);
                }
                return null;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public BrokerData getCachedActiveBroker() {
        return (BrokerData) BuildersKt__BuildersKt.runBlocking$default(null, new C18101(null), 1, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$shouldUseAccountManager$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$shouldUseAccountManager$1", f = "BaseActiveBrokerCache.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C18131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C18131(Continuation<? super C18131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C18131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C18131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BaseActiveBrokerCache.this.lock;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex2;
                this.L$1 = baseActiveBrokerCache2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                baseActiveBrokerCache = baseActiveBrokerCache2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                String rawValue = (String) baseActiveBrokerCache.storage.get(BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY);
                if (rawValue != null) {
                    Intrinsics.checkNotNullExpressionValue(rawValue, "rawValue");
                    Long longOrNull = StringsKt.toLongOrNull(rawValue);
                    if (longOrNull != null) {
                        return Boxing.boxBoolean(BaseActiveBrokerCache.INSTANCE.isNotExpired(Boxing.boxLong(longOrNull.longValue())));
                    }
                }
                return Boxing.boxBoolean(false);
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public boolean shouldUseAccountManager() {
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new C18131(null), 1, null)).booleanValue();
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setShouldUseAccountManagerForTheNextMilliseconds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setShouldUseAccountManagerForTheNextMilliseconds$1", f = "BaseActiveBrokerCache.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C18121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $timeInMillis;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18121(long j, Continuation<? super C18121> continuation) {
            super(2, continuation);
            this.$timeInMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C18121(this.$timeInMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BaseActiveBrokerCache.this.lock;
                long j2 = this.$timeInMillis;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex2;
                this.L$1 = baseActiveBrokerCache2;
                this.J$0 = j2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                baseActiveBrokerCache = baseActiveBrokerCache2;
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                baseActiveBrokerCache.storage.put(BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY, String.valueOf(System.currentTimeMillis() + j));
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public void setShouldUseAccountManagerForTheNextMilliseconds(long timeInMillis) throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new C18121(timeInMillis, null), 1, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setCachedActiveBroker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$setCachedActiveBroker$1", f = "BaseActiveBrokerCache.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C18111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BrokerData $brokerData;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18111(BrokerData brokerData, Continuation<? super C18111> continuation) {
            super(2, continuation);
            this.$brokerData = brokerData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new C18111(this.$brokerData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BaseActiveBrokerCache baseActiveBrokerCache;
            Mutex mutex;
            BrokerData brokerData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BaseActiveBrokerCache.this.lock;
                baseActiveBrokerCache = BaseActiveBrokerCache.this;
                BrokerData brokerData2 = this.$brokerData;
                this.L$0 = mutex2;
                this.L$1 = baseActiveBrokerCache;
                this.L$2 = brokerData2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                brokerData = brokerData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                brokerData = (BrokerData) this.L$2;
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                baseActiveBrokerCache.setCachedActiveBrokerWithoutLock(brokerData);
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public void setCachedActiveBroker(BrokerData brokerData) throws InterruptedException {
        Intrinsics.checkNotNullParameter(brokerData, "brokerData");
        BuildersKt__BuildersKt.runBlocking$default(null, new C18111(brokerData, null), 1, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$clearCachedActiveBroker$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseActiveBrokerCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.cache.BaseActiveBrokerCache$clearCachedActiveBroker$1", f = "BaseActiveBrokerCache.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActiveBrokerCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BaseActiveBrokerCache baseActiveBrokerCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BaseActiveBrokerCache.this.lock;
                BaseActiveBrokerCache baseActiveBrokerCache2 = BaseActiveBrokerCache.this;
                this.L$0 = mutex2;
                this.L$1 = baseActiveBrokerCache2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                baseActiveBrokerCache = baseActiveBrokerCache2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                baseActiveBrokerCache = (BaseActiveBrokerCache) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                baseActiveBrokerCache.storage.remove(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY);
                baseActiveBrokerCache.storage.remove(BaseActiveBrokerCache.ACTIVE_BROKER_CACHE_SIGHASH_KEY);
                baseActiveBrokerCache.storage.remove(BaseActiveBrokerCache.SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY);
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IActiveBrokerCache
    public void clearCachedActiveBroker() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    protected void setCachedActiveBrokerWithoutLock(BrokerData brokerData) {
        Intrinsics.checkNotNullParameter(brokerData, "brokerData");
        this.storage.put(ACTIVE_BROKER_CACHE_PACKAGE_NAME_KEY, brokerData.getPackageName());
        this.storage.put(ACTIVE_BROKER_CACHE_SIGHASH_KEY, brokerData.getSigningCertificateThumbprint());
        this.storage.remove(SHOULD_USE_ACCOUNT_MANAGER_UNTIL_EPOCH_MILLISECONDS_KEY);
    }
}
