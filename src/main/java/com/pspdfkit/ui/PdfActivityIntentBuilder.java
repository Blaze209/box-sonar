package com.pspdfkit.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.uw;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfActivityIntentBuilder extends BasePdfUiBuilder<PdfActivityIntentBuilder> {
    private Class<? extends PdfActivity> activityClass;

    private PdfActivityIntentBuilder(Context context, List<Uri> list, List<DataProvider> list2) {
        super(context, list, list2);
    }

    public static PdfActivityIntentBuilder emptyActivity(Context context) {
        uw.a(context, "context", null);
        return new PdfActivityIntentBuilder(context);
    }

    public static PdfActivityIntentBuilder fromDataProvider(Context context, DataProvider... dataProviderArr) {
        uw.a(context, "context", null);
        uw.a(dataProviderArr, "Can't create document with null or empty document data provider(s).");
        return new PdfActivityIntentBuilder(context, (List<Uri>) null, (List<DataProvider>) Arrays.asList(dataProviderArr));
    }

    public static PdfActivityIntentBuilder fromDocumentDescriptor(Context context, DocumentDescriptor... documentDescriptorArr) {
        uw.a(context, "context", null);
        uw.a(documentDescriptorArr, "Can't create activity with no documents loaded.");
        return new PdfActivityIntentBuilder(context, Arrays.asList(documentDescriptorArr));
    }

    public static PdfActivityIntentBuilder fromImageProvider(Context context, DataProvider dataProvider) {
        uw.a(context, "context", null);
        uw.a(dataProvider, "dataProvider", "Can't create document with null image document provider.");
        return new PdfActivityIntentBuilder(context, (Uri) null, dataProvider);
    }

    public static PdfActivityIntentBuilder fromImageUri(Context context, Uri uri) {
        uw.a(context, "context", null);
        uw.a(uri, "uri", "Can't create image document with null image document Uri.");
        return new PdfActivityIntentBuilder(context, uri, (DataProvider) null);
    }

    public static PdfActivityIntentBuilder fromUri(Context context, Uri... uriArr) {
        uw.a(context, "context", null);
        uw.a(uriArr, "Can't create document with null or empty document URI(s).");
        return new PdfActivityIntentBuilder(context, (List<Uri>) Arrays.asList(uriArr), (List<DataProvider>) null);
    }

    public PdfActivityIntentBuilder activityClass(Class<? extends PdfActivity> cls) {
        if (cls != null && !PdfActivity.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Passed activity class must extend PdfActivity!");
        }
        this.activityClass = cls;
        return this;
    }

    public Intent build() {
        if (this.activityClass == null) {
            this.activityClass = PdfActivity.class;
        }
        if (this.configuration == null) {
            this.configuration = new PdfActivityConfiguration.Builder(this.context).build();
        }
        Intent intent = new Intent(this.context, this.activityClass);
        if (this.documentDescriptors == null) {
            List<Uri> list = this.documentUris;
            if (list == null) {
                List<DataProvider> list2 = this.dataProviders;
                if (list2 != null) {
                    Iterator<DataProvider> it = list2.iterator();
                    while (it.hasNext()) {
                        if (!(it.next() instanceof Parcelable)) {
                            throw new NutrientException("The DataProvider must implement Parcelable when used with the PdfActivity.");
                        }
                    }
                } else {
                    Uri uri = this.imageDocumentUri;
                    if (uri != null) {
                        intent.setData(uri);
                    } else {
                        DataProvider dataProvider = this.imageDocumentProvider;
                        if (dataProvider != null && !(dataProvider instanceof Parcelable)) {
                            throw new NutrientException("The ImageDocument data provider must implement Parcelable when used with the PdfActivity.");
                        }
                    }
                }
            } else if (!list.isEmpty()) {
                intent.setData(this.documentUris.get(0));
            }
        }
        intent.putExtra("Nutri.InternalExtras", createExtras());
        return intent;
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfActivityIntentBuilder getThis() {
        return this;
    }

    private PdfActivityIntentBuilder(Context context, Uri uri, DataProvider dataProvider) {
        super(context, uri, dataProvider);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfActivityIntentBuilder configuration(PdfActivityConfiguration pdfActivityConfiguration) {
        return (PdfActivityIntentBuilder) super.configuration(pdfActivityConfiguration);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfActivityIntentBuilder contentSignatures(String... strArr) {
        return (PdfActivityIntentBuilder) super.contentSignatures(strArr);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfActivityIntentBuilder passwords(String... strArr) {
        return (PdfActivityIntentBuilder) super.passwords(strArr);
    }

    @Override // com.pspdfkit.ui.BasePdfUiBuilder
    public PdfActivityIntentBuilder visibleDocument(int i) {
        return (PdfActivityIntentBuilder) super.visibleDocument(i);
    }

    private PdfActivityIntentBuilder(Context context, List<DocumentDescriptor> list) {
        super(context, list);
    }

    private PdfActivityIntentBuilder(Context context) {
        super(context);
    }

    public PdfActivityIntentBuilder activityClass(KClass<? extends PdfActivity> kClass) {
        return activityClass(kClass != null ? JvmClassMappingKt.getJavaClass((KClass) kClass) : null);
    }
}
