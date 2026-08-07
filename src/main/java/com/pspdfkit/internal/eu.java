package com.pspdfkit.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.utils.PdfLog;
import java.util.Iterator;
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
@DebugMetadata(c = "com.pspdfkit.internal.views.page.PageLayout$refreshRenderingForSignatureFields$1", f = "PageLayout.kt", i = {}, l = {TypedValues.Custom.TYPE_FLOAT}, m = "invokeSuspend", n = {}, nl = {TypedValues.Custom.TYPE_BOOLEAN}, s = {}, v = 2)
public final class eu extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ au b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eu(au auVar, Continuation<? super eu> continuation) {
        super(2, continuation);
        this.b = auVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new eu(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new eu(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                au auVar = this.b;
                this.a = 1;
                obj = au.a(auVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            if (this.b.w.getValue() == null) {
                return Unit.INSTANCE;
            }
            au auVar2 = this.b;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                auVar2.onFormElementUpdated((SignatureFormElement) it.next());
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            PdfLog.e("Nutri.PageLayout", e, "Unable to refresh signature fields", new Object[0]);
        }
    }
}
