package com.box.android.data.api.models.adapters;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SkipUnknownElementsListAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001:\u0001\u000fB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/models/adapters/SkipUnknownElementsListAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "", "elementAdapter", "<init>", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Factory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SkipUnknownElementsListAdapter extends JsonAdapter<List<? extends Object>> {
    private final JsonAdapter<Object> elementAdapter;

    public SkipUnknownElementsListAdapter(JsonAdapter<Object> elementAdapter) {
        Intrinsics.checkNotNullParameter(elementAdapter, "elementAdapter");
        this.elementAdapter = elementAdapter;
    }

    /* JADX INFO: compiled from: SkipUnknownElementsListAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/box/android/data/api/models/adapters/SkipUnknownElementsListAdapter$Factory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Factory implements JsonAdapter.Factory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @Override // com.squareup.moshi.JsonAdapter.Factory
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            if (!annotations.isEmpty() || !Intrinsics.areEqual(Types.getRawType(type), List.class)) {
                return null;
            }
            JsonAdapter jsonAdapterAdapter = moshi.adapter(Types.collectionElementType(type, List.class));
            Intrinsics.checkNotNull(jsonAdapterAdapter);
            return new SkipUnknownElementsListAdapter(jsonAdapterAdapter);
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public List<? extends Object> fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        ArrayList arrayList = new ArrayList();
        reader.beginArray();
        while (reader.hasNext()) {
            try {
                Object objFromJson = this.elementAdapter.fromJson(reader.peekJson());
                if (objFromJson != null) {
                    arrayList.add(objFromJson);
                }
            } catch (JsonDataException unused) {
            }
            reader.skipValue();
        }
        reader.endArray();
        return arrayList;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, List<? extends Object> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            writer.nullValue();
            return;
        }
        writer.beginArray();
        int size = value.size();
        for (int i = 0; i < size; i++) {
            this.elementAdapter.toJson(writer, value.get(i));
        }
        writer.endArray();
    }
}
