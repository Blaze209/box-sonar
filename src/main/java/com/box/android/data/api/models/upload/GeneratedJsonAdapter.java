package com.box.android.data.api.models.upload;

import com.box.androidsdk.content.models.BoxUploadSession;
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
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.upload.SessionRunningInfoJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: SessionRunningInfoJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u00110\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/api/models/upload/SessionRunningInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/upload/SessionRunningInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableUploadSessionDTOAdapter", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "mutableSetOfLongAdapter", "", "", "mutableSetOfUploadFileChunkDTOAdapter", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "mutableMapOfLongIntAdapter", "", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<SessionRunningInfo> {
    private volatile Constructor<SessionRunningInfo> constructorRef;
    private final JsonAdapter<Map<Long, Integer>> mutableMapOfLongIntAdapter;
    private final JsonAdapter<Set<Long>> mutableSetOfLongAdapter;
    private final JsonAdapter<Set<UploadFileChunkDTO>> mutableSetOfUploadFileChunkDTOAdapter;
    private final JsonAdapter<UploadSessionDTO> nullableUploadSessionDTOAdapter;
    private final JsonReader.Options options;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of(BoxUploadSession.FIELD_TYPE, "running_requests", "chunks_to_upload", "failed_chunks", "succeeded_chunks", "request_attempts");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<UploadSessionDTO> jsonAdapterAdapter = moshi.adapter(UploadSessionDTO.class, SetsKt.emptySet(), "uploadSession");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.nullableUploadSessionDTOAdapter = jsonAdapterAdapter;
        JsonAdapter<Set<Long>> jsonAdapterAdapter2 = moshi.adapter(Types.newParameterizedType(Set.class, Long.class), SetsKt.emptySet(), "runningRequests");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.mutableSetOfLongAdapter = jsonAdapterAdapter2;
        JsonAdapter<Set<UploadFileChunkDTO>> jsonAdapterAdapter3 = moshi.adapter(Types.newParameterizedType(Set.class, UploadFileChunkDTO.class), SetsKt.emptySet(), "succeededChunks");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.mutableSetOfUploadFileChunkDTOAdapter = jsonAdapterAdapter3;
        JsonAdapter<Map<Long, Integer>> jsonAdapterAdapter4 = moshi.adapter(Types.newParameterizedType(Map.class, Long.class, Integer.class), SetsKt.emptySet(), "requestAttempts");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.mutableMapOfLongIntAdapter = jsonAdapterAdapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("GeneratedJsonAdapter(SessionRunningInfo)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SessionRunningInfo fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        UploadSessionDTO uploadSessionDTOFromJson = null;
        Set<Long> setFromJson = null;
        Set<Long> setFromJson2 = null;
        Set<Long> setFromJson3 = null;
        Set<UploadFileChunkDTO> setFromJson4 = null;
        Map<Long, Integer> mapFromJson = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    uploadSessionDTOFromJson = this.nullableUploadSessionDTOAdapter.fromJson(reader);
                    i &= -2;
                    break;
                case 1:
                    setFromJson = this.mutableSetOfLongAdapter.fromJson(reader);
                    if (setFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("runningRequests", "running_requests", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull;
                    }
                    i &= -3;
                    break;
                    break;
                case 2:
                    setFromJson2 = this.mutableSetOfLongAdapter.fromJson(reader);
                    if (setFromJson2 == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("chunksToUpload", "chunks_to_upload", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull2;
                    }
                    i &= -5;
                    break;
                    break;
                case 3:
                    setFromJson3 = this.mutableSetOfLongAdapter.fromJson(reader);
                    if (setFromJson3 == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("failedChunks", "failed_chunks", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull3;
                    }
                    i &= -9;
                    break;
                    break;
                case 4:
                    setFromJson4 = this.mutableSetOfUploadFileChunkDTOAdapter.fromJson(reader);
                    if (setFromJson4 == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("succeededChunks", "succeeded_chunks", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull4;
                    }
                    i &= -17;
                    break;
                    break;
                case 5:
                    mapFromJson = this.mutableMapOfLongIntAdapter.fromJson(reader);
                    if (mapFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull5 = Util.unexpectedNull("requestAttempts", "request_attempts", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull5, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull5;
                    }
                    i &= -33;
                    break;
                    break;
            }
        }
        reader.endObject();
        if (i == -64) {
            Set<Long> set = setFromJson;
            Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.Long>");
            Set<Long> set2 = setFromJson2;
            Set setAsMutableSet = TypeIntrinsics.asMutableSet(set);
            Intrinsics.checkNotNull(set2, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.Long>");
            Set<Long> set3 = setFromJson3;
            Set setAsMutableSet2 = TypeIntrinsics.asMutableSet(set2);
            Intrinsics.checkNotNull(set3, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.Long>");
            Set<UploadFileChunkDTO> set4 = setFromJson4;
            Set setAsMutableSet3 = TypeIntrinsics.asMutableSet(set3);
            Intrinsics.checkNotNull(set4, "null cannot be cast to non-null type kotlin.collections.MutableSet<com.box.android.data.api.models.upload.UploadFileChunkDTO>");
            Map<Long, Integer> map = mapFromJson;
            Set setAsMutableSet4 = TypeIntrinsics.asMutableSet(set4);
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Long, kotlin.Int>");
            return new SessionRunningInfo(uploadSessionDTOFromJson, setAsMutableSet, setAsMutableSet2, setAsMutableSet3, setAsMutableSet4, TypeIntrinsics.asMutableMap(map));
        }
        Set<Long> set5 = setFromJson;
        Set<Long> set6 = setFromJson2;
        Set<Long> set7 = setFromJson3;
        Set<UploadFileChunkDTO> set8 = setFromJson4;
        Map<Long, Integer> map2 = mapFromJson;
        UploadSessionDTO uploadSessionDTO = uploadSessionDTOFromJson;
        Constructor<SessionRunningInfo> declaredConstructor = this.constructorRef;
        if (declaredConstructor == null) {
            declaredConstructor = SessionRunningInfo.class.getDeclaredConstructor(UploadSessionDTO.class, Set.class, Set.class, Set.class, Set.class, Map.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = declaredConstructor;
            Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
        }
        SessionRunningInfo sessionRunningInfoNewInstance = declaredConstructor.newInstance(uploadSessionDTO, set5, set6, set7, set8, map2, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(sessionRunningInfoNewInstance, "newInstance(...)");
        return sessionRunningInfoNewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SessionRunningInfo value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name(BoxUploadSession.FIELD_TYPE);
        this.nullableUploadSessionDTOAdapter.toJson(writer, value_.getUploadSession());
        writer.name("running_requests");
        this.mutableSetOfLongAdapter.toJson(writer, value_.getRunningRequests());
        writer.name("chunks_to_upload");
        this.mutableSetOfLongAdapter.toJson(writer, value_.getChunksToUpload());
        writer.name("failed_chunks");
        this.mutableSetOfLongAdapter.toJson(writer, value_.getFailedChunks());
        writer.name("succeeded_chunks");
        this.mutableSetOfUploadFileChunkDTOAdapter.toJson(writer, value_.getSucceededChunks());
        writer.name("request_attempts");
        this.mutableMapOfLongIntAdapter.toJson(writer, value_.getRequestAttempts());
        writer.endObject();
    }
}
