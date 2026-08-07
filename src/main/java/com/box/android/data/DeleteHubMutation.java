package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.DeleteHubMutation_ResponseAdapter;
import com.box.android.data.adapter.DeleteHubMutation_VariablesAdapter;
import com.box.android.data.selections.DeleteHubMutationSelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteHubMutation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/box/android/data/DeleteHubMutation;", "Lcom/apollographql/apollo3/api/Mutation;", "Lcom/box/android/data/DeleteHubMutation$Data;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "DeleteHub", "Error", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeleteHubMutation implements Mutation<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "b805bb915d96cbf9a4d443ddc28cb7ca68a8e29987bb2c8ae22651fe7dcd30b8";
    public static final String OPERATION_NAME = "deleteHub";
    private final String id;

    public static /* synthetic */ DeleteHubMutation copy$default(DeleteHubMutation deleteHubMutation, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteHubMutation.id;
        }
        return deleteHubMutation.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final DeleteHubMutation copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new DeleteHubMutation(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeleteHubMutation) && Intrinsics.areEqual(this.id, ((DeleteHubMutation) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "DeleteHubMutation(id=" + this.id + ")";
    }

    public DeleteHubMutation(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String id() {
        return OPERATION_ID;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String document() {
        return INSTANCE.getOPERATION_DOCUMENT();
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String name() {
        return OPERATION_NAME;
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        DeleteHubMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(DeleteHubMutation_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Mutation.INSTANCE.getType()).selections(DeleteHubMutationSelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: DeleteHubMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/DeleteHubMutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", DeleteHubMutation.OPERATION_NAME, "Lcom/box/android/data/DeleteHubMutation$DeleteHub;", "<init>", "(Lcom/box/android/data/DeleteHubMutation$DeleteHub;)V", "getDeleteHub", "()Lcom/box/android/data/DeleteHubMutation$DeleteHub;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Mutation.Data {
        private final DeleteHub deleteHub;

        public static /* synthetic */ Data copy$default(Data data, DeleteHub deleteHub, int i, Object obj) {
            if ((i & 1) != 0) {
                deleteHub = data.deleteHub;
            }
            return data.copy(deleteHub);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DeleteHub getDeleteHub() {
            return this.deleteHub;
        }

        public final Data copy(DeleteHub deleteHub) {
            Intrinsics.checkNotNullParameter(deleteHub, "deleteHub");
            return new Data(deleteHub);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.deleteHub, ((Data) other).deleteHub);
        }

        public int hashCode() {
            return this.deleteHub.hashCode();
        }

        public String toString() {
            return "Data(deleteHub=" + this.deleteHub + ")";
        }

        public Data(DeleteHub deleteHub) {
            Intrinsics.checkNotNullParameter(deleteHub, "deleteHub");
            this.deleteHub = deleteHub;
        }

        public final DeleteHub getDeleteHub() {
            return this.deleteHub;
        }
    }

    /* JADX INFO: compiled from: DeleteHubMutation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/DeleteHubMutation$DeleteHub;", "", "value", "", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/box/android/data/DeleteHubMutation$Error;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getErrors", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/box/android/data/DeleteHubMutation$DeleteHub;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DeleteHub {
        private final List<Error> errors;
        private final Boolean value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteHub copy$default(DeleteHub deleteHub, Boolean bool, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = deleteHub.value;
            }
            if ((i & 2) != 0) {
                list = deleteHub.errors;
            }
            return deleteHub.copy(bool, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getValue() {
            return this.value;
        }

        public final List<Error> component2() {
            return this.errors;
        }

        public final DeleteHub copy(Boolean value, List<Error> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new DeleteHub(value, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteHub)) {
                return false;
            }
            DeleteHub deleteHub = (DeleteHub) other;
            return Intrinsics.areEqual(this.value, deleteHub.value) && Intrinsics.areEqual(this.errors, deleteHub.errors);
        }

        public int hashCode() {
            Boolean bool = this.value;
            return ((bool == null ? 0 : bool.hashCode()) * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "DeleteHub(value=" + this.value + ", errors=" + this.errors + ")";
        }

        public DeleteHub(Boolean bool, List<Error> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.value = bool;
            this.errors = errors;
        }

        public final Boolean getValue() {
            return this.value;
        }

        public final List<Error> getErrors() {
            return this.errors;
        }
    }

    /* JADX INFO: compiled from: DeleteHubMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/DeleteHubMutation$Error;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error {
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.message, ((Error) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        public Error(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DeleteHubMutation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/DeleteHubMutation$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "mutation deleteHub($id: ID!) { deleteHub(input: { id: $id } ) { value errors { message } } }";
        }
    }
}
