package com.box.android.base.presentation.fragments;

import android.view.View;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;

/* JADX INFO: compiled from: IMainParent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/fragments/IMainParent;", "", "dismissSnackbar", "", "getCurrentVisibleFragment", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "displaySnackbar", "Lcom/google/android/material/snackbar/Snackbar;", "msgResId", "", "actionMsgResId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setupFab", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMainParent {
    void dismissSnackbar();

    Snackbar displaySnackbar(int msgResId, int actionMsgResId, View.OnClickListener listener);

    BoxFragmentInterface getCurrentVisibleFragment();

    void setupFab();
}
