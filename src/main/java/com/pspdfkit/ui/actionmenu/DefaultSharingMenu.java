package com.pspdfkit.ui.actionmenu;

import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.R;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.internal.uw;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSharingMenu extends SharingMenu {
    private static final int MENU_OPTION_OPEN = R.id.pspdf__menu_option_open;
    private static final int MENU_OPTION_PRINT = R.id.pspdf__menu_option_print;
    private static final int MENU_OPTION_SAVE_AS = R.id.pspdf__menu_option_save_as;
    private final PdfDocument document;
    private boolean isPrintingEnabled;
    private boolean isShareEnabled;
    private final SharingMenuListener listener;

    public interface SharingMenuListener extends SharingMenu.SharingMenuListener {
        void performPrint();

        void performSaveAs();

        void showShareMenu(ShareAction shareAction);
    }

    public DefaultSharingMenu(FragmentActivity fragmentActivity, PdfDocument pdfDocument, SharingMenuListener sharingMenuListener) {
        super(fragmentActivity, sharingMenuListener);
        uw.a(pdfDocument, "document", null);
        this.document = pdfDocument;
        this.listener = sharingMenuListener;
        setSharingEnabled(true);
        setPrintingEnabled(true);
    }

    @Override // com.pspdfkit.ui.actionmenu.SharingMenu, com.pspdfkit.ui.actionmenu.ActionMenu
    public boolean onMenuItemClicked(ActionMenuItem actionMenuItem) {
        if (super.onMenuItemClicked(actionMenuItem)) {
            return true;
        }
        if (this.listener == null) {
            return false;
        }
        if (actionMenuItem.getItemId() == R.id.pspdf__menu_option_print) {
            dismiss();
            this.listener.performPrint();
            return true;
        }
        if (actionMenuItem.getItemId() == R.id.pspdf__menu_option_open) {
            dismiss();
            this.listener.showShareMenu(ShareAction.VIEW);
            return true;
        }
        if (actionMenuItem.getItemId() != R.id.pspdf__menu_option_save_as) {
            return false;
        }
        dismiss();
        this.listener.performSaveAs();
        return true;
    }

    @Override // com.pspdfkit.ui.actionmenu.SharingMenu
    public void sanitizeMenuItems() {
        ListIterator<ActionMenuItem> listIterator = getMenuItems().listIterator(getMenuItems().size());
        boolean z = false;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().isPrintItem()) {
                if (!this.isPrintingEnabled || z) {
                    listIterator.remove();
                } else {
                    z = true;
                }
            }
        }
    }

    public void setPrintingEnabled(boolean z) {
        this.isPrintingEnabled = z;
    }

    public void setSharingEnabled(boolean z) {
        if (this.isShareEnabled != z) {
            setShareAction(z ? ShareAction.SEND : null);
        }
        this.isShareEnabled = z;
    }

    @Override // com.pspdfkit.ui.actionmenu.SharingMenu, com.pspdfkit.ui.actionmenu.ActionMenu
    public boolean show() {
        if (getContext() == null) {
            return false;
        }
        clearFixedMenuItems();
        if (this.isPrintingEnabled) {
            FixedActionMenuItem fixedActionMenuItem = new FixedActionMenuItem(getContext(), MENU_OPTION_PRINT, R.drawable.pspdf__ic_print_large, R.string.pspdf__print);
            fixedActionMenuItem.setEnabled(DocumentPrintManager.get().hasPrintPermission(this.document));
            addMenuItem(fixedActionMenuItem);
        }
        if (this.isShareEnabled) {
            addMenuItem(new FixedActionMenuItem(getContext(), this.document.isWritableAndCanSave() ? MENU_OPTION_OPEN : MENU_OPTION_SAVE_AS, R.drawable.pspdf__ic_open_in, this.document.isWritableAndCanSave() ? R.string.pspdf__open : R.string.pspdf__save_as));
        }
        return super.show();
    }
}
