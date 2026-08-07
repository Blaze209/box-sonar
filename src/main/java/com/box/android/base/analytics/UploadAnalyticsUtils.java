package com.box.android.base.analytics;

import android.net.Uri;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.text.ParseException;

/* JADX INFO: loaded from: classes9.dex */
public class UploadAnalyticsUtils {
    public static BoxAmplitudeAnalytics.EventPropertyBuilder newUploadFlowCtaEventBuilder() {
        return BoxAmplitudeAnalytics.createEventBuilder().setCtaPageLocation(BoxAnalyticsParams.CTA_LOCATION_NATIVE_OVERLAY).setFlow(BoxAnalyticsParams.FLOW_UPLOAD).setMobileCtaType(BoxAnalyticsParams.TAP).setTimeOnPage();
    }

    public static void logNewFileUploadCtaEvent(String str, long j) {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderNewUploadFlowCtaEventBuilder = newUploadFlowCtaEventBuilder();
        String fileExtension = CommonBoxUtil.getFileExtension(str, "");
        eventPropertyBuilderNewUploadFlowCtaEventBuilder.setFileType(BoxAnalyticsParams.INSTANCE.calculateFileType(fileExtension));
        eventPropertyBuilderNewUploadFlowCtaEventBuilder.setFileExtension(fileExtension).setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_SINGLE_FILE_UPLOAD).setFileSize(j).logEvent(BoxAnalyticsParams.EVENT_UPLOAD_TRIGGERED);
    }

    public static void logNewFileUploadCtaEvent(Uri uri) {
        try {
            UploadModelBoxFile uri2 = BoxStaticUploadModel.parseUri(uri);
            logNewFileUploadCtaEvent(uri2.getFileName(), (long) uri2.getSize());
        } catch (ParseException e) {
            BoxLogUtils.e(UploadAnalyticsUtils.class.getName(), e);
        }
    }

    public static void logUploadFlowCancelCtaEvent(String str) {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_UPLOAD);
        eventPropertyBuilderCreateEventBuilder.setCtaPageLocation(str);
        eventPropertyBuilderCreateEventBuilder.logEvent(BoxAnalyticsParams.EVENT_CANCEL_TRIGGERED);
    }
}
