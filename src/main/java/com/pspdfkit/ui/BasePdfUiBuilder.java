package com.pspdfkit.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.wg;
import com.pspdfkit.ui.BasePdfUiBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class BasePdfUiBuilder<T extends BasePdfUiBuilder> {
    PdfActivityConfiguration configuration;
    private List<String> contentSignatures;
    final Context context;
    final List<DataProvider> dataProviders;
    final ArrayList<DocumentDescriptor> documentDescriptors;
    final List<Uri> documentUris;
    final DataProvider imageDocumentProvider;
    final Uri imageDocumentUri;
    private List<String> passwords;
    private int visibleDocumentIndex;

    public BasePdfUiBuilder(Context context, List<Uri> list, List<DataProvider> list2) {
        this.visibleDocumentIndex = 0;
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            throw new IllegalArgumentException("Either document URIs or dataProviders need to be non-null and not empty.");
        }
        if (list != null && list2 != null) {
            throw new IllegalArgumentException("Either document URIs or data providers need to be null.");
        }
        wg.a(context, false, list);
        this.context = context;
        this.documentUris = list;
        this.dataProviders = list2;
        this.imageDocumentUri = null;
        this.imageDocumentProvider = null;
        this.documentDescriptors = null;
    }

    public T configuration(PdfActivityConfiguration pdfActivityConfiguration) {
        this.configuration = pdfActivityConfiguration;
        return (T) getThis();
    }

    public T contentSignatures(String... strArr) {
        if (this.documentDescriptors != null) {
            throw new IllegalStateException("Content signatures are not supported when using document descriptors as they are already part of the DocumentDescriptor class.");
        }
        if (this.imageDocumentUri != null || this.imageDocumentProvider != null) {
            throw new IllegalStateException("Content signatures are not supported by image documents.");
        }
        this.contentSignatures = strArr == null ? null : Arrays.asList(strArr);
        return (T) getThis();
    }

    public Bundle createExtras() {
        Bundle bundle = new Bundle();
        ArrayList<DocumentDescriptor> arrayList = this.documentDescriptors;
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            List<Uri> list = this.documentUris;
            if (list != null) {
                arrayList.add(DocumentDescriptor.fromUris(list, this.passwords, this.contentSignatures));
            } else {
                List<DataProvider> list2 = this.dataProviders;
                if (list2 != null) {
                    Iterator<DataProvider> it = list2.iterator();
                    while (it.hasNext()) {
                        if (!(it.next() instanceof Parcelable)) {
                            throw new NutrientException("The DataProvider must implement Parcelable when used with the PdfActivity.");
                        }
                    }
                    arrayList.add(DocumentDescriptor.fromDataProviders(this.dataProviders, this.passwords, this.contentSignatures));
                } else {
                    Uri uri = this.imageDocumentUri;
                    if (uri != null) {
                        arrayList.add(DocumentDescriptor.imageDocumentFromUri(uri));
                    } else {
                        DataProvider dataProvider = this.imageDocumentProvider;
                        if (dataProvider != null) {
                            if (!(dataProvider instanceof Parcelable)) {
                                throw new NutrientException("The ImageDocument data provider must implement Parcelable when used with the PdfActivity.");
                            }
                            arrayList.add(DocumentDescriptor.imageDocumentFromDataProvider(dataProvider));
                        }
                    }
                }
            }
        }
        bundle.putParcelableArrayList("Nutri.DocumentDescriptors", arrayList);
        bundle.putInt("Nutri.VisibleDocumentDescriptorIndex", this.visibleDocumentIndex);
        bundle.putParcelable("Nutri.Configuration", this.configuration);
        return bundle;
    }

    public abstract T getThis();

    public T passwords(String... strArr) {
        if (this.documentDescriptors != null) {
            throw new IllegalStateException("Passwords are not supported when using document descriptor as they are already part of the DocumentDescriptor class.");
        }
        if (this.imageDocumentUri != null || this.imageDocumentProvider != null) {
            throw new IllegalStateException("Passwords are not supported by image documents.");
        }
        this.passwords = strArr == null ? null : Arrays.asList(strArr);
        return (T) getThis();
    }

    public T visibleDocument(int i) {
        if (this.visibleDocumentIndex == i) {
            return (T) getThis();
        }
        ArrayList<DocumentDescriptor> arrayList = this.documentDescriptors;
        if (arrayList != null && (i < 0 || i >= arrayList.size())) {
            throw new IllegalArgumentException("Visible document index must be from [0;" + this.documentDescriptors.size() + ")");
        }
        if (this.documentDescriptors == null && i != 0) {
            throw new IllegalArgumentException("Visible document index must be 0 when using single document.");
        }
        this.visibleDocumentIndex = i;
        return (T) getThis();
    }

    public BasePdfUiBuilder(Context context, Uri uri, DataProvider dataProvider) {
        this.visibleDocumentIndex = 0;
        if (uri == null && dataProvider == null) {
            throw new IllegalArgumentException("Either image document Uri or image document provider need to be non-null.");
        }
        if (uri != null && dataProvider != null) {
            throw new IllegalArgumentException("Either image document Uri or image document provider need to be null.");
        }
        this.context = context;
        this.imageDocumentUri = uri;
        this.imageDocumentProvider = dataProvider;
        this.documentUris = null;
        this.dataProviders = null;
        this.documentDescriptors = null;
    }

    public BasePdfUiBuilder(Context context, List<DocumentDescriptor> list) {
        this.visibleDocumentIndex = 0;
        this.context = context;
        this.documentDescriptors = new ArrayList<>(list);
        this.imageDocumentUri = null;
        this.imageDocumentProvider = null;
        this.documentUris = null;
        this.dataProviders = null;
    }

    public BasePdfUiBuilder(Context context) {
        this.visibleDocumentIndex = 0;
        this.context = context;
        this.documentDescriptors = null;
        this.imageDocumentUri = null;
        this.imageDocumentProvider = null;
        this.documentUris = null;
        this.dataProviders = null;
    }
}
