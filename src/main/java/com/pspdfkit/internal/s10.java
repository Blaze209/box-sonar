package com.pspdfkit.internal;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.document.printing.PrintOptions;
import com.pspdfkit.document.printing.PrintOptionsProvider;
import com.pspdfkit.document.sharing.DocumentSharingController;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.document.sharing.ShareTarget;
import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.document.sharing.SharingOptionsProvider;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.actionmenu.ActionMenu;
import com.pspdfkit.ui.actionmenu.ActionMenuItem;
import com.pspdfkit.ui.actionmenu.ActionMenuListener;
import com.pspdfkit.ui.actionmenu.DefaultSharingMenu;
import com.pspdfkit.ui.actionmenu.SharingMenu;
import com.pspdfkit.ui.dialog.BaseDocumentPrintDialog;
import com.pspdfkit.ui.dialog.BaseDocumentSharingDialog;
import com.pspdfkit.ui.dialog.DocumentPrintDialog;
import com.pspdfkit.ui.dialog.DocumentPrintDialogFactory;
import com.pspdfkit.ui.dialog.DocumentSharingDialog;
import com.pspdfkit.ui.dialog.DocumentSharingDialogConfiguration;
import com.pspdfkit.ui.dialog.DocumentSharingDialogFactory;

/* JADX INFO: loaded from: classes3.dex */
public class s10 extends Fragment implements DefaultSharingMenu.SharingMenuListener, ActionMenuListener {
    public static final /* synthetic */ int s = 0;
    public PdfFragment a;
    public ActionMenuListener b;
    public SharingOptionsProvider c;
    public PrintOptionsProvider d;
    public DocumentSharingDialogFactory e;
    public DocumentPrintDialogFactory f;
    public boolean g;
    public boolean h;
    public String i;
    public SharingMenu j;
    public se k;
    public be l;
    public le m;
    public b n;
    public ShareTarget o;
    public ShareAction p;
    public Bundle q;
    public final a r = new a();

    public class a implements InternalDocumentListener {
        public a() {
        }

        @Override // com.pspdfkit.listeners.DocumentListener
        public final void onDocumentLoaded(PdfDocument pdfDocument) {
            s10 s10Var = s10.this;
            if (s10Var.a == null) {
                return;
            }
            s10Var.a();
            s10.this.a.removeDocumentListener(this);
        }
    }

    public enum b {
        DEFAULT_SHARING_MENU,
        SHARING_MENU,
        PRINTING,
        SHARING,
        SAVING
    }

    public s10() {
        if (getParentFragment() == null) {
            setRetainInstance(true);
        }
    }

    public final void a() {
        PdfFragment pdfFragment;
        String string;
        ShareTarget shareTarget;
        if (this.q == null || (pdfFragment = this.a) == null || pdfFragment.getDocument() == null || getContext() == null) {
            return;
        }
        b bVar = (b) this.q.getSerializable("STATE_SHARING_MENU_STATE");
        if (bVar == null) {
            this.q = null;
            return;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            b();
        } else if (iOrdinal == 1) {
            ShareAction shareAction = (ShareAction) this.q.getSerializable("STATE_SHARING_MENU_SHARE_ACTION");
            if (shareAction != null) {
                showShareMenu(shareAction);
            }
        } else if (iOrdinal == 2) {
            performPrint();
        } else if (iOrdinal == 3) {
            ShareAction shareAction2 = (ShareAction) this.q.getSerializable("STATE_SHARE_TARGET_ACTION");
            if (shareAction2 != null && (string = this.q.getString("STATE_SHARE_TARGET_PACKAGE_NAME")) != null && (shareTarget = DocumentSharingIntentHelper.getShareTarget(getContext(), shareAction2, string)) != null) {
                performShare(shareTarget);
            }
        } else if (iOrdinal == 4) {
            performSaveAs();
        }
        this.q = null;
    }

