package com.box.android.preview.preview;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.AudioItem;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.preview.PreviewReducer$fetchAndObserveItemsForPlaylist$1$1", f = "PreviewReducer.kt", i = {0, 0, 0, 1}, l = {577, 580}, m = "emit", n = {"it", "playlist", "$i$a$-let-PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$1", "it"}, s = {"L$0", "L$1", "I$0", "L$0"}, v = 1)
final class PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewReducer.C16811.C01801<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1(PreviewReducer.C16811.C01801<? super T> c01801, Continuation<? super PreviewReducer$fetchAndObserveItemsForPlaylist$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01801;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result<? extends List<? extends AudioItem>, ? extends DomainError>) null, (Continuation<? super Unit>) this);
    }
}
