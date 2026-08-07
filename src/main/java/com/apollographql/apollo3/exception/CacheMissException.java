package com.apollographql.apollo3.exception;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/apollographql/apollo3/exception/CacheMissException;", "Lcom/apollographql/apollo3/exception/ApolloException;", "key", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "stale", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getFieldName", "()Ljava/lang/String;", "getKey", "getStale$annotations", "()V", "getStale", "()Z", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CacheMissException extends ApolloException {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String fieldName;
    private final String key;
    private final boolean stale;

    public static /* synthetic */ void getStale$annotations() {
    }

    public /* synthetic */ CacheMissException(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheMissException(String key, String str, boolean z) {
        super(INSTANCE.message$apollo_api(key, str, z), null, 2, null);
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.fieldName = str;
        this.stale = z;
    }

    public final boolean getStale() {
        return this.stale;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheMissException(String key, String str) {
        this(key, str, false);
        Intrinsics.checkNotNullParameter(key, "key");
    }

    /* JADX INFO: compiled from: Exceptions.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007J)\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/apollographql/apollo3/exception/CacheMissException$Companion;", "", "()V", "message", "", "key", "fieldName", "stale", "", "message$apollo_api", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String message$apollo_api(String key, String fieldName, boolean stale) {
            if (fieldName == null) {
                return "Object '" + key + "' not found";
            }
            if (stale) {
                return "Field '" + fieldName + "' on object '" + key + "' is stale";
            }
            return "Object '" + key + "' has no field named '" + fieldName + '\'';
        }

        @Deprecated(message = "Use CacheMissException.message instead")
        public final String message(String key, String fieldName) {
            return message$apollo_api(key, fieldName, false);
        }
    }
}
