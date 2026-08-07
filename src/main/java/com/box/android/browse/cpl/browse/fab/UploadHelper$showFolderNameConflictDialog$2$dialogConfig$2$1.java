package com.box.android.browse.cpl.browse.fab;

import android.net.Uri;
import com.box.android.domain.models.ItemId;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UploadHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1", f = "UploadHelper.kt", i = {1}, l = {Token.CONST, Token.SETCONST}, m = "invokeSuspend", n = {"newName"}, s = {"L$0"}, v = 1)
final class UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $folderName;
    final /* synthetic */ Uri $folderUri;
    final /* synthetic */ ItemId.Remote $parentId;
    Object L$0;
    int label;
    final /* synthetic */ UploadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1(UploadHelper uploadHelper, String str, ItemId.Remote remote, Uri uri, Continuation<? super UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1> continuation) {
        super(2, continuation);
        this.this$0 = uploadHelper;
        this.$folderName = str;
        this.$parentId = remote;
        this.$folderUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1(this.this$0, this.$folderName, this.$parentId, this.$folderUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        if (com.box.android.domain.services.ILocalItemService.uploadFolder$default(r11.this$0.localItemService, r4, r11.$parentId, r11.$folderUri, null, r11, 8, null) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r11 = r11.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L5d
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L37
        L22:
            kotlin.ResultKt.throwOnFailure(r12)
            com.box.android.browse.cpl.browse.fab.UploadHelper r12 = r11.this$0
            java.lang.String r1 = r11.$folderName
            com.box.android.domain.models.ItemId$Remote r4 = r11.$parentId
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r11.label = r3
            java.lang.Object r12 = com.box.android.browse.cpl.browse.fab.UploadHelper.access$generateUniqueFolderName(r12, r1, r4, r5)
            if (r12 != r0) goto L37
            goto L5c
        L37:
            r4 = r12
            java.lang.String r4 = (java.lang.String) r4
            com.box.android.browse.cpl.browse.fab.UploadHelper r12 = r11.this$0
            com.box.android.domain.services.ILocalItemService r3 = com.box.android.browse.cpl.browse.fab.UploadHelper.access$getLocalItemService$p(r12)
            com.box.android.domain.models.ItemId$Remote r12 = r11.$parentId
            r5 = r12
            com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
            android.net.Uri r6 = r11.$folderUri
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r11.L$0 = r12
            r11.label = r2
            r7 = 0
            r9 = 8
            r10 = 0
            java.lang.Object r11 = com.box.android.domain.services.ILocalItemService.uploadFolder$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r11 != r0) goto L5d
        L5c:
            return r0
        L5d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
