package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0000H&J\b\u0010\u001c\u001a\u00020\u0000H&R\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0082\u0001\u0002\u001d!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lsdk/pendo/io/s2/e;", "Lsdk/pendo/io/s2/y;", "Ljava/nio/channels/WritableByteChannel;", "Lsdk/pendo/io/s2/g;", "byteString", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "source", "write", "", "offset", "byteCount", "", "string", "writeUtf8", "b", "writeByte", "s", "writeShort", "i", "writeInt", "", "v", "writeDecimalLong", "writeHexadecimalUnsignedLong", "", "flush", "emit", "emitCompleteSegments", "Lsdk/pendo/io/s2/d;", "getBuffer", "()Lokio/Buffer;", "buffer", "Lsdk/pendo/io/s2/t;", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public interface e extends y, WritableByteChannel {
    e a(g byteString);

    e emit();

    e emitCompleteSegments();

    @Override // sdk.pendo.io.s2.y, java.io.Flushable
    void flush();

    d getBuffer();

    e write(byte[] source);

    e write(byte[] source, int offset, int byteCount);

    e writeByte(int b);

    e writeDecimalLong(long v);

    e writeHexadecimalUnsignedLong(long v);

    e writeInt(int i);

    e writeShort(int s);

    e writeUtf8(String string);
}
