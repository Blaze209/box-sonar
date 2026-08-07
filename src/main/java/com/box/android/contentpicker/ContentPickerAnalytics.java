package com.box.android.contentpicker;

import com.box.android.domain.analytics.AiCenterSessionInfoProvider;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentPickerAnalytics.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerAnalytics;", "", "contentPickerEventPropertyBuilder", "Lcom/box/android/contentpicker/ContentPickerEventPropertyBuilder;", "aiCenterSessionInfoProvider", "Lcom/box/android/domain/analytics/AiCenterSessionInfoProvider;", "<init>", "(Lcom/box/android/contentpicker/ContentPickerEventPropertyBuilder;Lcom/box/android/domain/analytics/AiCenterSessionInfoProvider;)V", "logViewChanged", "", "viewId", "", "Companion", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContentPickerAnalytics {
    private static final String VALUE_ACTION_CLICK = "click";
    private final AiCenterSessionInfoProvider aiCenterSessionInfoProvider;
    private final ContentPickerEventPropertyBuilder contentPickerEventPropertyBuilder;
    public static final int $stable = 8;

    @Inject
    public ContentPickerAnalytics(ContentPickerEventPropertyBuilder contentPickerEventPropertyBuilder, AiCenterSessionInfoProvider aiCenterSessionInfoProvider) {
        Intrinsics.checkNotNullParameter(contentPickerEventPropertyBuilder, "contentPickerEventPropertyBuilder");
        Intrinsics.checkNotNullParameter(aiCenterSessionInfoProvider, "aiCenterSessionInfoProvider");
        this.contentPickerEventPropertyBuilder = contentPickerEventPropertyBuilder;
        this.aiCenterSessionInfoProvider = aiCenterSessionInfoProvider;
    }

    public final void logViewChanged(String viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        this.contentPickerEventPropertyBuilder.setViewId(viewId).setSessionId(this.aiCenterSessionInfoProvider.getSessionId()).setHostAppName(this.aiCenterSessionInfoProvider.getHostAppName()).setAction(VALUE_ACTION_CLICK).setComponent(this.aiCenterSessionInfoProvider.getStyleName()).logEvent(BoxAnalyticsParams.EVENT_CONTENT_PICKER_VIEW_CHANGED);
    }
}
