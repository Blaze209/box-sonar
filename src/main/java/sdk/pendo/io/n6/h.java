package sdk.pendo.io.n6;

import java.util.Arrays;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements sdk.pendo.io.a5.a.InterfaceC0343a {
    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got error: " + (objArr != null ? Arrays.toString(objArr) : ""), new Object[0]);
        Object obj = objArr != null ? objArr[0] : null;
        if (obj != null) {
            sdk.pendo.io.s7.a.a.b(obj.toString());
        }
        sdk.pendo.io.p6.b.a(objArr);
    }
}
