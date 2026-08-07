package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class c extends Exception {
    private List<b.a> a;
    private g b;

    public c(String str, b.a aVar, Throwable th, g gVar) {
        super(str, th);
        this.a = Collections.emptyList();
        this.b = gVar;
        this.a = Collections.singletonList(aVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getMessage());
        if (!this.a.isEmpty()) {
            sb.append(" Additional details: ");
            sb.append(this.a);
        }
        return sb.toString();
    }

    public c(String str, List<b.a> list, g gVar) {
        super(str);
        Collections.emptyList();
        this.a = list;
        this.b = gVar;
    }
}
