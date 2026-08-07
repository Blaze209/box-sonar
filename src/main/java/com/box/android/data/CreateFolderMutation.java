package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.CreateFolderMutation_ResponseAdapter;
import com.box.android.data.adapter.CreateFolderMutation_VariablesAdapter;
import com.box.android.data.selections.CreateFolderMutationSelections;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CreateFolderMutation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000b&'()*+,-./0B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006HÆ\u0003J7\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u00061"}, d2 = {"Lcom/box/android/data/CreateFolderMutation;", "Lcom/apollographql/apollo3/api/Mutation;", "Lcom/box/android/data/CreateFolderMutation$Data;", "name", "", IdentificationData.FIELD_PARENT_ID, "Lcom/apollographql/apollo3/api/Optional;", "clientMutationId", "<init>", "(Ljava/lang/String;Lcom/apollographql/apollo3/api/Optional;Lcom/apollographql/apollo3/api/Optional;)V", "getName", "()Ljava/lang/String;", "getParentId", "()Lcom/apollographql/apollo3/api/Optional;", "getClientMutationId", "id", "document", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", CreateFolderMutation.OPERATION_NAME, "Value", "OwnedBy", "Parent", "UpdatedBy", "PermissionsV2Api", "ItemCollectionConnection", "Edge", "Node", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CreateFolderMutation implements Mutation<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "92fcb1f10d347d4c8ece0278eff3c89828a484f23b7f7d16e93bf2fa87c291c6";
    public static final String OPERATION_NAME = "CreateFolder";
    private final Optional<String> clientMutationId;
    private final String name;
    private final Optional<String> parentId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateFolderMutation copy$default(CreateFolderMutation createFolderMutation, String str, Optional optional, Optional optional2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createFolderMutation.name;
        }
        if ((i & 2) != 0) {
            optional = createFolderMutation.parentId;
        }
        if ((i & 4) != 0) {
            optional2 = createFolderMutation.clientMutationId;
        }
        return createFolderMutation.copy(str, optional, optional2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Optional<String> component2() {
        return this.parentId;
    }

    public final Optional<String> component3() {
        return this.clientMutationId;
    }

    public final CreateFolderMutation copy(String name, Optional<String> parentId, Optional<String> clientMutationId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(clientMutationId, "clientMutationId");
        return new CreateFolderMutation(name, parentId, clientMutationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateFolderMutation)) {
            return false;
        }
        CreateFolderMutation createFolderMutation = (CreateFolderMutation) other;
        return Intrinsics.areEqual(this.name, createFolderMutation.name) && Intrinsics.areEqual(this.parentId, createFolderMutation.parentId) && Intrinsics.areEqual(this.clientMutationId, createFolderMutation.clientMutationId);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.parentId.hashCode()) * 31) + this.clientMutationId.hashCode();
    }

    public String toString() {
        return "CreateFolderMutation(name=" + this.name + ", parentId=" + this.parentId + ", clientMutationId=" + this.clientMutationId + ")";
    }

    public CreateFolderMutation(String name, Optional<String> parentId, Optional<String> clientMutationId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(clientMutationId, "clientMutationId");
        this.name = name;
        this.parentId = parentId;
        this.clientMutationId = clientMutationId;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ CreateFolderMutation(String str, Optional.Absent absent, Optional.Absent absent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Optional.Absent.INSTANCE : absent, (i & 4) != 0 ? Optional.Absent.INSTANCE : absent2);
    }

    public final Optional<String> getParentId() {
        return this.parentId;
    }

    public final Optional<String> getClientMutationId() {
        return this.clientMutationId;
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
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        CreateFolderMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(CreateFolderMutation_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Mutation.INSTANCE.getType()).selections(CreateFolderMutationSelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", "createFolder", "Lcom/box/android/data/CreateFolderMutation$CreateFolder;", "<init>", "(Lcom/box/android/data/CreateFolderMutation$CreateFolder;)V", "getCreateFolder", "()Lcom/box/android/data/CreateFolderMutation$CreateFolder;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Mutation.Data {
        private final CreateFolder createFolder;

        public static /* synthetic */ Data copy$default(Data data, CreateFolder createFolder, int i, Object obj) {
            if ((i & 1) != 0) {
                createFolder = data.createFolder;
            }
            return data.copy(createFolder);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CreateFolder getCreateFolder() {
            return this.createFolder;
        }

        public final Data copy(CreateFolder createFolder) {
            Intrinsics.checkNotNullParameter(createFolder, "createFolder");
            return new Data(createFolder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.createFolder, ((Data) other).createFolder);
        }

        public int hashCode() {
            return this.createFolder.hashCode();
        }

        public String toString() {
            return "Data(createFolder=" + this.createFolder + ")";
        }

        public Data(CreateFolder createFolder) {
            Intrinsics.checkNotNullParameter(createFolder, "createFolder");
            this.createFolder = createFolder;
        }

        public final CreateFolder getCreateFolder() {
            return this.createFolder;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$CreateFolder;", "", "value", "Lcom/box/android/data/CreateFolderMutation$Value;", "<init>", "(Lcom/box/android/data/CreateFolderMutation$Value;)V", "getValue", "()Lcom/box/android/data/CreateFolderMutation$Value;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreateFolder {
        private final Value value;

        public static /* synthetic */ CreateFolder copy$default(CreateFolder createFolder, Value value, int i, Object obj) {
            if ((i & 1) != 0) {
                value = createFolder.value;
            }
            return createFolder.copy(value);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Value getValue() {
            return this.value;
        }

        public final CreateFolder copy(Value value) {
            return new CreateFolder(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CreateFolder) && Intrinsics.areEqual(this.value, ((CreateFolder) other).value);
        }

        public int hashCode() {
            Value value = this.value;
            if (value == null) {
                return 0;
            }
            return value.hashCode();
        }

        public String toString() {
            return "CreateFolder(value=" + this.value + ")";
        }

        public CreateFolder(Value value) {
            this.value = value;
        }

        public final Value getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010C\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010D\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u001aHÆ\u0003JÊ\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020MHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\r\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b-\u0010)R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u0012\u0010)R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006O"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$Value;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "size", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "", "ownedBy", "Lcom/box/android/data/CreateFolderMutation$OwnedBy;", "hasCollaborations", "isExternallyOwned", "parent", "Lcom/box/android/data/CreateFolderMutation$Parent;", "updatedBy", "Lcom/box/android/data/CreateFolderMutation$UpdatedBy;", "permissionsV2Api", "Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "itemCollectionConnection", "Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/CreateFolderMutation$OwnedBy;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/CreateFolderMutation$Parent;Lcom/box/android/data/CreateFolderMutation$UpdatedBy;Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getSize", "()Ljava/lang/Object;", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOwnedBy", "()Lcom/box/android/data/CreateFolderMutation$OwnedBy;", "getHasCollaborations", "getParent", "()Lcom/box/android/data/CreateFolderMutation$Parent;", "getUpdatedBy", "()Lcom/box/android/data/CreateFolderMutation$UpdatedBy;", "getPermissionsV2Api", "()Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/CreateFolderMutation$OwnedBy;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/CreateFolderMutation$Parent;Lcom/box/android/data/CreateFolderMutation$UpdatedBy;Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;)Lcom/box/android/data/CreateFolderMutation$Value;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Value {
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final Boolean hasCollaborations;
        private final String id;
        private final Boolean isExternallyOwned;
        private final Boolean isRooted;
        private final ItemCollectionConnection itemCollectionConnection;
        private final String name;
        private final OwnedBy ownedBy;
        private final Parent parent;
        private final PermissionsV2Api permissionsV2Api;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy updatedBy;

        public static /* synthetic */ Value copy$default(Value value, String str, ItemType itemType, String str2, Object obj, Date date, Date date2, Date date3, Date date4, Boolean bool, OwnedBy ownedBy, Boolean bool2, Boolean bool3, Parent parent, UpdatedBy updatedBy, PermissionsV2Api permissionsV2Api, ItemCollectionConnection itemCollectionConnection, int i, Object obj2) {
            String str3 = (i & 1) != 0 ? value.id : str;
            return value.copy(str3, (i & 2) != 0 ? value.type : itemType, (i & 4) != 0 ? value.name : str2, (i & 8) != 0 ? value.size : obj, (i & 16) != 0 ? value.createdAt : date, (i & 32) != 0 ? value.updatedAt : date2, (i & 64) != 0 ? value.contentCreatedAt : date3, (i & 128) != 0 ? value.contentUpdatedAt : date4, (i & 256) != 0 ? value.isRooted : bool, (i & 512) != 0 ? value.ownedBy : ownedBy, (i & 1024) != 0 ? value.hasCollaborations : bool2, (i & 2048) != 0 ? value.isExternallyOwned : bool3, (i & 4096) != 0 ? value.parent : parent, (i & 8192) != 0 ? value.updatedBy : updatedBy, (i & 16384) != 0 ? value.permissionsV2Api : permissionsV2Api, (i & 32768) != 0 ? value.itemCollectionConnection : itemCollectionConnection);
        }

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Parent getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final ItemCollectionConnection getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getIsRooted() {
            return this.isRooted;
        }

        public final Value copy(String id, ItemType type, String name, Object size, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, Boolean isRooted, OwnedBy ownedBy, Boolean hasCollaborations, Boolean isExternallyOwned, Parent parent, UpdatedBy updatedBy, PermissionsV2Api permissionsV2Api, ItemCollectionConnection itemCollectionConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Value(id, type, name, size, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, isRooted, ownedBy, hasCollaborations, isExternallyOwned, parent, updatedBy, permissionsV2Api, itemCollectionConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Value)) {
                return false;
            }
            Value value = (Value) other;
            return Intrinsics.areEqual(this.id, value.id) && this.type == value.type && Intrinsics.areEqual(this.name, value.name) && Intrinsics.areEqual(this.size, value.size) && Intrinsics.areEqual(this.createdAt, value.createdAt) && Intrinsics.areEqual(this.updatedAt, value.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, value.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, value.contentUpdatedAt) && Intrinsics.areEqual(this.isRooted, value.isRooted) && Intrinsics.areEqual(this.ownedBy, value.ownedBy) && Intrinsics.areEqual(this.hasCollaborations, value.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, value.isExternallyOwned) && Intrinsics.areEqual(this.parent, value.parent) && Intrinsics.areEqual(this.updatedBy, value.updatedBy) && Intrinsics.areEqual(this.permissionsV2Api, value.permissionsV2Api) && Intrinsics.areEqual(this.itemCollectionConnection, value.itemCollectionConnection);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode6 = (iHashCode5 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode7 = (iHashCode6 + (date4 == null ? 0 : date4.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            OwnedBy ownedBy = this.ownedBy;
            int iHashCode9 = (iHashCode8 + (ownedBy == null ? 0 : ownedBy.hashCode())) * 31;
            Boolean bool2 = this.hasCollaborations;
            int iHashCode10 = (iHashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isExternallyOwned;
            int iHashCode11 = (iHashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Parent parent = this.parent;
            int iHashCode12 = (iHashCode11 + (parent == null ? 0 : parent.hashCode())) * 31;
            UpdatedBy updatedBy = this.updatedBy;
            int iHashCode13 = (iHashCode12 + (updatedBy == null ? 0 : updatedBy.hashCode())) * 31;
            PermissionsV2Api permissionsV2Api = this.permissionsV2Api;
            int iHashCode14 = (iHashCode13 + (permissionsV2Api == null ? 0 : permissionsV2Api.hashCode())) * 31;
            ItemCollectionConnection itemCollectionConnection = this.itemCollectionConnection;
            return iHashCode14 + (itemCollectionConnection != null ? itemCollectionConnection.hashCode() : 0);
        }

        public String toString() {
            return "Value(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", size=" + this.size + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", isRooted=" + this.isRooted + ", ownedBy=" + this.ownedBy + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", parent=" + this.parent + ", updatedBy=" + this.updatedBy + ", permissionsV2Api=" + this.permissionsV2Api + ", itemCollectionConnection=" + this.itemCollectionConnection + ")";
        }

        public Value(String id, ItemType type, String str, Object obj, Date date, Date date2, Date date3, Date date4, Boolean bool, OwnedBy ownedBy, Boolean bool2, Boolean bool3, Parent parent, UpdatedBy updatedBy, PermissionsV2Api permissionsV2Api, ItemCollectionConnection itemCollectionConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.size = obj;
            this.createdAt = date;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.isRooted = bool;
            this.ownedBy = ownedBy;
            this.hasCollaborations = bool2;
            this.isExternallyOwned = bool3;
            this.parent = parent;
            this.updatedBy = updatedBy;
            this.permissionsV2Api = permissionsV2Api;
            this.itemCollectionConnection = itemCollectionConnection;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Object getSize() {
            return this.size;
        }

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        public final Boolean isRooted() {
            return this.isRooted;
        }

        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        public final Boolean isExternallyOwned() {
            return this.isExternallyOwned;
        }

        public final Parent getParent() {
            return this.parent;
        }

        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final ItemCollectionConnection getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$OwnedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ OwnedBy copy$default(OwnedBy ownedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = ownedBy.name;
            }
            return ownedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final OwnedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedBy)) {
                return false;
            }
            OwnedBy ownedBy = (OwnedBy) other;
            return Intrinsics.areEqual(this.id, ownedBy.id) && Intrinsics.areEqual(this.name, ownedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "OwnedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public OwnedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$Parent;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent copy$default(Parent parent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent.id;
            }
            if ((i & 2) != 0) {
                str2 = parent.name;
            }
            return parent.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent)) {
                return false;
            }
            Parent parent = (Parent) other;
            return Intrinsics.areEqual(this.id, parent.id) && Intrinsics.areEqual(this.name, parent.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$UpdatedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy copy$default(UpdatedBy updatedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy.name;
            }
            return updatedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy)) {
                return false;
            }
            UpdatedBy updatedBy = (UpdatedBy) other;
            return Intrinsics.areEqual(this.id, updatedBy.id) && Intrinsics.areEqual(this.name, updatedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "", "canInviteCollaborator", "", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanInviteCollaborator", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSetShareAccess", "getCanDownload", "getCanPreview", "getCanComment", "getCanUpload", "getCanRename", "getCanDelete", "getCanShare", "getCanViewAnnotations", "getCanCreateAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api {
        private final Boolean canComment;
        private final Boolean canCreateAnnotations;
        private final Boolean canDelete;
        private final Boolean canDownload;
        private final Boolean canInviteCollaborator;
        private final Boolean canPreview;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;
        private final Boolean canUpload;
        private final Boolean canViewAnnotations;

        public static /* synthetic */ PermissionsV2Api copy$default(PermissionsV2Api permissionsV2Api, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api.canInviteCollaborator;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api.canSetShareAccess;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api.canPreview;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api.canComment;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api.canUpload;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api.canRename;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api.canDelete;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api.canShare;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api.canCreateAnnotations;
            }
            Boolean bool12 = bool10;
            Boolean bool13 = bool11;
            Boolean bool14 = bool8;
            Boolean bool15 = bool9;
            Boolean bool16 = bool6;
            Boolean bool17 = bool7;
            Boolean bool18 = bool5;
            Boolean bool19 = bool3;
            return permissionsV2Api.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api copy(Boolean canInviteCollaborator, Boolean canSetShareAccess, Boolean canDownload, Boolean canPreview, Boolean canComment, Boolean canUpload, Boolean canRename, Boolean canDelete, Boolean canShare, Boolean canViewAnnotations, Boolean canCreateAnnotations) {
            return new PermissionsV2Api(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api)) {
                return false;
            }
            PermissionsV2Api permissionsV2Api = (PermissionsV2Api) other;
            return Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api.canInviteCollaborator) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api.canSetShareAccess) && Intrinsics.areEqual(this.canDownload, permissionsV2Api.canDownload) && Intrinsics.areEqual(this.canPreview, permissionsV2Api.canPreview) && Intrinsics.areEqual(this.canComment, permissionsV2Api.canComment) && Intrinsics.areEqual(this.canUpload, permissionsV2Api.canUpload) && Intrinsics.areEqual(this.canRename, permissionsV2Api.canRename) && Intrinsics.areEqual(this.canDelete, permissionsV2Api.canDelete) && Intrinsics.areEqual(this.canShare, permissionsV2Api.canShare) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api.canCreateAnnotations);
        }

        public int hashCode() {
            Boolean bool = this.canInviteCollaborator;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canSetShareAccess;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDownload;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canPreview;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canComment;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canUpload;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canRename;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canDelete;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canShare;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api(canInviteCollaborator=" + this.canInviteCollaborator + ", canSetShareAccess=" + this.canSetShareAccess + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canUpload=" + this.canUpload + ", canRename=" + this.canRename + ", canDelete=" + this.canDelete + ", canShare=" + this.canShare + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ")";
        }

        public PermissionsV2Api(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
            this.canInviteCollaborator = bool;
            this.canSetShareAccess = bool2;
            this.canDownload = bool3;
            this.canPreview = bool4;
            this.canComment = bool5;
            this.canUpload = bool6;
            this.canRename = bool7;
            this.canDelete = bool8;
            this.canShare = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;", "", "edges", "", "Lcom/box/android/data/CreateFolderMutation$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemCollectionConnection {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemCollectionConnection copy$default(ItemCollectionConnection itemCollectionConnection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemCollectionConnection.edges;
            }
            return itemCollectionConnection.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final ItemCollectionConnection copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemCollectionConnection(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemCollectionConnection) && Intrinsics.areEqual(this.edges, ((ItemCollectionConnection) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemCollectionConnection(edges=" + this.edges + ")";
        }

        public ItemCollectionConnection(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$Edge;", "", "id", "", "node", "Lcom/box/android/data/CreateFolderMutation$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/CreateFolderMutation$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/CreateFolderMutation$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final String id;
        private final Node node;

        public static /* synthetic */ Edge copy$default(Edge edge, String str, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge.id;
            }
            if ((i & 2) != 0) {
                node = edge.node;
            }
            return edge.copy(str, node);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Node getNode() {
            return this.node;
        }

        public final Edge copy(String id, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge(id, node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edge)) {
                return false;
            }
            Edge edge = (Edge) other;
            return Intrinsics.areEqual(this.id, edge.id) && Intrinsics.areEqual(this.node, edge.node);
        }

        public int hashCode() {
            String str = this.id;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Edge(id=" + this.id + ", node=" + this.node + ")";
        }

        public Edge(String str, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.id = str;
            this.node = node;
        }

        public final String getId() {
            return this.id;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$Node;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final String collectionType;
        private final String id;
        private final String name;

        public static /* synthetic */ Node copy$default(Node node, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.id;
            }
            if ((i & 2) != 0) {
                str2 = node.name;
            }
            if ((i & 4) != 0) {
                str3 = node.collectionType;
            }
            return node.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCollectionType() {
            return this.collectionType;
        }

        public final Node copy(String id, String name, String collectionType) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node(id, name, collectionType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.id, node.id) && Intrinsics.areEqual(this.name, node.name) && Intrinsics.areEqual(this.collectionType, node.collectionType);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.collectionType;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ")";
        }

        public Node(String id, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.collectionType = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getCollectionType() {
            return this.collectionType;
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/CreateFolderMutation$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "mutation CreateFolder($name: String!, $parentId: ID, $clientMutationId: String) { createFolder(input: { clientMutationId: $clientMutationId name: $name parentId: $parentId } ) { value { id type name size createdAt updatedAt contentCreatedAt contentUpdatedAt isRooted ownedBy { id name } hasCollaborations isExternallyOwned parent { id name } updatedBy { id name } permissionsV2Api { canInviteCollaborator canSetShareAccess canDownload canPreview canComment canUpload canRename canDelete canShare canViewAnnotations canCreateAnnotations } itemCollectionConnection { edges { id: cursor node { id name collectionType } } } } } }";
        }
    }
}
