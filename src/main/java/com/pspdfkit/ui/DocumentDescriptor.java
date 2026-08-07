package com.pspdfkit.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.R;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.ue;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.vu;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.zj;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentDescriptor implements Parcelable {
    public static final Parcelable.Creator<DocumentDescriptor> CREATOR = new Parcelable.Creator<DocumentDescriptor>() { // from class: com.pspdfkit.ui.DocumentDescriptor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentDescriptor createFromParcel(Parcel parcel) {
            return new DocumentDescriptor(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentDescriptor[] newArray(int i) {
            return new DocumentDescriptor[i];
        }
    };
    private String customTitle;
    private PdfDocument document;
    private final List<DocumentSource> documentSources;
    private final boolean isImageDocument;
    private String resolvedDocumentTitle;
    private Bundle state;

    private DocumentDescriptor(List<DocumentSource> list, boolean z) {
        if (z && list.size() != 1) {
            throw new IllegalArgumentException("Descriptor for image document must have exactly 1 document source.");
        }
        Iterator<DocumentSource> it = list.iterator();
        while (it.hasNext()) {
            if (!vu.a(it.next())) {
                throw new IllegalArgumentException("The DataProvider must implement Parcelable when used in DocumentDescriptor.");
            }
        }
        this.documentSources = list;
        this.isImageDocument = z;
    }

    public static DocumentDescriptor fromDataProvider(DataProvider dataProvider) {
        uw.a(dataProvider, "dataProvider", null);
        return fromDocumentSource(new DocumentSource(dataProvider));
    }

    public static DocumentDescriptor fromDataProviders(List<DataProvider> list, List<String> list2, List<String> list3) {
        uw.a(list, "dataProviders", null);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("dataProviders may not be empty");
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            arrayList.add(new DocumentSource(list.get(i), (list2 != null && list2.size() > i) ? list2.get(i) : null, (list3 != null && list3.size() > i) ? list3.get(i) : null));
            i++;
        }
        return fromDocumentSources(arrayList);
    }

    public static DocumentDescriptor fromDocument(PdfDocument pdfDocument) {
        uw.a(pdfDocument, "document", null);
        return pdfDocument instanceof zj.a ? new DocumentDescriptor(pdfDocument, Collections.singletonList(((zj.a) pdfDocument).R.a), true) : new DocumentDescriptor(pdfDocument, pdfDocument.getDocumentSources(), false);
    }

    public static DocumentDescriptor fromDocumentSource(DocumentSource documentSource) {
        uw.a(documentSource, "documentSource", null);
        return new DocumentDescriptor((List<DocumentSource>) Collections.singletonList(documentSource));
    }

    public static DocumentDescriptor fromDocumentSources(List<DocumentSource> list) {
        uw.a(list, "documentSources", null);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("documentSources may not be empty");
        }
        return new DocumentDescriptor(list);
    }

    public static DocumentDescriptor fromUri(Uri uri) {
        uw.a(uri, "documentUri", null);
        return fromUri(uri, null);
    }

    public static DocumentDescriptor fromUris(List<Uri> list, List<String> list2, List<String> list3) {
        uw.a(list, "documentUris", null);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("documentUris may not be empty");
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            arrayList.add(new DocumentSource(list.get(i), (list2 != null && list2.size() > i) ? list2.get(i) : null, (list3 != null && list3.size() > i) ? list3.get(i) : null));
            i++;
        }
        return fromDocumentSources(arrayList);
    }

    public static DocumentDescriptor imageDocumentFromDataProvider(DataProvider dataProvider) {
        uw.a(dataProvider, "dataProvider", null);
        return imageDocumentFromDocumentSource(new DocumentSource(dataProvider));
    }

    public static DocumentDescriptor imageDocumentFromDocumentSource(DocumentSource documentSource) {
        uw.a(documentSource, "documentSource", null);
        return new DocumentDescriptor(Collections.singletonList(documentSource), true);
    }

    public static DocumentDescriptor imageDocumentFromUri(Uri uri) {
        uw.a(uri, "uri", null);
        return imageDocumentFromDocumentSource(new DocumentSource(uri));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCustomTitle() {
        return this.customTitle;
    }

    public PdfDocument getDocument() {
        return this.document;
    }

    public DocumentSource getDocumentSource() {
        return this.documentSources.get(0);
    }

    public List<DocumentSource> getDocumentSources() {
        return this.documentSources;
    }

    public Bundle getState() {
        return this.state;
    }

    public String getTitle(Context context) {
        String strA;
        String str = this.customTitle;
        if (str != null) {
            return str;
        }
        PdfDocument pdfDocument = this.document;
        if (pdfDocument != null) {
            strA = ww.a(context, pdfDocument);
            this.resolvedDocumentTitle = strA;
        } else {
            strA = this.resolvedDocumentTitle;
            if (strA == null) {
                strA = ue.a(this.documentSources.get(0));
            }
        }
        return strA != null ? strA : no.a(context, R.string.pspdf__activity_title_unnamed_document, null);
    }

    public String getUid() {
        return this.documentSources.get(0).getUid();
    }

    public boolean isImageDocument() {
        return this.isImageDocument;
    }

    public void setDocument(PdfDocument pdfDocument) {
        this.document = pdfDocument;
    }

    public void setState(Bundle bundle) {
        this.state = bundle;
    }

    public void setTitle(String str) {
        this.customTitle = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<DocumentSource> list = this.documentSources;
        vu[] vuVarArr = new vu[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            vuVarArr[i2] = new vu(list.get(i2));
        }
        parcel.writeParcelableArray(vuVarArr, i);
        parcel.writeBundle(this.state);
        parcel.writeInt(this.isImageDocument ? 1 : 0);
        parcel.writeString(this.customTitle);
        parcel.writeString(this.resolvedDocumentTitle);
    }

    public static DocumentDescriptor fromDataProvider(DataProvider dataProvider, String str) {
        uw.a(dataProvider, "dataProvider", null);
        return fromDocumentSource(new DocumentSource(dataProvider, str));
    }

    public static DocumentDescriptor fromUri(Uri uri, String str) {
        uw.a(uri, "documentUri", null);
        return fromDocumentSources(Collections.singletonList(new DocumentSource(uri, str)));
    }

    public static DocumentDescriptor fromDataProvider(DataProvider dataProvider, String str, String str2) {
        uw.a(dataProvider, "dataProvider", null);
        return fromDocumentSource(new DocumentSource(dataProvider, str, str2));
    }

    private DocumentDescriptor(List<DocumentSource> list) {
        this(new ArrayList(list), false);
    }

    private DocumentDescriptor(PdfDocument pdfDocument, List<DocumentSource> list, boolean z) {
        this(list, z);
        this.document = pdfDocument;
    }

    public DocumentDescriptor(Parcel parcel) {
        List<DocumentSource> list;
        Parcelable[] parcelableArray = parcel.readParcelableArray(vu.class.getClassLoader());
        if (parcelableArray == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                vu vuVar = (vu) parcelable;
                if (vuVar != null) {
                    arrayList.add(vuVar.a);
                } else {
                    PdfLog.e("vu", "Failed to unparcel DocumentSource", new Object[0]);
                }
            }
            list = arrayList;
        }
        this.documentSources = list;
        this.state = parcel.readBundle(getClass().getClassLoader());
        this.isImageDocument = parcel.readInt() == 1;
        this.customTitle = parcel.readString();
        this.resolvedDocumentTitle = parcel.readString();
    }
}
