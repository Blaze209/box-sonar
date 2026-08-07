package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetItemWithWatermarkDataQuery_ResponseAdapter;
import com.box.android.data.adapter.GetItemWithWatermarkDataQuery_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.selections.GetItemWithWatermarkDataQuerySelections;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxClassification;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b&\b\u0086\b\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:$$%&'()*+,-./0123456789:;<=>?@ABCDEFGB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006H"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Data;", "itemId", "", "type", "Lcom/box/android/data/type/ItemType;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;)V", "getItemId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "id", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "Item", "OnFile", "ItemCollectionConnection", "Edge", "Node", "Classification", "OwnedBy", "UpdatedBy", "Parent", "PermissionsV2Api", "FileVersion", "FileLock", "CreatedBy", "SharedLink", "Watermark", "OnFolder", "ItemCollectionConnection1", "Edge1", "Node1", "OwnedBy1", "UpdatedBy1", "Parent1", "PermissionsV2Api1", "SharedLink1", "Watermark1", "OnWeblink", "ItemCollectionConnection2", "Edge2", "Node2", "OwnedBy2", "UpdatedBy2", "Parent2", "PermissionsV2Api2", "SharedLink2", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetItemWithWatermarkDataQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "697f9292618f03cbb99a89b5d92c3093f41e226e6a1662a44711cca557761173";
    public static final String OPERATION_NAME = "getItemWithWatermarkData";
    private final String itemId;
    private final ItemType type;

    public static /* synthetic */ GetItemWithWatermarkDataQuery copy$default(GetItemWithWatermarkDataQuery getItemWithWatermarkDataQuery, String str, ItemType itemType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getItemWithWatermarkDataQuery.itemId;
        }
        if ((i & 2) != 0) {
            itemType = getItemWithWatermarkDataQuery.type;
        }
        return getItemWithWatermarkDataQuery.copy(str, itemType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    public final GetItemWithWatermarkDataQuery copy(String itemId, ItemType type) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(type, "type");
        return new GetItemWithWatermarkDataQuery(itemId, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetItemWithWatermarkDataQuery)) {
            return false;
        }
        GetItemWithWatermarkDataQuery getItemWithWatermarkDataQuery = (GetItemWithWatermarkDataQuery) other;
        return Intrinsics.areEqual(this.itemId, getItemWithWatermarkDataQuery.itemId) && this.type == getItemWithWatermarkDataQuery.type;
    }

    public int hashCode() {
        return (this.itemId.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "GetItemWithWatermarkDataQuery(itemId=" + this.itemId + ", type=" + this.type + ")";
    }

    public GetItemWithWatermarkDataQuery(String itemId, ItemType type) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.itemId = itemId;
        this.type = type;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final ItemType getType() {
        return this.type;
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
        GetItemWithWatermarkDataQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetItemWithWatermarkDataQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetItemWithWatermarkDataQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "item", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Item;", "<init>", "(Lcom/box/android/data/GetItemWithWatermarkDataQuery$Item;)V", "getItem", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Item;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final Item item;

        public static /* synthetic */ Data copy$default(Data data, Item item, int i, Object obj) {
            if ((i & 1) != 0) {
                item = data.item;
            }
            return data.copy(item);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Item getItem() {
            return this.item;
        }

        public final Data copy(Item item) {
            return new Data(item);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.item, ((Data) other).item);
        }

        public int hashCode() {
            Item item = this.item;
            if (item == null) {
                return 0;
            }
            return item.hashCode();
        }

        public String toString() {
            return "Data(item=" + this.item + ")";
        }

        public Data(Item item) {
            this.item = item;
        }

        public final Item getItem() {
            return this.item;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Item;", "", GQLCacheConstants.TYPENAME_KEY, "", "onFile", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;", "onFolder", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFolder;", "onWeblink", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnWeblink;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFolder;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnWeblink;)V", "get__typename", "()Ljava/lang/String;", "getOnFile", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;", "getOnFolder", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFolder;", "getOnWeblink", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnWeblink;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Item {
        private final String __typename;
        private final OnFile onFile;
        private final OnFolder onFolder;
        private final OnWeblink onWeblink;

        public static /* synthetic */ Item copy$default(Item item, String str, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.__typename;
            }
            if ((i & 2) != 0) {
                onFile = item.onFile;
            }
            if ((i & 4) != 0) {
                onFolder = item.onFolder;
            }
            if ((i & 8) != 0) {
                onWeblink = item.onWeblink;
            }
            return item.copy(str, onFile, onFolder, onWeblink);
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

        public final Item copy(String __typename, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            return new Item(__typename, onFile, onFolder, onWeblink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics.areEqual(this.__typename, item.__typename) && Intrinsics.areEqual(this.onFile, item.onFile) && Intrinsics.areEqual(this.onFolder, item.onFolder) && Intrinsics.areEqual(this.onWeblink, item.onWeblink);
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
            return "Item(__typename=" + this.__typename + ", onFile=" + this.onFile + ", onFolder=" + this.onFolder + ", onWeblink=" + this.onWeblink + ")";
        }

        public Item(String __typename, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink) {
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bM\b\u0086\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010'\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0004\b*\u0010+J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010`\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010a\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010b\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010)HÆ\u0003J¶\u0002\u0010p\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)HÆ\u0001¢\u0006\u0002\u0010qJ\u0013\u0010r\u001a\u00020\u000e2\b\u0010s\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010t\u001a\u00020\u0010HÖ\u0001J\t\u0010u\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00108\u001a\u0004\b\r\u00107R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010;\u001a\u0004\b<\u0010:R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00108\u001a\u0004\bE\u00107R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00108\u001a\u0004\b\u0018\u00107R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bU\u0010V¨\u0006v"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "updatedAt", "description", "contentCreatedAt", "contentUpdatedAt", "isRooted", "", "commentCount", "", "annotationCount", "itemCollectionConnection", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection;", BoxItem.FIELD_CLASSIFICATION, "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Classification;", "size", "hasCollaborations", "isExternallyOwned", "sha1", "ownedBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy;", "updatedBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy;", "parent", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent;", "permissionsV2Api", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;", "fileVersion", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileVersion;", "fileLock", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "watermark", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Classification;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy;Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent;Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileVersion;Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getDescription", "getContentCreatedAt", "getContentUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommentCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnnotationCount", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection;", "getClassification", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Classification;", "getSize", "()Ljava/lang/Object;", "getHasCollaborations", "getSha1", "getOwnedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy;", "getUpdatedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy;", "getParent", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent;", "getPermissionsV2Api", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;", "getFileVersion", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileVersion;", "getFileLock", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;", "getSharedLink", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "getWatermark", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Classification;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy;Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent;Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileVersion;Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;", "equals", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnFile {
        private final Integer annotationCount;
        private final Classification classification;
        private final Integer commentCount;
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final String description;
        private final FileLock fileLock;
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
        private final SharedLink sharedLink;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy updatedBy;
        private final Watermark watermark;

        public static /* synthetic */ OnFile copy$default(OnFile onFile, String str, ItemType itemType, String str2, Date date, Date date2, String str3, Date date3, Date date4, Boolean bool, Integer num, Integer num2, ItemCollectionConnection itemCollectionConnection, Classification classification, Object obj, Boolean bool2, Boolean bool3, String str4, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, PermissionsV2Api permissionsV2Api, FileVersion fileVersion, FileLock fileLock, SharedLink sharedLink, Watermark watermark, int i, Object obj2) {
            Watermark watermark2;
            SharedLink sharedLink2;
            String str5 = (i & 1) != 0 ? onFile.id : str;
            ItemType itemType2 = (i & 2) != 0 ? onFile.type : itemType;
            String str6 = (i & 4) != 0 ? onFile.name : str2;
            Date date5 = (i & 8) != 0 ? onFile.createdAt : date;
            Date date6 = (i & 16) != 0 ? onFile.updatedAt : date2;
            String str7 = (i & 32) != 0 ? onFile.description : str3;
            Date date7 = (i & 64) != 0 ? onFile.contentCreatedAt : date3;
            Date date8 = (i & 128) != 0 ? onFile.contentUpdatedAt : date4;
            Boolean bool4 = (i & 256) != 0 ? onFile.isRooted : bool;
            Integer num3 = (i & 512) != 0 ? onFile.commentCount : num;
            Integer num4 = (i & 1024) != 0 ? onFile.annotationCount : num2;
            ItemCollectionConnection itemCollectionConnection2 = (i & 2048) != 0 ? onFile.itemCollectionConnection : itemCollectionConnection;
            Classification classification2 = (i & 4096) != 0 ? onFile.classification : classification;
            Object obj3 = (i & 8192) != 0 ? onFile.size : obj;
            String str8 = str5;
            Boolean bool5 = (i & 16384) != 0 ? onFile.hasCollaborations : bool2;
            Boolean bool6 = (i & 32768) != 0 ? onFile.isExternallyOwned : bool3;
            String str9 = (i & 65536) != 0 ? onFile.sha1 : str4;
            OwnedBy ownedBy2 = (i & 131072) != 0 ? onFile.ownedBy : ownedBy;
            UpdatedBy updatedBy2 = (i & 262144) != 0 ? onFile.updatedBy : updatedBy;
            Parent parent2 = (i & 524288) != 0 ? onFile.parent : parent;
            PermissionsV2Api permissionsV2Api2 = (i & 1048576) != 0 ? onFile.permissionsV2Api : permissionsV2Api;
            FileVersion fileVersion2 = (i & 2097152) != 0 ? onFile.fileVersion : fileVersion;
            FileLock fileLock2 = (i & 4194304) != 0 ? onFile.fileLock : fileLock;
            SharedLink sharedLink3 = (i & 8388608) != 0 ? onFile.sharedLink : sharedLink;
            if ((i & 16777216) != 0) {
                sharedLink2 = sharedLink3;
                watermark2 = onFile.watermark;
            } else {
                watermark2 = watermark;
                sharedLink2 = sharedLink3;
            }
            return onFile.copy(str8, itemType2, str6, date5, date6, str7, date7, date8, bool4, num3, num4, itemCollectionConnection2, classification2, obj3, bool5, bool6, str9, ownedBy2, updatedBy2, parent2, permissionsV2Api2, fileVersion2, fileLock2, sharedLink2, watermark2);
        }

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getCommentCount() {
            return this.commentCount;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getAnnotationCount() {
            return this.annotationCount;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final ItemCollectionConnection getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Classification getClassification() {
            return this.classification;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getSha1() {
            return this.sha1;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Parent getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final FileVersion getFileVersion() {
            return this.fileVersion;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final FileLock getFileLock() {
            return this.fileLock;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final SharedLink getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Watermark getWatermark() {
            return this.watermark;
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
        public final String getDescription() {
            return this.description;
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

        public final OnFile copy(String id, ItemType type, String name, Date createdAt, Date updatedAt, String description, Date contentCreatedAt, Date contentUpdatedAt, Boolean isRooted, Integer commentCount, Integer annotationCount, ItemCollectionConnection itemCollectionConnection, Classification classification, Object size, Boolean hasCollaborations, Boolean isExternallyOwned, String sha1, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, PermissionsV2Api permissionsV2Api, FileVersion fileVersion, FileLock fileLock, SharedLink sharedLink, Watermark watermark) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnFile(id, type, name, createdAt, updatedAt, description, contentCreatedAt, contentUpdatedAt, isRooted, commentCount, annotationCount, itemCollectionConnection, classification, size, hasCollaborations, isExternallyOwned, sha1, ownedBy, updatedBy, parent, permissionsV2Api, fileVersion, fileLock, sharedLink, watermark);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFile)) {
                return false;
            }
            OnFile onFile = (OnFile) other;
            return Intrinsics.areEqual(this.id, onFile.id) && this.type == onFile.type && Intrinsics.areEqual(this.name, onFile.name) && Intrinsics.areEqual(this.createdAt, onFile.createdAt) && Intrinsics.areEqual(this.updatedAt, onFile.updatedAt) && Intrinsics.areEqual(this.description, onFile.description) && Intrinsics.areEqual(this.contentCreatedAt, onFile.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onFile.contentUpdatedAt) && Intrinsics.areEqual(this.isRooted, onFile.isRooted) && Intrinsics.areEqual(this.commentCount, onFile.commentCount) && Intrinsics.areEqual(this.annotationCount, onFile.annotationCount) && Intrinsics.areEqual(this.itemCollectionConnection, onFile.itemCollectionConnection) && Intrinsics.areEqual(this.classification, onFile.classification) && Intrinsics.areEqual(this.size, onFile.size) && Intrinsics.areEqual(this.hasCollaborations, onFile.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, onFile.isExternallyOwned) && Intrinsics.areEqual(this.sha1, onFile.sha1) && Intrinsics.areEqual(this.ownedBy, onFile.ownedBy) && Intrinsics.areEqual(this.updatedBy, onFile.updatedBy) && Intrinsics.areEqual(this.parent, onFile.parent) && Intrinsics.areEqual(this.permissionsV2Api, onFile.permissionsV2Api) && Intrinsics.areEqual(this.fileVersion, onFile.fileVersion) && Intrinsics.areEqual(this.fileLock, onFile.fileLock) && Intrinsics.areEqual(this.sharedLink, onFile.sharedLink) && Intrinsics.areEqual(this.watermark, onFile.watermark);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
            String str2 = this.description;
            int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode6 = (iHashCode5 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode7 = (iHashCode6 + (date4 == null ? 0 : date4.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num = this.commentCount;
            int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.annotationCount;
            int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
            ItemCollectionConnection itemCollectionConnection = this.itemCollectionConnection;
            int iHashCode11 = (iHashCode10 + (itemCollectionConnection == null ? 0 : itemCollectionConnection.hashCode())) * 31;
            Classification classification = this.classification;
            int iHashCode12 = (iHashCode11 + (classification == null ? 0 : classification.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode13 = (iHashCode12 + (obj == null ? 0 : obj.hashCode())) * 31;
            Boolean bool2 = this.hasCollaborations;
            int iHashCode14 = (iHashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isExternallyOwned;
            int iHashCode15 = (iHashCode14 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str3 = this.sha1;
            int iHashCode16 = (iHashCode15 + (str3 == null ? 0 : str3.hashCode())) * 31;
            OwnedBy ownedBy = this.ownedBy;
            int iHashCode17 = (iHashCode16 + (ownedBy == null ? 0 : ownedBy.hashCode())) * 31;
            UpdatedBy updatedBy = this.updatedBy;
            int iHashCode18 = (iHashCode17 + (updatedBy == null ? 0 : updatedBy.hashCode())) * 31;
            Parent parent = this.parent;
            int iHashCode19 = (iHashCode18 + (parent == null ? 0 : parent.hashCode())) * 31;
            PermissionsV2Api permissionsV2Api = this.permissionsV2Api;
            int iHashCode20 = (iHashCode19 + (permissionsV2Api == null ? 0 : permissionsV2Api.hashCode())) * 31;
            FileVersion fileVersion = this.fileVersion;
            int iHashCode21 = (iHashCode20 + (fileVersion == null ? 0 : fileVersion.hashCode())) * 31;
            FileLock fileLock = this.fileLock;
            int iHashCode22 = (iHashCode21 + (fileLock == null ? 0 : fileLock.hashCode())) * 31;
            SharedLink sharedLink = this.sharedLink;
            int iHashCode23 = (iHashCode22 + (sharedLink == null ? 0 : sharedLink.hashCode())) * 31;
            Watermark watermark = this.watermark;
            return iHashCode23 + (watermark != null ? watermark.hashCode() : 0);
        }

        public String toString() {
            return "OnFile(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", description=" + this.description + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", isRooted=" + this.isRooted + ", commentCount=" + this.commentCount + ", annotationCount=" + this.annotationCount + ", itemCollectionConnection=" + this.itemCollectionConnection + ", classification=" + this.classification + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", sha1=" + this.sha1 + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", permissionsV2Api=" + this.permissionsV2Api + ", fileVersion=" + this.fileVersion + ", fileLock=" + this.fileLock + ", sharedLink=" + this.sharedLink + ", watermark=" + this.watermark + ")";
        }

        public OnFile(String id, ItemType type, String str, Date date, Date date2, String str2, Date date3, Date date4, Boolean bool, Integer num, Integer num2, ItemCollectionConnection itemCollectionConnection, Classification classification, Object obj, Boolean bool2, Boolean bool3, String str3, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, PermissionsV2Api permissionsV2Api, FileVersion fileVersion, FileLock fileLock, SharedLink sharedLink, Watermark watermark) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.updatedAt = date2;
            this.description = str2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.isRooted = bool;
            this.commentCount = num;
            this.annotationCount = num2;
            this.itemCollectionConnection = itemCollectionConnection;
            this.classification = classification;
            this.size = obj;
            this.hasCollaborations = bool2;
            this.isExternallyOwned = bool3;
            this.sha1 = str3;
            this.ownedBy = ownedBy;
            this.updatedBy = updatedBy;
            this.parent = parent;
            this.permissionsV2Api = permissionsV2Api;
            this.fileVersion = fileVersion;
            this.fileLock = fileLock;
            this.sharedLink = sharedLink;
            this.watermark = watermark;
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

        public final String getDescription() {
            return this.description;
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

        public final Classification getClassification() {
            return this.classification;
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

        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        public final Parent getParent() {
            return this.parent;
        }

        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final FileVersion getFileVersion() {
            return this.fileVersion;
        }

        public final FileLock getFileLock() {
            return this.fileLock;
        }

        public final SharedLink getSharedLink() {
            return this.sharedLink;
        }

        public final Watermark getWatermark() {
            return this.watermark;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection;", "", "edges", "", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Edge;", "", "id", "", "node", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Classification;", "", "name", "", "color", BoxClassification.FIELD_DEFINITION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getColor", "getDefinition", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Classification {
        private final String color;
        private final String definition;
        private final String name;

        public static /* synthetic */ Classification copy$default(Classification classification, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = classification.name;
            }
            if ((i & 2) != 0) {
                str2 = classification.color;
            }
            if ((i & 4) != 0) {
                str3 = classification.definition;
            }
            return classification.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDefinition() {
            return this.definition;
        }

        public final Classification copy(String name, String color, String definition) {
            return new Classification(name, color, definition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Classification)) {
                return false;
            }
            Classification classification = (Classification) other;
            return Intrinsics.areEqual(this.name, classification.name) && Intrinsics.areEqual(this.color, classification.color) && Intrinsics.areEqual(this.definition, classification.definition);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.color;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.definition;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Classification(name=" + this.name + ", color=" + this.color + ", definition=" + this.definition + ")";
        }

        public Classification(String str, String str2, String str3) {
            this.name = str;
            this.color = str2;
            this.definition = str3;
        }

        public final String getName() {
            return this.name;
        }

        public final String getColor() {
            return this.color;
        }

        public final String getDefinition() {
            return this.definition;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u009e\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;", "", "canComment", "", "canDelete", "canDownload", "canInviteCollaborator", "canPreview", "canRename", "canSetShareAccess", "canShare", "canUpload", "canViewAnnotations", "canCreateAnnotations", "canApplyWatermark", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanComment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanDelete", "getCanDownload", "getCanInviteCollaborator", "getCanPreview", "getCanRename", "getCanSetShareAccess", "getCanShare", "getCanUpload", "getCanViewAnnotations", "getCanCreateAnnotations", "getCanApplyWatermark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api {
        private final Boolean canApplyWatermark;
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

        public static /* synthetic */ PermissionsV2Api copy$default(PermissionsV2Api permissionsV2Api, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api.canComment;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api.canDelete;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api.canInviteCollaborator;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api.canPreview;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api.canRename;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api.canSetShareAccess;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api.canShare;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api.canUpload;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api.canCreateAnnotations;
            }
            if ((i & 2048) != 0) {
                bool12 = permissionsV2Api.canApplyWatermark;
            }
            Boolean bool13 = bool11;
            Boolean bool14 = bool12;
            Boolean bool15 = bool9;
            Boolean bool16 = bool10;
            Boolean bool17 = bool7;
            Boolean bool18 = bool8;
            Boolean bool19 = bool5;
            Boolean bool20 = bool6;
            return permissionsV2Api.copy(bool, bool2, bool3, bool4, bool19, bool20, bool17, bool18, bool15, bool16, bool13, bool14);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getCanApplyWatermark() {
            return this.canApplyWatermark;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final PermissionsV2Api copy(Boolean canComment, Boolean canDelete, Boolean canDownload, Boolean canInviteCollaborator, Boolean canPreview, Boolean canRename, Boolean canSetShareAccess, Boolean canShare, Boolean canUpload, Boolean canViewAnnotations, Boolean canCreateAnnotations, Boolean canApplyWatermark) {
            return new PermissionsV2Api(canComment, canDelete, canDownload, canInviteCollaborator, canPreview, canRename, canSetShareAccess, canShare, canUpload, canViewAnnotations, canCreateAnnotations, canApplyWatermark);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api)) {
                return false;
            }
            PermissionsV2Api permissionsV2Api = (PermissionsV2Api) other;
            return Intrinsics.areEqual(this.canComment, permissionsV2Api.canComment) && Intrinsics.areEqual(this.canDelete, permissionsV2Api.canDelete) && Intrinsics.areEqual(this.canDownload, permissionsV2Api.canDownload) && Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api.canInviteCollaborator) && Intrinsics.areEqual(this.canPreview, permissionsV2Api.canPreview) && Intrinsics.areEqual(this.canRename, permissionsV2Api.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api.canShare) && Intrinsics.areEqual(this.canUpload, permissionsV2Api.canUpload) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api.canCreateAnnotations) && Intrinsics.areEqual(this.canApplyWatermark, permissionsV2Api.canApplyWatermark);
        }

        public int hashCode() {
            Boolean bool = this.canComment;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canDelete;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDownload;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canInviteCollaborator;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canPreview;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canRename;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canSetShareAccess;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canShare;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canUpload;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            int iHashCode11 = (iHashCode10 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.canApplyWatermark;
            return iHashCode11 + (bool12 != null ? bool12.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api(canComment=" + this.canComment + ", canDelete=" + this.canDelete + ", canDownload=" + this.canDownload + ", canInviteCollaborator=" + this.canInviteCollaborator + ", canPreview=" + this.canPreview + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ", canUpload=" + this.canUpload + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ", canApplyWatermark=" + this.canApplyWatermark + ")";
        }

        public PermissionsV2Api(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12) {
            this.canComment = bool;
            this.canDelete = bool2;
            this.canDownload = bool3;
            this.canInviteCollaborator = bool4;
            this.canPreview = bool5;
            this.canRename = bool6;
            this.canSetShareAccess = bool7;
            this.canShare = bool8;
            this.canUpload = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
            this.canApplyWatermark = bool12;
        }

        public final Boolean getCanComment() {
            return this.canComment;
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

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        public final Boolean getCanApplyWatermark() {
            return this.canApplyWatermark;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileVersion;", "", "id", "", "sha1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSha1", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JT\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\n\u0010\u0016¨\u0006%"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;", "", "id", "", "appType", "createdAt", "Ljava/util/Date;", "createdBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$CreatedBy;", "expiresAt", "isDownloadPrevented", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/data/GetItemWithWatermarkDataQuery$CreatedBy;Ljava/util/Date;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getAppType", "getCreatedAt", "()Ljava/util/Date;", "getCreatedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$CreatedBy;", "getExpiresAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/data/GetItemWithWatermarkDataQuery$CreatedBy;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileLock {
        private final String appType;
        private final Date createdAt;
        private final CreatedBy createdBy;
        private final Date expiresAt;
        private final String id;
        private final Boolean isDownloadPrevented;

        public static /* synthetic */ FileLock copy$default(FileLock fileLock, String str, String str2, Date date, CreatedBy createdBy, Date date2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileLock.id;
            }
            if ((i & 2) != 0) {
                str2 = fileLock.appType;
            }
            if ((i & 4) != 0) {
                date = fileLock.createdAt;
            }
            if ((i & 8) != 0) {
                createdBy = fileLock.createdBy;
            }
            if ((i & 16) != 0) {
                date2 = fileLock.expiresAt;
            }
            if ((i & 32) != 0) {
                bool = fileLock.isDownloadPrevented;
            }
            Date date3 = date2;
            Boolean bool2 = bool;
            return fileLock.copy(str, str2, date, createdBy, date3, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAppType() {
            return this.appType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CreatedBy getCreatedBy() {
            return this.createdBy;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getExpiresAt() {
            return this.expiresAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsDownloadPrevented() {
            return this.isDownloadPrevented;
        }

        public final FileLock copy(String id, String appType, Date createdAt, CreatedBy createdBy, Date expiresAt, Boolean isDownloadPrevented) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new FileLock(id, appType, createdAt, createdBy, expiresAt, isDownloadPrevented);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileLock)) {
                return false;
            }
            FileLock fileLock = (FileLock) other;
            return Intrinsics.areEqual(this.id, fileLock.id) && Intrinsics.areEqual(this.appType, fileLock.appType) && Intrinsics.areEqual(this.createdAt, fileLock.createdAt) && Intrinsics.areEqual(this.createdBy, fileLock.createdBy) && Intrinsics.areEqual(this.expiresAt, fileLock.expiresAt) && Intrinsics.areEqual(this.isDownloadPrevented, fileLock.isDownloadPrevented);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.appType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            CreatedBy createdBy = this.createdBy;
            int iHashCode4 = (iHashCode3 + (createdBy == null ? 0 : createdBy.hashCode())) * 31;
            Date date2 = this.expiresAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Boolean bool = this.isDownloadPrevented;
            return iHashCode5 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "FileLock(id=" + this.id + ", appType=" + this.appType + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", expiresAt=" + this.expiresAt + ", isDownloadPrevented=" + this.isDownloadPrevented + ")";
        }

        public FileLock(String id, String str, Date date, CreatedBy createdBy, Date date2, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.appType = str;
            this.createdAt = date;
            this.createdBy = createdBy;
            this.expiresAt = date2;
            this.isDownloadPrevented = bool;
        }

        public final String getId() {
            return this.id;
        }

        public final String getAppType() {
            return this.appType;
        }

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final CreatedBy getCreatedBy() {
            return this.createdBy;
        }

        public final Date getExpiresAt() {
            return this.expiresAt;
        }

        public final Boolean isDownloadPrevented() {
            return this.isDownloadPrevented;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$CreatedBy;", "", "id", "", "name", "login", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getLogin", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreatedBy {
        private final String id;
        private final String login;
        private final String name;

        public static /* synthetic */ CreatedBy copy$default(CreatedBy createdBy, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = createdBy.id;
            }
            if ((i & 2) != 0) {
                str2 = createdBy.name;
            }
            if ((i & 4) != 0) {
                str3 = createdBy.login;
            }
            return createdBy.copy(str, str2, str3);
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
        public final String getLogin() {
            return this.login;
        }

        public final CreatedBy copy(String id, String name, String login) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new CreatedBy(id, name, login);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreatedBy)) {
                return false;
            }
            CreatedBy createdBy = (CreatedBy) other;
            return Intrinsics.areEqual(this.id, createdBy.id) && Intrinsics.areEqual(this.name, createdBy.name) && Intrinsics.areEqual(this.login, createdBy.login);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.login;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CreatedBy(id=" + this.id + ", name=" + this.name + ", login=" + this.login + ")";
        }

        public CreatedBy(String id, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.login = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getLogin() {
            return this.login;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink copy$default(SharedLink sharedLink, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink)) {
                return false;
            }
            SharedLink sharedLink = (SharedLink) other;
            return Intrinsics.areEqual(this.url, sharedLink.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;", "", "isWatermarked", "", "isWatermarkInherited", "isWatermarkedByAccessPolicy", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Watermark {
        private final Boolean isWatermarkInherited;
        private final Boolean isWatermarked;
        private final Boolean isWatermarkedByAccessPolicy;

        public static /* synthetic */ Watermark copy$default(Watermark watermark, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = watermark.isWatermarked;
            }
            if ((i & 2) != 0) {
                bool2 = watermark.isWatermarkInherited;
            }
            if ((i & 4) != 0) {
                bool3 = watermark.isWatermarkedByAccessPolicy;
            }
            return watermark.copy(bool, bool2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsWatermarked() {
            return this.isWatermarked;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsWatermarkInherited() {
            return this.isWatermarkInherited;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getIsWatermarkedByAccessPolicy() {
            return this.isWatermarkedByAccessPolicy;
        }

        public final Watermark copy(Boolean isWatermarked, Boolean isWatermarkInherited, Boolean isWatermarkedByAccessPolicy) {
            return new Watermark(isWatermarked, isWatermarkInherited, isWatermarkedByAccessPolicy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Watermark)) {
                return false;
            }
            Watermark watermark = (Watermark) other;
            return Intrinsics.areEqual(this.isWatermarked, watermark.isWatermarked) && Intrinsics.areEqual(this.isWatermarkInherited, watermark.isWatermarkInherited) && Intrinsics.areEqual(this.isWatermarkedByAccessPolicy, watermark.isWatermarkedByAccessPolicy);
        }

        public int hashCode() {
            Boolean bool = this.isWatermarked;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.isWatermarkInherited;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isWatermarkedByAccessPolicy;
            return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            return "Watermark(isWatermarked=" + this.isWatermarked + ", isWatermarkInherited=" + this.isWatermarkInherited + ", isWatermarkedByAccessPolicy=" + this.isWatermarkedByAccessPolicy + ")";
        }

        public Watermark(Boolean bool, Boolean bool2, Boolean bool3) {
            this.isWatermarked = bool;
            this.isWatermarkInherited = bool2;
            this.isWatermarkedByAccessPolicy = bool3;
        }

        public final Boolean isWatermarked() {
            return this.isWatermarked;
        }

        public final Boolean isWatermarkInherited() {
            return this.isWatermarkInherited;
        }

        public final Boolean isWatermarkedByAccessPolicy() {
            return this.isWatermarkedByAccessPolicy;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010K\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010N\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010O\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001fHÆ\u0003Jî\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u000e2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020ZHÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\r\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b5\u0010-R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0013\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006\\"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFolder;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "description", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "", "itemCollectionConnection", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection1;", "size", "hasCollaborations", "isExternallyOwned", "ownedBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy1;", "updatedBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy1;", "parent", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent1;", "permissionsV2Api", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "watermark", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection1;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getDescription", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection1;", "getSize", "()Ljava/lang/Object;", "getHasCollaborations", "getOwnedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy1;", "getUpdatedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy1;", "getParent", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent1;", "getPermissionsV2Api", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;", "getSharedLink", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "getWatermark", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection1;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFolder;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnFolder {
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final String description;
        private final Boolean hasCollaborations;
        private final String id;
        private final Boolean isExternallyOwned;
        private final Boolean isRooted;
        private final ItemCollectionConnection1 itemCollectionConnection;
        private final String name;
        private final OwnedBy1 ownedBy;
        private final Parent1 parent;
        private final PermissionsV2Api1 permissionsV2Api;
        private final SharedLink1 sharedLink;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy1 updatedBy;
        private final Watermark1 watermark;

        public static /* synthetic */ OnFolder copy$default(OnFolder onFolder, String str, ItemType itemType, String str2, Date date, String str3, Date date2, Date date3, Date date4, Boolean bool, ItemCollectionConnection1 itemCollectionConnection1, Object obj, Boolean bool2, Boolean bool3, OwnedBy1 ownedBy1, UpdatedBy1 updatedBy1, Parent1 parent1, PermissionsV2Api1 permissionsV2Api1, SharedLink1 sharedLink1, Watermark1 watermark1, int i, Object obj2) {
            Watermark1 watermark2;
            SharedLink1 sharedLink2;
            String str4 = (i & 1) != 0 ? onFolder.id : str;
            ItemType itemType2 = (i & 2) != 0 ? onFolder.type : itemType;
            String str5 = (i & 4) != 0 ? onFolder.name : str2;
            Date date5 = (i & 8) != 0 ? onFolder.createdAt : date;
            String str6 = (i & 16) != 0 ? onFolder.description : str3;
            Date date6 = (i & 32) != 0 ? onFolder.updatedAt : date2;
            Date date7 = (i & 64) != 0 ? onFolder.contentCreatedAt : date3;
            Date date8 = (i & 128) != 0 ? onFolder.contentUpdatedAt : date4;
            Boolean bool4 = (i & 256) != 0 ? onFolder.isRooted : bool;
            ItemCollectionConnection1 itemCollectionConnection2 = (i & 512) != 0 ? onFolder.itemCollectionConnection : itemCollectionConnection1;
            Object obj3 = (i & 1024) != 0 ? onFolder.size : obj;
            Boolean bool5 = (i & 2048) != 0 ? onFolder.hasCollaborations : bool2;
            Boolean bool6 = (i & 4096) != 0 ? onFolder.isExternallyOwned : bool3;
            OwnedBy1 ownedBy2 = (i & 8192) != 0 ? onFolder.ownedBy : ownedBy1;
            String str7 = str4;
            UpdatedBy1 updatedBy2 = (i & 16384) != 0 ? onFolder.updatedBy : updatedBy1;
            Parent1 parent2 = (i & 32768) != 0 ? onFolder.parent : parent1;
            PermissionsV2Api1 permissionsV2Api2 = (i & 65536) != 0 ? onFolder.permissionsV2Api : permissionsV2Api1;
            SharedLink1 sharedLink3 = (i & 131072) != 0 ? onFolder.sharedLink : sharedLink1;
            if ((i & 262144) != 0) {
                sharedLink2 = sharedLink3;
                watermark2 = onFolder.watermark;
            } else {
                watermark2 = watermark1;
                sharedLink2 = sharedLink3;
            }
            return onFolder.copy(str7, itemType2, str5, date5, str6, date6, date7, date8, bool4, itemCollectionConnection2, obj3, bool5, bool6, ownedBy2, updatedBy2, parent2, permissionsV2Api2, sharedLink2, watermark2);
        }

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final ItemCollectionConnection1 getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final OwnedBy1 getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final UpdatedBy1 getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Parent1 getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final PermissionsV2Api1 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final SharedLink1 getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Watermark1 getWatermark() {
            return this.watermark;
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
        public final String getDescription() {
            return this.description;
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

        public final OnFolder copy(String id, ItemType type, String name, Date createdAt, String description, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, Boolean isRooted, ItemCollectionConnection1 itemCollectionConnection, Object size, Boolean hasCollaborations, Boolean isExternallyOwned, OwnedBy1 ownedBy, UpdatedBy1 updatedBy, Parent1 parent, PermissionsV2Api1 permissionsV2Api, SharedLink1 sharedLink, Watermark1 watermark) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnFolder(id, type, name, createdAt, description, updatedAt, contentCreatedAt, contentUpdatedAt, isRooted, itemCollectionConnection, size, hasCollaborations, isExternallyOwned, ownedBy, updatedBy, parent, permissionsV2Api, sharedLink, watermark);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFolder)) {
                return false;
            }
            OnFolder onFolder = (OnFolder) other;
            return Intrinsics.areEqual(this.id, onFolder.id) && this.type == onFolder.type && Intrinsics.areEqual(this.name, onFolder.name) && Intrinsics.areEqual(this.createdAt, onFolder.createdAt) && Intrinsics.areEqual(this.description, onFolder.description) && Intrinsics.areEqual(this.updatedAt, onFolder.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, onFolder.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onFolder.contentUpdatedAt) && Intrinsics.areEqual(this.isRooted, onFolder.isRooted) && Intrinsics.areEqual(this.itemCollectionConnection, onFolder.itemCollectionConnection) && Intrinsics.areEqual(this.size, onFolder.size) && Intrinsics.areEqual(this.hasCollaborations, onFolder.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, onFolder.isExternallyOwned) && Intrinsics.areEqual(this.ownedBy, onFolder.ownedBy) && Intrinsics.areEqual(this.updatedBy, onFolder.updatedBy) && Intrinsics.areEqual(this.parent, onFolder.parent) && Intrinsics.areEqual(this.permissionsV2Api, onFolder.permissionsV2Api) && Intrinsics.areEqual(this.sharedLink, onFolder.sharedLink) && Intrinsics.areEqual(this.watermark, onFolder.watermark);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            String str2 = this.description;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode6 = (iHashCode5 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode7 = (iHashCode6 + (date4 == null ? 0 : date4.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            ItemCollectionConnection1 itemCollectionConnection1 = this.itemCollectionConnection;
            int iHashCode9 = (iHashCode8 + (itemCollectionConnection1 == null ? 0 : itemCollectionConnection1.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode10 = (iHashCode9 + (obj == null ? 0 : obj.hashCode())) * 31;
            Boolean bool2 = this.hasCollaborations;
            int iHashCode11 = (iHashCode10 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isExternallyOwned;
            int iHashCode12 = (iHashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            OwnedBy1 ownedBy1 = this.ownedBy;
            int iHashCode13 = (iHashCode12 + (ownedBy1 == null ? 0 : ownedBy1.hashCode())) * 31;
            UpdatedBy1 updatedBy1 = this.updatedBy;
            int iHashCode14 = (iHashCode13 + (updatedBy1 == null ? 0 : updatedBy1.hashCode())) * 31;
            Parent1 parent1 = this.parent;
            int iHashCode15 = (iHashCode14 + (parent1 == null ? 0 : parent1.hashCode())) * 31;
            PermissionsV2Api1 permissionsV2Api1 = this.permissionsV2Api;
            int iHashCode16 = (iHashCode15 + (permissionsV2Api1 == null ? 0 : permissionsV2Api1.hashCode())) * 31;
            SharedLink1 sharedLink1 = this.sharedLink;
            int iHashCode17 = (iHashCode16 + (sharedLink1 == null ? 0 : sharedLink1.hashCode())) * 31;
            Watermark1 watermark1 = this.watermark;
            return iHashCode17 + (watermark1 != null ? watermark1.hashCode() : 0);
        }

        public String toString() {
            return "OnFolder(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", description=" + this.description + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", isRooted=" + this.isRooted + ", itemCollectionConnection=" + this.itemCollectionConnection + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", permissionsV2Api=" + this.permissionsV2Api + ", sharedLink=" + this.sharedLink + ", watermark=" + this.watermark + ")";
        }

        public OnFolder(String id, ItemType type, String str, Date date, String str2, Date date2, Date date3, Date date4, Boolean bool, ItemCollectionConnection1 itemCollectionConnection1, Object obj, Boolean bool2, Boolean bool3, OwnedBy1 ownedBy1, UpdatedBy1 updatedBy1, Parent1 parent1, PermissionsV2Api1 permissionsV2Api1, SharedLink1 sharedLink1, Watermark1 watermark1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.description = str2;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.isRooted = bool;
            this.itemCollectionConnection = itemCollectionConnection1;
            this.size = obj;
            this.hasCollaborations = bool2;
            this.isExternallyOwned = bool3;
            this.ownedBy = ownedBy1;
            this.updatedBy = updatedBy1;
            this.parent = parent1;
            this.permissionsV2Api = permissionsV2Api1;
            this.sharedLink = sharedLink1;
            this.watermark = watermark1;
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

        public final String getDescription() {
            return this.description;
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

        public final Object getSize() {
            return this.size;
        }

        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        public final Boolean isExternallyOwned() {
            return this.isExternallyOwned;
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

        public final PermissionsV2Api1 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final SharedLink1 getSharedLink() {
            return this.sharedLink;
        }

        public final Watermark1 getWatermark() {
            return this.watermark;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection1;", "", "edges", "", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Edge1;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Edge1;", "", "id", "", "node", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node1;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node1;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node1;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node1;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u009e\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;", "", "canDelete", "", "canDownload", "canInviteCollaborator", "canRename", "canSetShareAccess", "canShare", "canUpload", "canPreview", "canComment", "canViewAnnotations", "canCreateAnnotations", "canApplyWatermark", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanDelete", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanDownload", "getCanInviteCollaborator", "getCanRename", "getCanSetShareAccess", "getCanShare", "getCanUpload", "getCanPreview", "getCanComment", "getCanViewAnnotations", "getCanCreateAnnotations", "getCanApplyWatermark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api1 {
        private final Boolean canApplyWatermark;
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

        public static /* synthetic */ PermissionsV2Api1 copy$default(PermissionsV2Api1 permissionsV2Api1, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, int i, Object obj) {
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
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api1.canPreview;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api1.canComment;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api1.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api1.canCreateAnnotations;
            }
            if ((i & 2048) != 0) {
                bool12 = permissionsV2Api1.canApplyWatermark;
            }
            Boolean bool13 = bool11;
            Boolean bool14 = bool12;
            Boolean bool15 = bool9;
            Boolean bool16 = bool10;
            Boolean bool17 = bool7;
            Boolean bool18 = bool8;
            Boolean bool19 = bool5;
            Boolean bool20 = bool6;
            return permissionsV2Api1.copy(bool, bool2, bool3, bool4, bool19, bool20, bool17, bool18, bool15, bool16, bool13, bool14);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getCanApplyWatermark() {
            return this.canApplyWatermark;
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

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final PermissionsV2Api1 copy(Boolean canDelete, Boolean canDownload, Boolean canInviteCollaborator, Boolean canRename, Boolean canSetShareAccess, Boolean canShare, Boolean canUpload, Boolean canPreview, Boolean canComment, Boolean canViewAnnotations, Boolean canCreateAnnotations, Boolean canApplyWatermark) {
            return new PermissionsV2Api1(canDelete, canDownload, canInviteCollaborator, canRename, canSetShareAccess, canShare, canUpload, canPreview, canComment, canViewAnnotations, canCreateAnnotations, canApplyWatermark);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api1)) {
                return false;
            }
            PermissionsV2Api1 permissionsV2Api1 = (PermissionsV2Api1) other;
            return Intrinsics.areEqual(this.canDelete, permissionsV2Api1.canDelete) && Intrinsics.areEqual(this.canDownload, permissionsV2Api1.canDownload) && Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api1.canInviteCollaborator) && Intrinsics.areEqual(this.canRename, permissionsV2Api1.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api1.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api1.canShare) && Intrinsics.areEqual(this.canUpload, permissionsV2Api1.canUpload) && Intrinsics.areEqual(this.canPreview, permissionsV2Api1.canPreview) && Intrinsics.areEqual(this.canComment, permissionsV2Api1.canComment) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api1.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api1.canCreateAnnotations) && Intrinsics.areEqual(this.canApplyWatermark, permissionsV2Api1.canApplyWatermark);
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
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canPreview;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canComment;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            int iHashCode11 = (iHashCode10 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.canApplyWatermark;
            return iHashCode11 + (bool12 != null ? bool12.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api1(canDelete=" + this.canDelete + ", canDownload=" + this.canDownload + ", canInviteCollaborator=" + this.canInviteCollaborator + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ", canUpload=" + this.canUpload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ", canApplyWatermark=" + this.canApplyWatermark + ")";
        }

        public PermissionsV2Api1(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12) {
            this.canDelete = bool;
            this.canDownload = bool2;
            this.canInviteCollaborator = bool3;
            this.canRename = bool4;
            this.canSetShareAccess = bool5;
            this.canShare = bool6;
            this.canUpload = bool7;
            this.canPreview = bool8;
            this.canComment = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
            this.canApplyWatermark = bool12;
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

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        public final Boolean getCanApplyWatermark() {
            return this.canApplyWatermark;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink1 {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink1 copy$default(SharedLink1 sharedLink1, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink1.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink1.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink1.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink1.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink1.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink1.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink1.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink1 copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink1(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink1)) {
                return false;
            }
            SharedLink1 sharedLink1 = (SharedLink1) other;
            return Intrinsics.areEqual(this.url, sharedLink1.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink1.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink1.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink1.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink1.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink1.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink1(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink1(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;", "", "isWatermarked", "", "isWatermarkInherited", "isWatermarkedByAccessPolicy", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Watermark1 {
        private final Boolean isWatermarkInherited;
        private final Boolean isWatermarked;
        private final Boolean isWatermarkedByAccessPolicy;

        public static /* synthetic */ Watermark1 copy$default(Watermark1 watermark1, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = watermark1.isWatermarked;
            }
            if ((i & 2) != 0) {
                bool2 = watermark1.isWatermarkInherited;
            }
            if ((i & 4) != 0) {
                bool3 = watermark1.isWatermarkedByAccessPolicy;
            }
            return watermark1.copy(bool, bool2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsWatermarked() {
            return this.isWatermarked;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsWatermarkInherited() {
            return this.isWatermarkInherited;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getIsWatermarkedByAccessPolicy() {
            return this.isWatermarkedByAccessPolicy;
        }

        public final Watermark1 copy(Boolean isWatermarked, Boolean isWatermarkInherited, Boolean isWatermarkedByAccessPolicy) {
            return new Watermark1(isWatermarked, isWatermarkInherited, isWatermarkedByAccessPolicy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Watermark1)) {
                return false;
            }
            Watermark1 watermark1 = (Watermark1) other;
            return Intrinsics.areEqual(this.isWatermarked, watermark1.isWatermarked) && Intrinsics.areEqual(this.isWatermarkInherited, watermark1.isWatermarkInherited) && Intrinsics.areEqual(this.isWatermarkedByAccessPolicy, watermark1.isWatermarkedByAccessPolicy);
        }

        public int hashCode() {
            Boolean bool = this.isWatermarked;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.isWatermarkInherited;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isWatermarkedByAccessPolicy;
            return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public String toString() {
            return "Watermark1(isWatermarked=" + this.isWatermarked + ", isWatermarkInherited=" + this.isWatermarkInherited + ", isWatermarkedByAccessPolicy=" + this.isWatermarkedByAccessPolicy + ")";
        }

        public Watermark1(Boolean bool, Boolean bool2, Boolean bool3) {
            this.isWatermarked = bool;
            this.isWatermarkInherited = bool2;
            this.isWatermarkedByAccessPolicy = bool3;
        }

        public final Boolean isWatermarked() {
            return this.isWatermarked;
        }

        public final Boolean isWatermarkInherited() {
            return this.isWatermarkInherited;
        }

        public final Boolean isWatermarkedByAccessPolicy() {
            return this.isWatermarkedByAccessPolicy;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010>\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0019HÆ\u0003J²\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u000b\u0010%R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006L"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnWeblink;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "description", "updatedAt", "isRooted", "", "itemCollectionConnection", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection2;", "url", "ownedBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy2;", "updatedBy", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy2;", "parent", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent2;", "permissionsV2Api", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api2;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink2;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection2;Ljava/lang/Object;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink2;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getDescription", "getUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection2;", "getUrl", "()Ljava/lang/Object;", "getOwnedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy2;", "getUpdatedBy", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy2;", "getParent", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent2;", "getPermissionsV2Api", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api2;", "getSharedLink", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink2;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/Boolean;Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection2;Ljava/lang/Object;Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api2;Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink2;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnWeblink;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnWeblink {
        private final Date createdAt;
        private final String description;
        private final String id;
        private final Boolean isRooted;
        private final ItemCollectionConnection2 itemCollectionConnection;
        private final String name;
        private final OwnedBy2 ownedBy;
        private final Parent2 parent;
        private final PermissionsV2Api2 permissionsV2Api;
        private final SharedLink2 sharedLink;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy2 updatedBy;
        private final Object url;

        @Deprecated(message = "use collectionConnection query")
        public static /* synthetic */ void getItemCollectionConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final OwnedBy2 getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final UpdatedBy2 getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Parent2 getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final PermissionsV2Api2 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final SharedLink2 getSharedLink() {
            return this.sharedLink;
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
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getIsRooted() {
            return this.isRooted;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ItemCollectionConnection2 getItemCollectionConnection() {
            return this.itemCollectionConnection;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Object getUrl() {
            return this.url;
        }

        public final OnWeblink copy(String id, ItemType type, String name, Date createdAt, String description, Date updatedAt, Boolean isRooted, ItemCollectionConnection2 itemCollectionConnection, Object url, OwnedBy2 ownedBy, UpdatedBy2 updatedBy, Parent2 parent, PermissionsV2Api2 permissionsV2Api, SharedLink2 sharedLink) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnWeblink(id, type, name, createdAt, description, updatedAt, isRooted, itemCollectionConnection, url, ownedBy, updatedBy, parent, permissionsV2Api, sharedLink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnWeblink)) {
                return false;
            }
            OnWeblink onWeblink = (OnWeblink) other;
            return Intrinsics.areEqual(this.id, onWeblink.id) && this.type == onWeblink.type && Intrinsics.areEqual(this.name, onWeblink.name) && Intrinsics.areEqual(this.createdAt, onWeblink.createdAt) && Intrinsics.areEqual(this.description, onWeblink.description) && Intrinsics.areEqual(this.updatedAt, onWeblink.updatedAt) && Intrinsics.areEqual(this.isRooted, onWeblink.isRooted) && Intrinsics.areEqual(this.itemCollectionConnection, onWeblink.itemCollectionConnection) && Intrinsics.areEqual(this.url, onWeblink.url) && Intrinsics.areEqual(this.ownedBy, onWeblink.ownedBy) && Intrinsics.areEqual(this.updatedBy, onWeblink.updatedBy) && Intrinsics.areEqual(this.parent, onWeblink.parent) && Intrinsics.areEqual(this.permissionsV2Api, onWeblink.permissionsV2Api) && Intrinsics.areEqual(this.sharedLink, onWeblink.sharedLink);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            String str2 = this.description;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Boolean bool = this.isRooted;
            int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            ItemCollectionConnection2 itemCollectionConnection2 = this.itemCollectionConnection;
            int iHashCode7 = (iHashCode6 + (itemCollectionConnection2 == null ? 0 : itemCollectionConnection2.hashCode())) * 31;
            Object obj = this.url;
            int iHashCode8 = (iHashCode7 + (obj == null ? 0 : obj.hashCode())) * 31;
            OwnedBy2 ownedBy2 = this.ownedBy;
            int iHashCode9 = (iHashCode8 + (ownedBy2 == null ? 0 : ownedBy2.hashCode())) * 31;
            UpdatedBy2 updatedBy2 = this.updatedBy;
            int iHashCode10 = (iHashCode9 + (updatedBy2 == null ? 0 : updatedBy2.hashCode())) * 31;
            Parent2 parent2 = this.parent;
            int iHashCode11 = (iHashCode10 + (parent2 == null ? 0 : parent2.hashCode())) * 31;
            PermissionsV2Api2 permissionsV2Api2 = this.permissionsV2Api;
            int iHashCode12 = (iHashCode11 + (permissionsV2Api2 == null ? 0 : permissionsV2Api2.hashCode())) * 31;
            SharedLink2 sharedLink2 = this.sharedLink;
            return iHashCode12 + (sharedLink2 != null ? sharedLink2.hashCode() : 0);
        }

        public String toString() {
            return "OnWeblink(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", description=" + this.description + ", updatedAt=" + this.updatedAt + ", isRooted=" + this.isRooted + ", itemCollectionConnection=" + this.itemCollectionConnection + ", url=" + this.url + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", permissionsV2Api=" + this.permissionsV2Api + ", sharedLink=" + this.sharedLink + ")";
        }

        public OnWeblink(String id, ItemType type, String str, Date date, String str2, Date date2, Boolean bool, ItemCollectionConnection2 itemCollectionConnection2, Object obj, OwnedBy2 ownedBy2, UpdatedBy2 updatedBy2, Parent2 parent2, PermissionsV2Api2 permissionsV2Api2, SharedLink2 sharedLink2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.description = str2;
            this.updatedAt = date2;
            this.isRooted = bool;
            this.itemCollectionConnection = itemCollectionConnection2;
            this.url = obj;
            this.ownedBy = ownedBy2;
            this.updatedBy = updatedBy2;
            this.parent = parent2;
            this.permissionsV2Api = permissionsV2Api2;
            this.sharedLink = sharedLink2;
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

        public final String getDescription() {
            return this.description;
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

        public final Object getUrl() {
            return this.url;
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

        public final PermissionsV2Api2 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final SharedLink2 getSharedLink() {
            return this.sharedLink;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection2;", "", "edges", "", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Edge2;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Edge2;", "", "id", "", "node", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node2;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node2;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node2;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Node2;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api2;", "", "canInviteCollaborator", "", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanInviteCollaborator", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSetShareAccess", "getCanDownload", "getCanPreview", "getCanComment", "getCanUpload", "getCanRename", "getCanDelete", "getCanShare", "getCanViewAnnotations", "getCanCreateAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api2;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api2 {
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

        public static /* synthetic */ PermissionsV2Api2 copy$default(PermissionsV2Api2 permissionsV2Api2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api2.canInviteCollaborator;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api2.canSetShareAccess;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api2.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api2.canPreview;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api2.canComment;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api2.canUpload;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api2.canRename;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api2.canDelete;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api2.canShare;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api2.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api2.canCreateAnnotations;
            }
            Boolean bool12 = bool10;
            Boolean bool13 = bool11;
            Boolean bool14 = bool8;
            Boolean bool15 = bool9;
            Boolean bool16 = bool6;
            Boolean bool17 = bool7;
            Boolean bool18 = bool5;
            Boolean bool19 = bool3;
            return permissionsV2Api2.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
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

        public final PermissionsV2Api2 copy(Boolean canInviteCollaborator, Boolean canSetShareAccess, Boolean canDownload, Boolean canPreview, Boolean canComment, Boolean canUpload, Boolean canRename, Boolean canDelete, Boolean canShare, Boolean canViewAnnotations, Boolean canCreateAnnotations) {
            return new PermissionsV2Api2(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api2)) {
                return false;
            }
            PermissionsV2Api2 permissionsV2Api2 = (PermissionsV2Api2) other;
            return Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api2.canInviteCollaborator) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api2.canSetShareAccess) && Intrinsics.areEqual(this.canDownload, permissionsV2Api2.canDownload) && Intrinsics.areEqual(this.canPreview, permissionsV2Api2.canPreview) && Intrinsics.areEqual(this.canComment, permissionsV2Api2.canComment) && Intrinsics.areEqual(this.canUpload, permissionsV2Api2.canUpload) && Intrinsics.areEqual(this.canRename, permissionsV2Api2.canRename) && Intrinsics.areEqual(this.canDelete, permissionsV2Api2.canDelete) && Intrinsics.areEqual(this.canShare, permissionsV2Api2.canShare) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api2.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api2.canCreateAnnotations);
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
            return "PermissionsV2Api2(canInviteCollaborator=" + this.canInviteCollaborator + ", canSetShareAccess=" + this.canSetShareAccess + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canUpload=" + this.canUpload + ", canRename=" + this.canRename + ", canDelete=" + this.canDelete + ", canShare=" + this.canShare + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ")";
        }

        public PermissionsV2Api2(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
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

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink2;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink2;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink2 {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink2 copy$default(SharedLink2 sharedLink2, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink2.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink2.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink2.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink2.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink2.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink2.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink2.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink2 copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink2(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink2)) {
                return false;
            }
            SharedLink2 sharedLink2 = (SharedLink2) other;
            return Intrinsics.areEqual(this.url, sharedLink2.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink2.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink2.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink2.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink2.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink2.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink2(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink2(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: GetItemWithWatermarkDataQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetItemWithWatermarkDataQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query getItemWithWatermarkData($itemId: ID!, $type: ItemType!) { item(id: $itemId, type: $type) { __typename ... on File { id type name createdAt updatedAt description contentCreatedAt contentUpdatedAt isRooted commentCount annotationCount itemCollectionConnection { edges { id: cursor node { id name collectionType } } } classification { name color definition } size hasCollaborations isExternallyOwned sha1 ownedBy { id name } updatedBy { id name } parent { id name } permissionsV2Api { canComment canDelete canDownload canInviteCollaborator canPreview canRename canSetShareAccess canShare canUpload canViewAnnotations canCreateAnnotations canApplyWatermark } fileVersion { id sha1 } fileLock { id appType createdAt createdBy { id name login } expiresAt isDownloadPrevented } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } watermark { isWatermarked isWatermarkInherited isWatermarkedByAccessPolicy } } ... on Folder { id type name createdAt description updatedAt contentCreatedAt contentUpdatedAt isRooted itemCollectionConnection { edges { id: cursor node { id name collectionType } } } size hasCollaborations isExternallyOwned ownedBy { id name } updatedBy { id name } parent { id name } permissionsV2Api { canDelete canDownload canInviteCollaborator canRename canSetShareAccess canShare canUpload canPreview canComment canViewAnnotations canCreateAnnotations canApplyWatermark } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } watermark { isWatermarked isWatermarkInherited isWatermarkedByAccessPolicy } } ... on Weblink { id type name createdAt description updatedAt isRooted itemCollectionConnection { edges { id: cursor node { id name collectionType } } } url ownedBy { id name } updatedBy { id name } parent { id name } permissionsV2Api { canInviteCollaborator canSetShareAccess canDownload canPreview canComment canUpload canRename canDelete canShare canViewAnnotations canCreateAnnotations } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } } } }";
        }
    }
}
