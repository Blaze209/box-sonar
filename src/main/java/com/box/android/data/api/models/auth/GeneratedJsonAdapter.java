package com.box.android.data.api.models.auth;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.auth.AccessTokenDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: AccessTokenDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/auth/AccessTokenDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "longAdapter", "", "nullableStringAdapter", "nullableListOfScopeDTOAdapter", "", "Lcom/box/android/data/api/models/auth/ScopeDTO;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<AccessTokenDTO> {
    private volatile Constructor<AccessTokenDTO> constructorRef;
    private final JsonAdapter<Long> longAdapter;
    private final JsonAdapter<List<ScopeDTO>> nullableListOfScopeDTOAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("access_token", "expires_in", "issued_token_type", "refresh_token", "restricted_to", "token_type");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "accessToken");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<Long> jsonAdapterAdapter2 = moshi.adapter(Long.TYPE, SetsKt.emptySet(), "expiresIn");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.longAdapter = jsonAdapterAdapter2;
        JsonAdapter<String> jsonAdapterAdapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "issuedTokenType");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.nullableStringAdapter = jsonAdapterAdapter3;
        JsonAdapter<List<ScopeDTO>> jsonAdapterAdapter4 = moshi.adapter(Types.newParameterizedType(List.class, ScopeDTO.class), SetsKt.emptySet(), "restrictedTo");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.nullableListOfScopeDTOAdapter = jsonAdapterAdapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(AccessTokenDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public AccessTokenDTO fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Long lFromJson = null;
        int i = -1;
        String strFromJson = null;
        String strFromJson2 = null;
        String strFromJson3 = null;
        List<ScopeDTO> listFromJson = null;
        String strFromJson4 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    strFromJson = this.stringAdapter.fromJson(reader);
                    if (strFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("accessToken", "access_token", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull;
                    }
                    break;
                    break;
                case 1:
                    lFromJson = this.longAdapter.fromJson(reader);
                    if (lFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("expiresIn", "expires_in", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull2;
                    }
                    break;
                    break;
                case 2:
                    strFromJson2 = this.nullableStringAdapter.fromJson(reader);
                    break;
                case 3:
                    strFromJson3 = this.nullableStringAdapter.fromJson(reader);
                    break;
                case 4:
                    listFromJson = this.nullableListOfScopeDTOAdapter.fromJson(reader);
                    break;
                case 5:
                    strFromJson4 = this.stringAdapter.fromJson(reader);
                    if (strFromJson4 == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("tokenType", "token_type", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull3;
                    }
                    i = -33;
                    break;
                    break;
            }
        }
        reader.endObject();
        if (i == -33) {
            String str = strFromJson;
            if (str == null) {
                JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("accessToken", "access_token", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty;
            }
            if (lFromJson != null) {
                List<ScopeDTO> list = listFromJson;
                String str2 = strFromJson2;
                long jLongValue = lFromJson.longValue();
                Intrinsics.checkNotNull(strFromJson4, "null cannot be cast to non-null type kotlin.String");
                return new AccessTokenDTO(str, jLongValue, str2, strFromJson3, list, strFromJson4);
            }
            JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("expiresIn", "expires_in", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty2;
        }
        List<ScopeDTO> list2 = listFromJson;
        String str3 = strFromJson2;
        String str4 = strFromJson;
        Constructor<AccessTokenDTO> declaredConstructor = this.constructorRef;
        if (declaredConstructor == null) {
            declaredConstructor = AccessTokenDTO.class.getDeclaredConstructor(String.class, Long.TYPE, String.class, String.class, List.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = declaredConstructor;
            Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
        }
        Constructor<AccessTokenDTO> constructor = declaredConstructor;
        if (str4 == null) {
            JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("accessToken", "access_token", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty3;
        }
        if (lFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("expiresIn", "expires_in", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty4;
        }
        AccessTokenDTO accessTokenDTONewInstance = constructor.newInstance(str4, Long.valueOf(lFromJson.longValue()), str3, strFromJson3, list2, strFromJson4, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(accessTokenDTONewInstance, "newInstance(...)");
        return accessTokenDTONewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, AccessTokenDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("access_token");
        this.stringAdapter.toJson(writer, value_.getAccessToken());
        writer.name("expires_in");
        this.longAdapter.toJson(writer, Long.valueOf(value_.getExpiresIn()));
        writer.name("issued_token_type");
        this.nullableStringAdapter.toJson(writer, value_.getIssuedTokenType());
        writer.name("refresh_token");
        this.nullableStringAdapter.toJson(writer, value_.getRefreshToken());
        writer.name("restricted_to");
        this.nullableListOfScopeDTOAdapter.toJson(writer, value_.getRestrictedTo());
        writer.name("token_type");
        this.stringAdapter.toJson(writer, value_.getTokenType());
        writer.endObject();
    }
}
