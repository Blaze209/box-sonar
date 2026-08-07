package com.box.android.base.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseListingViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H$J\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H¦@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/vm/BaseListingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_errorLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/box/android/common/utilities/ErrorEvent;", "get_errorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "errorLiveData", "Landroidx/lifecycle/LiveData;", "getErrorLiveData", "()Landroidx/lifecycle/LiveData;", "setError", "", "error", "Lcom/box/android/domain/models/DomainError;", "errorHelper", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "areItemsFetched", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseListingViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<ErrorEvent> _errorLiveData = new MutableLiveData<>();

    /* JADX INFO: renamed from: areItemsFetched */
    public boolean getInitialFetchCompleted() {
        return true;
    }

    protected abstract ErrorEvent errorHelper(DomainError error);

    public abstract Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<ErrorEvent> get_errorLiveData() {
        return this._errorLiveData;
    }

    public final LiveData<ErrorEvent> getErrorLiveData() {
        return this._errorLiveData;
    }

    public final void setError(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this._errorLiveData.postValue(errorHelper(error));
    }
}
