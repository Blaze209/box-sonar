package sdk.pendo.io.sdk.flutter;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IFlutterBridge {
    String generateBitmap();

    void prepareDataForCapture();

    void registerForEvents(IFlutterEventsCallback iFlutterEventsCallback);

    default void setSRConfig(Map<String, Object> map) {
    }
}
