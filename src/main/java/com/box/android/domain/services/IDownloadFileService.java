package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IDownloadFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IDownloadFileService;", "", "downloadFile", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "", "Lcom/box/android/domain/models/DomainError;", "Lcom/box/android/domain/utils/Progress;", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "fileSize", "", "targetFile", "Ljava/io/File;", "sharedLinkHeader", "", "(Lcom/box/android/domain/models/ItemId$Remote;JLjava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFileChunk", "startByte", "endByte", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/io/File;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IDownloadFileService {
    Object downloadFile(ItemId.Remote remote, long j, File file, String str, Continuation<? super ResultProgressWrapper<Unit, DomainError, Progress>> continuation);

    Object downloadFileChunk(ItemId.Remote remote, File file, long j, long j2, String str, Continuation<? super ResultProgressWrapper<Unit, DomainError, Progress>> continuation);
}
