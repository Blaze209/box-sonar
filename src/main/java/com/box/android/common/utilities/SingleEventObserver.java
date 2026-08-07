package com.box.android.common.utilities;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.box.android.common.utilities.SingleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleEvent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/common/utilities/SingleEventObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/common/utilities/SingleEvent;", "Landroidx/lifecycle/Observer;", "onEventUnhandledContent", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onChanged", "event", "(Lcom/box/android/common/utilities/SingleEvent;)V", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SingleEventObserver<T extends SingleEvent<?>> implements Observer<T> {
    private final Function1<T, Unit> onEventUnhandledContent;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleEventObserver(Function1<? super T, Unit> onEventUnhandledContent) {
        Intrinsics.checkNotNullParameter(onEventUnhandledContent, "onEventUnhandledContent");
        this.onEventUnhandledContent = onEventUnhandledContent;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getIsHandled()) {
            return;
        }
        this.onEventUnhandledContent.invoke(event);
        event.handledEvent();
    }
}
