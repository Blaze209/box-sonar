package com.pspdfkit.internal;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public interface sm {
    FragmentManager getFragmentManager();

    Bundle getPdfParameters();

    void performApplyConfiguration(PdfActivityConfiguration pdfActivityConfiguration);

    void setPdfView(View view);
}
