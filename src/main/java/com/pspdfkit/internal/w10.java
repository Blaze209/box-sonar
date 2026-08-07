package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.SignatureAnnotationModeHandler$setupHitDetector$1", f = "SignatureAnnotationModeHandler.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, nl = {175}, s = {}, v = 2)
public final class w10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ u10 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w10(u10 u10Var, Continuation<? super w10> continuation) {
        super(2, continuation);
        this.b = u10Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new w10(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new w10(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v20 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        m40 state;
        fm fmVar;
        Object objPrepareFieldsCache;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                lm lmVarJ = this.b.j();
                this = this;
                if (lmVarJ != null && (fmVar = lmVarJ.g) != null) {
                    this.a = 1;
                    objPrepareFieldsCache = fmVar.prepareFieldsCache(this);
                    if (objPrepareFieldsCache == coroutine_suspended) {
                        this = this;
                        this = objPrepareFieldsCache;
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
            this = this;
            this = objPrepareFieldsCache;
            this = this;
        } catch (Throwable th) {
            au auVarL = this.b.l();
            Integer numBoxInt = (auVarL == null || (state = auVarL.getState()) == null) ? null : Boxing.boxInt(state.b);
            if (th instanceof CancellationException) {
                if (numBoxInt != null) {
                    PdfLog.w("Nutri.SignAnnotModeHand", "Loading form elements was cancelled for page: %d", numBoxInt);
                } else {
                    PdfLog.w("Nutri.SignAnnotModeHand", "Loading form elements was cancelled.", new Object[0]);
                }
            } else if (numBoxInt != null) {
                PdfLog.e("Nutri.SignAnnotModeHand", th, "Exception while loading form elements on page: %d", numBoxInt);
            } else {
                PdfLog.e("Nutri.SignAnnotModeHand", th, "Exception while loading form elements.", new Object[0]);
            }
        }
        return Unit.INSTANCE;
    }
}
