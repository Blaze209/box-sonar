package com.pspdfkit.document.editor.page;

import com.pspdfkit.document.processor.NewPage;

/* JADX INFO: loaded from: classes3.dex */
public interface NewPageFactory {

    public interface OnNewPageReadyListener {
        void onCancelled();

        void onNewPageReady(NewPage newPage);
    }

    void onCreateNewPage(OnNewPageReadyListener onNewPageReadyListener);
}
