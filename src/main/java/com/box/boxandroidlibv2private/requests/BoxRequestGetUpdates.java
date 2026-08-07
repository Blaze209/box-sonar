package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestsEvent;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetUpdates extends BoxRequestsEvent.GetUserEvents {
    private static final String FIELD_EVENT_TYPES = "event_types";
    public static final String URI = "internal_updates";

    public BoxRequestGetUpdates(String str, BoxSession boxSession) {
        super(str, boxSession);
    }

    public static String getUri() {
        return URI;
    }

    public BoxRequestGetUpdates setEventTypes(String... strArr) {
        if (strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                sb.append(String.format(Locale.ENGLISH, ",%s", strArr[i]));
            }
            this.mQueryMap.put(FIELD_EVENT_TYPES, sb.toString());
        }
        return this;
    }
}
