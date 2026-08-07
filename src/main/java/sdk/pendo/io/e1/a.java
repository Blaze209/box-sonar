package sdk.pendo.io.e1;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private final CharSequence a;
    private int b = 0;
    private int c;

    public a(CharSequence charSequence) {
        this.a = charSequence;
        this.c = charSequence.length() - 1;
    }

    private int j(int i) {
        this.c = i;
        return i;
    }

    public char a(int i) {
        return this.a.charAt(i);
    }

    public boolean b() {
        return this.b >= this.c;
    }

    public boolean c() {
        return c(this.b + 1);
    }

    public boolean d() {
        return c(this.b);
    }

    public int e() {
        return e(this.b);
    }

    public boolean f(int i) {
        char cA = a(i);
        return Character.isDigit(cA) || cA == '-' || cA == '.';
    }

    public boolean g(int i) {
        return !c(i);
    }

    public char h(int i) {
        do {
            i++;
            if (g(i)) {
                break;
            }
        } while (a(i) == ' ');
        if (g(i)) {
            return ' ';
        }
        return a(i);
    }

    public char i() {
        return i(this.b);
    }

    public int k(int i) {
        this.b = i;
        return i;
    }

    public a l() {
        j();
        k();
        return this;
    }

    public String toString() {
        return this.a.toString();
    }

    private a k() {
        while (d() && this.b < this.c && c(' ')) {
            b(1);
        }
        return this;
    }

    public char a() {
        return this.a.charAt(this.b);
    }

    public int b(int i) {
        return j(this.c - i);
    }

    public boolean c(int i) {
        return i >= 0 && i <= this.c;
    }

    public int d(int i) {
        return k(this.b + i);
    }

    public int e(int i) {
        do {
            i--;
            if (g(i)) {
                break;
            }
        } while (a(i) == ' ');
        if (g(i)) {
            return -1;
        }
        return i;
    }

    public int f() {
        return this.c + 1;
    }

    public char g() {
        return h(this.b);
    }

    public int h() {
        return this.b;
    }

    public char i(int i) {
        int iE = e(i);
        if (iE == -1) {
            return ' ';
        }
        return a(iE);
    }

    public a j() {
        while (d() && this.b < this.c && a() == ' ') {
            d(1);
        }
        return this;
    }

    public boolean a(char c) {
        return this.a.charAt(this.b) == c;
    }

    public int b(char c) {
        return a(this.b, c);
    }

    public boolean c(char c) {
        return this.a.charAt(this.c) == c;
    }

    public boolean d(char c) {
        return c(this.b + 1) && this.a.charAt(this.b + 1) == c;
    }

    public int e(char c) {
        return c(this.b, c);
    }

    public boolean f(char c) {
        return d(this.b, c);
    }

    public void g(char c) {
        if (j().a() != c) {
            throw new sdk.pendo.io.d1.f(String.format("Expected character: %c", Character.valueOf(c)));
        }
        d(1);
    }

    public boolean a(CharSequence charSequence) {
        j();
        if (!c((this.b + charSequence.length()) - 1)) {
            return false;
        }
        int i = this.b;
        if (!a(i, charSequence.length() + i).equals(charSequence)) {
            return false;
        }
        d(charSequence.length());
        return true;
    }

    public int b(int i, char c) {
        while (!g(i)) {
            if (a(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int c(int i, char c) {
        boolean z = false;
        for (int i2 = i + 1; !g(i2); i2++) {
            if (z) {
                z = false;
            } else if ('\\' == a(i2)) {
                z = true;
            } else if (c == a(i2)) {
                return i2;
            }
        }
        return -1;
    }

    public boolean d(int i, char c) {
        int i2 = i + 1;
        while (!g(i2) && a(i2) == ' ') {
            i2++;
        }
        return !g(i2) && a(i2) == c;
    }

    public int a(int i, boolean z, boolean z2) {
        return a(i, '(', ')', z, z2);
    }

    public int a(int i, char c, char c2, boolean z, boolean z2) {
        char cA;
        if (a(i) != c) {
            throw new sdk.pendo.io.d1.f("Expected " + c + " but found " + a(i));
        }
        int i2 = 1;
        int i3 = i + 1;
        while (c(i3)) {
            if (z && ((cA = a(i3)) == '\'' || cA == '\"')) {
                int iC = c(i3, cA);
                if (iC == -1) {
                    throw new sdk.pendo.io.d1.f("Could not find matching close quote for " + cA + " when parsing : " + ((Object) this.a));
                }
                i3 = iC + 1;
            }
            if (z2 && a(i3) == '/') {
                int iC2 = c(i3, '/');
                if (iC2 == -1) {
                    throw new sdk.pendo.io.d1.f("Could not find matching close for / when parsing regex in : " + ((Object) this.a));
                }
                i3 = iC2 + 1;
            }
            if (a(i3) == c) {
                i2++;
            }
            if (a(i3) == c2 && (i2 = i2 - 1) == 0) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int a(int i, char c) {
        do {
            i++;
            if (g(i)) {
                break;
            }
        } while (a(i) == ' ');
        if (a(i) == c) {
            return i;
        }
        return -1;
    }

    public CharSequence a(int i, int i2) {
        return this.a.subSequence(i, i2);
    }
}
