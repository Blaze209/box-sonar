package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import external.sdk.pendo.io.mozilla.javascript.Token;
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
@DebugMetadata(c = "com.pspdfkit.internal.views.page.FormEditor$prepareCache$1", f = "FormEditor.kt", i = {}, l = {Token.LET}, m = "invokeSuspend", n = {}, nl = {Token.CONST}, s = {}, v = 2)
public final class oh extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ mh b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh(mh mhVar, Continuation<? super oh> continuation) {
        super(2, continuation);
        this.b = mhVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new oh(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new oh(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                fm fmVar = this.b.b.g;
                this.a = 1;
                Object objPrepareFieldsCache = fmVar.prepareFieldsCache(this);
                this = objPrepareFieldsCache;
                if (objPrepareFieldsCache == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
        } catch (Throwable th) {
            m40 state = this.b.a.getState();
            Integer numBoxInt = state != null ? Boxing.boxInt(state.b) : null;
            if (th instanceof CancellationException) {
                if (numBoxInt != null) {
                    PdfLog.w("Nutri.FormEditor", "Loading form elements was cancelled for page: %d", numBoxInt);
                } else {
                    PdfLog.w("Nutri.FormEditor", "Loading form elements was cancelled.", new Object[0]);
                }
            } else if (numBoxInt != null) {
                PdfLog.e("Nutri.FormEditor", th, "Exception while loading form elements on page: %d", numBoxInt);
            } else {
                PdfLog.e("Nutri.FormEditor", th, "Exception while loading form elements.", new Object[0]);
            }
        }
        return Unit.INSTANCE;
    }
}
