package com.microsoft.identity.common.java.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class QueryParamsAdapter extends TypeAdapter<List<Map.Entry<String, String>>> {
    private static final String TAG = "QueryParamsAdapter";
    private static final Gson mGson;
    boolean mWriteProperFormat;

    public QueryParamsAdapter(boolean z) {
        this.mWriteProperFormat = z;
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(getListType(), new QueryParamsAdapter(false));
        mGson = gsonBuilder.create();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, List<Map.Entry<String, String>> list) throws IOException {
        if (this.mWriteProperFormat) {
            writeProperFormat(jsonWriter, list);
        } else {
            writeListPairFormat(jsonWriter, list);
        }
    }

    private void writeProperFormat(JsonWriter jsonWriter, List<Map.Entry<String, String>> list) throws IOException {
        jsonWriter.beginObject();
        for (Map.Entry<String, String> entry : list) {
            jsonWriter.name(entry.getKey());
            jsonWriter.value(entry.getValue());
        }
        jsonWriter.endObject();
    }

    private void writeListPairFormat(JsonWriter jsonWriter, List<Map.Entry<String, String>> list) throws IOException {
        jsonWriter.beginArray();
        for (Map.Entry<String, String> entry : list) {
            jsonWriter.beginObject();
            jsonWriter.name("first");
            jsonWriter.value(entry.getKey());
            jsonWriter.name("second");
            jsonWriter.value(entry.getValue());
            jsonWriter.endObject();
        }
        jsonWriter.endArray();
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.util.QueryParamsAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public List<Map.Entry<String, String>> read2(JsonReader jsonReader) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
        if (i == 1) {
            return readListPairFormat(jsonReader);
        }
        if (i == 2) {
            return readProperFormat(jsonReader);
        }
        return new ArrayList();
    }

    private List<Map.Entry<String, String>> readProperFormat(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            arrayList.add(new AbstractMap.SimpleEntry(jsonReader.nextName(), jsonReader.nextString()));
        }
        jsonReader.endObject();
        return arrayList;
    }

    private List<Map.Entry<String, String>> readListPairFormat(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            String strNextString = "";
            String strNextString2 = "";
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (StringUtil.equalsIgnoreCase(strNextName, "first")) {
                    strNextString = jsonReader.nextString();
                } else if (StringUtil.equalsIgnoreCase(strNextName, "second")) {
                    strNextString2 = jsonReader.nextString();
                } else {
                    throw new JsonSyntaxException("Unexpected NAME field: " + strNextName);
                }
            }
            arrayList.add(new AbstractMap.SimpleEntry(strNextString, strNextString2));
            jsonReader.endObject();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static String _toJson(List<Map.Entry<String, String>> list) {
        return mGson.toJson(list, getListType());
    }

    public static List<Map.Entry<String, String>> _fromJson(String str) throws ClientException {
        if (StringUtil.isNullOrEmpty(str)) {
            return new ArrayList();
        }
        try {
            return (List) mGson.fromJson(str, getListType());
        } catch (JsonSyntaxException e) {
            String str2 = "malformed json string:" + str;
            Logger.error(TAG + ":_fromJson", str2, e);
            throw new ClientException("json_parse_failure", str2, e);
        }
    }

    public static Type getListType() {
        return TypeToken.getParameterized(List.class, TypeToken.getParameterized(Map.Entry.class, String.class, String.class).getRawType()).getType();
    }
}
