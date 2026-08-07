package com.box.android.base.presentation.fragments;

import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.core.app.NotificationCompat;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.androidsdk.content.models.BoxItem;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IBoxFragmentActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H&J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J0\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH&J$\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J.\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH&J.\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/fragments/IBoxFragmentActivity;", "", "logAnalyticsCurrentPage", "", "toggleFab", "showFab", "", "setupFab", "setupAddFab", "showNonActionItems", "showBottomSheet", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "onActionModeCreated", "actionModeCallback", "Landroidx/appcompat/view/ActionMode$Callback;", "onActionModeDestroyed", "getFabMenu", "Lcom/github/clans/fab/FloatingActionMenu;", "dismissOutdatedSnackbar", "fragmentInterface", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "dismissSnackbar", "displaySnackbar", "Lcom/google/android/material/snackbar/Snackbar;", NotificationCompat.CATEGORY_MESSAGE, "", "actionMsgResId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "duration", "msgResId", "caller", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBoxFragmentActivity {
    void dismissOutdatedSnackbar(BoxFragmentInterface fragmentInterface);

    void dismissSnackbar();

    default void dismissSnackbar(BoxFragmentInterface fragmentInterface) {
        Intrinsics.checkNotNullParameter(fragmentInterface, "fragmentInterface");
    }

    Snackbar displaySnackbar(int msgResId, int actionMsgResId, View.OnClickListener listener);

    Snackbar displaySnackbar(int msgResId, int actionMsgResId, View.OnClickListener listener, int duration);

    Snackbar displaySnackbar(BoxFragmentInterface caller, int msgResId, int actionMsgResId, View.OnClickListener listener);

    Snackbar displaySnackbar(String msg, int actionMsgResId, View.OnClickListener listener);

    Snackbar displaySnackbar(String msg, int actionMsgResId, View.OnClickListener listener, int duration);

    FloatingActionMenu getFabMenu();

    void logAnalyticsCurrentPage();

    void onActionModeCreated(ActionMode.Callback actionModeCallback);

    void onActionModeDestroyed(ActionMode.Callback actionModeCallback);

    void setupAddFab();

    void setupFab();

    void showBottomSheet(BoxItem boxItem);

    boolean showNonActionItems();

    void toggleFab(boolean showFab);

    /* JADX INFO: compiled from: IBoxFragmentActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void dismissSnackbar(IBoxFragmentActivity iBoxFragmentActivity, BoxFragmentInterface fragmentInterface) {
            Intrinsics.checkNotNullParameter(fragmentInterface, "fragmentInterface");
            IBoxFragmentActivity.super.dismissSnackbar(fragmentInterface);
        }
    }

    static /* synthetic */ Snackbar displaySnackbar$default(IBoxFragmentActivity iBoxFragmentActivity, String str, int i, View.OnClickListener onClickListener, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displaySnackbar");
        }
        if ((i3 & 8) != 0) {
            i2 = -2;
        }
        return iBoxFragmentActivity.displaySnackbar(str, i, onClickListener, i2);
    }

    static /* synthetic */ Snackbar displaySnackbar$default(IBoxFragmentActivity iBoxFragmentActivity, int i, int i2, View.OnClickListener onClickListener, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displaySnackbar");
        }
        if ((i4 & 8) != 0) {
            i3 = -2;
        }
        return iBoxFragmentActivity.displaySnackbar(i, i2, onClickListener, i3);
    }
}
