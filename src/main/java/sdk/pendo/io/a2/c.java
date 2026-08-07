package sdk.pendo.io.a2;

import java.io.Writer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class c extends b {
    @Override // sdk.pendo.io.a2.b
    public final int a(CharSequence charSequence, int i, Writer writer) {
        return a(Character.codePointAt(charSequence, i), writer) ? 1 : 0;
    }

    public abstract boolean a(int i, Writer writer);
}
