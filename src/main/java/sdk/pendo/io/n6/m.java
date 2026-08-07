package sdk.pendo.io.n6;

import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements sdk.pendo.io.a5.a.InterfaceC0343a {
    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got Disconnect", new Object[0]);
        sdk.pendo.io.o6.a.d();
        sdk.pendo.io.o6.a.c(Boolean.FALSE);
        sdk.pendo.io.o6.a.d().a(sdk.pendo.io.o6.a.d.EVENT_SOCKET_DISCONNECTED, objArr);
    }
}
