package com.pspdfkit.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.PushButtonFormElement;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class sv implements dn {
    public final PdfFragment a;
    public zl b;
    public final CompositeDisposable c = new CompositeDisposable();

    @DebugMetadata(c = "com.pspdfkit.internal.ui.javascript.PdfFragmentJsPlatformDelegate$importButtonIcon$1", f = "PdfFragmentJsPlatformDelegate.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, nl = {125}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ PdfDocument b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ sv e;
        public final /* synthetic */ Context f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PdfDocument pdfDocument, int i, int i2, sv svVar, Context context, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = pdfDocument;
            this.c = i;
            this.d = i2;
            this.e = svVar;
            this.f = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationProvider annotationProvider = this.b.getAnnotationProvider();
                int i2 = this.c;
                int i3 = this.d;
                this.a = 1;
                obj = annotationProvider.getAnnotation(i2, i3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Annotation annotation = (Annotation) obj;
            WidgetAnnotation widgetAnnotation = annotation instanceof WidgetAnnotation ? (WidgetAnnotation) annotation : null;
            if (widgetAnnotation == null) {
                return Unit.INSTANCE;
            }
            FormElement formElement = widgetAnnotation.getFormElement();
            if (!(formElement instanceof PushButtonFormElement)) {
                PdfLog.e("Nutri.PdfFragJsPlatDel", "Can't import button icon: importButtonIcon action works only on push buttons.", new Object[0]);
                return Unit.INSTANCE;
            }
            sv svVar = this.e;
            PushButtonFormElement pushButtonFormElement = (PushButtonFormElement) formElement;
            FragmentManager parentFragmentManager = svVar.a.getParentFragmentManager();
            parentFragmentManager.getClass();
            svVar.b = new zl(parentFragmentManager);
            sv svVar2 = this.e;
            zl zlVar = svVar2.b;
            if (zlVar != null) {
                rv rvVar = new rv(svVar2, this.f, pushButtonFormElement, widgetAnnotation);
                zlVar.b = rvVar;
                yl ylVar = zlVar.c;
                if (ylVar != null) {
                    ylVar.b = rvVar;
                    yl.a aVar = ylVar.c;
                    if (aVar != null) {
                        ylVar.a(aVar);
                    }
                }
            }
            zl zlVar2 = this.e.b;
            if (zlVar2 != null) {
                Boxing.boxBoolean(zlVar2.a(null));
            }
            return Unit.INSTANCE;
        }
    }

    public sv(PdfFragment pdfFragment) {
        this.a = pdfFragment;
    }

    @Override // com.pspdfkit.internal.dn
    public final bn a(String str, String str2) {
        str.getClass();
        str2.getClass();
        if (this.a.getContext() == null) {
            return bn.CANCEL;
        }
        new MAMAlertDialogBuilder(this.a.getContext()).setTitle(str).setMessage(str2).setPositiveButton(no.a(this.a.requireContext(), R.string.pspdf__ok, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.sv$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                sv.a(dialogInterface, i);
            }
        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.pspdfkit.internal.sv$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return sv.a(dialogInterface, i, keyEvent);
            }
        }).create().show();
        return bn.OK;
    }

    public static final void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return false;
        }
        dialogInterface.dismiss();
        return true;
    }

    @Override // com.pspdfkit.internal.dn
    public final Integer a() {
        return Integer.valueOf(this.a.getPageIndex());
    }

    @Override // com.pspdfkit.internal.dn
    public final boolean a(int i) {
        this.a.setPageIndex(i, true);
        return true;
    }

    @Override // com.pspdfkit.internal.dn
    public final boolean a(String str) {
        str.getClass();
        this.a.executeAction(new UriAction(str, null, 2, null));
        return true;
    }

    @Override // com.pspdfkit.internal.dn
    public final boolean a(cn cnVar) {
        PdfDocument document = this.a.getDocument();
        FragmentActivity activity = this.a.getActivity();
        if (document == null || activity == null) {
            return false;
        }
        DocumentSharingManager.shareDocument(new xo(activity, cnVar), document, new SharingOptions(PdfProcessorTask.AnnotationProcessingMode.FLATTEN));
        return true;
    }

    @Override // com.pspdfkit.internal.dn
    public final boolean a(int i, int i2) {
        PdfDocument document;
        Context context;
        if (!ar.b().a(NativeLicenseFeatures.ACRO_FORMS) || (document = this.a.getDocument()) == null || (context = this.a.getContext()) == null) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new a(document, i, i2, this, context, null), 3, null);
        return true;
    }
}
