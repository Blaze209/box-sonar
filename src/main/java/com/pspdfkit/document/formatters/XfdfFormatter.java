package com.pspdfkit.document.formatters;

import android.net.Uri;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.internal.jni.NativeXFDFFormatter;
import com.pspdfkit.internal.jni.NativeXFDFImportResult;
import com.pspdfkit.internal.jni.NativeXFDFOptions;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.pt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J>\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J>\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u0018\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/document/formatters/XfdfFormatter;", "", "<init>", "()V", "parseXfdfAsync", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/pspdfkit/annotations/Annotation;", "document", "Lcom/pspdfkit/document/PdfDocument;", "dataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "ignorePageRotation", "", "parseXfdf", "writeXfdfAsync", "Lio/reactivex/rxjava3/core/Completable;", "annotations", "formFields", "Lcom/pspdfkit/forms/FormField;", "outputStream", "Ljava/io/OutputStream;", "writeXfdf", "", "requireAnnotationsAreAttached", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class XfdfFormatter {
    public static final int $stable = 0;
    public static final XfdfFormatter INSTANCE = new XfdfFormatter();

    private XfdfFormatter() {
    }

    @JvmStatic
    public static final List<Annotation> parseXfdf(PdfDocument pdfDocument, DataProvider dataProvider) {
        pdfDocument.getClass();
        dataProvider.getClass();
        return parseXfdf$default(pdfDocument, dataProvider, false, 4, null);
    }

    public static /* synthetic */ List parseXfdf$default(PdfDocument pdfDocument, DataProvider dataProvider, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return parseXfdf(pdfDocument, dataProvider, z);
    }

    @JvmStatic
    public static final Single<List<Annotation>> parseXfdfAsync(PdfDocument pdfDocument, DataProvider dataProvider) {
        pdfDocument.getClass();
        dataProvider.getClass();
        return parseXfdfAsync$default(pdfDocument, dataProvider, false, 4, null);
    }

    public static /* synthetic */ Single parseXfdfAsync$default(PdfDocument pdfDocument, DataProvider dataProvider, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return parseXfdfAsync(pdfDocument, dataProvider, z);
    }

    private final void requireAnnotationsAreAttached(List<? extends Annotation> annotations) {
        Iterator<? extends Annotation> it = annotations.iterator();
        while (it.hasNext()) {
            if (it.next().getInternal().getNativeAnnotation() == null) {
                throw new IllegalArgumentException("The annotations need to be part of the document.");
            }
        }
    }

    @JvmStatic
    public static final void writeXfdf(PdfDocument pdfDocument, List<? extends Annotation> list, List<? extends FormField> list2, OutputStream outputStream) throws IOException {
        pdfDocument.getClass();
        list.getClass();
        list2.getClass();
        outputStream.getClass();
        writeXfdf$default(pdfDocument, list, list2, outputStream, false, 16, null);
    }

    public static /* synthetic */ void writeXfdf$default(PdfDocument pdfDocument, List list, List list2, OutputStream outputStream, boolean z, int i, Object obj) throws IOException {
        if ((i & 16) != 0) {
            z = false;
        }
        writeXfdf(pdfDocument, list, list2, outputStream, z);
    }

    @JvmStatic
    public static final Completable writeXfdfAsync(PdfDocument pdfDocument, List<? extends Annotation> list, List<? extends FormField> list2, OutputStream outputStream) {
        pdfDocument.getClass();
        list.getClass();
        list2.getClass();
        outputStream.getClass();
        return writeXfdfAsync$default(pdfDocument, list, list2, outputStream, false, 16, null);
    }

    public static /* synthetic */ Completable writeXfdfAsync$default(PdfDocument pdfDocument, List list, List list2, OutputStream outputStream, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return writeXfdfAsync(pdfDocument, list, list2, outputStream, z);
    }

    @JvmStatic
    public static final List<Annotation> parseXfdf(PdfDocument document, DataProvider dataProvider, boolean ignorePageRotation) {
        document.getClass();
        dataProvider.getClass();
        lm lmVar = (lm) document;
        NativeDocument nativeDocument = lmVar.y;
        DataProviderShim dataProviderShim = new DataProviderShim(dataProvider);
        NativeXFDFOptions nativeXFDFOptions = new NativeXFDFOptions(ignorePageRotation, true);
        int i = 0;
        NativeXFDFImportResult xfdf = NativeXFDFFormatter.parseXfdf(nativeDocument, 0, dataProviderShim, nativeXFDFOptions);
        xfdf.getClass();
        if (!xfdf.getSuccess()) {
            throw new XfdfFormatterException(xfdf.getErrorMessage());
        }
        ArrayList<NativeAnnotation> importedAnnotations = xfdf.getImportedAnnotations();
        importedAnnotations.getClass();
        ArrayList arrayList = new ArrayList(importedAnnotations.size());
        int size = importedAnnotations.size();
        while (i < size) {
            NativeAnnotation nativeAnnotation = importedAnnotations.get(i);
            i++;
            NativeAnnotation nativeAnnotation2 = nativeAnnotation;
            nativeAnnotation2.setIsSavedToDocument(true);
            Annotation annotation = (Annotation) BuildersKt.runBlocking(Dispatchers.getIO(), new XfdfFormatter$parseXfdf$annotation$1(lmVar, nativeAnnotation2, null));
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final Single<List<Annotation>> parseXfdfAsync(final PdfDocument document, final DataProvider dataProvider, final boolean ignorePageRotation) {
        document.getClass();
        dataProvider.getClass();
        Single<List<Annotation>> singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.document.formatters.XfdfFormatter$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return XfdfFormatter.parseXfdf(document, dataProvider, ignorePageRotation);
            }
        });
        singleFromCallable.getClass();
        return singleFromCallable;
    }

    @JvmStatic
    public static final void writeXfdf(PdfDocument document, List<? extends Annotation> annotations, List<? extends FormField> formFields, OutputStream outputStream, boolean ignorePageRotation) throws IOException {
        document.getClass();
        annotations.getClass();
        formFields.getClass();
        outputStream.getClass();
        INSTANCE.requireAnnotationsAreAttached(annotations);
        ArrayList arrayList = new ArrayList(annotations.size());
        Iterator<? extends Annotation> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getInternal().getNativeAnnotation());
        }
        ArrayList arrayList2 = new ArrayList(formFields.size());
        Iterator<? extends FormField> it2 = formFields.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getInternal().getNativeFormField());
        }
        Uri fileUri = document.getDocumentSource().getFileUri();
        NativeResult nativeResultWriteXfdf = NativeXFDFFormatter.writeXfdf(((lm) document).y, 0, arrayList, arrayList2, fileUri != null ? fileUri.getPath() : null, new pt(outputStream), new NativeXFDFOptions(ignorePageRotation, true));
        nativeResultWriteXfdf.getClass();
        if (nativeResultWriteXfdf.getHasError()) {
            throw new IOException("Error on writing XFDF: " + nativeResultWriteXfdf.getErrorString());
        }
    }

    @JvmStatic
    public static final Completable writeXfdfAsync(final PdfDocument document, final List<? extends Annotation> annotations, final List<? extends FormField> formFields, final OutputStream outputStream, final boolean ignorePageRotation) {
        document.getClass();
        annotations.getClass();
        formFields.getClass();
        outputStream.getClass();
        INSTANCE.requireAnnotationsAreAttached(annotations);
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.document.formatters.XfdfFormatter$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws IOException {
                XfdfFormatter.writeXfdf(document, annotations, formFields, outputStream, ignorePageRotation);
            }
        });
        completableFromAction.getClass();
        return completableFromAction;
    }
}
