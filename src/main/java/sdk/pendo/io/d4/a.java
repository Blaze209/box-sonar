package sdk.pendo.io.d4;

import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public class a<T> {
    final int a;
    final Object[] b;
    Object[] c;
    int d;

    /* JADX INFO: renamed from: sdk.pendo.io.d4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0373a<T> extends sdk.pendo.io.q3.j<T> {
        @Override // sdk.pendo.io.q3.j
        boolean test(T t);
    }

    public a(int i) {
        this.a = i;
        Object[] objArr = new Object[i + 1];
        this.b = objArr;
        this.c = objArr;
    }

    public <U> boolean a(sdk.pendo.io.j3.b<? super U> bVar) {
        Object[] objArr = this.b;
        int i = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (i.a(objArr2, bVar)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public void b(T t) {
        this.b[0] = t;
    }

    public <U> boolean a(o<? super U> oVar) {
        Object[] objArr = this.b;
        int i = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (i.b(objArr2, oVar)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public void a(T t) {
        int i = this.a;
        int i2 = this.d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.c[i] = objArr;
            this.c = objArr;
            i2 = 0;
        }
        this.c[i2] = t;
        this.d = i2 + 1;
    }

    public void a(InterfaceC0373a<? super T> interfaceC0373a) {
        int i = this.a;
        for (Object[] objArr = this.b; objArr != null; objArr = (Object[]) objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    break;
                } else {
                    if (interfaceC0373a.test(obj)) {
                        return;
                    }
                }
            }
        }
    }
}
