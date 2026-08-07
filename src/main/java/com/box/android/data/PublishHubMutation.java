package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.PublishHubMutation_ResponseAdapter;
import com.box.android.data.adapter.PublishHubMutation_VariablesAdapter;
import com.box.android.data.selections.PublishHubMutationSelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PublishHubMutation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005 !\"#$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006%"}, d2 = {"Lcom/box/android/data/PublishHubMutation;", "Lcom/apollographql/apollo3/api/Mutation;", "Lcom/box/android/data/PublishHubMutation$Data;", "id", "", "document", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDocument", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "PublishHub", "Value", "Error", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PublishHubMutation implements Mutation<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "177075e08c3171abb2c9cf6e6491fa74ef46509bf72c0ccf06675a1377d66bdb";
    public static final String OPERATION_NAME = "publishHub";
    private final String document;
    private final String id;

    public static /* synthetic */ PublishHubMutation copy$default(PublishHubMutation publishHubMutation, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publishHubMutation.id;
        }
        if ((i & 2) != 0) {
            str2 = publishHubMutation.document;
        }
        return publishHubMutation.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDocument() {
        return this.document;
    }

    public final PublishHubMutation copy(String id, String document) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(document, "document");
        return new PublishHubMutation(id, document);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishHubMutation)) {
            return false;
        }
        PublishHubMutation publishHubMutation = (PublishHubMutation) other;
        return Intrinsics.areEqual(this.id, publishHubMutation.id) && Intrinsics.areEqual(this.document, publishHubMutation.document);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.document.hashCode();
    }

    public String toString() {
        return "PublishHubMutation(id=" + this.id + ", document=" + this.document + ")";
    }

    public PublishHubMutation(String id, String document) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(document, "document");
        this.id = id;
        this.document = document;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDocument() {
        return this.document;
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
        PublishHubMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(PublishHubMutation_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Mutation.INSTANCE.getType()).selections(PublishHubMutationSelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: PublishHubMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/PublishHubMutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", PublishHubMutation.OPERATION_NAME, "Lcom/box/android/data/PublishHubMutation$PublishHub;", "<init>", "(Lcom/box/android/data/PublishHubMutation$PublishHub;)V", "getPublishHub", "()Lcom/box/android/data/PublishHubMutation$PublishHub;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Mutation.Data {
        private final PublishHub publishHub;

        public static /* synthetic */ Data copy$default(Data data, PublishHub publishHub, int i, Object obj) {
            if ((i & 1) != 0) {
                publishHub = data.publishHub;
            }
            return data.copy(publishHub);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PublishHub getPublishHub() {
            return this.publishHub;
        }

        public final Data copy(PublishHub publishHub) {
            Intrinsics.checkNotNullParameter(publishHub, "publishHub");
            return new Data(publishHub);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.publishHub, ((Data) other).publishHub);
        }

        public int hashCode() {
            return this.publishHub.hashCode();
        }

        public String toString() {
            return "Data(publishHub=" + this.publishHub + ")";
        }

        public Data(PublishHub publishHub) {
            Intrinsics.checkNotNullParameter(publishHub, "publishHub");
            this.publishHub = publishHub;
        }

        public final PublishHub getPublishHub() {
            return this.publishHub;
        }
    }

    /* JADX INFO: compiled from: PublishHubMutation.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/PublishHubMutation$PublishHub;", "", "value", "Lcom/box/android/data/PublishHubMutation$Value;", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/box/android/data/PublishHubMutation$Error;", "<init>", "(Lcom/box/android/data/PublishHubMutation$Value;Ljava/util/List;)V", "getValue", "()Lcom/box/android/data/PublishHubMutation$Value;", "getErrors", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PublishHub {
        private final List<Error> errors;
        private final Value value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PublishHub copy$default(PublishHub publishHub, Value value, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                value = publishHub.value;
            }
            if ((i & 2) != 0) {
                list = publishHub.errors;
            }
            return publishHub.copy(value, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Value getValue() {
            return this.value;
        }

        public final List<Error> component2() {
            return this.errors;
        }

        public final PublishHub copy(Value value, List<Error> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new PublishHub(value, errors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PublishHub)) {
                return false;
            }
            PublishHub publishHub = (PublishHub) other;
            return Intrinsics.areEqual(this.value, publishHub.value) && Intrinsics.areEqual(this.errors, publishHub.errors);
        }

        public int hashCode() {
            Value value = this.value;
            return ((value == null ? 0 : value.hashCode()) * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "PublishHub(value=" + this.value + ", errors=" + this.errors + ")";
        }

        public PublishHub(Value value, List<Error> errors) {
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

    /* JADX INFO: compiled from: PublishHubMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/PublishHubMutation$Value;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: PublishHubMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/PublishHubMutation$Error;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: PublishHubMutation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/PublishHubMutation$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "mutation publishHub($id: ID!, $document: String!) { publishHub(input: { id: $id document: $document } ) { value { id } errors { message } } }";
        }
    }
}
