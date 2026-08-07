package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.json.MapJsonReader;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ObjectBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0086\u0002¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0011R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/api/BuilderProperty;", ExifInterface.GPS_DIRECTION_TRUE, "", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "(Lcom/apollographql/apollo3/api/Adapter;)V", "getAdapter", "()Lcom/apollographql/apollo3/api/Adapter;", "getValue", "thisRef", "Lcom/apollographql/apollo3/api/ObjectBuilder;", "property", "Lkotlin/reflect/KProperty;", "(Lcom/apollographql/apollo3/api/ObjectBuilder;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lcom/apollographql/apollo3/api/ObjectBuilder;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BuilderProperty<T> {
    private final Adapter<T> adapter;

    public BuilderProperty(Adapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    public final Adapter<T> getAdapter() {
        return this.adapter;
    }

    public final T getValue(ObjectBuilder thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        Object obj = thisRef.get__fields().get(property.getName());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        return this.adapter.fromJson(new MapJsonReader((Map) obj, null, 2, null), CustomScalarAdapters.Empty);
    }

    public final void setValue(ObjectBuilder thisRef, KProperty<?> property, T value) throws IOException {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        Map<String, Object> map = thisRef.get__fields();
        String name = property.getName();
        MapJsonWriter mapJsonWriter = new MapJsonWriter();
        this.adapter.toJson(mapJsonWriter, CustomScalarAdapters.Empty, value);
        map.put(name, mapJsonWriter.root());
    }
}
