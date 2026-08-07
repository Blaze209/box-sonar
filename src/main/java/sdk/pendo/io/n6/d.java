package sdk.pendo.io.n6;

import java.util.Arrays;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements sdk.pendo.io.a5.a.InterfaceC0343a {
    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got connection error: " + (objArr != null ? Arrays.toString(objArr) : ""), new Object[0]);
        sdk.pendo.io.p6.b.a(objArr);
    }
}
