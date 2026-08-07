package sdk.pendo.io.t1;

/* JADX INFO: loaded from: classes5.dex */
abstract class c extends b {
    protected int y;

    public c(int i) {
        super(i);
    }

    protected abstract int a(char c, int i);

    protected abstract void a(int i, int i2);

    @Override // sdk.pendo.io.t1.b
    protected void a(boolean[] zArr) {
        int i = this.g;
        c(zArr);
        b(i, this.g);
    }

    @Override // sdk.pendo.io.t1.b
    protected Object b(boolean[] zArr) throws e {
        int i = this.g;
        d();
        i();
        char c = this.a;
        if (c != '.' && c != 'E' && c != 'e') {
            j();
            char c2 = this.a;
            if (c2 < 0 || c2 >= '~' || zArr[c2] || c2 == 26) {
                b(i, this.g);
                return a(this.f);
            }
            c(zArr);
            b(i, this.g);
            if (this.j) {
                return this.f;
            }
            throw new e(this.g, 1, this.f);
        }
        if (c == '.') {
            d();
            i();
        }
        char c3 = this.a;
        if (c3 != 'E' && c3 != 'e') {
            j();
            char c4 = this.a;
            if (c4 < 0 || c4 >= '~' || zArr[c4] || c4 == 26) {
                b(i, this.g);
                return c();
            }
            c(zArr);
            b(i, this.g);
            if (this.j) {
                return this.f;
            }
            throw new e(this.g, 1, this.f);
        }
        this.d.a('E');
        d();
        char c5 = this.a;
        if (c5 != '+' && c5 != '-' && (c5 < '0' || c5 > '9')) {
            c(zArr);
            b(i, this.g);
            if (!this.j) {
                throw new e(this.g, 1, this.f);
            }
            if (!this.h) {
                b();
            }
            return this.f;
        }
        this.d.a(c5);
        d();
        i();
        j();
        char c6 = this.a;
        if (c6 < 0 || c6 >= '~' || zArr[c6] || c6 == 26) {
            b(i, this.g);
            return c();
        }
        c(zArr);
        b(i, this.g);
        if (this.j) {
            return this.f;
        }
        throw new e(this.g, 1, this.f);
    }

    protected abstract void b(int i, int i2);

    @Override // sdk.pendo.io.t1.b
    protected void g() throws e {
        if (!this.k && this.a == '\'') {
            if (!this.j) {
                throw new e(this.g, 0, Character.valueOf(this.a));
            }
            a(b.t);
            return;
        }
        int iA = a(this.a, this.g + 1);
        if (iA == -1) {
            throw new e(this.y, 3, null);
        }
        a(this.g + 1, iA);
        if (this.f.indexOf(92) != -1) {
            this.d.a();
            h();
        } else {
            a();
            this.g = iA;
            d();
        }
    }
}
