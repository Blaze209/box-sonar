package sdk.pendo.io.a2;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class e extends j {
    public e(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    public static e a(int i, int i2) {
        return new e(i, i2, false);
    }

    @Override // sdk.pendo.io.a2.j
    protected String b(int i) {
        char[] chars = Character.toChars(i);
        return "\\u" + b.a(chars[0]) + "\\u" + b.a(chars[1]);
    }
}
