package sdk.pendo.io.a2;

import java.io.Writer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class a extends b {
    private final b[] b;

    public a(b... bVarArr) {
        this.b = (b[]) sdk.pendo.io.w1.b.a((Object[]) bVarArr);
    }

    @Override // sdk.pendo.io.a2.b
    public int a(CharSequence charSequence, int i, Writer writer) {
        for (b bVar : this.b) {
            int iA = bVar.a(charSequence, i, writer);
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }
}
