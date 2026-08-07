package zipkin2.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Annotation;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
final class Proto3ZipkinFields {
    static final Logger LOG = Logger.getLogger(Proto3ZipkinFields.class.getName());
    static final SpanField SPAN = new SpanField();

    Proto3ZipkinFields() {
    }

    static class EndpointField extends Proto3Fields.LengthDelimitedField<Endpoint> {
        static final int IPV4_KEY = 18;
        static final int IPV6_KEY = 26;
        static final int PORT_KEY = 32;
        static final int SERVICE_NAME_KEY = 10;
        static final Proto3Fields.Utf8Field SERVICE_NAME = new Proto3Fields.Utf8Field(10);
        static final Proto3Fields.BytesField IPV4 = new Proto3Fields.BytesField(18);
        static final Proto3Fields.BytesField IPV6 = new Proto3Fields.BytesField(26);
        static final Proto3Fields.VarintField PORT = new Proto3Fields.VarintField(32);

        EndpointField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(Endpoint endpoint) {
            return SERVICE_NAME.sizeInBytes(endpoint.serviceName()) + IPV4.sizeInBytes(endpoint.ipv4Bytes()) + IPV6.sizeInBytes(endpoint.ipv6Bytes()) + PORT.sizeInBytes(endpoint.portAsInt());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, Endpoint endpoint) {
            SERVICE_NAME.write(writeBuffer, endpoint.serviceName());
            IPV4.write(writeBuffer, endpoint.ipv4Bytes());
            IPV6.write(writeBuffer, endpoint.ipv6Bytes());
            PORT.write(writeBuffer, endpoint.portAsInt());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public Endpoint readValue(ReadBuffer readBuffer, int i) {
            int iPos = readBuffer.pos() + i;
            Endpoint.Builder builderNewBuilder = Endpoint.newBuilder();
            while (readBuffer.pos() < iPos) {
                int varint32 = readBuffer.readVarint32();
                if (varint32 == 10) {
                    builderNewBuilder.serviceName(SERVICE_NAME.readLengthPrefixAndValue(readBuffer));
                } else if (varint32 == 18) {
                    builderNewBuilder.parseIp(IPV4.readLengthPrefixAndValue(readBuffer));
                } else if (varint32 == 26) {
                    builderNewBuilder.parseIp(IPV6.readLengthPrefixAndValue(readBuffer));
                } else if (varint32 == 32) {
                    builderNewBuilder.port(readBuffer.readVarint32());
                } else {
                    Proto3ZipkinFields.logAndSkip(readBuffer, varint32);
                }
            }
            return builderNewBuilder.build();
        }
    }

    static abstract class SpanBuilderField<T> extends Proto3Fields.LengthDelimitedField<T> {
        abstract boolean readLengthPrefixAndValue(ReadBuffer readBuffer, Span.Builder builder);

        SpanBuilderField(int i) {
            super(i);
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final T readValue(ReadBuffer readBuffer, int i) {
            throw new UnsupportedOperationException();
        }
    }

    static class AnnotationField extends SpanBuilderField<Annotation> {
        static final int TIMESTAMP_KEY = 9;
        static final int VALUE_KEY = 18;
        static final Proto3Fields.Fixed64Field TIMESTAMP = new Proto3Fields.Fixed64Field(9);
        static final Proto3Fields.Utf8Field VALUE = new Proto3Fields.Utf8Field(18);

        AnnotationField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(Annotation annotation) {
            return TIMESTAMP.sizeInBytes(annotation.timestamp()) + VALUE.sizeInBytes(annotation.value());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, Annotation annotation) {
            TIMESTAMP.write(writeBuffer, annotation.timestamp());
            VALUE.write(writeBuffer, annotation.value());
        }

        @Override // zipkin2.internal.Proto3ZipkinFields.SpanBuilderField
        boolean readLengthPrefixAndValue(ReadBuffer readBuffer, Span.Builder builder) {
            int varint32 = readBuffer.readVarint32();
            if (varint32 == 0) {
                return false;
            }
            int iPos = readBuffer.pos() + varint32;
            String lengthPrefixAndValue = null;
            long value = 0;
            while (readBuffer.pos() < iPos) {
                int varint33 = readBuffer.readVarint32();
                if (varint33 == 9) {
                    value = TIMESTAMP.readValue(readBuffer);
                } else if (varint33 == 18) {
                    lengthPrefixAndValue = VALUE.readLengthPrefixAndValue(readBuffer);
                } else {
                    Proto3ZipkinFields.logAndSkip(readBuffer, varint33);
                }
            }
            if (value == 0 || lengthPrefixAndValue == null) {
                return false;
            }
            builder.addAnnotation(value, lengthPrefixAndValue);
            return true;
        }
    }

