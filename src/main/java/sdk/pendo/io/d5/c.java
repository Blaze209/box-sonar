package sdk.pendo.io.d5;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final int a = String.valueOf(Integer.MAX_VALUE).length();
    private static final Map<String, Integer> b;
    private static final Map<Integer, String> c;
    private static sdk.pendo.io.d5.b<String> d;
    private static sdk.pendo.io.j5.a.C0402a e;

    class a extends HashMap<String, Integer> {
        a() {
            put("open", 0);
            put(HeaderElements.CLOSE, 1);
            put("ping", 2);
            put("pong", 3);
            put("message", 4);
            put(HeaderElements.UPGRADE, 5);
            put("noop", 6);
        }
    }

    class b implements f {
        final /* synthetic */ StringBuilder a;

        b(StringBuilder sb) {
            this.a = sb;
        }

        @Override // sdk.pendo.io.d5.c.f
        public void a(Object obj) {
            this.a.append(c.b((String) obj));
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.d5.c$c, reason: collision with other inner class name */
    class C0374c implements f<byte[]> {
        final /* synthetic */ ArrayList a;

        C0374c(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // sdk.pendo.io.d5.c.f
        public void a(byte[] bArr) {
            this.a.add(bArr);
        }
    }

    class d implements f {
        final /* synthetic */ f a;

        d(f fVar) {
            this.a = fVar;
        }

        @Override // sdk.pendo.io.d5.c.f
        public void a(Object obj) {
            int i = 0;
            if (obj instanceof String) {
                String str = (String) obj;
                String strValueOf = String.valueOf(str.length());
                int length = strValueOf.length();
                byte[] bArr = new byte[length + 2];
                bArr[0] = 0;
                while (i < strValueOf.length()) {
                    int i2 = i + 1;
                    bArr[i2] = (byte) Character.getNumericValue(strValueOf.charAt(i));
                    i = i2;
                }
                bArr[length + 1] = -1;
                this.a.a(sdk.pendo.io.d5.a.a(new byte[][]{bArr, c.c(str)}));
                return;
            }
            byte[] bArr2 = (byte[]) obj;
            String strValueOf2 = String.valueOf(bArr2.length);
            int length2 = strValueOf2.length();
            byte[] bArr3 = new byte[length2 + 2];
            bArr3[0] = 1;
            while (i < strValueOf2.length()) {
                int i3 = i + 1;
                bArr3[i3] = (byte) Character.getNumericValue(strValueOf2.charAt(i));
                i = i3;
            }
            bArr3[length2 + 1] = -1;
            this.a.a(sdk.pendo.io.d5.a.a(new byte[][]{bArr3, bArr2}));
        }
    }

    public interface e<T> {
        boolean a(sdk.pendo.io.d5.b<T> bVar, int i, int i2);
    }

    public interface f<T> {
        void a(T t);
    }

    static {
        a aVar = new a();
        b = aVar;
        c = new HashMap();
        for (Map.Entry<String, Integer> entry : aVar.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new sdk.pendo.io.d5.b<>("error", "parser error");
        sdk.pendo.io.j5.a.C0402a c0402a = new sdk.pendo.io.j5.a.C0402a();
        e = c0402a;
        c0402a.a = false;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.appendCodePoint(b2 & 255);
        }
        return sb.toString();
    }

    public static sdk.pendo.io.d5.b<byte[]> b(byte[] bArr) {
        byte b2 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return new sdk.pendo.io.d5.b<>(c.get(Integer.valueOf(b2)), bArr2);
    }

    public static void c(sdk.pendo.io.d5.b bVar, f fVar) {
        a(bVar, false, fVar);
    }

    public static sdk.pendo.io.d5.b<String> a(String str) {
        return a(str, false);
    }

    private static void b(sdk.pendo.io.d5.b bVar, f<byte[]> fVar) {
        a(bVar, true, new d(fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] c(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Character.codePointAt(str, i);
        }
        return bArr;
    }

    public static sdk.pendo.io.d5.b<String> a(String str, boolean z) {
        int numericValue;
        if (str == null) {
            return d;
        }
        try {
            numericValue = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            numericValue = -1;
        }
        if (z) {
            try {
                str = sdk.pendo.io.j5.a.a(str, e);
            } catch (sdk.pendo.io.j5.b unused2) {
                return d;
            }
        }
        if (numericValue >= 0) {
            Map<Integer, String> map = c;
            if (numericValue < map.size()) {
                return str.length() > 1 ? new sdk.pendo.io.d5.b<>(map.get(Integer.valueOf(numericValue)), str.substring(1)) : new sdk.pendo.io.d5.b<>(map.get(Integer.valueOf(numericValue)));
            }
        }
        return d;
    }

    private static void b(sdk.pendo.io.d5.b[] bVarArr, f<byte[]> fVar) {
        if (bVarArr.length == 0) {
            fVar.a(new byte[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(bVarArr.length);
        for (sdk.pendo.io.d5.b bVar : bVarArr) {
            b(bVar, new C0374c(arrayList));
        }
        fVar.a(sdk.pendo.io.d5.a.a((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
    }

    public static void a(String str, e<String> eVar) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i = 0;
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (':' != cCharAt) {
                    sb.append(cCharAt);
                } else {
                    try {
                        int i2 = Integer.parseInt(sb.toString());
                        int i3 = i + 1;
                        String strSubstring = str.substring(i3, i3 + i2);
                        if (strSubstring.length() != 0) {
                            sdk.pendo.io.d5.b<String> bVarA = a(strSubstring, false);
                            if (!d.a.equals(bVarA.a) || !d.b.equals(bVarA.b)) {
                                if (!eVar.a(bVarA, i + i2, length)) {
                                    return;
                                }
                            }
                        }
                        i += i2;
                        sb = new StringBuilder();
                    } catch (IndexOutOfBoundsException | NumberFormatException unused) {
                    }
                }
                i++;
            }
            if (sb.length() <= 0) {
                return;
            }
        }
        eVar.a(d, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        return str.length() + ":" + str;
    }

    public static void a(byte[] bArr, e eVar) {
        Object objB;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (byteBufferWrap.capacity() <= 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj = arrayList.get(i);
                    if (obj instanceof String) {
                        objB = a((String) obj, true);
                    } else {
                        if (obj instanceof byte[]) {
                            objB = b((byte[]) obj);
                        }
                    }
                    eVar.a(objB, i, size);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = (byteBufferWrap.get(0) & 255) == 0;
            int i2 = 1;
            while (true) {
                int i3 = byteBufferWrap.get(i2) & 255;
                if (i3 == 255) {
                    break;
                }
                if (sb.length() > a) {
                    eVar.a(d, 0, 1);
                    return;
                } else {
                    sb.append(i3);
                    i2++;
                }
            }
            byteBufferWrap.position(sb.length() + 1);
            ByteBuffer byteBufferSlice = byteBufferWrap.slice();
            int i4 = Integer.parseInt(sb.toString());
            byteBufferSlice.position(1);
            int i5 = i4 + 1;
            byteBufferSlice.limit(i5);
            byte[] bArr2 = new byte[byteBufferSlice.remaining()];
            byteBufferSlice.get(bArr2);
            if (z) {
                arrayList.add(a(bArr2));
            } else {
                arrayList.add(bArr2);
            }
            byteBufferSlice.clear();
            byteBufferSlice.position(i5);
            byteBufferWrap = byteBufferSlice.slice();
        }
    }

    private static void a(sdk.pendo.io.d5.b<byte[]> bVar, f<byte[]> fVar) {
        byte[] bArr = bVar.b;
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = b.get(bVar.a).byteValue();
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        fVar.a(bArr2);
    }

    public static void a(sdk.pendo.io.d5.b bVar, boolean z, f fVar) {
        if (bVar.b instanceof byte[]) {
            a((sdk.pendo.io.d5.b<byte[]>) bVar, (f<byte[]>) fVar);
            return;
        }
        String strValueOf = String.valueOf(b.get(bVar.a));
        if (bVar.b != 0) {
            StringBuilder sbAppend = new StringBuilder().append(strValueOf);
            String strValueOf2 = String.valueOf(bVar.b);
            if (z) {
                strValueOf2 = sdk.pendo.io.j5.a.b(strValueOf2, e);
            }
            strValueOf = sbAppend.append(strValueOf2).toString();
        }
        fVar.a(strValueOf);
    }

    public static void a(sdk.pendo.io.d5.b[] bVarArr, f fVar) {
        String string;
        for (sdk.pendo.io.d5.b bVar : bVarArr) {
            if (bVar.b instanceof byte[]) {
                b(bVarArr, (f<byte[]>) fVar);
                return;
            }
        }
        if (bVarArr.length == 0) {
            string = "0:";
        } else {
            StringBuilder sb = new StringBuilder();
            for (sdk.pendo.io.d5.b bVar2 : bVarArr) {
                a(bVar2, false, new b(sb));
            }
            string = sb.toString();
        }
        fVar.a(string);
    }
}
