package com.box.android.services;

import android.content.Context;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppNotificationServices.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000b\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0010H\u0016¨\u0006\u0015"}, d2 = {"Lcom/box/android/services/AppNotificationServices;", "Lcom/box/android/coreservices/services/NotificationServices;", "Ljava/io/Serializable;", "<init>", "()V", "displayDialog", "", "title", "", "message", "buttonText", "displayToast", NotificationCompat.CATEGORY_MESSAGE, "context", "Landroid/content/Context;", "resID", "", "customToast", "Landroid/widget/Toast;", "titleResId", "resId", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppNotificationServices implements NotificationServices, Serializable {
    public static final int $stable = 0;

    @Inject
    public AppNotificationServices() {
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayDialog(String title, String message, String buttonText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        BoxNotificationHelper.displayDialog(title, message, buttonText);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayDialog(String title, String message) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        BoxNotificationHelper.displayDialog(title, message);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayToast(String msg, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BoxPresentationUtils.displayToast(msg, context);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayToast(int resID, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BoxPresentationUtils.displayToast(resID, context, new String[0]);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayToast(Toast customToast, String msg, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BoxPresentationUtils.displayToast(customToast, msg, context);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayDialog(int titleResId, int resId) {
        BoxNotificationHelper.displayDialog(titleResId, resId);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayDialog(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BoxNotificationHelper.displayDialog(message);
    }

    @Override // com.box.android.coreservices.services.NotificationServices
    public void displayDialog(int resId) {
        BoxNotificationHelper.displayDialog(resId);
    }
}
