package com.box.android.domain.usecases.jobs;

import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: JobTags.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/usecases/jobs/JobTags;", "", "<init>", "()V", "CREATE_FOLDER", "", "CHUNK_UPLOAD", "UPLOAD_FILE_V2", "DELETE_FILE", "DELETE_COLLABORATION", "JOB_SOURCE", "DOWNLOAD_FILE_JOB", "UPLOAD_FOLDER", "MOVE_ITEM", "COPY_ITEM", "AUTO_UPLOAD", "MARK_FOR_OFFLINE", "JobSource", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobTags {
    public static final String AUTO_UPLOAD = "auto_upload";
    public static final String CHUNK_UPLOAD = "chunk_upload";
    public static final String COPY_ITEM = "copy_item";
    public static final String CREATE_FOLDER = "create_folder";
    public static final String DELETE_COLLABORATION = "delete_collaboration";
    public static final String DELETE_FILE = "delete_file";
    public static final String DOWNLOAD_FILE_JOB = "download_file_job";
    public static final JobTags INSTANCE = new JobTags();
    public static final String JOB_SOURCE = "job_source";
    public static final String MARK_FOR_OFFLINE = "mark_offline";
    public static final String MOVE_ITEM = "move_item";
    public static final String UPLOAD_FILE_V2 = "upload_file_v2";
    public static final String UPLOAD_FOLDER = "upload_folder";

    private JobTags() {
    }

    /* JADX INFO: compiled from: JobTags.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SHARE_SHEET", "CAPTURE_UPLOAD", "SCAN_DOCUMENT", "VIDEO", "AUDIO_RECORDING", "AUTO_UPLOAD", "FAB_FOLDER", "FAB_FILE", "NEW_VERSION_UPLOAD", "UPLOAD_CACHED", "OFFLINE_SAVE_BROWSE", "OFFLINE_SAVE_PREVIEW", "OFFLINE_UPDATE", "OFFLINE", "DOWNLOAD_FROM_BROWSE", "DOWNLOAD_FROM_PREVIEW", "DOWNLOAD_FOLDER", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum JobSource {
        SHARE_SHEET("share sheet"),
        CAPTURE_UPLOAD("capture"),
        SCAN_DOCUMENT("scan_document"),
        VIDEO("video upload"),
        AUDIO_RECORDING("audio recording upload"),
        AUTO_UPLOAD("auto upload"),
        FAB_FOLDER("fab folder"),
        FAB_FILE("fab file"),
        NEW_VERSION_UPLOAD("new version"),
        UPLOAD_CACHED("upload cached file"),
        OFFLINE_SAVE_BROWSE("offline save browse"),
        OFFLINE_SAVE_PREVIEW("offline save preview"),
        OFFLINE_UPDATE("offline update"),
        OFFLINE(BoxRecentItemSQLData.OFFLINE_COLUMN_NAME),
        DOWNLOAD_FROM_BROWSE("download browse"),
        DOWNLOAD_FROM_PREVIEW("download preview"),
        DOWNLOAD_FOLDER("download folder");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries<JobSource> getEntries() {
            return $ENTRIES;
        }

        JobSource(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }
}
