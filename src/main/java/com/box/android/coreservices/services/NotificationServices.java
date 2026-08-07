package com.box.android.coreservices.services;

import android.content.Context;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationServices.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&J$\u0010\b\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/services/NotificationServices;", "", "displayDialog", "", "title", "", "message", "buttonText", "displayToast", NotificationCompat.CATEGORY_MESSAGE, "context", "Landroid/content/Context;", "resID", "", "customToast", "Landroid/widget/Toast;", "titleResId", "resId", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationServices {
    void displayDialog(int resId);

    void displayDialog(int titleResId, int resId);

    void displayDialog(String message);

    void displayDialog(String title, String message);

    void displayDialog(String title, String message, String buttonText);

    void displayToast(int resID, Context context);

    void displayToast(Toast customToast, String msg, Context context);

    void displayToast(String msg, Context context);
}
