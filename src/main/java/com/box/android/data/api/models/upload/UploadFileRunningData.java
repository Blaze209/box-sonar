package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0013\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0006\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "", "type", "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "InitialData", "PreflightCheckData", "UploadWholeFileData", "SessionCreationData", "ChunkUploadingData", "CommitSessionData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$CommitSessionData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$InitialData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$PreflightCheckData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$SessionCreationData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData$UploadWholeFileData;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class UploadFileRunningData {
    private final String type;

    public /* synthetic */ UploadFileRunningData(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private UploadFileRunningData(@Json(name = "type") String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData$InitialData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "localItemId", "", "fileSize", "", "fileSha1", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getLocalItemId", "()Ljava/lang/String;", "getFileSize", "()J", "getFileSha1", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InitialData extends UploadFileRunningData {
        private final String fileSha1;
        private final long fileSize;
        private final String localItemId;

        public static /* synthetic */ InitialData copy$default(InitialData initialData, String str, long j, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = initialData.localItemId;
            }
            if ((i & 2) != 0) {
                j = initialData.fileSize;
            }
            if ((i & 4) != 0) {
                str2 = initialData.fileSha1;
            }
            return initialData.copy(str, j, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final InitialData copy(@Json String localItemId, @Json long fileSize, @Json String fileSha1) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            return new InitialData(localItemId, fileSize, fileSha1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitialData)) {
                return false;
            }
            InitialData initialData = (InitialData) other;
            return Intrinsics.areEqual(this.localItemId, initialData.localItemId) && this.fileSize == initialData.fileSize && Intrinsics.areEqual(this.fileSha1, initialData.fileSha1);
        }

        public int hashCode() {
            return (((this.localItemId.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileSha1.hashCode();
        }

        public String toString() {
            return "InitialData(localItemId=" + this.localItemId + ", fileSize=" + this.fileSize + ", fileSha1=" + this.fileSha1 + ")";
        }

        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitialData(@Json String localItemId, @Json long j, @Json String fileSha1) {
            super(UploadJobStates.INITIAL_STATE.getValue(), null);
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            this.localItemId = localItemId;
            this.fileSize = j;
            this.fileSha1 = fileSha1;
        }
    }

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData$PreflightCheckData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "localItemId", "", "fileSize", "", "fileSha1", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getLocalItemId", "()Ljava/lang/String;", "getFileSize", "()J", "getFileSha1", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PreflightCheckData extends UploadFileRunningData {
        private final String fileSha1;
        private final long fileSize;
        private final String localItemId;

        public static /* synthetic */ PreflightCheckData copy$default(PreflightCheckData preflightCheckData, String str, long j, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = preflightCheckData.localItemId;
            }
            if ((i & 2) != 0) {
                j = preflightCheckData.fileSize;
            }
            if ((i & 4) != 0) {
                str2 = preflightCheckData.fileSha1;
            }
            return preflightCheckData.copy(str, j, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final PreflightCheckData copy(@Json String localItemId, @Json long fileSize, @Json String fileSha1) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            return new PreflightCheckData(localItemId, fileSize, fileSha1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreflightCheckData)) {
                return false;
            }
            PreflightCheckData preflightCheckData = (PreflightCheckData) other;
            return Intrinsics.areEqual(this.localItemId, preflightCheckData.localItemId) && this.fileSize == preflightCheckData.fileSize && Intrinsics.areEqual(this.fileSha1, preflightCheckData.fileSha1);
        }

        public int hashCode() {
            return (((this.localItemId.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileSha1.hashCode();
        }

        public String toString() {
            return "PreflightCheckData(localItemId=" + this.localItemId + ", fileSize=" + this.fileSize + ", fileSha1=" + this.fileSha1 + ")";
        }

        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreflightCheckData(@Json String localItemId, @Json long j, @Json String fileSha1) {
            super(UploadJobStates.PREFLIGHT_CHECK_STATE.getValue(), null);
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            this.localItemId = localItemId;
            this.fileSize = j;
            this.fileSha1 = fileSha1;
        }
    }

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData$UploadWholeFileData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "localItemId", "", "fileSize", "", "fileSha1", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getLocalItemId", "()Ljava/lang/String;", "getFileSize", "()J", "getFileSha1", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UploadWholeFileData extends UploadFileRunningData {
        private final String fileSha1;
        private final long fileSize;
        private final String localItemId;

        public static /* synthetic */ UploadWholeFileData copy$default(UploadWholeFileData uploadWholeFileData, String str, long j, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uploadWholeFileData.localItemId;
            }
            if ((i & 2) != 0) {
                j = uploadWholeFileData.fileSize;
            }
            if ((i & 4) != 0) {
                str2 = uploadWholeFileData.fileSha1;
            }
            return uploadWholeFileData.copy(str, j, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final UploadWholeFileData copy(@Json String localItemId, @Json long fileSize, @Json String fileSha1) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            return new UploadWholeFileData(localItemId, fileSize, fileSha1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UploadWholeFileData)) {
                return false;
            }
            UploadWholeFileData uploadWholeFileData = (UploadWholeFileData) other;
            return Intrinsics.areEqual(this.localItemId, uploadWholeFileData.localItemId) && this.fileSize == uploadWholeFileData.fileSize && Intrinsics.areEqual(this.fileSha1, uploadWholeFileData.fileSha1);
        }

        public int hashCode() {
            return (((this.localItemId.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileSha1.hashCode();
        }

        public String toString() {
            return "UploadWholeFileData(localItemId=" + this.localItemId + ", fileSize=" + this.fileSize + ", fileSha1=" + this.fileSha1 + ")";
        }

        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UploadWholeFileData(@Json String localItemId, @Json long j, @Json String fileSha1) {
            super(UploadJobStates.UPLOAD_WHOLE_FILE_STATE.getValue(), null);
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            this.localItemId = localItemId;
            this.fileSize = j;
            this.fileSha1 = fileSha1;
        }
    }

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData$SessionCreationData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "localItemId", "", "fileSize", "", "fileSha1", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getLocalItemId", "()Ljava/lang/String;", "getFileSize", "()J", "getFileSha1", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SessionCreationData extends UploadFileRunningData {
        private final String fileSha1;
        private final long fileSize;
        private final String localItemId;

        public static /* synthetic */ SessionCreationData copy$default(SessionCreationData sessionCreationData, String str, long j, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionCreationData.localItemId;
            }
            if ((i & 2) != 0) {
                j = sessionCreationData.fileSize;
            }
            if ((i & 4) != 0) {
                str2 = sessionCreationData.fileSha1;
            }
            return sessionCreationData.copy(str, j, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final SessionCreationData copy(@Json String localItemId, @Json long fileSize, @Json String fileSha1) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            return new SessionCreationData(localItemId, fileSize, fileSha1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionCreationData)) {
                return false;
            }
            SessionCreationData sessionCreationData = (SessionCreationData) other;
            return Intrinsics.areEqual(this.localItemId, sessionCreationData.localItemId) && this.fileSize == sessionCreationData.fileSize && Intrinsics.areEqual(this.fileSha1, sessionCreationData.fileSha1);
        }

        public int hashCode() {
            return (((this.localItemId.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileSha1.hashCode();
        }

        public String toString() {
            return "SessionCreationData(localItemId=" + this.localItemId + ", fileSize=" + this.fileSize + ", fileSha1=" + this.fileSha1 + ")";
        }

        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionCreationData(@Json String localItemId, @Json long j, @Json String fileSha1) {
            super(UploadJobStates.UPLOAD_SESSION_CREATION_STATE.getValue(), null);
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            this.localItemId = localItemId;
            this.fileSize = j;
            this.fileSha1 = fileSha1;
        }
    }

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0003J}\u0010'\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n2\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0014\b\u0003\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n2\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006/"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData$ChunkUploadingData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "localItemId", "", "fileSize", "", "fileSha1", "sessionInfo", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "runningRequests", "", "chunksToUpload", "", "failedChunks", "succeededChunks", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Lcom/box/android/data/api/models/upload/UploadSessionDTO;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Set;)V", "getLocalItemId", "()Ljava/lang/String;", "getFileSize", "()J", "getFileSha1", "getSessionInfo", "()Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "getRunningRequests", "()Ljava/util/Map;", "getChunksToUpload", "()Ljava/util/Set;", "getFailedChunks", "getSucceededChunks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ChunkUploadingData extends UploadFileRunningData {
        private final Set<Long> chunksToUpload;
        private final Map<String, Long> failedChunks;
        private final String fileSha1;
        private final long fileSize;
        private final String localItemId;
        private final Map<String, Long> runningRequests;
        private final UploadSessionDTO sessionInfo;
        private final Set<UploadFileChunkDTO> succeededChunks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChunkUploadingData copy$default(ChunkUploadingData chunkUploadingData, String str, long j, String str2, UploadSessionDTO uploadSessionDTO, Map map, Set set, Map map2, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = chunkUploadingData.localItemId;
            }
            if ((i & 2) != 0) {
                j = chunkUploadingData.fileSize;
            }
            if ((i & 4) != 0) {
                str2 = chunkUploadingData.fileSha1;
            }
            if ((i & 8) != 0) {
                uploadSessionDTO = chunkUploadingData.sessionInfo;
            }
            if ((i & 16) != 0) {
                map = chunkUploadingData.runningRequests;
            }
            if ((i & 32) != 0) {
                set = chunkUploadingData.chunksToUpload;
            }
            if ((i & 64) != 0) {
                map2 = chunkUploadingData.failedChunks;
            }
            if ((i & 128) != 0) {
                set2 = chunkUploadingData.succeededChunks;
            }
            Map map3 = map2;
            Set set3 = set2;
            return chunkUploadingData.copy(str, j, str2, uploadSessionDTO, map, set, map3, set3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileSha1() {
            return this.fileSha1;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UploadSessionDTO getSessionInfo() {
            return this.sessionInfo;
        }

        public final Map<String, Long> component5() {
            return this.runningRequests;
        }

        public final Set<Long> component6() {
            return this.chunksToUpload;
        }

        public final Map<String, Long> component7() {
            return this.failedChunks;
        }

        public final Set<UploadFileChunkDTO> component8() {
            return this.succeededChunks;
        }

        public final ChunkUploadingData copy(@Json String localItemId, @Json long fileSize, @Json String fileSha1, @Json UploadSessionDTO sessionInfo, @Json Map<String, Long> runningRequests, @Json Set<Long> chunksToUpload, @Json Map<String, Long> failedChunks, @Json Set<UploadFileChunkDTO> succeededChunks) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
            Intrinsics.checkNotNullParameter(chunksToUpload, "chunksToUpload");
            Intrinsics.checkNotNullParameter(failedChunks, "failedChunks");
            Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
            return new ChunkUploadingData(localItemId, fileSize, fileSha1, sessionInfo, runningRequests, chunksToUpload, failedChunks, succeededChunks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChunkUploadingData)) {
                return false;
            }
            ChunkUploadingData chunkUploadingData = (ChunkUploadingData) other;
            return Intrinsics.areEqual(this.localItemId, chunkUploadingData.localItemId) && this.fileSize == chunkUploadingData.fileSize && Intrinsics.areEqual(this.fileSha1, chunkUploadingData.fileSha1) && Intrinsics.areEqual(this.sessionInfo, chunkUploadingData.sessionInfo) && Intrinsics.areEqual(this.runningRequests, chunkUploadingData.runningRequests) && Intrinsics.areEqual(this.chunksToUpload, chunkUploadingData.chunksToUpload) && Intrinsics.areEqual(this.failedChunks, chunkUploadingData.failedChunks) && Intrinsics.areEqual(this.succeededChunks, chunkUploadingData.succeededChunks);
        }

        public int hashCode() {
            return (((((((((((((this.localItemId.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileSha1.hashCode()) * 31) + this.sessionInfo.hashCode()) * 31) + this.runningRequests.hashCode()) * 31) + this.chunksToUpload.hashCode()) * 31) + this.failedChunks.hashCode()) * 31) + this.succeededChunks.hashCode();
        }

        public String toString() {
            return "ChunkUploadingData(localItemId=" + this.localItemId + ", fileSize=" + this.fileSize + ", fileSha1=" + this.fileSha1 + ", sessionInfo=" + this.sessionInfo + ", runningRequests=" + this.runningRequests + ", chunksToUpload=" + this.chunksToUpload + ", failedChunks=" + this.failedChunks + ", succeededChunks=" + this.succeededChunks + ")";
        }

        public final String getLocalItemId() {
            return this.localItemId;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final UploadSessionDTO getSessionInfo() {
            return this.sessionInfo;
        }

        public final Map<String, Long> getRunningRequests() {
            return this.runningRequests;
        }

        public final Set<Long> getChunksToUpload() {
            return this.chunksToUpload;
        }

        public final Map<String, Long> getFailedChunks() {
            return this.failedChunks;
        }

        public final Set<UploadFileChunkDTO> getSucceededChunks() {
            return this.succeededChunks;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkUploadingData(@Json String localItemId, @Json long j, @Json String fileSha1, @Json UploadSessionDTO sessionInfo, @Json Map<String, Long> runningRequests, @Json Set<Long> chunksToUpload, @Json Map<String, Long> failedChunks, @Json Set<UploadFileChunkDTO> succeededChunks) {
            super(UploadJobStates.UPLOAD_CHUNK_STATE.getValue(), null);
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
            Intrinsics.checkNotNullParameter(chunksToUpload, "chunksToUpload");
            Intrinsics.checkNotNullParameter(failedChunks, "failedChunks");
            Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
            this.localItemId = localItemId;
            this.fileSize = j;
            this.fileSha1 = fileSha1;
            this.sessionInfo = sessionInfo;
            this.runningRequests = runningRequests;
            this.chunksToUpload = chunksToUpload;
            this.failedChunks = failedChunks;
            this.succeededChunks = succeededChunks;
        }
    }

    /* JADX INFO: compiled from: UploadFileStates.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadFileRunningData$CommitSessionData;", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "localItemId", "", "fileSize", "", "fileSha1", "sessionInfo", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "succeededChunks", "", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Lcom/box/android/data/api/models/upload/UploadSessionDTO;Ljava/util/Set;)V", "getLocalItemId", "()Ljava/lang/String;", "getFileSize", "()J", "getFileSha1", "getSessionInfo", "()Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "getSucceededChunks", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommitSessionData extends UploadFileRunningData {
        private final String fileSha1;
        private final long fileSize;
        private final String localItemId;
        private final UploadSessionDTO sessionInfo;
        private final Set<UploadFileChunkDTO> succeededChunks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CommitSessionData copy$default(CommitSessionData commitSessionData, String str, long j, String str2, UploadSessionDTO uploadSessionDTO, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                str = commitSessionData.localItemId;
            }
            if ((i & 2) != 0) {
                j = commitSessionData.fileSize;
            }
            if ((i & 4) != 0) {
                str2 = commitSessionData.fileSha1;
            }
            if ((i & 8) != 0) {
                uploadSessionDTO = commitSessionData.sessionInfo;
            }
            if ((i & 16) != 0) {
                set = commitSessionData.succeededChunks;
            }
            Set set2 = set;
            String str3 = str2;
            return commitSessionData.copy(str, j, str3, uploadSessionDTO, set2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileSha1() {
            return this.fileSha1;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UploadSessionDTO getSessionInfo() {
            return this.sessionInfo;
        }

        public final Set<UploadFileChunkDTO> component5() {
            return this.succeededChunks;
        }

        public final CommitSessionData copy(@Json String localItemId, @Json long fileSize, @Json String fileSha1, @Json UploadSessionDTO sessionInfo, @Json Set<UploadFileChunkDTO> succeededChunks) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
            return new CommitSessionData(localItemId, fileSize, fileSha1, sessionInfo, succeededChunks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommitSessionData)) {
                return false;
            }
            CommitSessionData commitSessionData = (CommitSessionData) other;
            return Intrinsics.areEqual(this.localItemId, commitSessionData.localItemId) && this.fileSize == commitSessionData.fileSize && Intrinsics.areEqual(this.fileSha1, commitSessionData.fileSha1) && Intrinsics.areEqual(this.sessionInfo, commitSessionData.sessionInfo) && Intrinsics.areEqual(this.succeededChunks, commitSessionData.succeededChunks);
        }

        public int hashCode() {
            return (((((((this.localItemId.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31) + this.fileSha1.hashCode()) * 31) + this.sessionInfo.hashCode()) * 31) + this.succeededChunks.hashCode();
        }

        public String toString() {
            return "CommitSessionData(localItemId=" + this.localItemId + ", fileSize=" + this.fileSize + ", fileSha1=" + this.fileSha1 + ", sessionInfo=" + this.sessionInfo + ", succeededChunks=" + this.succeededChunks + ")";
        }

        public final String getLocalItemId() {
            return this.localItemId;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final String getFileSha1() {
            return this.fileSha1;
        }

        public final UploadSessionDTO getSessionInfo() {
            return this.sessionInfo;
        }

        public final Set<UploadFileChunkDTO> getSucceededChunks() {
            return this.succeededChunks;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommitSessionData(@Json String localItemId, @Json long j, @Json String fileSha1, @Json UploadSessionDTO sessionInfo, @Json Set<UploadFileChunkDTO> succeededChunks) {
            super(UploadJobStates.UPLOAD_COMMIT_SESSION_STATE.getValue(), null);
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(fileSha1, "fileSha1");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
            this.localItemId = localItemId;
            this.fileSize = j;
            this.fileSha1 = fileSha1;
            this.sessionInfo = sessionInfo;
            this.succeededChunks = succeededChunks;
        }
    }
}
