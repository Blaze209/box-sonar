package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.CopyItemMutation_ResponseAdapter;
import com.box.android.data.adapter.CopyItemMutation_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.selections.CopyItemMutationSelections;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyItemMutation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u001d./0123456789:;<=>?@ABCDEFGHIJBC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tHÆ\u0003JK\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006K"}, d2 = {"Lcom/box/android/data/CopyItemMutation;", "Lcom/apollographql/apollo3/api/Mutation;", "Lcom/box/android/data/CopyItemMutation$Data;", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "newParentId", "newName", "Lcom/apollographql/apollo3/api/Optional;", "clientMutationId", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Lcom/apollographql/apollo3/api/Optional;Lcom/apollographql/apollo3/api/Optional;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getNewParentId", "getNewName", "()Lcom/apollographql/apollo3/api/Optional;", "getClientMutationId", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "CopyItem", "OnFile", "ItemCollectionConnection", "Edge", "Node", "OwnedBy", "UpdatedBy", "Parent", "Watermark", "PermissionsV2Api", "FileVersion", "OnFolder", "ItemCollectionConnection1", "Edge1", "Node1", "OwnedBy1", "UpdatedBy1", "Parent1", "PermissionsV2Api1", "OnWeblink", "ItemCollectionConnection2", "Edge2", "Node2", "OwnedBy2", "UpdatedBy2", "Parent2", "PermissionsV2Api2", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CopyItemMutation implements Mutation<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "a1e4789606afd5b89258568087ce71544b48c5f815321181f14376a9f4337a1f";
    public static final String OPERATION_NAME = "CopyItem";
    private final Optional<String> clientMutationId;
    private final String id;
    private final Optional<String> newName;
    private final String newParentId;
    private final ItemType type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CopyItemMutation copy$default(CopyItemMutation copyItemMutation, String str, ItemType itemType, String str2, Optional optional, Optional optional2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = copyItemMutation.id;
        }
        if ((i & 2) != 0) {
            itemType = copyItemMutation.type;
        }
        if ((i & 4) != 0) {
            str2 = copyItemMutation.newParentId;
        }
        if ((i & 8) != 0) {
            optional = copyItemMutation.newName;
        }
        if ((i & 16) != 0) {
            optional2 = copyItemMutation.clientMutationId;
        }
        Optional optional3 = optional2;
        String str3 = str2;
        return copyItemMutation.copy(str, itemType, str3, optional, optional3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNewParentId() {
        return this.newParentId;
    }

    public final Optional<String> component4() {
        return this.newName;
    }

    public final Optional<String> component5() {
        return this.clientMutationId;
    }

    public final CopyItemMutation copy(String id, ItemType type, String newParentId, Optional<String> newName, Optional<String> clientMutationId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(newParentId, "newParentId");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Intrinsics.checkNotNullParameter(clientMutationId, "clientMutationId");
        return new CopyItemMutation(id, type, newParentId, newName, clientMutationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CopyItemMutation)) {
            return false;
        }
        CopyItemMutation copyItemMutation = (CopyItemMutation) other;
        return Intrinsics.areEqual(this.id, copyItemMutation.id) && this.type == copyItemMutation.type && Intrinsics.areEqual(this.newParentId, copyItemMutation.newParentId) && Intrinsics.areEqual(this.newName, copyItemMutation.newName) && Intrinsics.areEqual(this.clientMutationId, copyItemMutation.clientMutationId);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.newParentId.hashCode()) * 31) + this.newName.hashCode()) * 31) + this.clientMutationId.hashCode();
    }

    public String toString() {
        return "CopyItemMutation(id=" + this.id + ", type=" + this.type + ", newParentId=" + this.newParentId + ", newName=" + this.newName + ", clientMutationId=" + this.clientMutationId + ")";
    }

    public CopyItemMutation(String id, ItemType type, String newParentId, Optional<String> newName, Optional<String> clientMutationId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(newParentId, "newParentId");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Intrinsics.checkNotNullParameter(clientMutationId, "clientMutationId");
        this.id = id;
        this.type = type;
        this.newParentId = newParentId;
        this.newName = newName;
        this.clientMutationId = clientMutationId;
    }

    public final String getId() {
        return this.id;
    }

    public final ItemType getType() {
        return this.type;
    }

    public final String getNewParentId() {
        return this.newParentId;
    }

    public /* synthetic */ CopyItemMutation(String str, ItemType itemType, String str2, Optional.Absent absent, Optional.Absent absent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, itemType, str2, (i & 8) != 0 ? Optional.Absent.INSTANCE : absent, (i & 16) != 0 ? Optional.Absent.INSTANCE : absent2);
    }

    public final Optional<String> getNewName() {
        return this.newName;
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
        return "CopyItem";
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        CopyItemMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(CopyItemMutation_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Mutation.INSTANCE.getType()).selections(CopyItemMutationSelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", "copyItem", "Lcom/box/android/data/CopyItemMutation$CopyItem;", "<init>", "(Lcom/box/android/data/CopyItemMutation$CopyItem;)V", "getCopyItem", "()Lcom/box/android/data/CopyItemMutation$CopyItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Mutation.Data {
        private final CopyItem copyItem;

        public static /* synthetic */ Data copy$default(Data data, CopyItem copyItem, int i, Object obj) {
            if ((i & 1) != 0) {
                copyItem = data.copyItem;
            }
            return data.copy(copyItem);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CopyItem getCopyItem() {
            return this.copyItem;
        }

        public final Data copy(CopyItem copyItem) {
            return new Data(copyItem);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.copyItem, ((Data) other).copyItem);
        }

        public int hashCode() {
            CopyItem copyItem = this.copyItem;
            if (copyItem == null) {
                return 0;
            }
            return copyItem.hashCode();
        }

        public String toString() {
            return "Data(copyItem=" + this.copyItem + ")";
        }

        public Data(CopyItem copyItem) {
            this.copyItem = copyItem;
        }

        public final CopyItem getCopyItem() {
            return this.copyItem;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/CopyItemMutation$CopyItem;", "", GQLCacheConstants.TYPENAME_KEY, "", "onFile", "Lcom/box/android/data/CopyItemMutation$OnFile;", "onFolder", "Lcom/box/android/data/CopyItemMutation$OnFolder;", "onWeblink", "Lcom/box/android/data/CopyItemMutation$OnWeblink;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/CopyItemMutation$OnFile;Lcom/box/android/data/CopyItemMutation$OnFolder;Lcom/box/android/data/CopyItemMutation$OnWeblink;)V", "get__typename", "()Ljava/lang/String;", "getOnFile", "()Lcom/box/android/data/CopyItemMutation$OnFile;", "getOnFolder", "()Lcom/box/android/data/CopyItemMutation$OnFolder;", "getOnWeblink", "()Lcom/box/android/data/CopyItemMutation$OnWeblink;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CopyItem {
        private final String __typename;
        private final OnFile onFile;
        private final OnFolder onFolder;
        private final OnWeblink onWeblink;

        public static /* synthetic */ CopyItem copy$default(CopyItem copyItem, String str, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = copyItem.__typename;
            }
            if ((i & 2) != 0) {
                onFile = copyItem.onFile;
            }
            if ((i & 4) != 0) {
                onFolder = copyItem.onFolder;
            }
            if ((i & 8) != 0) {
                onWeblink = copyItem.onWeblink;
            }
            return copyItem.copy(str, onFile, onFolder, onWeblink);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OnFile getOnFile() {
            return this.onFile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final OnFolder getOnFolder() {
            return this.onFolder;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final OnWeblink getOnWeblink() {
            return this.onWeblink;
        }

        public final CopyItem copy(String __typename, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            return new CopyItem(__typename, onFile, onFolder, onWeblink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CopyItem)) {
                return false;
            }
            CopyItem copyItem = (CopyItem) other;
            return Intrinsics.areEqual(this.__typename, copyItem.__typename) && Intrinsics.areEqual(this.onFile, copyItem.onFile) && Intrinsics.areEqual(this.onFolder, copyItem.onFolder) && Intrinsics.areEqual(this.onWeblink, copyItem.onWeblink);
        }

        public int hashCode() {
            int iHashCode = this.__typename.hashCode() * 31;
            OnFile onFile = this.onFile;
            int iHashCode2 = (iHashCode + (onFile == null ? 0 : onFile.hashCode())) * 31;
            OnFolder onFolder = this.onFolder;
            int iHashCode3 = (iHashCode2 + (onFolder == null ? 0 : onFolder.hashCode())) * 31;
            OnWeblink onWeblink = this.onWeblink;
            return iHashCode3 + (onWeblink != null ? onWeblink.hashCode() : 0);
        }

        public String toString() {
            return "CopyItem(__typename=" + this.__typename + ", onFile=" + this.onFile + ", onFolder=" + this.onFolder + ", onWeblink=" + this.onWeblink + ")";
        }

        public CopyItem(String __typename, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            this.__typename = __typename;
            this.onFile = onFile;
            this.onFolder = onFolder;
            this.onWeblink = onWeblink;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final OnFile getOnFile() {
            return this.onFile;
        }

        public final OnFolder getOnFolder() {
            return this.onFolder;
        }

        public final OnWeblink getOnWeblink() {
            return this.onWeblink;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b#\u0010$J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010R\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010S\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010Y\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0086\u0002\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"HÆ\u0001¢\u0006\u0002\u0010_J\u0013\u0010`\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u000fHÖ\u0001J\t\u0010c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00100\u001a\u0004\b\f\u0010/R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00100\u001a\u0004\bA\u0010/R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00100\u001a\u0004\b\u001b\u0010/R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bG\u0010H¨\u0006d"}, d2 = {"Lcom/box/android/data/CopyItemMutation$OnFile;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "", "commentCount", "", "annotationCount", "itemCollectionConnection", "Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection;", "ownedBy", "Lcom/box/android/data/CopyItemMutation$OwnedBy;", "updatedBy", "Lcom/box/android/data/CopyItemMutation$UpdatedBy;", "parent", "Lcom/box/android/data/CopyItemMutation$Parent;", "size", "hasCollaborations", "isExternallyOwned", "sha1", "watermark", "Lcom/box/android/data/CopyItemMutation$Watermark;", "permissionsV2Api", "Lcom/box/android/data/CopyItemMutation$PermissionsV2Api;", "fileVersion", "Lcom/box/android/data/CopyItemMutation$FileVersion;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection;Lcom/box/android/data/CopyItemMutation$OwnedBy;Lcom/box/android/data/CopyItemMutation$UpdatedBy;Lcom/box/android/data/CopyItemMutation$Parent;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/CopyItemMutation$Watermark;Lcom/box/android/data/CopyItemMutation$PermissionsV2Api;Lcom/box/android/data/CopyItemMutation$FileVersion;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommentCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnnotationCount", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection;", "getOwnedBy", "()Lcom/box/android/data/CopyItemMutation$OwnedBy;", "getUpdatedBy", "()Lcom/box/android/data/CopyItemMutation$UpdatedBy;", "getParent", "()Lcom/box/android/data/CopyItemMutation$Parent;", "getSize", "()Ljava/lang/Object;", "getHasCollaborations", "getSha1", "getWatermark", "()Lcom/box/android/data/CopyItemMutation$Watermark;", "getPermissionsV2Api", "()Lcom/box/android/data/CopyItemMutation$PermissionsV2Api;", "getFileVersion", "()Lcom/box/android/data/CopyItemMutation$FileVersion;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection;Lcom/box/android/data/CopyItemMutation$OwnedBy;Lcom/box/android/data/CopyItemMutation$UpdatedBy;Lcom/box/android/data/CopyItemMutation$Parent;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/CopyItemMutation$Watermark;Lcom/box/android/data/CopyItemMutation$PermissionsV2Api;Lcom/box/android/data/CopyItemMutation$FileVersion;)Lcom/box/android/data/CopyItemMutation$OnFile;", "equals", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnFile {
        private final Integer annotationCount;
        private final Integer commentCount;
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final FileVersion fileVersion;
        private final Boolean hasCollaborations;
        private final String id;
        private final Boolean isExternallyOwned;
        private final Boolean isRooted;
        private final ItemCollectionConnection itemCollectionConnection;
        private final String name;
        private final OwnedBy ownedBy;
        private final Parent parent;
        private final PermissionsV2Api permissionsV2Api;
        private final String sha1;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy updatedBy;
        private final Watermark watermark;

        public static /* synthetic */ OnFile copy$default(OnFile onFile, String str, ItemType itemType, String str2, Date date, Date date2, Date date3, Date date4, Boolean bool, Integer num, Integer num2, ItemCollectionConnection itemCollectionConnection, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, Object obj, Boolean bool2, Boolean bool3, String str3, Watermark watermark, PermissionsV2Api permissionsV2Api, FileVersion fileVersion, int i, Object obj2) {
            FileVersion fileVersion2;
            PermissionsV2Api permissionsV2Api2;
            String str4 = (i & 1) != 0 ? onFile.id : str;
            ItemType itemType2 = (i & 2) != 0 ? onFile.type : itemType;
            String str5 = (i & 4) != 0 ? onFile.name : str2;
            Date date5 = (i & 8) != 0 ? onFile.createdAt : date;
            Date date6 = (i & 16) != 0 ? onFile.updatedAt : date2;
            Date date7 = (i & 32) != 0 ? onFile.contentCreatedAt : date3;
            Date date8 = (i & 64) != 0 ? onFile.contentUpdatedAt : date4;
            Boolean bool4 = (i & 128) != 0 ? onFile.isRooted : bool;
            Integer num3 = (i & 256) != 0 ? onFile.commentCount : num;
            Integer num4 = (i & 512) != 0 ? onFile.annotationCount : num2;
            ItemCollectionConnection itemCollectionConnection2 = (i & 1024) != 0 ? onFile.itemCollectionConnection : itemCollectionConnection;
            OwnedBy ownedBy2 = (i & 2048) != 0 ? onFile.ownedBy : ownedBy;
            UpdatedBy updatedBy2 = (i & 4096) != 0 ? onFile.updatedBy : updatedBy;
            Parent parent2 = (i & 8192) != 0 ? onFile.parent : parent;
            String str6 = str4;
            Object obj3 = (i & 16384) != 0 ? onFile.size : obj;
            Boolean bool5 = (i & 32768) != 0 ? onFile.hasCollaborations : bool2;
            Boolean bool6 = (i & 65536) != 0 ? onFile.isExternallyOwned : bool3;
            String str7 = (i & 131072) != 0 ? onFile.sha1 : str3;
            Watermark watermark2 = (i & 262144) != 0 ? onFile.watermark : watermark;
            PermissionsV2Api permissionsV2Api3 = (i & 524288) != 0 ? onFile.permissionsV2Api : permissionsV2Api;
            if ((i & 1048576) != 0) {
                permissionsV2Api2 = permissionsV2Api3;
                fileVersion2 = onFile.fileVersion;
            } else {
                fileVersion2 = fileVersion;
                permissionsV2Api2 = permissionsV2Api3;
            }
            return onFile.copy(str6, itemType2, str5, date5, date6, date7, date8, bool4, num3, num4, itemCollectionConnection2, ownedBy2, updatedBy2, parent2, obj3, bool5, bool6, str7, watermark2, permissionsV2Api2, fileVersion2);
        }

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getAnnotationCount() {
            return this.annotationCount;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final ItemCollectionConnection getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Parent getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getSha1() {
            return this.sha1;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Watermark getWatermark() {
            return this.watermark;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final FileVersion getFileVersion() {
            return this.fileVersion;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getIsRooted() {
            return this.isRooted;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getCommentCount() {
            return this.commentCount;
        }

        public final OnFile copy(String id, ItemType type, String name, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, Boolean isRooted, Integer commentCount, Integer annotationCount, ItemCollectionConnection itemCollectionConnection, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, Object size, Boolean hasCollaborations, Boolean isExternallyOwned, String sha1, Watermark watermark, PermissionsV2Api permissionsV2Api, FileVersion fileVersion) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnFile(id, type, name, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, isRooted, commentCount, annotationCount, itemCollectionConnection, ownedBy, updatedBy, parent, size, hasCollaborations, isExternallyOwned, sha1, watermark, permissionsV2Api, fileVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFile)) {
                return false;
            }
            OnFile onFile = (OnFile) other;
            return Intrinsics.areEqual(this.id, onFile.id) && this.type == onFile.type && Intrinsics.areEqual(this.name, onFile.name) && Intrinsics.areEqual(this.createdAt, onFile.createdAt) && Intrinsics.areEqual(this.updatedAt, onFile.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, onFile.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onFile.contentUpdatedAt) && Intrinsics.areEqual(this.isRooted, onFile.isRooted) && Intrinsics.areEqual(this.commentCount, onFile.commentCount) && Intrinsics.areEqual(this.annotationCount, onFile.annotationCount) && Intrinsics.areEqual(this.itemCollectionConnection, onFile.itemCollectionConnection) && Intrinsics.areEqual(this.ownedBy, onFile.ownedBy) && Intrinsics.areEqual(this.updatedBy, onFile.updatedBy) && Intrinsics.areEqual(this.parent, onFile.parent) && Intrinsics.areEqual(this.size, onFile.size) && Intrinsics.areEqual(this.hasCollaborations, onFile.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, onFile.isExternallyOwned) && Intrinsics.areEqual(this.sha1, onFile.sha1) && Intrinsics.areEqual(this.watermark, onFile.watermark) && Intrinsics.areEqual(this.permissionsV2Api, onFile.permissionsV2Api) && Intrinsics.areEqual(this.fileVersion, onFile.fileVersion);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode5 = (iHashCode4 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode6 = (iHashCode5 + (date4 == null ? 0 : date4.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num = this.commentCount;
            int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.annotationCount;
            int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
            ItemCollectionConnection itemCollectionConnection = this.itemCollectionConnection;
            int iHashCode10 = (iHashCode9 + (itemCollectionConnection == null ? 0 : itemCollectionConnection.hashCode())) * 31;
            OwnedBy ownedBy = this.ownedBy;
            int iHashCode11 = (iHashCode10 + (ownedBy == null ? 0 : ownedBy.hashCode())) * 31;
            UpdatedBy updatedBy = this.updatedBy;
            int iHashCode12 = (iHashCode11 + (updatedBy == null ? 0 : updatedBy.hashCode())) * 31;
            Parent parent = this.parent;
            int iHashCode13 = (iHashCode12 + (parent == null ? 0 : parent.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode14 = (iHashCode13 + (obj == null ? 0 : obj.hashCode())) * 31;
            Boolean bool2 = this.hasCollaborations;
            int iHashCode15 = (iHashCode14 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isExternallyOwned;
            int iHashCode16 = (iHashCode15 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str2 = this.sha1;
            int iHashCode17 = (iHashCode16 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Watermark watermark = this.watermark;
            int iHashCode18 = (iHashCode17 + (watermark == null ? 0 : watermark.hashCode())) * 31;
            PermissionsV2Api permissionsV2Api = this.permissionsV2Api;
            int iHashCode19 = (iHashCode18 + (permissionsV2Api == null ? 0 : permissionsV2Api.hashCode())) * 31;
            FileVersion fileVersion = this.fileVersion;
            return iHashCode19 + (fileVersion != null ? fileVersion.hashCode() : 0);
        }

        public String toString() {
            return "OnFile(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", isRooted=" + this.isRooted + ", commentCount=" + this.commentCount + ", annotationCount=" + this.annotationCount + ", itemCollectionConnection=" + this.itemCollectionConnection + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", sha1=" + this.sha1 + ", watermark=" + this.watermark + ", permissionsV2Api=" + this.permissionsV2Api + ", fileVersion=" + this.fileVersion + ")";
        }

        public OnFile(String id, ItemType type, String str, Date date, Date date2, Date date3, Date date4, Boolean bool, Integer num, Integer num2, ItemCollectionConnection itemCollectionConnection, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, Object obj, Boolean bool2, Boolean bool3, String str2, Watermark watermark, PermissionsV2Api permissionsV2Api, FileVersion fileVersion) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.isRooted = bool;
            this.commentCount = num;
            this.annotationCount = num2;
            this.itemCollectionConnection = itemCollectionConnection;
            this.ownedBy = ownedBy;
            this.updatedBy = updatedBy;
            this.parent = parent;
            this.size = obj;
            this.hasCollaborations = bool2;
            this.isExternallyOwned = bool3;
            this.sha1 = str2;
            this.watermark = watermark;
            this.permissionsV2Api = permissionsV2Api;
            this.fileVersion = fileVersion;
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

        public final Integer getCommentCount() {
            return this.commentCount;
        }

        public final Integer getAnnotationCount() {
            return this.annotationCount;
        }

        public final ItemCollectionConnection getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        public final Parent getParent() {
            return this.parent;
        }

        public final Object getSize() {
            return this.size;
        }

        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        public final Boolean isExternallyOwned() {
            return this.isExternallyOwned;
        }

        public final String getSha1() {
            return this.sha1;
        }

        public final Watermark getWatermark() {
            return this.watermark;
        }

        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final FileVersion getFileVersion() {
            return this.fileVersion;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection;", "", "edges", "", "Lcom/box/android/data/CopyItemMutation$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Edge;", "", "id", "", "node", "Lcom/box/android/data/CopyItemMutation$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/CopyItemMutation$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/CopyItemMutation$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Node;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$OwnedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$UpdatedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Parent;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Watermark;", "", "isWatermarked", "", "<init>", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;)Lcom/box/android/data/CopyItemMutation$Watermark;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Watermark {
        private final Boolean isWatermarked;

        public static /* synthetic */ Watermark copy$default(Watermark watermark, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = watermark.isWatermarked;
            }
            return watermark.copy(bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsWatermarked() {
            return this.isWatermarked;
        }

        public final Watermark copy(Boolean isWatermarked) {
            return new Watermark(isWatermarked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Watermark) && Intrinsics.areEqual(this.isWatermarked, ((Watermark) other).isWatermarked);
        }

        public int hashCode() {
            Boolean bool = this.isWatermarked;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "Watermark(isWatermarked=" + this.isWatermarked + ")";
        }

        public Watermark(Boolean bool) {
            this.isWatermarked = bool;
        }

        public final Boolean isWatermarked() {
            return this.isWatermarked;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/CopyItemMutation$PermissionsV2Api;", "", "canComment", "", "canCreateAnnotations", "canDelete", "canDownload", "canInviteCollaborator", "canPreview", "canRename", "canSetShareAccess", "canShare", "canUpload", "canViewAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanComment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanCreateAnnotations", "getCanDelete", "getCanDownload", "getCanInviteCollaborator", "getCanPreview", "getCanRename", "getCanSetShareAccess", "getCanShare", "getCanUpload", "getCanViewAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/CopyItemMutation$PermissionsV2Api;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                bool = permissionsV2Api.canComment;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api.canCreateAnnotations;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api.canDelete;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api.canDownload;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api.canInviteCollaborator;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api.canPreview;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api.canRename;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api.canSetShareAccess;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api.canShare;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api.canUpload;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api.canViewAnnotations;
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
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api copy(Boolean canComment, Boolean canCreateAnnotations, Boolean canDelete, Boolean canDownload, Boolean canInviteCollaborator, Boolean canPreview, Boolean canRename, Boolean canSetShareAccess, Boolean canShare, Boolean canUpload, Boolean canViewAnnotations) {
            return new PermissionsV2Api(canComment, canCreateAnnotations, canDelete, canDownload, canInviteCollaborator, canPreview, canRename, canSetShareAccess, canShare, canUpload, canViewAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api)) {
                return false;
            }
            PermissionsV2Api permissionsV2Api = (PermissionsV2Api) other;
            return Intrinsics.areEqual(this.canComment, permissionsV2Api.canComment) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api.canCreateAnnotations) && Intrinsics.areEqual(this.canDelete, permissionsV2Api.canDelete) && Intrinsics.areEqual(this.canDownload, permissionsV2Api.canDownload) && Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api.canInviteCollaborator) && Intrinsics.areEqual(this.canPreview, permissionsV2Api.canPreview) && Intrinsics.areEqual(this.canRename, permissionsV2Api.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api.canShare) && Intrinsics.areEqual(this.canUpload, permissionsV2Api.canUpload) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api.canViewAnnotations);
        }

        public int hashCode() {
            Boolean bool = this.canComment;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canCreateAnnotations;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDelete;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canDownload;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canInviteCollaborator;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canPreview;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canRename;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canSetShareAccess;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canShare;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canUpload;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canViewAnnotations;
            return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api(canComment=" + this.canComment + ", canCreateAnnotations=" + this.canCreateAnnotations + ", canDelete=" + this.canDelete + ", canDownload=" + this.canDownload + ", canInviteCollaborator=" + this.canInviteCollaborator + ", canPreview=" + this.canPreview + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ", canUpload=" + this.canUpload + ", canViewAnnotations=" + this.canViewAnnotations + ")";
        }

        public PermissionsV2Api(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
            this.canComment = bool;
            this.canCreateAnnotations = bool2;
            this.canDelete = bool3;
            this.canDownload = bool4;
            this.canInviteCollaborator = bool5;
            this.canPreview = bool6;
            this.canRename = bool7;
            this.canSetShareAccess = bool8;
            this.canShare = bool9;
            this.canUpload = bool10;
            this.canViewAnnotations = bool11;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$FileVersion;", "", "id", "", "sha1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSha1", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileVersion {
        private final String id;
        private final String sha1;

        public static /* synthetic */ FileVersion copy$default(FileVersion fileVersion, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileVersion.id;
            }
            if ((i & 2) != 0) {
                str2 = fileVersion.sha1;
            }
            return fileVersion.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSha1() {
            return this.sha1;
        }

        public final FileVersion copy(String id, String sha1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            return new FileVersion(id, sha1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileVersion)) {
                return false;
            }
            FileVersion fileVersion = (FileVersion) other;
            return Intrinsics.areEqual(this.id, fileVersion.id) && Intrinsics.areEqual(this.sha1, fileVersion.sha1);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.sha1.hashCode();
        }

        public String toString() {
            return "FileVersion(id=" + this.id + ", sha1=" + this.sha1 + ")";
        }

        public FileVersion(String id, String sha1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            this.id = id;
            this.sha1 = sha1;
        }

        public final String getId() {
            return this.id;
        }

        public final String getSha1() {
            return this.sha1;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010@\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010G\u001a\u0004\u0018\u00010\u001aHÆ\u0003JÊ\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\r2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020MHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\f\u0010'R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b5\u0010'R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\u0018\u0010'R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006O"}, d2 = {"Lcom/box/android/data/CopyItemMutation$OnFolder;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "", "itemCollectionConnection", "Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection1;", "ownedBy", "Lcom/box/android/data/CopyItemMutation$OwnedBy1;", "updatedBy", "Lcom/box/android/data/CopyItemMutation$UpdatedBy1;", "parent", "Lcom/box/android/data/CopyItemMutation$Parent1;", "size", "hasCollaborations", "isExternallyOwned", "permissionsV2Api", "Lcom/box/android/data/CopyItemMutation$PermissionsV2Api1;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection1;Lcom/box/android/data/CopyItemMutation$OwnedBy1;Lcom/box/android/data/CopyItemMutation$UpdatedBy1;Lcom/box/android/data/CopyItemMutation$Parent1;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/CopyItemMutation$PermissionsV2Api1;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection1;", "getOwnedBy", "()Lcom/box/android/data/CopyItemMutation$OwnedBy1;", "getUpdatedBy", "()Lcom/box/android/data/CopyItemMutation$UpdatedBy1;", "getParent", "()Lcom/box/android/data/CopyItemMutation$Parent1;", "getSize", "()Ljava/lang/Object;", "getHasCollaborations", "getPermissionsV2Api", "()Lcom/box/android/data/CopyItemMutation$PermissionsV2Api1;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection1;Lcom/box/android/data/CopyItemMutation$OwnedBy1;Lcom/box/android/data/CopyItemMutation$UpdatedBy1;Lcom/box/android/data/CopyItemMutation$Parent1;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/CopyItemMutation$PermissionsV2Api1;)Lcom/box/android/data/CopyItemMutation$OnFolder;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnFolder {
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final Boolean hasCollaborations;
        private final String id;
        private final Boolean isExternallyOwned;
        private final Boolean isRooted;
        private final ItemCollectionConnection1 itemCollectionConnection;
        private final String name;
        private final OwnedBy1 ownedBy;
        private final Parent1 parent;
        private final PermissionsV2Api1 permissionsV2Api;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy1 updatedBy;

        public static /* synthetic */ OnFolder copy$default(OnFolder onFolder, String str, ItemType itemType, String str2, Date date, Date date2, Date date3, Date date4, Boolean bool, ItemCollectionConnection1 itemCollectionConnection1, OwnedBy1 ownedBy1, UpdatedBy1 updatedBy1, Parent1 parent1, Object obj, Boolean bool2, Boolean bool3, PermissionsV2Api1 permissionsV2Api1, int i, Object obj2) {
            String str3 = (i & 1) != 0 ? onFolder.id : str;
            return onFolder.copy(str3, (i & 2) != 0 ? onFolder.type : itemType, (i & 4) != 0 ? onFolder.name : str2, (i & 8) != 0 ? onFolder.createdAt : date, (i & 16) != 0 ? onFolder.updatedAt : date2, (i & 32) != 0 ? onFolder.contentCreatedAt : date3, (i & 64) != 0 ? onFolder.contentUpdatedAt : date4, (i & 128) != 0 ? onFolder.isRooted : bool, (i & 256) != 0 ? onFolder.itemCollectionConnection : itemCollectionConnection1, (i & 512) != 0 ? onFolder.ownedBy : ownedBy1, (i & 1024) != 0 ? onFolder.updatedBy : updatedBy1, (i & 2048) != 0 ? onFolder.parent : parent1, (i & 4096) != 0 ? onFolder.size : obj, (i & 8192) != 0 ? onFolder.hasCollaborations : bool2, (i & 16384) != 0 ? onFolder.isExternallyOwned : bool3, (i & 32768) != 0 ? onFolder.permissionsV2Api : permissionsV2Api1);
        }

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final OwnedBy1 getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final UpdatedBy1 getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Parent1 getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final PermissionsV2Api1 getPermissionsV2Api() {
            return this.permissionsV2Api;
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
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getIsRooted() {
            return this.isRooted;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final ItemCollectionConnection1 getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        public final OnFolder copy(String id, ItemType type, String name, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, Boolean isRooted, ItemCollectionConnection1 itemCollectionConnection, OwnedBy1 ownedBy, UpdatedBy1 updatedBy, Parent1 parent, Object size, Boolean hasCollaborations, Boolean isExternallyOwned, PermissionsV2Api1 permissionsV2Api) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnFolder(id, type, name, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, isRooted, itemCollectionConnection, ownedBy, updatedBy, parent, size, hasCollaborations, isExternallyOwned, permissionsV2Api);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFolder)) {
                return false;
            }
            OnFolder onFolder = (OnFolder) other;
            return Intrinsics.areEqual(this.id, onFolder.id) && this.type == onFolder.type && Intrinsics.areEqual(this.name, onFolder.name) && Intrinsics.areEqual(this.createdAt, onFolder.createdAt) && Intrinsics.areEqual(this.updatedAt, onFolder.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, onFolder.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onFolder.contentUpdatedAt) && Intrinsics.areEqual(this.isRooted, onFolder.isRooted) && Intrinsics.areEqual(this.itemCollectionConnection, onFolder.itemCollectionConnection) && Intrinsics.areEqual(this.ownedBy, onFolder.ownedBy) && Intrinsics.areEqual(this.updatedBy, onFolder.updatedBy) && Intrinsics.areEqual(this.parent, onFolder.parent) && Intrinsics.areEqual(this.size, onFolder.size) && Intrinsics.areEqual(this.hasCollaborations, onFolder.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, onFolder.isExternallyOwned) && Intrinsics.areEqual(this.permissionsV2Api, onFolder.permissionsV2Api);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode5 = (iHashCode4 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode6 = (iHashCode5 + (date4 == null ? 0 : date4.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
            ItemCollectionConnection1 itemCollectionConnection1 = this.itemCollectionConnection;
            int iHashCode8 = (iHashCode7 + (itemCollectionConnection1 == null ? 0 : itemCollectionConnection1.hashCode())) * 31;
            OwnedBy1 ownedBy1 = this.ownedBy;
            int iHashCode9 = (iHashCode8 + (ownedBy1 == null ? 0 : ownedBy1.hashCode())) * 31;
            UpdatedBy1 updatedBy1 = this.updatedBy;
            int iHashCode10 = (iHashCode9 + (updatedBy1 == null ? 0 : updatedBy1.hashCode())) * 31;
            Parent1 parent1 = this.parent;
            int iHashCode11 = (iHashCode10 + (parent1 == null ? 0 : parent1.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode12 = (iHashCode11 + (obj == null ? 0 : obj.hashCode())) * 31;
            Boolean bool2 = this.hasCollaborations;
            int iHashCode13 = (iHashCode12 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isExternallyOwned;
            int iHashCode14 = (iHashCode13 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            PermissionsV2Api1 permissionsV2Api1 = this.permissionsV2Api;
            return iHashCode14 + (permissionsV2Api1 != null ? permissionsV2Api1.hashCode() : 0);
        }

        public String toString() {
            return "OnFolder(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", isRooted=" + this.isRooted + ", itemCollectionConnection=" + this.itemCollectionConnection + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", permissionsV2Api=" + this.permissionsV2Api + ")";
        }

        public OnFolder(String id, ItemType type, String str, Date date, Date date2, Date date3, Date date4, Boolean bool, ItemCollectionConnection1 itemCollectionConnection1, OwnedBy1 ownedBy1, UpdatedBy1 updatedBy1, Parent1 parent1, Object obj, Boolean bool2, Boolean bool3, PermissionsV2Api1 permissionsV2Api1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.isRooted = bool;
            this.itemCollectionConnection = itemCollectionConnection1;
            this.ownedBy = ownedBy1;
            this.updatedBy = updatedBy1;
            this.parent = parent1;
            this.size = obj;
            this.hasCollaborations = bool2;
            this.isExternallyOwned = bool3;
            this.permissionsV2Api = permissionsV2Api1;
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

        public final ItemCollectionConnection1 getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        public final OwnedBy1 getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy1 getUpdatedBy() {
            return this.updatedBy;
        }

        public final Parent1 getParent() {
            return this.parent;
        }

        public final Object getSize() {
            return this.size;
        }

        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        public final Boolean isExternallyOwned() {
            return this.isExternallyOwned;
        }

        public final PermissionsV2Api1 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection1;", "", "edges", "", "Lcom/box/android/data/CopyItemMutation$Edge1;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemCollectionConnection1 {
        private final List<Edge1> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemCollectionConnection1 copy$default(ItemCollectionConnection1 itemCollectionConnection1, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemCollectionConnection1.edges;
            }
            return itemCollectionConnection1.copy(list);
        }

        public final List<Edge1> component1() {
            return this.edges;
        }

        public final ItemCollectionConnection1 copy(List<Edge1> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemCollectionConnection1(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemCollectionConnection1) && Intrinsics.areEqual(this.edges, ((ItemCollectionConnection1) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemCollectionConnection1(edges=" + this.edges + ")";
        }

        public ItemCollectionConnection1(List<Edge1> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge1> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Edge1;", "", "id", "", "node", "Lcom/box/android/data/CopyItemMutation$Node1;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/CopyItemMutation$Node1;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/CopyItemMutation$Node1;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge1 {
        private final String id;
        private final Node1 node;

        public static /* synthetic */ Edge1 copy$default(Edge1 edge1, String str, Node1 node1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge1.id;
            }
            if ((i & 2) != 0) {
                node1 = edge1.node;
            }
            return edge1.copy(str, node1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Node1 getNode() {
            return this.node;
        }

        public final Edge1 copy(String id, Node1 node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge1(id, node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edge1)) {
                return false;
            }
            Edge1 edge1 = (Edge1) other;
            return Intrinsics.areEqual(this.id, edge1.id) && Intrinsics.areEqual(this.node, edge1.node);
        }

        public int hashCode() {
            String str = this.id;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Edge1(id=" + this.id + ", node=" + this.node + ")";
        }

        public Edge1(String str, Node1 node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.id = str;
            this.node = node;
        }

        public final String getId() {
            return this.id;
        }

        public final Node1 getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Node1;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node1 {
        private final String collectionType;
        private final String id;
        private final String name;

        public static /* synthetic */ Node1 copy$default(Node1 node1, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node1.id;
            }
            if ((i & 2) != 0) {
                str2 = node1.name;
            }
            if ((i & 4) != 0) {
                str3 = node1.collectionType;
            }
            return node1.copy(str, str2, str3);
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

        public final Node1 copy(String id, String name, String collectionType) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node1(id, name, collectionType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node1)) {
                return false;
            }
            Node1 node1 = (Node1) other;
            return Intrinsics.areEqual(this.id, node1.id) && Intrinsics.areEqual(this.name, node1.name) && Intrinsics.areEqual(this.collectionType, node1.collectionType);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.collectionType;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Node1(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ")";
        }

        public Node1(String id, String str, String str2) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$OwnedBy1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy1 {
        private final String id;
        private final String name;

        public static /* synthetic */ OwnedBy1 copy$default(OwnedBy1 ownedBy1, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy1.id;
            }
            if ((i & 2) != 0) {
                str2 = ownedBy1.name;
            }
            return ownedBy1.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final OwnedBy1 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy1(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedBy1)) {
                return false;
            }
            OwnedBy1 ownedBy1 = (OwnedBy1) other;
            return Intrinsics.areEqual(this.id, ownedBy1.id) && Intrinsics.areEqual(this.name, ownedBy1.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "OwnedBy1(id=" + this.id + ", name=" + this.name + ")";
        }

        public OwnedBy1(String id, String str) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$UpdatedBy1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy1 {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy1 copy$default(UpdatedBy1 updatedBy1, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy1.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy1.name;
            }
            return updatedBy1.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy1 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy1(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy1)) {
                return false;
            }
            UpdatedBy1 updatedBy1 = (UpdatedBy1) other;
            return Intrinsics.areEqual(this.id, updatedBy1.id) && Intrinsics.areEqual(this.name, updatedBy1.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy1(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy1(String id, String str) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Parent1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent1 {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent1 copy$default(Parent1 parent1, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent1.id;
            }
            if ((i & 2) != 0) {
                str2 = parent1.name;
            }
            return parent1.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent1 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent1(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent1)) {
                return false;
            }
            Parent1 parent1 = (Parent1) other;
            return Intrinsics.areEqual(this.id, parent1.id) && Intrinsics.areEqual(this.name, parent1.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent1(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent1(String id, String str) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/box/android/data/CopyItemMutation$PermissionsV2Api1;", "", "canDelete", "", "canDownload", "canInviteCollaborator", "canRename", "canSetShareAccess", "canShare", "canUpload", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanDelete", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanDownload", "getCanInviteCollaborator", "getCanRename", "getCanSetShareAccess", "getCanShare", "getCanUpload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/CopyItemMutation$PermissionsV2Api1;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api1 {
        private final Boolean canDelete;
        private final Boolean canDownload;
        private final Boolean canInviteCollaborator;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;
        private final Boolean canUpload;

        public static /* synthetic */ PermissionsV2Api1 copy$default(PermissionsV2Api1 permissionsV2Api1, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api1.canDelete;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api1.canDownload;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api1.canInviteCollaborator;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api1.canRename;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api1.canSetShareAccess;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api1.canShare;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api1.canUpload;
            }
            Boolean bool8 = bool6;
            Boolean bool9 = bool7;
            Boolean bool10 = bool5;
            Boolean bool11 = bool3;
            return permissionsV2Api1.copy(bool, bool2, bool11, bool4, bool10, bool8, bool9);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final PermissionsV2Api1 copy(Boolean canDelete, Boolean canDownload, Boolean canInviteCollaborator, Boolean canRename, Boolean canSetShareAccess, Boolean canShare, Boolean canUpload) {
            return new PermissionsV2Api1(canDelete, canDownload, canInviteCollaborator, canRename, canSetShareAccess, canShare, canUpload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api1)) {
                return false;
            }
            PermissionsV2Api1 permissionsV2Api1 = (PermissionsV2Api1) other;
            return Intrinsics.areEqual(this.canDelete, permissionsV2Api1.canDelete) && Intrinsics.areEqual(this.canDownload, permissionsV2Api1.canDownload) && Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api1.canInviteCollaborator) && Intrinsics.areEqual(this.canRename, permissionsV2Api1.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api1.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api1.canShare) && Intrinsics.areEqual(this.canUpload, permissionsV2Api1.canUpload);
        }

        public int hashCode() {
            Boolean bool = this.canDelete;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canDownload;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canInviteCollaborator;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canRename;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canSetShareAccess;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canShare;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canUpload;
            return iHashCode6 + (bool7 != null ? bool7.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api1(canDelete=" + this.canDelete + ", canDownload=" + this.canDownload + ", canInviteCollaborator=" + this.canInviteCollaborator + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ", canUpload=" + this.canUpload + ")";
        }

        public PermissionsV2Api1(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
            this.canDelete = bool;
            this.canDownload = bool2;
            this.canInviteCollaborator = bool3;
            this.canRename = bool4;
            this.canSetShareAccess = bool5;
            this.canShare = bool6;
            this.canUpload = bool7;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u009a\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\n\u0010!R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006D"}, d2 = {"Lcom/box/android/data/CopyItemMutation$OnWeblink;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "updatedAt", "isRooted", "", "itemCollectionConnection", "Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection2;", "ownedBy", "Lcom/box/android/data/CopyItemMutation$OwnedBy2;", "updatedBy", "Lcom/box/android/data/CopyItemMutation$UpdatedBy2;", "parent", "Lcom/box/android/data/CopyItemMutation$Parent2;", "url", "permissionsV2Api", "Lcom/box/android/data/CopyItemMutation$PermissionsV2Api2;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection2;Lcom/box/android/data/CopyItemMutation$OwnedBy2;Lcom/box/android/data/CopyItemMutation$UpdatedBy2;Lcom/box/android/data/CopyItemMutation$Parent2;Ljava/lang/Object;Lcom/box/android/data/CopyItemMutation$PermissionsV2Api2;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection2;", "getOwnedBy", "()Lcom/box/android/data/CopyItemMutation$OwnedBy2;", "getUpdatedBy", "()Lcom/box/android/data/CopyItemMutation$UpdatedBy2;", "getParent", "()Lcom/box/android/data/CopyItemMutation$Parent2;", "getUrl", "()Ljava/lang/Object;", "getPermissionsV2Api", "()Lcom/box/android/data/CopyItemMutation$PermissionsV2Api2;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection2;Lcom/box/android/data/CopyItemMutation$OwnedBy2;Lcom/box/android/data/CopyItemMutation$UpdatedBy2;Lcom/box/android/data/CopyItemMutation$Parent2;Ljava/lang/Object;Lcom/box/android/data/CopyItemMutation$PermissionsV2Api2;)Lcom/box/android/data/CopyItemMutation$OnWeblink;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnWeblink {
        private final Date createdAt;
        private final String id;
        private final Boolean isRooted;
        private final ItemCollectionConnection2 itemCollectionConnection;
        private final String name;
        private final OwnedBy2 ownedBy;
        private final Parent2 parent;
        private final PermissionsV2Api2 permissionsV2Api;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy2 updatedBy;
        private final Object url;

        public static /* synthetic */ OnWeblink copy$default(OnWeblink onWeblink, String str, ItemType itemType, String str2, Date date, Date date2, Boolean bool, ItemCollectionConnection2 itemCollectionConnection2, OwnedBy2 ownedBy2, UpdatedBy2 updatedBy2, Parent2 parent2, Object obj, PermissionsV2Api2 permissionsV2Api2, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = onWeblink.id;
            }
            if ((i & 2) != 0) {
                itemType = onWeblink.type;
            }
            if ((i & 4) != 0) {
                str2 = onWeblink.name;
            }
            if ((i & 8) != 0) {
                date = onWeblink.createdAt;
            }
            if ((i & 16) != 0) {
                date2 = onWeblink.updatedAt;
            }
            if ((i & 32) != 0) {
                bool = onWeblink.isRooted;
            }
            if ((i & 64) != 0) {
                itemCollectionConnection2 = onWeblink.itemCollectionConnection;
            }
            if ((i & 128) != 0) {
                ownedBy2 = onWeblink.ownedBy;
            }
            if ((i & 256) != 0) {
                updatedBy2 = onWeblink.updatedBy;
            }
            if ((i & 512) != 0) {
                parent2 = onWeblink.parent;
            }
            if ((i & 1024) != 0) {
                obj = onWeblink.url;
            }
            if ((i & 2048) != 0) {
                permissionsV2Api2 = onWeblink.permissionsV2Api;
            }
            Object obj3 = obj;
            PermissionsV2Api2 permissionsV2Api3 = permissionsV2Api2;
            UpdatedBy2 updatedBy3 = updatedBy2;
            Parent2 parent3 = parent2;
            ItemCollectionConnection2 itemCollectionConnection3 = itemCollectionConnection2;
            OwnedBy2 ownedBy3 = ownedBy2;
            Date date3 = date2;
            Boolean bool2 = bool;
            return onWeblink.copy(str, itemType, str2, date, date3, bool2, itemCollectionConnection3, ownedBy3, updatedBy3, parent3, obj3, permissionsV2Api3);
        }

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Parent2 getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Object getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final PermissionsV2Api2 getPermissionsV2Api() {
            return this.permissionsV2Api;
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
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsRooted() {
            return this.isRooted;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ItemCollectionConnection2 getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final OwnedBy2 getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final UpdatedBy2 getUpdatedBy() {
            return this.updatedBy;
        }

        public final OnWeblink copy(String id, ItemType type, String name, Date createdAt, Date updatedAt, Boolean isRooted, ItemCollectionConnection2 itemCollectionConnection, OwnedBy2 ownedBy, UpdatedBy2 updatedBy, Parent2 parent, Object url, PermissionsV2Api2 permissionsV2Api) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnWeblink(id, type, name, createdAt, updatedAt, isRooted, itemCollectionConnection, ownedBy, updatedBy, parent, url, permissionsV2Api);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnWeblink)) {
                return false;
            }
            OnWeblink onWeblink = (OnWeblink) other;
            return Intrinsics.areEqual(this.id, onWeblink.id) && this.type == onWeblink.type && Intrinsics.areEqual(this.name, onWeblink.name) && Intrinsics.areEqual(this.createdAt, onWeblink.createdAt) && Intrinsics.areEqual(this.updatedAt, onWeblink.updatedAt) && Intrinsics.areEqual(this.isRooted, onWeblink.isRooted) && Intrinsics.areEqual(this.itemCollectionConnection, onWeblink.itemCollectionConnection) && Intrinsics.areEqual(this.ownedBy, onWeblink.ownedBy) && Intrinsics.areEqual(this.updatedBy, onWeblink.updatedBy) && Intrinsics.areEqual(this.parent, onWeblink.parent) && Intrinsics.areEqual(this.url, onWeblink.url) && Intrinsics.areEqual(this.permissionsV2Api, onWeblink.permissionsV2Api);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
            ItemCollectionConnection2 itemCollectionConnection2 = this.itemCollectionConnection;
            int iHashCode6 = (iHashCode5 + (itemCollectionConnection2 == null ? 0 : itemCollectionConnection2.hashCode())) * 31;
            OwnedBy2 ownedBy2 = this.ownedBy;
            int iHashCode7 = (iHashCode6 + (ownedBy2 == null ? 0 : ownedBy2.hashCode())) * 31;
            UpdatedBy2 updatedBy2 = this.updatedBy;
            int iHashCode8 = (iHashCode7 + (updatedBy2 == null ? 0 : updatedBy2.hashCode())) * 31;
            Parent2 parent2 = this.parent;
            int iHashCode9 = (iHashCode8 + (parent2 == null ? 0 : parent2.hashCode())) * 31;
            Object obj = this.url;
            int iHashCode10 = (iHashCode9 + (obj == null ? 0 : obj.hashCode())) * 31;
            PermissionsV2Api2 permissionsV2Api2 = this.permissionsV2Api;
            return iHashCode10 + (permissionsV2Api2 != null ? permissionsV2Api2.hashCode() : 0);
        }

        public String toString() {
            return "OnWeblink(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isRooted=" + this.isRooted + ", itemCollectionConnection=" + this.itemCollectionConnection + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", url=" + this.url + ", permissionsV2Api=" + this.permissionsV2Api + ")";
        }

        public OnWeblink(String id, ItemType type, String str, Date date, Date date2, Boolean bool, ItemCollectionConnection2 itemCollectionConnection2, OwnedBy2 ownedBy2, UpdatedBy2 updatedBy2, Parent2 parent2, Object obj, PermissionsV2Api2 permissionsV2Api2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.updatedAt = date2;
            this.isRooted = bool;
            this.itemCollectionConnection = itemCollectionConnection2;
            this.ownedBy = ownedBy2;
            this.updatedBy = updatedBy2;
            this.parent = parent2;
            this.url = obj;
            this.permissionsV2Api = permissionsV2Api2;
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

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        public final Boolean isRooted() {
            return this.isRooted;
        }

        public final ItemCollectionConnection2 getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        public final OwnedBy2 getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy2 getUpdatedBy() {
            return this.updatedBy;
        }

        public final Parent2 getParent() {
            return this.parent;
        }

        public final Object getUrl() {
            return this.url;
        }

        public final PermissionsV2Api2 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/CopyItemMutation$ItemCollectionConnection2;", "", "edges", "", "Lcom/box/android/data/CopyItemMutation$Edge2;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemCollectionConnection2 {
        private final List<Edge2> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemCollectionConnection2 copy$default(ItemCollectionConnection2 itemCollectionConnection2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemCollectionConnection2.edges;
            }
            return itemCollectionConnection2.copy(list);
        }

        public final List<Edge2> component1() {
            return this.edges;
        }

        public final ItemCollectionConnection2 copy(List<Edge2> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemCollectionConnection2(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemCollectionConnection2) && Intrinsics.areEqual(this.edges, ((ItemCollectionConnection2) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemCollectionConnection2(edges=" + this.edges + ")";
        }

        public ItemCollectionConnection2(List<Edge2> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge2> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Edge2;", "", "id", "", "node", "Lcom/box/android/data/CopyItemMutation$Node2;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/CopyItemMutation$Node2;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/CopyItemMutation$Node2;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge2 {
        private final String id;
        private final Node2 node;

        public static /* synthetic */ Edge2 copy$default(Edge2 edge2, String str, Node2 node2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge2.id;
            }
            if ((i & 2) != 0) {
                node2 = edge2.node;
            }
            return edge2.copy(str, node2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Node2 getNode() {
            return this.node;
        }

        public final Edge2 copy(String id, Node2 node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge2(id, node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edge2)) {
                return false;
            }
            Edge2 edge2 = (Edge2) other;
            return Intrinsics.areEqual(this.id, edge2.id) && Intrinsics.areEqual(this.node, edge2.node);
        }

        public int hashCode() {
            String str = this.id;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Edge2(id=" + this.id + ", node=" + this.node + ")";
        }

        public Edge2(String str, Node2 node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.id = str;
            this.node = node;
        }

        public final String getId() {
            return this.id;
        }

        public final Node2 getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Node2;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node2 {
        private final String collectionType;
        private final String id;
        private final String name;

        public static /* synthetic */ Node2 copy$default(Node2 node2, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node2.id;
            }
            if ((i & 2) != 0) {
                str2 = node2.name;
            }
            if ((i & 4) != 0) {
                str3 = node2.collectionType;
            }
            return node2.copy(str, str2, str3);
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

        public final Node2 copy(String id, String name, String collectionType) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node2(id, name, collectionType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node2)) {
                return false;
            }
            Node2 node2 = (Node2) other;
            return Intrinsics.areEqual(this.id, node2.id) && Intrinsics.areEqual(this.name, node2.name) && Intrinsics.areEqual(this.collectionType, node2.collectionType);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.collectionType;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Node2(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ")";
        }

        public Node2(String id, String str, String str2) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$OwnedBy2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy2 {
        private final String id;
        private final String name;

        public static /* synthetic */ OwnedBy2 copy$default(OwnedBy2 ownedBy2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy2.id;
            }
            if ((i & 2) != 0) {
                str2 = ownedBy2.name;
            }
            return ownedBy2.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final OwnedBy2 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy2(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedBy2)) {
                return false;
            }
            OwnedBy2 ownedBy2 = (OwnedBy2) other;
            return Intrinsics.areEqual(this.id, ownedBy2.id) && Intrinsics.areEqual(this.name, ownedBy2.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "OwnedBy2(id=" + this.id + ", name=" + this.name + ")";
        }

        public OwnedBy2(String id, String str) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$UpdatedBy2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy2 {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy2 copy$default(UpdatedBy2 updatedBy2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy2.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy2.name;
            }
            return updatedBy2.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy2 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy2(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy2)) {
                return false;
            }
            UpdatedBy2 updatedBy2 = (UpdatedBy2) other;
            return Intrinsics.areEqual(this.id, updatedBy2.id) && Intrinsics.areEqual(this.name, updatedBy2.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy2(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy2(String id, String str) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Parent2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent2 {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent2 copy$default(Parent2 parent2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent2.id;
            }
            if ((i & 2) != 0) {
                str2 = parent2.name;
            }
            return parent2.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent2 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent2(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent2)) {
                return false;
            }
            Parent2 parent2 = (Parent2) other;
            return Intrinsics.areEqual(this.id, parent2.id) && Intrinsics.areEqual(this.name, parent2.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent2(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent2(String id, String str) {
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

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/CopyItemMutation$PermissionsV2Api2;", "", "canComment", "", "canDelete", "canRename", "canSetShareAccess", "canShare", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanComment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanDelete", "getCanRename", "getCanSetShareAccess", "getCanShare", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/CopyItemMutation$PermissionsV2Api2;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api2 {
        private final Boolean canComment;
        private final Boolean canDelete;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;

        public static /* synthetic */ PermissionsV2Api2 copy$default(PermissionsV2Api2 permissionsV2Api2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api2.canComment;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api2.canDelete;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api2.canRename;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api2.canSetShareAccess;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api2.canShare;
            }
            Boolean bool6 = bool5;
            Boolean bool7 = bool3;
            return permissionsV2Api2.copy(bool, bool2, bool7, bool4, bool6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api2 copy(Boolean canComment, Boolean canDelete, Boolean canRename, Boolean canSetShareAccess, Boolean canShare) {
            return new PermissionsV2Api2(canComment, canDelete, canRename, canSetShareAccess, canShare);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api2)) {
                return false;
            }
            PermissionsV2Api2 permissionsV2Api2 = (PermissionsV2Api2) other;
            return Intrinsics.areEqual(this.canComment, permissionsV2Api2.canComment) && Intrinsics.areEqual(this.canDelete, permissionsV2Api2.canDelete) && Intrinsics.areEqual(this.canRename, permissionsV2Api2.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api2.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api2.canShare);
        }

        public int hashCode() {
            Boolean bool = this.canComment;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canDelete;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canRename;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canSetShareAccess;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canShare;
            return iHashCode4 + (bool5 != null ? bool5.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api2(canComment=" + this.canComment + ", canDelete=" + this.canDelete + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ")";
        }

        public PermissionsV2Api2(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
            this.canComment = bool;
            this.canDelete = bool2;
            this.canRename = bool3;
            this.canSetShareAccess = bool4;
            this.canShare = bool5;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }
    }

    /* JADX INFO: compiled from: CopyItemMutation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/CopyItemMutation$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "mutation CopyItem($id: String!, $type: ItemType!, $newParentId: String!, $newName: String, $clientMutationId: String) { copyItem(input: { clientMutationId: $clientMutationId itemId: $id newName: $newName newParentId: $newParentId type: $type } ) { __typename ... on File { id type name createdAt updatedAt contentCreatedAt contentUpdatedAt isRooted commentCount annotationCount itemCollectionConnection { edges { id: cursor node { id name collectionType } } } ownedBy { id name } updatedBy { id name } parent { id name } size hasCollaborations isExternallyOwned sha1 watermark { isWatermarked } permissionsV2Api { canComment canCreateAnnotations canDelete canDownload canInviteCollaborator canPreview canRename canSetShareAccess canShare canUpload canViewAnnotations } fileVersion { id sha1 } } ... on Folder { id type name createdAt updatedAt contentCreatedAt contentUpdatedAt isRooted itemCollectionConnection { edges { id: cursor node { id name collectionType } } } ownedBy { id name } updatedBy { id name } parent { id name } size hasCollaborations isExternallyOwned permissionsV2Api { canDelete canDownload canInviteCollaborator canRename canSetShareAccess canShare canUpload } } ... on Weblink { id type name createdAt updatedAt isRooted itemCollectionConnection { edges { id: cursor node { id name collectionType } } } ownedBy { id name } updatedBy { id name } parent { id name } url permissionsV2Api { canComment canDelete canRename canSetShareAccess canShare } } } }";
        }
    }
}
