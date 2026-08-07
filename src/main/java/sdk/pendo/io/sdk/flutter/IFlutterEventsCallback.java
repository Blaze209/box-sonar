package sdk.pendo.io.sdk.flutter;

import com.box.androidsdk.content.models.BoxRepresentation;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&J \u0010\f\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&J \u0010\r\u001a\u00020\u00032\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/sdk/flutter/IFlutterEventsCallback;", "", "clickActionDetected", "", "retroElementInfo", "", "", "newScreenIdentified", "screenName", BoxRepresentation.FIELD_INFO, "screenContentChanged", "screenDataForCaptureReady", "sendLogToBE", "sendSREventData", "srEventData", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IFlutterEventsCallback {
    void clickActionDetected(Map<String, ? extends Object> retroElementInfo);

    void newScreenIdentified(String screenName, Map<String, ? extends Object> info);

    void screenContentChanged(String screenName, Map<String, ? extends Object> info);

    void screenDataForCaptureReady(Map<String, ? extends Object> info);

    void sendLogToBE(Map<String, ? extends Object> info);

    void sendSREventData(Map<String, ? extends Object> srEventData);
}
