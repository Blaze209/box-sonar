package com.box.android.preview.previewtype.boxnote;

import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.imageutils.JfifUtil;
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
@DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$handleLoadNote$effect$1", f = "BoxNotePreviewReducer.kt", i = {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {205, 207, JfifUtil.MARKER_SOI, PsExtractor.VIDEO_STREAM_MASK, 252, 259, 261}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "tokenWithExpiration", "$this$flow", "tokenWithExpiration", "accessToken", "expiresIn", "$this$flow", "tokenWithExpiration", "accessToken", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "sharedLinkPassword", "sessionData", "noteUri", "headers", "expiresIn", "$this$flow", "tokenWithExpiration", "accessToken", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "sharedLinkPassword", "sessionData", "noteUri", "headers", "expiresIn", "$this$flow", "tokenWithExpiration", "accessToken", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "sharedLinkPassword", "sessionData", "noteUri", "headers", "freshFileModel", "expiresIn", "freshIsReadOnly", "$this$flow", "tokenWithExpiration", "accessToken", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "sharedLinkPassword", "sessionData", "noteUri", "headers", "ex", "expiresIn"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0"}, v = 1)
final class BoxNotePreviewReducer$handleLoadNote$effect$1 extends SuspendLambda implements Function2<FlowCollector<? super BoxNotePreviewReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxNotePreviewReducer.Action.LoadNote $action;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    final /* synthetic */ BoxNotePreviewReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxNotePreviewReducer$handleLoadNote$effect$1(BoxNotePreviewReducer boxNotePreviewReducer, BoxNotePreviewReducer.Action.LoadNote loadNote, Continuation<? super BoxNotePreviewReducer$handleLoadNote$effect$1> continuation) {
        super(2, continuation);
        this.this$0 = boxNotePreviewReducer;
        this.$action = loadNote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxNotePreviewReducer$handleLoadNote$effect$1 boxNotePreviewReducer$handleLoadNote$effect$1 = new BoxNotePreviewReducer$handleLoadNote$effect$1(this.this$0, this.$action, continuation);
        boxNotePreviewReducer$handleLoadNote$effect$1.L$0 = obj;
        return boxNotePreviewReducer$handleLoadNote$effect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BoxNotePreviewReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((BoxNotePreviewReducer$handleLoadNote$effect$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x010e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0136  */
    /* JADX WARN: Code duplicated, block: B:33:0x014c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0188  */
    /* JADX WARN: Code duplicated, block: B:41:0x0246  */
    /* JADX WARN: Code duplicated, block: B:45:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:48:0x02a9 A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:50:0x02b4 A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:51:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:53:0x02ba A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0316  */
    /* JADX WARN: Code duplicated, block: B:56:0x0317 A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0325 A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0329 A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0337 A[Catch: ThrowableDomainError -> 0x006c, TryCatch #1 {ThrowableDomainError -> 0x006c, blocks: (B:8:0x0067, B:46:0x02a3, B:48:0x02a9, B:50:0x02b4, B:53:0x02ba, B:56:0x0317, B:57:0x0324, B:58:0x0325, B:60:0x0329, B:61:0x0336, B:62:0x0337, B:63:0x033c), top: B:73:0x000e }] */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x012f, code lost:
    
        if (r2.emit(new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.Action.SessionRefreshFailed(r19.$action.getFileModel()), r19) == r3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0181, code lost:
    
        if (r2.emit(new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.Action.RefreshSession(r19.$action.getFileModel(), r19.$action.getAttemptQuickLoad(), r19.$action.getEditOnLoad()), r19) == r3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x038c, code lost:
    
        if (r2.emit(new com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.Action.Error(r0.getDomainError()), r19) == r3) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$handleLoadNote$effect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