    static final class TagField extends SpanBuilderField<Map.Entry<String, String>> {
        static final int KEY_KEY = 10;
        static final int VALUE_KEY = 18;
        static final Proto3Fields.Utf8Field KEY = new Proto3Fields.Utf8Field(10);
        static final Proto3Fields.Utf8Field VALUE = new Proto3Fields.Utf8Field(18);

        TagField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(Map.Entry<String, String> entry) {
            return KEY.sizeInBytes(entry.getKey()) + VALUE.sizeInBytes(entry.getValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, Map.Entry<String, String> entry) {
            KEY.write(writeBuffer, entry.getKey());
            VALUE.write(writeBuffer, entry.getValue());
        }

        @Override // zipkin2.internal.Proto3ZipkinFields.SpanBuilderField
        boolean readLengthPrefixAndValue(ReadBuffer readBuffer, Span.Builder builder) {
            int varint32 = readBuffer.readVarint32();
            if (varint32 == 0) {
                return false;
            }
            int iPos = readBuffer.pos() + varint32;
            String lengthPrefixAndValue = null;
            String str = "";
            while (readBuffer.pos() < iPos) {
                int varint33 = readBuffer.readVarint32();
                if (varint33 == 10) {
                    lengthPrefixAndValue = KEY.readLengthPrefixAndValue(readBuffer);
                } else if (varint33 == 18) {
                    String lengthPrefixAndValue2 = VALUE.readLengthPrefixAndValue(readBuffer);
                    if (lengthPrefixAndValue2 != null) {
                        str = lengthPrefixAndValue2;
                    }
                } else {
                    Proto3ZipkinFields.logAndSkip(readBuffer, varint33);
                }
            }
            if (lengthPrefixAndValue == null) {
                return false;
            }
            builder.putTag(lengthPrefixAndValue, str);
            return true;
        }
    }

    static class SpanField extends Proto3Fields.LengthDelimitedField<Span> {
        static final int ANNOTATION_KEY = 82;
        static final int DEBUG_KEY = 96;
        static final int DURATION_KEY = 56;
        static final int ID_KEY = 26;
        static final int KIND_KEY = 32;
        static final int LOCAL_ENDPOINT_KEY = 66;
        static final int NAME_KEY = 42;
        static final int PARENT_ID_KEY = 18;
        static final int REMOTE_ENDPOINT_KEY = 74;
        static final int SHARED_KEY = 104;
        static final int TAG_KEY = 90;
        static final int TIMESTAMP_KEY = 49;
        static final int TRACE_ID_KEY = 10;
        static final Proto3Fields.HexField TRACE_ID = new Proto3Fields.HexField(10);
        static final Proto3Fields.HexField PARENT_ID = new Proto3Fields.HexField(18);
        static final Proto3Fields.HexField ID = new Proto3Fields.HexField(26);
        static final Proto3Fields.VarintField KIND = new Proto3Fields.VarintField(32);
        static final Proto3Fields.Utf8Field NAME = new Proto3Fields.Utf8Field(42);
        static final Proto3Fields.Fixed64Field TIMESTAMP = new Proto3Fields.Fixed64Field(49);
        static final Proto3Fields.VarintField DURATION = new Proto3Fields.VarintField(56);
        static final EndpointField LOCAL_ENDPOINT = new EndpointField(66);
        static final EndpointField REMOTE_ENDPOINT = new EndpointField(74);
        static final AnnotationField ANNOTATION = new AnnotationField(82);
        static final TagField TAG = new TagField(90);
        static final Proto3Fields.BooleanField DEBUG = new Proto3Fields.BooleanField(96);
        static final Proto3Fields.BooleanField SHARED = new Proto3Fields.BooleanField(104);

