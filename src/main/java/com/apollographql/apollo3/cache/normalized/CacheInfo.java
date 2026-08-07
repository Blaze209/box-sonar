package com.apollographql.apollo3.cache.normalized;

import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.exception.CacheMissException;
import com.pspdfkit.annotations.NoteAnnotation;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ClientCacheExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u000212B3\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nBC\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010/\u001a\u000200R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001dR\u0018\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010(R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010(R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0016¨\u00063"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/CacheInfo;", "Lcom/apollographql/apollo3/api/ExecutionContext$Element;", "millisStart", "", "millisEnd", "hit", "", "missedKey", "", "missedField", "(JJZLjava/lang/String;Ljava/lang/String;)V", "cacheStartMillis", "cacheEndMillis", "networkStartMillis", "networkEndMillis", "isCacheHit", "cacheMissException", "Lcom/apollographql/apollo3/exception/CacheMissException;", "networkException", "Lcom/apollographql/apollo3/exception/ApolloException;", "(JJJJZLcom/apollographql/apollo3/exception/CacheMissException;Lcom/apollographql/apollo3/exception/ApolloException;)V", "getCacheEndMillis", "()J", "getCacheMissException", "()Lcom/apollographql/apollo3/exception/CacheMissException;", "getCacheStartMillis", "getHit$annotations", "()V", "getHit", "()Z", "key", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "getKey", "()Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "getMillisEnd$annotations", "getMillisEnd", "getMillisStart$annotations", "getMillisStart", "getMissedField$annotations", "getMissedField", "()Ljava/lang/String;", "getMissedKey$annotations", "getMissedKey", "getNetworkEndMillis", "getNetworkException", "()Lcom/apollographql/apollo3/exception/ApolloException;", "getNetworkStartMillis", "newBuilder", "Lcom/apollographql/apollo3/cache/normalized/CacheInfo$Builder;", "Builder", NoteAnnotation.KEY, "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CacheInfo implements ExecutionContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long cacheEndMillis;
    private final CacheMissException cacheMissException;
    private final long cacheStartMillis;
    private final boolean isCacheHit;
    private final long networkEndMillis;
    private final ApolloException networkException;
    private final long networkStartMillis;

    public /* synthetic */ CacheInfo(long j, long j2, long j3, long j4, boolean z, CacheMissException cacheMissException, ApolloException apolloException, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, cacheMissException, apolloException);
    }

    @Deprecated(message = "Use cacheHit instead", replaceWith = @ReplaceWith(expression = "cacheHit", imports = {}))
    public static /* synthetic */ void getHit$annotations() {
    }

    @Deprecated(message = "Use cacheEndMillis instead", replaceWith = @ReplaceWith(expression = "cacheEndMillis", imports = {}))
    public static /* synthetic */ void getMillisEnd$annotations() {
    }

    @Deprecated(message = "Use cacheStartMillis instead", replaceWith = @ReplaceWith(expression = "cacheStartMillis", imports = {}))
    public static /* synthetic */ void getMillisStart$annotations() {
    }

    @Deprecated(message = "Use cacheMissException?.fieldName instead", replaceWith = @ReplaceWith(expression = "cacheMissException?.fieldName", imports = {}))
    public static /* synthetic */ void getMissedField$annotations() {
    }

    @Deprecated(message = "Use cacheMissException?.key instead", replaceWith = @ReplaceWith(expression = "cacheMissException?.key", imports = {}))
    public static /* synthetic */ void getMissedKey$annotations() {
    }

    private CacheInfo(long j, long j2, long j3, long j4, boolean z, CacheMissException cacheMissException, ApolloException apolloException) {
        this.cacheStartMillis = j;
        this.cacheEndMillis = j2;
        this.networkStartMillis = j3;
        this.networkEndMillis = j4;
        this.isCacheHit = z;
        this.cacheMissException = cacheMissException;
        this.networkException = apolloException;
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <R> R fold(R r, Function2<? super R, ? super ExecutionContext.Element, ? extends R> function2) {
        return (R) ExecutionContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <E extends ExecutionContext.Element> E get(ExecutionContext.Key<E> key) {
        return (E) ExecutionContext.Element.DefaultImpls.get(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext minusKey(ExecutionContext.Key<?> key) {
        return ExecutionContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext plus(ExecutionContext executionContext) {
        return ExecutionContext.Element.DefaultImpls.plus(this, executionContext);
    }

    public final long getCacheStartMillis() {
        return this.cacheStartMillis;
    }

    public final long getCacheEndMillis() {
        return this.cacheEndMillis;
    }

    public final long getNetworkStartMillis() {
        return this.networkStartMillis;
    }

    public final long getNetworkEndMillis() {
        return this.networkEndMillis;
    }

    public final boolean isCacheHit() {
        return this.isCacheHit;
    }

    public final CacheMissException getCacheMissException() {
        return this.cacheMissException;
    }

    public final ApolloException getNetworkException() {
        return this.networkException;
    }

    @Deprecated(message = "Use CacheInfo.Builder")
    public CacheInfo(long j, long j2, boolean z, String str, String str2) {
        this(j, j2, 0L, 0L, z, str != null ? new CacheMissException(str, str2) : null, null);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element
    public ExecutionContext.Key<?> getKey() {
        return INSTANCE;
    }

    public final long getMillisStart() {
        return this.cacheStartMillis;
    }

    public final long getMillisEnd() {
        return this.cacheEndMillis;
    }

    /* JADX INFO: renamed from: getHit, reason: from getter */
    public final boolean getIsCacheHit() {
        return this.isCacheHit;
    }

    public final String getMissedKey() {
        CacheMissException cacheMissException = this.cacheMissException;
        if (cacheMissException != null) {
            return cacheMissException.getKey();
        }
        return null;
    }

    public final String getMissedField() {
        CacheMissException cacheMissException = this.cacheMissException;
        if (cacheMissException != null) {
            return cacheMissException.getFieldName();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.CacheInfo$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/CacheInfo$Key;", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "Lcom/apollographql/apollo3/cache/normalized/CacheInfo;", "()V", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion implements ExecutionContext.Key<CacheInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Builder newBuilder() {
        return new Builder().cacheStartMillis(this.cacheStartMillis).cacheEndMillis(this.cacheEndMillis).networkStartMillis(this.networkStartMillis).networkEndMillis(this.networkEndMillis).cacheHit(this.isCacheHit).networkException(this.networkException);
    }

    /* JADX INFO: compiled from: ClientCacheExtensions.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/CacheInfo$Builder;", "", "()V", "cacheEndMillis", "", "cacheHit", "", "cacheMissException", "Lcom/apollographql/apollo3/exception/CacheMissException;", "cacheStartMillis", "networkEndMillis", "networkException", "Lcom/apollographql/apollo3/exception/ApolloException;", "networkStartMillis", "build", "Lcom/apollographql/apollo3/cache/normalized/CacheInfo;", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private long cacheEndMillis;
        private boolean cacheHit;
        private CacheMissException cacheMissException;
        private long cacheStartMillis;
        private long networkEndMillis;
        private ApolloException networkException;
        private long networkStartMillis;

        public final Builder cacheStartMillis(long cacheStartMillis) {
            this.cacheStartMillis = cacheStartMillis;
            return this;
        }

        public final Builder cacheEndMillis(long cacheEndMillis) {
            this.cacheEndMillis = cacheEndMillis;
            return this;
        }

        public final Builder networkStartMillis(long networkStartMillis) {
            this.networkStartMillis = networkStartMillis;
            return this;
        }

        public final Builder networkEndMillis(long networkEndMillis) {
            this.networkEndMillis = networkEndMillis;
            return this;
        }

        public final Builder cacheHit(boolean cacheHit) {
            this.cacheHit = cacheHit;
            return this;
        }

        public final Builder cacheMissException(CacheMissException cacheMissException) {
            this.cacheMissException = cacheMissException;
            return this;
        }

        public final Builder networkException(ApolloException networkException) {
            this.networkException = networkException;
            return this;
        }

        public final CacheInfo build() {
            return new CacheInfo(this.cacheStartMillis, this.cacheEndMillis, this.networkStartMillis, this.networkEndMillis, this.cacheHit, this.cacheMissException, this.networkException, null);
        }
    }
}
