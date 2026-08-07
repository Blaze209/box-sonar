package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.api.Operation;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLOperationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLOperationDTO;", "", "data", "Lcom/apollographql/apollo3/api/Operation$Data;", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/apollographql/apollo3/api/Error;", "<init>", "(Lcom/apollographql/apollo3/api/Operation$Data;Ljava/util/List;)V", "getData", "()Lcom/apollographql/apollo3/api/Operation$Data;", "getErrors", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GQLOperationDTO {
    private final Operation.Data data;
    private final List<Error> errors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GQLOperationDTO copy$default(GQLOperationDTO gQLOperationDTO, Operation.Data data, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            data = gQLOperationDTO.data;
        }
        if ((i & 2) != 0) {
            list = gQLOperationDTO.errors;
        }
        return gQLOperationDTO.copy(data, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Operation.Data getData() {
        return this.data;
    }

    public final List<Error> component2() {
        return this.errors;
    }

    public final GQLOperationDTO copy(Operation.Data data, List<Error> errors) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new GQLOperationDTO(data, errors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GQLOperationDTO)) {
            return false;
        }
        GQLOperationDTO gQLOperationDTO = (GQLOperationDTO) other;
        return Intrinsics.areEqual(this.data, gQLOperationDTO.data) && Intrinsics.areEqual(this.errors, gQLOperationDTO.errors);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.errors.hashCode();
    }

    public String toString() {
        return "GQLOperationDTO(data=" + this.data + ", errors=" + this.errors + ")";
    }

    public GQLOperationDTO(Operation.Data data, List<Error> errors) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.data = data;
        this.errors = errors;
    }

    public final Operation.Data getData() {
        return this.data;
    }

    public final List<Error> getErrors() {
        return this.errors;
    }
}
