package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class UiStartEvent extends BaseEvent {
    public UiStartEvent() {
        names(TelemetryEventStrings.Event.UI_START_EVENT);
        types(TelemetryEventStrings.EventType.UI_EVENT);
    }

    public UiStartEvent putUserAgent(AuthorizationAgent authorizationAgent) {
        if (authorizationAgent == null) {
            return this;
        }
        put(TelemetryEventStrings.Key.USER_AGENT, authorizationAgent.name());
        return this;
    }

    public UiStartEvent putLoginHint(String str) {
        put(TelemetryEventStrings.Key.LOGIN_HINT, str);
        return this;
    }

    public UiStartEvent isForcePrompt(boolean z) {
        put(TelemetryEventStrings.Key.IS_FORCE_PROMPT, String.valueOf(z));
        return this;
    }
}
