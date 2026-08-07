package com.pspdfkit.document.processor;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.R;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.bd;
import com.pspdfkit.internal.uw;
import java.io.File;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentComparisonDialog {
    public static void restore(FragmentActivity fragmentActivity, ComparisonDialogListener comparisonDialogListener) {
        int i = bd.o;
        fragmentActivity.getClass();
        comparisonDialogListener.getClass();
        uw.a(fragmentActivity.getSupportFragmentManager(), "fragmentManager", null);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.getClass();
        bd bdVar = (bd) supportFragmentManager.findFragmentByTag("com.pspdfkit.document.processor.DocumentComparisonDialog");
        if (bdVar == null) {
            return;
        }
        bdVar.g = comparisonDialogListener;
    }

    public static void show(FragmentActivity fragmentActivity, PdfActivityConfiguration pdfActivityConfiguration, ComparisonDocument comparisonDocument, ComparisonDocument comparisonDocument2, File file, ComparisonDialogListener comparisonDialogListener) {
        int i = bd.o;
        fragmentActivity.getClass();
        pdfActivityConfiguration.getClass();
        comparisonDocument.getClass();
        comparisonDocument2.getClass();
        file.getClass();
        comparisonDialogListener.getClass();
        uw.a(fragmentActivity.getSupportFragmentManager(), "fragmentManager", null);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.getClass();
        bd bdVar = (bd) supportFragmentManager.findFragmentByTag("com.pspdfkit.document.processor.DocumentComparisonDialog");
        if (bdVar == null) {
            bdVar = new bd();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("comparison_documents_list_argument", CollectionsKt.arrayListOf(comparisonDocument, comparisonDocument2));
        bundle.putParcelable("pdf_configuration_argument", pdfActivityConfiguration);
        bundle.putString("output_file_argument", file.getAbsolutePath());
        bdVar.setArguments(bundle);
        bdVar.setStyle(1, R.style.PSPDFKit_FullScreenDialog);
        bdVar.g = comparisonDialogListener;
        bdVar.show(fragmentActivity.getSupportFragmentManager(), "com.pspdfkit.document.processor.DocumentComparisonDialog");
    }
}
