package com.box.android.workers;

import com.box.android.domain.services.ILocalItemService;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AutoUploadWorkerDispatcher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/box/android/workers/AutoUploadWorkerDispatcher;", "", "<init>", "()V", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIoDispatcher$annotations", "getIoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setIoDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "setupAutoUpload", "", "uploadInfo", "Lcom/box/android/localrepo/LocalAutoContentUploadInformation;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoUploadWorkerDispatcher {
    public static final AutoUploadWorkerDispatcher INSTANCE = new AutoUploadWorkerDispatcher();
    private static CoroutineDispatcher ioDispatcher = Dispatchers.getIO();
    public static final int $stable = 8;

    public static /* synthetic */ void getIoDispatcher$annotations() {
    }

    private AutoUploadWorkerDispatcher() {
    }

    public final CoroutineDispatcher getIoDispatcher() {
        return ioDispatcher;
    }

    public final void setIoDispatcher(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "<set-?>");
        ioDispatcher = coroutineDispatcher;
    }

    public final void setupAutoUpload(LocalAutoContentUploadInformation uploadInfo, ILocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        if (uploadInfo != null) {
            AutoUploadUriTriggerWorker.INSTANCE.toggleServices(uploadInfo);
            if (uploadInfo.isSyncEnabled()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), null, null, new AutoUploadWorkerDispatcher$setupAutoUpload$1$1(localItemService, uploadInfo, null), 3, null);
            }
        }
    }
}
