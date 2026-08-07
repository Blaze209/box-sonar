package com.pspdfkit.document.sharing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.b30;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.ww;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSharingManager {
    private static PdfProcessorTask buildProcessorTaskFromSharingOptions(PdfDocument pdfDocument, SharingOptions sharingOptions) {
        if (sharingOptions == null || !ar.b().a(NativeLicenseFeatures.PDF_CREATION)) {
            return null;
        }
        return sharingOptions.getProcessorTask(pdfDocument);
    }

    public static DocumentSharingController shareBitmap(Bitmap bitmap, final DocumentSharingController documentSharingController) {
        uw.a(bitmap, "bitmap", null);
        uw.a(documentSharingController, "controller", null);
        if (documentSharingController.getContext() == null) {
            throw new NullPointerException("DocumentSharingController must have non-null context.");
        }
        Single<Uri> singlePrepareBitmapForSharing = DocumentSharingProviderProcessor.prepareBitmapForSharing(documentSharingController.getContext(), bitmap);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        documentSharingController.onSharingStarted((b30) singlePrepareBitmapForSharing.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new b30<Uri>() { // from class: com.pspdfkit.document.sharing.DocumentSharingManager.3
            @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                documentSharingController.onSharingError();
            }

            @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(Uri uri) {
                documentSharingController.onSharingFinished(uri);
            }
        }));
        return documentSharingController;
    }

    public static DocumentSharingController shareDocument(final DocumentSharingController documentSharingController, PdfDocument pdfDocument, SharingOptions sharingOptions) {
        uw.a(documentSharingController, "controller", null);
        if (documentSharingController.getContext() == null) {
            throw new NullPointerException("DocumentSharingController must have non-null context.");
        }
        uw.a(pdfDocument, "document", null);
        PdfProcessorTask pdfProcessorTaskBuildProcessorTaskFromSharingOptions = buildProcessorTaskFromSharingOptions(pdfDocument, sharingOptions);
        String strA = (sharingOptions == null || TextUtils.isEmpty(sharingOptions.getDocumentName())) ? ww.a(documentSharingController.getContext(), pdfDocument) : sharingOptions.getDocumentName();
        Single<Uri> singlePrepareDocumentForSharing = pdfProcessorTaskBuildProcessorTaskFromSharingOptions == null ? DocumentSharingProviderProcessor.prepareDocumentForSharing(documentSharingController.getContext(), pdfDocument, strA) : DocumentSharingProviderProcessor.prepareDocumentForSharing(documentSharingController.getContext(), pdfDocument, pdfProcessorTaskBuildProcessorTaskFromSharingOptions, strA, new DocumentSharingProviderProcessor.PdfProcessorProgressListener() { // from class: com.pspdfkit.document.sharing.DocumentSharingManager$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.document.sharing.DocumentSharingProviderProcessor.PdfProcessorProgressListener
            public final void onProcessorProgress(PdfProcessor.ProcessorProgress processorProgress) {
                h60.a(new Runnable() { // from class: com.pspdfkit.document.sharing.DocumentSharingManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        documentSharingController.onSharingProgress(processorProgress);
                    }
                });
            }
        });
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        documentSharingController.onSharingStarted((Disposable) singlePrepareDocumentForSharing.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<Uri>() { // from class: com.pspdfkit.document.sharing.DocumentSharingManager.1
            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                documentSharingController.onSharingError();
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(Uri uri) {
                documentSharingController.onSharingFinished(uri);
            }
        }));
        return documentSharingController;
    }

    public static DocumentSharingController shareEmbeddedFile(EmbeddedFile embeddedFile, final DocumentSharingController documentSharingController) {
        uw.a(embeddedFile, "embeddedFile", null);
        uw.a(documentSharingController, "controller", null);
        if (documentSharingController.getContext() == null) {
            throw new NullPointerException("DocumentSharingController must have non-null context.");
        }
        Single<Uri> singlePrepareEmbeddedFileForSharing = DocumentSharingProviderProcessor.prepareEmbeddedFileForSharing(documentSharingController.getContext(), embeddedFile);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        documentSharingController.onSharingStarted((b30) singlePrepareEmbeddedFileForSharing.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new b30<Uri>() { // from class: com.pspdfkit.document.sharing.DocumentSharingManager.2
            @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                documentSharingController.onSharingError();
            }

            @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(Uri uri) {
                documentSharingController.onSharingFinished(uri);
            }
        }));
        return documentSharingController;
    }

    public static DocumentSharingController shareSoundAnnotation(SoundAnnotation soundAnnotation, final DocumentSharingController documentSharingController) {
        uw.a(soundAnnotation, "soundAnnotation", null);
        uw.a(documentSharingController, "controller", null);
        if (documentSharingController.getContext() == null) {
            throw new NullPointerException("DocumentSharingController must have non-null context.");
        }
        Single<Uri> singlePrepareSoundAnnotationForSharing = DocumentSharingProviderProcessor.prepareSoundAnnotationForSharing(documentSharingController.getContext(), soundAnnotation);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        documentSharingController.onSharingStarted((b30) singlePrepareSoundAnnotationForSharing.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new b30<Uri>() { // from class: com.pspdfkit.document.sharing.DocumentSharingManager.4
            @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                documentSharingController.onSharingError();
            }

            @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(Uri uri) {
                documentSharingController.onSharingFinished(uri);
            }
        }));
        return documentSharingController;
    }

    public static void shareText(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        context.startActivity(Intent.createChooser(DocumentSharingIntentHelper.getShareTextIntent(str), null));
    }

    public static DocumentSharingController shareEmbeddedFile(Context context, EmbeddedFile embeddedFile, ShareAction shareAction) {
        return shareEmbeddedFile(embeddedFile, new DefaultDocumentSharingController(context, shareAction));
    }

    public static DocumentSharingController shareBitmap(Context context, Bitmap bitmap, ShareAction shareAction) {
        return shareBitmap(bitmap, new DefaultDocumentSharingController(context, shareAction));
    }

    public static DocumentSharingController shareDocument(Context context, PdfDocument pdfDocument, ShareAction shareAction) {
        return shareDocument(new DefaultDocumentSharingController(context, shareAction), pdfDocument, (SharingOptions) null);
    }

    public static DocumentSharingController shareDocument(Context context, PdfDocument pdfDocument, ShareAction shareAction, SharingOptions sharingOptions) {
        return shareDocument(new DefaultDocumentSharingController(context, shareAction), pdfDocument, sharingOptions);
    }

    public static DocumentSharingController shareDocument(Context context, PdfDocument pdfDocument, ShareTarget shareTarget) {
        return shareDocument(new DefaultDocumentSharingController(context, shareTarget), pdfDocument, (SharingOptions) null);
    }

    public static DocumentSharingController shareDocument(Context context, PdfDocument pdfDocument, ShareTarget shareTarget, SharingOptions sharingOptions) {
        return shareDocument(new DefaultDocumentSharingController(context, shareTarget), pdfDocument, sharingOptions);
    }

    public static DocumentSharingController shareDocument(DocumentSharingController documentSharingController, PdfDocument pdfDocument) {
        return shareDocument(documentSharingController, pdfDocument, (SharingOptions) null);
    }
}
