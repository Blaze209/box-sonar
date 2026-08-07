package zipkin2.codec;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.Span;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.Proto3Codec;
import zipkin2.internal.ReadBuffer;
import zipkin2.internal.ThriftCodec;
import zipkin2.internal.V1JsonSpanReader;
import zipkin2.internal.V2SpanReader;
import zipkin2.v1.V1Span;
import zipkin2.v1.V1SpanConverter;

/* JADX INFO: loaded from: classes6.dex */
public enum SpanBytesDecoder implements BytesDecoder<Span> {
    JSON_V1 { // from class: zipkin2.codec.SpanBytesDecoder.1
        @Override // zipkin2.codec.BytesDecoder
        public Encoding encoding() {
            return Encoding.JSON;
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decode(byte[] bArr, Collection<Span> collection) {
            Span spanDecodeOne = decodeOne(ReadBuffer.wrap(bArr));
            if (spanDecodeOne == null) {
                return false;
            }
            collection.add(spanDecodeOne);
            return true;
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return new V1JsonSpanReader().readList(ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return new V1JsonSpanReader().readList(ReadBuffer.wrapUnsafe(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public Span decodeOne(byte[] bArr) {
            return decodeOne(ReadBuffer.wrap(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public Span decodeOne(ByteBuffer byteBuffer) {
            return decodeOne(ReadBuffer.wrapUnsafe(byteBuffer));
        }

        Span decodeOne(ReadBuffer readBuffer) {
            V1Span v1Span = (V1Span) JsonCodec.readOne(new V1JsonSpanReader(), readBuffer);
            ArrayList arrayList = new ArrayList(1);
            V1SpanConverter.create().convert(v1Span, arrayList);
            return (Span) arrayList.get(0);
        }

        @Override // zipkin2.codec.BytesDecoder
        public List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    },
    THRIFT { // from class: zipkin2.codec.SpanBytesDecoder.2
        @Override // zipkin2.codec.BytesDecoder
        public Encoding encoding() {
            return Encoding.THRIFT;
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decode(byte[] bArr, Collection<Span> collection) {
            return ThriftCodec.read(ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return ThriftCodec.readList(ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return ThriftCodec.readList(ReadBuffer.wrapUnsafe(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public Span decodeOne(byte[] bArr) {
            return ThriftCodec.readOne(ReadBuffer.wrap(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public Span decodeOne(ByteBuffer byteBuffer) {
            return ThriftCodec.readOne(ReadBuffer.wrapUnsafe(byteBuffer));
        }

        @Override // zipkin2.codec.BytesDecoder
        public List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    },
    JSON_V2 { // from class: zipkin2.codec.SpanBytesDecoder.3
        @Override // zipkin2.codec.BytesDecoder
        public Encoding encoding() {
            return Encoding.JSON;
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decode(byte[] bArr, Collection<Span> collection) {
            return JsonCodec.read(new V2SpanReader(), ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return JsonCodec.readList(new V2SpanReader(), ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return JsonCodec.readList(new V2SpanReader(), ReadBuffer.wrapUnsafe(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public Span decodeOne(byte[] bArr) {
            return (Span) JsonCodec.readOne(new V2SpanReader(), ReadBuffer.wrap(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public Span decodeOne(ByteBuffer byteBuffer) {
            return (Span) JsonCodec.readOne(new V2SpanReader(), ReadBuffer.wrapUnsafe(byteBuffer));
        }

        @Override // zipkin2.codec.BytesDecoder
        public List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    },
    PROTO3 { // from class: zipkin2.codec.SpanBytesDecoder.4
        @Override // zipkin2.codec.BytesDecoder
        public Encoding encoding() {
            return Encoding.PROTO3;
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decode(byte[] bArr, Collection<Span> collection) {
            return Proto3Codec.read(ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return Proto3Codec.readList(ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return Proto3Codec.readList(ReadBuffer.wrapUnsafe(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public Span decodeOne(byte[] bArr) {
            return Proto3Codec.readOne(ReadBuffer.wrap(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public Span decodeOne(ByteBuffer byteBuffer) {
            return Proto3Codec.readOne(ReadBuffer.wrapUnsafe(byteBuffer));
        }

        @Override // zipkin2.codec.BytesDecoder
        public List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    };

    public abstract List<Span> decodeList(ByteBuffer byteBuffer);

    public abstract boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection);

    @Nullable
    public abstract Span decodeOne(ByteBuffer byteBuffer);

    static List<Span> doDecodeList(SpanBytesDecoder spanBytesDecoder, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        spanBytesDecoder.decodeList(bArr, arrayList);
        return arrayList;
    }

    static List<Span> doDecodeList(SpanBytesDecoder spanBytesDecoder, ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        spanBytesDecoder.decodeList(byteBuffer, arrayList);
        return arrayList;
    }
}
