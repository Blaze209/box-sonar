package com.apollographql.apollo3.cache.normalized.api;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheHeaders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0011\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0086\u0002J\b\u0010\u000f\u001a\u00020\fH\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "", "headerMap", "", "", "(Ljava/util/Map;)V", "hasHeader", "", "headerName", "headerValue", BoxAnalyticsParams.CTA_LOCATION_HEADER, "newBuilder", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders$Builder;", "plus", "cacheHeaders", "toBuilder", "Builder", "Companion", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CacheHeaders {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final CacheHeaders NONE = new CacheHeaders(MapsKt.emptyMap());
    private final Map<String, String> headerMap;

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public CacheHeaders(Map<String, String> headerMap) {
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        this.headerMap = headerMap;
    }

    /* JADX INFO: compiled from: CacheHeaders.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nJ\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders$Builder;", "", "()V", "headerMap", "", "", "addHeader", "headerName", "headerValue", "addHeaders", "", "build", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private final Map<String, String> headerMap = new LinkedHashMap();

        public final Builder addHeader(String headerName, String headerValue) {
            Intrinsics.checkNotNullParameter(headerName, "headerName");
            Intrinsics.checkNotNullParameter(headerValue, "headerValue");
            this.headerMap.put(headerName, headerValue);
            return this;
        }

        public final Builder addHeaders(Map<String, String> headerMap) {
            Intrinsics.checkNotNullParameter(headerMap, "headerMap");
            this.headerMap.putAll(headerMap);
            return this;
        }

        public final CacheHeaders build() {
            return new CacheHeaders(this.headerMap);
        }
    }

    @Deprecated(message = "Use newBuilder() instead", replaceWith = @ReplaceWith(expression = "newBuilder()", imports = {}))
    public final Builder toBuilder() {
        return newBuilder();
    }

    public final Builder newBuilder() {
        return INSTANCE.builder().addHeaders(this.headerMap);
    }

    public final String headerValue(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return this.headerMap.get(header);
    }

    public final boolean hasHeader(String headerName) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        return this.headerMap.containsKey(headerName);
    }

    /* JADX INFO: compiled from: CacheHeaders.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders$Companion;", "", "()V", "NONE", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "builder", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders$Builder;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    public final CacheHeaders plus(CacheHeaders cacheHeaders) {
        Intrinsics.checkNotNullParameter(cacheHeaders, "cacheHeaders");
        return newBuilder().addHeaders(cacheHeaders.headerMap).build();
    }
}
