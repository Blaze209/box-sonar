package com.box.android.domain.usecases.capture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CaptureFolderInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureFolderInteractor$getCaptureFolder$1", f = "CaptureFolderInteractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {34, 36, 38, 41, 48}, m = "invokeSuspend$observeUploadFolderCreationJob", n = {"$this$flow", "this$0", "folderModel", "$this$flow", "this$0", "folderModel", "localId", "$this$flow", "this$0", "folderModel", "localId", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$2", "$this$flow", "this$0", "folderModel", "localId", "$this$onError$iv", "it", "$this$onSuccess$iv", "jobInfos", "$this$forEach$iv", "element$iv", "jobInfo", "$i$f$onError", "$i$a$-onError-CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$2", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$2$1", "$i$f$forEach", "$i$a$-forEach-CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$2$1$1", "$this$flow", "this$0", "folderModel", "localId", "$this$onError$iv", "it", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$2", "$i$f$onError", "$i$a$-onError-CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$2$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, v = 1)
final class CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;

    CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$1(Continuation<? super CaptureFolderInteractor$getCaptureFolder$1$observeUploadFolderCreationJob$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CaptureFolderInteractor.AnonymousClass1.invokeSuspend$observeUploadFolderCreationJob(null, null, null, this);
    }
}
