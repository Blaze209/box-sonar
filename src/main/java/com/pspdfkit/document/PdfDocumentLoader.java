package com.pspdfkit.document;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.Nutrient;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.vd;
import com.pspdfkit.internal.x8;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDocumentLoader {
    private x8 checkpointerConfiguration;
    private final Context context;
    private final List<DocumentSource> documentSources;
    private boolean isMultithreadedRenderingEnabled = true;

    private PdfDocumentLoader(Context context, List<DocumentSource> list) {
        uw.a(context, "context", null);
        uw.a(list, "documentSources", null);
        this.context = context;
        this.documentSources = list;
    }

    public static PdfDocumentLoader fromDocumentSource(Context context, DocumentSource documentSource) {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(documentSource, "documentSource", null);
        return new PdfDocumentLoader(context, Collections.singletonList(documentSource));
    }

    private static PdfDocumentLoader fromDocumentSources(Context context, List<DocumentSource> list) {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(list, "documentSources", null);
        uw.a(list, "At least one document source is required to open a PDF!");
        return new PdfDocumentLoader(context, list);
    }

    static /* synthetic */ PdfDocument lambda$openDocumentAsync$0(lm lmVar) throws Throwable {
        return lmVar;
    }

    public static PdfDocument openDocument(Context context, DocumentSource documentSource) throws IOException {
        uw.a(context, "context", null);
        uw.a(documentSource, "source", null);
        return fromDocumentSource(context, documentSource).openDocument();
    }

    public static Single<PdfDocument> openDocumentAsync(Context context, Uri uri) throws NutrientNotInitializedException {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(uri, "documentUri", null);
        return fromDocumentSource(context, new DocumentSource(uri)).openDocumentAsync();
    }

    public static PdfDocument openDocuments(Context context, List<DocumentSource> list) throws IOException {
        return fromDocumentSources(context, list).openDocument();
    }

    public static Single<PdfDocument> openDocumentsAsync(Context context, List<DocumentSource> list) {
        return fromDocumentSources(context, list).openDocumentAsync();
    }

    private PdfDocumentLoader setMultithreadedRenderingEnabled(boolean z) {
        this.isMultithreadedRenderingEnabled = z;
        return this;
    }

    public PdfDocumentLoader setCheckpointerConfiguration(x8 x8Var) {
        this.checkpointerConfiguration = x8Var;
        return this;
    }

    public static PdfDocument openDocuments(Context context, List<DocumentSource> list, boolean z) throws IOException {
        return fromDocumentSources(context, list).setMultithreadedRenderingEnabled(z).openDocument();
    }

    public static Single<PdfDocument> openDocumentsAsync(Context context, List<DocumentSource> list, boolean z) {
        return fromDocumentSources(context, list).setMultithreadedRenderingEnabled(z).openDocumentAsync();
    }

    public static PdfDocument openDocument(Context context, Uri uri) throws NutrientNotInitializedException, IOException {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(uri, "documentUri", null);
        return fromDocumentSource(context, new DocumentSource(uri)).openDocument();
    }

    public static Single<PdfDocument> openDocumentAsync(Context context, Uri uri, String str) throws NutrientNotInitializedException {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(uri, "documentUri", null);
        return fromDocumentSource(context, new DocumentSource(uri, str)).openDocumentAsync();
    }

    public static PdfDocument openDocument(Context context, Uri uri, String str) throws NutrientNotInitializedException, IOException {
        Nutrient.ensureInitialized();
        uw.a(context, "context", null);
        uw.a(uri, "documentUri", null);
        return fromDocumentSource(context, new DocumentSource(uri, str)).openDocument();
    }

    public static Single<PdfDocument> openDocumentAsync(Context context, DocumentSource documentSource) throws NutrientNotInitializedException {
        return fromDocumentSource(context, documentSource).openDocumentAsync();
    }

    public static Single<PdfDocument> openDocumentAsync(Context context, DocumentSource documentSource, boolean z) throws NutrientNotInitializedException {
        return fromDocumentSource(context, documentSource).setMultithreadedRenderingEnabled(z).openDocumentAsync();
    }

    public static PdfDocument openDocument(Context context, DocumentSource documentSource, boolean z) throws IOException {
        return fromDocumentSource(context, documentSource).setMultithreadedRenderingEnabled(z).openDocument();
    }

    private Single<PdfDocument> openDocumentAsync() {
        Context context = this.context;
        List<DocumentSource> list = this.documentSources;
        x8 x8Var = this.checkpointerConfiguration;
        if (x8Var == null) {
            x8Var = new x8();
        }
        return vd.a(context, list, x8Var, this.isMultithreadedRenderingEnabled).map(new Function() { // from class: com.pspdfkit.document.PdfDocumentLoader$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return PdfDocumentLoader.lambda$openDocumentAsync$0((lm) obj);
            }
        });
    }

    public PdfDocument openDocument() throws IOException {
        try {
            return openDocumentAsync().blockingGet();
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }
}
