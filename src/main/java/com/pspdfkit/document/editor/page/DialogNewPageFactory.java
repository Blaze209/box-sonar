package com.pspdfkit.document.editor.page;

import androidx.fragment.app.FragmentManager;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.Size;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogNewPageFactory implements NewPageFactory {
    private final Size documentPageSize;
    private final WeakReference<FragmentManager> fragmentManager;
    private final List<PageTemplate> pageTemplates;
    private final boolean showPageTemplatesLast;

    public DialogNewPageFactory(FragmentManager fragmentManager) {
        this(fragmentManager, null);
    }

    @Override // com.pspdfkit.document.editor.page.NewPageFactory
    public void onCreateNewPage(final NewPageFactory.OnNewPageReadyListener onNewPageReadyListener) {
        uw.a(onNewPageReadyListener, "callback", null);
        FragmentManager fragmentManager = this.fragmentManager.get();
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            onNewPageReadyListener.onCancelled();
        } else {
            NewPageDialog.show(fragmentManager, this.documentPageSize, this.pageTemplates, this.showPageTemplatesLast, new NewPageDialog.Callback() { // from class: com.pspdfkit.document.editor.page.DialogNewPageFactory.1
                @Override // com.pspdfkit.document.editor.page.NewPageDialog.Callback
                public void onDialogCancelled() {
                    onNewPageReadyListener.onCancelled();
                }

                @Override // com.pspdfkit.document.editor.page.NewPageDialog.Callback
                public void onDialogConfirmed(NewPage newPage) {
                    onNewPageReadyListener.onNewPageReady(newPage);
                }
            });
        }
    }

    public DialogNewPageFactory(FragmentManager fragmentManager, Size size) {
        this(fragmentManager, size, null);
    }

    public DialogNewPageFactory(FragmentManager fragmentManager, Size size, List<PageTemplate> list) {
        this(fragmentManager, size, list, false);
    }

    public DialogNewPageFactory(FragmentManager fragmentManager, Size size, List<PageTemplate> list, boolean z) {
        uw.a(fragmentManager, "fragmentManager", null);
        this.fragmentManager = new WeakReference<>(fragmentManager);
        this.documentPageSize = size;
        if (list == null) {
            this.pageTemplates = Collections.EMPTY_LIST;
        } else {
            this.pageTemplates = list;
        }
        this.showPageTemplatesLast = z;
    }
}
