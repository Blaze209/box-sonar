package sdk.pendo.io.u1;

import java.io.IOException;
import sdk.pendo.io.r1.g;
import sdk.pendo.io.r1.i;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e<Object> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.u1.e
    public <E> void a(E e, Appendable appendable, g gVar) throws IOException {
        gVar.c(appendable);
        boolean z = false;
        for (Object obj : (Object[]) e) {
            if (z) {
                gVar.i(appendable);
            } else {
                z = true;
            }
            i.a(obj, appendable, gVar);
        }
        gVar.d(appendable);
    }
}
