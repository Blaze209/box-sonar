package com.box.android.data.datasource;

import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SharedLinkTokenRetryHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.SharedLinkTokenRetryHelper$retryOnFlowFailure$1$1", f = "SharedLinkTokenRetryHelper.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {69, 79, 81, 82, 84}, m = "emit", n = {"it", "it", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "cachedTokenForSharedLink", "isSharedLinkTokenUseful", "it", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "cachedTokenForSharedLink", "token", "it", "isSharedLinkTokenUseful", "$i$a$-let-SharedLinkTokenRetryHelper$retryOnFlowFailure$1$1$1", "it", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "cachedTokenForSharedLink", "token", "isSharedLinkTokenUseful", "it", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "cachedTokenForSharedLink", "isSharedLinkTokenUseful"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
final class SharedLinkTokenRetryHelper$retryOnFlowFailure$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedLinkTokenRetryHelper.C11001.C01571<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SharedLinkTokenRetryHelper$retryOnFlowFailure$1$1$emit$1(SharedLinkTokenRetryHelper.C11001.C01571<? super T> c01571, Continuation<? super SharedLinkTokenRetryHelper$retryOnFlowFailure$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01571;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result) null, (Continuation<? super Unit>) this);
    }
}
