package com.pspdfkit.internal;

import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewSaveListener;
import java.io.IOException;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.documentinfo.DocumentInfoViewModel$saveChanges$2", f = "DocumentInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class td extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ lm a;
    public final /* synthetic */ ud b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public td(lm lmVar, ud udVar, Continuation<? super td> continuation) {
        super(2, continuation);
        this.a = lmVar;
        this.b = udVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new td(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new td(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        rd value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        boolean zSaveIfModified = this.a.saveIfModified();
        if (!this.b.g.a.isEmpty()) {
            Iterator<OnDocumentInfoViewSaveListener> it = this.b.g.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().onDocumentInfoChangesSaved(this.a);
            }
        }
        MutableStateFlow<rd> mutableStateFlow = this.b.b;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, rd.a(value, false, null, false, !zSaveIfModified, 3)));
        return Unit.INSTANCE;
    }
}
