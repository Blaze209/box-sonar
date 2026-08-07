package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObjectBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a)\u0010\u0007\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\f\u001a\u0002H\t¢\u0006\u0002\u0010\r\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"GlobalBuilder", "Lcom/apollographql/apollo3/api/BuilderScope;", "getGlobalBuilder", "()Lcom/apollographql/apollo3/api/BuilderScope;", "Builder", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adaptValue", "", ExifInterface.GPS_DIRECTION_TRUE, "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "value", "(Lcom/apollographql/apollo3/api/Adapter;Ljava/lang/Object;)Ljava/lang/Object;", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ObjectBuilderKt {
    private static final BuilderScope GlobalBuilder = new BuilderScope() { // from class: com.apollographql.apollo3.api.ObjectBuilderKt$GlobalBuilder$1
        @Override // com.apollographql.apollo3.api.BuilderScope
        /* JADX INFO: renamed from: getCustomScalarAdapters */
        public CustomScalarAdapters get$customScalarAdapters() {
            return CustomScalarAdapters.PassThrough;
        }
    };

    public static final BuilderScope Builder(final CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return new BuilderScope() { // from class: com.apollographql.apollo3.api.ObjectBuilderKt.Builder.1
            @Override // com.apollographql.apollo3.api.BuilderScope
            /* JADX INFO: renamed from: getCustomScalarAdapters, reason: from getter */
            public CustomScalarAdapters get$customScalarAdapters() {
                return customScalarAdapters;
            }
        };
    }

    public static final BuilderScope getGlobalBuilder() {
        return GlobalBuilder;
    }

    public static final <T> Object adaptValue(Adapter<T> adapter, T t) throws IOException {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        MapJsonWriter mapJsonWriter = new MapJsonWriter();
        adapter.toJson(mapJsonWriter, CustomScalarAdapters.Empty, t);
        return mapJsonWriter.root();
    }
}
