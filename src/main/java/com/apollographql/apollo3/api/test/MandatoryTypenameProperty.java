package com.apollographql.apollo3.api.test;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0086\u0002J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/api/test/MandatoryTypenameProperty;", "", "parentTypeName", "", "possibleTypes", "", "(Ljava/lang/String;Ljava/util/List;)V", "typename", "getValue", "mapBuilder", "Lcom/apollographql/apollo3/api/test/MapBuilder;", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MandatoryTypenameProperty {
    private final String parentTypeName;
    private final List<String> possibleTypes;
    private String typename;

    public MandatoryTypenameProperty(String parentTypeName, List<String> possibleTypes) {
        Intrinsics.checkNotNullParameter(parentTypeName, "parentTypeName");
        Intrinsics.checkNotNullParameter(possibleTypes, "possibleTypes");
        this.parentTypeName = parentTypeName;
        this.possibleTypes = possibleTypes;
    }

    public final String getValue(MapBuilder mapBuilder, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(mapBuilder, "mapBuilder");
        Intrinsics.checkNotNullParameter(property, "property");
        String str = this.typename;
        if (str == null) {
            throw new IllegalStateException((this.parentTypeName + ": __typename is not known at compile-time for this type. Please specify it explicitly (allowed values: " + CollectionsKt.joinToString$default(this.possibleTypes, null, null, null, 0, null, null, 63, null) + ')').toString());
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final void setValue(MapBuilder mapBuilder, KProperty<?> property, String value) {
        Intrinsics.checkNotNullParameter(mapBuilder, "mapBuilder");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        this.typename = value;
    }
}
