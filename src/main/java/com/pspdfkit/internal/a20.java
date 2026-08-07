package com.pspdfkit.internal;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.forms.FormElement;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$onDocumentLoaded$1", f = "SignatureFormSigningHandler.kt", i = {1}, l = {Token.TARGET, Token.SCRIPT}, m = "invokeSuspend", n = {"widgetAnnotationCurrentlyBeingSigned"}, nl = {134, 136}, s = {"L$0"}, v = 2)
public final class a20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ b20 c;
    public final /* synthetic */ wu d;
    public final /* synthetic */ lm e;

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$onDocumentLoaded$1$formElement$1", f = "SignatureFormSigningHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FormElement>, Object> {
        public final /* synthetic */ WidgetAnnotation a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WidgetAnnotation widgetAnnotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = widgetAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FormElement> continuation) {
            WidgetAnnotation widgetAnnotation = this.a;
            new a(widgetAnnotation, continuation);
            Unit unit = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(unit);
            return widgetAnnotation.getFormElement();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return this.a.getFormElement();
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$onDocumentLoaded$1$widgetAnnotationCurrentlyBeingSigned$1", f = "SignatureFormSigningHandler.kt", i = {}, l = {Token.LOOP}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetAnnotation>, Object> {
        public int a;
        public final /* synthetic */ wu b;
        public final /* synthetic */ lm c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wu wuVar, lm lmVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = wuVar;
            this.c = lmVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WidgetAnnotation> continuation) {
            return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                wu wuVar = this.b;
                lm lmVar = this.c;
                this.a = 1;
                obj = wuVar.a(lmVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj instanceof WidgetAnnotation) {
                return (WidgetAnnotation) obj;
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a20(b20 b20Var, wu wuVar, lm lmVar, Continuation<? super a20> continuation) {
        super(2, continuation);
        this.c = b20Var;
        this.d = wuVar;
        this.e = lmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a20(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((a20) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r8 == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.b
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r7.a
            com.pspdfkit.annotations.WidgetAnnotation r0 = (com.pspdfkit.annotations.WidgetAnnotation) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> La2
            goto L5b
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> La2
            goto L3c
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> La2
            com.pspdfkit.internal.a20$b r1 = new com.pspdfkit.internal.a20$b     // Catch: java.lang.Exception -> La2
            com.pspdfkit.internal.wu r5 = r7.d     // Catch: java.lang.Exception -> La2
            com.pspdfkit.internal.lm r6 = r7.e     // Catch: java.lang.Exception -> La2
            r1.<init>(r5, r6, r4)     // Catch: java.lang.Exception -> La2
            r7.b = r3     // Catch: java.lang.Exception -> La2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7)     // Catch: java.lang.Exception -> La2
            if (r8 != r0) goto L3c
            goto L5a
        L3c:
            com.pspdfkit.annotations.WidgetAnnotation r8 = (com.pspdfkit.annotations.WidgetAnnotation) r8     // Catch: java.lang.Exception -> La2
            if (r8 != 0) goto L43
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> La2
            return r7
        L43:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> La2
            com.pspdfkit.internal.a20$a r3 = new com.pspdfkit.internal.a20$a     // Catch: java.lang.Exception -> La2
            r3.<init>(r8, r4)     // Catch: java.lang.Exception -> La2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch: java.lang.Exception -> La2
            r7.a = r8     // Catch: java.lang.Exception -> La2
            r7.b = r2     // Catch: java.lang.Exception -> La2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r7)     // Catch: java.lang.Exception -> La2
            if (r8 != r0) goto L5b
        L5a:
            return r0
        L5b:
            com.pspdfkit.forms.FormElement r8 = (com.pspdfkit.forms.FormElement) r8     // Catch: java.lang.Exception -> La2
            boolean r0 = r8 instanceof com.pspdfkit.forms.SignatureFormElement     // Catch: java.lang.Exception -> La2
            if (r0 == 0) goto L64
            r4 = r8
            com.pspdfkit.forms.SignatureFormElement r4 = (com.pspdfkit.forms.SignatureFormElement) r4     // Catch: java.lang.Exception -> La2
        L64:
            if (r4 != 0) goto L69
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> La2
            return r7
        L69:
            com.pspdfkit.internal.b20 r7 = r7.c     // Catch: java.lang.Exception -> La2
            r7.d = r4     // Catch: java.lang.Exception -> La2
            com.pspdfkit.ui.PdfFragment r8 = r7.a     // Catch: java.lang.Exception -> La2
            com.pspdfkit.internal.tg r0 = com.pspdfkit.internal.ar.b()     // Catch: java.lang.Exception -> La2
            monitor-enter(r0)     // Catch: java.lang.Exception -> La2
            com.pspdfkit.internal.jni.NativeLicense r1 = com.pspdfkit.internal.jni.NativeLicense.license()     // Catch: java.lang.Throwable -> L9f
            com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability r1 = r1.signatureFeatureAvailability()     // Catch: java.lang.Throwable -> L9f
            com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability r2 = com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability.ELECTRONICSIGNATURES     // Catch: java.lang.Throwable -> L9f
            if (r1 != r2) goto L8d
            monitor-exit(r0)     // Catch: java.lang.Exception -> La2
            androidx.fragment.app.FragmentManager r0 = r8.getParentFragmentManager()     // Catch: java.lang.Exception -> La2
            com.pspdfkit.signatures.storage.SignatureStorage r8 = r8.getSignatureStorage()     // Catch: java.lang.Exception -> La2
            com.pspdfkit.ui.signatures.ElectronicSignatureFragment.restore(r0, r7, r8)     // Catch: java.lang.Exception -> La2
            goto La2
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Exception -> La2
            com.pspdfkit.ui.signatures.SignaturePickerFragment$Companion r0 = com.pspdfkit.ui.signatures.SignaturePickerFragment.INSTANCE     // Catch: java.lang.Exception -> La2
            androidx.fragment.app.FragmentManager r1 = r8.getParentFragmentManager()     // Catch: java.lang.Exception -> La2
            r1.getClass()     // Catch: java.lang.Exception -> La2
            com.pspdfkit.signatures.storage.SignatureStorage r8 = r8.getSignatureStorage()     // Catch: java.lang.Exception -> La2
            r0.restore(r1, r7, r8)     // Catch: java.lang.Exception -> La2
            goto La2
        L9f:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Exception -> La2
            throw r7     // Catch: java.lang.Exception -> La2
        La2:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.a20.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
