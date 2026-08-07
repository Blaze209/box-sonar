package com.pspdfkit.internal;

import android.widget.TextView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.PdfActivityUserInterfaceCoordinator$updatePageNumberOverlay$1", f = "PdfActivityUserInterfaceCoordinator.kt", i = {0}, l = {915}, m = "invokeSuspend", n = {"data"}, nl = {925}, s = {"L$0"}, v = 2)
public final class iv extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ lm c;
    public final /* synthetic */ int d;
    public final /* synthetic */ dv e;
    public final /* synthetic */ TextView f;
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;

    @DebugMetadata(c = "com.pspdfkit.internal.ui.PdfActivityUserInterfaceCoordinator$updatePageNumberOverlay$1$1", f = "PdfActivityUserInterfaceCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ dv a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ dv.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dv dvVar, TextView textView, int i, int i2, boolean z, dv.a aVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = dvVar;
            this.b = textView;
            this.c = i;
            this.d = i2;
            this.e = z;
            this.f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            dv dvVar = this.a;
            TextView textView = this.b;
            int i = this.c;
            int i2 = this.d;
            boolean z = this.e;
            dv.a aVar = this.f;
            dv.a(dvVar, textView, i, i2, z, aVar.a, aVar.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv(lm lmVar, int i, dv dvVar, TextView textView, int i2, boolean z, Continuation<? super iv> continuation) {
        super(2, continuation);
        this.c = lmVar;
        this.d = i;
        this.e = dvVar;
        this.f = textView;
        this.g = i2;
        this.h = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new iv(this.c, this.d, this.e, this.f, this.g, this.h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((iv) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            dv.a aVar = new dv.a(this.c.getPageLabel(this.d, false), this.c.s);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar2 = new a(this.e, this.f, this.d, this.g, this.h, aVar, null);
            this.a = SpillingKt.nullOutSpilledVariable(aVar);
            this.b = 1;
            if (BuildersKt.withContext(main, aVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
