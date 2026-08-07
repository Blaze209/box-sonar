package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionRunningInfo.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0014\b\u0003\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fHÆ\u0003Jk\u0010\u001f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0014\b\u0003\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/box/android/data/api/models/upload/SessionRunningInfo;", "", "uploadSession", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "runningRequests", "", "", "chunksToUpload", "failedChunks", "succeededChunks", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "requestAttempts", "", "", "<init>", "(Lcom/box/android/data/api/models/upload/UploadSessionDTO;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;)V", "getUploadSession", "()Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "getRunningRequests", "()Ljava/util/Set;", "getChunksToUpload", "getFailedChunks", "getSucceededChunks", "getRequestAttempts", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SessionRunningInfo {
    private final Set<Long> chunksToUpload;
    private final Set<Long> failedChunks;
    private final Map<Long, Integer> requestAttempts;
    private final Set<Long> runningRequests;
    private final Set<UploadFileChunkDTO> succeededChunks;
    private final UploadSessionDTO uploadSession;

    public SessionRunningInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionRunningInfo copy$default(SessionRunningInfo sessionRunningInfo, UploadSessionDTO uploadSessionDTO, Set set, Set set2, Set set3, Set set4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadSessionDTO = sessionRunningInfo.uploadSession;
        }
        if ((i & 2) != 0) {
            set = sessionRunningInfo.runningRequests;
        }
        if ((i & 4) != 0) {
            set2 = sessionRunningInfo.chunksToUpload;
        }
        if ((i & 8) != 0) {
            set3 = sessionRunningInfo.failedChunks;
        }
        if ((i & 16) != 0) {
            set4 = sessionRunningInfo.succeededChunks;
        }
        if ((i & 32) != 0) {
            map = sessionRunningInfo.requestAttempts;
        }
        Set set5 = set4;
        Map map2 = map;
        return sessionRunningInfo.copy(uploadSessionDTO, set, set2, set3, set5, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UploadSessionDTO getUploadSession() {
        return this.uploadSession;
    }

    public final Set<Long> component2() {
        return this.runningRequests;
    }

    public final Set<Long> component3() {
        return this.chunksToUpload;
    }

    public final Set<Long> component4() {
        return this.failedChunks;
    }

    public final Set<UploadFileChunkDTO> component5() {
        return this.succeededChunks;
    }

    public final Map<Long, Integer> component6() {
        return this.requestAttempts;
    }

    public final SessionRunningInfo copy(@Json(name = BoxUploadSession.FIELD_TYPE) UploadSessionDTO uploadSession, @Json(name = "running_requests") Set<Long> runningRequests, @Json(name = "chunks_to_upload") Set<Long> chunksToUpload, @Json(name = "failed_chunks") Set<Long> failedChunks, @Json(name = "succeeded_chunks") Set<UploadFileChunkDTO> succeededChunks, @Json(name = "request_attempts") Map<Long, Integer> requestAttempts) {
        Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
        Intrinsics.checkNotNullParameter(chunksToUpload, "chunksToUpload");
        Intrinsics.checkNotNullParameter(failedChunks, "failedChunks");
        Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
        Intrinsics.checkNotNullParameter(requestAttempts, "requestAttempts");
        return new SessionRunningInfo(uploadSession, runningRequests, chunksToUpload, failedChunks, succeededChunks, requestAttempts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionRunningInfo)) {
            return false;
        }
        SessionRunningInfo sessionRunningInfo = (SessionRunningInfo) other;
        return Intrinsics.areEqual(this.uploadSession, sessionRunningInfo.uploadSession) && Intrinsics.areEqual(this.runningRequests, sessionRunningInfo.runningRequests) && Intrinsics.areEqual(this.chunksToUpload, sessionRunningInfo.chunksToUpload) && Intrinsics.areEqual(this.failedChunks, sessionRunningInfo.failedChunks) && Intrinsics.areEqual(this.succeededChunks, sessionRunningInfo.succeededChunks) && Intrinsics.areEqual(this.requestAttempts, sessionRunningInfo.requestAttempts);
    }

    public int hashCode() {
        UploadSessionDTO uploadSessionDTO = this.uploadSession;
        return ((((((((((uploadSessionDTO == null ? 0 : uploadSessionDTO.hashCode()) * 31) + this.runningRequests.hashCode()) * 31) + this.chunksToUpload.hashCode()) * 31) + this.failedChunks.hashCode()) * 31) + this.succeededChunks.hashCode()) * 31) + this.requestAttempts.hashCode();
    }

    public String toString() {
        return "SessionRunningInfo(uploadSession=" + this.uploadSession + ", runningRequests=" + this.runningRequests + ", chunksToUpload=" + this.chunksToUpload + ", failedChunks=" + this.failedChunks + ", succeededChunks=" + this.succeededChunks + ", requestAttempts=" + this.requestAttempts + ")";
    }

    public SessionRunningInfo(@Json(name = BoxUploadSession.FIELD_TYPE) UploadSessionDTO uploadSessionDTO, @Json(name = "running_requests") Set<Long> runningRequests, @Json(name = "chunks_to_upload") Set<Long> chunksToUpload, @Json(name = "failed_chunks") Set<Long> failedChunks, @Json(name = "succeeded_chunks") Set<UploadFileChunkDTO> succeededChunks, @Json(name = "request_attempts") Map<Long, Integer> requestAttempts) {
        Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
        Intrinsics.checkNotNullParameter(chunksToUpload, "chunksToUpload");
        Intrinsics.checkNotNullParameter(failedChunks, "failedChunks");
        Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
        Intrinsics.checkNotNullParameter(requestAttempts, "requestAttempts");
        this.uploadSession = uploadSessionDTO;
        this.runningRequests = runningRequests;
        this.chunksToUpload = chunksToUpload;
        this.failedChunks = failedChunks;
        this.succeededChunks = succeededChunks;
        this.requestAttempts = requestAttempts;
    }

    public final UploadSessionDTO getUploadSession() {
        return this.uploadSession;
    }

    public /* synthetic */ SessionRunningInfo(UploadSessionDTO uploadSessionDTO, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, LinkedHashSet linkedHashSet3, LinkedHashSet linkedHashSet4, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uploadSessionDTO, (i & 2) != 0 ? new LinkedHashSet() : linkedHashSet, (i & 4) != 0 ? new LinkedHashSet() : linkedHashSet2, (i & 8) != 0 ? new LinkedHashSet() : linkedHashSet3, (i & 16) != 0 ? new LinkedHashSet() : linkedHashSet4, (i & 32) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    public final Set<Long> getRunningRequests() {
        return this.runningRequests;
    }

    public final Set<Long> getChunksToUpload() {
        return this.chunksToUpload;
    }

    public final Set<Long> getFailedChunks() {
        return this.failedChunks;
    }

    public final Set<UploadFileChunkDTO> getSucceededChunks() {
        return this.succeededChunks;
    }

    public final Map<Long, Integer> getRequestAttempts() {
        return this.requestAttempts;
    }
}
