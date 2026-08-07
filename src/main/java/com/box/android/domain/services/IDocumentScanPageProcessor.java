package com.box.android.domain.services;

import android.content.Context;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ScannedDocumentPage;
import com.box.android.domain.models.ScannedPageProcessingResult;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IDocumentScanPageProcessor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J*\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u0011JD\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH¦@¢\u0006\u0002\u0010\u001dJH\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010$JH\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010&¨\u0006'À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IDocumentScanPageProcessor;", "", "getWorkingDirectory", "Ljava/io/File;", "prepareFile", "rotateImage", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "imagePath", "", "degrees", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotatePage", "Lcom/box/android/domain/models/ScannedDocumentPage;", Location.TYPE_PAGE, "(Lcom/box/android/domain/models/ScannedDocumentPage;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processImage", "Lcom/box/android/domain/models/ScannedPageProcessingResult;", "context", "Landroid/content/Context;", "originalImageFile", "distortionCorrection", "", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "documentPosition", "Lcom/box/android/domain/models/DocumentPosition;", "(Landroid/content/Context;Ljava/io/File;ZLcom/box/android/domain/models/DocumentPageFilterType;Lcom/box/android/domain/models/DocumentPosition;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDocument", SupportedFileExtensions.PAGES_EXTENSION, "", "title", "outputFileName", "ocrOptional", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outputFile", "(Ljava/util/List;Ljava/lang/String;Ljava/io/File;ZLandroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IDocumentScanPageProcessor {
    Object createDocument(List<ScannedDocumentPage> list, String str, File file, boolean z, Context context, Continuation<? super Result<? extends File, ? extends DomainError>> continuation);

    Object createDocument(List<ScannedDocumentPage> list, String str, String str2, boolean z, Context context, Continuation<? super Result<? extends File, ? extends DomainError>> continuation);

    File getWorkingDirectory();

    File prepareFile();

    Object processImage(Context context, File file, boolean z, DocumentPageFilterType documentPageFilterType, DocumentPosition documentPosition, Continuation<? super Result<ScannedPageProcessingResult, ? extends DomainError>> continuation);

    Object rotateImage(String str, int i, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object rotatePage(ScannedDocumentPage scannedDocumentPage, int i, Continuation<? super Result<ScannedDocumentPage, ? extends DomainError>> continuation);
}
