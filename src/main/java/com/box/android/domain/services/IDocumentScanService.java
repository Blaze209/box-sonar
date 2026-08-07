package com.box.android.domain.services;

import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IDocumentScanService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004H¦@¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u000b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0004H¦@¢\u0006\u0002\u0010\tJ*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IDocumentScanService;", "", "observePages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ScannedDocumentPage;", "Lcom/box/android/domain/models/DomainError;", "getPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addPageToDocument", Location.TYPE_PAGE, "(Lcom/box/android/domain/models/ScannedDocumentPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllPages", "", "deletePage", "workingDirectory", "Ljava/io/File;", "(Ljava/io/File;Lcom/box/android/domain/models/ScannedDocumentPage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IDocumentScanService {
    Object addPageToDocument(ScannedDocumentPage scannedDocumentPage, Continuation<? super Result<ScannedDocumentPage, ? extends DomainError>> continuation);

    Object deleteAllPages(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object deletePage(File file, ScannedDocumentPage scannedDocumentPage, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object getPages(Continuation<? super Result<? extends List<ScannedDocumentPage>, ? extends DomainError>> continuation);

    Flow<Result<List<ScannedDocumentPage>, DomainError>> observePages();
}
