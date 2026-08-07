package sdk.pendo.io.u1;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.r1.g;
import sdk.pendo.io.r1.h;

/* JADX INFO: loaded from: classes5.dex */
public class c implements e<Object> {
    @Override // sdk.pendo.io.u1.e
    public <E> void a(E e, Appendable appendable, g gVar) throws IOException {
        sdk.pendo.io.p1.d dVarA = sdk.pendo.io.p1.d.a(e.getClass(), h.a);
        appendable.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = false;
        for (sdk.pendo.io.p1.b bVar : dVarA.a()) {
            Object objA = dVarA.a(e, bVar.b());
            if (objA != null || !gVar.a()) {
                if (z) {
                    appendable.append(AbstractJsonLexerKt.COMMA);
                } else {
                    z = true;
                }
                sdk.pendo.io.r1.d.a(bVar.c(), objA, appendable, gVar);
            }
        }
        appendable.append(AbstractJsonLexerKt.END_OBJ);
    }
}
