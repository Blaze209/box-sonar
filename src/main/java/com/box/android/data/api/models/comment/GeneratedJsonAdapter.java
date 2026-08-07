package com.box.android.data.api.models.comment;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.androidsdk.content.models.BoxComment;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.comment.CommentV2ResponseDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: CommentV2ResponseDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/api/models/comment/CommentV2ResponseDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/comment/CommentV2ResponseDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "nullableStringAdapter", "dateAdapter", "Ljava/util/Date;", "userMiniDTOAdapter", "Lcom/box/android/data/api/models/UserMiniDTO;", "commentPermissionsDTOAdapter", "Lcom/box/android/data/api/models/comment/CommentPermissionsDTO;", "nullableItemIdDTOAdapter", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<CommentV2ResponseDTO> {
    private final JsonAdapter<CommentPermissionsDTO> commentPermissionsDTOAdapter;
    private volatile Constructor<CommentV2ResponseDTO> constructorRef;
    private final JsonAdapter<Date> dateAdapter;
    private final JsonAdapter<ItemIdDTO> nullableItemIdDTOAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<UserMiniDTO> userMiniDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("id", "type", "message", BoxComment.FIELD_TAGGED_MESSAGE, "created_at", "created_by", "modified_at", "permissions", "item");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<String> jsonAdapterAdapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "taggedMessage");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.nullableStringAdapter = jsonAdapterAdapter2;
        JsonAdapter<Date> jsonAdapterAdapter3 = moshi.adapter(Date.class, SetsKt.emptySet(), "createdAt");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.dateAdapter = jsonAdapterAdapter3;
        JsonAdapter<UserMiniDTO> jsonAdapterAdapter4 = moshi.adapter(UserMiniDTO.class, SetsKt.emptySet(), "createdBy");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.userMiniDTOAdapter = jsonAdapterAdapter4;
        JsonAdapter<CommentPermissionsDTO> jsonAdapterAdapter5 = moshi.adapter(CommentPermissionsDTO.class, SetsKt.emptySet(), "permissions");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.commentPermissionsDTOAdapter = jsonAdapterAdapter5;
        JsonAdapter<ItemIdDTO> jsonAdapterAdapter6 = moshi.adapter(ItemIdDTO.class, SetsKt.emptySet(), "item");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter6, "adapter(...)");
        this.nullableItemIdDTOAdapter = jsonAdapterAdapter6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(CommentV2ResponseDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public CommentV2ResponseDTO fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        String strFromJson = null;
        String strFromJson2 = null;
        String strFromJson3 = null;
        String strFromJson4 = null;
        Date dateFromJson = null;
        UserMiniDTO userMiniDTOFromJson = null;
        Date date = null;
        CommentPermissionsDTO commentPermissionsDTOFromJson = null;
        ItemIdDTO itemIdDTOFromJson = null;
        while (true) {
            String str = strFromJson;
            String str2 = strFromJson2;
            String str3 = strFromJson3;
            String str4 = strFromJson4;
            Date date2 = dateFromJson;
            UserMiniDTO userMiniDTO = userMiniDTOFromJson;
            if (reader.hasNext()) {
                Date date3 = date;
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                    case 0:
                        strFromJson = this.stringAdapter.fromJson(reader);
                        if (strFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("id", "id", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull;
                        }
                        date = date3;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                        break;
                    case 1:
                        strFromJson2 = this.stringAdapter.fromJson(reader);
                        if (strFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("type", "type", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull2;
                        }
                        date = date3;
                        strFromJson = str;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                        break;
                    case 2:
                        strFromJson3 = this.stringAdapter.fromJson(reader);
                        if (strFromJson3 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("message", "message", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull3;
                        }
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                        break;
                    case 3:
                        strFromJson4 = this.nullableStringAdapter.fromJson(reader);
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                    case 4:
                        dateFromJson = this.dateAdapter.fromJson(reader);
                        if (dateFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("createdAt", "created_at", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull4;
                        }
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                        break;
                    case 5:
                        userMiniDTOFromJson = this.userMiniDTOAdapter.fromJson(reader);
                        if (userMiniDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull5 = Util.unexpectedNull("createdBy", "created_by", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull5, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull5;
                        }
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        break;
                        break;
                    case 6:
                        Date dateFromJson2 = this.dateAdapter.fromJson(reader);
                        if (dateFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull6 = Util.unexpectedNull("modifiedAt", "modified_at", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull6, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull6;
                        }
                        date = dateFromJson2;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                        break;
                    case 7:
                        commentPermissionsDTOFromJson = this.commentPermissionsDTOAdapter.fromJson(reader);
                        if (commentPermissionsDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull7 = Util.unexpectedNull("permissions", "permissions", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull7, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull7;
                        }
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                    case 8:
                        itemIdDTOFromJson = this.nullableItemIdDTOAdapter.fromJson(reader);
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        i = -257;
                        break;
                    default:
                        date = date3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        strFromJson4 = str4;
                        dateFromJson = date2;
                        userMiniDTOFromJson = userMiniDTO;
                        break;
                }
            } else {
                Date date4 = date;
                reader.endObject();
                if (i == -257) {
                    if (str == null) {
                        JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("id", "id", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty;
                    }
                    if (str2 == null) {
                        JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("type", "type", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty2;
                    }
                    if (str3 == null) {
                        JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("message", "message", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty3;
                    }
                    if (date2 == null) {
                        JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("createdAt", "created_at", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty4;
                    }
                    if (userMiniDTO == null) {
                        JsonDataException jsonDataExceptionMissingProperty5 = Util.missingProperty("createdBy", "created_by", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty5, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty5;
                    }
                    if (date4 == null) {
                        JsonDataException jsonDataExceptionMissingProperty6 = Util.missingProperty("modifiedAt", "modified_at", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty6, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty6;
                    }
                    if (commentPermissionsDTOFromJson != null) {
                        return new CommentV2ResponseDTO(str, str2, str3, str4, date2, userMiniDTO, date4, commentPermissionsDTOFromJson, itemIdDTOFromJson);
                    }
                    JsonDataException jsonDataExceptionMissingProperty7 = Util.missingProperty("permissions", "permissions", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty7, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty7;
                }
                int i2 = i;
                Constructor<CommentV2ResponseDTO> declaredConstructor = this.constructorRef;
                if (declaredConstructor == null) {
                    declaredConstructor = CommentV2ResponseDTO.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, Date.class, UserMiniDTO.class, Date.class, CommentPermissionsDTO.class, ItemIdDTO.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = declaredConstructor;
                    Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
                }
                if (str == null) {
                    JsonDataException jsonDataExceptionMissingProperty8 = Util.missingProperty("id", "id", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty8, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty8;
                }
                if (str2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty9 = Util.missingProperty("type", "type", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty9, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty9;
                }
                if (str3 == null) {
                    JsonDataException jsonDataExceptionMissingProperty10 = Util.missingProperty("message", "message", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty10, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty10;
                }
                if (date2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty11 = Util.missingProperty("createdAt", "created_at", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty11, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty11;
                }
                if (userMiniDTO == null) {
                    JsonDataException jsonDataExceptionMissingProperty12 = Util.missingProperty("createdBy", "created_by", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty12, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty12;
                }
                if (date4 == null) {
                    JsonDataException jsonDataExceptionMissingProperty13 = Util.missingProperty("modifiedAt", "modified_at", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty13, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty13;
                }
                if (commentPermissionsDTOFromJson == 0) {
                    JsonDataException jsonDataExceptionMissingProperty14 = Util.missingProperty("permissions", "permissions", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty14, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty14;
                }
                CommentV2ResponseDTO commentV2ResponseDTONewInstance = declaredConstructor.newInstance(str, str2, str3, str4, date2, userMiniDTO, date4, commentPermissionsDTOFromJson, itemIdDTOFromJson, Integer.valueOf(i2), null);
                Intrinsics.checkNotNullExpressionValue(commentV2ResponseDTONewInstance, "newInstance(...)");
                return commentV2ResponseDTONewInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, CommentV2ResponseDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, value_.getId());
        writer.name("type");
        this.stringAdapter.toJson(writer, value_.getType());
        writer.name("message");
        this.stringAdapter.toJson(writer, value_.getMessage());
        writer.name(BoxComment.FIELD_TAGGED_MESSAGE);
        this.nullableStringAdapter.toJson(writer, value_.getTaggedMessage());
        writer.name("created_at");
        this.dateAdapter.toJson(writer, value_.getCreatedAt());
        writer.name("created_by");
        this.userMiniDTOAdapter.toJson(writer, value_.getCreatedBy());
        writer.name("modified_at");
        this.dateAdapter.toJson(writer, value_.getModifiedAt());
        writer.name("permissions");
        this.commentPermissionsDTOAdapter.toJson(writer, value_.getPermissions());
        writer.name("item");
        this.nullableItemIdDTOAdapter.toJson(writer, value_.getItem());
        writer.endObject();
    }
}
