package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.exporter.internal.marshal.Marshaler;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: loaded from: classes4.dex */
public final class GrpcRequestBody extends RequestBody {
    private static final byte COMPRESSED_FLAG = 1;
    private static final MediaType GRPC_MEDIA_TYPE = MediaType.parse("application/grpc");
    private static final int HEADER_LENGTH = 5;
    private static final byte UNCOMPRESSED_FLAG = 0;
    private final boolean compressed;
    private final int contentLength;
    private final Marshaler marshaler;
    private final int messageSize;

    public GrpcRequestBody(Marshaler marshaler, boolean z) {
        this.marshaler = marshaler;
        this.compressed = z;
        int binarySerializedSize = marshaler.getBinarySerializedSize();
        this.messageSize = binarySerializedSize;
        if (z) {
            this.contentLength = -1;
        } else {
            this.contentLength = binarySerializedSize + 5;
        }
    }

    @Override // okhttp3.RequestBody
    @Nullable
    /* JADX INFO: renamed from: contentType */
    public MediaType getMediaType() {
        return GRPC_MEDIA_TYPE;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (!this.compressed) {
            bufferedSink.writeByte(0);
            bufferedSink.writeInt(this.messageSize);
            this.marshaler.writeBinaryTo(bufferedSink.outputStream());
            return;
        }
        Buffer buffer = new Buffer();
        try {
            BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(buffer));
            try {
                this.marshaler.writeBinaryTo(bufferedSinkBuffer.outputStream());
                if (bufferedSinkBuffer != null) {
                    bufferedSinkBuffer.close();
                }
                bufferedSink.writeByte(1);
                int size = (int) buffer.size();
                bufferedSink.writeInt(size);
                bufferedSink.write(buffer, size);
                buffer.close();
            } catch (Throwable th) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                buffer.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }
}
