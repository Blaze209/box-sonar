package com.microsoft.identity.common.java.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
public class CharArrayJsonAdapter extends TypeAdapter<char[]> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, char[] cArr) throws IOException {
        jsonWriter.value(new String(cArr));
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public char[] read2(JsonReader jsonReader) throws IOException {
        return jsonReader.nextString().toCharArray();
    }
}
