package com.box.android.domain.usecases.capture;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CaptureFolderUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/capture/CaptureFolderUseCase;", "", "getCaptureFolder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CaptureFolderUseCase {
    Flow<Result<FolderModel, DomainError>> getCaptureFolder();
}
