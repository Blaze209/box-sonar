package com.box.android.domain.services;

import android.net.Uri;
import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IObservabilityService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH¦@¢\u0006\u0002\u0010\rJ>\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH¦@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\nH&¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IObservabilityService;", "", "authenticate", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLogArchiveFile", "Landroid/net/Uri;", "fileProviderAuthorityId", "", "logTag", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadLogArchiveFile", "", "logArchiveFileToUpload", "Ljava/io/File;", "destinationFolderRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "authInfoModel", "(Ljava/io/File;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/AuthenticationInfoModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogArchiveFileToUpload", "deleteLogArchiveFile", "logArchiveFileToDelete", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogArchiveFileCount", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IObservabilityService {
    Object authenticate(Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>> continuation);

    Object createLogArchiveFile(int i, String str, Continuation<? super Result<? extends Uri, ? extends DomainError>> continuation);

    Object deleteLogArchiveFile(File file, Continuation<? super Unit> continuation);

    int getLogArchiveFileCount();

    Object getLogArchiveFileToUpload(Continuation<? super File> continuation);

    Object uploadLogArchiveFile(File file, ItemId.Remote remote, AuthenticationInfoModel authenticationInfoModel, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IObservabilityService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object createLogArchiveFile$default(IObservabilityService iObservabilityService, int i, String str, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogArchiveFile");
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return iObservabilityService.createLogArchiveFile(i, str, continuation);
    }

    static /* synthetic */ Object uploadLogArchiveFile$default(IObservabilityService iObservabilityService, File file, ItemId.Remote remote, AuthenticationInfoModel authenticationInfoModel, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadLogArchiveFile");
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return iObservabilityService.uploadLogArchiveFile(file, remote, authenticationInfoModel, str, continuation);
    }
}
