package com.box.android.base.presentation.presenters;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.presentation.utilities.ListingDialogFragmentInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: DialogFragmentListingPresenter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/presentation/presenters/DialogFragmentListingPresenter;", ExifInterface.GPS_DIRECTION_TRUE, "F", "Lcom/box/android/base/presentation/utilities/ListingDialogFragmentInterface;", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "<init>", "()V", "onItemClicked", "", "item", "additionalData", "", "", "(Ljava/lang/Object;[Ljava/lang/Object;)V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DialogFragmentListingPresenter<T, F extends ListingDialogFragmentInterface> extends BaseListingPresenter<T, F> {
    public static final int $stable = 8;

    public abstract void onItemClicked(T item, Object... additionalData);
}
