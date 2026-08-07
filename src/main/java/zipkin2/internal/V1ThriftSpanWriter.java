package zipkin2.internal;

import com.google.common.base.Ascii;
import java.util.List;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.v1.V1Annotation;
import zipkin2.v1.V1BinaryAnnotation;
import zipkin2.v1.V1Span;
import zipkin2.v1.V2SpanConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class V1ThriftSpanWriter implements WriteBuffer.Writer<Span> {
    final V2SpanConverter converter = V2SpanConverter.create();
    static final ThriftField TRACE_ID = new ThriftField((byte) 10, 1);
    static final ThriftField TRACE_ID_HIGH = new ThriftField((byte) 10, 12);
    static final ThriftField NAME = new ThriftField((byte) 11, 3);
    static final ThriftField ID = new ThriftField((byte) 10, 4);
    static final ThriftField PARENT_ID = new ThriftField((byte) 10, 5);
    static final ThriftField ANNOTATIONS = new ThriftField(Ascii.SI, 6);
    static final ThriftField BINARY_ANNOTATIONS = new ThriftField(Ascii.SI, 8);
    static final ThriftField DEBUG = new ThriftField((byte) 2, 9);
    static final ThriftField TIMESTAMP = new ThriftField((byte) 10, 10);
    static final ThriftField DURATION = new ThriftField((byte) 10, 11);
    static final byte[] EMPTY_ARRAY = new byte[0];

    @Override // zipkin2.internal.WriteBuffer.Writer
    public int sizeInBytes(Span span) {
        int iSizeInBytes;
        V1Span v1SpanConvert = this.converter.convert(span);
        int iSizeInBytes2 = span.localEndpoint() != null ? ThriftEndpointCodec.sizeInBytes(span.localEndpoint()) : 0;
        int i = v1SpanConvert.traceIdHigh() != 0 ? 22 : 11;
        if (v1SpanConvert.parentId() != 0) {
            i += 11;
        }
        int iUtf8SizeInBytes = i + 18;
        if (span.name() != null) {
            iUtf8SizeInBytes += WriteBuffer.utf8SizeInBytes(span.name());
        }
        int iSizeInBytes3 = iUtf8SizeInBytes + 8;
        int size = v1SpanConvert.annotations().size();
        for (int i2 = 0; i2 < size; i2++) {
            iSizeInBytes3 += ThriftAnnotationWriter.sizeInBytes(WriteBuffer.utf8SizeInBytes(v1SpanConvert.annotations().get(i2).value()), iSizeInBytes2);
        }
        int i3 = iSizeInBytes3 + 8;
        int size2 = v1SpanConvert.binaryAnnotations().size();
        for (int i4 = 0; i4 < size2; i4++) {
            V1BinaryAnnotation v1BinaryAnnotation = v1SpanConvert.binaryAnnotations().get(i4);
            int iUtf8SizeInBytes2 = WriteBuffer.utf8SizeInBytes(v1BinaryAnnotation.key());
            if (v1BinaryAnnotation.stringValue() != null) {
                iSizeInBytes = ThriftBinaryAnnotationWriter.sizeInBytes(iUtf8SizeInBytes2, WriteBuffer.utf8SizeInBytes(v1BinaryAnnotation.stringValue()), iSizeInBytes2);
            } else {
                iSizeInBytes = ThriftBinaryAnnotationWriter.sizeInBytes(iUtf8SizeInBytes2, 1, ThriftEndpointCodec.sizeInBytes(v1BinaryAnnotation.endpoint()));
            }
            i3 += iSizeInBytes;
        }
        if (v1SpanConvert.debug() != null) {
            i3 += 4;
        }
        if (v1SpanConvert.timestamp() != 0) {
            i3 += 11;
        }
        if (v1SpanConvert.duration() != 0) {
            i3 += 11;
        }
        return i3 + 1;
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public void write(Span span, WriteBuffer writeBuffer) {
        V1Span v1SpanConvert = this.converter.convert(span);
        byte[] bArrLegacyEndpointBytes = legacyEndpointBytes(span.localEndpoint());
        TRACE_ID.write(writeBuffer);
        ThriftCodec.writeLong(writeBuffer, v1SpanConvert.traceId());
        NAME.write(writeBuffer);
        ThriftCodec.writeLengthPrefixed(writeBuffer, span.name() != null ? span.name() : "");
        ID.write(writeBuffer);
        ThriftCodec.writeLong(writeBuffer, v1SpanConvert.id());
        if (v1SpanConvert.parentId() != 0) {
            PARENT_ID.write(writeBuffer);
            ThriftCodec.writeLong(writeBuffer, v1SpanConvert.parentId());
        }
        ANNOTATIONS.write(writeBuffer);
        writeAnnotations(writeBuffer, v1SpanConvert, bArrLegacyEndpointBytes);
        BINARY_ANNOTATIONS.write(writeBuffer);
        writeBinaryAnnotations(writeBuffer, v1SpanConvert, bArrLegacyEndpointBytes);
        if (v1SpanConvert.debug() != null) {
            DEBUG.write(writeBuffer);
            writeBuffer.writeByte(v1SpanConvert.debug().booleanValue() ? 1 : 0);
        }
        if (v1SpanConvert.timestamp() != 0) {
            TIMESTAMP.write(writeBuffer);
            ThriftCodec.writeLong(writeBuffer, v1SpanConvert.timestamp());
        }
        if (v1SpanConvert.duration() != 0) {
            DURATION.write(writeBuffer);
            ThriftCodec.writeLong(writeBuffer, v1SpanConvert.duration());
        }
        if (v1SpanConvert.traceIdHigh() != 0) {
            TRACE_ID_HIGH.write(writeBuffer);
            ThriftCodec.writeLong(writeBuffer, v1SpanConvert.traceIdHigh());
        }
        writeBuffer.writeByte(0);
    }

    static void writeAnnotations(WriteBuffer writeBuffer, V1Span v1Span, byte[] bArr) {
        int size = v1Span.annotations().size();
        ThriftCodec.writeListBegin(writeBuffer, size);
        for (int i = 0; i < size; i++) {
            V1Annotation v1Annotation = v1Span.annotations().get(i);
            ThriftAnnotationWriter.write(v1Annotation.timestamp(), v1Annotation.value(), bArr, writeBuffer);
        }
    }

    static void writeBinaryAnnotations(WriteBuffer writeBuffer, V1Span v1Span, byte[] bArr) {
        int size = v1Span.binaryAnnotations().size();
        ThriftCodec.writeListBegin(writeBuffer, size);
        for (int i = 0; i < size; i++) {
            V1BinaryAnnotation v1BinaryAnnotation = v1Span.binaryAnnotations().get(i);
            ThriftBinaryAnnotationWriter.write(v1BinaryAnnotation.key(), v1BinaryAnnotation.stringValue(), v1BinaryAnnotation.stringValue() != null ? bArr : legacyEndpointBytes(v1BinaryAnnotation.endpoint()), writeBuffer);
        }
    }

    public String toString() {
        return "Span";
    }

    public byte[] writeList(List<Span> list) {
        if (list.size() == 0) {
            return EMPTY_ARRAY;
        }
        byte[] bArr = new byte[ThriftCodec.listSizeInBytes(this, list)];
        ThriftCodec.writeList(this, list, WriteBuffer.wrap(bArr));
        return bArr;
    }

    public byte[] write(Span span) {
        byte[] bArr = new byte[sizeInBytes(span)];
        write(span, WriteBuffer.wrap(bArr));
        return bArr;
    }

    public int writeList(List<Span> list, byte[] bArr, int i) {
        if (list.size() == 0) {
            return 0;
        }
        WriteBuffer writeBufferWrap = WriteBuffer.wrap(bArr, i);
        ThriftCodec.writeList(this, list, writeBufferWrap);
        return writeBufferWrap.pos() - i;
    }

    static byte[] legacyEndpointBytes(@Nullable Endpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        byte[] bArr = new byte[ThriftEndpointCodec.sizeInBytes(endpoint)];
        ThriftEndpointCodec.write(endpoint, WriteBuffer.wrap(bArr));
        return bArr;
    }

    static class ThriftAnnotationWriter {
        static final ThriftField TIMESTAMP = new ThriftField((byte) 10, 1);
        static final ThriftField VALUE = new ThriftField((byte) 11, 2);
        static final ThriftField ENDPOINT = new ThriftField(Ascii.FF, 3);

        static int sizeInBytes(int i, int i2) {
            int i3 = i + 18;
            if (i2 > 0) {
                i3 += i2 + 3;
            }
            return i3 + 1;
        }

        ThriftAnnotationWriter() {
        }

        static void write(long j, String str, byte[] bArr, WriteBuffer writeBuffer) {
            TIMESTAMP.write(writeBuffer);
            ThriftCodec.writeLong(writeBuffer, j);
            VALUE.write(writeBuffer);
            ThriftCodec.writeLengthPrefixed(writeBuffer, str);
            if (bArr != null) {
                ENDPOINT.write(writeBuffer);
                writeBuffer.write(bArr);
            }
            writeBuffer.writeByte(0);
        }
    }

    static class ThriftBinaryAnnotationWriter {
        static final ThriftField KEY = new ThriftField((byte) 11, 1);
        static final ThriftField VALUE = new ThriftField((byte) 11, 2);
        static final ThriftField TYPE = new ThriftField((byte) 8, 3);
        static final ThriftField ENDPOINT = new ThriftField(Ascii.FF, 4);

        static int sizeInBytes(int i, int i2, int i3) {
            int i4 = i + 7 + i2 + 7 + 7;
            if (i3 > 0) {
                i4 += i3 + 3;
            }
            return i4 + 1;
        }

        ThriftBinaryAnnotationWriter() {
        }

        static void write(String str, String str2, byte[] bArr, WriteBuffer writeBuffer) {
            int i;
            KEY.write(writeBuffer);
            ThriftCodec.writeLengthPrefixed(writeBuffer, str);
            VALUE.write(writeBuffer);
            if (str2 != null) {
                ThriftCodec.writeInt(writeBuffer, WriteBuffer.utf8SizeInBytes(str2));
                writeBuffer.writeUtf8(str2);
                i = 6;
            } else {
                ThriftCodec.writeInt(writeBuffer, 1);
                writeBuffer.writeByte(1);
                i = 0;
            }
            TYPE.write(writeBuffer);
            ThriftCodec.writeInt(writeBuffer, i);
            if (bArr != null) {
                ENDPOINT.write(writeBuffer);
                writeBuffer.write(bArr);
            }
            writeBuffer.writeByte(0);
        }
    }
}
