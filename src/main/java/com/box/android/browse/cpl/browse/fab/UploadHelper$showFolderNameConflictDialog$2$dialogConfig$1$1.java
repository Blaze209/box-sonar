package com.box.android.browse.cpl.browse.fab;

import android.net.Uri;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.ILocalItemService;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UploadHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1", f = "UploadHelper.kt", i = {}, l = {Token.XMLEND}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $folderName;
    final /* synthetic */ Uri $folderUri;
    final /* synthetic */ ItemId.Remote $parentId;
    int label;
    final /* synthetic */ UploadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1(UploadHelper uploadHelper, String str, ItemId.Remote remote, Uri uri, Continuation<? super UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1> continuation) {
        super(2, continuation);
        this.this$0 = uploadHelper;
        this.$folderName = str;
        this.$parentId = remote;
        this.$folderUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1(this.this$0, this.$folderName, this.$parentId, this.$folderUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (ILocalItemService.uploadFolder$default(this.this$0.localItemService, this.$folderName, this.$parentId, this.$folderUri, null, this, 8, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
