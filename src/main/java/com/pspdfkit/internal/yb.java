package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.edit.Edit;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.clipboard.CopyPasteManagerImpl$pasteAnnotations$1", f = "CopyPasteManagerImpl.kt", i = {0, 0, 0, 0, 0}, l = {BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-CopyPasteManagerImpl$pasteAnnotations$1$1"}, nl = {229}, s = {"L$0", "L$4", "L$5", "I$1", "I$2"}, v = 2)
public final class yb extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public wb b;
    public Matrix c;
    public Iterator d;
    public Object e;
    public Object f;
    public int g;
    public int h;
    public int i;
    public final /* synthetic */ ArrayList j;
    public final /* synthetic */ wb k;
    public final /* synthetic */ int l;
    public final /* synthetic */ Matrix m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb(ArrayList arrayList, wb wbVar, int i, Matrix matrix, Continuation continuation) {
        super(2, continuation);
        this.j = arrayList;
        this.k = wbVar;
        this.l = i;
        this.m = matrix;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new yb(this.j, this.k, this.l, this.m, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((yb) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterable iterable;
        wb wbVar;
        int i;
        Matrix matrix;
        Iterator it;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.i;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iterable = this.j;
            wbVar = this.k;
            i = this.l;
            matrix = this.m;
            it = iterable.iterator();
            i2 = 0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.h;
            i = this.g;
            it = this.d;
            matrix = this.c;
            wbVar = this.b;
            iterable = (Iterable) this.a;
            ResultKt.throwOnFailure(obj);
        }
        Matrix matrix2 = matrix;
        int i4 = i;
        wb wbVar2 = wbVar;
        Iterator it2 = it;
        Iterable iterable2 = iterable;
        while (it2.hasNext()) {
            Object next = it2.next();
            Annotation annotation = (Annotation) next;
            lf<Edit> lfVar = wbVar2.g;
            this.a = SpillingKt.nullOutSpilledVariable(iterable2);
            this.b = wbVar2;
            this.c = matrix2;
            this.d = it2;
            this.e = SpillingKt.nullOutSpilledVariable(next);
            this.f = SpillingKt.nullOutSpilledVariable(annotation);
            this.g = i4;
            this.h = i2;
            this.i = 1;
            yb ybVar = this;
            if (wb.a(wbVar2, annotation, i4, matrix2, lfVar, ybVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this = ybVar;
        }
        return Unit.INSTANCE;
    }
}
