package com.box.android.data.datasource;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.exception.ApolloCompositeException;
import com.apollographql.apollo3.exception.ApolloNetworkException;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: GQLErrorUtil.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000b\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/datasource/GQLErrorUtil;", "", "<init>", "()V", "GQL_FIELD_CODE", "", "GQL_FIELD_ERROR_CODE", "graphQLErrorMap", "", "Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorModel;", "Lcom/box/android/data/datasource/errors/RemoteError;", "getRemoteError", "gqlApolloError", "Lcom/apollographql/apollo3/api/Error;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "GQLCode", "GQLErrorCode", "GQLErrorModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLErrorUtil {
    private static final String GQL_FIELD_CODE = "code";
    private static final String GQL_FIELD_ERROR_CODE = "errorCode";
    public static final GQLErrorUtil INSTANCE = new GQLErrorUtil();
    private static final Map<GQLErrorModel, RemoteError> graphQLErrorMap = MapsKt.mapOf(TuplesKt.to(new GQLErrorModel(GQLCode.BAD_USER_INPUT, GQLErrorCode.BAD_REQUEST), new RemoteError.BadRequest(null, 1, null)), TuplesKt.to(new GQLErrorModel(GQLCode.CONFLICT, GQLErrorCode.CONFLICT), new RemoteError.Conflict()), TuplesKt.to(new GQLErrorModel(GQLCode.NOT_FOUND, GQLErrorCode.AGENTS_FETCH_FAILED), new RemoteError.Unauthorized(null, 1, null)));

    private GQLErrorUtil() {
    }

    /* JADX INFO: compiled from: GQLErrorUtil.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/box/android/data/datasource/GQLErrorUtil$GQLCode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BAD_USER_INPUT", "CONFLICT", "UNKNOWN", "NOT_FOUND", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum GQLCode {
        BAD_USER_INPUT("BAD_USER_INPUT"),
        CONFLICT("CONFLICT"),
        UNKNOWN("__UNKNOWN__"),
        NOT_FOUND("Not Found");

        private final String value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<GQLCode> getEntries() {
            return $ENTRIES;
        }

        GQLCode(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: GQLErrorUtil.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/datasource/GQLErrorUtil$GQLCode$Companion;", "", "<init>", "()V", "safeValueOf", "Lcom/box/android/data/datasource/GQLErrorUtil$GQLCode;", "value", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final GQLCode safeValueOf(String value) {
                GQLCode next;
                Iterator<GQLCode> it = GQLCode.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.getValue(), value));
                GQLCode gQLCode = next;
                return gQLCode == null ? GQLCode.UNKNOWN : gQLCode;
            }
        }
    }

    /* JADX INFO: compiled from: GQLErrorUtil.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BAD_REQUEST", "CONFLICT", "UNKNOWN", "AGENTS_FETCH_FAILED", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum GQLErrorCode {
        BAD_REQUEST("Bad Request"),
        CONFLICT("Conflict"),
        UNKNOWN("__UNKNOWN__"),
        AGENTS_FETCH_FAILED("ai_agents_fetch_failed");

        private final String value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<GQLErrorCode> getEntries() {
            return $ENTRIES;
        }

        GQLErrorCode(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: GQLErrorUtil.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorCode$Companion;", "", "<init>", "()V", "safeValueOf", "Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorCode;", "value", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final GQLErrorCode safeValueOf(String value) {
                GQLErrorCode next;
                Iterator<GQLErrorCode> it = GQLErrorCode.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.getValue(), value));
                GQLErrorCode gQLErrorCode = next;
                return gQLErrorCode == null ? GQLErrorCode.UNKNOWN : gQLErrorCode;
            }
        }
    }

    /* JADX INFO: compiled from: GQLErrorUtil.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorModel;", "", "code", "Lcom/box/android/data/datasource/GQLErrorUtil$GQLCode;", "errorCode", "Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorCode;", "<init>", "(Lcom/box/android/data/datasource/GQLErrorUtil$GQLCode;Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorCode;)V", "getCode", "()Lcom/box/android/data/datasource/GQLErrorUtil$GQLCode;", "getErrorCode", "()Lcom/box/android/data/datasource/GQLErrorUtil$GQLErrorCode;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GQLErrorModel {
        private final GQLCode code;
        private final GQLErrorCode errorCode;

        public static /* synthetic */ GQLErrorModel copy$default(GQLErrorModel gQLErrorModel, GQLCode gQLCode, GQLErrorCode gQLErrorCode, int i, Object obj) {
            if ((i & 1) != 0) {
                gQLCode = gQLErrorModel.code;
            }
            if ((i & 2) != 0) {
                gQLErrorCode = gQLErrorModel.errorCode;
            }
            return gQLErrorModel.copy(gQLCode, gQLErrorCode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GQLCode getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GQLErrorCode getErrorCode() {
            return this.errorCode;
        }

        public final GQLErrorModel copy(GQLCode code, GQLErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            return new GQLErrorModel(code, errorCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GQLErrorModel)) {
                return false;
            }
            GQLErrorModel gQLErrorModel = (GQLErrorModel) other;
            return this.code == gQLErrorModel.code && this.errorCode == gQLErrorModel.errorCode;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.errorCode.hashCode();
        }

        public String toString() {
            return "GQLErrorModel(code=" + this.code + ", errorCode=" + this.errorCode + ")";
        }

        public GQLErrorModel(GQLCode code, GQLErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            this.code = code;
            this.errorCode = errorCode;
        }

        public final GQLCode getCode() {
            return this.code;
        }

        public final GQLErrorCode getErrorCode() {
            return this.errorCode;
        }
    }

    public final RemoteError getRemoteError(Error gqlApolloError) {
        Intrinsics.checkNotNullParameter(gqlApolloError, "gqlApolloError");
        Map<String, Object> extensions = gqlApolloError.getExtensions();
        if (extensions == null) {
            return new RemoteError.Unknown(-1, "GraphQL error missing extensions: " + gqlApolloError.getMessage());
        }
        GQLCode.Companion companion = GQLCode.INSTANCE;
        Object obj = extensions.get("code");
        GQLCode gQLCodeSafeValueOf = companion.safeValueOf(obj instanceof String ? (String) obj : null);
        GQLErrorCode.Companion companion2 = GQLErrorCode.INSTANCE;
        Object obj2 = extensions.get("errorCode");
        RemoteError remoteError = graphQLErrorMap.get(new GQLErrorModel(gQLCodeSafeValueOf, companion2.safeValueOf(obj2 instanceof String ? (String) obj2 : null)));
        return remoteError == null ? new RemoteError.Unknown(-1, gqlApolloError.getMessage()) : remoteError;
    }

    public final RemoteError getRemoteError(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (!(exception instanceof ApolloNetworkException)) {
            if (exception instanceof ApolloCompositeException) {
                List<Throwable> suppressedExceptions = ExceptionsKt.getSuppressedExceptions(exception);
                if (!(suppressedExceptions instanceof Collection) || !suppressedExceptions.isEmpty()) {
                    Iterator<T> it = suppressedExceptions.iterator();
                    while (it.hasNext()) {
                        if (((Throwable) it.next()) instanceof ApolloNetworkException) {
                        }
                    }
                }
            }
            return new RemoteError.Unknown(-1, Reflection.getOrCreateKotlinClass(exception.getClass()).getSimpleName() + " " + exception.getMessage());
        }
        return RemoteError.NetworkError.INSTANCE;
    }
}
