package sdk.pendo.io.n6;

import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements sdk.pendo.io.a5.a.InterfaceC0343a {
    private void a() {
        JSONObject jSONObject = new JSONObject();
        sdk.pendo.io.p6.b.a(jSONObject, true);
        sdk.pendo.io.p6.b.a(sdk.pendo.io.m6.a.EVENT_DEBUG_MODE_EXITED.b(), jSONObject);
    }

    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got: debugModeExit", new Object[0]);
        sdk.pendo.io.o6.a.d().a(sdk.pendo.io.o6.a.d.EVENT_DEBUG_MODE_EXIT, new Object[0]);
        if (sdk.pendo.io.o6.a.d().c().equals(sdk.pendo.io.o6.a.g.STATE_PAIRED)) {
            a();
        }
    }
}
