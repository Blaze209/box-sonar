package sdk.pendo.io.r1;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class j {
    public static final e a;
    public static final f b;
    public static final d c;
    public static final c d;
    public static final b e;

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements h {
        private b() {
        }

        @Override // sdk.pendo.io.r1.j.h
        public void a(String str, Appendable appendable) {
            String str2;
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '\f') {
                        str2 = "\\f";
                    } else if (cCharAt == '\r') {
                        str2 = "\\r";
                    } else if (cCharAt == '\"') {
                        str2 = "\\\"";
                    } else if (cCharAt == '/') {
                        str2 = "\\/";
                    } else if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = "\\n";
                                break;
                            default:
                                if ((cCharAt >= 0 && cCharAt <= 31) || ((cCharAt >= 127 && cCharAt <= 159) || (cCharAt >= 8192 && cCharAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 4) & 15));
                                    cCharAt = "0123456789ABCDEF".charAt(cCharAt & 15);
                                }
                                appendable.append(cCharAt);
                                continue;
                                break;
                        }
                    } else {
                        str2 = "\\\\";
                    }
                    appendable.append(str2);
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements h {
        private c() {
        }

        /* JADX WARN: Code duplicated, block: B:28:0x003e A[Catch: IOException -> 0x0082, TryCatch #0 {IOException -> 0x0082, blocks: (B:2:0x0000, B:4:0x0007, B:12:0x001b, B:28:0x003e, B:29:0x006c, B:34:0x007b), top: B:39:0x0000 }] */
        @Override // sdk.pendo.io.r1.j.h
        public void a(String str, Appendable appendable) {
            String str2;
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '\f') {
                        str2 = "\\f";
                    } else if (cCharAt == '\r') {
                        str2 = "\\r";
                    } else if (cCharAt == '\"') {
                        str2 = "\\\"";
                    } else if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = "\\n";
                                break;
                            default:
                                if (cCharAt >= 0 && cCharAt <= 31) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 4) & 15));
                                    cCharAt = "0123456789ABCDEF".charAt(cCharAt & 15);
                                } else if ((cCharAt >= 127 && cCharAt <= 159) || (cCharAt >= 8192 && cCharAt <= 8447)) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((cCharAt >> 4) & 15));
                                    cCharAt = "0123456789ABCDEF".charAt(cCharAt & 15);
                                }
                                appendable.append(cCharAt);
                                continue;
                                break;
                        }
                    } else {
                        str2 = "\\\\";
                    }
                    appendable.append(str2);
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exception");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d implements g {
        private d() {
        }

        /* JADX WARN: Code duplicated, block: B:49:0x0076 A[LOOP:2: B:44:0x006b->B:49:0x0076, LOOP_END] */
        @Override // sdk.pendo.io.r1.j.g
        public boolean a(String str) {
            int i;
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char cCharAt = str.charAt(0);
            if (j.b(cCharAt) || j.e(cCharAt)) {
                return true;
            }
            for (int i2 = 1; i2 < length; i2++) {
                char cCharAt2 = str.charAt(i2);
                if (j.d(cCharAt2) || j.e(cCharAt2)) {
                    return true;
                }
            }
            if (j.a(str)) {
                return true;
            }
            char cCharAt3 = str.charAt(0);
            if ((cCharAt3 >= '0' && cCharAt3 <= '9') || cCharAt3 == '-') {
                int i3 = 1;
                while (i3 < length) {
                    cCharAt3 = str.charAt(i3);
                    if (cCharAt3 < '0' || cCharAt3 > '9') {
                        break;
                    }
                    i3++;
                }
                if (i3 == length) {
                    return true;
                }
                if (cCharAt3 == '.') {
                    i++;
                } else {
                    i = i3 + 1;
                }
                while (i < length) {
                    cCharAt3 = str.charAt(i);
                    if (cCharAt3 < '0' || cCharAt3 > '9') {
                        break;
                    }
                    i++;
                }
                if (i == length) {
                    return true;
                }
                if (cCharAt3 == 'E' || cCharAt3 == 'e') {
                    int i4 = i + 1;
                    if (i4 == length) {
                        return false;
                    }
                    char cCharAt4 = str.charAt(i4);
                    if (cCharAt4 == '+' || cCharAt4 == '-') {
                        i += 2;
                        str.charAt(i);
                    } else {
                        i = i4;
                    }
                }
                if (i == length) {
                    return false;
                }
                while (i < length) {
                    char cCharAt5 = str.charAt(i);
                    if (cCharAt5 < '0' || cCharAt5 > '9') {
                        break;
                    }
                    i++;
                }
                if (i == length) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e implements g {
        private e() {
        }

        @Override // sdk.pendo.io.r1.j.g
        public boolean a(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char cCharAt = str.charAt(0);
            if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char cCharAt2 = str.charAt(i);
                if (j.a(cCharAt2) || j.b(cCharAt2) || j.c(cCharAt2) || j.e(cCharAt2)) {
                    return true;
                }
            }
            return j.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class f implements g {
        private f() {
        }

        @Override // sdk.pendo.io.r1.j.g
        public boolean a(String str) {
            return true;
        }
    }

    public interface g {
        boolean a(String str);
    }

    public interface h {
        void a(String str, Appendable appendable);
    }

    static {
        a = new e();
        b = new f();
        c = new d();
        d = new c();
        e = new b();
    }

    public static boolean a(char c2) {
        return c2 == '\r' || c2 == '\n' || c2 == '\t' || c2 == ' ';
    }

    public static boolean a(String str) {
        String str2;
        if (str.length() < 3) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'n') {
            str2 = AbstractJsonLexerKt.NULL;
        } else if (cCharAt == 't') {
            str2 = TelemetryEventStrings.Value.TRUE;
        } else if (cCharAt == 'f') {
            str2 = "false";
        } else {
            if (cCharAt != 'N') {
                return false;
            }
            str2 = "NaN";
        }
        return str.equals(str2);
    }

    public static boolean b(char c2) {
        return c2 == '{' || c2 == '[' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == ':' || c2 == '\'' || c2 == '\"';
    }

    public static boolean c(char c2) {
        return c2 == '\b' || c2 == '\f' || c2 == '\n';
    }

    public static boolean d(char c2) {
        return c2 == '}' || c2 == ']' || c2 == ',' || c2 == ':';
    }

    public static boolean e(char c2) {
        if (c2 >= 0 && c2 <= 31) {
            return true;
        }
        if (c2 < 127 || c2 > 159) {
            return c2 >= 8192 && c2 <= 8447;
        }
        return true;
    }
}
