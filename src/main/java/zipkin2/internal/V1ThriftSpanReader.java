package zipkin2.internal;

import com.google.common.base.Ascii;
import zipkin2.Endpoint;
import zipkin2.v1.V1Span;

/* JADX INFO: loaded from: classes6.dex */
public final class V1ThriftSpanReader {
    static final String ONE = Character.toString(1);
    V1Span.Builder builder = V1Span.newBuilder();

    public static V1ThriftSpanReader create() {
        return new V1ThriftSpanReader();
    }

    public V1Span read(ReadBuffer readBuffer) {
        V1Span.Builder builder = this.builder;
        if (builder == null) {
            this.builder = V1Span.newBuilder();
        } else {
            builder.clear();
        }
        while (true) {
            ThriftField thriftField = ThriftField.read(readBuffer);
            if (thriftField.type != 0) {
                if (thriftField.isEqualTo(V1ThriftSpanWriter.TRACE_ID_HIGH)) {
                    this.builder.traceIdHigh(readBuffer.readLong());
                } else if (thriftField.isEqualTo(V1ThriftSpanWriter.TRACE_ID)) {
                    this.builder.traceId(readBuffer.readLong());
                } else if (thriftField.isEqualTo(V1ThriftSpanWriter.NAME)) {
                    this.builder.name(readBuffer.readUtf8(readBuffer.readInt()));
                } else if (thriftField.isEqualTo(V1ThriftSpanWriter.ID)) {
                    this.builder.id(readBuffer.readLong());
                } else if (thriftField.isEqualTo(V1ThriftSpanWriter.PARENT_ID)) {
                    this.builder.parentId(readBuffer.readLong());
                } else {
                    if (thriftField.isEqualTo(V1ThriftSpanWriter.ANNOTATIONS)) {
                        int listLength = ThriftCodec.readListLength(readBuffer);
                        for (int i = 0; i < listLength; i++) {
                            AnnotationReader.read(readBuffer, this.builder);
                        }
                    } else if (thriftField.isEqualTo(V1ThriftSpanWriter.BINARY_ANNOTATIONS)) {
                        int listLength2 = ThriftCodec.readListLength(readBuffer);
                        for (int i2 = 0; i2 < listLength2; i2++) {
                            BinaryAnnotationReader.read(readBuffer, this.builder);
                        }
                    } else if (thriftField.isEqualTo(V1ThriftSpanWriter.DEBUG)) {
                        this.builder.debug(Boolean.valueOf(readBuffer.readByte() == 1));
                    } else if (thriftField.isEqualTo(V1ThriftSpanWriter.TIMESTAMP)) {
                        this.builder.timestamp(readBuffer.readLong());
                    } else if (thriftField.isEqualTo(V1ThriftSpanWriter.DURATION)) {
                        this.builder.duration(readBuffer.readLong());
                    } else {
                        ThriftCodec.skip(readBuffer, thriftField.type);
                    }
                }
            } else {
                return this.builder.build();
            }
        }
    }

    static final class AnnotationReader {
        static final ThriftField TIMESTAMP = new ThriftField((byte) 10, 1);
        static final ThriftField VALUE = new ThriftField((byte) 11, 2);
        static final ThriftField ENDPOINT = new ThriftField(Ascii.FF, 3);

        AnnotationReader() {
        }

        static void read(ReadBuffer readBuffer, V1Span.Builder builder) {
            String utf8 = null;
            long j = 0;
            Endpoint endpoint = null;
            while (true) {
                ThriftField thriftField = ThriftField.read(readBuffer);
                if (thriftField.type == 0) {
                    break;
                }
                if (thriftField.isEqualTo(TIMESTAMP)) {
                    j = readBuffer.readLong();
                } else if (thriftField.isEqualTo(VALUE)) {
                    utf8 = readBuffer.readUtf8(readBuffer.readInt());
                } else if (thriftField.isEqualTo(ENDPOINT)) {
                    endpoint = ThriftEndpointCodec.read(readBuffer);
                } else {
                    ThriftCodec.skip(readBuffer, thriftField.type);
                }
            }
            if (j == 0 || utf8 == null) {
                return;
            }
            builder.addAnnotation(j, utf8, endpoint);
        }
    }

    static final class BinaryAnnotationReader {
        static final ThriftField KEY = new ThriftField((byte) 11, 1);
        static final ThriftField VALUE = new ThriftField((byte) 11, 2);
        static final ThriftField TYPE = new ThriftField((byte) 8, 3);
        static final ThriftField ENDPOINT = new ThriftField(Ascii.FF, 4);

        BinaryAnnotationReader() {
        }

        static void read(ReadBuffer readBuffer, V1Span.Builder builder) {
            String utf8 = null;
            Endpoint endpoint = null;
            boolean z = false;
            boolean z2 = false;
            String utf9 = null;
            while (true) {
                ThriftField thriftField = ThriftField.read(readBuffer);
                if (thriftField.type == 0) {
                    break;
                }
                if (thriftField.isEqualTo(KEY)) {
                    utf8 = readBuffer.readUtf8(readBuffer.readInt());
                } else if (thriftField.isEqualTo(VALUE)) {
                    utf9 = readBuffer.readUtf8(readBuffer.readInt());
                } else if (thriftField.isEqualTo(TYPE)) {
                    int i = readBuffer.readInt();
                    if (i == 0) {
                        z2 = true;
                    } else if (i == 6) {
                        z = true;
                    }
                } else if (thriftField.isEqualTo(ENDPOINT)) {
                    endpoint = ThriftEndpointCodec.read(readBuffer);
                } else {
                    ThriftCodec.skip(readBuffer, thriftField.type);
                }
            }
            if (utf8 == null || utf9 == null) {
                return;
            }
            if (z) {
                builder.addBinaryAnnotation(utf8, utf9, endpoint);
                return;
            }
            if (z2 && V1ThriftSpanReader.ONE.equals(utf9) && endpoint != null) {
                if (utf8.equals("sa") || utf8.equals("ca") || utf8.equals("ma")) {
                    builder.addBinaryAnnotation(utf8, endpoint);
                }
            }
        }
    }

    V1ThriftSpanReader() {
    }
}
