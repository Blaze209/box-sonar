package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Fragment;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.pspdfkit.BuildConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: ApolloStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\t0\u000bH¦@¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J*\u0010\u0012\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00130\u0013H¦@¢\u0006\u0002\u0010\u0016JA\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0013\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\u0006\u0010\u001c\u001a\u0002H\u00182\u0006\u0010\u001d\u001a\u00020\u001eH&¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0002\u0010\"JB\u0010#\u001a\u0002H\u0018\"\b\b\u0000\u0010\u0018*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00180&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010)\u001a\u00020*H¦@¢\u0006\u0002\u0010+J:\u0010,\u001a\u0002H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010)\u001a\u00020*H¦@¢\u0006\u0002\u0010-J \u0010.\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010/\u001a\u00020\u000fH¦@¢\u0006\u0002\u00100J&\u0010.\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020(032\b\b\u0002\u0010/\u001a\u00020\u000fH¦@¢\u0006\u0002\u00104J*\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u00106\u001a\u000607j\u0002`82\b\b\u0002\u0010 \u001a\u00020\u000fH¦@¢\u0006\u0002\u00109JZ\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\"\b\b\u0000\u0010\u0018*\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00180&2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u0002H\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u000fH¦@¢\u0006\u0002\u0010<JR\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\u0006\u0010>\u001a\u0002H\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u000fH¦@¢\u0006\u0002\u0010?JT\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\u0006\u0010>\u001a\u0002H\u00182\n\u00106\u001a\u000607j\u0002`82\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u000fH¦@¢\u0006\u0002\u0010AR\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006B"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "", "changedKeys", "Lkotlinx/coroutines/flow/SharedFlow;", "", "", "getChangedKeys", "()Lkotlinx/coroutines/flow/SharedFlow;", "accessCache", "R", "block", "Lkotlin/Function1;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAll", "", "dispose", "", "dump", "", "Lkotlin/reflect/KClass;", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalize", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "data", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/util/Map;", "publish", "keys", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFragment", "Lcom/apollographql/apollo3/api/Fragment$Data;", BuildConfig.FLAVOR, "Lcom/apollographql/apollo3/api/Fragment;", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readOperation", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "cascade", "(Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cacheKeys", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollbackOptimisticUpdates", "mutationId", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "(Ljava/util/UUID;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFragment", "fragmentData", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/Fragment$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOperation", "operationData", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOptimisticUpdates", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Ljava/util/UUID;Lcom/apollographql/apollo3/api/CustomScalarAdapters;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ApolloStore {
    <R> Object accessCache(Function1<? super com.apollographql.apollo3.cache.normalized.api.NormalizedCache, ? extends R> function1, Continuation<? super R> continuation);

    boolean clearAll();

    void dispose();

    Object dump(Continuation<? super Map<KClass<?>, ? extends Map<String, Record>>> continuation);

    SharedFlow<Set<String>> getChangedKeys();

    <D extends Operation.Data> Map<String, Record> normalize(Operation<D> operation, D data, CustomScalarAdapters customScalarAdapters);

    Object publish(Set<String> set, Continuation<? super Unit> continuation);

    <D extends Fragment.Data> Object readFragment(Fragment<D> fragment, CacheKey cacheKey, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, Continuation<? super D> continuation);

    <D extends Operation.Data> Object readOperation(Operation<D> operation, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, Continuation<? super D> continuation);

    Object remove(CacheKey cacheKey, boolean z, Continuation<? super Boolean> continuation);

    Object remove(List<CacheKey> list, boolean z, Continuation<? super Integer> continuation);

    Object rollbackOptimisticUpdates(UUID uuid, boolean z, Continuation<? super Set<String>> continuation);

    <D extends Fragment.Data> Object writeFragment(Fragment<D> fragment, CacheKey cacheKey, D d, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, boolean z, Continuation<? super Set<String>> continuation);

    <D extends Operation.Data> Object writeOperation(Operation<D> operation, D d, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, boolean z, Continuation<? super Set<String>> continuation);

    <D extends Operation.Data> Object writeOptimisticUpdates(Operation<D> operation, D d, UUID uuid, CustomScalarAdapters customScalarAdapters, boolean z, Continuation<? super Set<String>> continuation);

    /* JADX INFO: compiled from: ApolloStore.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object readOperation$default(ApolloStore apolloStore, Operation operation, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readOperation");
            }
            if ((i & 2) != 0) {
                customScalarAdapters = CustomScalarAdapters.Empty;
            }
            if ((i & 4) != 0) {
                cacheHeaders = CacheHeaders.NONE;
            }
            return apolloStore.readOperation(operation, customScalarAdapters, cacheHeaders, continuation);
        }

        public static /* synthetic */ Object readFragment$default(ApolloStore apolloStore, Fragment fragment, CacheKey cacheKey, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readFragment");
            }
            if ((i & 4) != 0) {
                customScalarAdapters = CustomScalarAdapters.Empty;
            }
            CustomScalarAdapters customScalarAdapters2 = customScalarAdapters;
            if ((i & 8) != 0) {
                cacheHeaders = CacheHeaders.NONE;
            }
            return apolloStore.readFragment(fragment, cacheKey, customScalarAdapters2, cacheHeaders, continuation);
        }

        public static /* synthetic */ Object writeOperation$default(ApolloStore apolloStore, Operation operation, Operation.Data data, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeOperation");
            }
            if ((i & 4) != 0) {
                customScalarAdapters = CustomScalarAdapters.Empty;
            }
            CustomScalarAdapters customScalarAdapters2 = customScalarAdapters;
            if ((i & 8) != 0) {
                cacheHeaders = CacheHeaders.NONE;
            }
            CacheHeaders cacheHeaders2 = cacheHeaders;
            if ((i & 16) != 0) {
                z = true;
            }
            return apolloStore.writeOperation(operation, data, customScalarAdapters2, cacheHeaders2, z, continuation);
        }

        public static /* synthetic */ Object writeFragment$default(ApolloStore apolloStore, Fragment fragment, CacheKey cacheKey, Fragment.Data data, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeFragment");
            }
            if ((i & 8) != 0) {
                customScalarAdapters = CustomScalarAdapters.Empty;
            }
            CustomScalarAdapters customScalarAdapters2 = customScalarAdapters;
            if ((i & 16) != 0) {
                cacheHeaders = CacheHeaders.NONE;
            }
            CacheHeaders cacheHeaders2 = cacheHeaders;
            if ((i & 32) != 0) {
                z = true;
            }
            return apolloStore.writeFragment(fragment, cacheKey, data, customScalarAdapters2, cacheHeaders2, z, continuation);
        }

        public static /* synthetic */ Object writeOptimisticUpdates$default(ApolloStore apolloStore, Operation operation, Operation.Data data, UUID uuid, CustomScalarAdapters customScalarAdapters, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeOptimisticUpdates");
            }
            if ((i & 8) != 0) {
                customScalarAdapters = CustomScalarAdapters.Empty;
            }
            CustomScalarAdapters customScalarAdapters2 = customScalarAdapters;
            if ((i & 16) != 0) {
                z = true;
            }
            return apolloStore.writeOptimisticUpdates(operation, data, uuid, customScalarAdapters2, z, continuation);
        }

        public static /* synthetic */ Object rollbackOptimisticUpdates$default(ApolloStore apolloStore, UUID uuid, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rollbackOptimisticUpdates");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return apolloStore.rollbackOptimisticUpdates(uuid, z, continuation);
        }

        public static /* synthetic */ Object remove$default(ApolloStore apolloStore, CacheKey cacheKey, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return apolloStore.remove(cacheKey, z, (Continuation<? super Boolean>) continuation);
        }

        public static /* synthetic */ Object remove$default(ApolloStore apolloStore, List list, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return apolloStore.remove((List<CacheKey>) list, z, (Continuation<? super Integer>) continuation);
        }
    }
}
