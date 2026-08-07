package com.splunk.rum;

import java.nio.charset.StandardCharsets;
import java.util.List;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.V2SpanWriter;
import zipkin2.internal.WriteBuffer;

/* JADX INFO: loaded from: classes3.dex */
class CustomZipkinEncoder implements BytesEncoder<Span> {
    private final WriteBuffer.Writer<Span> writer = new V2SpanWriter();

    CustomZipkinEncoder() {
    }

    @Override // zipkin2.codec.BytesEncoder
    public Encoding encoding() {
        return Encoding.JSON;
    }

    @Override // zipkin2.codec.BytesEncoder
    public int sizeInBytes(Span span) {
        return this.writer.sizeInBytes(span);
    }

    @Override // zipkin2.codec.BytesEncoder
    public byte[] encode(Span span) {
        return new String(JsonCodec.write(this.writer, span), StandardCharsets.UTF_8).replace("\"name\":\"" + span.name() + "\"", "\"name\":\"" + span.tags().get(SplunkSpanDataModifier.SPLUNK_OPERATION_KEY.getKey()) + "\"").getBytes(StandardCharsets.UTF_8);
    }

    @Override // zipkin2.codec.BytesEncoder
    public byte[] encodeList(List<Span> list) {
        return JsonCodec.writeList(this.writer, list);
    }
}
