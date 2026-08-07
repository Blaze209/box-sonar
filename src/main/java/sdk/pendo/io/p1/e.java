package sdk.pendo.io.p1;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import sdk.pendo.io.a.d0;
import sdk.pendo.io.a.s;
import sdk.pendo.io.a.u;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static String j = d0.b((Class<?>) d.class);
    final Class<?> a;
    final b[] b;
    final i c;
    final String d;
    final String e;
    final String f;
    final String g;
    final HashMap<Class<?>, Method> h = new HashMap<>();
    Class<? extends Exception> i = NoSuchFieldException.class;

    public e(Class<?> cls, b[] bVarArr, i iVar) {
        this.a = cls;
        this.b = bVarArr;
        this.c = iVar;
        String name = cls.getName();
        this.d = name;
        this.e = name.startsWith("java.") ? "external.sdk.pendo.io.jsonsmart.asm." + name + "AccAccess" : name.concat("AccAccess");
        this.f = this.e.replace('.', '/');
        this.g = name.replace('.', '/');
    }

    private void b(u uVar, Class<?> cls) {
        String strB = d0.b(cls);
        uVar.a(187, strB);
        uVar.a(89);
        uVar.a("mapping " + this.d + " failed to map field:");
        uVar.d(25, 2);
        uVar.a(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
        uVar.a(183, strB, "<init>", "(Ljava/lang/String;)V", false);
        uVar.a(191);
    }

    public void a(Class<?> cls) {
        if (cls == null) {
            return;
        }
        for (Method method : cls.getMethods()) {
            if ((method.getModifiers() & 8) != 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(Object.class)) {
                    Class<?> returnType = method.getReturnType();
                    if (!returnType.equals(Void.TYPE)) {
                        this.h.put(returnType, method);
                    }
                }
            }
        }
    }

    public void a(Iterable<Class<?>> iterable) {
        if (iterable == null) {
            return;
        }
        Iterator<Class<?>> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public Class<?> a() {
        Method method;
        d0 d0Var;
        Method method2;
        int i;
        int i2;
        d0 d0Var2;
        Method method3;
        int i3 = 1;
        sdk.pendo.io.a.h hVar = new sdk.pendo.io.a.h(1);
        boolean z = this.b.length > 10;
        hVar.a(50, 33, this.f, "Lexternal/sdk/pendo/io/jsonsmart/asm/BeansAccess<L" + this.g + ";>;", j, null);
        u uVarA = hVar.a(1, "<init>", "()V", (String) null, (String[]) null);
        uVarA.b();
        uVarA.d(25, 0);
        uVarA.a(183, j, "<init>", "()V", false);
        uVarA.a(177);
        uVarA.c(1, 1);
        uVarA.c();
        u uVarA2 = hVar.a(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", (String) null, (String[]) null);
        uVarA2.b();
        b[] bVarArr = this.b;
        if (bVarArr.length != 0) {
            if (bVarArr.length > 14) {
                uVarA2.d(21, 2);
                s[] sVarArrA = a.a(this.b.length);
                s sVar = new s();
                uVarA2.a(0, sVarArrA.length - 1, sVar, sVarArrA);
                b[] bVarArr2 = this.b;
                int length = bVarArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    b bVar = bVarArr2[i4];
                    int i6 = i5 + 1;
                    uVarA2.a(sVarArrA[i5]);
                    if (bVar.i()) {
                        a(uVarA2, bVar);
                    } else {
                        uVarA2.a(177);
                    }
                    i4++;
                    i5 = i6;
                }
                uVarA2.a(sVar);
            } else {
                s[] sVarArrA2 = a.a(bVarArr.length);
                int i7 = 0;
                for (b bVar2 : this.b) {
                    a(uVarA2, 2, i7, sVarArrA2[i7]);
                    a(uVarA2, bVar2);
                    uVarA2.a(sVarArrA2[i7]);
                    uVarA2.a(3, 0, (Object[]) null, 0, (Object[]) null);
                    i7++;
                }
            }
        }
        Class<? extends Exception> cls = this.i;
        if (cls != null) {
            a(uVarA2, cls);
        } else {
            uVarA2.a(177);
        }
        uVarA2.c(0, 0);
        uVarA2.c();
        u uVarA3 = hVar.a(1, PasskeyWebListener.GET_UNIQUE_KEY, "(Ljava/lang/Object;I)Ljava/lang/Object;", (String) null, (String[]) null);
        uVarA3.b();
        b[] bVarArr3 = this.b;
        int i8 = 192;
        if (bVarArr3.length == 0) {
            uVarA3.a(3, 0, (Object[]) null, 0, (Object[]) null);
        } else if (bVarArr3.length > 14) {
            uVarA3.d(21, 2);
            s[] sVarArrA3 = a.a(this.b.length);
            s sVar2 = new s();
            uVarA3.a(0, sVarArrA3.length - 1, sVar2, sVarArrA3);
            b[] bVarArr4 = this.b;
            int length2 = bVarArr4.length;
            int i9 = 0;
            int i10 = 0;
            while (i9 < length2) {
                b bVar3 = bVarArr4[i9];
                int i11 = i10 + 1;
                uVarA3.a(sVarArrA3[i10]);
                int i12 = i9;
                uVarA3.a(3, 0, (Object[]) null, 0, (Object[]) null);
                if (bVar3.g()) {
                    uVarA3.d(25, i3);
                    uVarA3.a(i8, this.g);
                    d0 d0VarC = d0.c(bVar3.d());
                    if (bVar3.f() || (method2 = bVar3.c) == null) {
                        d0Var = d0VarC;
                        uVarA3.a(180, this.g, bVar3.c(), d0Var.a());
                    } else {
                        String strA = d0.a(method2);
                        d0Var = d0VarC;
                        uVarA3.a(182, this.g, bVar3.c.getName(), strA, false);
                    }
                    a.a(uVarA3, d0Var);
                } else {
                    uVarA3.a(i3);
                }
                uVarA3.a(176);
                i9 = i12 + 1;
                i10 = i11;
                i8 = 192;
                i3 = 1;
            }
            uVarA3.a(sVar2);
            uVarA3.a(3, 0, (Object[]) null, 0, (Object[]) null);
        } else {
            s[] sVarArrA4 = a.a(bVarArr3.length);
            int i13 = 0;
            for (b bVar4 : this.b) {
                a(uVarA3, 2, i13, sVarArrA4[i13]);
                uVarA3.d(25, 1);
                uVarA3.a(192, this.g);
                d0 d0VarC2 = d0.c(bVar4.d());
                if (bVar4.f() || (method = bVar4.c) == null) {
                    uVarA3.a(180, this.g, bVar4.c(), d0VarC2.a());
                } else {
                    if (method == null) {
                        throw new RuntimeException("no Getter for field " + bVar4.c() + " in class " + this.d);
                    }
                    uVarA3.a(182, this.g, bVar4.c.getName(), d0.a(method), false);
                }
                a.a(uVarA3, d0VarC2);
                uVarA3.a(176);
                uVarA3.a(sVarArrA4[i13]);
                uVarA3.a(3, 0, (Object[]) null, 0, (Object[]) null);
                i13++;
            }
        }
        Class<? extends Exception> cls2 = this.i;
        if (cls2 != null) {
            a(uVarA3, cls2);
        } else {
            uVarA3.a(1);
            uVarA3.a(176);
        }
        uVarA3.c(0, 0);
        uVarA3.c();
        int i14 = Token.SET;
        if (z) {
            i = 176;
            i2 = 192;
        } else {
            i = 176;
            i2 = 192;
            u uVarA4 = hVar.a(1, "set", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V", (String) null, (String[]) null);
            uVarA4.b();
            s[] sVarArrA5 = a.a(this.b.length);
            int i15 = 0;
            for (b bVar5 : this.b) {
                uVarA4.d(25, 2);
                uVarA4.a(bVar5.g);
                uVarA4.a(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
                uVarA4.a(Token.SET, sVarArrA5[i15]);
                a(uVarA4, bVar5);
                uVarA4.a(sVarArrA5[i15]);
                uVarA4.a(3, 0, (Object[]) null, 0, (Object[]) null);
                i15++;
            }
            Class<? extends Exception> cls3 = this.i;
            if (cls3 != null) {
                b(uVarA4, cls3);
            } else {
                uVarA4.a(177);
            }
            uVarA4.c(0, 0);
            uVarA4.c();
        }
        if (!z) {
            u uVarA5 = hVar.a(1, PasskeyWebListener.GET_UNIQUE_KEY, "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", (String) null, (String[]) null);
            uVarA5.b();
            s[] sVarArrA6 = a.a(this.b.length);
            b[] bVarArr5 = this.b;
            int length3 = bVarArr5.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length3) {
                b bVar6 = bVarArr5[i16];
                uVarA5.d(25, 2);
                uVarA5.a(bVar6.g);
                uVarA5.a(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
                uVarA5.a(i14, sVarArrA6[i17]);
                uVarA5.d(25, 1);
                uVarA5.a(i2, this.g);
                d0 d0VarC3 = d0.c(bVar6.d());
                if (bVar6.f() || (method3 = bVar6.c) == null) {
                    d0Var2 = d0VarC3;
                    uVarA5.a(180, this.g, bVar6.c(), d0Var2.a());
                } else {
                    String strA2 = d0.a(method3);
                    d0Var2 = d0VarC3;
                    uVarA5.a(182, this.g, bVar6.c.getName(), strA2, false);
                }
                a.a(uVarA5, d0Var2);
                uVarA5.a(i);
                uVarA5.a(sVarArrA6[i17]);
                uVarA5.a(3, 0, (Object[]) null, 0, (Object[]) null);
                i17++;
                i16++;
                i14 = Token.SET;
            }
            Class<? extends Exception> cls4 = this.i;
            if (cls4 != null) {
                b(uVarA5, cls4);
            } else {
                uVarA5.a(1);
                uVarA5.a(i);
            }
            uVarA5.c(0, 0);
            uVarA5.c();
        }
        u uVarA6 = hVar.a(1, "newInstance", "()Ljava/lang/Object;", (String) null, (String[]) null);
        uVarA6.b();
        uVarA6.a(187, this.g);
        uVarA6.a(89);
        uVarA6.a(183, this.g, "<init>", "()V", false);
        uVarA6.a(i);
        uVarA6.c(2, 1);
        uVarA6.c();
        hVar.a();
        return this.c.a(this.e, hVar.d());
    }

    private void a(u uVar, int i, int i2, s sVar) {
        uVar.d(21, i);
        if (i2 == 0) {
            uVar.a(Token.LET, sVar);
            return;
        }
        if (i2 == 1) {
            uVar.a(4);
            uVar.a(160, sVar);
            return;
        }
        if (i2 == 2) {
            uVar.a(5);
            uVar.a(160, sVar);
            return;
        }
        if (i2 == 3) {
            uVar.a(6);
            uVar.a(160, sVar);
            return;
        }
        if (i2 == 4) {
            uVar.a(7);
            uVar.a(160, sVar);
        } else if (i2 == 5) {
            uVar.a(8);
            uVar.a(160, sVar);
        } else {
            if (i2 < 6) {
                throw new RuntimeException("non supported negative values");
            }
            uVar.b(16, i2);
            uVar.a(160, sVar);
        }
    }

    private void a(u uVar, b bVar) {
        s sVar;
        String str;
        boolean z;
        int i;
        String str2;
        String str3;
        Method method;
        u uVar2 = uVar;
        uVar2.d(25, 1);
        uVar2.a(192, this.g);
        uVar2.d(25, 3);
        d0 d0VarC = d0.c(bVar.d());
        Class<?> clsD = bVar.d();
        String strB = d0.b(clsD);
        Method method2 = this.h.get(clsD);
        if (method2 != null) {
            uVar2.a(184, d0.b(method2.getDeclaringClass()), method2.getName(), d0.a(method2), false);
        } else {
            if (bVar.e()) {
                sVar = new s();
                uVar2.a(198, sVar);
                uVar2.d(25, 3);
                z = false;
                uVar2.a(182, "java/lang/Object", "toString", "()Ljava/lang/String;", false);
                str = "(Ljava/lang/String;)L" + strB + AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER;
                str3 = "valueOf";
                i = 184;
                uVar2 = uVar;
                str2 = strB;
            } else {
                if (clsD.equals(String.class)) {
                    sVar = new s();
                    uVar2.a(198, sVar);
                    uVar2.d(25, 3);
                    str = "()Ljava/lang/String;";
                    z = false;
                    i = 182;
                    str2 = "java/lang/Object";
                    str3 = "toString";
                }
                uVar2.a(192, strB);
            }
            uVar2.a(i, str2, str3, str, z);
            uVar2.d(58, 3);
            uVar2.a(sVar);
            uVar2.a(3, 0, (Object[]) null, 0, (Object[]) null);
            uVar2.d(25, 1);
            uVar2.a(192, this.g);
            uVar2.d(25, 3);
            uVar2.a(192, strB);
        }
        if (bVar.f() || (method = bVar.b) == null) {
            uVar2.a(181, this.g, bVar.c(), d0VarC.a());
        } else {
            uVar.a(182, this.g, bVar.b.getName(), d0.a(method), false);
            uVar2 = uVar;
        }
        uVar2.a(177);
    }

    private void a(u uVar, Class<?> cls) {
        String strB = d0.b(cls);
        uVar.a(187, strB);
        uVar.a(89);
        uVar.a("mapping " + this.d + " failed to map field:");
        uVar.d(21, 2);
        uVar.a(184, "java/lang/Integer", "toString", "(I)Ljava/lang/String;", false);
        uVar.a(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
        uVar.a(183, strB, "<init>", "(Ljava/lang/String;)V", false);
        uVar.a(191);
    }
}
