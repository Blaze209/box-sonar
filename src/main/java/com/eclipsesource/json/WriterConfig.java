package com.eclipsesource.json;

import java.io.Writer;

/* JADX INFO: loaded from: classes13.dex */
public abstract class WriterConfig {
    public static WriterConfig MINIMAL = new WriterConfig() { // from class: com.eclipsesource.json.WriterConfig.1
        @Override // com.eclipsesource.json.WriterConfig
        JsonWriter createWriter(Writer writer) {
            return new JsonWriter(writer);
        }
    };
    public static WriterConfig PRETTY_PRINT = PrettyPrint.indentWithSpaces(2);

    abstract JsonWriter createWriter(Writer writer);
}
