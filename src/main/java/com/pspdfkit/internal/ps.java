package com.pspdfkit.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.note.NoteEditorPresenter$subscribe$2", f = "NoteEditorPresenter.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, nl = {69}, s = {}, v = 2)
public final class ps extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ os b;
    public final /* synthetic */ js c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ps(os osVar, js jsVar, Continuation<? super ps> continuation) {
        super(2, continuation);
        this.b = osVar;
        this.c = jsVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ps(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new ps(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String strG;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            gs gsVar = this.b.a;
            this.a = 1;
            obj = gsVar.b(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<? extends ds> list = (List) obj;
        os osVar = this.b;
        osVar.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            osVar.b((ds) it.next());
        }
        if (list.size() != 1 || ((strG = ((ds) CollectionsKt.first((List) list)).g()) != null && strG.length() != 0)) {
            z = false;
        }
        this.c.a(list, z);
        return Unit.INSTANCE;
    }
}
