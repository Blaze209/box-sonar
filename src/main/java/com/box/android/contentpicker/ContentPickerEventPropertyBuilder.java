package com.box.android.contentpicker;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentPickerAnalytics.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0017\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerEventPropertyBuilder;", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;", "<init>", "()V", "setViewId", "viewId", "", "setSessionId", "sessionId", "setHostAppName", "hostAppName", "setAction", "action", "setComponent", ContentPickerEventPropertyBuilder.PROPERTY_COMPONENT, "Companion", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ContentPickerEventPropertyBuilder extends BoxAmplitudeAnalytics.EventPropertyBuilder {
    private static final String PROPERTY_ACTION = "action";
    private static final String PROPERTY_COMPONENT = "component";
    private static final String PROPERTY_HOST_APP_NAME = "host_app_name";
    private static final String PROPERTY_SESSION_ID = "session_id";
    private static final String PROPERTY_VIEW_ID = "view_id";
    public static final int $stable = 8;

    @Inject
    public ContentPickerEventPropertyBuilder() {
    }

    public final ContentPickerEventPropertyBuilder setViewId(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        setProperty(PROPERTY_VIEW_ID, viewId);
        return this;
    }

    public final ContentPickerEventPropertyBuilder setSessionId(String sessionId) {
        setProperty("session_id", sessionId);
        return this;
    }

    public final ContentPickerEventPropertyBuilder setHostAppName(String hostAppName) {
        setProperty(PROPERTY_HOST_APP_NAME, hostAppName);
        return this;
    }

    public final ContentPickerEventPropertyBuilder setAction(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        setProperty("action", action);
        return this;
    }

    public final ContentPickerEventPropertyBuilder setComponent(String component) {
        setProperty(PROPERTY_COMPONENT, component);
        return this;
    }
}
