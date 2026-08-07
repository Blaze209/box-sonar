package com.box.android.capture.viewmodel;

import androidx.lifecycle.LiveDataScope;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.item.FileModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1", f = "CaptureHistoryButtonViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {110, 121, 122, 128, Token.TARGET, 135}, m = "invokeSuspend", n = {"$this$liveData", "lastJob", "lastUpload", "lastHistoryModel", "it", "sha1", "file", "$i$a$-let-CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1$1", "$this$liveData", "lastJob", "lastUpload", "lastHistoryModel", "it", "sha1", "file", "it", "$i$a$-let-CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1$1", "$i$a$-let-CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1$1$1", "$this$liveData", "lastJob", "lastUpload", "lastHistoryModel", "it", "sha1", "file", "$i$a$-let-CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1$1", "$this$liveData", "lastJob", "lastUpload", "lastHistoryModel", "it", "sha1", "file", "$i$a$-let-CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1$1", "$this$liveData", "lastJob", "lastUpload", "lastHistoryModel", "it", "sha1", "file", "$i$a$-let-CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1$1", "$this$liveData", "lastJob", "lastUpload", "lastHistoryModel"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3"}, v = 1)
final class CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1 extends SuspendLambda implements Function2<LiveDataScope<CaptureHistoryButtonViewModel.CaptureThumbnailResource>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CaptureHistoryModel> $pendingFiles;
    final /* synthetic */ List<CaptureHistoryModel> $uploadedFiles;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ CaptureHistoryButtonViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1(List<CaptureHistoryModel> list, List<CaptureHistoryModel> list2, CaptureHistoryButtonViewModel captureHistoryButtonViewModel, Continuation<? super CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1> continuation) {
        super(2, continuation);
        this.$pendingFiles = list;
        this.$uploadedFiles = list2;
        this.this$0 = captureHistoryButtonViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1 captureHistoryButtonViewModel$lastCaptureThumbnail$1$1 = new CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1(this.$pendingFiles, this.$uploadedFiles, this.this$0, continuation);
        captureHistoryButtonViewModel$lastCaptureThumbnail$1$1.L$0 = obj;
        return captureHistoryButtonViewModel$lastCaptureThumbnail$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LiveDataScope<CaptureHistoryButtonViewModel.CaptureThumbnailResource> liveDataScope, Continuation<? super Unit> continuation) {
        return ((CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0152, code lost:
    
        if (r0.emit(r3, r12) == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01be, code lost:
    
        if (r0.emit(r3, r12) == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01f1, code lost:
    
        if (r0.emit(null, r12) == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0237, code lost:
    
        if (r0.emit(r3, r12) == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x026b, code lost:
    
        if (r0.emit(null, r12) == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0298, code lost:
    
        if (r0.emit(null, r12) == r1) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x029a, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$3(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$2(CaptureHistoryModel captureHistoryModel, CaptureHistoryModel captureHistoryModel2) {
        FileModel fileModel;
        Date contentCreatedDate;
        Date date;
        FileModel fileModel2;
        if (captureHistoryModel == null || (fileModel = captureHistoryModel.getFileModel()) == null || (contentCreatedDate = fileModel.getContentCreatedDate()) == null) {
            return -1;
        }
        if (captureHistoryModel2 == null || (fileModel2 = captureHistoryModel2.getFileModel()) == null || (date = fileModel2.getContentCreatedDate()) == null) {
            date = new Date(0L);
        }
        return contentCreatedDate.compareTo(date);
    }
}
