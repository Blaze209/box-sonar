package com.box.android.common.utilities;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: SingleEvent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/common/utilities/SingleEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isHandled", "", "handledEvent", "", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SingleEvent<T> {
    private boolean isHandled;
    private final T value;

    public SingleEvent(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: isHandled, reason: from getter */
    public boolean getIsHandled() {
        return this.isHandled;
    }

    public void handledEvent() {
        this.isHandled = true;
    }
}
