package sdk.pendo.io.r0;

import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes4.dex */
class h {
    private static sdk.pendo.io.m0.a.C0418a a(sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return (bVar == null || !KeyManagementAlgorithmIdentifiers.DIRECT.equals(bVar.c("alg"))) ? aVar.a() : aVar.c();
    }

    static String b(sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return a(bVar, aVar).a();
    }

    static String c(sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return a(bVar, aVar).e();
    }
}
