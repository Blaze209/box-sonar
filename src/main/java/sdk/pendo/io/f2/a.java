package sdk.pendo.io.f2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxIterator;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.s2.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\f\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0000H\u0002\u001a\"\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002\u001a0\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"", "b", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "input", "", "pos", BoxIterator.FIELD_LIMIT, "Ljava/net/InetAddress;", "", IDToken.ADDRESS, "addressOffset", "okhttp"}, k = 2, mv = {1, 8, 0})
public final class a {
    private static final boolean a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final String b(String str) {
        int length;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i = 0;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = ascii.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0 || a(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (StringsKt.startsWith$default(str, "[", false, 2, (Object) null) && StringsKt.endsWith$default(str, "]", false, 2, (Object) null)) {
            i = 1;
            length = str.length() - 1;
        } else {
            length = str.length();
        }
        InetAddress inetAddressA = a(str, i, length);
        if (inetAddressA == null) {
            return null;
        }
        byte[] address = inetAddressA.getAddress();
        if (address.length == 16) {
            Intrinsics.checkNotNullExpressionValue(address, "address");
            return a(address);
        }
        if (address.length == 4) {
            return inetAddressA.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }

    private static final boolean a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (Intrinsics.compare((int) cCharAt, 48) < 0 || Intrinsics.compare((int) cCharAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x0070 A[LOOP:1: B:30:0x0064->B:33:0x0070, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0076 A[EDGE_INSN: B:54:0x0076->B:34:0x0076 BREAK  A[LOOP:1: B:30:0x0064->B:33:0x0070], SYNTHETIC] */
    private static final InetAddress a(String str, int i, int i2) {
        int i3;
        int i4;
        int iA;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (i5 < i2) {
            if (i6 == 16) {
                return null;
            }
            int i9 = i5 + 2;
            if (i9 <= i2 && StringsKt.startsWith$default(str, "::", i5, false, 4, (Object) null)) {
                if (i7 != -1) {
                    return null;
                }
                i6 += 2;
                if (i9 == i2) {
                    i7 = i6;
                    break;
                }
                i7 = i6;
                i8 = i9;
                i3 = 0;
                i5 = i8;
                while (i5 < i2) {
                    iA = b.a(str.charAt(i5));
                    if (iA != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iA;
                    i5++;
                }
                i4 = i5 - i8;
                if (i4 != 0) {
                }
                return null;
            }
            if (i6 != 0) {
                if (!StringsKt.startsWith$default(str, ":", i5, false, 4, (Object) null)) {
                    if (!StringsKt.startsWith$default(str, ".", i5, false, 4, (Object) null) || !a(str, i8, i2, bArr, i6 - 2)) {
                        return null;
                    }
                    i6 += 2;
                    break;
                }
                i5++;
            }
            i8 = i5;
            i3 = 0;
            i5 = i8;
            while (i5 < i2) {
                iA = b.a(str.charAt(i5));
                if (iA != -1) {
                    break;
                }
                i3 = (i3 << 4) + iA;
                i5++;
            }
            i4 = i5 - i8;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i10 = i6 + 1;
            bArr[i6] = (byte) ((i3 >>> 8) & 255);
            i6 += 2;
            bArr[i10] = (byte) (i3 & 255);
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i11 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String a(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        d dVar = new d();
        while (i2 < bArr.length) {
            if (i2 == i) {
                dVar.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    dVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    dVar.writeByte(58);
                }
                dVar.writeHexadecimalUnsignedLong((b.a(bArr[i2], 255) << 8) | b.a(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return dVar.readUtf8();
    }
}
