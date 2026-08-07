package zipkin2.internal;

import java.util.Iterator;
import java.util.Map;
import zipkin2.Annotation;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class V2SpanWriter implements WriteBuffer.Writer<Span> {
    @Override // zipkin2.internal.WriteBuffer.Writer
    public int sizeInBytes(Span span) {
        int length = span.traceId().length();
        int i = length + 13;
        if (span.parentId() != null) {
            i = length + 43;
        }
        int iJsonEscapedSizeInBytes = i + 24;
        if (span.kind() != null) {
            iJsonEscapedSizeInBytes = span.kind().name().length() + i + 34;
        }
        if (span.name() != null) {
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 10 + JsonEscaper.jsonEscapedSizeInBytes(span.name());
        }
        if (span.timestampAsLong() != 0) {
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 13 + WriteBuffer.asciiSizeInBytes(span.timestampAsLong());
        }
        if (span.durationAsLong() != 0) {
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 12 + WriteBuffer.asciiSizeInBytes(span.durationAsLong());
        }
        if (span.localEndpoint() != null) {
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 17 + endpointSizeInBytes(span.localEndpoint(), false);
        }
        if (span.remoteEndpoint() != null) {
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 18 + endpointSizeInBytes(span.remoteEndpoint(), false);
        }
        if (!span.annotations().isEmpty()) {
            iJsonEscapedSizeInBytes += 17;
            int size = span.annotations().size();
            if (size > 1) {
                iJsonEscapedSizeInBytes += size - 1;
            }
            for (int i2 = 0; i2 < size; i2++) {
                Annotation annotation = span.annotations().get(i2);
                iJsonEscapedSizeInBytes += annotationSizeInBytes(annotation.timestamp(), annotation.value(), 0);
            }
        }
        if (!span.tags().isEmpty()) {
            iJsonEscapedSizeInBytes += 10;
            int size2 = span.tags().size();
            if (size2 > 1) {
                iJsonEscapedSizeInBytes += size2 - 1;
            }
            for (Map.Entry<String, String> entry : span.tags().entrySet()) {
                iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 5 + JsonEscaper.jsonEscapedSizeInBytes(entry.getKey()) + JsonEscaper.jsonEscapedSizeInBytes(entry.getValue());
            }
        }
        if (Boolean.TRUE.equals(span.debug())) {
            iJsonEscapedSizeInBytes += 13;
        }
        if (Boolean.TRUE.equals(span.shared())) {
            iJsonEscapedSizeInBytes += 14;
        }
        return iJsonEscapedSizeInBytes + 1;
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public void write(Span span, WriteBuffer writeBuffer) {
        writeBuffer.writeAscii("{\"traceId\":\"");
        writeBuffer.writeAscii(span.traceId());
        writeBuffer.writeByte(34);
        if (span.parentId() != null) {
            writeBuffer.writeAscii(",\"parentId\":\"");
            writeBuffer.writeAscii(span.parentId());
            writeBuffer.writeByte(34);
        }
        writeBuffer.writeAscii(",\"id\":\"");
        writeBuffer.writeAscii(span.id());
        writeBuffer.writeByte(34);
        if (span.kind() != null) {
            writeBuffer.writeAscii(",\"kind\":\"");
            writeBuffer.writeAscii(span.kind().toString());
            writeBuffer.writeByte(34);
        }
        if (span.name() != null) {
            writeBuffer.writeAscii(",\"name\":\"");
            writeBuffer.writeUtf8(JsonEscaper.jsonEscape(span.name()));
            writeBuffer.writeByte(34);
        }
        if (span.timestampAsLong() != 0) {
            writeBuffer.writeAscii(",\"timestamp\":");
            writeBuffer.writeAscii(span.timestampAsLong());
        }
        if (span.durationAsLong() != 0) {
            writeBuffer.writeAscii(",\"duration\":");
            writeBuffer.writeAscii(span.durationAsLong());
        }
        int i = 0;
        if (span.localEndpoint() != null) {
            writeBuffer.writeAscii(",\"localEndpoint\":");
            writeEndpoint(span.localEndpoint(), writeBuffer, false);
        }
        if (span.remoteEndpoint() != null) {
            writeBuffer.writeAscii(",\"remoteEndpoint\":");
            writeEndpoint(span.remoteEndpoint(), writeBuffer, false);
        }
        if (!span.annotations().isEmpty()) {
            writeBuffer.writeAscii(",\"annotations\":");
            writeBuffer.writeByte(91);
            int size = span.annotations().size();
            while (i < size) {
                int i2 = i + 1;
                Annotation annotation = span.annotations().get(i);
                writeAnnotation(annotation.timestamp(), annotation.value(), null, writeBuffer);
                if (i2 < size) {
                    writeBuffer.writeByte(44);
                }
                i = i2;
            }
            writeBuffer.writeByte(93);
        }
        if (!span.tags().isEmpty()) {
            writeBuffer.writeAscii(",\"tags\":{");
            Iterator<Map.Entry<String, String>> it = span.tags().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                writeBuffer.writeByte(34);
                writeBuffer.writeUtf8(JsonEscaper.jsonEscape(next.getKey()));
                writeBuffer.writeAscii("\":\"");
                writeBuffer.writeUtf8(JsonEscaper.jsonEscape(next.getValue()));
                writeBuffer.writeByte(34);
                if (it.hasNext()) {
                    writeBuffer.writeByte(44);
                }
            }
            writeBuffer.writeByte(125);
        }
        if (Boolean.TRUE.equals(span.debug())) {
            writeBuffer.writeAscii(",\"debug\":true");
        }
        if (Boolean.TRUE.equals(span.shared())) {
            writeBuffer.writeAscii(",\"shared\":true");
        }
        writeBuffer.writeByte(125);
    }

    public String toString() {
        return "Span";
    }

    static int endpointSizeInBytes(Endpoint endpoint, boolean z) {
        String strServiceName = endpoint.serviceName();
        if (strServiceName == null && z) {
            strServiceName = "";
        }
        int iJsonEscapedSizeInBytes = strServiceName != null ? 17 + JsonEscaper.jsonEscapedSizeInBytes(strServiceName) : 1;
        if (endpoint.ipv4() != null) {
            if (iJsonEscapedSizeInBytes != 1) {
                iJsonEscapedSizeInBytes++;
            }
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 9 + endpoint.ipv4().length();
        }
        if (endpoint.ipv6() != null) {
            if (iJsonEscapedSizeInBytes != 1) {
                iJsonEscapedSizeInBytes++;
            }
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 9 + endpoint.ipv6().length();
        }
        int iPortAsInt = endpoint.portAsInt();
        if (iPortAsInt != 0) {
            if (iJsonEscapedSizeInBytes != 1) {
                iJsonEscapedSizeInBytes++;
            }
            iJsonEscapedSizeInBytes = iJsonEscapedSizeInBytes + 7 + WriteBuffer.asciiSizeInBytes(iPortAsInt);
        }
        return iJsonEscapedSizeInBytes + 1;
    }

    static void writeEndpoint(Endpoint endpoint, WriteBuffer writeBuffer, boolean z) {
        boolean z2;
        writeBuffer.writeByte(123);
        String strServiceName = endpoint.serviceName();
        if (strServiceName == null && z) {
            strServiceName = "";
        }
        boolean z3 = true;
        if (strServiceName != null) {
            writeBuffer.writeAscii("\"serviceName\":\"");
            writeBuffer.writeUtf8(JsonEscaper.jsonEscape(strServiceName));
            writeBuffer.writeByte(34);
            z2 = true;
        } else {
            z2 = false;
        }
        if (endpoint.ipv4() != null) {
            if (z2) {
                writeBuffer.writeByte(44);
            }
            writeBuffer.writeAscii("\"ipv4\":\"");
            writeBuffer.writeAscii(endpoint.ipv4());
            writeBuffer.writeByte(34);
            z2 = true;
        }
        if (endpoint.ipv6() != null) {
            if (z2) {
                writeBuffer.writeByte(44);
            }
            writeBuffer.writeAscii("\"ipv6\":\"");
            writeBuffer.writeAscii(endpoint.ipv6());
            writeBuffer.writeByte(34);
        } else {
            z3 = z2;
        }
        int iPortAsInt = endpoint.portAsInt();
        if (iPortAsInt != 0) {
            if (z3) {
                writeBuffer.writeByte(44);
            }
            writeBuffer.writeAscii("\"port\":");
            writeBuffer.writeAscii(iPortAsInt);
        }
        writeBuffer.writeByte(125);
    }

    static int annotationSizeInBytes(long j, String str, int i) {
        int iAsciiSizeInBytes = WriteBuffer.asciiSizeInBytes(j) + 25 + JsonEscaper.jsonEscapedSizeInBytes(str);
        return i != 0 ? iAsciiSizeInBytes + 12 + i : iAsciiSizeInBytes;
    }

    static void writeAnnotation(long j, String str, @Nullable byte[] bArr, WriteBuffer writeBuffer) {
        writeBuffer.writeAscii("{\"timestamp\":");
        writeBuffer.writeAscii(j);
        writeBuffer.writeAscii(",\"value\":\"");
        writeBuffer.writeUtf8(JsonEscaper.jsonEscape(str));
        writeBuffer.writeByte(34);
        if (bArr != null) {
            writeBuffer.writeAscii(",\"endpoint\":");
            writeBuffer.write(bArr);
        }
        writeBuffer.writeByte(125);
    }
}
