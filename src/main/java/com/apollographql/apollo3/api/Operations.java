package com.apollographql.apollo3.api;

import com.apollographql.apollo3.api.internal.ResponseParser;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.apollographql.apollo3.api.json.JsonWriter;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: Operations.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a;\u0010\t\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u000b\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a:\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¨\u0006\u0015"}, d2 = {"composeJsonRequest", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/Operation;", "jsonWriter", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "composeJsonResponse", "data", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/json/JsonWriter;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)V", "parseJsonResponse", "Lcom/apollographql/apollo3/api/ApolloResponse;", "jsonReader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "json", "", "parseJsonResponseInternal", "checkEof", "", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class Operations {
    public static final <D extends Operation.Data> void composeJsonRequest(Operation<D> operation, JsonWriter jsonWriter) throws IOException {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        composeJsonRequest$default(operation, jsonWriter, null, 2, null);
    }

    public static final <D extends Operation.Data> void composeJsonResponse(Operation<D> operation, JsonWriter jsonWriter, D data) throws Throwable {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(data, "data");
        composeJsonResponse$default(operation, jsonWriter, data, null, 4, null);
    }

    public static final <D extends Operation.Data> ApolloResponse<D> parseJsonResponse(Operation<D> operation, JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        return parseJsonResponse$default(operation, jsonReader, (CustomScalarAdapters) null, 2, (Object) null);
    }

    public static final <D extends Operation.Data> ApolloResponse<D> parseJsonResponse(Operation<D> operation, String json) {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        return parseJsonResponse$default(operation, json, (CustomScalarAdapters) null, 2, (Object) null);
    }

    public static /* synthetic */ void composeJsonRequest$default(Operation operation, JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            customScalarAdapters = CustomScalarAdapters.Empty;
        }
        composeJsonRequest(operation, jsonWriter, customScalarAdapters);
    }

    public static /* synthetic */ ApolloResponse parseJsonResponse$default(Operation operation, JsonReader jsonReader, CustomScalarAdapters customScalarAdapters, int i, Object obj) {
        if ((i & 2) != 0) {
            customScalarAdapters = CustomScalarAdapters.Empty;
        }
        return parseJsonResponse(operation, jsonReader, customScalarAdapters);
    }

    public static final <D extends Operation.Data> ApolloResponse<D> parseJsonResponse(Operation<D> operation, JsonReader jsonReader, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return parseJsonResponseInternal(operation, jsonReader, customScalarAdapters, true);
    }

    public static final <D extends Operation.Data> ApolloResponse<D> parseJsonResponseInternal(Operation<D> operation, JsonReader jsonReader, CustomScalarAdapters customScalarAdapters, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return ResponseParser.INSTANCE.parse(jsonReader, operation, customScalarAdapters.newBuilder().adapterContext(customScalarAdapters.getAdapterContext().newBuilder().variables(Executables.variables(operation, customScalarAdapters, true)).build()).build(), z);
    }

    public static /* synthetic */ ApolloResponse parseJsonResponse$default(Operation operation, String str, CustomScalarAdapters customScalarAdapters, int i, Object obj) {
        if ((i & 2) != 0) {
            customScalarAdapters = CustomScalarAdapters.Empty;
        }
        return parseJsonResponse(operation, str, customScalarAdapters);
    }

    public static final <D extends Operation.Data> ApolloResponse<D> parseJsonResponse(Operation<D> operation, String json, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return parseJsonResponse(operation, JsonReaders.jsonReader(new Buffer().writeUtf8(json)), customScalarAdapters);
    }

    public static /* synthetic */ void composeJsonResponse$default(Operation operation, JsonWriter jsonWriter, Operation.Data data, CustomScalarAdapters customScalarAdapters, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            customScalarAdapters = CustomScalarAdapters.Empty;
        }
        composeJsonResponse(operation, jsonWriter, data, customScalarAdapters);
    }

    public static final <D extends Operation.Data> void composeJsonResponse(Operation<D> operation, JsonWriter jsonWriter, D data, CustomScalarAdapters customScalarAdapters) throws Throwable {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        JsonWriter jsonWriter2 = jsonWriter;
        try {
            JsonWriter jsonWriter3 = jsonWriter2;
            jsonWriter3.beginObject();
            jsonWriter3.name("data");
            operation.adapter().toJson(jsonWriter3, customScalarAdapters, data);
            jsonWriter3.endObject();
            Unit unit = Unit.INSTANCE;
            try {
                jsonWriter2.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                jsonWriter2.close();
            } catch (Throwable th3) {
                ExceptionsKt.addSuppressed(th, th3);
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public static final <D extends Operation.Data> void composeJsonRequest(Operation<D> operation, JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters) throws IOException {
        Intrinsics.checkNotNullParameter(operation, "<this>");
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        jsonWriter.beginObject();
        jsonWriter.name("operationName");
        jsonWriter.value(operation.name());
        jsonWriter.name("variables");
        jsonWriter.beginObject();
        operation.serializeVariables(jsonWriter, customScalarAdapters);
        jsonWriter.endObject();
        jsonWriter.name("query");
        jsonWriter.value(operation.document());
        jsonWriter.endObject();
    }
}
