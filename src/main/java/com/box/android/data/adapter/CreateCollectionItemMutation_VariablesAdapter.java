package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.CreateCollectionItemMutation;
import com.box.android.data.type.adapter.ItemType_ResponseAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateCollectionItemMutation_VariablesAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/adapter/CreateCollectionItemMutation_VariablesAdapter;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateCollectionItemMutation;", "<init>", "()V", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCollectionItemMutation_VariablesAdapter implements Adapter<CreateCollectionItemMutation> {
    public static final CreateCollectionItemMutation_VariablesAdapter INSTANCE = new CreateCollectionItemMutation_VariablesAdapter();

    private CreateCollectionItemMutation_VariablesAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.apollographql.apollo3.api.Adapter
    public CreateCollectionItemMutation fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        throw new IllegalStateException("Input type used in output position");
    }

    @Override // com.apollographql.apollo3.api.Adapter
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateCollectionItemMutation value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.name(BoxItemJob.COLLECTION_ID);
        Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getCollectionId());
        writer.name("itemId");
        Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getItemId());
        writer.name("itemType");
        ItemType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.getItemType());
    }
}
