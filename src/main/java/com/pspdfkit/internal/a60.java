package com.pspdfkit.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.intune.mam.client.widget.MAMEditText;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.AnnotationProviderRxJava;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.GoToAction;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.links.LinkAnnotationHighlighter;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.AnnotationCreatorInputDialogFragment;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.TextSelectionController;
import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.EnumSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a60 extends l30 implements TextSelectionController {
    public final w50 d;
    public final z1 e;
    public final PdfFragment f;
    public final AnnotationPreferencesManager g;
    public final LinkAnnotationHighlighter h;
    public final vo i;
    public EnumSet<DocumentPermissions> j;
    public y50 k;
    public y50 l;
    public String m;
    public boolean n;
    public zd o;
    public TextSelectionController.OnSearchSelectedTextListener p;

    public class a implements AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
        public final void onAbort() {
        }

        @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
        public final void onAnnotationCreatorSet(String str) {
            this.a.run();
        }
    }

    public class b implements AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener {
        public b() {
        }

        @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
        public final void onAbort() {
        }

        @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
        public final void onAnnotationCreatorSet(String str) {
            a60 a60Var = a60.this;
            a60Var.a(a60Var.m);
        }
    }

    public class c extends c30 {
        public final /* synthetic */ AlertDialog a;

        public c(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            a60.this.m = charSequence.toString();
            a60.this.a(this.a);
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            a = iArr;
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnnotationType.REDACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnnotationType.STRIKEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AnnotationType.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a60(w50 w50Var, z1 z1Var, PdfFragment pdfFragment, AnnotationPreferencesManager annotationPreferencesManager, at atVar, vo voVar) {
        super(pdfFragment.requireContext(), pdfFragment, atVar);
        this.j = EnumSet.noneOf(DocumentPermissions.class);
        this.e = z1Var;
        this.f = pdfFragment;
        this.d = w50Var;
        this.g = annotationPreferencesManager;
        LinkAnnotationHighlighter linkAnnotationHighlighter = new LinkAnnotationHighlighter(pdfFragment.requireContext());
        this.h = linkAnnotationHighlighter;
        this.i = voVar;
        pdfFragment.addDrawableProvider(linkAnnotationHighlighter);
    }

    public static /* synthetic */ void a(DialogInterface dialogInterface, int i) {
    }

    public final boolean a(TextSelection textSelection, TextSelection textSelection2) {
        x50 x50Var = (x50) this.d;
        x50Var.getClass();
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Text selection listeners touched on non ui thread.");
        }
        Iterator<TextSelectionManager.OnTextSelectionChangeListener> it = x50Var.b.iterator();
        while (it.hasNext()) {
            if (!it.next().onBeforeTextSelectionChange(textSelection, textSelection2)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ void b() {
        a(AnnotationType.HIGHLIGHT, true);
    }

    public final /* synthetic */ void c() {
        a(AnnotationType.REDACT, false);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void createLinkAboveSelectedText() {
        if (!isLinkCreationEnabledByConfiguration()) {
            PdfLog.w("Nutri.TextSelSMHandler", "Unable to create link above selected text: creating links not enabled by configuration.", new Object[0]);
            return;
        }
        if (this.g.isAnnotationCreatorSet()) {
            a(this.m);
            return;
        }
        AnnotationCreatorInputDialogFragment.show(this.f.requireActivity().getSupportFragmentManager(), null, new b());
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.a(Analytics.Event.SHOW_ANNOTATION_CREATOR_DIALOG, new Bundle());
    }

    public final /* synthetic */ void d() {
        a(AnnotationType.STRIKEOUT, false);
    }

    public final /* synthetic */ void e() {
        a(AnnotationType.UNDERLINE, false);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController
    public final PdfFragment getFragment() {
        return this.f;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final TextSelection getTextSelection() {
        y50 y50Var = this.k;
        if (y50Var != null) {
            return y50Var.a;
        }
        y50 y50Var2 = this.l;
        if (y50Var2 != null) {
            return y50Var2.a;
        }
        return null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final TextSelectionManager getTextSelectionManager() {
        return this.d;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void highlightSelectedText() {
        a(new Runnable() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void highlightSelectedTextAndBeginCommenting() {
        a(new Runnable() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isInstantHighlightCommentingEnabledByConfiguration() {
        return ar.b().a(this.f.getConfiguration(), AnnotationTool.INSTANT_HIGHLIGHT_COMMENT) && ar.b().a(this.f.getConfiguration(), this.f.getDocument());
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isLinkCreationEnabledByConfiguration() {
        return ar.b().a(this.f.getConfiguration(), AnnotationType.LINK) && ar.b().a(this.f.getConfiguration(), this.f.getDocument());
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isRedactionEnabledByConfiguration() {
        return ar.b().a(this.f.getConfiguration(), AnnotationTool.REDACTION);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isTextExtractionEnabledByDocumentPermissions() {
        return this.j.contains(DocumentPermissions.EXTRACT);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isTextHighlightingEnabledByConfiguration() {
        return ar.b().a(this.f.getConfiguration(), AnnotationTool.HIGHLIGHT) && ar.b().a(this.f.getConfiguration(), this.f.getDocument());
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isTextSharingEnabledByConfiguration() {
        return this.f.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.TEXT_SELECTION_SHARING);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final boolean isTextSpeakEnabledByDocumentPermissions() {
        return this.j.contains(DocumentPermissions.EXTRACT_ACCESSIBILITY);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void redactSelectedText() {
        a(new Runnable() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void searchSelectedText() {
        TextSelection textSelection = getTextSelection();
        if (textSelection == null) {
            return;
        }
        String str = textSelection.text;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ACTION, "search");
        bundle.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
        i0VarA.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle);
        TextSelectionController.OnSearchSelectedTextListener onSearchSelectedTextListener = this.p;
        if (onSearchSelectedTextListener != null) {
            onSearchSelectedTextListener.onSearchSelectedText(str);
        }
        y50 y50Var = this.l;
        if (y50Var != null) {
            y50Var.a((TextSelection) null, y50Var.t);
        } else {
            this.b.exitCurrentlyActiveMode();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void setOnSearchSelectedTextListener(TextSelectionController.OnSearchSelectedTextListener onSearchSelectedTextListener) {
        this.p = onSearchSelectedTextListener;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void setTextSelection(TextSelection textSelection) {
        y50 y50Var = this.k;
        if (y50Var != null) {
            y50Var.a(textSelection, y50Var.t);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void strikeoutSelectedText() {
        a(new Runnable() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController
    public final void underlineSelectedText() {
        a(new Runnable() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    public final void b(Throwable th) throws Throwable {
        PdfLog.d("Nutri.TextSelSMHandler", th, "Creating link annotation above the selected text failed.", new Object[0]);
        Toast.makeText(this.f.requireContext(), R.string.pspdf__link_annotation_creation_failed, 0).show();
    }

    public final /* synthetic */ void a() {
        a(AnnotationType.HIGHLIGHT, false);
    }

    public final void a(Runnable runnable) {
        if (this.g.getAnnotationCreator() == null) {
            AnnotationCreatorInputDialogFragment.show(this.f.getParentFragmentManager(), null, new a(runnable));
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            i0VarA.a(Analytics.Event.SHOW_ANNOTATION_CREATOR_DIALOG, new Bundle());
            return;
        }
        runnable.run();
    }

    public final void a(final AnnotationType annotationType, final boolean z) {
        y50 y50Var = this.l;
        if (y50Var == null) {
            y50Var = this.k;
        }
        if (y50Var == null) {
            return;
        }
        final TextSelection textSelection = y50Var.a;
        y50Var.a(annotationType, z).subscribe(new Consumer() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(textSelection, annotationType, z, (BaseRectsAnnotation) obj);
            }
        }, new Consumer() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a((Throwable) obj);
            }
        });
    }

    public final void a(TextSelection textSelection, AnnotationType annotationType, boolean z, BaseRectsAnnotation baseRectsAnnotation) throws Throwable {
        String str;
        if (textSelection != null) {
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            int i = d.a[annotationType.ordinal()];
            if (i == 1) {
                str = "highlight";
            } else if (i == 2) {
                str = "redact";
            } else if (i == 3) {
                str = "strikeout";
            } else {
                if (i != 4) {
                    throw new IllegalArgumentException("Invalid type passed: " + annotationType);
                }
                str = "underline";
            }
            bundleA.putString(Analytics.Data.ACTION, str);
            bundleA.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
            i0VarA.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundleA);
        }
        y50 y50Var = this.l;
        if (y50Var != null) {
            y50Var.a((TextSelection) null, y50Var.t);
        } else {
            this.b.exitCurrentlyActiveMode();
        }
        if (z) {
            this.e.a(baseRectsAnnotation);
        }
    }

    public final /* synthetic */ void a(Throwable th) throws Throwable {
        PdfLog.e("Nutri.TextSelSMHandler", th, "Failed to create annotation for selected text.", new Object[0]);
    }

    public final void a(String str) {
        FrameLayout frameLayout = new FrameLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = this.a.getResources().getDimensionPixelSize(R.dimen.pspdf__alert_dialog_inset);
        layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.pspdf__alert_dialog_inset);
        final MAMEditText mAMEditText = new MAMEditText(this.a);
        mAMEditText.setId(R.id.pspdf__link_creator_dialog_edit_text);
        mAMEditText.setSingleLine();
        if (str != null) {
            mAMEditText.setText(str);
        }
        mAMEditText.setLayoutParams(layoutParams);
        frameLayout.addView(mAMEditText);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(this.a).setTitle(R.string.pspdf__link_destination).setMessage(R.string.pspdf__link_enter_page_index_or_url).setView(frameLayout).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.a(dialogInterface);
            }
        }).setPositiveButton(R.string.pspdf__add_link, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                a60.a(dialogInterface, i);
            }
        }).setNegativeButton(no.a(this.a, R.string.pspdf__cancel, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
        mAMEditText.addTextChangedListener(new c(alertDialogCreate));
        alertDialogCreate.show();
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(mAMEditText, alertDialogCreate, view);
            }
        });
        a(alertDialogCreate);
        this.n = true;
    }

    public final /* synthetic */ void a(DialogInterface dialogInterface) {
        this.n = false;
        this.m = null;
    }

    public final void a(EditText editText, AlertDialog alertDialog, View view) {
        TextSelection textSelection = getTextSelection();
        String str = this.m;
        if (str != null && textSelection != null) {
            if (!str.startsWith("http://") && !this.m.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX)) {
                try {
                    a(Integer.valueOf(Integer.parseInt(this.m)), textSelection);
                } catch (NumberFormatException e) {
                    PdfLog.d("Nutri.TextSelSMHandler", e, "Entered text could not be converted to an Integer nor URL.", new Object[0]);
                    editText.setError(view.getContext().getString(R.string.pspdf__link_annotation_creation_parsed_text_error));
                    return;
                }
            } else {
                String str2 = this.m;
                PdfDocument document = this.f.getDocument();
                if (document != null) {
                    a(document, textSelection, new UriAction(str2));
                }
            }
        }
        y50 y50Var = this.l;
        if (y50Var != null) {
            y50Var.a((TextSelection) null, y50Var.t);
        } else {
            this.b.exitCurrentlyActiveMode();
        }
        alertDialog.dismiss();
    }

    public final void a(AlertDialog alertDialog) {
        Button button = alertDialog.getButton(-1);
        String str = this.m;
        button.setEnabled((str == null || str.isEmpty()) ? false : true);
    }

    public final void a(Integer num, TextSelection textSelection) {
        PdfDocument document = this.f.getDocument();
        if (document == null) {
            return;
        }
        if (num.intValue() >= 0 && num.intValue() < document.getPageCount()) {
            a(document, textSelection, new GoToAction(num.intValue()));
            return;
        }
        Context contextRequireContext = this.f.requireContext();
        Toast.makeText(contextRequireContext, contextRequireContext.getResources().getString(R.string.pspdf__link_page_not_found, String.valueOf(num)), 0).show();
        PdfLog.d("Nutri.TextSelSMHandler", "Unable to create link annotation with GOTO action pointing to non-existing page in the document.", new Object[0]);
    }

    public final void a(PdfDocument pdfDocument, TextSelection textSelection, Action action) {
        final LinkAnnotation linkAnnotation = new LinkAnnotation(textSelection.pageIndex);
        linkAnnotation.setBoundingBox(ip.a(textSelection.textBlocks));
        linkAnnotation.setAction(action);
        AnnotationProviderRxJava.addAnnotationToPageCompletable(pdfDocument.getAnnotationProvider(), linkAnnotation).observeOn(AndroidSchedulers.mainThread()).subscribe(new io.reactivex.rxjava3.functions.Action() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(linkAnnotation);
            }
        }, new Consumer() { // from class: com.pspdfkit.internal.a60$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.b((Throwable) obj);
            }
        });
    }

    public final void a(LinkAnnotation linkAnnotation) throws Throwable {
        PdfLog.d("Nutri.TextSelSMHandler", "Link annotation successfully created above the selected text.", new Object[0]);
        Toast.makeText(this.f.requireContext(), R.string.pspdf__link_annotation_successfully_created, 0).show();
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.ANNOTATION_TYPE, linkAnnotation.getType().name());
        bundle.putInt(Analytics.Data.PAGE_INDEX, linkAnnotation.getPageIndex());
        i0VarA.a(Analytics.Event.CREATE_ANNOTATION, bundle);
        this.h.setLinkAnnotation(linkAnnotation);
    }
}
