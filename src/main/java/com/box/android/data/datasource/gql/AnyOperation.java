package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.api.Executables;
import com.apollographql.apollo3.api.Query;
import com.box.android.data.api.models.adapters.graphql.GQLCustomScalarAdapters;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QueryDebouncer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/datasource/gql/AnyOperation;", "", SerializedNames.OPERATION, "", NativeAuthConstants.GrantType.ATTRIBUTES, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOperation", "()Ljava/lang/String;", "getAttributes", "equals", "", "other", "hashCode", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnyOperation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String attributes;
    private final String operation;

    public AnyOperation(String operation, String str) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.operation = operation;
        this.attributes = str;
    }

    public final String getAttributes() {
        return this.attributes;
    }

    public final String getOperation() {
        return this.operation;
    }

    /* JADX INFO: compiled from: QueryDebouncer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/datasource/gql/AnyOperation$Companion;", "", "<init>", "()V", "initWithQueryCall", "Lcom/box/android/data/datasource/gql/AnyOperation;", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "query", "Lcom/apollographql/apollo3/api/Query;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <D extends Query.Data> AnyOperation initWithQueryCall(Query<D> query) {
            String strVariablesJson;
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                strVariablesJson = Executables.variablesJson(query, GQLCustomScalarAdapters.INSTANCE.getCustomScalars());
            } catch (IOException unused) {
                strVariablesJson = null;
            }
            return new AnyOperation(query.document(), strVariablesJson);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AnyOperation) {
            AnyOperation anyOperation = (AnyOperation) other;
            if (Intrinsics.areEqual(this.operation, anyOperation.operation) && Intrinsics.areEqual(this.attributes, anyOperation.attributes)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.operation.hashCode();
        String str = this.attributes;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
