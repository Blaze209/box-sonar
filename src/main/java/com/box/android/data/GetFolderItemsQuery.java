package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetFolderItemsQuery_ResponseAdapter;
import com.box.android.data.adapter.GetFolderItemsQuery_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.selections.GetFolderItemsQuerySelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetFolderItemsQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/box/android/data/GetFolderItemsQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetFolderItemsQuery$Data;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "Folder", GQLCacheConstants.TYPENAME_ITEM_CONNECTION, "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetFolderItemsQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "aecde8e8318c2ed249374aaa5d4c53c1282e48d9ced16df4d1232d94ac58edf9";
    public static final String OPERATION_NAME = "GetFolderItems";
    private final String id;

    public static /* synthetic */ GetFolderItemsQuery copy$default(GetFolderItemsQuery getFolderItemsQuery, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getFolderItemsQuery.id;
        }
        return getFolderItemsQuery.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final GetFolderItemsQuery copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new GetFolderItemsQuery(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetFolderItemsQuery) && Intrinsics.areEqual(this.id, ((GetFolderItemsQuery) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "GetFolderItemsQuery(id=" + this.id + ")";
    }

    public GetFolderItemsQuery(String id) {
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
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        GetFolderItemsQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetFolderItemsQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetFolderItemsQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetFolderItemsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetFolderItemsQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "folder", "Lcom/box/android/data/GetFolderItemsQuery$Folder;", "<init>", "(Lcom/box/android/data/GetFolderItemsQuery$Folder;)V", "getFolder", "()Lcom/box/android/data/GetFolderItemsQuery$Folder;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final Folder folder;

        public static /* synthetic */ Data copy$default(Data data, Folder folder, int i, Object obj) {
            if ((i & 1) != 0) {
                folder = data.folder;
            }
            return data.copy(folder);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Folder getFolder() {
            return this.folder;
        }

        public final Data copy(Folder folder) {
            return new Data(folder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.folder, ((Data) other).folder);
        }

        public int hashCode() {
            Folder folder = this.folder;
            if (folder == null) {
                return 0;
            }
            return folder.hashCode();
        }

        public String toString() {
            return "Data(folder=" + this.folder + ")";
        }

        public Data(Folder folder) {
            this.folder = folder;
        }

        public final Folder getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: GetFolderItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetFolderItemsQuery$Folder;", "", "id", "", "itemConnection", "Lcom/box/android/data/GetFolderItemsQuery$ItemConnection;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetFolderItemsQuery$ItemConnection;)V", "getId", "()Ljava/lang/String;", "getItemConnection", "()Lcom/box/android/data/GetFolderItemsQuery$ItemConnection;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Folder {
        private final String id;
        private final ItemConnection itemConnection;

        public static /* synthetic */ Folder copy$default(Folder folder, String str, ItemConnection itemConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                str = folder.id;
            }
            if ((i & 2) != 0) {
                itemConnection = folder.itemConnection;
            }
            return folder.copy(str, itemConnection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemConnection getItemConnection() {
            return this.itemConnection;
        }

        public final Folder copy(String id, ItemConnection itemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Folder(id, itemConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Folder)) {
                return false;
            }
            Folder folder = (Folder) other;
            return Intrinsics.areEqual(this.id, folder.id) && Intrinsics.areEqual(this.itemConnection, folder.itemConnection);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            ItemConnection itemConnection = this.itemConnection;
            return iHashCode + (itemConnection == null ? 0 : itemConnection.hashCode());
        }

        public String toString() {
            return "Folder(id=" + this.id + ", itemConnection=" + this.itemConnection + ")";
        }

        public Folder(String id, ItemConnection itemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.itemConnection = itemConnection;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemConnection getItemConnection() {
            return this.itemConnection;
        }
    }

    /* JADX INFO: compiled from: GetFolderItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetFolderItemsQuery$ItemConnection;", "", GQLCacheConstants.TYPENAME_KEY, "", "itemConnectionFragment", "Lcom/box/android/data/fragment/ItemConnectionFragment;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/fragment/ItemConnectionFragment;)V", "get__typename", "()Ljava/lang/String;", "getItemConnectionFragment", "()Lcom/box/android/data/fragment/ItemConnectionFragment;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemConnection {
        private final String __typename;
        private final ItemConnectionFragment itemConnectionFragment;

        public static /* synthetic */ ItemConnection copy$default(ItemConnection itemConnection, String str, ItemConnectionFragment itemConnectionFragment, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemConnection.__typename;
            }
            if ((i & 2) != 0) {
                itemConnectionFragment = itemConnection.itemConnectionFragment;
            }
            return itemConnection.copy(str, itemConnectionFragment);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemConnectionFragment getItemConnectionFragment() {
            return this.itemConnectionFragment;
        }

        public final ItemConnection copy(String __typename, ItemConnectionFragment itemConnectionFragment) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            Intrinsics.checkNotNullParameter(itemConnectionFragment, "itemConnectionFragment");
            return new ItemConnection(__typename, itemConnectionFragment);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemConnection)) {
                return false;
            }
            ItemConnection itemConnection = (ItemConnection) other;
            return Intrinsics.areEqual(this.__typename, itemConnection.__typename) && Intrinsics.areEqual(this.itemConnectionFragment, itemConnection.itemConnectionFragment);
        }

        public int hashCode() {
            return (this.__typename.hashCode() * 31) + this.itemConnectionFragment.hashCode();
        }

        public String toString() {
            return "ItemConnection(__typename=" + this.__typename + ", itemConnectionFragment=" + this.itemConnectionFragment + ")";
        }

        public ItemConnection(String __typename, ItemConnectionFragment itemConnectionFragment) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            Intrinsics.checkNotNullParameter(itemConnectionFragment, "itemConnectionFragment");
            this.__typename = __typename;
            this.itemConnectionFragment = itemConnectionFragment;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final ItemConnectionFragment getItemConnectionFragment() {
            return this.itemConnectionFragment;
        }
    }

    /* JADX INFO: compiled from: GetFolderItemsQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetFolderItemsQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query GetFolderItems($id: ID!) { folder(id: $id) { id itemConnection { __typename ...itemConnectionFragment } } }  fragment fileFields on File { id name type createdAt updatedAt contentCreatedAt contentUpdatedAt isRooted commentCount annotationCount ownedBy { id name } updatedBy { id name } parent { id name } fileVersion { id sha1 } itemCollectionConnection { edges { id: cursor node { id name collectionType } } } size hasCollaborations isExternallyOwned sha1 watermark { isWatermarked } permissionsV2Api { canComment canDelete canDownload canInviteCollaborator canPreview canRename canSetShareAccess canShare canUpload canViewAnnotations canCreateAnnotations } fileLock { id appType createdAt createdBy { id name login } expiresAt isDownloadPrevented } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } }  fragment folderFields on Folder { id name type createdAt updatedAt contentCreatedAt contentUpdatedAt isRooted ownedBy { id name } updatedBy { id name } parent { id name } itemCollectionConnection { edges { id: cursor node { id name collectionType } } } size hasCollaborations isExternallyOwned permissionsV2Api { canDelete canDownload canInviteCollaborator canRename canSetShareAccess canShare canUpload } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } }  fragment weblinkFields on Weblink { id name type createdAt updatedAt isRooted ownedBy { id name } updatedBy { id name } parent { id name } itemCollectionConnection { edges { id: cursor node { id name collectionType } } } url permissionsV2Api { canComment canDelete canRename canSetShareAccess canShare } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } }  fragment itemConnectionFragment on FolderItemConnection { totalCount edges { id: cursor node { __typename ...fileFields ...folderFields ...weblinkFields } } }";
        }
    }
}
