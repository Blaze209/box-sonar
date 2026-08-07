package com.box.android.domain.usecases.documentscanning;

import android.content.Context;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: DocumentScanUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004H¦@¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJN\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H¦@¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u0004H¦@¢\u0006\u0002\u0010\tJ\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u001c\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u001d¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/documentscanning/DocumentScanUseCase;", "", "observeScannedPages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "Lcom/box/android/domain/models/DomainError;", "getScannedPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNewScannedPage", "context", "Landroid/content/Context;", "imageFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateScannedPage", "scannedDocumentPage", "newDocumentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "newFilterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "rotationAngle", "", "(Landroid/content/Context;Lcom/box/android/domain/models/ScannedDocumentPage;Lcom/box/android/domain/models/DocumentPosition;Lcom/box/android/domain/models/DocumentPageFilterType;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllPages", "", "deletePage", Location.TYPE_PAGE, "(Lcom/box/android/domain/models/ScannedDocumentPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DocumentScanUseCase {
    Object addNewScannedPage(Context context, File file, Continuation<? super Result<ScannedDocumentPage, ? extends DomainError>> continuation);

    Object deleteAllPages(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object deletePage(ScannedDocumentPage scannedDocumentPage, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object getScannedPages(Continuation<? super Result<? extends List<ScannedDocumentPage>, ? extends DomainError>> continuation);

    Flow<Result<List<ScannedDocumentPage>, DomainError>> observeScannedPages();

    Object updateScannedPage(Context context, ScannedDocumentPage scannedDocumentPage, DocumentPosition documentPosition, DocumentPageFilterType documentPageFilterType, Integer num, Continuation<? super Result<ScannedDocumentPage, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: DocumentScanUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object updateScannedPage$default(DocumentScanUseCase documentScanUseCase, Context context, ScannedDocumentPage scannedDocumentPage, DocumentPosition documentPosition, DocumentPageFilterType documentPageFilterType, Integer num, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateScannedPage");
        }
        if ((i & 4) != 0) {
            documentPosition = null;
        }
        if ((i & 8) != 0) {
            documentPageFilterType = null;
        }
        if ((i & 16) != 0) {
            num = null;
        }
        return documentScanUseCase.updateScannedPage(context, scannedDocumentPage, documentPosition, documentPageFilterType, num, continuation);
    }
}
