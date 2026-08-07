package com.box.android.data.jobs;

import androidx.work.Data;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IMoveCopyJobInputValidator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/data/jobs/IMoveCopyJobInputValidator;", "", "validateInputData", "Lcom/box/android/data/jobs/MoveCopyJobInputValidator$ValidationResult;", "inputData", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMoveCopyJobInputValidator {
    Object validateInputData(Data data, Continuation<? super MoveCopyJobInputValidator.ValidationResult> continuation);
}
