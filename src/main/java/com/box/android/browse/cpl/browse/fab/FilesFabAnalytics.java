package com.box.android.browse.cpl.browse.fab;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: FilesFabAnalytics.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabAnalytics;", "", "<init>", "()V", "fabClicked", "", "fabContentViewed", "uploadContentMenuViewed", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesFabAnalytics {
    public static final int $stable = 0;

    @Inject
    public FilesFabAnalytics() {
    }

    public final void fabClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_ADD_CTA_TRIGGERED);
    }

    public final void fabContentViewed() {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_FAB)) {
            BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_UPLOAD);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, Arrays.copyOf(new Object[]{BoxAnalyticsParams.PAGE_NAME_FAB}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            flow.logEvent(str);
        }
    }

    public final void uploadContentMenuViewed() {
        if (BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_UPLOAD_CONTENT)) {
            BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_UPLOAD);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(BoxAnalyticsParams.EVENT_PAGE_VIEWED_TEMPLATE, Arrays.copyOf(new Object[]{BoxAnalyticsParams.PAGE_NAME_UPLOAD_CONTENT}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            flow.logEvent(str);
        }
    }
}