    public final void b() {
        PdfFragment pdfFragment;
        if (getActivity() == null || (pdfFragment = this.a) == null || pdfFragment.getDocument() == null) {
            return;
        }
        DefaultSharingMenu defaultSharingMenu = new DefaultSharingMenu(getActivity(), this.a.getDocument(), this);
        defaultSharingMenu.setSharingEnabled(this.g);
        defaultSharingMenu.setPrintingEnabled(this.h);
        if (this.b != null) {
            defaultSharingMenu.addActionMenuListener(this);
        }
        this.j = defaultSharingMenu;
        this.n = b.DEFAULT_SHARING_MENU;
        defaultSharingMenu.show();
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public final boolean onActionMenuItemClicked(ActionMenu actionMenu, ActionMenuItem actionMenuItem) {
        ActionMenuListener actionMenuListener = this.b;
        return actionMenuListener != null && actionMenuListener.onActionMenuItemClicked(actionMenu, actionMenuItem);
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public final boolean onActionMenuItemLongClicked(ActionMenu actionMenu, ActionMenuItem actionMenuItem) {
        ActionMenuListener actionMenuListener = this.b;
        return actionMenuListener != null && actionMenuListener.onActionMenuItemLongClicked(actionMenu, actionMenuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.q = bundle;
            a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.a = null;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public final void onDisplayActionMenu(ActionMenu actionMenu) {
        ActionMenuListener actionMenuListener = this.b;
        if (actionMenuListener != null) {
            actionMenuListener.onDisplayActionMenu(actionMenu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        SharingMenu sharingMenu = this.j;
        if (sharingMenu != null) {
            sharingMenu.onDetach();
        }
        se seVar = this.k;
        if (seVar != null) {
            seVar.f = null;
            DocumentSharingController documentSharingController = seVar.g;
            if (documentSharingController != null) {
                documentSharingController.onDetach();
            }
        }
        be beVar = this.l;
        if (beVar != null) {
            beVar.b = null;
        }
        le leVar = this.m;
        if (leVar != null) {
            leVar.c = null;
            DocumentSharingController documentSharingController2 = leVar.d;
            if (documentSharingController2 != null) {
                documentSharingController2.onDetach();
            }
        }
        this.b = null;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public final boolean onPrepareActionMenu(ActionMenu actionMenu) {
        ActionMenuListener actionMenuListener = this.b;
        return actionMenuListener == null || actionMenuListener.onPrepareActionMenu(actionMenu);
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public final void onRemoveActionMenu(ActionMenu actionMenu) {
        ActionMenuListener actionMenuListener = this.b;
        if (actionMenuListener != null) {
            actionMenuListener.onRemoveActionMenu(actionMenu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (getActivity() == null) {
            return;
        }
        SharingMenu sharingMenu = this.j;
        if (sharingMenu != null) {
            sharingMenu.onAttach(getActivity());
        }
        se seVar = this.k;
        if (seVar != null) {
            FragmentActivity activity = getActivity();
            seVar.f = activity;
            DocumentSharingController documentSharingController = seVar.g;
            if (documentSharingController != null) {
                documentSharingController.onAttach(activity);
            } else if (DocumentSharingDialog.isVisible(activity.getSupportFragmentManager())) {
                DocumentSharingDialog.restore(activity.getSupportFragmentManager(), new re(seVar));
                seVar.j = true;
            }
        }
        be beVar = this.l;
        if (beVar != null) {
            FragmentActivity activity2 = getActivity();
            if (beVar.b == null) {
                beVar.b = activity2;
                if (DocumentPrintDialog.isVisible(activity2.getSupportFragmentManager())) {
                    DocumentPrintDialog.restore(activity2.getSupportFragmentManager(), new ae(beVar, activity2));
                    beVar.c = true;
                }
            }
        }
        le leVar = this.m;
        if (leVar != null) {
            FragmentActivity activity3 = getActivity();
            leVar.c = activity3;
            DocumentSharingController documentSharingController2 = leVar.d;
            if (documentSharingController2 != null) {
                documentSharingController2.onAttach(activity3);
            } else if (DocumentSharingDialog.isVisible(activity3.getSupportFragmentManager())) {
                DocumentSharingDialog.restore(activity3.getSupportFragmentManager(), new ke(leVar));
                leVar.f = true;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        le leVar;
        super.onSaveInstanceState(bundle);
        b bVar = this.n;
        if (bVar == null) {
            return;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            SharingMenu sharingMenu = this.j;
            if (sharingMenu == null || !sharingMenu.isShowing()) {
                return;
            }
            bundle.putSerializable("STATE_SHARING_MENU_STATE", this.n);
            return;
        }
        if (iOrdinal == 1) {
            SharingMenu sharingMenu2 = this.j;
            if (sharingMenu2 == null || !sharingMenu2.isShowing()) {
                return;
            }
            bundle.putSerializable("STATE_SHARING_MENU_STATE", this.n);
            bundle.putSerializable("STATE_SHARING_MENU_SHARE_ACTION", this.p);
            return;
        }
        if (iOrdinal == 2) {
            be beVar = this.l;
            if (beVar == null || !beVar.c) {
                return;
            }
            bundle.putSerializable("STATE_SHARING_MENU_STATE", this.n);
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal == 4 && (leVar = this.m) != null && leVar.f) {
                bundle.putSerializable("STATE_SHARING_MENU_STATE", this.n);
                return;
            }
            return;
        }
        se seVar = this.k;
        if (seVar == null || this.o == null || !seVar.j) {
            return;
        }
        bundle.putSerializable("STATE_SHARING_MENU_STATE", this.n);
        bundle.putSerializable("STATE_SHARE_TARGET_ACTION", this.o.getShareAction());
        bundle.putString("STATE_SHARE_TARGET_PACKAGE_NAME", this.o.getPackageName());
    }

    @Override // com.pspdfkit.ui.actionmenu.DefaultSharingMenu.SharingMenuListener
    public final void performPrint() {
        PdfFragment pdfFragment;
        int pageIndex;
        PrintOptions printOptionsCreatePrintOptions;
        if (getActivity() == null || (pdfFragment = this.a) == null || pdfFragment.getDocument() == null || !this.h || (pageIndex = this.a.getPageIndex()) < 0) {
            return;
        }
        this.n = b.PRINTING;
        FragmentActivity activity = getActivity();
        PdfDocument document = this.a.getDocument();
        DocumentPrintDialogFactory documentPrintDialogFactory = this.f;
        PrintOptionsProvider printOptionsProvider = this.d;
        String strA = this.i;
        be beVar = new be(activity, document, documentPrintDialogFactory, printOptionsProvider, pageIndex, strA);
        this.l = beVar;
        if (activity == null) {
            return;
        }
        if (!ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow creation of new PDF documents. This is mandatory for printing to work!");
        }
        if (printOptionsProvider != null && (printOptionsCreatePrintOptions = printOptionsProvider.createPrintOptions(document, pageIndex)) != null) {
            DocumentPrintManager.get().print(beVar.b, document, printOptionsCreatePrintOptions);
            return;
        }
        BaseDocumentPrintDialog baseDocumentPrintDialogCreateDocumentPrintDialog = documentPrintDialogFactory != null ? documentPrintDialogFactory.createDocumentPrintDialog() : null;
        beVar.c = true;
        FragmentActivity fragmentActivity = beVar.b;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        int pageCount = document.getPageCount();
        if (strA == null) {
            strA = ww.a(beVar.b, document);
        }
        DocumentPrintDialog.show(baseDocumentPrintDialogCreateDocumentPrintDialog, fragmentActivity, supportFragmentManager, pageIndex, pageCount, strA, new ae(beVar, beVar.b));
    }

    @Override // com.pspdfkit.ui.actionmenu.DefaultSharingMenu.SharingMenuListener
    public final void performSaveAs() {
        PdfFragment pdfFragment;
        int pageIndex;
        if (getActivity() == null || (pdfFragment = this.a) == null || pdfFragment.getDocument() == null || !this.g || (pageIndex = this.a.getPageIndex()) < 0) {
            return;
        }
        FragmentActivity activity = getActivity();
        PdfDocument document = this.a.getDocument();
        DocumentSharingDialogFactory documentSharingDialogFactory = this.e;
        ShareAction shareAction = ShareAction.VIEW;
        String str = this.i;
        le leVar = new le(activity, document, documentSharingDialogFactory, shareAction, pageIndex, str);
        this.m = leVar;
        this.n = b.SAVING;
        if (activity != null) {
            if (ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
                DocumentSharingDialogConfiguration.Builder builder = new DocumentSharingDialogConfiguration.Builder(leVar.c, shareAction, document, pageIndex);
                if (!TextUtils.isEmpty(str)) {
                    builder.initialDocumentName(str);
                }
                builder.setSavingFlow(true, leVar.c);
                builder.setInitialPagesSpinnerAllPages(true);
                BaseDocumentSharingDialog baseDocumentSharingDialogCreateDocumentSharingDialog = documentSharingDialogFactory != null ? documentSharingDialogFactory.createDocumentSharingDialog() : null;
                leVar.f = true;
                DocumentSharingDialog.show(baseDocumentSharingDialogCreateDocumentSharingDialog, leVar.c.getSupportFragmentManager(), builder.build(), new ke(leVar));
                return;
            }
            if (str == null) {
                str = "";
            }
            SharingOptions sharingOptions = new SharingOptions(str);
            FragmentActivity fragmentActivity = leVar.c;
            if (fragmentActivity == null) {
                return;
            }
            leVar.d = DocumentSharingManager.shareDocument(fragmentActivity, document, shareAction, sharingOptions);
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putString(Analytics.Data.ACTION, shareAction.name());
            i0VarA.a("share", bundleA);
        }
    }

    @Override // com.pspdfkit.ui.actionmenu.SharingMenu.SharingMenuListener
    public final void performShare(ShareTarget shareTarget) {
        PdfFragment pdfFragment;
        int pageIndex;
        SharingOptions sharingOptionsCreateSharingOptions;
        if (getActivity() == null || (pdfFragment = this.a) == null || pdfFragment.getDocument() == null || !this.g || (pageIndex = this.a.getPageIndex()) < 0) {
            return;
        }
        FragmentActivity activity = getActivity();
        PdfDocument document = this.a.getDocument();
        DocumentSharingDialogFactory documentSharingDialogFactory = this.e;
        SharingOptionsProvider sharingOptionsProvider = this.c;
        se seVar = new se(activity, document, documentSharingDialogFactory, sharingOptionsProvider, shareTarget, pageIndex, this.i);
        this.k = seVar;
        this.n = b.SHARING;
        this.o = shareTarget;
        if (seVar.f != null) {
            if (!ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
                String str = seVar.c;
                if (str == null) {
                    str = "";
                }
                seVar.a(new SharingOptions(str));
                return;
            }
            DocumentSharingDialogConfiguration.Builder builder = new DocumentSharingDialogConfiguration.Builder(seVar.f, seVar.e, document, seVar.b);
            if (seVar.k) {
                builder.positiveButtonText(no.a(seVar.f, R.string.pspdf__print, null));
                builder.dialogTitle(no.a(seVar.f, R.string.pspdf__print, null).concat("…"));
            }
            if (!TextUtils.isEmpty(seVar.c)) {
                builder.initialDocumentName(seVar.c);
            }
            if (sharingOptionsProvider != null && (sharingOptionsCreateSharingOptions = sharingOptionsProvider.createSharingOptions(document, seVar.b)) != null) {
                seVar.a(sharingOptionsCreateSharingOptions);
                return;
            }
            BaseDocumentSharingDialog baseDocumentSharingDialogCreateDocumentSharingDialog = documentSharingDialogFactory != null ? documentSharingDialogFactory.createDocumentSharingDialog() : null;
            seVar.j = true;
            DocumentSharingDialog.show(baseDocumentSharingDialogCreateDocumentSharingDialog, seVar.f.getSupportFragmentManager(), builder.build(), new re(seVar));
        }
    }

    @Override // com.pspdfkit.ui.actionmenu.DefaultSharingMenu.SharingMenuListener
    public final void showShareMenu(ShareAction shareAction) {
        if (getActivity() == null) {
            return;
        }
        SharingMenu sharingMenu = new SharingMenu(getActivity(), this);
        sharingMenu.setShareAction(shareAction);
        this.j = sharingMenu;
        this.n = b.SHARING_MENU;
        this.p = shareAction;
        sharingMenu.show();
    }
}
