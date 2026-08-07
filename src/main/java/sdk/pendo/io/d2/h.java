package sdk.pendo.io.d2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ViewProps;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
final class h {
    static final int a(int i) {
        return ((i & 65535) << 8) | 7;
    }

    static final int b(int i) {
        return ((i & 65535) << 8) | 8;
    }

    static final int c(int i) {
        return i >>> 8;
    }

    static final int d(int i) {
        return i & 255;
    }

    static boolean e(int i) {
        return i == 3 || i == 4;
    }

    static final int a(String str, d dVar) {
        return a(dVar.a(str));
    }

    static final int b(String str, d dVar) {
        if (str.length() != 1) {
            return a(str, dVar);
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return 2;
        }
        if (cCharAt != 'S' && cCharAt != 'Z' && cCharAt != 'I') {
            if (cCharAt == 'J') {
                return 4;
            }
            switch (cCharAt) {
                case 'B':
                case 'C':
                    break;
                case 'D':
                    return 3;
                default:
                    throw new IllegalArgumentException("bad type");
            }
        }
        return 1;
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str.replace('/', '.'));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String b(int i, d dVar) {
        int iD = d(i);
        switch (iD) {
            case 0:
                return ViewProps.TOP;
            case 1:
                return "int";
            case 2:
                return TypedValues.Custom.S_FLOAT;
            case 3:
                return "double";
            case 4:
                return "long";
            case 5:
                return AbstractJsonLexerKt.NULL;
            case 6:
                return "uninitialized_this";
            default:
                if (iD == 7) {
                    return a(i, dVar);
                }
                if (iD == 8) {
                    return "uninitialized";
                }
                throw new IllegalArgumentException("bad type");
        }
    }

    static final String a(int i, d dVar) {
        if (d(i) == 7) {
            return (String) dVar.c(c(i));
        }
        throw new IllegalArgumentException("expecting object type");
    }

    static int a(int i, int i2, d dVar) {
        String strI;
        int iD = d(i);
        int iD2 = d(i2);
        boolean z = iD == 7;
        boolean z2 = iD2 == 7;
        if (i != i2 && (!z || i2 != 5)) {
            if (iD == 0 || iD2 == 0) {
                return 0;
            }
            if (i != 5 || !z2) {
                if (z && z2) {
                    String strA = a(i, dVar);
                    String strA2 = a(i2, dVar);
                    String str = (String) dVar.c(2);
                    String str2 = (String) dVar.c(4);
                    if (strA.equals(str)) {
                        strA = str2;
                    }
                    if (strA2.equals(str)) {
                        strA2 = str2;
                    }
                    Class<?> clsA = a(strA);
                    Class<?> clsA2 = a(strA2);
                    if (!clsA.isAssignableFrom(clsA2)) {
                        if (!clsA2.isAssignableFrom(clsA)) {
                            if (clsA2.isInterface() || clsA.isInterface()) {
                                strI = "java/lang/Object";
                            } else {
                                do {
                                    clsA2 = clsA2.getSuperclass();
                                    if (clsA2 != null) {
                                    }
                                } while (!clsA2.isAssignableFrom(clsA));
                                strI = c.i(clsA2.getName());
                            }
                            return a(strI, dVar);
                        }
                    }
                }
                throw new IllegalArgumentException("bad merge attempt between " + b(i, dVar) + " and " + b(i2, dVar));
            }
            return i2;
        }
        return i;
    }
}
