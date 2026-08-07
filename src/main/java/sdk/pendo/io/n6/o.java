package sdk.pendo.io.n6;

import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements sdk.pendo.io.a5.a.InterfaceC0343a {
    private void a() {
        JSONObject jSONObject = new JSONObject();
        sdk.pendo.io.p6.b.a(jSONObject, true);
        sdk.pendo.io.p6.b.a(sdk.pendo.io.m6.a.EVENT_TEST_MODE_ENTERED.b(), jSONObject);
    }

    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got testModeEnter", new Object[0]);
        sdk.pendo.io.o6.a.d().a(sdk.pendo.io.o6.a.d.EVENT_TEST_MODE_ENTER, objArr);
        if (sdk.pendo.io.o6.a.d().s()) {
            a();
        }
    }
}
