package com.box.android.preview.previewtype.boxnote;

import com.facebook.imageutils.TiffUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$handleSessionRefreshed$effect$1", f = "BoxNotePreviewReducer.kt", i = {0, 1, 1, 2, 2}, l = {TiffUtil.TIFF_TAG_ORIENTATION, 277, 285}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "refreshSuccess", "$this$flow", "refreshSuccess"}, s = {"L$0", "L$0", "Z$0", "L$0", "Z$0"}, v = 1)
final class BoxNotePreviewReducer$handleSessionRefreshed$effect$1 extends SuspendLambda implements Function2<FlowCollector<? super BoxNotePreviewReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxNotePreviewReducer.Action.RefreshSession $action;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ BoxNotePreviewReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxNotePreviewReducer$handleSessionRefreshed$effect$1(BoxNotePreviewReducer boxNotePreviewReducer, BoxNotePreviewReducer.Action.RefreshSession refreshSession, Continuation<? super BoxNotePreviewReducer$handleSessionRefreshed$effect$1> continuation) {
        super(2, continuation);
        this.this$0 = boxNotePreviewReducer;
        this.$action = refreshSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxNotePreviewReducer$handleSessionRefreshed$effect$1 boxNotePreviewReducer$handleSessionRefreshed$effect$1 = new BoxNotePreviewReducer$handleSessionRefreshed$effect$1(this.this$0, this.$action, continuation);
        boxNotePreviewReducer$handleSessionRefreshed$effect$1.L$0 = obj;
        return boxNotePreviewReducer$handleSessionRefreshed$effect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BoxNotePreviewReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((BoxNotePreviewReducer$handleSessionRefreshed$effect$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
    
        if (r0.emit(new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.Action.LoadNote(r7.$action.getFileModel(), r7.$action.getAttemptQuickLoad(), r7.$action.getEditOnLoad()), r7) == r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0090, code lost:
    
        if (r0.emit(new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.Action.SessionRefreshFailed(r7.$action.getFileModel()), r7) == r1) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L26
            if (r2 == r5) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            goto L1e
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L93
        L22:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L41
        L26:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer r8 = r7.this$0
            com.box.android.preview.previewtype.boxnote.BoxNotesEnvironment r8 = com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.access$getEnvironment$p(r8)
            com.box.android.domain.services.ISessionManager r8 = r8.getSessionManager()
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.L$0 = r0
            r7.label = r5
            java.lang.Object r8 = r8.refreshSession(r2)
            if (r8 != r1) goto L41
            goto L92
        L41:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L74
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$LoadNote r2 = new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$LoadNote
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$RefreshSession r3 = r7.$action
            com.box.android.domain.models.item.FileModel r3 = r3.getFileModel()
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$RefreshSession r5 = r7.$action
            boolean r5 = r5.getAttemptQuickLoad()
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$RefreshSession r6 = r7.$action
            boolean r6 = r6.getEditOnLoad()
            r2.<init>(r3, r5, r6)
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r5
            r7.Z$0 = r8
            r7.label = r4
            java.lang.Object r7 = r0.emit(r2, r3)
            if (r7 != r1) goto L93
            goto L92
        L74:
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$SessionRefreshFailed r2 = new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$SessionRefreshFailed
            com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$Action$RefreshSession r4 = r7.$action
            com.box.android.domain.models.item.FileModel r4 = r4.getFileModel()
            r2.<init>(r4)
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r5
            r7.Z$0 = r8
            r7.label = r3
            java.lang.Object r7 = r0.emit(r2, r4)
            if (r7 != r1) goto L93
        L92:
            return r1
        L93:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$handleSessionRefreshed$effect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
