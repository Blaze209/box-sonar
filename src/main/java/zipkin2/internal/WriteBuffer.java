package zipkin2.internal;

import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.work.WorkInfo;
import com.box.android.data.jobs.DownloadFileJobKt;
import com.google.common.base.Ascii;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes6.dex */
public final class WriteBuffer {
    final byte[] buf;
    int pos;

    public interface Writer<T> {
        int sizeInBytes(T t);

        void write(T t, WriteBuffer writeBuffer);
    }

    public static int asciiSizeInBytes(long j) {
        boolean z;
        int i;
        if (j == 0) {
            return 1;
        }
        if (j == Long.MIN_VALUE) {
            return 20;
        }
        if (j < 0) {
            j = -j;
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j < 100) {
                    i = j < 10 ? 1 : 2;
                } else {
                    i = j < 1000 ? 3 : 4;
                }
            } else if (j < 1000000) {
                i = j < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US ? 5 : 6;
            } else {
                i = j < DownloadFileJobKt.MIN_CHUNK_SIZE ? 7 : 8;
            }
        } else if (j < MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US) {
            if (j < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i = j < C.NANOS_PER_SECOND ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        return z ? i + 1 : i;
    }

    public static int varintSizeInBytes(int i) {
        if ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int varintSizeInBytes(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static WriteBuffer wrap(byte[] bArr) {
        return wrap(bArr, 0);
    }

    public static WriteBuffer wrap(byte[] bArr, int i) {
        return new WriteBuffer(bArr, i);
    }

    WriteBuffer(byte[] bArr, int i) {
        this.buf = bArr;
        this.pos = i;
    }

    public void writeByte(int i) {
        byte[] bArr = this.buf;
        int i2 = this.pos;
        this.pos = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void write(byte[] bArr) {
        System.arraycopy(bArr, 0, this.buf, this.pos, bArr.length);
        this.pos += bArr.length;
    }

    void writeBackwards(long j) {
        int iAsciiSizeInBytes = this.pos + asciiSizeInBytes(j);
        this.pos = iAsciiSizeInBytes;
        while (j != 0) {
            iAsciiSizeInBytes--;
            this.buf[iAsciiSizeInBytes] = (byte) HexCodec.HEX_DIGITS[(int) (j % 10)];
            j /= 10;
        }
    }

    public void writeLongHex(long j) {
        int i = this.pos;
        writeHexByte(this.buf, i, (byte) ((j >>> 56) & 255));
        writeHexByte(this.buf, i + 2, (byte) ((j >>> 48) & 255));
        writeHexByte(this.buf, i + 4, (byte) ((j >>> 40) & 255));
        writeHexByte(this.buf, i + 6, (byte) ((j >>> 32) & 255));
        writeHexByte(this.buf, i + 8, (byte) ((j >>> 24) & 255));
        writeHexByte(this.buf, i + 10, (byte) ((j >>> 16) & 255));
        writeHexByte(this.buf, i + 12, (byte) ((j >>> 8) & 255));
        writeHexByte(this.buf, i + 14, (byte) (j & 255));
        this.pos = i + 16;
    }

    static void writeHexByte(byte[] bArr, int i, byte b) {
        bArr[i] = (byte) HexCodec.HEX_DIGITS[(b >> 4) & 15];
        bArr[i + 1] = (byte) HexCodec.HEX_DIGITS[b & Ascii.SI];
    }

    final int pos() {
        return this.pos;
    }

    public void writeAscii(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            writeByte(str.charAt(i) & 255);
        }
    }

    public void writeUtf8(CharSequence charSequence) {
        int i;
        char cCharAt;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 < 128) {
                writeByte(cCharAt2);
                while (i2 < length - 1 && (cCharAt = charSequence.charAt((i = i2 + 1))) < 128) {
                    writeByte(cCharAt);
                    i2 = i;
                }
            } else if (cCharAt2 < 2048) {
                writeByte((cCharAt2 >> 6) | 192);
                writeByte((cCharAt2 & '?') | 128);
            } else {
                if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    writeByte((cCharAt2 >> '\f') | 224);
                    writeByte(((cCharAt2 >> 6) & 63) | 128);
                    writeByte((cCharAt2 & '?') | 128);
                } else if (!Character.isHighSurrogate(cCharAt2)) {
                    writeByte(63);
                } else {
                    if (i2 == length - 1) {
                        writeByte(63);
                        return;
                    }
                    i2++;
                    char cCharAt3 = charSequence.charAt(i2);
                    if (!Character.isLowSurrogate(cCharAt3)) {
                        writeByte(63);
                        writeByte(Character.isHighSurrogate(cCharAt3) ? '?' : cCharAt3);
                    } else {
                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                        writeByte((codePoint >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        writeByte(((codePoint >> 12) & 63) | 128);
                        writeByte(((codePoint >> 6) & 63) | 128);
                        writeByte((codePoint & 63) | 128);
                    }
                }
            }
            i2++;
        }
    }

    public void writeAscii(long j) {
        if (j == 0) {
            writeByte(48);
            return;
        }
        if (j == Long.MIN_VALUE) {
            writeAscii("-9223372036854775808");
            return;
        }
        if (j < 0) {
            writeByte(45);
            j = -j;
        }
        writeBackwards(j);
    }

    void writeVarint(int i) {
        while ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            writeByte((byte) ((i & 127) | 128));
            i >>>= 7;
        }
        writeByte((byte) i);
    }

    void writeVarint(long j) {
        while (((-128) & j) != 0) {
            writeByte((byte) ((127 & j) | 128));
            j >>>= 7;
        }
        writeByte((byte) j);
    }

    void writeLongLe(long j) {
        writeByte((byte) (j & 255));
        writeByte((byte) ((j >> 8) & 255));
        writeByte((byte) ((j >> 16) & 255));
        writeByte((byte) ((j >> 24) & 255));
        writeByte((byte) ((j >> 32) & 255));
        writeByte((byte) ((j >> 40) & 255));
        writeByte((byte) ((j >> 48) & 255));
        writeByte((byte) ((j >> 56) & 255));
    }

    public static int utf8SizeInBytes(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 128) {
                i2++;
                while (i < length - 1) {
                    int i3 = i + 1;
                    if (charSequence.charAt(i3) >= 128) {
                        break;
                    }
                    i2++;
                    i = i3;
                }
            } else if (cCharAt < 2048) {
                i2 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i2 += 3;
            } else {
                int i4 = i + 1;
                char cCharAt2 = i4 < length ? charSequence.charAt(i4) : (char) 0;
                if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                    i2++;
                } else {
                    i2 += 4;
                    i = i4;
                }
            }
            i++;
        }
        return i2;
    }
}
