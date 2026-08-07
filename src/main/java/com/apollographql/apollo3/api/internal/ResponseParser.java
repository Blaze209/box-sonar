package com.apollographql.apollo3.api.internal;

import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.apollographql.apollo3.api.json.MapJsonReader;
import com.apollographql.apollo3.exception.JsonDataException;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseParser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012J\f\u0010\u0014\u001a\u00020\u0010*\u00020\bH\u0002J\f\u0010\u0015\u001a\u00020\u0016*\u00020\bH\u0002J\u0014\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018*\u00020\bH\u0002J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018*\u00020\bH\u0002J\u0014\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018*\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"Lcom/apollographql/apollo3/api/internal/ResponseParser;", "", "()V", "parse", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "jsonReader", "Lcom/apollographql/apollo3/api/json/JsonReader;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "checkEof", "", "parseError", "Lcom/apollographql/apollo3/api/Error;", "payload", "", "", "readError", "readErrorLocation", "Lcom/apollographql/apollo3/api/Error$Location;", "readErrorLocations", "", "readErrors", "readPath", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ResponseParser {
    public static final ResponseParser INSTANCE = new ResponseParser();

    /* JADX INFO: compiled from: ResponseParser.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonReader.Token.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ResponseParser() {
    }

    public static /* synthetic */ ApolloResponse parse$default(ResponseParser responseParser, JsonReader jsonReader, Operation operation, CustomScalarAdapters customScalarAdapters, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return responseParser.parse(jsonReader, operation, customScalarAdapters, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    public final <D extends Operation.Data> ApolloResponse<D> parse(JsonReader jsonReader, Operation<D> operation, CustomScalarAdapters customScalarAdapters, boolean checkEof) {
        ?? r10;
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        JsonReader jsonReader2 = jsonReader;
        ApolloResponse<D> th = null;
        try {
            JsonReader jsonReader3 = jsonReader2;
            jsonReader3.beginObject();
            Operation.Data data = null;
            List<Error> errors = null;
            Map<String, ? extends Object> map = null;
            while (jsonReader3.hasNext()) {
                String strNextName = jsonReader3.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1809421292) {
                    if (iHashCode != -1294635157) {
                        if (iHashCode == 3076010 && strNextName.equals("data")) {
                            data = (Operation.Data) Adapters.m11185nullable(operation.adapter()).fromJson(jsonReader3, customScalarAdapters);
                        } else {
                            jsonReader3.skipValue();
                        }
                    } else if (strNextName.equals(BoxAnalyticsParams.CATEGORY_ERRORS)) {
                        errors = INSTANCE.readErrors(jsonReader3);
                    } else {
                        jsonReader3.skipValue();
                    }
                } else if (strNextName.equals("extensions")) {
                    Object any = JsonReaders.readAny(jsonReader3);
                    map = any instanceof Map ? (Map) any : null;
                } else {
                    jsonReader3.skipValue();
                }
            }
            jsonReader3.endObject();
            if (checkEof && jsonReader3.getPeekedToken() != JsonReader.Token.END_DOCUMENT) {
                throw new JsonDataException("Expected END_DOCUMENT but was " + jsonReader3.getPeekedToken());
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            ApolloResponse<D> apolloResponseBuild = new ApolloResponse.Builder(operation, uuidRandomUUID, data).errors(errors).extensions(map).build();
            try {
                jsonReader2.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r10 = th;
            th = apolloResponseBuild;
        } catch (Throwable th3) {
            try {
                jsonReader2.close();
                r10 = th3;
            } catch (Throwable th4) {
                ExceptionsKt.addSuppressed(th3, th4);
                r10 = th3;
            }
        }
        if (r10 == 0) {
            return th;
        }
        throw r10;
    }

    public final Error parseError(Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return readError(new MapJsonReader(payload, null, 2, null));
    }

    private final List<Error> readErrors(JsonReader jsonReader) throws IOException {
        if (jsonReader.getPeekedToken() == JsonReader.Token.NULL) {
            jsonReader.nextNull();
            return CollectionsKt.emptyList();
        }
        jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(readError(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0064  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Error readError(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = "";
        List<Error.Location> errorLocations = null;
        List<Object> path = null;
        Map map = null;
        LinkedHashMap linkedHashMap = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            switch (strNextName.hashCode()) {
                case -1809421292:
                    if (!strNextName.equals("extensions")) {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        linkedHashMap.put(strNextName, JsonReaders.readAny(jsonReader));
                    } else {
                        Object any = JsonReaders.readAny(jsonReader);
                        map = !(any instanceof Map) ? null : (Map) any;
                    }
                    break;
                case -1197189282:
                    if (!strNextName.equals("locations")) {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        linkedHashMap.put(strNextName, JsonReaders.readAny(jsonReader));
                    } else {
                        errorLocations = readErrorLocations(jsonReader);
                    }
                    break;
                case 3433509:
                    if (!strNextName.equals("path")) {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        linkedHashMap.put(strNextName, JsonReaders.readAny(jsonReader));
                    } else {
                        path = readPath(jsonReader);
                    }
                    break;
                case 954925063:
                    if (!strNextName.equals("message")) {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        linkedHashMap.put(strNextName, JsonReaders.readAny(jsonReader));
                    } else {
                        String strNextString = jsonReader.nextString();
                        str = strNextString != null ? strNextString : "";
                    }
                    break;
                default:
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                    linkedHashMap.put(strNextName, JsonReaders.readAny(jsonReader));
                    break;
            }
        }
        jsonReader.endObject();
        return new Error(str, errorLocations, path, map, linkedHashMap);
    }

    private final List<Object> readPath(JsonReader jsonReader) throws IOException {
        if (jsonReader.getPeekedToken() == JsonReader.Token.NULL) {
            return (List) jsonReader.nextNull();
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[jsonReader.getPeekedToken().ordinal()];
            if (i == 1 || i == 2) {
                arrayList.add(Integer.valueOf(jsonReader.nextInt()));
            } else {
                String strNextString = jsonReader.nextString();
                Intrinsics.checkNotNull(strNextString);
                arrayList.add(strNextString);
            }
        }
        jsonReader.endArray();
        return arrayList;
    }

    private final List<Error.Location> readErrorLocations(JsonReader jsonReader) throws IOException {
        if (jsonReader.getPeekedToken() == JsonReader.Token.NULL) {
            return (List) jsonReader.nextNull();
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(readErrorLocation(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    private final Error.Location readErrorLocation(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        int iNextInt = -1;
        int iNextInt2 = -1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (Intrinsics.areEqual(strNextName, "line")) {
                iNextInt = jsonReader.nextInt();
            } else if (Intrinsics.areEqual(strNextName, "column")) {
                iNextInt2 = jsonReader.nextInt();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new Error.Location(iNextInt, iNextInt2);
    }
}
