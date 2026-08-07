package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.pspdfkit.analytics.Analytics;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: GQLCache.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00110\u0013H\u0086H¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLCache;", "", "apolloClientConfigurator", "Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;", "<init>", "(Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex$annotations", "()V", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "apolloStore", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "getApolloStore", "()Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "apolloStoreWithLock", "R", Analytics.Data.ACTION, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCache {
    private final GQLApolloClientConfigurator apolloClientConfigurator;
    private final Mutex mutex;

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.GQLCache$apolloStoreWithLock$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCache.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.GQLCache", f = "GQLCache.kt", i = {0, 0, 0, 0}, l = {53}, m = "apolloStoreWithLock", n = {Analytics.Data.ACTION, "$this$withLock_u24default$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1<R> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCache.this.apolloStoreWithLock(null, this);
        }
    }

    public static /* synthetic */ void getMutex$annotations() {
    }

    @Inject
    public GQLCache(GQLApolloClientConfigurator apolloClientConfigurator) {
        Intrinsics.checkNotNullParameter(apolloClientConfigurator, "apolloClientConfigurator");
        this.apolloClientConfigurator = apolloClientConfigurator;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    public final Mutex getMutex() {
        return this.mutex;
    }

    public final ApolloStore getApolloStore() {
        ApolloClient apolloClient = this.apolloClientConfigurator.getApolloClient();
        if (apolloClient != null) {
            return NormalizedCache.getApolloStore(apolloClient);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <R> Object apolloStoreWithLock(Function1<? super ApolloStore, ? extends R> function1, Continuation<? super R> continuation) {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
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
            mutex = getMutex();
            anonymousClass1.L$0 = function1;
            anonymousClass1.L$1 = mutex;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 1;
            if (mutex.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            Mutex mutex2 = (Mutex) anonymousClass1.L$1;
            Function1<? super ApolloStore, ? extends R> function2 = (Function1) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            function1 = function2;
        }
        try {
            return function1.invoke(getApolloStore());
        } finally {
            mutex.unlock(null);
        }
    }

    private final <R> Object apolloStoreWithLock$$forInline(Function1<? super ApolloStore, ? extends R> function1, Continuation<? super R> continuation) {
        Mutex mutex = getMutex();
        mutex.lock(null, continuation);
        try {
            return function1.invoke(getApolloStore());
        } finally {
            mutex.unlock(null);
        }
    }
}
