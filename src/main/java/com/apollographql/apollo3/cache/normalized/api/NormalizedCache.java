package com.apollographql.apollo3.cache.normalized.api;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NormalizedCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000J\b\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H&J\u0010\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH&R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "Lcom/apollographql/apollo3/cache/normalized/api/ReadOnlyNormalizedCache;", "()V", "<set-?>", "nextCache", "getNextCache", "()Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "chain", SemanticAttributes.DbSystemValues.CACHE, "clearAll", "", "merge", "", "", "record", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "records", "", "remove", "", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "cascade", "", "pattern", "Companion", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class NormalizedCache implements ReadOnlyNormalizedCache {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String specialChars = "()^$.*?+{}";
    private NormalizedCache nextCache;

    @JvmStatic
    public static final String prettifyDump(Map<KClass<?>, ? extends Map<String, Record>> map) {
        return INSTANCE.prettifyDump(map);
    }

    public abstract void clearAll();

    public abstract Set<String> merge(Record record, CacheHeaders cacheHeaders);

    public abstract Set<String> merge(Collection<Record> records, CacheHeaders cacheHeaders);

    public abstract int remove(String pattern);

    public abstract boolean remove(CacheKey cacheKey, boolean cascade);

    public final NormalizedCache getNextCache() {
        return this.nextCache;
    }

    public final NormalizedCache chain(NormalizedCache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        NormalizedCache normalizedCache = this;
        while (true) {
            NormalizedCache normalizedCache2 = normalizedCache.nextCache;
            if (normalizedCache2 != null) {
                Intrinsics.checkNotNull(normalizedCache2);
                normalizedCache = normalizedCache2;
            } else {
                normalizedCache.nextCache = cache;
                return this;
            }
        }
    }

    /* JADX INFO: compiled from: NormalizedCache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J1\u0010\b\u001a\u00020\u00042'\u0010\t\u001a#\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u000b¢\u0006\u0002\b\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\n0\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache$Companion;", "", "()V", "specialChars", "", "patternToRegex", "Lkotlin/text/Regex;", "pattern", "prettifyDump", "dump", "", "Lkotlin/reflect/KClass;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String prettifyDump(Map<KClass<?>, ? extends Map<String, Record>> dump) {
            Intrinsics.checkNotNullParameter(dump, "dump");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<KClass<?>, ? extends Map<String, Record>> entry : dump.entrySet()) {
                KClass<?> key = entry.getKey();
                Map<String, Record> value = entry.getValue();
                sb.append(key.getSimpleName()).append(" {");
                for (Map.Entry<String, Record> entry2 : value.entrySet()) {
                    String key2 = entry2.getKey();
                    Record value2 = entry2.getValue();
                    sb.append("\n  \"").append(key2).append("\" : {");
                    for (Map.Entry<String, Object> entry3 : value2.getFields().entrySet()) {
                        String key3 = entry3.getKey();
                        Object value3 = entry3.getValue();
                        sb.append("\n    \"").append(key3).append("\" : ");
                        if (value3 instanceof CacheKey) {
                            sb.append(value3);
                        } else if (value3 instanceof List) {
                            sb.append("[");
                            Iterator it = ((List) value3).iterator();
                            while (it.hasNext()) {
                                sb.append("\n      ").append(it.next());
                            }
                            sb.append("\n    ]");
                        } else {
                            sb.append(value3);
                        }
                    }
                    sb.append("\n  }\n");
                }
                sb.append("}\n");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public final Regex patternToRegex(String pattern) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            StringBuilder sb = new StringBuilder();
            int length = pattern.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                char cCharAt = pattern.charAt(i);
                if (z) {
                    if (cCharAt == '\\') {
                        sb.append("\\\\");
                    } else if (cCharAt == '%') {
                        sb.append("%");
                    } else if (cCharAt == '_') {
                        sb.append("_");
                    } else {
                        throw new IllegalStateException(("Invalid escape in pattern: " + pattern).toString());
                    }
                } else if (cCharAt == '\\') {
                    z = true;
                } else if (cCharAt == '%') {
                    sb.append(".*");
                } else if (cCharAt != '_') {
                    if (StringsKt.contains$default((CharSequence) NormalizedCache.specialChars, cCharAt, false, 2, (Object) null)) {
                        sb.append("\\");
                    }
                    sb.append(cCharAt);
                } else {
                    sb.append(".");
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new Regex(string, RegexOption.IGNORE_CASE);
        }
    }
}
