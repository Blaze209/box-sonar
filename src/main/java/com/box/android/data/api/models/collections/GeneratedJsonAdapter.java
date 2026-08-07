package com.box.android.data.api.models.collections;

import com.box.android.data.api.models.PaginationDTO;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.collections.CollectionItemsDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: CollectionItemsDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/collections/CollectionItemsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/collections/CollectionItemsDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "listOfCollectionItemDTOAdapter", "", "Lcom/box/android/data/api/models/collections/CollectionItemDTO;", "paginationDTOAdapter", "Lcom/box/android/data/api/models/PaginationDTO;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<CollectionItemsDTO> {
    private final JsonAdapter<List<CollectionItemDTO>> listOfCollectionItemDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<PaginationDTO> paginationDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("data", "pagination");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<List<CollectionItemDTO>> jsonAdapterAdapter = moshi.adapter(Types.newParameterizedType(List.class, CollectionItemDTO.class), SetsKt.emptySet(), "entries");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.listOfCollectionItemDTOAdapter = jsonAdapterAdapter;
        JsonAdapter<PaginationDTO> jsonAdapterAdapter2 = moshi.adapter(PaginationDTO.class, SetsKt.emptySet(), "pagination");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.paginationDTOAdapter = jsonAdapterAdapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(CollectionItemsDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CollectionItemsDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        List<CollectionItemDTO> listFromJson = null;
        PaginationDTO paginationDTOFromJson = null;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                listFromJson = this.listOfCollectionItemDTOAdapter.fromJson(reader);
                if (listFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("entries", "data", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull;
                }
            } else if (iSelectName == 1 && (paginationDTOFromJson = this.paginationDTOAdapter.fromJson(reader)) == null) {
                JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("pagination", "pagination", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                throw jsonDataExceptionUnexpectedNull2;
            }
        }
        reader.endObject();
        if (listFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("entries", "data", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty;
        }
        if (paginationDTOFromJson != null) {
            return new CollectionItemsDTO(listFromJson, paginationDTOFromJson);
        }
        JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("pagination", "pagination", reader);
        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
        throw jsonDataExceptionMissingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CollectionItemsDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("data");
        this.listOfCollectionItemDTOAdapter.toJson(writer, value_.getEntries());
        writer.name("pagination");
        this.paginationDTOAdapter.toJson(writer, value_.getPagination());
        writer.endObject();
    }
}
