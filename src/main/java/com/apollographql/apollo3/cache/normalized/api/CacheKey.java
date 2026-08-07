package com.apollographql.apollo3.cache.normalized.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CacheKey.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\"\u00020\u0003¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "", "typename", "", "values", "", "(Ljava/lang/String;Ljava/util/List;)V", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "key", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "serialize", "toString", "Companion", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CacheKey {
    private static final String SERIALIZATION_TEMPLATE = "ApolloCacheReference";
    private final String key;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex SERIALIZATION_REGEX_PATTERN = new Regex("ApolloCacheReference\\{(.*)\\}");
    private static final CacheKey ROOT_CACHE_KEY = new CacheKey("QUERY_ROOT");

    @JvmStatic
    public static final boolean canDeserialize(String str) {
        return INSTANCE.canDeserialize(str);
    }

    @JvmStatic
    public static final CacheKey deserialize(String str) {
        return INSTANCE.deserialize(str);
    }

    @JvmStatic
    public static final CacheKey rootKey() {
        return INSTANCE.rootKey();
    }

    public CacheKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    public final String getKey() {
        return this.key;
    }

    public CacheKey(String typename, List<String> values) {
        Intrinsics.checkNotNullParameter(typename, "typename");
        Intrinsics.checkNotNullParameter(values, "values");
        StringBuilder sb = new StringBuilder();
        sb.append(typename);
        sb.append(":");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this(string);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheKey(String typename, String... values) {
        this(typename, (List<String>) ArraysKt.toList(values));
        Intrinsics.checkNotNullParameter(typename, "typename");
        Intrinsics.checkNotNullParameter(values, "values");
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public boolean equals(Object other) {
        String str = this.key;
        CacheKey cacheKey = other instanceof CacheKey ? (CacheKey) other : null;
        return Intrinsics.areEqual(str, cacheKey != null ? cacheKey.key : null);
    }

    public String toString() {
        return "CacheKey(" + this.key + ')';
    }

    public final String serialize() {
        return "ApolloCacheReference{" + this.key + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: compiled from: CacheKey.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0007J)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0012\"\u00020\tH\u0007¢\u0006\u0002\u0010\u0013J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/CacheKey$Companion;", "", "()V", "ROOT_CACHE_KEY", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "SERIALIZATION_REGEX_PATTERN", "Lkotlin/text/Regex;", "getSERIALIZATION_REGEX_PATTERN$annotations", "SERIALIZATION_TEMPLATE", "", "canDeserialize", "", "value", "deserialize", "serializedCacheKey", TypedValues.TransitionType.S_FROM, "typename", "values", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "", "rootKey", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getSERIALIZATION_REGEX_PATTERN$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final CacheKey deserialize(String serializedCacheKey) {
            Intrinsics.checkNotNullParameter(serializedCacheKey, "serializedCacheKey");
            MatchResult matchResultMatchEntire = CacheKey.SERIALIZATION_REGEX_PATTERN.matchEntire(serializedCacheKey);
            List<String> groupValues = matchResultMatchEntire != null ? matchResultMatchEntire.getGroupValues() : null;
            if (groupValues == null || groupValues.size() <= 1) {
                throw new IllegalArgumentException(("Not a cache reference: " + serializedCacheKey + " Must be of the form: ApolloCacheReference{%s}").toString());
            }
            return new CacheKey(groupValues.get(1));
        }

        @JvmStatic
        public final boolean canDeserialize(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CacheKey.SERIALIZATION_REGEX_PATTERN.matches(value);
        }

        @JvmStatic
        public final CacheKey rootKey() {
            return CacheKey.ROOT_CACHE_KEY;
        }

        @Deprecated(message = "Use the constructor instead", replaceWith = @ReplaceWith(expression = "CacheKey(typename, values)", imports = {}))
        public final CacheKey from(String typename, List<String> values) {
            Intrinsics.checkNotNullParameter(typename, "typename");
            Intrinsics.checkNotNullParameter(values, "values");
            return new CacheKey(typename, values);
        }

        @Deprecated(message = "Use the constructor instead", replaceWith = @ReplaceWith(expression = "CacheKey(typename, values)", imports = {}))
        public final CacheKey from(String typename, String... values) {
            Intrinsics.checkNotNullParameter(typename, "typename");
            Intrinsics.checkNotNullParameter(values, "values");
            return new CacheKey(typename, (List<String>) ArraysKt.toList(values));
        }
    }
}