        SpanField() {
            super(10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(Span span) {
            int iSizeInBytes = TRACE_ID.sizeInBytes(span.traceId()) + PARENT_ID.sizeInBytes(span.parentId()) + ID.sizeInBytes(span.id()) + KIND.sizeInBytes(span.kind() != null ? 1 : 0) + NAME.sizeInBytes(span.name()) + TIMESTAMP.sizeInBytes(span.timestampAsLong()) + DURATION.sizeInBytes(span.durationAsLong()) + LOCAL_ENDPOINT.sizeInBytes(span.localEndpoint()) + REMOTE_ENDPOINT.sizeInBytes(span.remoteEndpoint());
            List<Annotation> listAnnotations = span.annotations();
            int size = listAnnotations.size();
            for (int i = 0; i < size; i++) {
                iSizeInBytes += ANNOTATION.sizeInBytes(listAnnotations.get(i));
            }
            Map<String, String> mapTags = span.tags();
            if (mapTags.size() > 0) {
                Iterator<Map.Entry<String, String>> it = mapTags.entrySet().iterator();
                while (it.hasNext()) {
                    iSizeInBytes += TAG.sizeInBytes(it.next());
                }
            }
            return iSizeInBytes + DEBUG.sizeInBytes(Boolean.TRUE.equals(span.debug())) + SHARED.sizeInBytes(Boolean.TRUE.equals(span.shared()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, Span span) {
            TRACE_ID.write(writeBuffer, span.traceId());
            PARENT_ID.write(writeBuffer, span.parentId());
            ID.write(writeBuffer, span.id());
            KIND.write(writeBuffer, toByte(span.kind()));
            NAME.write(writeBuffer, span.name());
            TIMESTAMP.write(writeBuffer, span.timestampAsLong());
            DURATION.write(writeBuffer, span.durationAsLong());
            LOCAL_ENDPOINT.write(writeBuffer, span.localEndpoint());
            REMOTE_ENDPOINT.write(writeBuffer, span.remoteEndpoint());
            List<Annotation> listAnnotations = span.annotations();
            int size = listAnnotations.size();
            for (int i = 0; i < size; i++) {
                ANNOTATION.write(writeBuffer, listAnnotations.get(i));
            }
            Map<String, String> mapTags = span.tags();
            if (!mapTags.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = mapTags.entrySet().iterator();
                while (it.hasNext()) {
                    TAG.write(writeBuffer, it.next());
                }
            }
            DEBUG.write(writeBuffer, Boolean.TRUE.equals(span.debug()));
            SHARED.write(writeBuffer, Boolean.TRUE.equals(span.shared()));
        }

        int toByte(Span.Kind kind) {
            if (kind != null) {
                return kind.ordinal() + 1;
            }
            return 0;
        }

        public Span read(ReadBuffer readBuffer) {
            readBuffer.readVarint32();
            return readLengthPrefixAndValue(readBuffer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public Span readValue(ReadBuffer readBuffer, int i) {
            readBuffer.require(i);
            int iPos = readBuffer.pos() + i;
            Span.Builder builderNewBuilder = Span.newBuilder();
            while (readBuffer.pos() < iPos) {
                int varint32 = readBuffer.readVarint32();
                switch (varint32) {
                    case 10:
                        builderNewBuilder.traceId(TRACE_ID.readLengthPrefixAndValue(readBuffer));
                        break;
                    case 18:
                        builderNewBuilder.parentId(PARENT_ID.readLengthPrefixAndValue(readBuffer));
                        break;
                    case 26:
                        builderNewBuilder.id(ID.readLengthPrefixAndValue(readBuffer));
                        break;
                    case 32:
                        int varint33 = readBuffer.readVarint32();
                        if (varint33 != 0 && varint33 <= Span.Kind.values().length) {
                            builderNewBuilder.kind(Span.Kind.values()[varint33 - 1]);
                        }
                        break;
                    case 42:
                        builderNewBuilder.name(NAME.readLengthPrefixAndValue(readBuffer));
                        break;
                    case 49:
                        builderNewBuilder.timestamp(TIMESTAMP.readValue(readBuffer));
                        break;
                    case 56:
                        builderNewBuilder.duration(readBuffer.readVarint64());
                        break;
                    case 66:
                        builderNewBuilder.localEndpoint(LOCAL_ENDPOINT.readLengthPrefixAndValue(readBuffer));
                        break;
                    case 74:
                        builderNewBuilder.remoteEndpoint(REMOTE_ENDPOINT.readLengthPrefixAndValue(readBuffer));
                        break;
                    case 82:
                        ANNOTATION.readLengthPrefixAndValue(readBuffer, builderNewBuilder);
                        break;
                    case 90:
                        TAG.readLengthPrefixAndValue(readBuffer, builderNewBuilder);
                        break;
                    case 96:
                        if (DEBUG.read(readBuffer)) {
                            builderNewBuilder.debug(true);
                        }
                        break;
                    case 104:
                        if (SHARED.read(readBuffer)) {
                            builderNewBuilder.shared(true);
                        }
                        break;
                    default:
                        Proto3ZipkinFields.logAndSkip(readBuffer, varint32);
                        break;
                }
            }
            return builderNewBuilder.build();
        }
    }

    static void logAndSkip(ReadBuffer readBuffer, int i) {
        int iWireType = Proto3Fields.Field.wireType(i, readBuffer.pos());
        Logger logger = LOG;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("Skipping field: byte=%s, fieldNumber=%s, wireType=%s", Integer.valueOf(readBuffer.pos()), Integer.valueOf(Proto3Fields.Field.fieldNumber(i, readBuffer.pos())), Integer.valueOf(iWireType)));
        }
        Proto3Fields.Field.skipValue(readBuffer, iWireType);
    }
}
