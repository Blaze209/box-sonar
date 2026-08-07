package sdk.pendo.io.j5;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static int[] a;
    private static int b;
    private static int c;

    /* JADX INFO: renamed from: sdk.pendo.io.j5.a$a, reason: collision with other inner class name */
    public static class C0402a {
        public boolean a = true;
    }

    private static boolean a(int i, boolean z) throws b {
        if (i < 55296 || i > 57343) {
            return true;
        }
        if (z) {
            throw new b("Lone surrogate U+" + Integer.toHexString(i).toUpperCase(Locale.US) + " is not a scalar value");
        }
        return false;
    }

    public static String b(String str, C0402a c0402a) {
        boolean z = c0402a.a;
        int[] iArrA = a(str);
        int length = iArrA.length;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (true) {
            i++;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(b(iArrA[i], z));
        }
    }

    private static char[] a(int i, int i2) {
        return Character.toChars(((i >> i2) & 63) | 128);
    }

    private static String b(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        if ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
            return sb.append(Character.toChars(i)).toString();
        }
        if ((i & (-2048)) == 0) {
            sb.append(Character.toChars(((i >> 6) & 31) | 192));
        } else if (((-65536) & i) == 0) {
            if (!a(i, z)) {
                i = Utf8.REPLACEMENT_CODE_POINT;
            }
            sb.append(Character.toChars(((i >> 12) & 15) | 224));
            sb.append(a(i, 6));
        } else if (((-2097152) & i) == 0) {
            sb.append(Character.toChars(((i >> 18) & 7) | PsExtractor.VIDEO_STREAM_MASK));
            sb.append(a(i, 12));
            sb.append(a(i, 6));
        }
        sb.append(Character.toChars((i & 63) | 128));
        return sb.toString();
    }

    public static String a(String str, C0402a c0402a) throws b {
        boolean z = c0402a.a;
        int[] iArrA = a(str);
        a = iArrA;
        b = iArrA.length;
        c = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iA = a(z);
            if (iA == -1) {
                return a(a(arrayList));
            }
            arrayList.add(Integer.valueOf(iA));
        }
    }

    private static int a(boolean z) throws b {
        int i = c;
        int i2 = b;
        if (i > i2) {
            throw new b("Invalid byte index");
        }
        if (i == i2) {
            return -1;
        }
        int i3 = a[i];
        int i4 = i3 & 255;
        c = i + 1;
        if ((i3 & 128) == 0) {
            return i4;
        }
        if ((i3 & 224) == 192) {
            int iA = a() | ((i3 & 31) << 6);
            if (iA >= 128) {
                return iA;
            }
            throw new b("Invalid continuation byte");
        }
        if ((i3 & PsExtractor.VIDEO_STREAM_MASK) == 224) {
            int iA2 = (a() << 6) | ((i3 & 15) << 12) | a();
            if (iA2 >= 2048) {
                return a(iA2, z) ? iA2 : Utf8.REPLACEMENT_CODE_POINT;
            }
            throw new b("Invalid continuation byte");
        }
        if ((i3 & 248) == 240) {
            int iA3 = (a() << 12) | ((i3 & 15) << 18) | (a() << 6) | a();
            if (iA3 >= 65536 && iA3 <= 1114111) {
                return iA3;
            }
        }
        throw new b("Invalid continuation byte");
    }

    private static int[] a(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    private static int a() throws b {
        int i = c;
        if (i >= b) {
            throw new b("Invalid byte index");
        }
        int i2 = a[i];
        c = i + 1;
        if ((i2 & 192) == 128) {
            return i2 & 63;
        }
        throw new b("Invalid continuation byte");
    }

    private static int[] a(String str) {
        int length = str.length();
        int iCharCount = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            iArr[i] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i++;
        }
        return iArr;
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.appendCodePoint(i);
        }
        return sb.toString();
    }
}
