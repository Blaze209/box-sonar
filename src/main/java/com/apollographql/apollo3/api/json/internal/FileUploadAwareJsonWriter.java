package com.apollographql.apollo3.api.json.internal;

import com.apollographql.apollo3.api.Upload;
import com.apollographql.apollo3.api.json.JsonNumber;
import com.apollographql.apollo3.api.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: FileUploadAwareJsonWriter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0000H\u0016J\b\u0010\f\u001a\u00020\u0000H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0010J\b\u0010\u0011\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u001aH\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u001bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/apollographql/apollo3/api/json/internal/FileUploadAwareJsonWriter;", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "wrappedWriter", "(Lcom/apollographql/apollo3/api/json/JsonWriter;)V", "path", "", "getPath", "()Ljava/lang/String;", "uploads", "", "Lcom/apollographql/apollo3/api/Upload;", "beginArray", "beginObject", HeaderElements.CLOSE, "", "collectedUploads", "", "endArray", "endObject", "flush", "name", "nullValue", "value", "Lcom/apollographql/apollo3/api/json/JsonNumber;", "", "", "", "", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FileUploadAwareJsonWriter implements JsonWriter {
    private final Map<String, Upload> uploads;
    private final JsonWriter wrappedWriter;

    public FileUploadAwareJsonWriter(JsonWriter wrappedWriter) {
        Intrinsics.checkNotNullParameter(wrappedWriter, "wrappedWriter");
        this.wrappedWriter = wrappedWriter;
        this.uploads = new LinkedHashMap();
    }

    public final Map<String, Upload> collectedUploads() {
        return this.uploads;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter beginArray() throws IOException {
        this.wrappedWriter.beginArray();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter endArray() throws IOException {
        this.wrappedWriter.endArray();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter beginObject() throws IOException {
        this.wrappedWriter.beginObject();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter endObject() throws IOException {
        this.wrappedWriter.endObject();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter name(String name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        this.wrappedWriter.name(name);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(String value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        this.wrappedWriter.value(value);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(boolean value) throws IOException {
        this.wrappedWriter.value(value);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(double value) throws IOException {
        this.wrappedWriter.value(value);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(int value) throws IOException {
        this.wrappedWriter.value(value);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(long value) throws IOException {
        this.wrappedWriter.value(value);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(JsonNumber value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        this.wrappedWriter.value(value);
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter value(Upload value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        this.uploads.put(this.wrappedWriter.getPath(), value);
        this.wrappedWriter.nullValue();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public FileUploadAwareJsonWriter nullValue() throws IOException {
        this.wrappedWriter.nullValue();
        return this;
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public String getPath() {
        return this.wrappedWriter.getPath();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.wrappedWriter.close();
    }

    @Override // com.apollographql.apollo3.api.json.JsonWriter
    public void flush() throws IOException {
        this.wrappedWriter.flush();
    }
}
