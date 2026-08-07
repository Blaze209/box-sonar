package com.box.android.data.api.models.observability;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
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

/* JADX INFO: renamed from: com.box.android.data.api.models.observability.UploadLogMetadataDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: UploadLogMetadataDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/observability/UploadLogMetadataDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/observability/UploadLogMetadataDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "clientLogMetadataAdapter", "Lcom/box/android/data/api/models/observability/ClientLogMetadata;", "userMiniDTOAdapter", "Lcom/box/android/data/api/models/UserMiniDTO;", "fileDTOAdapter", "Lcom/box/android/data/api/models/items/FileDTO;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<UploadLogMetadataDTO> {
    private final JsonAdapter<ClientLogMetadata> clientLogMetadataAdapter;
    private final JsonAdapter<FileDTO> fileDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<UserMiniDTO> userMiniDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("client_log_metadata", "user", "file");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<ClientLogMetadata> jsonAdapterAdapter = moshi.adapter(ClientLogMetadata.class, SetsKt.emptySet(), "clientLogMetadata");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.clientLogMetadataAdapter = jsonAdapterAdapter;
        JsonAdapter<UserMiniDTO> jsonAdapterAdapter2 = moshi.adapter(UserMiniDTO.class, SetsKt.emptySet(), "user");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.userMiniDTOAdapter = jsonAdapterAdapter2;
        JsonAdapter<FileDTO> jsonAdapterAdapter3 = moshi.adapter(FileDTO.class, SetsKt.emptySet(), "file");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.fileDTOAdapter = jsonAdapterAdapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(UploadLogMetadataDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public UploadLogMetadataDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        ClientLogMetadata clientLogMetadataFromJson = null;
        UserMiniDTO userMiniDTOFromJson = null;
        FileDTO fileDTOFromJson = null;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                clientLogMetadataFromJson = this.clientLogMetadataAdapter.fromJson(reader);
                if (clientLogMetadataFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("clientLogMetadata", "client_log_metadata", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull;
                }
            } else if (iSelectName == 1) {
                userMiniDTOFromJson = this.userMiniDTOAdapter.fromJson(reader);
                if (userMiniDTOFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("user", "user", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull2;
                }
            } else if (iSelectName == 2 && (fileDTOFromJson = this.fileDTOAdapter.fromJson(reader)) == null) {
                JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("file_", "file", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                throw jsonDataExceptionUnexpectedNull3;
            }
        }
        reader.endObject();
        if (clientLogMetadataFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("clientLogMetadata", "client_log_metadata", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty;
        }
        if (userMiniDTOFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("user", "user", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty2;
        }
        if (fileDTOFromJson != null) {
            return new UploadLogMetadataDTO(clientLogMetadataFromJson, userMiniDTOFromJson, fileDTOFromJson);
        }
        JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("file_", "file", reader);
        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
        throw jsonDataExceptionMissingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, UploadLogMetadataDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("client_log_metadata");
        this.clientLogMetadataAdapter.toJson(writer, value_.getClientLogMetadata());
        writer.name("user");
        this.userMiniDTOAdapter.toJson(writer, value_.getUser());
        writer.name("file");
        this.fileDTOAdapter.toJson(writer, value_.getFile());
        writer.endObject();
    }
}
