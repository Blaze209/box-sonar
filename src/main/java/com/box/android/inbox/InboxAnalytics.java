package com.box.android.inbox;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: InboxAnalytics.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/inbox/InboxAnalytics;", "", "<init>", "()V", "inboxScreenViewed", "", "notificationsTabScreenViewed", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxAnalytics {
    public static final int $stable = 0;

    @Inject
    public InboxAnalytics() {
    }

    public final void inboxScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_INBOX_SCREEN_VIEWED);
    }

    public final void notificationsTabScreenViewed() {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_NOTIFICATIONS)) {
            BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, Arrays.copyOf(new Object[]{BoxAnalyticsParams.PAGE_NAME_NOTIFICATIONS}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            flow.logEvent(str);
        }
    }
}
