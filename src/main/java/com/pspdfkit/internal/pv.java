package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import io.reactivex.rxjava3.core.SingleEmitter;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.drawable.PdfDrawableHelperKt$getPdfDrawablesForPageAsync$1$job$1", f = "PdfDrawableHelper.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, nl = {53}, s = {}, v = 2)
public final class pv extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ lm b;
    public final /* synthetic */ List<PdfDrawableProvider> c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ int e;
    public final /* synthetic */ SingleEmitter<List<PdfDrawable>> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public pv(lm lmVar, List<? extends PdfDrawableProvider> list, Context context, int i, SingleEmitter<List<PdfDrawable>> singleEmitter, Continuation<? super pv> continuation) {
        super(2, continuation);
        this.b = lmVar;
        this.c = list;
        this.d = context;
        this.e = i;
        this.f = singleEmitter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new pv(this.b, this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((pv) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                lm lmVar = this.b;
                List<PdfDrawableProvider> list = this.c;
                Context context = this.d;
                int i2 = this.e;
                this.a = 1;
                obj = qv.a(lmVar, list, context, i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List<PdfDrawable> list2 = (List) obj;
            if (!this.f.isDisposed()) {
                this.f.onSuccess(list2);
            }
        } catch (Throwable th) {
            if (!this.f.isDisposed()) {
                this.f.onError(th);
            }
        }
        return Unit.INSTANCE;
    }
}
