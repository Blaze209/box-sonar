package com.box.android.domain.usecases.documentscanning;

import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.services.IDocumentScanPageProcessor;
import com.box.android.domain.services.IDocumentScanService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: DocumentScanUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\tH\u0016J \u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\nH\u0096@¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015JH\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0002J\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\nH\u0096@¢\u0006\u0002\u0010\u000fJ\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\n2\u0006\u0010!\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/domain/usecases/documentscanning/DocumentScanInteractor;", "Lcom/box/android/domain/usecases/documentscanning/DocumentScanUseCase;", "documentScanService", "Lcom/box/android/domain/services/IDocumentScanService;", "scanPageProcessor", "Lcom/box/android/domain/services/IDocumentScanPageProcessor;", "<init>", "(Lcom/box/android/domain/services/IDocumentScanService;Lcom/box/android/domain/services/IDocumentScanPageProcessor;)V", "observeScannedPages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "Lcom/box/android/domain/models/DomainError;", "getScannedPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNewScannedPage", "context", "Landroid/content/Context;", "imageFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateScannedPage", "scannedDocumentPage", "newDocumentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "newFilterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "rotationAngle", "", "(Landroid/content/Context;Lcom/box/android/domain/models/ScannedDocumentPage;Lcom/box/android/domain/models/DocumentPosition;Lcom/box/android/domain/models/DocumentPageFilterType;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExistingEnhancedImage", "", Location.TYPE_PAGE, "deleteAllPages", "deletePage", "(Lcom/box/android/domain/models/ScannedDocumentPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScanInteractor implements DocumentScanUseCase {
    private final IDocumentScanService documentScanService;
    private final IDocumentScanPageProcessor scanPageProcessor;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.documentscanning.DocumentScanInteractor$addNewScannedPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.documentscanning.DocumentScanInteractor", f = "DocumentScanUseCase.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {42, 60}, m = "addNewScannedPage", n = {"context", "imageFile", "context", "imageFile", "$this$flatMap$iv", "document", "$i$f$flatMap", "$i$a$-flatMap-DocumentScanInteractor$addNewScannedPage$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanInteractor.this.addNewScannedPage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.documentscanning.DocumentScanInteractor$updateScannedPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DocumentScanUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.documentscanning.DocumentScanInteractor", f = "DocumentScanUseCase.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {75, 78, 93}, m = "updateScannedPage", n = {"context", "scannedDocumentPage", "newDocumentPosition", "newFilterType", "rotationAngle", "updatedPage", "context", "scannedDocumentPage", "newDocumentPosition", "newFilterType", "rotationAngle", "context", "scannedDocumentPage", "newDocumentPosition", "newFilterType", "rotationAngle", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-DocumentScanInteractor$updateScannedPage$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C16321 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C16321(Continuation<? super C16321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanInteractor.this.updateScannedPage(null, null, null, null, null, this);
        }
    }

    @Inject
    public DocumentScanInteractor(IDocumentScanService documentScanService, IDocumentScanPageProcessor scanPageProcessor) {
        Intrinsics.checkNotNullParameter(documentScanService, "documentScanService");
        Intrinsics.checkNotNullParameter(scanPageProcessor, "scanPageProcessor");
        this.documentScanService = documentScanService;
        this.scanPageProcessor = scanPageProcessor;
    }

    @Override // com.box.android.domain.usecases.documentscanning.DocumentScanUseCase
    public Flow<Result<List<ScannedDocumentPage>, DomainError>> observeScannedPages() {
        return this.documentScanService.observePages();
    }

    @Override // com.box.android.domain.usecases.documentscanning.DocumentScanUseCase
    public Object getScannedPages(Continuation<? super Result<? extends List<ScannedDocumentPage>, ? extends DomainError>> continuation) {
        return this.documentScanService.getPages(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f8, code lost:
    
        if (r1 == r2) goto L29;
     */
    @Override // com.box.android.domain.usecases.documentscanning.DocumentScanUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object addNewScannedPage(android.content.Context r24, java.io.File r25, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.ScannedDocumentPage, ? extends com.box.android.domain.models.DomainError>> r26) {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.documentscanning.DocumentScanInteractor.addNewScannedPage(android.content.Context, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01e5, code lost:
    
        if (r1 == r15) goto L53;
     */
    @Override // com.box.android.domain.usecases.documentscanning.DocumentScanUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateScannedPage(android.content.Context r29, com.box.android.domain.models.ScannedDocumentPage r30, com.box.android.domain.models.DocumentPosition r31, com.box.android.domain.models.DocumentPageFilterType r32, java.lang.Integer r33, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.ScannedDocumentPage, ? extends com.box.android.domain.models.DomainError>> r34) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.documentscanning.DocumentScanInteractor.updateScannedPage(android.content.Context, com.box.android.domain.models.ScannedDocumentPage, com.box.android.domain.models.DocumentPosition, com.box.android.domain.models.DocumentPageFilterType, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void deleteExistingEnhancedImage(ScannedDocumentPage page) {
        if (new File(page.getEnhancedImagePath()).delete()) {
            return;
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to delete existing enhanced image file " + page.getEnhancedImagePath());
    }

    @Override // com.box.android.domain.usecases.documentscanning.DocumentScanUseCase
    public Object deleteAllPages(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        FilesKt.deleteRecursively(this.scanPageProcessor.getWorkingDirectory());
        return this.documentScanService.deleteAllPages(continuation);
    }

    @Override // com.box.android.domain.usecases.documentscanning.DocumentScanUseCase
    public Object deletePage(ScannedDocumentPage scannedDocumentPage, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.documentScanService.deletePage(this.scanPageProcessor.getWorkingDirectory(), scannedDocumentPage, continuation);
    }
}
