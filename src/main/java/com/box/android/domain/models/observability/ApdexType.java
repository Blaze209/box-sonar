package com.box.android.domain.models.observability;

import kotlin.Metadata;

/* JADX INFO: compiled from: ApdexType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u000b\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexType;", "", "name", "", "getName", "()Ljava/lang/String;", "Milestone", "Lcom/box/android/domain/models/observability/AppStartupApdex;", "Lcom/box/android/domain/models/observability/DownloadApdex;", "Lcom/box/android/domain/models/observability/FolderNavApdex;", "Lcom/box/android/domain/models/observability/HubAssetApdex;", "Lcom/box/android/domain/models/observability/HubsListApdex;", "Lcom/box/android/domain/models/observability/PreviewNavApdex;", "Lcom/box/android/domain/models/observability/RecentsLoadApdex;", "Lcom/box/android/domain/models/observability/RecentsNavApdex;", "Lcom/box/android/domain/models/observability/RootFolderLoadApdex;", "Lcom/box/android/domain/models/observability/RootFolderNavApdex;", "Lcom/box/android/domain/models/observability/UploadApdex;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ApdexType {

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0005\u0006\u0007\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "", "name", "", "getName", "()Ljava/lang/String;", "Lcom/box/android/domain/models/observability/AppStartupApdex$Cold$AppFirstCodeExecuted;", "Lcom/box/android/domain/models/observability/PreviewNavApdex$FileDownloadEnded;", "Lcom/box/android/domain/models/observability/PreviewNavApdex$FileDownloadStarted;", "Lcom/box/android/domain/models/observability/PreviewNavApdex$FileInfoRepresentationFetchEnded;", "Lcom/box/android/domain/models/observability/PreviewNavApdex$FileInfoRepresentationFetchStarted;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Milestone {
        String getName();
    }

    String getName();
}
