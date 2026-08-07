package com.pspdfkit.internal;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.Nutrient;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer;
import com.pspdfkit.document.providers.AssetDataProvider;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class vd {
    public static final /* synthetic */ boolean a = true;

    public static Single<lm> a(final Context context, final List<DocumentSource> list, final x8 x8Var, final boolean z) {
        return Single.create(new SingleOnSubscribe() { // from class: com.pspdfkit.internal.vd$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) throws Throwable {
                vd.a(context, list, x8Var, z, singleEmitter);
            }
        });
    }

    public static void a(Context context, List list, x8 x8Var, boolean z, SingleEmitter singleEmitter) throws Throwable {
        lm lmVar;
        Context applicationContext = context.getApplicationContext();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(applicationContext, (DocumentSource) it.next()));
        }
        try {
            if (arrayList.size() == 1 && PdfDocumentCheckpointer.isCheckpointSupported((DocumentSource) arrayList.get(0))) {
                DocumentSource documentSource = (DocumentSource) arrayList.get(0);
                x8Var.getClass();
                List<DocumentSource> checkpointPath = PdfDocumentCheckpointer.setCheckpointPath(applicationContext, documentSource, "PSPDFDocumentCheckpoints");
                PageRenderConfiguration pageRenderConfiguration = lm.Q;
                checkpointPath.getClass();
                lmVar = new lm(lm.b.a(checkpointPath), checkpointPath, new nc(), x8Var, null, z, true);
            } else {
                lmVar = new lm(lm.b.a(arrayList), arrayList, new nc(), null, null, z, true);
            }
            singleEmitter.onSuccess(lmVar);
        } catch (Throwable th) {
            singleEmitter.tryOnError(th);
        }
    }

    public static DocumentSource a(Context context, DocumentSource documentSource) throws IOException {
        if (documentSource.isFileSource()) {
            Uri fileUri = documentSource.getFileUri();
            if (!a && fileUri == null) {
                throw new AssertionError();
            }
            if (Nutrient.isOpenableUri(context, fileUri)) {
                if (fileUri != null && fileUri.toString().startsWith("file:///android_asset/")) {
                    return new DocumentSource(new AssetDataProvider(fileUri.toString().substring(22)), documentSource.getPassword(), documentSource.getContentSignature());
                }
                String strA = wg.a(context, fileUri);
                if (strA == null) {
                    return new DocumentSource(new ContentResolverDataProvider(fileUri), documentSource.getPassword(), documentSource.getContentSignature());
                }
                if (!strA.equals(fileUri.getPath())) {
                    PdfLog.d("Nutri.DocumentLoader", "Uri %s resolved to %s, opening...", fileUri.toString(), strA);
                    return new DocumentSource(Uri.fromFile(new File(strA)), documentSource.getPassword(), documentSource.getContentSignature());
                }
            } else {
                throw new IOException("Uri " + fileUri + "is not local file or content provider. Only local files are supported as documents at this moment.");
            }
        }
        return documentSource;
    }
}
