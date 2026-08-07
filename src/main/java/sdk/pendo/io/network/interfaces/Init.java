package sdk.pendo.io.network.interfaces;

import sdk.pendo.io.k3.j;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.n4.f;
import sdk.pendo.io.n4.t;

/* JADX INFO: loaded from: classes4.dex */
public interface Init {
    @f("v2/devices/init")
    j<r<InitModel>> initSdk(@t("withContent") int i);
}
