package com.box.android.data.api.models.pushnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.pushnotifications.NotificationCategoriesDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: NotificationCategoriesDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "notificationCategoryDTOAdapter", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<NotificationCategoriesDTO> {
    private final JsonAdapter<NotificationCategoryDTO> notificationCategoryDTOAdapter;
    private final JsonReader.Options options;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("SHARING", "MENTIONS", "TASKS", "RELEVANT_UPDATES", "EVENT_COMMENT_CREATE", "EVENT_COLLAB_INVITE_COLLABORATOR", "EVENT_ITEM_MODIFY", "EVENT_ITEM_UPLOAD");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<NotificationCategoryDTO> jsonAdapterAdapter = moshi.adapter(NotificationCategoryDTO.class, SetsKt.emptySet(), "sharing");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.notificationCategoryDTOAdapter = jsonAdapterAdapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(47);
        sb.append("GeneratedJsonAdapter(NotificationCategoriesDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public NotificationCategoriesDTO fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        NotificationCategoryDTO notificationCategoryDTOFromJson = null;
        NotificationCategoryDTO notificationCategoryDTOFromJson2 = null;
        NotificationCategoryDTO notificationCategoryDTOFromJson3 = null;
        NotificationCategoryDTO notificationCategoryDTO = null;
        NotificationCategoryDTO notificationCategoryDTOFromJson4 = null;
        NotificationCategoryDTO notificationCategoryDTOFromJson5 = null;
        NotificationCategoryDTO notificationCategoryDTO2 = null;
        NotificationCategoryDTO notificationCategoryDTOFromJson6 = null;
        while (true) {
            NotificationCategoryDTO notificationCategoryDTO3 = notificationCategoryDTOFromJson;
            NotificationCategoryDTO notificationCategoryDTO4 = notificationCategoryDTOFromJson2;
            NotificationCategoryDTO notificationCategoryDTO5 = notificationCategoryDTOFromJson3;
            NotificationCategoryDTO notificationCategoryDTO6 = notificationCategoryDTO;
            NotificationCategoryDTO notificationCategoryDTO7 = notificationCategoryDTOFromJson4;
            NotificationCategoryDTO notificationCategoryDTO8 = notificationCategoryDTOFromJson5;
            NotificationCategoryDTO notificationCategoryDTO9 = notificationCategoryDTO2;
            NotificationCategoryDTO notificationCategoryDTO10 = notificationCategoryDTOFromJson6;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                    case 0:
                        notificationCategoryDTOFromJson = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("sharing", "SHARING", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull;
                        }
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                    case 1:
                        notificationCategoryDTOFromJson2 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("mentions", "MENTIONS", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull2;
                        }
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                        break;
                    case 2:
                        notificationCategoryDTOFromJson3 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson3 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("tasks", "TASKS", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull3;
                        }
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                        break;
                    case 3:
                        NotificationCategoryDTO notificationCategoryDTOFromJson7 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson7 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("relevantUpdates", "RELEVANT_UPDATES", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull4;
                        }
                        notificationCategoryDTO = notificationCategoryDTOFromJson7;
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                        break;
                    case 4:
                        notificationCategoryDTOFromJson4 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson4 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull5 = Util.unexpectedNull("commentCreated", "EVENT_COMMENT_CREATE", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull5, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull5;
                        }
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                        break;
                    case 5:
                        notificationCategoryDTOFromJson5 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson5 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull6 = Util.unexpectedNull("collaborationInvite", "EVENT_COLLAB_INVITE_COLLABORATOR", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull6, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull6;
                        }
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                        break;
                    case 6:
                        NotificationCategoryDTO notificationCategoryDTOFromJson8 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson8 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull7 = Util.unexpectedNull(SemanticAttributes.FaasDocumentOperationValues.EDIT, "EVENT_ITEM_MODIFY", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull7, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull7;
                        }
                        notificationCategoryDTO2 = notificationCategoryDTOFromJson8;
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                        break;
                    case 7:
                        notificationCategoryDTOFromJson6 = this.notificationCategoryDTOAdapter.fromJson(reader);
                        if (notificationCategoryDTOFromJson6 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull8 = Util.unexpectedNull(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "EVENT_ITEM_UPLOAD", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull8, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull8;
                        }
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        break;
                        break;
                    default:
                        notificationCategoryDTOFromJson = notificationCategoryDTO3;
                        notificationCategoryDTOFromJson2 = notificationCategoryDTO4;
                        notificationCategoryDTOFromJson3 = notificationCategoryDTO5;
                        notificationCategoryDTO = notificationCategoryDTO6;
                        notificationCategoryDTOFromJson4 = notificationCategoryDTO7;
                        notificationCategoryDTOFromJson5 = notificationCategoryDTO8;
                        notificationCategoryDTO2 = notificationCategoryDTO9;
                        notificationCategoryDTOFromJson6 = notificationCategoryDTO10;
                        break;
                }
            } else {
                reader.endObject();
                if (notificationCategoryDTO3 == null) {
                    JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("sharing", "SHARING", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty;
                }
                if (notificationCategoryDTO4 == null) {
                    JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("mentions", "MENTIONS", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty2;
                }
                if (notificationCategoryDTO5 == null) {
                    JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("tasks", "TASKS", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty3;
                }
                if (notificationCategoryDTO6 == null) {
                    JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("relevantUpdates", "RELEVANT_UPDATES", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty4;
                }
                if (notificationCategoryDTO7 == null) {
                    JsonDataException jsonDataExceptionMissingProperty5 = Util.missingProperty("commentCreated", "EVENT_COMMENT_CREATE", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty5, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty5;
                }
                if (notificationCategoryDTO8 == null) {
                    JsonDataException jsonDataExceptionMissingProperty6 = Util.missingProperty("collaborationInvite", "EVENT_COLLAB_INVITE_COLLABORATOR", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty6, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty6;
                }
                if (notificationCategoryDTO9 == null) {
                    JsonDataException jsonDataExceptionMissingProperty7 = Util.missingProperty(SemanticAttributes.FaasDocumentOperationValues.EDIT, "EVENT_ITEM_MODIFY", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty7, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty7;
                }
                if (notificationCategoryDTO10 != null) {
                    return new NotificationCategoriesDTO(notificationCategoryDTO3, notificationCategoryDTO4, notificationCategoryDTO5, notificationCategoryDTO6, notificationCategoryDTO7, notificationCategoryDTO8, notificationCategoryDTO9, notificationCategoryDTO10);
                }
                JsonDataException jsonDataExceptionMissingProperty8 = Util.missingProperty(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "EVENT_ITEM_UPLOAD", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty8, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty8;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, NotificationCategoriesDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("SHARING");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getSharing());
        writer.name("MENTIONS");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getMentions());
        writer.name("TASKS");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getTasks());
        writer.name("RELEVANT_UPDATES");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getRelevantUpdates());
        writer.name("EVENT_COMMENT_CREATE");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getCommentCreated());
        writer.name("EVENT_COLLAB_INVITE_COLLABORATOR");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getCollaborationInvite());
        writer.name("EVENT_ITEM_MODIFY");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getEdit());
        writer.name("EVENT_ITEM_UPLOAD");
        this.notificationCategoryDTOAdapter.toJson(writer, value_.getUpload());
        writer.endObject();
    }
}
