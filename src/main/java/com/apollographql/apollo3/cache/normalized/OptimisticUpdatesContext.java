package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Mutation.Data;
import com.pspdfkit.annotations.NoteAnnotation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \r*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\rB\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/OptimisticUpdatesContext;", "D", "Lcom/apollographql/apollo3/api/Mutation$Data;", "Lcom/apollographql/apollo3/api/ExecutionContext$Element;", "value", "(Lcom/apollographql/apollo3/api/Mutation$Data;)V", "key", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "getKey", "()Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "getValue", "()Lcom/apollographql/apollo3/api/Mutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", NoteAnnotation.KEY, "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OptimisticUpdatesContext<D extends Mutation.Data> implements ExecutionContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final D value;

    public OptimisticUpdatesContext(D value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <R> R fold(R r, Function2<? super R, ? super ExecutionContext.Element, ? extends R> function2) {
        return (R) ExecutionContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <E extends ExecutionContext.Element> E get(ExecutionContext.Key<E> key) {
        return (E) ExecutionContext.Element.DefaultImpls.get(this, key);
    }

    public final D getValue() {
        return this.value;
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext minusKey(ExecutionContext.Key<?> key) {
        return ExecutionContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext plus(ExecutionContext executionContext) {
        return ExecutionContext.Element.DefaultImpls.plus(this, executionContext);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element
    public ExecutionContext.Key<?> getKey() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.OptimisticUpdatesContext$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/OptimisticUpdatesContext$Key;", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "Lcom/apollographql/apollo3/cache/normalized/OptimisticUpdatesContext;", "()V", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion implements ExecutionContext.Key<OptimisticUpdatesContext<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
