package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class d extends c {
    public d(sdk.pendo.io.u0.e eVar, g gVar) {
        super("JWT rejected due to invalid signature.", Collections.singletonList(new b.a(9, "Invalid JWS Signature: " + eVar)), gVar);
    }
}
