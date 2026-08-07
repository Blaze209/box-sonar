package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.CreateUnpublishedHubMutation_ResponseAdapter;
import com.box.android.data.selections.CreateUnpublishedHubMutationSelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CreateUnpublishedHubMutation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/CreateUnpublishedHubMutation;", "Lcom/apollographql/apollo3/api/Mutation;", "Lcom/box/android/data/CreateUnpublishedHubMutation$Data;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "id", "", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "Data", "CreateUnpublishedHub", "Value", "Error", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateUnpublishedHubMutation implements Mutation<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "ba4831f0a34c038359d1bd6c2352124200fa055279db1e04386613f707d4e05e";
    public static final String OPERATION_NAME = "createUnpublishedHub";

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
    }

    public boolean equals(Object other) {
        return other != null && other.getClass() == getClass();
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(getClass()).hashCode();
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
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(CreateUnpublishedHubMutation_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Mutation.INSTANCE.getType()).selections(CreateUnpublishedHubMutationSelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CreateUnpublishedHubMutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", CreateUnpublishedHubMutation.OPERATION_NAME, "Lcom/box/android/data/CreateUnpublishedHubMutation$CreateUnpublishedHub;", "<init>", "(Lcom/box/android/data/CreateUnpublishedHubMutation$CreateUnpublishedHub;)V", "getCreateUnpublishedHub", "()Lcom/box/android/data/CreateUnpublishedHubMutation$CreateUnpublishedHub;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Mutation.Data {
        private final CreateUnpublishedHub createUnpublishedHub;

        public static /* synthetic */ Data copy$default(Data data, CreateUnpublishedHub createUnpublishedHub, int i, Object obj) {
            if ((i & 1) != 0) {
                createUnpublishedHub = data.createUnpublishedHub;
            }
            return data.copy(createUnpublishedHub);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CreateUnpublishedHub getCreateUnpublishedHub() {
            return this.createUnpublishedHub;
        }

        public final Data copy(CreateUnpublishedHub createUnpublishedHub) {
            Intrinsics.checkNotNullParameter(createUnpublishedHub, "createUnpublishedHub");
            return new Data(createUnpublishedHub);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.createUnpublishedHub, ((Data) other).createUnpublishedHub);
        }

        public int hashCode() {
            return this.createUnpublishedHub.hashCode();
        }

        public String toString() {
            return "Data(createUnpublishedHub=" + this.createUnpublishedHub + ")";
        }

        public Data(CreateUnpublishedHub createUnpublishedHub) {
            Intrinsics.checkNotNullParameter(createUnpublishedHub, "createUnpublishedHub");
            this.createUnpublishedHub = createUnpublishedHub;
        }

        public final CreateUnpublishedHub getCreateUnpublishedHub() {
            return this.createUnpublishedHub;
        }
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/CreateUnpublishedHubMutation$CreateUnpublishedHub;", "", "value", "Lcom/box/android/data/CreateUnpublishedHubMutation$Value;", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/box/android/data/CreateUnpublishedHubMutation$Error;", "<init>", "(Lcom/box/android/data/CreateUnpublishedHubMutation$Value;Ljava/util/List;)V", "getValue", "()Lcom/box/android/data/CreateUnpublishedHubMutation$Value;", "getErrors", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreateUnpublishedHub {
        private final List<Error> errors;
        private final Value value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CreateUnpublishedHub copy$default(CreateUnpublishedHub createUnpublishedHub, Value value, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                value = createUnpublishedHub.value;
            }
            if ((i & 2) != 0) {
                list = createUnpublishedHub.errors;
            }
            return createUnpublishedHub.copy(value, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Value getValue() {
            return this.value;
        }

        public final List<Error> component2() {
            return this.errors;
        }

        public final CreateUnpublishedHub copy(Value value, List<Error> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new CreateUnpublishedHub(value, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateUnpublishedHub)) {
                return false;
            }
            CreateUnpublishedHub createUnpublishedHub = (CreateUnpublishedHub) other;
            return Intrinsics.areEqual(this.value, createUnpublishedHub.value) && Intrinsics.areEqual(this.errors, createUnpublishedHub.errors);
        }

        public int hashCode() {
            Value value = this.value;
            return ((value == null ? 0 : value.hashCode()) * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "CreateUnpublishedHub(value=" + this.value + ", errors=" + this.errors + ")";
        }

        public CreateUnpublishedHub(Value value, List<Error> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.value = value;
            this.errors = errors;
        }

        public final Value getValue() {
            return this.value;
        }

        public final List<Error> getErrors() {
            return this.errors;
        }
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/CreateUnpublishedHubMutation$Value;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Value {
        private final String id;

        public static /* synthetic */ Value copy$default(Value value, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = value.id;
            }
            return value.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Value copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Value(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Value) && Intrinsics.areEqual(this.id, ((Value) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Value(id=" + this.id + ")";
        }

        public Value(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/CreateUnpublishedHubMutation$Error;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CreateUnpublishedHubMutation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/CreateUnpublishedHubMutation$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "mutation createUnpublishedHub { createUnpublishedHub { value { id } errors { message } } }";
        }
    }
}
