package com.box.android.base.presentation.utilities;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: ItemActionListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/ItemActionListener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onPrimaryAction", "", "item", "(Ljava/lang/Object;)V", "onSecondaryAction", "onLongClick", "", "(Ljava/lang/Object;)Z", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ItemActionListener<T> {
    default boolean onLongClick(T item) {
        return true;
    }

    void onPrimaryAction(T item);

    void onSecondaryAction(T item);

    /* JADX INFO: compiled from: ItemActionListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean onLongClick(ItemActionListener<T> itemActionListener, T t) {
            return ItemActionListener.super.onLongClick(t);
        }
    }
}
