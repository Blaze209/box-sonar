package com.pspdfkit.internal;

import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.RadioButtonFormElement;
import com.pspdfkit.utils.PdfLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.FormEditor$toggleRadio$1", f = "FormEditor.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, nl = {349}, s = {}, v = 2)
public final class qh extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ FormElement b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qh(FormElement formElement, Continuation<? super qh> continuation) {
        super(2, continuation);
        this.b = formElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new qh(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new qh(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FormElement formElement = this.b;
                formElement.getClass();
                this.a = 1;
                if (sh.a((RadioButtonFormElement) formElement, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            PdfLog.e("Nutri.FormEditor", e, "Failed to select radio button", new Object[0]);
        }
        return Unit.INSTANCE;
    }
}
