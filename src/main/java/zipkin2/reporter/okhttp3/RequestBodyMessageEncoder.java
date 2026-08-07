package zipkin2.reporter.okhttp3;

import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import zipkin2.codec.Encoding;

/* JADX INFO: loaded from: classes6.dex */
enum RequestBodyMessageEncoder {
    JSON { // from class: zipkin2.reporter.okhttp3.RequestBodyMessageEncoder.1
        @Override // zipkin2.reporter.okhttp3.RequestBodyMessageEncoder
        public RequestBody encode(List<byte[]> list) {
            return new JsonRequestBody(list);
        }
    },
    THRIFT { // from class: zipkin2.reporter.okhttp3.RequestBodyMessageEncoder.2
        @Override // zipkin2.reporter.okhttp3.RequestBodyMessageEncoder
        RequestBody encode(List<byte[]> list) {
            return new ThriftRequestBody(list);
        }
    },
    PROTO3 { // from class: zipkin2.reporter.okhttp3.RequestBodyMessageEncoder.3
        @Override // zipkin2.reporter.okhttp3.RequestBodyMessageEncoder
        RequestBody encode(List<byte[]> list) {
            return new Protobuf3RequestBody(list);
        }
    };

    abstract RequestBody encode(List<byte[]> list);

    static abstract class StreamingRequestBody extends RequestBody {
        final long contentLength;
        final MediaType contentType;
        final List<byte[]> values;

        StreamingRequestBody(Encoding encoding, MediaType mediaType, List<byte[]> list) {
            this.contentType = mediaType;
            this.values = list;
            this.contentLength = encoding.listSizeInBytes(list);
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: contentType */
        public MediaType get$contentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.contentLength;
        }
    }

    static final class JsonRequestBody extends StreamingRequestBody {
        static final MediaType CONTENT_TYPE = MediaType.parse("application/json");

        JsonRequestBody(List<byte[]> list) {
            super(Encoding.JSON, CONTENT_TYPE, list);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.writeByte(91);
            int size = this.values.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                bufferedSink.write(this.values.get(i));
                if (i2 < size) {
                    bufferedSink.writeByte(44);
                }
                i = i2;
            }
            bufferedSink.writeByte(93);
        }
    }

    static final class ThriftRequestBody extends StreamingRequestBody {
        static final MediaType CONTENT_TYPE = MediaType.parse("application/x-thrift");

        ThriftRequestBody(List<byte[]> list) {
            super(Encoding.THRIFT, CONTENT_TYPE, list);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            int size = this.values.size();
            bufferedSink.writeByte(12);
            bufferedSink.writeByte((size >>> 24) & 255);
            bufferedSink.writeByte((size >>> 16) & 255);
            bufferedSink.writeByte((size >>> 8) & 255);
            bufferedSink.writeByte(size & 255);
            for (int i = 0; i < size; i++) {
                bufferedSink.write(this.values.get(i));
            }
        }
    }

    static final class Protobuf3RequestBody extends StreamingRequestBody {
        static final MediaType CONTENT_TYPE = MediaType.parse("application/x-protobuf");

        Protobuf3RequestBody(List<byte[]> list) {
            super(Encoding.PROTO3, CONTENT_TYPE, list);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            int size = this.values.size();
            for (int i = 0; i < size; i++) {
                bufferedSink.write(this.values.get(i));
            }
        }
    }
}
