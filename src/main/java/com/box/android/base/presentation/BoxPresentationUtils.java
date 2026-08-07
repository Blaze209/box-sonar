package com.box.android.base.presentation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.box.android.common.utilities.CommonBoxUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: BoxPresentationUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J@\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\bH\u0007J8\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007JB\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\bH\u0007J*\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\bH\u0003J&\u0010\t\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J5\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010 \"\u00020\u0001H\u0007¢\u0006\u0002\u0010!J3\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060 \"\u00020\u0006H\u0007¢\u0006\u0002\u0010#J6\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/base/presentation/BoxPresentationUtils;", "", "<init>", "()V", "toasts", "", "", "SNACKBAR_DURATION_4_S", "", "displayToast", "", NotificationCompat.CATEGORY_MESSAGE, "context", "Landroid/content/Context;", "displaySnackBar", "Lcom/google/android/material/snackbar/Snackbar;", "view", "Landroid/view/View;", "msgResId", "actionMsgResId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "duration", "msgRes", "", "prepareSnackBar", "snackbar", "customToast", "Landroid/widget/Toast;", "localize", "resourceID", "args", "", "(ILandroid/content/Context;[Ljava/lang/Object;)Ljava/lang/String;", "resID", "(ILandroid/content/Context;[Ljava/lang/String;)V", "displaySnack", "parentView", "resId", "actionResId", "actionListener", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxPresentationUtils {
    public static final int SNACKBAR_DURATION_4_S = 4000;
    public static final BoxPresentationUtils INSTANCE = new BoxPresentationUtils();
    private static final Set<String> toasts = new LinkedHashSet();
    public static final int $stable = 8;

    private BoxPresentationUtils() {
    }

    @JvmStatic
    public static final void displayToast(String msg, Context context) {
        displayToast((Toast) null, msg, context);
    }

    @JvmStatic
    public static final Snackbar displaySnackBar(Context context, View view, int msgResId, int actionMsgResId, View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        return displaySnackBar(context, view, msgResId, actionMsgResId, listener, -2);
    }

    public static /* synthetic */ Snackbar displaySnackBar$default(Context context, View view, int i, int i2, View.OnClickListener onClickListener, int i3, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            i3 = -2;
        }
        return displaySnackBar(context, view, i, i2, onClickListener, i3);
    }

    @JvmStatic
    public static final Snackbar displaySnackBar(Context context, View view, int msgResId, int actionMsgResId, View.OnClickListener listener, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        return displaySnackBar(context, view, context.getResources().getText(msgResId), actionMsgResId, listener, duration);
    }

    @JvmStatic
    public static final Snackbar displaySnackBar(Context context, View view, CharSequence msgRes, int actionMsgResId, View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        return displaySnackBar(context, view, msgRes, actionMsgResId, listener, -2);
    }

    public static /* synthetic */ Snackbar displaySnackBar$default(Context context, View view, CharSequence charSequence, int i, View.OnClickListener onClickListener, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = -2;
        }
        return displaySnackBar(context, view, charSequence, i, onClickListener, i2);
    }

    @JvmStatic
    public static final Snackbar displaySnackBar(Context context, View view, CharSequence msgRes, int actionMsgResId, View.OnClickListener listener, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(msgRes);
        Snackbar snackbarMake = Snackbar.make(view, msgRes, duration);
        Intrinsics.checkNotNullExpressionValue(snackbarMake, "make(...)");
        prepareSnackBar(snackbarMake, context, listener, actionMsgResId);
        return snackbarMake;
    }

    @JvmStatic
    private static final void prepareSnackBar(Snackbar snackbar, Context context, View.OnClickListener listener, int actionMsgResId) {
        if (listener != null) {
            snackbar.setAction(actionMsgResId, listener);
        }
        View viewFindViewById = snackbar.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setTextColor(CommonBoxUtil.getColorFromAttribute(context, com.box.android.base.R.attr.snackBarPrimary));
        View viewFindViewById2 = snackbar.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById2).setTextColor(CommonBoxUtil.getColorFromAttribute(context, com.box.android.base.R.attr.snackBarAction));
        snackbar.show();
    }

    @JvmStatic
    public static final void displayToast(final Toast customToast, final String msg, final Context context) {
        Set<String> set = toasts;
        synchronized (set) {
            if (CollectionsKt.contains(set, msg)) {
                return;
            }
            if (msg != null) {
                Boolean.valueOf(set.add(msg));
            }
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() { // from class: com.box.android.base.presentation.BoxPresentationUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BoxPresentationUtils.displayToast$lambda$1(customToast, msg, context, handler);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayToast$lambda$1(Toast toast, final String str, Context context, Handler handler) {
        if (toast != null) {
            toast.setText(str);
            toast.show();
        } else if (context != null) {
            Toast.makeText(context, str, 1).show();
        }
        handler.postDelayed(new Runnable() { // from class: com.box.android.base.presentation.BoxPresentationUtils$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BoxPresentationUtils.displayToast$lambda$1$0(str);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayToast$lambda$1$0(String str) {
        TypeIntrinsics.asMutableCollection(toasts).remove(str);
    }

    @JvmStatic
    public static final String localize(int resourceID, Context context, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Resources resources = context != null ? context.getResources() : null;
        if (args.length == 0) {
            if (resources != null) {
                return resources.getString(resourceID);
            }
            return null;
        }
        if (resources != null) {
            return resources.getString(resourceID, Arrays.copyOf(args, args.length));
        }
        return null;
    }

    @JvmStatic
    public static final void displayToast(int resID, Context context, String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        displayToast(localize(resID, context, Arrays.copyOf(args, args.length)), context);
    }

    @JvmStatic
    public static final Snackbar displaySnack(View parentView, int resId, int actionResId, View.OnClickListener actionListener, int duration) {
        if (parentView == null) {
            return null;
        }
        Snackbar snackbarMake = Snackbar.make(parentView, resId, duration);
        Intrinsics.checkNotNullExpressionValue(snackbarMake, "make(...)");
        if (actionListener != null) {
            snackbarMake.setAction(actionResId, actionListener);
        }
        snackbarMake.show();
        return snackbarMake;
    }
}
