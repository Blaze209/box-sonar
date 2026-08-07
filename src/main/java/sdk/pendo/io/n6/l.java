package sdk.pendo.io.n6;

import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements sdk.pendo.io.a5.a.InterfaceC0343a {
    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got Connected", new Object[0]);
        sdk.pendo.io.p6.b.a("dummySocketEvent", new JSONObject());
        sdk.pendo.io.o6.a.d();
        sdk.pendo.io.o6.a.c(Boolean.TRUE);
        sdk.pendo.io.o6.a.d().a(sdk.pendo.io.o6.a.d.EVENT_SOCKET_CONNECTED, objArr);
    }
}
