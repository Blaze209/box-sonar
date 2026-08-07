package sdk.pendo.io.network.interfaces;

import kotlin.Metadata;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.models.networkReponses.RegisterDeviceResponse;
import sdk.pendo.io.n4.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lsdk/pendo/io/network/interfaces/RegisterDevice;", "", "Lsdk/pendo/io/e2/c0;", "json", "Lsdk/pendo/io/k3/j;", "Lsdk/pendo/io/l4/r;", "Lsdk/pendo/io/models/networkReponses/RegisterDeviceResponse;", "registerDevice", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface RegisterDevice {
    @o("v2/devices/register")
    j<r<RegisterDeviceResponse>> registerDevice(@sdk.pendo.io.n4.a c0 json);
}
