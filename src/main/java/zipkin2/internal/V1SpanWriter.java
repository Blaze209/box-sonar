package zipkin2.internal;

import zipkin2.Endpoint;
import zipkin2.v1.V1Annotation;
import zipkin2.v1.V1BinaryAnnotation;
import zipkin2.v1.V1Span;

/* JADX INFO: loaded from: classes6.dex */
public final class V1SpanWriter implements WriteBuffer.Writer<V1Span> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v1, types: [zipkin2.Endpoint] */
    /* JADX WARN: Type inference failed for: r7v1, types: [zipkin2.Endpoint] */
    @Override // zipkin2.internal.WriteBuffer.Writer
    public int sizeInBytes(V1Span v1Span) {
        int iEndpointSizeInBytes;
        ?? r3;
        int i;
        ?? r4;
        int i2;
        int i3 = v1Span.traceIdHigh() != 0 ? 45 : 29;
        if (v1Span.parentId() != 0) {
            i3 += 30;
        }
        int iBinaryAnnotationSizeInBytes = i3 + 34;
        if (v1Span.name() != null) {
            iBinaryAnnotationSizeInBytes += JsonEscaper.jsonEscapedSizeInBytes(v1Span.name());
        }
        if (v1Span.timestamp() != 0) {
            iBinaryAnnotationSizeInBytes = iBinaryAnnotationSizeInBytes + 13 + WriteBuffer.asciiSizeInBytes(v1Span.timestamp());
        }
        if (v1Span.duration() != 0) {
            iBinaryAnnotationSizeInBytes = iBinaryAnnotationSizeInBytes + 12 + WriteBuffer.asciiSizeInBytes(v1Span.duration());
        }
        int size = v1Span.annotations().size();
        ?? r5 = 0;
        r5 = 0;
        if (size > 0) {
            iBinaryAnnotationSizeInBytes += 17;
            if (size > 1) {
                iBinaryAnnotationSizeInBytes += size - 1;
            }
            int i4 = 0;
            iEndpointSizeInBytes = 0;
            while (i4 < size) {
                V1Annotation v1Annotation = v1Span.annotations().get(i4);
                ?? Endpoint = v1Annotation.endpoint();
                if (Endpoint == 0) {
                    i2 = iEndpointSizeInBytes;
                    iEndpointSizeInBytes = 0;
                } else {
                    if (!Endpoint.equals(r5)) {
                        r5 = r5;
                        iEndpointSizeInBytes = V2SpanWriter.endpointSizeInBytes(Endpoint, true);
                        r5 = Endpoint;
                    }
                    r5 = r5;
                    i2 = iEndpointSizeInBytes;
                }
                iBinaryAnnotationSizeInBytes += V2SpanWriter.annotationSizeInBytes(v1Annotation.timestamp(), v1Annotation.value(), iEndpointSizeInBytes);
                i4++;
                iEndpointSizeInBytes = i2;
                r5 = r5;
            }
        } else {
            iEndpointSizeInBytes = 0;
        }
        int size2 = v1Span.binaryAnnotations().size();
        if (size2 > 0) {
            iBinaryAnnotationSizeInBytes += 23;
            if (size2 > 1) {
                iBinaryAnnotationSizeInBytes += size2 - 1;
            }
            int i5 = 0;
            ?? r6 = r5;
            while (i5 < size2) {
                int i6 = i5 + 1;
                V1BinaryAnnotation v1BinaryAnnotation = v1Span.binaryAnnotations().get(i5);
                ?? Endpoint2 = v1BinaryAnnotation.endpoint();
                if (Endpoint2 == 0) {
                    i = iEndpointSizeInBytes;
                    iEndpointSizeInBytes = 0;
                    r4 = r6;
                } else {
                    if (!Endpoint2.equals(r6)) {
                        r3 = r6;
                        iEndpointSizeInBytes = V2SpanWriter.endpointSizeInBytes(Endpoint2, true);
                        r3 = Endpoint2;
                    }
                    r3 = r6;
                    i = iEndpointSizeInBytes;
                    r4 = r3;
                }
                iBinaryAnnotationSizeInBytes = v1BinaryAnnotation.stringValue() != null ? iBinaryAnnotationSizeInBytes + binaryAnnotationSizeInBytes(v1BinaryAnnotation.key(), v1BinaryAnnotation.stringValue(), iEndpointSizeInBytes) : iBinaryAnnotationSizeInBytes + 37 + iEndpointSizeInBytes;
                iEndpointSizeInBytes = i;
                i5 = i6;
                r6 = r4;
            }
        }
        if (Boolean.TRUE.equals(v1Span.debug())) {
            iBinaryAnnotationSizeInBytes += 13;
        }
        return iBinaryAnnotationSizeInBytes + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v2, types: [zipkin2.Endpoint] */
    /* JADX WARN: Type inference failed for: r7v7, types: [zipkin2.Endpoint] */
    @Override // zipkin2.internal.WriteBuffer.Writer
    public void write(V1Span v1Span, WriteBuffer writeBuffer) {
        ?? r5;
        byte[] bArrLegacyEndpointBytes;
        ?? r6;
        ?? r7;
        byte[] bArr;
        ?? r8;
        ?? r9;
        byte[] bArr2;
        ?? r10;
        writeBuffer.writeAscii("{\"traceId\":\"");
        if (v1Span.traceIdHigh() != 0) {
            writeBuffer.writeLongHex(v1Span.traceIdHigh());
        }
        writeBuffer.writeLongHex(v1Span.traceId());
        writeBuffer.writeByte(34);
        if (v1Span.parentId() != 0) {
            writeBuffer.writeAscii(",\"parentId\":\"");
            writeBuffer.writeLongHex(v1Span.parentId());
            writeBuffer.writeByte(34);
        }
        writeBuffer.writeAscii(",\"id\":\"");
        writeBuffer.writeLongHex(v1Span.id());
        writeBuffer.writeByte(34);
        writeBuffer.writeAscii(",\"name\":\"");
        if (v1Span.name() != null) {
            writeBuffer.writeUtf8(JsonEscaper.jsonEscape(v1Span.name()));
        }
        writeBuffer.writeByte(34);
        if (v1Span.timestamp() != 0) {
            writeBuffer.writeAscii(",\"timestamp\":");
            writeBuffer.writeAscii(v1Span.timestamp());
        }
        if (v1Span.duration() != 0) {
            writeBuffer.writeAscii(",\"duration\":");
            writeBuffer.writeAscii(v1Span.duration());
        }
        int size = v1Span.annotations().size();
        int i = 0;
        if (size > 0) {
            writeBuffer.writeAscii(",\"annotations\":[");
            int i2 = 0;
            ?? r11 = 0;
            bArrLegacyEndpointBytes = null;
            while (i2 < size) {
                int i3 = i2 + 1;
                V1Annotation v1Annotation = v1Span.annotations().get(i2);
                ?? Endpoint = v1Annotation.endpoint();
                if (Endpoint == 0) {
                    bArr2 = bArrLegacyEndpointBytes;
                    bArrLegacyEndpointBytes = null;
                    r10 = r11;
                } else {
                    if (!Endpoint.equals(r11)) {
                        r9 = r11;
                        bArrLegacyEndpointBytes = legacyEndpointBytes(Endpoint);
                        r9 = Endpoint;
                    }
                    r9 = r11;
                    bArr2 = bArrLegacyEndpointBytes;
                    r10 = r9;
                }
                V2SpanWriter.writeAnnotation(v1Annotation.timestamp(), v1Annotation.value(), bArrLegacyEndpointBytes, writeBuffer);
                if (i3 < size) {
                    writeBuffer.writeByte(44);
                }
                bArrLegacyEndpointBytes = bArr2;
                i2 = i3;
                r11 = r10;
            }
            writeBuffer.writeByte(93);
            r5 = r11;
        } else {
            r5 = 0;
            bArrLegacyEndpointBytes = null;
        }
        int size2 = v1Span.binaryAnnotations().size();
        if (size2 > 0) {
            writeBuffer.writeAscii(",\"binaryAnnotations\":[");
            while (i < size2) {
                int i4 = i + 1;
                V1BinaryAnnotation v1BinaryAnnotation = v1Span.binaryAnnotations().get(i);
                ?? Endpoint2 = v1BinaryAnnotation.endpoint();
                if (Endpoint2 == 0) {
                    r6 = r5;
                    bArr = bArrLegacyEndpointBytes;
                    bArrLegacyEndpointBytes = null;
                    r8 = r6;
                } else {
                    if (!Endpoint2.equals(r6)) {
                        r6 = r5;
                        r7 = r6;
                        bArrLegacyEndpointBytes = legacyEndpointBytes(Endpoint2);
                        r7 = Endpoint2;
                    }
                    r6 = r5;
                    r7 = r6;
                    bArr = bArrLegacyEndpointBytes;
                    r8 = r7;
                }
                if (v1BinaryAnnotation.stringValue() != null) {
                    writeBinaryAnnotation(v1BinaryAnnotation.key(), v1BinaryAnnotation.stringValue(), bArrLegacyEndpointBytes, writeBuffer);
                } else {
                    writeBuffer.writeAscii("{\"key\":\"");
                    writeBuffer.writeAscii(v1BinaryAnnotation.key());
                    writeBuffer.writeAscii("\",\"value\":true,\"endpoint\":");
                    writeBuffer.write(bArrLegacyEndpointBytes);
                    writeBuffer.writeByte(125);
                }
                if (i4 < size2) {
                    writeBuffer.writeByte(44);
                }
                bArrLegacyEndpointBytes = bArr;
                i = i4;
                r6 = r8;
            }
            r6 = r5;
            writeBuffer.writeByte(93);
        }
        if (Boolean.TRUE.equals(v1Span.debug())) {
            writeBuffer.writeAscii(",\"debug\":true");
        }
        writeBuffer.writeByte(125);
    }

    public String toString() {
        return "Span";
    }

    static byte[] legacyEndpointBytes(@Nullable Endpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        byte[] bArr = new byte[V2SpanWriter.endpointSizeInBytes(endpoint, true)];
        V2SpanWriter.writeEndpoint(endpoint, WriteBuffer.wrap(bArr), true);
        return bArr;
    }

    static int binaryAnnotationSizeInBytes(String str, String str2, int i) {
        int iJsonEscapedSizeInBytes = JsonEscaper.jsonEscapedSizeInBytes(str) + 21 + JsonEscaper.jsonEscapedSizeInBytes(str2);
        return i != 0 ? iJsonEscapedSizeInBytes + 12 + i : iJsonEscapedSizeInBytes;
    }

    static void writeBinaryAnnotation(String str, String str2, @Nullable byte[] bArr, WriteBuffer writeBuffer) {
        writeBuffer.writeAscii("{\"key\":\"");
        writeBuffer.writeUtf8(JsonEscaper.jsonEscape(str));
        writeBuffer.writeAscii("\",\"value\":\"");
        writeBuffer.writeUtf8(JsonEscaper.jsonEscape(str2));
        writeBuffer.writeByte(34);
        if (bArr != null) {
            writeBuffer.writeAscii(",\"endpoint\":");
            writeBuffer.write(bArr);
        }
        writeBuffer.writeAscii("}");
    }
}
