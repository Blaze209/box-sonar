package com.pspdfkit.internal;

import android.widget.Toast;
import com.pspdfkit.R;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.utils.PdfLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.ContentEditingSpecialModeHandler$saveContentChanges$1", f = "ContentEditingSpecialModeHandler.kt", i = {}, l = {494}, m = "invokeSuspend", n = {}, nl = {495}, s = {}, v = 2)
public final class bb extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ ab b;

    @DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.ContentEditingSpecialModeHandler$saveContentChanges$1$1", f = "ContentEditingSpecialModeHandler.kt", i = {0}, l = {460}, m = "invokeSuspend", n = {"$this$flow"}, nl = {461}, s = {"L$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super ya<Unit>>, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ ab c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ab abVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = abVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ya<Unit>> flowCollector, Continuation<? super Unit> continuation) {
            a aVar = new a(this.c, continuation);
            aVar.b = flowCollector;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            FlowCollector flowCollector = (FlowCollector) this.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ya<Unit> yaVarB = this.c.b();
                this.b = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.a = 1;
                if (flowCollector.emit(yaVarB, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.ContentEditingSpecialModeHandler$saveContentChanges$1$2", f = "ContentEditingSpecialModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function3<FlowCollector<? super ya<Unit>>, Throwable, Continuation<? super Unit>, Object> {
        public /* synthetic */ Throwable a;
        public final /* synthetic */ ab b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ab abVar, Continuation<? super b> continuation) {
            super(3, continuation);
            this.b = abVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ya<Unit>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            b bVar = new b(this.b, continuation);
            bVar.a = th;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = this.a;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            PdfLog.e("Nutri.CEditingSMHandler", th, "Saving content to document failed.", new Object[0]);
            ab abVar = this.b;
            Toast.makeText(abVar.a, R.string.pspdf__document_could_not_be_saved, 0).show();
            abVar.b.exitCurrentlyActiveMode();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.ContentEditingSpecialModeHandler$saveContentChanges$1$3", f = "ContentEditingSpecialModeHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function3<FlowCollector<? super ya<Unit>>, Throwable, Continuation<? super Unit>, Object> {
        public /* synthetic */ Throwable a;
        public final /* synthetic */ ab b;

        public static final class a implements InternalDocumentListener {
            public final /* synthetic */ ab a;
            public final /* synthetic */ x70 b;

            public a(ab abVar, x70 x70Var) {
                this.a = abVar;
                this.b = x70Var;
            }

            public static final void a(x70 x70Var, DocumentView documentView) {
                documentView.getClass();
                documentView.setViewState(x70Var);
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public final void onDocumentLoadFailed(Throwable th) {
                th.getClass();
                this.a.e.removeDocumentListener(this);
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public final void onDocumentLoaded(PdfDocument pdfDocument) {
                pdfDocument.getClass();
                this.a.e.removeDocumentListener(this);
                uv viewCoordinator = this.a.e.getInternal().getViewCoordinator();
                final x70 x70Var = this.b;
                viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.internal.bb$c$a$$ExternalSyntheticLambda0
                    @Override // com.pspdfkit.internal.uv.c
                    public final void a(DocumentView documentView) {
                        bb.c.a.a(x70Var, documentView);
                    }
                }, false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ab abVar, Continuation<? super c> continuation) {
            super(3, continuation);
            this.b = abVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ya<Unit>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            c cVar = new c(this.b, continuation);
            cVar.a = th;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = this.a;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            if (th == null) {
                PdfDocument document = this.b.e.getDocument();
                if (document != null) {
                    ab abVar = this.b;
                    DocumentView documentViewA = abVar.e.getInternal().getViewCoordinator().a(false);
                    x70 viewState = documentViewA != null ? documentViewA.getViewState() : null;
                    if (viewState != null) {
                        abVar.e.addDocumentListener(new a(abVar, viewState));
                    }
                    abVar.e.setCustomPdfSources(document.getDocumentSources());
                }
                this.b.b.exitCurrentlyActiveMode();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(ab abVar, Continuation<? super bb> continuation) {
        super(2, continuation);
        this.b = abVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new bb(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new bb(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowOnCompletion = FlowKt.onCompletion(FlowKt.m16356catch(FlowKt.flowOn(FlowKt.flow(new a(this.b, null)), Dispatchers.getIO()), new b(this.b, null)), new c(this.b, null));
            this.a = 1;
            if (FlowKt.collect(flowOnCompletion, this) == coroutine_suspended) {
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
