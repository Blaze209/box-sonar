package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsEvent;
import com.box.androidsdk.content.utils.RealTimeServerConnection;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiEvent extends BoxApi {
    public static final String EVENTS_ENDPOINT = "/events";

    public BoxApiEvent(BoxSession boxSession) {
        super(boxSession);
    }

    protected String getEventsUrl() {
        return getBaseUri() + EVENTS_ENDPOINT;
    }

    public BoxRequestsEvent.GetUserEvents getUserEventsRequest() {
        return new BoxRequestsEvent.GetUserEvents(getEventsUrl(), this.mSession);
    }

    public BoxRequestsEvent.GetEnterpriseEvents getEnterpriseEventsRequest() {
        return new BoxRequestsEvent.GetEnterpriseEvents(getEventsUrl(), this.mSession);
    }

    public RealTimeServerConnection getLongPollServerConnection(RealTimeServerConnection.OnChangeListener onChangeListener) {
        return new RealTimeServerConnection(new BoxRequestsEvent.EventRealTimeServerRequest(getEventsUrl(), this.mSession), onChangeListener, this.mSession);
    }
}
