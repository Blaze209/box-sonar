package sdk.pendo.io.s7;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class y0 {
    private static final Charset a = Charset.forName("UTF-8");
    private static final char[] b = "0123456789ABCDEF".toCharArray();

    public interface a<T> {
        boolean test(T t);
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = b;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, a);
    }

    public static boolean c(String str) {
        return i(str) != null;
    }

    public static boolean d(String str) {
        try {
            new JSONArray(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean e(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean g(String str) {
        boolean z;
        boolean z2 = false;
        if (sdk.pendo.io.w1.g.a(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z3 = true;
        int i = charArray[0] == '-' ? 1 : 0;
        int i2 = i + 1;
        char c = 'F';
        if (length > i2 && charArray[i] == '0') {
            char c2 = charArray[i2];
            if (c2 == 'x' || c2 == 'X') {
                int i3 = i + 2;
                if (i3 == length) {
                    return false;
                }
                while (i3 < charArray.length) {
                    char c3 = charArray[i3];
                    if ((c3 < '0' || c3 > '9') && ((c3 < 'a' || c3 > 'f') && (c3 < 'A' || c3 > 'F'))) {
                        return false;
                    }
                    i3++;
                }
                return true;
            }
            if (Character.isDigit(c2)) {
                while (i2 < charArray.length) {
                    char c4 = charArray[i2];
                    if (c4 < '0' || c4 > '7') {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        int i4 = length - 1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            z = z2;
            boolean z8 = z3;
            if (i >= i4 && (i >= length || !z4 || z5)) {
                if (i >= charArray.length) {
                    return (z4 || !z5) ? z : z8;
                }
                char c5 = charArray[i];
                if (c5 >= '0' && c5 <= '9') {
                    return z8;
                }
                if (c5 != 'e' && c5 != 'E') {
                    if (c5 == '.') {
                        if (z7 || z6) {
                            return z;
                        }
                    } else if (z4 || (c5 != 'd' && c5 != 'D' && c5 != 'f' && c5 != c)) {
                        if ((c5 == 'l' || c5 == 'L') && z5 && !z6 && !z7) {
                            return z8;
                        }
                    }
                    return z5;
                }
                return z;
            }
            char c6 = charArray[i];
            if (c6 >= '0' && c6 <= '9') {
                z5 = z8;
                z4 = z;
            } else if (c6 == '.') {
                if (z7 || z6) {
                    break;
                }
                z7 = z8;
            } else if (c6 == 'e' || c6 == 'E') {
                if (z6 || !z5) {
                    return z;
                }
                z4 = z8;
                z6 = z4;
            } else {
                if ((c6 != '+' && c6 != '-') || !z4) {
                    return z;
                }
                z4 = z;
                z5 = z4;
            }
            i++;
            c = 'F';
            z3 = z8;
            z2 = z;
        }
        return z;
    }

    public static String h(String str) {
        return str == null ? "" : str;
    }

    public static Integer i(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public static Boolean b(String str) {
        try {
            Class.forName(str);
            return Boolean.TRUE;
        } catch (ClassNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public static String a(String str) {
        return Base64.encodeToString(a((CharSequence) str).toString().getBytes(Charset.forName("UTF-8")), 10);
    }

    public static <T> boolean a(List<T> list, a<T> aVar) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (aVar.test(t)) {
                arrayList.add(t);
            }
        }
        return list.removeAll(arrayList);
    }

    public static List<String> a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass.getName());
        }
        return arrayList;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.toString().contains("sdk.pendo.io")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray a(List<? extends Object> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends Object> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toString());
        }
        return jSONArray;
    }

    public static String a(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append(entry.getKey()).append(":").append(entry.getValue() != null ? entry.getValue().toString() : AbstractJsonLexerKt.NULL).append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(SortedMap<String, String> sortedMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : sortedMap.keySet()) {
            arrayList.add(str);
            arrayList.add(":");
            arrayList.add(sortedMap.get(str));
        }
        return a(arrayList, "");
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        return sb.toString();
    }

    public static String a(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return String.join(str, list);
    }

    public static CharSequence a(CharSequence charSequence) {
        return a(charSequence, 256);
    }

    public static String a(CharSequence charSequence, int i) {
        if (charSequence != null && charSequence.length() > i) {
            return charSequence.subSequence(0, i).toString();
        }
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }
}
