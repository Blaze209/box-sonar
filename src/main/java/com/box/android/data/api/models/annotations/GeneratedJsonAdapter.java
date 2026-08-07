package com.box.android.data.api.models.annotations;

import com.box.android.data.api.models.UserMiniDTO;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.annotations.AnnotationDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: AnnotationDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010 \u001a\u00020\nH\u0016J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/data/api/models/annotations/AnnotationDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "dateAdapter", "Ljava/util/Date;", "userMiniDTOAdapter", "Lcom/box/android/data/api/models/UserMiniDTO;", "listOfCommentDTOAdapter", "", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "intAdapter", "", "descriptionDTOAdapter", "Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "annotationFileVersionDTOAdapter", "Lcom/box/android/data/api/models/annotations/AnnotationFileVersionDTO;", "fileActivityPermissionsDTOAdapter", "Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "statusAdapter", "Lcom/box/android/data/api/models/annotations/Status;", "targetDTOAdapter", "Lcom/box/android/data/api/models/annotations/TargetDTO;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<AnnotationDTO> {
    private final JsonAdapter<AnnotationFileVersionDTO> annotationFileVersionDTOAdapter;
    private volatile Constructor<AnnotationDTO> constructorRef;
    private final JsonAdapter<Date> dateAdapter;
    private final JsonAdapter<DescriptionDTO> descriptionDTOAdapter;
    private final JsonAdapter<FileActivityPermissionsDTO> fileActivityPermissionsDTOAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<CommentDTO>> listOfCommentDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<Status> statusAdapter;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<TargetDTO> targetDTOAdapter;
    private final JsonAdapter<UserMiniDTO> userMiniDTOAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("id", "type", "created_at", "created_by", "replies", "total_reply_count", "description", "file_version", "modified_at", "modified_by", "permissions", "status", "target");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<Date> jsonAdapterAdapter2 = moshi.adapter(Date.class, SetsKt.emptySet(), "createdAt");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.dateAdapter = jsonAdapterAdapter2;
        JsonAdapter<UserMiniDTO> jsonAdapterAdapter3 = moshi.adapter(UserMiniDTO.class, SetsKt.emptySet(), "createdBy");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.userMiniDTOAdapter = jsonAdapterAdapter3;
        JsonAdapter<List<CommentDTO>> jsonAdapterAdapter4 = moshi.adapter(Types.newParameterizedType(List.class, CommentDTO.class), SetsKt.emptySet(), "replies");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.listOfCommentDTOAdapter = jsonAdapterAdapter4;
        JsonAdapter<Integer> jsonAdapterAdapter5 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "totalReplies");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.intAdapter = jsonAdapterAdapter5;
        JsonAdapter<DescriptionDTO> jsonAdapterAdapter6 = moshi.adapter(DescriptionDTO.class, SetsKt.emptySet(), "description");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter6, "adapter(...)");
        this.descriptionDTOAdapter = jsonAdapterAdapter6;
        JsonAdapter<AnnotationFileVersionDTO> jsonAdapterAdapter7 = moshi.adapter(AnnotationFileVersionDTO.class, SetsKt.emptySet(), "fileVersion");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter7, "adapter(...)");
        this.annotationFileVersionDTOAdapter = jsonAdapterAdapter7;
        JsonAdapter<FileActivityPermissionsDTO> jsonAdapterAdapter8 = moshi.adapter(FileActivityPermissionsDTO.class, SetsKt.emptySet(), "permissions");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter8, "adapter(...)");
        this.fileActivityPermissionsDTOAdapter = jsonAdapterAdapter8;
        JsonAdapter<Status> jsonAdapterAdapter9 = moshi.adapter(Status.class, SetsKt.emptySet(), "status");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter9, "adapter(...)");
        this.statusAdapter = jsonAdapterAdapter9;
        JsonAdapter<TargetDTO> jsonAdapterAdapter10 = moshi.adapter(TargetDTO.class, SetsKt.emptySet(), "target");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter10, "adapter(...)");
        this.targetDTOAdapter = jsonAdapterAdapter10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(AnnotationDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public AnnotationDTO fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        char c = 0;
        reader.beginObject();
        int i = -1;
        Integer numFromJson = 0;
        String str = null;
        DescriptionDTO descriptionDTOFromJson = null;
        String strFromJson = null;
        Date dateFromJson = null;
        UserMiniDTO userMiniDTOFromJson = null;
        List<CommentDTO> listFromJson = null;
        TargetDTO targetDTOFromJson = null;
        AnnotationFileVersionDTO annotationFileVersionDTOFromJson = null;
        Date dateFromJson2 = null;
        UserMiniDTO userMiniDTOFromJson2 = null;
        FileActivityPermissionsDTO fileActivityPermissionsDTOFromJson = null;
        Status statusFromJson = null;
        while (true) {
            c = c;
            String str2 = str;
            numFromJson = numFromJson;
            String str3 = strFromJson;
            Date date = dateFromJson;
            DescriptionDTO descriptionDTO = descriptionDTOFromJson;
            int i2 = i;
            if (reader.hasNext()) {
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 0:
                        String strFromJson2 = this.stringAdapter.fromJson(reader);
                        if (strFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("id", "id", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull;
                        }
                        str = strFromJson2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                        break;
                    case 1:
                        strFromJson = this.stringAdapter.fromJson(reader);
                        if (strFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("type", "type", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull2;
                        }
                        c = c;
                        str = str2;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                        break;
                    case 2:
                        dateFromJson = this.dateAdapter.fromJson(reader);
                        if (dateFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("createdAt", "created_at", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull3;
                        }
                        c = c;
                        str = str2;
                        numFromJson = numFromJson;
                        strFromJson = str3;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                        break;
                    case 3:
                        userMiniDTOFromJson = this.userMiniDTOAdapter.fromJson(reader);
                        if (userMiniDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("createdBy", "created_by", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull4;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 4:
                        listFromJson = this.listOfCommentDTOAdapter.fromJson(reader);
                        if (listFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull5 = Util.unexpectedNull("replies", "replies", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull5, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull5;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 5:
                        numFromJson = this.intAdapter.fromJson(reader);
                        if (numFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull6 = Util.unexpectedNull("totalReplies", "total_reply_count", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull6, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull6;
                        }
                        i = i2 & (-33);
                        c = c;
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        break;
                        break;
                    case 6:
                        descriptionDTOFromJson = this.descriptionDTOAdapter.fromJson(reader);
                        if (descriptionDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull7 = Util.unexpectedNull("description", "description", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull7, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull7;
                        }
                        i = i2 & (-65);
                        c = c;
                        str = str2;
                        numFromJson = numFromJson;
                        strFromJson = str3;
                        dateFromJson = date;
                        break;
                        break;
                    case 7:
                        annotationFileVersionDTOFromJson = this.annotationFileVersionDTOAdapter.fromJson(reader);
                        if (annotationFileVersionDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull8 = Util.unexpectedNull("fileVersion", "file_version", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull8, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull8;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 8:
                        dateFromJson2 = this.dateAdapter.fromJson(reader);
                        if (dateFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull9 = Util.unexpectedNull("modifiedAt", "modified_at", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull9, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull9;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 9:
                        userMiniDTOFromJson2 = this.userMiniDTOAdapter.fromJson(reader);
                        if (userMiniDTOFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull10 = Util.unexpectedNull("modifiedBy", "modified_by", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull10, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull10;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 10:
                        fileActivityPermissionsDTOFromJson = this.fileActivityPermissionsDTOAdapter.fromJson(reader);
                        if (fileActivityPermissionsDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull11 = Util.unexpectedNull("permissions", "permissions", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull11, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull11;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 11:
                        statusFromJson = this.statusAdapter.fromJson(reader);
                        if (statusFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull12 = Util.unexpectedNull("status", "status", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull12, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull12;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    case 12:
                        targetDTOFromJson = this.targetDTOAdapter.fromJson(reader);
                        if (targetDTOFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull13 = Util.unexpectedNull("target", "target", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull13, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull13;
                        }
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                    default:
                        str = str2;
                        strFromJson = str3;
                        dateFromJson = date;
                        descriptionDTOFromJson = descriptionDTO;
                        i = i2;
                        break;
                }
            } else {
                reader.endObject();
                if (i2 == -97) {
                    if (str2 == null) {
                        JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("id", "id", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty;
                    }
                    if (str3 == null) {
                        JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("type", "type", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty2;
                    }
                    if (date == null) {
                        JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("createdAt", "created_at", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty3;
                    }
                    if (userMiniDTOFromJson == null) {
                        JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("createdBy", "created_by", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty4;
                    }
                    if (listFromJson == null) {
                        JsonDataException jsonDataExceptionMissingProperty5 = Util.missingProperty("replies", "replies", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty5, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty5;
                    }
                    TargetDTO targetDTO = targetDTOFromJson;
                    int iIntValue = numFromJson.intValue();
                    Intrinsics.checkNotNull(descriptionDTO, "null cannot be cast to non-null type com.box.android.data.api.models.annotations.DescriptionDTO");
                    if (annotationFileVersionDTOFromJson == null) {
                        JsonDataException jsonDataExceptionMissingProperty6 = Util.missingProperty("fileVersion", "file_version", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty6, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty6;
                    }
                    if (dateFromJson2 == null) {
                        JsonDataException jsonDataExceptionMissingProperty7 = Util.missingProperty("modifiedAt", "modified_at", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty7, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty7;
                    }
                    if (userMiniDTOFromJson2 == null) {
                        JsonDataException jsonDataExceptionMissingProperty8 = Util.missingProperty("modifiedBy", "modified_by", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty8, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty8;
                    }
                    if (fileActivityPermissionsDTOFromJson == null) {
                        JsonDataException jsonDataExceptionMissingProperty9 = Util.missingProperty("permissions", "permissions", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty9, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty9;
                    }
                    if (statusFromJson == null) {
                        JsonDataException jsonDataExceptionMissingProperty10 = Util.missingProperty("status", "status", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty10, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty10;
                    }
                    if (targetDTO != null) {
                        return new AnnotationDTO(str2, str3, date, userMiniDTOFromJson, listFromJson, iIntValue, descriptionDTO, annotationFileVersionDTOFromJson, dateFromJson2, userMiniDTOFromJson2, fileActivityPermissionsDTOFromJson, statusFromJson, targetDTO);
                    }
                    JsonDataException jsonDataExceptionMissingProperty11 = Util.missingProperty("target", "target", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty11, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty11;
                }
                TargetDTO targetDTO2 = targetDTOFromJson;
                Constructor<AnnotationDTO> declaredConstructor = this.constructorRef;
                if (declaredConstructor == null) {
                    Class[] clsArr = new Class[15];
                    clsArr[c] = String.class;
                    clsArr[1] = String.class;
                    clsArr[2] = Date.class;
                    clsArr[3] = UserMiniDTO.class;
                    clsArr[4] = List.class;
                    clsArr[5] = Integer.TYPE;
                    clsArr[6] = DescriptionDTO.class;
                    clsArr[7] = AnnotationFileVersionDTO.class;
                    clsArr[8] = Date.class;
                    clsArr[9] = UserMiniDTO.class;
                    clsArr[10] = FileActivityPermissionsDTO.class;
                    clsArr[11] = Status.class;
                    clsArr[12] = TargetDTO.class;
                    clsArr[13] = Integer.TYPE;
                    clsArr[14] = Util.DEFAULT_CONSTRUCTOR_MARKER;
                    declaredConstructor = AnnotationDTO.class.getDeclaredConstructor(clsArr);
                    this.constructorRef = declaredConstructor;
                    Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
                }
                Constructor<AnnotationDTO> constructor = declaredConstructor;
                if (str2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty12 = Util.missingProperty("id", "id", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty12, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty12;
                }
                if (str3 == null) {
                    JsonDataException jsonDataExceptionMissingProperty13 = Util.missingProperty("type", "type", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty13, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty13;
                }
                if (date == null) {
                    JsonDataException jsonDataExceptionMissingProperty14 = Util.missingProperty("createdAt", "created_at", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty14, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty14;
                }
                if (userMiniDTOFromJson == null) {
                    JsonDataException jsonDataExceptionMissingProperty15 = Util.missingProperty("createdBy", "created_by", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty15, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty15;
                }
                if (listFromJson == null) {
                    JsonDataException jsonDataExceptionMissingProperty16 = Util.missingProperty("replies", "replies", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty16, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty16;
                }
                if (annotationFileVersionDTOFromJson == null) {
                    JsonDataException jsonDataExceptionMissingProperty17 = Util.missingProperty("fileVersion", "file_version", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty17, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty17;
                }
                if (dateFromJson2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty18 = Util.missingProperty("modifiedAt", "modified_at", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty18, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty18;
                }
                if (userMiniDTOFromJson2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty19 = Util.missingProperty("modifiedBy", "modified_by", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty19, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty19;
                }
                if (fileActivityPermissionsDTOFromJson == null) {
                    JsonDataException jsonDataExceptionMissingProperty20 = Util.missingProperty("permissions", "permissions", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty20, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty20;
                }
                if (statusFromJson == null) {
                    JsonDataException jsonDataExceptionMissingProperty21 = Util.missingProperty("status", "status", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty21, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty21;
                }
                if (targetDTO2 == null) {
                    JsonDataException jsonDataExceptionMissingProperty22 = Util.missingProperty("target", "target", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty22, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty22;
                }
                AnnotationDTO annotationDTONewInstance = constructor.newInstance(str2, str3, date, userMiniDTOFromJson, listFromJson, numFromJson, descriptionDTO, annotationFileVersionDTOFromJson, dateFromJson2, userMiniDTOFromJson2, fileActivityPermissionsDTOFromJson, statusFromJson, targetDTO2, Integer.valueOf(i2), null);
                Intrinsics.checkNotNullExpressionValue(annotationDTONewInstance, "newInstance(...)");
                return annotationDTONewInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, AnnotationDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, value_.getId());
        writer.name("type");
        this.stringAdapter.toJson(writer, value_.getType());
        writer.name("created_at");
        this.dateAdapter.toJson(writer, value_.getCreatedAt());
        writer.name("created_by");
        this.userMiniDTOAdapter.toJson(writer, value_.getCreatedBy());
        writer.name("replies");
        this.listOfCommentDTOAdapter.toJson(writer, value_.getReplies());
        writer.name("total_reply_count");
        this.intAdapter.toJson(writer, Integer.valueOf(value_.getTotalReplies()));
        writer.name("description");
        this.descriptionDTOAdapter.toJson(writer, value_.getDescription());
        writer.name("file_version");
        this.annotationFileVersionDTOAdapter.toJson(writer, value_.getFileVersion());
        writer.name("modified_at");
        this.dateAdapter.toJson(writer, value_.getModifiedAt());
        writer.name("modified_by");
        this.userMiniDTOAdapter.toJson(writer, value_.getModifiedBy());
        writer.name("permissions");
        this.fileActivityPermissionsDTOAdapter.toJson(writer, value_.getPermissions());
        writer.name("status");
        this.statusAdapter.toJson(writer, value_.getStatus());
        writer.name("target");
        this.targetDTOAdapter.toJson(writer, value_.getTarget());
        writer.endObject();
    }
}
