package com.box.android.base.presentation.fragments;

import kotlin.Metadata;

/* JADX INFO: compiled from: AlertDialogFragmentListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/fragments/AlertDialogFragmentListener;", "", "onAlertDialogFragmentPositiveButton", "", "tag", "", "onAlertDialogFragmentNeutralButton", "onAlertDialogFragmentNegativeButton", "onAlertDialogFragmentDismissed", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AlertDialogFragmentListener {
    default void onAlertDialogFragmentDismissed(String tag) {
    }

    default void onAlertDialogFragmentNegativeButton(String tag) {
    }

    default void onAlertDialogFragmentNeutralButton(String tag) {
    }

    default void onAlertDialogFragmentPositiveButton(String tag) {
    }

    /* JADX INFO: compiled from: AlertDialogFragmentListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onAlertDialogFragmentPositiveButton(AlertDialogFragmentListener alertDialogFragmentListener, String str) {
            AlertDialogFragmentListener.super.onAlertDialogFragmentPositiveButton(str);
        }

        @Deprecated
        public static void onAlertDialogFragmentNeutralButton(AlertDialogFragmentListener alertDialogFragmentListener, String str) {
            AlertDialogFragmentListener.super.onAlertDialogFragmentNeutralButton(str);
        }

        @Deprecated
        public static void onAlertDialogFragmentNegativeButton(AlertDialogFragmentListener alertDialogFragmentListener, String str) {
            AlertDialogFragmentListener.super.onAlertDialogFragmentNegativeButton(str);
        }

        @Deprecated
        public static void onAlertDialogFragmentDismissed(AlertDialogFragmentListener alertDialogFragmentListener, String str) {
            AlertDialogFragmentListener.super.onAlertDialogFragmentDismissed(str);
        }
    }
}
