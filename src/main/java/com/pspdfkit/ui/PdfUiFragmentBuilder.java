package com.pspdfkit.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.uw;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfUiFragmentBuilder extends BasePdfUiBuilder<PdfUiFragmentBuilder> {
    private Class<? extends PdfUiFragment> fragmentClass;
    private String pdfFragmentTag;

    private PdfUiFragmentBuilder(Context context, List<Uri> list, List<DataProvider> list2) {
        super(context, list, list2);
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
    }

    public static PdfUiFragmentBuilder emptyFragment(Context context) {
        uw.a(context, "context", null);
        return new PdfUiFragmentBuilder(context);
    }

    public static PdfUiFragmentBuilder fromDataProvider(Context context, DataProvider... dataProviderArr) {
        uw.a(context, "context", null);
        uw.a(dataProviderArr, "Can't create document with null or empty document data provider(s).");
        return new PdfUiFragmentBuilder(context, (List<Uri>) null, (List<DataProvider>) Arrays.asList(dataProviderArr));
    }

    public static PdfUiFragmentBuilder fromDocumentDescriptor(Context context, DocumentDescriptor... documentDescriptorArr) {
        uw.a(context, "context", null);
        uw.a(documentDescriptorArr, "Can't create fragment with no documents loaded.");
        return new PdfUiFragmentBuilder(context, Arrays.asList(documentDescriptorArr));
    }

    public static PdfUiFragmentBuilder fromImageProvider(Context context, DataProvider dataProvider) {
        uw.a(context, "context", null);
        uw.a(dataProvider, "dataProvider", "Can't create document with null image document provider.");
        return new PdfUiFragmentBuilder(context, (Uri) null, dataProvider);
    }

    public static PdfUiFragmentBuilder fromImageUri(Context context, Uri uri) {
        uw.a(context, "context", null);
        uw.a(uri, "uri", "Can't create image document with null image document Uri.");
        return new PdfUiFragmentBuilder(context, uri, (DataProvider) null);
    }

    public static PdfUiFragmentBuilder fromUri(Context context, Uri... uriArr) {
        uw.a(context, "context", null);
        uw.a(uriArr, "Can't create document with null or empty document URI(s).");
        return new PdfUiFragmentBuilder(context, (List<Uri>) Arrays.asList(uriArr), (List<DataProvider>) null);
    }

    public PdfUiFragment build() {
        if (this.fragmentClass == null) {
            this.fragmentClass = PdfUiFragment.class;
        }
        if (this.configuration == null) {
            this.configuration = new PdfActivityConfiguration.Builder(this.context).build();
        }
        try {
            PdfUiFragment pdfUiFragmentNewInstance = this.fragmentClass.getDeclaredConstructor(null).newInstance(null);
            pdfUiFragmentNewInstance.setArguments(createExtras());
            return pdfUiFragmentNewInstance;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate PdfUiFragment.", e);
        }
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public Bundle createExtras() {
        Bundle bundleCreateExtras = super.createExtras();
        bundleCreateExtras.putString("Nutri.PdfFragmentTag", this.pdfFragmentTag);
        return bundleCreateExtras;
    }

    public PdfUiFragmentBuilder fragmentClass(Class<? extends PdfUiFragment> cls) {
        if (cls != null && !PdfUiFragment.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Passed fragment class must extend PdfUiFragment!");
        }
        this.fragmentClass = cls;
        return this;
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfUiFragmentBuilder getThis() {
        return this;
    }

    public PdfUiFragmentBuilder pdfFragmentTag(String str) {
        if (str != null) {
            this.pdfFragmentTag = str;
            return this;
        }
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
        return this;
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfUiFragmentBuilder configuration(PdfActivityConfiguration pdfActivityConfiguration) {
        return (PdfUiFragmentBuilder) super.configuration(pdfActivityConfiguration);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfUiFragmentBuilder contentSignatures(String... strArr) {
        return (PdfUiFragmentBuilder) super.contentSignatures(strArr);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfUiFragmentBuilder passwords(String... strArr) {
        return (PdfUiFragmentBuilder) super.passwords(strArr);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfUiFragmentBuilder visibleDocument(int i) {
        return (PdfUiFragmentBuilder) super.visibleDocument(i);
    }

    private PdfUiFragmentBuilder(Context context, Uri uri, DataProvider dataProvider) {
        super(context, uri, dataProvider);
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
    }

    private PdfUiFragmentBuilder(Context context, List<DocumentDescriptor> list) {
        super(context, list);
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
    }

    private PdfUiFragmentBuilder(Context context) {
        super(context);
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
    }
}
