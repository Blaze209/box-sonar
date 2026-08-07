package com.box.android.data.api.models;

import com.box.androidsdk.content.models.BoxRepresentation;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.RepresentationDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: RepresentationDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/api/models/RepresentationDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/RepresentationDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "representationContentDTOAdapter", "Lcom/box/android/data/api/models/RepresentationContentDTO;", "nullableRepresentationInfoDTOAdapter", "Lcom/box/android/data/api/models/RepresentationInfoDTO;", "representationPropertiesDTOAdapter", "Lcom/box/android/data/api/models/RepresentationPropertiesDTO;", "representationTypeDTOAdapter", "Lcom/box/android/data/api/models/RepresentationTypeDTO;", "representationStatusDTOAdapter", "Lcom/box/android/data/api/models/RepresentationStatusDTO;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<RepresentationDTO> {
    private final JsonAdapter<RepresentationInfoDTO> nullableRepresentationInfoDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<RepresentationContentDTO> representationContentDTOAdapter;
    private final JsonAdapter<RepresentationPropertiesDTO> representationPropertiesDTOAdapter;
    private final JsonAdapter<RepresentationStatusDTO> representationStatusDTOAdapter;
    private final JsonAdapter<RepresentationTypeDTO> representationTypeDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("content", BoxRepresentation.FIELD_INFO, "properties", BoxRepresentation.FIELD_REPRESENTATION, "status");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<RepresentationContentDTO> jsonAdapterAdapter = moshi.adapter(RepresentationContentDTO.class, SetsKt.emptySet(), "content");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.representationContentDTOAdapter = jsonAdapterAdapter;
        JsonAdapter<RepresentationInfoDTO> jsonAdapterAdapter2 = moshi.adapter(RepresentationInfoDTO.class, SetsKt.emptySet(), BoxRepresentation.FIELD_INFO);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.nullableRepresentationInfoDTOAdapter = jsonAdapterAdapter2;
        JsonAdapter<RepresentationPropertiesDTO> jsonAdapterAdapter3 = moshi.adapter(RepresentationPropertiesDTO.class, SetsKt.emptySet(), "properties");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.representationPropertiesDTOAdapter = jsonAdapterAdapter3;
        JsonAdapter<RepresentationTypeDTO> jsonAdapterAdapter4 = moshi.adapter(RepresentationTypeDTO.class, SetsKt.emptySet(), "representationType");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.representationTypeDTOAdapter = jsonAdapterAdapter4;
        JsonAdapter<RepresentationStatusDTO> jsonAdapterAdapter5 = moshi.adapter(RepresentationStatusDTO.class, SetsKt.emptySet(), "status");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.representationStatusDTOAdapter = jsonAdapterAdapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(RepresentationDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public RepresentationDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        RepresentationContentDTO representationContentDTOFromJson = null;
        RepresentationInfoDTO representationInfoDTOFromJson = null;
        RepresentationPropertiesDTO representationPropertiesDTOFromJson = null;
        RepresentationTypeDTO representationTypeDTOFromJson = null;
        RepresentationStatusDTO representationStatusDTOFromJson = null;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                representationContentDTOFromJson = this.representationContentDTOAdapter.fromJson(reader);
                if (representationContentDTOFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("content", "content", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull;
                }
            } else if (iSelectName == 1) {
                representationInfoDTOFromJson = this.nullableRepresentationInfoDTOAdapter.fromJson(reader);
            } else if (iSelectName == 2) {
                representationPropertiesDTOFromJson = this.representationPropertiesDTOAdapter.fromJson(reader);
                if (representationPropertiesDTOFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("properties", "properties", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull2;
                }
            } else if (iSelectName == 3) {
                representationTypeDTOFromJson = this.representationTypeDTOAdapter.fromJson(reader);
                if (representationTypeDTOFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("representationType", BoxRepresentation.FIELD_REPRESENTATION, reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull3;
                }
            } else if (iSelectName == 4 && (representationStatusDTOFromJson = this.representationStatusDTOAdapter.fromJson(reader)) == null) {
                JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("status", "status", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                throw jsonDataExceptionUnexpectedNull4;
            }
        }
        reader.endObject();
        if (representationContentDTOFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("content", "content", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty;
        }
        if (representationPropertiesDTOFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("properties", "properties", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty2;
        }
        if (representationTypeDTOFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("representationType", BoxRepresentation.FIELD_REPRESENTATION, reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty3;
        }
        if (representationStatusDTOFromJson != null) {
            return new RepresentationDTO(representationContentDTOFromJson, representationInfoDTOFromJson, representationPropertiesDTOFromJson, representationTypeDTOFromJson, representationStatusDTOFromJson);
        }
        JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("status", "status", reader);
        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
        throw jsonDataExceptionMissingProperty4;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, RepresentationDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("content");
        this.representationContentDTOAdapter.toJson(writer, value_.getContent());
        writer.name(BoxRepresentation.FIELD_INFO);
        this.nullableRepresentationInfoDTOAdapter.toJson(writer, value_.getInfo());
        writer.name("properties");
        this.representationPropertiesDTOAdapter.toJson(writer, value_.getProperties());
        writer.name(BoxRepresentation.FIELD_REPRESENTATION);
        this.representationTypeDTOAdapter.toJson(writer, value_.getRepresentationType());
        writer.name("status");
        this.representationStatusDTOAdapter.toJson(writer, value_.getStatus());
        writer.endObject();
    }
}
