package com.box.android.base.presentation.utilities;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewModelExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a3\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\t\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\t0\n*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"observeOnce", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "addValue", "U", "", "Landroidx/lifecycle/MutableLiveData;", "element", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewModelExtensionsKt {
    public static final <T> void observeOnce(final LiveData<T> liveData, LifecycleOwner lifecycleOwner, final Observer<T> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        liveData.observe(lifecycleOwner, new Observer<T>() { // from class: com.box.android.base.presentation.utilities.ViewModelExtensionsKt.observeOnce.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(T value) {
                observer.onChanged(value);
                liveData.removeObserver(this);
            }
        });
    }

    public static final <U, T extends List<U>> void addValue(MutableLiveData<T> mutableLiveData, U u) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        T value = mutableLiveData.getValue();
        if (value != null) {
            value.add(u);
        }
        mutableLiveData.postValue(mutableLiveData.getValue());
    }
}
