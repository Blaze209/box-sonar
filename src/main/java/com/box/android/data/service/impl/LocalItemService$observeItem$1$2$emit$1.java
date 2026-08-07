package com.box.android.data.service.impl;

import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LocalItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService$observeItem$1$2", f = "LocalItemService.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {177, TsExtractor.TS_PACKET_SIZE, 191, 191}, m = "emit", n = {"remoteId", "it", "$i$a$-let-LocalItemService$observeItem$1$2$1", "remoteId", "it", "$i$a$-let-LocalItemService$observeItem$1$2$2", "remoteId", "it", "$this$onSuccess$iv", "entity", "$i$a$-let-LocalItemService$observeItem$1$2$2", "$i$f$onSuccess", "$i$a$-onSuccess-LocalItemService$observeItem$1$2$2$1", "remoteId", "it", "$this$onSuccess$iv", "entity", "$i$a$-let-LocalItemService$observeItem$1$2$2", "$i$f$onSuccess", "$i$a$-onSuccess-LocalItemService$observeItem$1$2$2$1"}, s = {"L$0", "L$1", "I$0", "L$0", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, v = 1)
final class LocalItemService$observeItem$1$2$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalItemService.C14621.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LocalItemService$observeItem$1$2$emit$1(LocalItemService.C14621.AnonymousClass2<? super T> anonymousClass2, Continuation<? super LocalItemService$observeItem$1$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ItemId.Remote) null, (Continuation<? super Unit>) this);
    }
}
