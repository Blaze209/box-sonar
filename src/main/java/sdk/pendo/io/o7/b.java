package sdk.pendo.io.o7;

import com.box.androidsdk.content.models.BoxRepresentation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.sdk.flutter.IFlutterEventsCallback;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J \u0010\n\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J \u0010\r\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/o7/b;", "Lsdk/pendo/io/sdk/flutter/IFlutterEventsCallback;", "", "screenName", "", "", BoxRepresentation.FIELD_INFO, "", "newScreenIdentified", "screenContentChanged", "screenDataForCaptureReady", "retroElementInfo", "clickActionDetected", "sendLogToBE", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class b implements IFlutterEventsCallback {
    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void clickActionDetected(Map<String, ? extends Object> retroElementInfo) {
        Intrinsics.checkNotNullParameter(retroElementInfo, "retroElementInfo");
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void newScreenIdentified(String screenName, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void screenContentChanged(String screenName, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(info, "info");
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void screenDataForCaptureReady(Map<String, ? extends Object> info) {
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void sendLogToBE(Map<String, ? extends Object> info) {
    }
}
