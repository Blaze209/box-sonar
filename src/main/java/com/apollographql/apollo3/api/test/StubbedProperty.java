package com.apollographql.apollo3.api.test;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0086\u0002¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0011R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/api/test/StubbedProperty;", ExifInterface.GPS_DIRECTION_TRUE, "", "map", "", "", "responseName", "(Ljava/util/Map;Ljava/lang/String;)V", "getValue", "mapBuilder", "Lcom/apollographql/apollo3/api/test/MapBuilder;", "property", "Lkotlin/reflect/KProperty;", "(Lcom/apollographql/apollo3/api/test/MapBuilder;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lcom/apollographql/apollo3/api/test/MapBuilder;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StubbedProperty<T> {
    private final Map<String, Object> map;
    private final String responseName;

    public StubbedProperty(Map<String, Object> map, String responseName) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(responseName, "responseName");
        this.map = map;
        this.responseName = responseName;
    }

    public final T getValue(MapBuilder mapBuilder, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(mapBuilder, "mapBuilder");
        Intrinsics.checkNotNullParameter(property, "property");
        if (!this.map.containsKey(this.responseName)) {
            throw new IllegalStateException(("Property " + this.responseName + " is not set").toString());
        }
        return (T) this.map.get(this.responseName);
    }

    public final void setValue(MapBuilder mapBuilder, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(mapBuilder, "mapBuilder");
        Intrinsics.checkNotNullParameter(property, "property");
        this.map.put(this.responseName, value);
    }
}
