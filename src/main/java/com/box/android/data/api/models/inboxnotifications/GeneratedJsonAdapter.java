package com.box.android.data.api.models.inboxnotifications;

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

/* JADX INFO: renamed from: com.box.android.data.api.models.inboxnotifications.CommonPayloadDTOInboxJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: CommonPayloadDTOInboxJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInboxJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "avatarDTOAdapter", "Lcom/box/android/data/api/models/inboxnotifications/AvatarDTO;", "nullableIconDTOAdapter", "Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "textDTOAdapter", "Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "nullableTextDTOAdapter", "nullableStatusDTOAdapter", "Lcom/box/android/data/api/models/inboxnotifications/StatusDTO;", "listOfIconDTOAdapter", "", "nullableActionDTOAdapter", "Lcom/box/android/data/api/models/inboxnotifications/ActionDTO;", "listOfActionDTOAdapter", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<CommonPayloadDTOInbox> {
    private final JsonAdapter<AvatarDTO> avatarDTOAdapter;
    private final JsonAdapter<List<ActionDTO>> listOfActionDTOAdapter;
    private final JsonAdapter<List<IconDTO>> listOfIconDTOAdapter;
    private final JsonAdapter<ActionDTO> nullableActionDTOAdapter;
    private final JsonAdapter<IconDTO> nullableIconDTOAdapter;
    private final JsonAdapter<StatusDTO> nullableStatusDTOAdapter;
    private final JsonAdapter<TextDTO> nullableTextDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<TextDTO> textDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("type", "main_icon", "sub_icon", "title", "message", "status", "timestamp", "status_icons", "card_action", "primary_action", "secondary_action", "menu_actions");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<AvatarDTO> jsonAdapterAdapter2 = moshi.adapter(AvatarDTO.class, SetsKt.emptySet(), "mainIcon");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.avatarDTOAdapter = jsonAdapterAdapter2;
        JsonAdapter<IconDTO> jsonAdapterAdapter3 = moshi.adapter(IconDTO.class, SetsKt.emptySet(), "subIcon");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.nullableIconDTOAdapter = jsonAdapterAdapter3;
        JsonAdapter<TextDTO> jsonAdapterAdapter4 = moshi.adapter(TextDTO.class, SetsKt.emptySet(), "title");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.textDTOAdapter = jsonAdapterAdapter4;
        JsonAdapter<TextDTO> jsonAdapterAdapter5 = moshi.adapter(TextDTO.class, SetsKt.emptySet(), "message");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.nullableTextDTOAdapter = jsonAdapterAdapter5;
        JsonAdapter<StatusDTO> jsonAdapterAdapter6 = moshi.adapter(StatusDTO.class, SetsKt.emptySet(), "status");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter6, "adapter(...)");
        this.nullableStatusDTOAdapter = jsonAdapterAdapter6;
        JsonAdapter<List<IconDTO>> jsonAdapterAdapter7 = moshi.adapter(Types.newParameterizedType(List.class, IconDTO.class), SetsKt.emptySet(), "statusIcons");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter7, "adapter(...)");
        this.listOfIconDTOAdapter = jsonAdapterAdapter7;
        JsonAdapter<ActionDTO> jsonAdapterAdapter8 = moshi.adapter(ActionDTO.class, SetsKt.emptySet(), "cardAction");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter8, "adapter(...)");
        this.nullableActionDTOAdapter = jsonAdapterAdapter8;
        JsonAdapter<List<ActionDTO>> jsonAdapterAdapter9 = moshi.adapter(Types.newParameterizedType(List.class, ActionDTO.class), SetsKt.emptySet(), "menuActions");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter9, "adapter(...)");
        this.listOfActionDTOAdapter = jsonAdapterAdapter9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(CommonPayloadDTOInbox)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CommonPayloadDTOInbox fromJson(JsonReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String strFromJson = null;
        AvatarDTO avatarDTOFromJson = null;
        IconDTO iconDTOFromJson = null;
        TextDTO textDTOFromJson = null;
        TextDTO textDTOFromJson2 = null;
        StatusDTO statusDTOFromJson = null;
        String strFromJson2 = null;
        List<IconDTO> list = null;
        ActionDTO actionDTOFromJson = null;
        ActionDTO actionDTOFromJson2 = null;
        ActionDTO actionDTOFromJson3 = null;
        List<ActionDTO> listFromJson = null;
        while (true) {
            String str = strFromJson;
            AvatarDTO avatarDTO = avatarDTOFromJson;
            IconDTO iconDTO = iconDTOFromJson;
            TextDTO textDTO = textDTOFromJson;
            TextDTO textDTO2 = textDTOFromJson2;
            StatusDTO statusDTO = statusDTOFromJson;
            String str2 = strFromJson2;
            if (reader.hasNext()) {
                List<IconDTO> list2 = list;
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    case 0:
                        strFromJson = this.stringAdapter.fromJson(reader);
                        if (strFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("type", "type", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull;
                        }
                        list = list2;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                        break;
                    case 1:
                        avatarDTOFromJson = this.avatarDTOAdapter.fromJson(reader);
                        if (avatarDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("mainIcon", "main_icon", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull2;
                        }
                        list = list2;
                        strFromJson = str;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                        break;
                    case 2:
                        iconDTOFromJson = this.nullableIconDTOAdapter.fromJson(reader);
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    case 3:
                        textDTOFromJson = this.textDTOAdapter.fromJson(reader);
                        if (textDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("title", "title", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull3;
                        }
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                        break;
                    case 4:
                        textDTOFromJson2 = this.nullableTextDTOAdapter.fromJson(reader);
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    case 5:
                        statusDTOFromJson = this.nullableStatusDTOAdapter.fromJson(reader);
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        strFromJson2 = str2;
                        break;
                    case 6:
                        strFromJson2 = this.stringAdapter.fromJson(reader);
                        if (strFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("timestamp", "timestamp", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull4;
                        }
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        break;
                        break;
                    case 7:
                        List<IconDTO> listFromJson2 = this.listOfIconDTOAdapter.fromJson(reader);
                        if (listFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull5 = Util.unexpectedNull("statusIcons", "status_icons", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull5, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull5;
                        }
                        list = listFromJson2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                        break;
                    case 8:
                        actionDTOFromJson = this.nullableActionDTOAdapter.fromJson(reader);
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    case 9:
                        actionDTOFromJson2 = this.nullableActionDTOAdapter.fromJson(reader);
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    case 10:
                        actionDTOFromJson3 = this.nullableActionDTOAdapter.fromJson(reader);
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    case 11:
                        listFromJson = this.listOfActionDTOAdapter.fromJson(reader);
                        if (listFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull6 = Util.unexpectedNull("menuActions", "menu_actions", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull6, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull6;
                        }
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                    default:
                        list = list2;
                        strFromJson = str;
                        avatarDTOFromJson = avatarDTO;
                        iconDTOFromJson = iconDTO;
                        textDTOFromJson = textDTO;
                        textDTOFromJson2 = textDTO2;
                        statusDTOFromJson = statusDTO;
                        strFromJson2 = str2;
                        break;
                }
            } else {
                List<IconDTO> list3 = list;
                reader.endObject();
                if (str == null) {
                    JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("type", "type", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty;
                }
                if (avatarDTO == null) {
                    JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("mainIcon", "main_icon", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty2;
                }
                if (textDTO == null) {
                    JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("title", "title", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty3;
                }
                if (str2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("timestamp", "timestamp", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty4;
                }
                if (list3 == null) {
                    JsonDataException jsonDataExceptionMissingProperty5 = Util.missingProperty("statusIcons", "status_icons", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty5, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty5;
                }
                if (listFromJson != null) {
                    return new CommonPayloadDTOInbox(str, avatarDTO, iconDTO, textDTO, textDTO2, statusDTO, str2, list3, actionDTOFromJson, actionDTOFromJson2, actionDTOFromJson3, listFromJson);
                }
                JsonDataException jsonDataExceptionMissingProperty6 = Util.missingProperty("menuActions", "menu_actions", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty6, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty6;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CommonPayloadDTOInbox value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("type");
        this.stringAdapter.toJson(writer, value_.getType());
        writer.name("main_icon");
        this.avatarDTOAdapter.toJson(writer, value_.getMainIcon());
        writer.name("sub_icon");
        this.nullableIconDTOAdapter.toJson(writer, value_.getSubIcon());
        writer.name("title");
        this.textDTOAdapter.toJson(writer, value_.getTitle());
        writer.name("message");
        this.nullableTextDTOAdapter.toJson(writer, value_.getMessage());
        writer.name("status");
        this.nullableStatusDTOAdapter.toJson(writer, value_.getStatus());
        writer.name("timestamp");
        this.stringAdapter.toJson(writer, value_.getTimestamp());
        writer.name("status_icons");
        this.listOfIconDTOAdapter.toJson(writer, value_.getStatusIcons());
        writer.name("card_action");
        this.nullableActionDTOAdapter.toJson(writer, value_.getCardAction());
        writer.name("primary_action");
        this.nullableActionDTOAdapter.toJson(writer, value_.getPrimaryAction());
        writer.name("secondary_action");
        this.nullableActionDTOAdapter.toJson(writer, value_.getSecondaryAction());
        writer.name("menu_actions");
        this.listOfActionDTOAdapter.toJson(writer, value_.getMenuActions());
        writer.endObject();
    }
}
