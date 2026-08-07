package sdk.pendo.io.b2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import sdk.pendo.io.w1.g;
import sdk.pendo.io.w1.h;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: sdk.pendo.io.b2.a$a, reason: collision with other inner class name */
    static class C0348a {
        private static final C0348a[] c = new C0348a[0];
        private final Object a;
        private int b = 1;

        C0348a(Object obj) {
            this.a = obj;
        }

        int b() {
            return this.b;
        }

        Object c() {
            return this.a;
        }

        void d() {
            this.b++;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0348a) {
                C0348a c0348a = (C0348a) obj;
                if (this.a.getClass() != c0348a.a.getClass() || this.b != c0348a.b) {
                    return false;
                }
                Object obj2 = this.a;
                if (obj2 instanceof StringBuilder) {
                    return obj2.toString().equals(c0348a.a.toString());
                }
                boolean z = obj2 instanceof Number;
                Object obj3 = c0348a.a;
                if (z) {
                    return obj2.equals(obj3);
                }
                if (obj2 == obj3) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return g.a(this.a.toString(), this.b);
        }

        static boolean a(C0348a[] c0348aArr, Object obj) {
            for (C0348a c0348a : c0348aArr) {
                if (c0348a.c() == obj) {
                    return true;
                }
            }
            return false;
        }
    }

    static String a(C0348a[] c0348aArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        C0348a[] c0348aArr2 = c0348aArr;
        StringBuilder sb = new StringBuilder();
        int length = c0348aArr2.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            C0348a c0348a = c0348aArr2[i2];
            Object objC = c0348a.c();
            int iB = c0348a.b();
            if (objC instanceof StringBuilder) {
                sb.append(objC.toString());
                length = length;
                i = i2;
            } else {
                if (objC.equals("y")) {
                    sb.append(a(j, z, iB));
                } else {
                    if (objC.equals("M")) {
                        sb.append(a(j2, z, iB));
                    } else {
                        i = i2;
                        if (objC.equals("d")) {
                            sb.append(a(j3, z, iB));
                            z2 = false;
                        } else {
                            if (objC.equals("H")) {
                                length = length;
                                sb.append(a(j4, z, iB));
                            } else {
                                length = length;
                                if (objC.equals(CmcdData.OBJECT_TYPE_MANIFEST)) {
                                    sb.append(a(j5, z, iB));
                                } else if (objC.equals("s")) {
                                    sb.append(a(j6, z, iB));
                                    z2 = true;
                                } else if (objC.equals(ExifInterface.LATITUDE_SOUTH)) {
                                    if (z2) {
                                        sb.append(a(j7, true, z ? Math.max(3, iB) : 3));
                                    } else {
                                        sb.append(a(j7, z, iB));
                                    }
                                    z2 = false;
                                }
                            }
                            z2 = false;
                        }
                    }
                    i2 = i + 1;
                    c0348aArr2 = c0348aArr;
                    length = length;
                }
                i = i2;
                z2 = false;
            }
            i2 = i + 1;
            c0348aArr2 = c0348aArr;
            length = length;
        }
        return sb.toString();
    }

    public static String a(long j, String str) {
        return a(j, str, true);
    }

    public static String a(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        h.a(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
        C0348a[] c0348aArrA = a(str);
        if (C0348a.a(c0348aArrA, "d")) {
            j3 = j / 86400000;
            j2 = j - (86400000 * j3);
        } else {
            j2 = j;
            j3 = 0;
        }
        if (C0348a.a(c0348aArrA, "H")) {
            long j7 = j2 / 3600000;
            j2 -= 3600000 * j7;
            j4 = j7;
        } else {
            j4 = 0;
        }
        if (C0348a.a(c0348aArrA, CmcdData.OBJECT_TYPE_MANIFEST)) {
            long j8 = j2 / 60000;
            j2 -= 60000 * j8;
            j5 = j8;
        } else {
            j5 = 0;
        }
        if (C0348a.a(c0348aArrA, "s")) {
            j6 = j2 / 1000;
            j2 -= 1000 * j6;
        } else {
            j6 = 0;
        }
        return a(c0348aArrA, 0L, 0L, j3, j4, j5, j6, j2, z);
    }

    public static String a(long j) {
        return a(j, "HH:mm:ss.SSS");
    }

    static C0348a[] a(String str) {
        String str2;
        ArrayList arrayList = new ArrayList(str.length());
        boolean z = false;
        StringBuilder sb = null;
        C0348a c0348a = null;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!z || cCharAt == '\'') {
                if (cCharAt != '\'') {
                    if (cCharAt == 'H') {
                        str2 = "H";
                    } else if (cCharAt == 'M') {
                        str2 = "M";
                    } else if (cCharAt == 'S') {
                        str2 = ExifInterface.LATITUDE_SOUTH;
                    } else if (cCharAt == 'd') {
                        str2 = "d";
                    } else if (cCharAt == 'm') {
                        str2 = CmcdData.OBJECT_TYPE_MANIFEST;
                    } else if (cCharAt == 's') {
                        str2 = "s";
                    } else if (cCharAt != 'y') {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new C0348a(sb));
                        }
                        sb.append(cCharAt);
                        str2 = null;
                    } else {
                        str2 = "y";
                    }
                } else if (z) {
                    z = false;
                    sb = null;
                    str2 = null;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    arrayList.add(new C0348a(sb2));
                    sb = sb2;
                    z = true;
                    str2 = null;
                }
                if (str2 != null) {
                    if (c0348a == null || !c0348a.c().equals(str2)) {
                        C0348a c0348a2 = new C0348a(str2);
                        arrayList.add(c0348a2);
                        c0348a = c0348a2;
                    } else {
                        c0348a.d();
                    }
                    sb = null;
                }
            } else {
                sb.append(cCharAt);
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unmatched quote in format: " + str);
        }
        return (C0348a[]) arrayList.toArray(C0348a.c);
    }

    private static String a(long j, boolean z, int i) {
        String string = Long.toString(j);
        return z ? g.a(string, i, '0') : string;
    }
}
