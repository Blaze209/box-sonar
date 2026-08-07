package sdk.pendo.io.n6;

import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements sdk.pendo.io.a5.a.InterfaceC0343a {
    private void a(boolean z) {
        if (z) {
            JSONObject jSONObject = new JSONObject();
            sdk.pendo.io.p6.b.a(jSONObject, true);
            sdk.pendo.io.p6.b.a(sdk.pendo.io.m6.a.EVENT_PREVIEW_DISPLAYED.b(), jSONObject);
        }
    }

    @Override // sdk.pendo.io.a5.a.InterfaceC0343a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got previewOnDevice", new Object[0]);
        sdk.pendo.io.o6.a.d().a(sdk.pendo.io.o6.a.d.EVENT_PREVIEW_ON_DEVICE, objArr);
        a(true);
    }
}
