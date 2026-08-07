package com.box.android.data.api.models.fileversions;

import com.box.android.data.api.models.RepresentationsDTO;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.models.BoxFile;
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

/* JADX INFO: renamed from: com.box.android.data.api.models.fileversions.FileVersionRepresentationsDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: FileVersionRepresentationsDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/fileversions/FileVersionRepresentationsDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/fileversions/FileVersionRepresentationsDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "representationsDTOAdapter", "Lcom/box/android/data/api/models/RepresentationsDTO;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<FileVersionRepresentationsDTO> {
    private final JsonReader.Options options;
    private final JsonAdapter<RepresentationsDTO> representationsDTOAdapter;
    private final JsonAdapter<String> stringAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("id", "name", BoxApiPreview.FIELD_AUTHENTICATED_DOWNLOAD_URL, BoxFile.FIELD_REPRESENTATIONS);
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<RepresentationsDTO> jsonAdapterAdapter2 = moshi.adapter(RepresentationsDTO.class, SetsKt.emptySet(), BoxFile.FIELD_REPRESENTATIONS);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.representationsDTOAdapter = jsonAdapterAdapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(51);
        sb.append("GeneratedJsonAdapter(FileVersionRepresentationsDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public FileVersionRepresentationsDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String strFromJson = null;
        String strFromJson2 = null;
        String strFromJson3 = null;
        RepresentationsDTO representationsDTOFromJson = null;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                strFromJson = this.stringAdapter.fromJson(reader);
                if (strFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("id", "id", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull;
                }
            } else if (iSelectName == 1) {
                strFromJson2 = this.stringAdapter.fromJson(reader);
                if (strFromJson2 == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("name", "name", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull2;
                }
            } else if (iSelectName == 2) {
                strFromJson3 = this.stringAdapter.fromJson(reader);
                if (strFromJson3 == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("downloadUrl", BoxApiPreview.FIELD_AUTHENTICATED_DOWNLOAD_URL, reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull3;
                }
            } else if (iSelectName == 3 && (representationsDTOFromJson = this.representationsDTOAdapter.fromJson(reader)) == null) {
                JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull(BoxFile.FIELD_REPRESENTATIONS, BoxFile.FIELD_REPRESENTATIONS, reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                throw jsonDataExceptionUnexpectedNull4;
            }
        }
        reader.endObject();
        if (strFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("id", "id", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty;
        }
        if (strFromJson2 == null) {
            JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("name", "name", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty2;
        }
        if (strFromJson3 == null) {
            JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("downloadUrl", BoxApiPreview.FIELD_AUTHENTICATED_DOWNLOAD_URL, reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty3;
        }
        if (representationsDTOFromJson != null) {
            return new FileVersionRepresentationsDTO(strFromJson, strFromJson2, strFromJson3, representationsDTOFromJson);
        }
        JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty(BoxFile.FIELD_REPRESENTATIONS, BoxFile.FIELD_REPRESENTATIONS, reader);
        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
        throw jsonDataExceptionMissingProperty4;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, FileVersionRepresentationsDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, value_.getId());
        writer.name("name");
        this.stringAdapter.toJson(writer, value_.getName());
        writer.name(BoxApiPreview.FIELD_AUTHENTICATED_DOWNLOAD_URL);
        this.stringAdapter.toJson(writer, value_.getDownloadUrl());
        writer.name(BoxFile.FIELD_REPRESENTATIONS);
        this.representationsDTOAdapter.toJson(writer, value_.getRepresentations());
        writer.endObject();
    }
}
