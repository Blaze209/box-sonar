package com.pspdfkit.document.editor.page;

import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public final class ValueNewPageFactory implements NewPageFactory {
    private final NewPage newPage;

    public ValueNewPageFactory(NewPage newPage) {
        uw.a(newPage, "newPage", null);
        this.newPage = newPage;
    }

    @Override // com.pspdfkit.document.editor.page.NewPageFactory
    public void onCreateNewPage(NewPageFactory.OnNewPageReadyListener onNewPageReadyListener) {
        onNewPageReadyListener.onNewPageReady(this.newPage);
    }
}
