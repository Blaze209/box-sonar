package com.box.android.data.fragment;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Fragment;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.fragment.selections.collectionFragmentsSelections;
import com.box.android.data.type.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CollectionFragmentsImpl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/fragment/CollectionFragmentsImpl;", "Lcom/apollographql/apollo3/api/Fragment;", "Lcom/box/android/data/fragment/CollectionFragments;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionFragmentsImpl implements Fragment<CollectionFragments> {
    @Override // com.apollographql.apollo3.api.Fragment, com.apollographql.apollo3.api.Executable
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

    @Override // com.apollographql.apollo3.api.Fragment, com.apollographql.apollo3.api.Executable
    public Adapter<CollectionFragments> adapter() {
        return Adapters.m11187obj$default(CollectionFragmentsImpl_ResponseAdapter.CollectionFragments.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Fragment, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", Collection.INSTANCE.getType()).selections(collectionFragmentsSelections.INSTANCE.get__root()).build();
    }
}
