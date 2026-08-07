package sdk.pendo.io.r5;

import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.actions.PendoCommandAction;

/* JADX INFO: loaded from: classes4.dex */
public enum d {
    GUIDE_RECEIVED("guideReceived"),
    GUIDE_SEEN("guideSeen"),
    GUIDE_NOT_SEEN("guideNotSeen"),
    GUIDE_DISPLAYED("guideDisplayed"),
    GUIDE_DISMISSED(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.GUIDE_DISMISSED),
    GUIDE_NOT_DISPLAYED("guideNotDisplayed"),
    APP_SCREEN_LEFT("AppScreenLeft"),
    CUSTOM_EVENT_OCCURRED("CustomEventOccurred"),
    TRACK_EVENT("trackEvent"),
    FORM_SUBMITTED("FormSubmitted"),
    POLL_RESPONSE("pollResponse"),
    PAGER_FLOW("PagerFlow"),
    APP_SESSION_START("AppSessionStart"),
    APP_SESSION_END("AppSessionEnd"),
    APP_IN_BACKGROUND("AppInBackground"),
    APP_IN_FOREGROUND("AppInForeground"),
    APP_SCREEN_VIEWED("AppScreenViewed"),
    APP_BUTTON_CLICKED("AppButtonClicked"),
    LIST_ITEM_CLICKED("ListItemClicked"),
    SDK_EXCEPTION("SdkException"),
    SDK_ERROR("SdkError"),
    SECURITY_EXCEPTION("SecurityException"),
    IDENTIFY("identify"),
    APP_OFFLINE("AppOffline"),
    APP_ONLINE("AppOnline"),
    APP_OFFLINE_LIMIT_REACHED("AppOfflineLimitReached"),
    UNKNOWN("Unknown");

    private static final Map<String, d> LOOKUP_BY_EVENT = new HashMap();
    private final String mValue;

    static {
        for (d dVar : values()) {
            LOOKUP_BY_EVENT.put(dVar.b(), dVar);
        }
    }

    d(String str) {
        this.mValue = str;
    }

    public String b() {
        return this.mValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mValue;
    }

    public static d a(String str) {
        d dVar = LOOKUP_BY_EVENT.get(str);
        return dVar != null ? dVar : UNKNOWN;
    }
}
