package com.pspdfkit.internal;

import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.bx.a;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.ui.PdfThumbnailBar;
import com.pspdfkit.ui.PdfThumbnailGrid;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.redaction.RedactionView;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class wx implements RedactionView.RedactionViewListener {
    public final AppCompatActivity a;
    public final at b;
    public final lm c;
    public final o3 d;
    public final lc e;
    public final PdfUi f;

    @DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionApplicator$onRedactionsCleared$1", f = "RedactionApplicator.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, nl = {72}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.wx$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.ui.redaction.RedactionApplicator$onRedactionsCleared$1$1$1$1", f = "RedactionApplicator.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class C0293a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ wx b;
            public final /* synthetic */ Annotation c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0293a(wx wxVar, Annotation annotation, Continuation<? super C0293a> continuation) {
                super(2, continuation);
                this.b = wxVar;
                this.c = annotation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0293a(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new C0293a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    o3 o3Var = this.b.d;
                    Annotation annotation = this.c;
                    this.a = 1;
                    if (o3Var.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
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

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        public static final void a(List list, wx wxVar) throws InterruptedException {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BuildersKt__BuildersKt.runBlocking$default(null, new C0293a(wxVar, (Annotation) it.next(), null), 1, null);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return wx.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return wx.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    o3 o3Var = wx.this.d;
                    EnumSet enumSetOf = EnumSet.of(AnnotationType.REDACT);
                    enumSetOf.getClass();
                    this.a = 1;
                    obj = o3.a(o3Var, enumSetOf, 0, o3Var.a.s, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                final List list = (List) obj;
                final wx wxVar = wx.this;
                wxVar.d.a(wxVar.b, new Runnable() { // from class: com.pspdfkit.internal.wx$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        wx.a.a(list, wxVar);
                    }
                });
            } catch (Throwable th) {
                PdfLog.e("Nutri.RedactApplicator", th, "Redactions couldn't be cleared.", new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public b() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Uri uri = (Uri) obj;
            uri.getClass();
            int i = gy.h;
            wx wxVar = wx.this;
            AppCompatActivity appCompatActivity = wxVar.a;
            lm lmVar = wxVar.c;
            appCompatActivity.getClass();
            lmVar.getClass();
            if (appCompatActivity.getSupportFragmentManager().findFragmentByTag("RedactionProcessorFragment") != null) {
                return;
            }
            gy gyVar = new gy();
            gyVar.f = lmVar;
            gyVar.g = uri;
            appCompatActivity.getSupportFragmentManager().beginTransaction().add(gyVar, "RedactionProcessorFragment").commit();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = new c<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.RedactApplicator", th, "Document couldn't be redacted.", new Object[0]);
        }
    }

    public wx(AppCompatActivity appCompatActivity, a70 a70Var, lm lmVar, o3 o3Var, lc lcVar, PdfUi pdfUi) {
        appCompatActivity.getClass();
        lmVar.getClass();
        o3Var.getClass();
        pdfUi.getClass();
        this.a = appCompatActivity;
        this.b = a70Var;
        this.c = lmVar;
        this.d = o3Var;
        this.e = lcVar;
        this.f = pdfUi;
    }

    public static final void a(wx wxVar, DialogInterface dialogInterface, int i) {
        wxVar.a();
    }

    public static final void b() {
    }

    public static final void b(wx wxVar, DialogInterface dialogInterface, int i) {
        wxVar.getClass();
        int i2 = gy.h;
        AppCompatActivity appCompatActivity = wxVar.a;
        lm lmVar = wxVar.c;
        appCompatActivity.getClass();
        lmVar.getClass();
        if (appCompatActivity.getSupportFragmentManager().findFragmentByTag("RedactionProcessorFragment") != null) {
            return;
        }
        gy gyVar = new gy();
        gyVar.f = lmVar;
        gyVar.g = null;
        appCompatActivity.getSupportFragmentManager().beginTransaction().add(gyVar, "RedactionProcessorFragment").commit();
    }

    @Override // com.pspdfkit.ui.redaction.RedactionView.RedactionViewListener
    public final void onPreviewModeChanged(boolean z) {
        PdfFragment pdfFragment = this.f.getPdfFragment();
        if (pdfFragment != null) {
            pdfFragment.setRedactionAnnotationPreviewEnabled(z);
            PSPDFKitViews pSPDFKitViews = this.f.getPSPDFKitViews();
            PdfThumbnailBar thumbnailBarView = pSPDFKitViews.getThumbnailBarView();
            if (thumbnailBarView != null) {
                thumbnailBarView.setRedactionAnnotationPreviewEnabled(z);
            }
            PdfThumbnailGrid thumbnailGridView = pSPDFKitViews.getThumbnailGridView();
            if (thumbnailGridView != null) {
                thumbnailGridView.setRedactionAnnotationPreviewEnabled(z);
            }
            PdfOutlineView outlineView = pSPDFKitViews.getOutlineView();
            if (outlineView != null) {
                outlineView.setRedactionAnnotationPreviewEnabled(z);
            }
            RedactionView redactionView = pSPDFKitViews.getRedactionView();
            if (redactionView != null) {
                redactionView.setRedactionAnnotationPreviewEnabled(z);
            }
            RedactionView redactionView2 = pSPDFKitViews.getRedactionView();
            if (redactionView2 != null) {
                redactionView2.collapseRedactionOptions();
            }
        }
    }

    @Override // com.pspdfkit.ui.redaction.RedactionView.RedactionViewListener
    public final void onRedactionsApplied() {
        boolean zIsWritableAndCanSave = this.c.isWritableAndCanSave();
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this.a).setTitle(R.string.pspdf__redaction_apply_redactions).setMessage(R.string.pspdf__redaction_apply_dialog_message).setNeutralButton(R.string.pspdf__cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.pspdf__redaction_apply_dialog_new_file, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.wx$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                wx.a(this.f$0, dialogInterface, i);
            }
        });
        if (zIsWritableAndCanSave) {
            positiveButton.setNegativeButton(R.string.pspdf__redaction_apply_dialog_overwrite_file, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.wx$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    wx.b(this.f$0, dialogInterface, i);
                }
            });
        }
        positiveButton.show();
    }

    @Override // com.pspdfkit.ui.redaction.RedactionView.RedactionViewListener
    public final void onRedactionsCleared() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new a(null), 3, null);
    }

    public final void a() {
        lc lcVar = this.e;
        AppCompatActivity appCompatActivity = this.a;
        String strReplaceAll = no.a(appCompatActivity, R.string.pspdf__filename_redacted, (View) null, ww.a(appCompatActivity, this.c)).replaceAll("[:\\\\/*\"?|<>']", "");
        strReplaceAll.getClass();
        Maybe<Uri> destinationUri = lcVar.getDestinationUri("android.intent.action.CREATE_DOCUMENT", strReplaceAll);
        bx bxVar = this.c.a.a;
        bxVar.getClass();
        destinationUri.subscribeOn(bxVar.new a(5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), c.a, new Action() { // from class: com.pspdfkit.internal.wx$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                wx.b();
            }
        });
    }
}
