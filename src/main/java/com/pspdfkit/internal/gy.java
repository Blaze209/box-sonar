package com.pspdfkit.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.R;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.DocumentDescriptor;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.document.editor.DocumentEditorProgressDialog;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/gy;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class gy extends Fragment {
    public static final /* synthetic */ int h = 0;
    public final MutableStateFlow<Boolean> a = StateFlowKt.MutableStateFlow(Boolean.FALSE);
    public final CompletableJob b;
    public final CoroutineScope c;
    public PdfUi d;
    public final DocumentEditorProgressDialog e;
    public lm f;
    public Uri g;

    public gy() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.b = completableJobSupervisorJob$default;
        this.c = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(Dispatchers.getMain().getImmediate()));
        this.e = new DocumentEditorProgressDialog();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(gy gyVar, lm lmVar, ContinuationImpl continuationImpl) {
        dy dyVar;
        if (continuationImpl instanceof dy) {
            dyVar = (dy) continuationImpl;
            int i = dyVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dyVar.d = i - Integer.MIN_VALUE;
            } else {
                dyVar = new dy(gyVar, continuationImpl);
            }
        } else {
            dyVar = new dy(gyVar, continuationImpl);
        }
        Object objA = dyVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dyVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            dyVar.a = lmVar;
            dyVar.d = 1;
            objA = gyVar.a(dyVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lmVar = dyVar.a;
            ResultKt.throwOnFailure(objA);
        }
        PdfUi pdfUi = (PdfUi) objA;
        if (pdfUi != null) {
            int pageIndex = pdfUi.getPageIndex();
            pdfUi.getDocumentCoordinator().setDocument(DocumentDescriptor.fromDocument(lmVar));
            pdfUi.setPageIndex(pageIndex);
        }
        gyVar.a(true);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        lm lmVar = this.f;
        if (lmVar == null) {
            a(true);
            return;
        }
        Uri uri = this.g;
        if (uri != null) {
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new cy(this, lmVar, uri, null), 3, null);
            return;
        }
        DocumentSaveOptions documentSaveOptionsA = lmVar.a(false);
        documentSaveOptionsA.setApplyRedactions(true);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new ay(this, lmVar, documentSaveOptionsA, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        this.e.showIndeterminateProgressDialog(requireContext(), R.string.pspdf__redaction_redacting);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Job.DefaultImpls.cancel$default((Job) this.b, (CancellationException) null, 1, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        Fragment fragment;
        super.onStart();
        Context context = getContext();
        context.getClass();
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity instanceof PdfActivity) {
            this.d = (PdfUi) fragmentActivity;
            this.a.setValue(Boolean.TRUE);
        }
        if (this.d == null) {
            List<Fragment> fragments = fragmentActivity.getSupportFragmentManager().getFragments();
            fragments.getClass();
            Iterator<T> it = fragments.iterator();
            do {
                if (!it.hasNext()) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                fragment = (Fragment) it.next();
            } while (!(fragment instanceof PdfUiFragment));
            fragment.getClass();
            this.d = (PdfUiFragment) fragment;
            this.a.setValue(Boolean.TRUE);
        }
        if (this.f == null) {
            a(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.a.setValue(Boolean.FALSE);
        this.d = null;
        JobKt__JobKt.cancelChildren$default((Job) this.b, (CancellationException) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(gy gyVar, PdfDocument pdfDocument, Uri uri, ContinuationImpl continuationImpl) {
        ey eyVar;
        if (continuationImpl instanceof ey) {
            eyVar = (ey) continuationImpl;
            int i = eyVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                eyVar.e = i - Integer.MIN_VALUE;
            } else {
                eyVar = new ey(gyVar, continuationImpl);
            }
        } else {
            eyVar = new ey(gyVar, continuationImpl);
        }
        Object objA = eyVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eyVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            eyVar.a = pdfDocument;
            eyVar.b = uri;
            eyVar.e = 1;
            objA = gyVar.a(eyVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uri = eyVar.b;
            pdfDocument = eyVar.a;
            ResultKt.throwOnFailure(objA);
        }
        PdfUi pdfUi = (PdfUi) objA;
        if (pdfUi != null) {
            DocumentDescriptor documentDescriptorFromUri = DocumentDescriptor.fromUri(uri, pdfDocument.getDocumentSource().getPassword());
            documentDescriptorFromUri.getClass();
            pdfUi.getDocumentCoordinator().addDocument(documentDescriptorFromUri);
            pdfUi.getDocumentCoordinator().setVisibleDocument(documentDescriptorFromUri);
        }
        gyVar.a(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(gy gyVar, ContinuationImpl continuationImpl) {
        fy fyVar;
        if (continuationImpl instanceof fy) {
            fyVar = (fy) continuationImpl;
            int i = fyVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                fyVar.c = i - Integer.MIN_VALUE;
            } else {
                fyVar = new fy(gyVar, continuationImpl);
            }
        } else {
            fyVar = new fy(gyVar, continuationImpl);
        }
        Object objA = fyVar.a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = fyVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            fyVar.c = 1;
            objA = gyVar.a(fyVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        if (((PdfUi) objA) != null) {
            gyVar.e.showErrorDialog(gyVar.requireContext(), R.string.pspdf__redaction_apply_dialog_failed);
            gyVar.a(false);
        } else {
            gyVar.a(true);
        }
        return Unit.INSTANCE;
    }

    public final void a(boolean z) {
        this.f = null;
        this.g = null;
        if (isAdded()) {
            getParentFragmentManager().beginTransaction().remove(this).commit();
        }
        if (z) {
            this.e.dismiss();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(ContinuationImpl continuationImpl) {
        zx zxVar;
        if (continuationImpl instanceof zx) {
            zxVar = (zx) continuationImpl;
            int i = zxVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                zxVar.c = i - Integer.MIN_VALUE;
            } else {
                zxVar = new zx(this, continuationImpl);
            }
        } else {
            zxVar = new zx(this, continuationImpl);
        }
        Object obj = zxVar.a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zxVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            yx yxVar = new yx(this.a);
            zxVar.c = 1;
            if (FlowKt.first(yxVar, zxVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return this.d;
    }
}
