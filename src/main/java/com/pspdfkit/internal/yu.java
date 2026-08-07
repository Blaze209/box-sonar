package com.pspdfkit.internal;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionType;
import com.pspdfkit.annotations.actions.GoToEmbeddedAction;
import com.pspdfkit.annotations.actions.NamedAction;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.DocumentActionListener;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.sharing.DocumentSharingProviderProcessor;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfActivityIntentBuilder;
import com.pspdfkit.ui.PdfFragment;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class yu implements DocumentActionListener {
    public final cw a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[NamedAction.NamedActionType.values().length];
            b = iArr;
            try {
                iArr[NamedAction.NamedActionType.PRINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[NamedAction.NamedActionType.OUTLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[NamedAction.NamedActionType.FIND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[NamedAction.NamedActionType.SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[NamedAction.NamedActionType.SAVEAS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ActionType.values().length];
            a = iArr2;
            try {
                iArr2[ActionType.NAMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ActionType.GOTO_EMBEDDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public yu(cw cwVar) {
        this.a = cwVar;
    }

    public final boolean a(final GoToEmbeddedAction goToEmbeddedAction) {
        if (!goToEmbeddedAction.getIsNewWindow()) {
            return false;
        }
        PdfFragment pdfFragment = this.a.fragment;
        if (TextUtils.isEmpty(goToEmbeddedAction.getPdfPath()) || pdfFragment == null || pdfFragment.getDocument() == null) {
            return false;
        }
        pdfFragment.getDocument().getEmbeddedFilesProvider().getEmbeddedFileWithFileNameAsync(goToEmbeddedAction.getPdfPath(), true).subscribe(new Consumer() { // from class: com.pspdfkit.internal.yu$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(goToEmbeddedAction, (EmbeddedFile) obj);
            }
        });
        return true;
    }

    @Override // com.pspdfkit.document.DocumentActionListener
    public final boolean onExecuteAction(Action action) {
        int i = a.a[action.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            return a((GoToEmbeddedAction) action);
        }
        int i2 = a.b[((NamedAction) action).getNamedActionType().ordinal()];
        if (i2 == 1) {
            this.a.showPrintDialog();
            return true;
        }
        if (i2 == 2) {
            ((jv) this.a.getViews()).toggleView(PSPDFKitViews.Type.VIEW_OUTLINE, 0L);
            return true;
        }
        if (i2 == 3 || i2 == 4) {
            ((jv) this.a.getViews()).toggleView(PSPDFKitViews.Type.VIEW_SEARCH, 0L);
            return true;
        }
        if (i2 != 5) {
            return false;
        }
        this.a.showSaveAsDialog();
        return true;
    }

    public final /* synthetic */ void a(GoToEmbeddedAction goToEmbeddedAction, EmbeddedFile embeddedFile) throws Throwable {
        a(embeddedFile, goToEmbeddedAction.getPageIndex());
    }

    public final void a(EmbeddedFile embeddedFile, final int i) {
        final AppCompatActivity hostingActivity = this.a.getHostingActivity();
        Single<Uri> singlePrepareEmbeddedFileForSharing = DocumentSharingProviderProcessor.prepareEmbeddedFileForSharing(hostingActivity, embeddedFile);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        singlePrepareEmbeddedFileForSharing.subscribeOn(schedulerIo).subscribe(new Consumer() { // from class: com.pspdfkit.internal.yu$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(i, hostingActivity, (Uri) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void a(int i, Activity activity, Uri uri) throws Throwable {
        PdfActivityIntentBuilder pdfActivityIntentBuilderConfiguration = PdfActivityIntentBuilder.fromUri(activity, uri).configuration(new PdfActivityConfiguration.Builder(this.a.getConfiguration()).page(i).build());
        if (activity instanceof PdfActivity) {
            pdfActivityIntentBuilderConfiguration.activityClass((Class<? extends PdfActivity>) activity.getClass());
        }
        activity.startActivity(pdfActivityIntentBuilderConfiguration.build());
    }
}
