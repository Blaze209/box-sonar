package com.box.android.data.persistence.logging;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.metrics.preview.PreviewObservability;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MetricsEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010)\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006*"}, d2 = {"Lcom/box/android/data/persistence/logging/MetricsEventType;", "", "logType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogType", "()Ljava/lang/String;", "METRIC", "WARNING", "ERROR", "CRASH", "SEARCH_API", "PREVIEW", "PREVIEW_PM23", "PREVIOUS_VERSION_PREVIEW_PM23", "FOLDER_UPLOAD", "AUTO_UPLOAD", "FILE_UPLOAD", "PREVIEW_TTI", "ALL_FILES_LOAD_TTI", "FOLDER_LOAD_TTI", "MOVE", "COPY", "FOLDER_LOAD_TTI_V2", "FOLDER_FULL_LOAD", "FOLDER_LOAD_PAGE", "FILE_DOWNLOAD", "FILE_ACTIVITY", "BOX_AI", "HUBS", "APDEX", "MSAL_LOGIN", "MSAL_REMEDIATE", "MSAL_POLICY_BLOCKED", "LOGIN", "REGISTER", "FORCE_UPDATE", "MARK_FOR_OFFLINE_FILE", "MARK_FOR_OFFLINE_FOLDER", "WATERMARK_UPDATE", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum MetricsEventType {
    METRIC(""),
    WARNING("warning"),
    ERROR("error"),
    CRASH("crash"),
    SEARCH_API("search_api"),
    PREVIEW(BoxAnalyticsParams.CTA_PAGE_PREVIEW),
    PREVIEW_PM23("preview_pm23"),
    PREVIOUS_VERSION_PREVIEW_PM23("previous_version_preview"),
    FOLDER_UPLOAD("folder_upload"),
    AUTO_UPLOAD("auto_upload"),
    FILE_UPLOAD("file_upload"),
    PREVIEW_TTI(PreviewObservability.PREVIEW_SUCCESS_PREFIX),
    ALL_FILES_LOAD_TTI("all_files_load_tti"),
    FOLDER_LOAD_TTI("folder_load_tti"),
    MOVE(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB),
    COPY(BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB),
    FOLDER_LOAD_TTI_V2("folder_load_tti_v2"),
    FOLDER_FULL_LOAD("folder_full_load"),
    FOLDER_LOAD_PAGE("folder_load_page"),
    FILE_DOWNLOAD("file_download"),
    FILE_ACTIVITY("file_activity"),
    BOX_AI("box_ai"),
    HUBS("hubs"),
    APDEX("apdex"),
    MSAL_LOGIN("msal_login"),
    MSAL_REMEDIATE("msal_remediate"),
    MSAL_POLICY_BLOCKED("msal_policy_blocked"),
    LOGIN("login"),
    REGISTER("register"),
    FORCE_UPDATE("force_update"),
    MARK_FOR_OFFLINE_FILE("mark_for_offline_file"),
    MARK_FOR_OFFLINE_FOLDER("mark_for_offline_folder"),
    WATERMARK_UPDATE("watermark_update");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String logType;

    public static EnumEntries<MetricsEventType> getEntries() {
        return $ENTRIES;
    }

    MetricsEventType(String str) {
        this.logType = str;
    }

    public final String getLogType() {
        return this.logType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.logType;
    }
}
