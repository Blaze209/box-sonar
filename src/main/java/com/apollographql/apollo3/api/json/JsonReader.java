package com.apollographql.apollo3.api.json;

import com.facebook.infer.annotation.ThreadConfined;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: JsonReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001!J\b\u0010\u0003\u001a\u00020\u0000H&J\b\u0010\u0004\u001a\u00020\u0000H&J\b\u0010\u0005\u001a\u00020\u0000H&J\b\u0010\u0006\u001a\u00020\u0000H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\u0016\u0010\u001e\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\bH&J\b\u0010 \u001a\u00020\u001dH&¨\u0006\""}, d2 = {"Lcom/apollographql/apollo3/api/json/JsonReader;", "Ljava/io/Closeable;", "Lokio/Closeable;", "beginArray", "beginObject", "endArray", "endObject", "getPath", "", "", "hasNext", "", "nextBoolean", "nextDouble", "", "nextInt", "", "nextLong", "", "nextName", "", "nextNull", "", "nextNumber", "Lcom/apollographql/apollo3/api/json/JsonNumber;", "nextString", "peek", "Lcom/apollographql/apollo3/api/json/JsonReader$Token;", "rewind", "", "selectName", "names", "skipValue", "Token", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface JsonReader extends Closeable {

    /* JADX INFO: compiled from: JsonReader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/apollographql/apollo3/api/json/JsonReader$Token;", "", "(Ljava/lang/String;I)V", "BEGIN_ARRAY", "END_ARRAY", "BEGIN_OBJECT", "END_OBJECT", "NAME", "STRING", "NUMBER", "LONG", "BOOLEAN", "NULL", "END_DOCUMENT", ThreadConfined.ANY, "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        LONG,
        BOOLEAN,
        NULL,
        END_DOCUMENT,
        ANY
    }

    JsonReader beginArray() throws IOException;

    JsonReader beginObject() throws IOException;

    JsonReader endArray() throws IOException;

    JsonReader endObject() throws IOException;

    List<Object> getPath();

    boolean hasNext() throws IOException;

    boolean nextBoolean() throws IOException;

    double nextDouble() throws IOException;

    int nextInt() throws IOException;

    long nextLong() throws IOException;

    String nextName() throws IOException;

    Void nextNull() throws IOException;

    JsonNumber nextNumber() throws IOException;

    String nextString() throws IOException;

    Token peek() throws IOException;

    void rewind();

    int selectName(List<String> names) throws IOException;

    void skipValue() throws IOException;
}
