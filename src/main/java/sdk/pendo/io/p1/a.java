package sdk.pendo.io.p1;

import java.lang.reflect.Field;
import java.util.HashMap;
import sdk.pendo.io.a.d0;
import sdk.pendo.io.a.s;
import sdk.pendo.io.a.u;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    protected static void a(u uVar, d0 d0Var) {
        switch (d0Var.c()) {
            case 1:
                uVar.a(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                break;
            case 2:
                uVar.a(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;", false);
                break;
            case 3:
                uVar.a(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false);
                break;
            case 4:
                uVar.a(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;", false);
                break;
            case 5:
                uVar.a(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
                break;
            case 6:
                uVar.a(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false);
                break;
            case 7:
                uVar.a(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
                break;
            case 8:
                uVar.a(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
                break;
        }
    }

    public static String b(String str) {
        int length = str.length();
        char[] cArr = new char[length + 2];
        cArr[0] = 'i';
        cArr[1] = 's';
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[2] = cCharAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 2] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static String c(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 's';
        cArr[1] = 'e';
        cArr[2] = 't';
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[3] = cCharAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static b[] a(Class<?> cls, j jVar) {
        HashMap map = new HashMap();
        if (jVar == null) {
            jVar = c.a;
        }
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                String name = field.getName();
                if (!map.containsKey(name)) {
                    b bVar = new b(cls, field, jVar);
                    if (bVar.h()) {
                        map.put(name, bVar);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return (b[]) map.values().toArray(new b[map.size()]);
    }

    public static String a(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            cCharAt = (char) (cCharAt - ' ');
        }
        cArr[3] = cCharAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static s[] a(int i) {
        s[] sVarArr = new s[i];
        for (int i2 = 0; i2 < i; i2++) {
            sVarArr[i2] = new s();
        }
        return sVarArr;
    }
}
