package com.box.android.base.analytics;

import android.content.Context;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;

/* JADX INFO: loaded from: classes9.dex */
public class DownloadAnalyticsUtils {
    public static BoxAmplitudeAnalytics.BackgroundEventPropertyBuilder createDownloadErrorBuilder(Exception exc, BoxFile boxFile, Context context) {
        BoxAmplitudeAnalytics.BackgroundEventPropertyBuilder backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder = BoxAmplitudeAnalytics.createBackgroundEventPropertyBuilder();
        backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        if (boxFile != null) {
            backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setBoxItem(boxFile);
        }
        if (exc instanceof BoxException.CorruptedContentException) {
            BoxException.CorruptedContentException corruptedContentException = (BoxException.CorruptedContentException) exc;
            backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setError(BoxAnalyticsParams.ERROR_TYPE_INTEGRITY, String.format(BoxAnalyticsParams.ERROR_TEXT_MISMATCH_SHA1_TEMPLATE, corruptedContentException.getExpectedSha1(), corruptedContentException.getReceivedSha1()), BoxAnalyticsParams.ERROR_CODE_INVALID_HASH);
            backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setErrorOrigin("unknown");
            return backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder;
        }
        backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setError(exc);
        return backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder;
    }

    public static BoxAmplitudeAnalytics.BackgroundEventPropertyBuilder createBuilder(BoxFile boxFile, Context context) {
        BoxAmplitudeAnalytics.BackgroundEventPropertyBuilder backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder = BoxAmplitudeAnalytics.createBackgroundEventPropertyBuilder();
        backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        if (boxFile != null) {
            backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder.setBoxItem(boxFile);
        }
        return backgroundEventPropertyBuilderCreateBackgroundEventPropertyBuilder;
    }
}
