package org.apache.hc.core5.util;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class ByteArrayBuffer implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;
    private byte[] array;
    private int len;

    public ByteArrayBuffer(int i) {
        Args.notNegative(i, "Buffer capacity");
        this.array = new byte[i];
    }

    private void expand(int i) {
        byte[] bArr = new byte[Math.max(this.array.length << 1, i)];
        System.arraycopy(this.array, 0, bArr, 0, this.len);
        this.array = bArr;
    }

    public void append(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null) {
            return;
        }
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.len + i2;
        if (i4 > this.array.length) {
            expand(i4);
        }
        System.arraycopy(bArr, i, this.array, this.len, i2);
        this.len = i4;
    }

    public void append(int i) {
        int i2 = this.len + 1;
        if (i2 > this.array.length) {
            expand(i2);
        }
        this.array[this.len] = (byte) i;
        this.len = i2;
    }

    public void append(char[] cArr, int i, int i2) {
        int i3;
        if (cArr == null) {
            return;
        }
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > cArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.len;
        int i5 = i2 + i4;
        if (i5 > this.array.length) {
            expand(i5);
        }
        while (i4 < i5) {
            this.array[i4] = TextUtils.castAsByte(cArr[i]);
            i++;
            i4++;
        }
        this.len = i5;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i, int i2) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.array(), i, i2);
    }

    public void append(ByteBuffer byteBuffer) {
        int iRemaining;
        if (byteBuffer != null && (iRemaining = byteBuffer.remaining()) > 0) {
            int i = this.len + iRemaining;
            if (i > this.array.length) {
                expand(i);
            }
            byteBuffer.get(this.array, this.len, iRemaining);
            this.len = i;
        }
    }

    public void clear() {
        this.len = 0;
    }

    public byte[] toByteArray() {
        int i = this.len;
        byte[] bArr = new byte[i];
        if (i > 0) {
            System.arraycopy(this.array, 0, bArr, 0, i);
        }
        return bArr;
    }

    public int byteAt(int i) {
        return this.array[i];
    }

    public int capacity() {
        return this.array.length;
    }

    public int length() {
        return this.len;
    }

    public void ensureCapacity(int i) {
        if (i <= 0) {
            return;
        }
        int length = this.array.length;
        int i2 = this.len;
        if (i > length - i2) {
            expand(i2 + i);
        }
    }

    public byte[] array() {
        return this.array;
    }

    public void setLength(int i) {
        if (i < 0 || i > this.array.length) {
            throw new IndexOutOfBoundsException("len: " + i + " < 0 or > buffer len: " + this.array.length);
        }
        this.len = i;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.array.length;
    }

    public int indexOf(byte b, int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        int i3 = this.len;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i > i2) {
            return -1;
        }
        while (i < i2) {
            if (this.array[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int indexOf(byte b) {
        return indexOf(b, 0, this.len);
    }
}
