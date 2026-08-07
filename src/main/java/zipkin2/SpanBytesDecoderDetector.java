package zipkin2;

import com.yubico.yubikit.core.fido.CtapException;
import java.nio.ByteBuffer;
import zipkin2.codec.BytesDecoder;
import zipkin2.codec.SpanBytesDecoder;

/* JADX INFO: loaded from: classes6.dex */
public final class SpanBytesDecoderDetector {
    static final byte[] ENDPOINT_FIELD_SUFFIX = {69, 110, 100, 112, 111, 105, 110, 116, CtapException.ERR_INVALID_CREDENTIAL};
    static final byte[] TAGS_FIELD = {CtapException.ERR_INVALID_CREDENTIAL, 116, 97, 103, 115, CtapException.ERR_INVALID_CREDENTIAL};

    public static BytesDecoder<Span> decoderForMessage(byte[] bArr) {
        BytesDecoder<Span> bytesDecoderDetectDecoder = detectDecoder(ByteBuffer.wrap(bArr));
        byte b = bArr[0];
        if (b == 12 || b == 91) {
            throw new IllegalArgumentException("Expected json or thrift object, not list encoding");
        }
        if (bytesDecoderDetectDecoder == SpanBytesDecoder.JSON_V2 || bytesDecoderDetectDecoder == SpanBytesDecoder.PROTO3) {
            throw new UnsupportedOperationException("v2 formats should only be used with list messages");
        }
        return bytesDecoderDetectDecoder;
    }

    public static BytesDecoder<Span> decoderForListMessage(byte[] bArr) {
        return decoderForListMessage(ByteBuffer.wrap(bArr));
    }

    public static BytesDecoder<Span> decoderForListMessage(ByteBuffer byteBuffer) {
        BytesDecoder<Span> bytesDecoderDetectDecoder = detectDecoder(byteBuffer);
        byte b = byteBuffer.get(byteBuffer.position());
        if (b == 12 || b == 11 || protobuf3(byteBuffer) || b == 91) {
            return bytesDecoderDetectDecoder;
        }
        throw new IllegalArgumentException("Expected json, proto3 or thrift list encoding");
    }

    static BytesDecoder<Span> detectDecoder(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get(byteBuffer.position());
        if (b <= 16) {
            return protobuf3(byteBuffer) ? SpanBytesDecoder.PROTO3 : SpanBytesDecoder.THRIFT;
        }
        if (b != 91 && b != 123) {
            throw new IllegalArgumentException("Could not detect the span format");
        }
        if (!contains(byteBuffer, ENDPOINT_FIELD_SUFFIX) && !contains(byteBuffer, TAGS_FIELD)) {
            return SpanBytesDecoder.JSON_V1;
        }
        return SpanBytesDecoder.JSON_V2;
    }

    static boolean contains(ByteBuffer byteBuffer, byte[] bArr) {
        for (int i = 0; i < (byteBuffer.remaining() - bArr.length) + 1; i++) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (byteBuffer.get(byteBuffer.position() + i + i2) != bArr[i2]) {
                }
            }
            return true;
        }
        return false;
    }

    static boolean protobuf3(ByteBuffer byteBuffer) {
        return byteBuffer.get(byteBuffer.position()) == 10 && byteBuffer.get(byteBuffer.position() + 1) != 0;
    }

    SpanBytesDecoderDetector() {
    }
}
