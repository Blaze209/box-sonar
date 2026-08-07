package com.box.android.common.utilities;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleEvent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"postEventValue", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "Lcom/box/android/common/utilities/SingleEvent;", "value", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SingleEventKt {
    public static final <T> void postEventValue(MutableLiveData<SingleEvent<T>> mutableLiveData, T t) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        mutableLiveData.postValue(new SingleEvent<>(t));
    }
}
