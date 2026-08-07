package com.box.android.data.utilities;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KotlinObjectAdapterFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/box/android/data/utilities/KotlinObjectAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KotlinObjectAdapterFactory implements JsonAdapter.Factory {
    @Override // com.squareup.moshi.JsonAdapter.Factory
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Class<?> rawType = Types.getRawType(type);
        Intrinsics.checkNotNull(rawType);
        final Object objectInstance = JvmClassMappingKt.getKotlinClass(rawType).getObjectInstance();
        if (objectInstance == null) {
            return null;
        }
        return new JsonAdapter<Object>() { // from class: com.box.android.data.utilities.KotlinObjectAdapterFactory.create.1
            @Override // com.squareup.moshi.JsonAdapter
            public Object fromJson(JsonReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                reader.beginObject();
                while (reader.hasNext()) {
                    reader.skipName();
                    reader.skipValue();
                }
                reader.endObject();
                return objectInstance;
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter writer, Object value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.beginObject().endObject();
            }
        };
    }
}
