package sdk.pendo.io.v7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lsdk/pendo/io/v7/b;", "", "", "data", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final byte[] b(byte[] data) {
        int length = data.length;
        int i = ((length + 72) / 64) * 64;
        byte[] bArr = new byte[i];
        System.arraycopy(data, 0, bArr, 0, length);
        bArr[length] = -128;
        long j = ((long) length) * 8;
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[(i - 1) - i2] = (byte) (j >>> (i2 * 8));
        }
        return bArr;
    }

    public final byte[] a(byte[] data) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrB = b(data);
        int i4 = 80;
        int[] iArr = new int[80];
        int i5 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, bArrB.length - 1, 64);
        int i6 = 1732584193;
        int i7 = -271733879;
        int i8 = -1732584194;
        int i9 = 271733878;
        int i10 = -1009589776;
        if (progressionLastElement >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i5;
                while (true) {
                    if (i12 >= 16) {
                        break;
                    }
                    int i13 = (i12 * 4) + i11;
                    iArr[i12] = ((bArrB[i13 + 1] & 255) << 16) | ((bArrB[i13] & 255) << 24) | ((bArrB[i13 + 2] & 255) << 8) | (bArrB[i13 + 3] & 255);
                    i12++;
                }
                for (i = 16; i < i4; i++) {
                    int i14 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                    iArr[i] = (i14 >>> 31) | (i14 << 1);
                }
                int i15 = i6;
                int i16 = i7;
                int i17 = i8;
                int i18 = i9;
                int i19 = i10;
                int i20 = 0;
                while (i20 < i4) {
                    if (i20 >= 0 && i20 < 20) {
                        i2 = (i16 & i17) | ((~i16) & i18);
                        i3 = 1518500249;
                    } else if (20 <= i20 && i20 < 40) {
                        i2 = (i16 ^ i17) ^ i18;
                        i3 = 1859775393;
                    } else if (40 > i20 || i20 >= 60) {
                        i2 = (i16 ^ i17) ^ i18;
                        i3 = -899497514;
                    } else {
                        i2 = ((i17 | i18) & i16) | (i17 & i18);
                        i3 = -1894007588;
                    }
                    int i21 = ((i15 << 5) | (i15 >>> 27)) + i2 + i19 + i3 + iArr[i20];
                    int i22 = (i16 << 30) | (i16 >>> 2);
                    i20++;
                    i16 = i15;
                    i19 = i18;
                    i15 = i21;
                    i18 = i17;
                    i17 = i22;
                    i4 = 80;
                }
                i6 += i15;
                i7 += i16;
                i8 += i17;
                i9 += i18;
                i10 += i19;
                if (i11 == progressionLastElement) {
                    break;
                }
                i11 += 64;
                i4 = 80;
                i5 = 0;
            }
        }
        byte[] bArr = new byte[20];
        int[] iArr2 = {i6, i7, i8, i9, i10};
        for (int i23 = 0; i23 < 5; i23++) {
            int i24 = i23 * 4;
            int i25 = iArr2[i23];
            bArr[i24] = (byte) (i25 >>> 24);
            bArr[i24 + 1] = (byte) (i25 >>> 16);
            bArr[i24 + 2] = (byte) (i25 >>> 8);
            bArr[i24 + 3] = (byte) i25;
        }
        return bArr;
    }
}
