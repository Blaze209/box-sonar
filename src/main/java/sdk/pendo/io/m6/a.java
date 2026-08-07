package sdk.pendo.io.m6;

import com.facebook.hermes.intl.Constants;

/* JADX INFO: loaded from: classes4.dex */
public enum a {
    EVENT_PAIRED_MODE_UPDATE("updatePairedMode"),
    EVENT_PAIRED_MODE_UPDATED("pairedModeUpdated"),
    EVENT_RESET_STATE("resetState"),
    EVENT_PREVIEW_ON_DEVICE("previewOnDevice"),
    EVENT_PREVIEW_DISPLAYED("previewDisplayed"),
    EVENT_CAPTURE_MODE_ENTER("enterCaptureMode"),
    EVENT_CAPTURE_MODE_ENTERED("captureModeEntered"),
    EVENT_CAPTURE_MODE_EXIT("exitCaptureMode"),
    EVENT_CAPTURE_MODE_EXITED("captureModeExited"),
    EVENT_PREPARE_TO_RECEIVE_SCREEN("prepareToReceiveScreen"),
    EVENT_READY_TO_RECEIVE_SCREEN("readyToReceiveScreen"),
    EVENT_SCREEN_CAPTURED("screenCaptured"),
    EVENT_CAPTURE_MODE_SCREEN_RECEIVED("screenReceived"),
    EVENT_TEST_MODE_ENTER("enterTestMode"),
    EVENT_TEST_MODE_ENTERED("testModeEntered"),
    EVENT_TEST_MODE_EXIT("exitTestMode"),
    EVENT_TEST_MODE_EXITED("testModeExited"),
    EVENT_DEBUG_MODE_ENTER("enterDebugMode"),
    EVENT_DEBUG_MODE_ENTERED("debugModeEntered"),
    EVENT_DEBUG_MODE_EXIT("exitDebugMode"),
    EVENT_DEBUG_MODE_EXITED("debugModeExited"),
    EVENT_DEBUG_MODE_LOG("log"),
    EVENT_DEBUG_MODE_EVENT("event"),
    EVENT_DEBUG_MODE_RECORDING_EVENT("recordingEvent"),
    EVENT_TERMINATE("terminateSession"),
    EVENT_INVALID(Constants.COLLATION_INVALID);

    public static final String EVENT_SUCCESS = "isSuccessful";
    private final String mCommand;

    a(String str) {
        this.mCommand = str;
    }

    public String b() {
        return this.mCommand;
    }
}
