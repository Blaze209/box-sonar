package zipkin2.internal;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ReadBuffer extends InputStream {
    @Override // java.io.InputStream
    public abstract int available();

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    abstract String doReadUtf8(int i);

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    abstract int pos();

    @Override // java.io.InputStream
    public abstract int read(byte[] bArr, int i, int i2);

    abstract byte readByteUnsafe();

    abstract byte[] readBytes(int i);

    abstract int readInt();

    abstract long readLong();

    abstract long readLongLe();

    abstract short readShort();

    @Override // java.io.InputStream
    public abstract long skip(long j);

    abstract boolean tryReadAscii(char[] cArr, int i);

    public static ReadBuffer wrapUnsafe(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
            return new BigEndianByteBuffer(byteBuffer);
        }
        return new LittleEndianByteBuffer(byteBuffer);
    }

    public static ReadBuffer wrap(byte[] bArr) {
        return wrap(bArr, 0, bArr.length);
    }

    public static ReadBuffer wrap(byte[] bArr, int i, int i2) {
        return new Array(bArr, i, i2);
    }

    static final class BigEndianByteBuffer extends Buff {
        BigEndianByteBuffer(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        @Override // zipkin2.internal.ReadBuffer
        short readShort() {
            require(2);
            return this.buf.getShort();
        }

        @Override // zipkin2.internal.ReadBuffer
        int readInt() {
            require(4);
            return this.buf.getInt();
        }

        @Override // zipkin2.internal.ReadBuffer
        long readLong() {
            require(8);
            return this.buf.getLong();
        }

        @Override // zipkin2.internal.ReadBuffer
        long readLongLe() {
            return Long.reverseBytes(readLong());
        }
    }

    static final class LittleEndianByteBuffer extends Buff {
        LittleEndianByteBuffer(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        @Override // zipkin2.internal.ReadBuffer
        short readShort() {
            require(2);
            return Short.reverseBytes(this.buf.getShort());
        }

        @Override // zipkin2.internal.ReadBuffer
        int readInt() {
            require(4);
            return Integer.reverseBytes(this.buf.getInt());
        }

        @Override // zipkin2.internal.ReadBuffer
        long readLong() {
            return Long.reverseBytes(readLongLe());
        }

        @Override // zipkin2.internal.ReadBuffer
        long readLongLe() {
            require(8);
            return this.buf.getLong();
        }
    }

    static abstract class Buff extends ReadBuffer {
        final ByteBuffer buf;

        Buff(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte readByteUnsafe() {
            return this.buf.get();
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte[] readBytes(int i) {
            require(i);
            byte[] bArr = new byte[i];
            this.buf.get(bArr);
            return bArr;
        }

        @Override // zipkin2.internal.ReadBuffer
        boolean tryReadAscii(char[] cArr, int i) {
            this.buf.mark();
            for (int i2 = 0; i2 < i; i2++) {
                byte b = this.buf.get();
                if ((b & 128) != 0) {
                    this.buf.reset();
                    return false;
                }
                cArr[i2] = (char) b;
            }
            return true;
        }

        @Override // zipkin2.internal.ReadBuffer
        final String doReadUtf8(int i) {
            return new String(readBytes(i), JsonCodec.UTF_8);
        }

        @Override // zipkin2.internal.ReadBuffer
        public int pos() {
            return this.buf.position();
        }

        @Override // zipkin2.internal.ReadBuffer, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (available() == 0) {
                return -1;
            }
            int iCheckReadArguments = checkReadArguments(bArr, i, i2);
            if (iCheckReadArguments == 0) {
                return 0;
            }
            this.buf.get(bArr, i, iCheckReadArguments);
            return iCheckReadArguments;
        }

        @Override // zipkin2.internal.ReadBuffer, java.io.InputStream
        public long skip(long j) {
            int iMax = Math.max(available(), (int) j);
            ByteBuffer byteBuffer = this.buf;
            byteBuffer.position(byteBuffer.position() + iMax);
            return iMax;
        }

        @Override // zipkin2.internal.ReadBuffer, java.io.InputStream
        public int available() {
            return this.buf.remaining();
        }
    }

    static final class Array extends ReadBuffer {
        int arrayOffset;
        final byte[] buf;
        int length;
        int offset;

        Array(byte[] bArr, int i, int i2) {
            this.buf = bArr;
            this.offset = i;
            this.arrayOffset = i;
            this.length = i2;
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte readByteUnsafe() {
            byte[] bArr = this.buf;
            int i = this.offset;
            this.offset = i + 1;
            return bArr[i];
        }

        @Override // zipkin2.internal.ReadBuffer
        final byte[] readBytes(int i) {
            require(i);
            byte[] bArr = new byte[i];
            System.arraycopy(this.buf, this.offset, bArr, 0, i);
            this.offset += i;
            return bArr;
        }

        @Override // zipkin2.internal.ReadBuffer, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (available() == 0) {
                return -1;
            }
            int iCheckReadArguments = checkReadArguments(bArr, i, i2);
            if (iCheckReadArguments == 0) {
                return 0;
            }
            System.arraycopy(this.buf, this.offset, bArr, 0, iCheckReadArguments);
            this.offset += iCheckReadArguments;
            return iCheckReadArguments;
        }

        @Override // zipkin2.internal.ReadBuffer
        boolean tryReadAscii(char[] cArr, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                byte b = this.buf[this.offset + i2];
                if ((b & 128) != 0) {
                    return false;
                }
                cArr[i2] = (char) b;
            }
            this.offset += i;
            return true;
        }

        @Override // zipkin2.internal.ReadBuffer
        final String doReadUtf8(int i) {
            String str = new String(this.buf, this.offset, i, JsonCodec.UTF_8);
            this.offset += i;
            return str;
        }

        @Override // zipkin2.internal.ReadBuffer
        short readShort() {
            require(2);
            byte[] bArr = this.buf;
            int i = this.offset;
            int i2 = i + 1;
            this.offset = i2;
            int i3 = (bArr[i] & 255) << 8;
            this.offset = i + 2;
            return (short) ((bArr[i2] & 255) | i3);
        }

        @Override // zipkin2.internal.ReadBuffer
        int readInt() {
            require(4);
            int i = this.offset;
            this.offset = i + 4;
            byte[] bArr = this.buf;
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }

        @Override // zipkin2.internal.ReadBuffer
        long readLong() {
            return Long.reverseBytes(readLongLe());
        }

        @Override // zipkin2.internal.ReadBuffer
        long readLongLe() {
            require(8);
            int i = this.offset;
            this.offset = i + 8;
            byte[] bArr = this.buf;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        @Override // zipkin2.internal.ReadBuffer
        public int pos() {
            return this.offset - this.arrayOffset;
        }

        @Override // zipkin2.internal.ReadBuffer, java.io.InputStream
        public long skip(long j) {
            int iMin = Math.min(available(), (int) j);
            this.offset += iMin;
            return iMin;
        }

        @Override // zipkin2.internal.ReadBuffer, java.io.InputStream
        public int available() {
            return this.length - (this.offset - this.arrayOffset);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    final byte readByte() {
        require(1);
        return readByteUnsafe();
    }

    final String readUtf8(int i) {
        if (i == 0) {
            return "";
        }
        require(i);
        if (i > 256) {
            return doReadUtf8(i);
        }
        char[] cArrShortStringBuffer = RecyclableBuffers.shortStringBuffer();
        if (tryReadAscii(cArrShortStringBuffer, i)) {
            return new String(cArrShortStringBuffer, 0, i);
        }
        return doReadUtf8(i);
    }

    @Override // java.io.InputStream
    public final int read() {
        if (available() > 0) {
            return readByteUnsafe();
        }
        return -1;
    }

    final String readBytesAsHex(int i) {
        if (i > 32) {
            throw new IllegalArgumentException("hex field greater than 32 chars long: " + i);
        }
        require(i);
        char[] cArrShortStringBuffer = RecyclableBuffers.shortStringBuffer();
        int i2 = i * 2;
        for (int i3 = 0; i3 < i2; i3 += 2) {
            byte byteUnsafe = readByteUnsafe();
            cArrShortStringBuffer[i3] = HexCodec.HEX_DIGITS[(byteUnsafe >> 4) & 15];
            cArrShortStringBuffer[i3 + 1] = HexCodec.HEX_DIGITS[byteUnsafe & Ascii.SI];
        }
        return new String(cArrShortStringBuffer, 0, i2);
    }

    final int readVarint32() {
        int i;
        byte b = readByte();
        if (b >= 0) {
            return b;
        }
        int i2 = b & 127;
        byte b2 = readByte();
        if (b2 >= 0) {
            i = b2 << 7;
        } else {
            i2 |= (b2 & 127) << 7;
            byte b3 = readByte();
            if (b3 >= 0) {
                i = b3 << Ascii.SO;
            } else {
                i2 |= (b3 & 127) << 14;
                byte b4 = readByte();
                if (b4 >= 0) {
                    i = b4 << 21;
                } else {
                    i2 |= (b4 & 127) << 21;
                    byte b5 = readByte();
                    if ((b5 & CtapException.ERR_VENDOR_FIRST) != 0) {
                        throw new IllegalArgumentException("Greater than 32-bit varint at position " + (pos() - 1));
                    }
                    i = b5 << Ascii.FS;
                }
            }
        }
        return i | i2;
    }

    final long readVarint64() {
        byte b = readByte();
        if (b >= 0) {
            return b;
        }
        long j = b & 127;
        for (int i = 1; b < 0 && i < 10; i++) {
            b = readByte();
            if (i == 9 && (b & CtapException.ERR_VENDOR_FIRST) != 0) {
                throw new IllegalArgumentException("Greater than 64-bit varint at position " + (pos() - 1));
            }
            j |= ((long) (b & 127)) << (i * 7);
        }
        return j;
    }

    final void require(int i) {
        if (available() < i) {
            throw new IllegalArgumentException("Truncated: length " + i + " > bytes available " + available());
        }
    }

    int checkReadArguments(byte[] bArr, int i, int i2) {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        return Math.min(available(), i2);
    }
}
