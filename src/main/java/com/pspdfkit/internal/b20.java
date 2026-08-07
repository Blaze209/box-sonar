package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.listeners.OnSignaturePickedListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.signatures.SignatureInfoDialog;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.utils.PdfLog;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class b20 implements FormManager.OnFormElementClickedListener, OnSignaturePickedListener {
    public final PdfFragment a;
    public lm b;
    public wu c;
    public SignatureFormElement d;
    public final a e = new a();
    public Job f;

    public static final class a implements InternalDocumentListener {
        public a() {
        }

        @Override // com.pspdfkit.listeners.DocumentListener
        public final void onDocumentLoaded(PdfDocument pdfDocument) {
            pdfDocument.getClass();
            b20 b20Var = b20.this;
            lm lmVar = (lm) pdfDocument;
            if (ar.b().a(NativeLicenseFeatures.ACRO_FORMS) && b20Var.a.isAdded()) {
                b20Var.b = lmVar;
                Job job = b20Var.f;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                wu wuVar = b20Var.c;
                if (wuVar != null) {
                    b20Var.f = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a20(b20Var, wuVar, lmVar, null), 3, null);
                }
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$onSignaturePicked$1", f = "SignatureFormSigningHandler.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, nl = {289}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Annotation c;
        public final /* synthetic */ PdfDocument d;

        @DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler$onSignaturePicked$1$1", f = "SignatureFormSigningHandler.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, nl = {288}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ PdfDocument b;
            public final /* synthetic */ Annotation c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(PdfDocument pdfDocument, Annotation annotation, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = pdfDocument;
                this.c = annotation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnnotationProvider annotationProvider = this.b.getAnnotationProvider();
                    Annotation annotation = this.c;
                    this.a = 1;
                    if (annotationProvider.addAnnotationToPage(annotation, this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Annotation annotation, PdfDocument pdfDocument, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = annotation;
            this.d = pdfDocument;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b20.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                a aVar = new a(this.d, this.c, null);
                this.a = 1;
                if (BuildersKt.withContext(io2, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            b20.this.a.setSelectedAnnotation(this.c);
            return Unit.INSTANCE;
        }
    }

    public b20(PdfFragment pdfFragment) {
        this.a = pdfFragment;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(b20 b20Var, SignatureFormElement signatureFormElement, List list, ContinuationImpl continuationImpl) {
        z10 z10Var;
        WidgetAnnotation widgetAnnotation;
        Annotation annotation;
        if (continuationImpl instanceof z10) {
            z10Var = (z10) continuationImpl;
            int i = z10Var.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                z10Var.g = i - Integer.MIN_VALUE;
            } else {
                z10Var = new z10(b20Var, continuationImpl);
            }
        } else {
            z10Var = new z10(b20Var, continuationImpl);
        }
        Object obj = z10Var.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = z10Var.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            PdfDocument document = b20Var.a.getDocument();
            if (document == null) {
                return null;
            }
            WidgetAnnotation annotation2 = signatureFormElement.getAnnotation();
            annotation2.getClass();
            AnnotationProvider annotationProvider = document.getAnnotationProvider();
            EnumSet enumSetOf = EnumSet.of(AnnotationType.WIDGET);
            enumSetOf.getClass();
            int pageIndex = annotation2.getPageIndex();
            z10Var.a = SpillingKt.nullOutSpilledVariable(signatureFormElement);
            z10Var.b = list;
            z10Var.c = SpillingKt.nullOutSpilledVariable(document);
            z10Var.d = annotation2;
            z10Var.g = 1;
            Object allAnnotationsOfType = annotationProvider.getAllAnnotationsOfType(enumSetOf, pageIndex, 1, z10Var);
            if (allAnnotationsOfType == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = allAnnotationsOfType;
            widgetAnnotation = annotation2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            widgetAnnotation = z10Var.d;
            list = z10Var.b;
            ResultKt.throwOnFailure(obj);
        }
        List list2 = (List) obj;
        for (Annotation annotation3 : list) {
            annotation3.getClass();
            list2.getClass();
            int size = list2.size();
            if (size == 0) {
                annotation = null;
            } else if (size != 1) {
                PointF pointF = new PointF(annotation3.getBoundingBox().centerX(), annotation3.getBoundingBox().centerY());
                Iterator it = list2.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object next = it.next();
                if (it.hasNext()) {
                    Annotation annotation4 = (Annotation) next;
                    float fA = ip.a(pointF.x, pointF.y, annotation4.getBoundingBox().centerX(), annotation4.getBoundingBox().centerY());
                    do {
                        Object next2 = it.next();
                        Annotation annotation5 = (Annotation) next2;
                        float fA2 = ip.a(pointF.x, pointF.y, annotation5.getBoundingBox().centerX(), annotation5.getBoundingBox().centerY());
                        if (Float.compare(fA, fA2) > 0) {
                            next = next2;
                            fA = fA2;
                        }
                    } while (it.hasNext());
                }
                annotation = (Annotation) next;
            } else {
                annotation = (Annotation) CollectionsKt.first(list2);
            }
            if (annotation != null && annotation.getObjectNumber() == widgetAnnotation.getObjectNumber()) {
                return annotation3;
            }
        }
        return null;
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onDismiss() {
        Job job = this.f;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementClickedListener
    public final boolean onFormElementClicked(FormElement formElement) {
        formElement.getClass();
        if (formElement.getType() != FormType.SIGNATURE || this.a.getDocument() == null) {
            return false;
        }
        SignatureFormElement signatureFormElement = (SignatureFormElement) formElement;
        PdfDocument document = this.a.getDocument();
        if (document == null) {
            return true;
        }
        FragmentManager parentFragmentManager = this.a.getParentFragmentManager();
        parentFragmentManager.getClass();
        boolean zA = ar.b().a(NativeLicenseFeatures.ACRO_FORMS);
        boolean zA2 = ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES);
        ar.b().getClass();
        boolean zB = tg.b();
        if (!zA) {
            return true;
        }
        if (zA2 && signatureFormElement.isSigned()) {
            SignatureInfoDialog.show(parentFragmentManager, signatureFormElement.getSignatureInfo(), a(signatureFormElement));
            return true;
        }
        if (!zB) {
            PdfLog.w("Nutri.SignFormHandler", "Attempted to add or select a signature but license does not include Electronic Signatures, skipping...", new Object[0]);
            return true;
        }
        WidgetAnnotation annotation = signatureFormElement.getAnnotation();
        annotation.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new c20(annotation, this, signatureFormElement, document, null), 3, null);
        return true;
    }

    @Override // com.pspdfkit.signatures.listeners.OnSignaturePickedListener
    public final void onSignaturePicked(Signature signature) {
        lm lmVar;
        signature.getClass();
        SignatureFormElement signatureFormElement = this.d;
        if (signatureFormElement == null || (lmVar = this.b) == null) {
            return;
        }
        WidgetAnnotation annotation = signatureFormElement.getAnnotation();
        annotation.getClass();
        RectF boundingBox = annotation.getBoundingBox();
        int pageIndex = annotation.getPageIndex();
        float fWidth = boundingBox.width();
        float fHeight = boundingBox.height();
        float fCenterX = boundingBox.centerX();
        float fCenterY = boundingBox.centerY();
        float f = fWidth * 0.95f;
        float f2 = fHeight * 0.95f;
        RectF rectF = new RectF();
        float f3 = fCenterX - (f / 2.0f);
        rectF.left = f3;
        rectF.right = f3 + f;
        float f4 = fCenterY - (f2 / 2.0f);
        rectF.top = f4;
        rectF.bottom = f4 + f2;
        Annotation annotation2 = signature.toAnnotation(lmVar, pageIndex, rectF);
        annotation2.setCreator(this.a.getAnnotationPreferences().getAnnotationCreator());
        PdfDocument document = this.a.getDocument();
        if (document != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new b(annotation2, document, null), 3, null);
        }
    }

    public final Runnable a(final SignatureFormElement signatureFormElement) {
        if (signatureFormElement.isReadOnly()) {
            return null;
        }
        return new Runnable() { // from class: com.pspdfkit.internal.b20$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b20.a(signatureFormElement, this);
            }
        };
    }

    public static final void a(SignatureFormElement signatureFormElement, b20 b20Var) {
        try {
            signatureFormElement.getFormField().removeSignature();
        } catch (NutrientException e) {
            b20Var.getClass();
            Log.e("Nutri.SignFormHandler", "Error while deleting a signature", e);
        }
    }
}
