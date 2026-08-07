package external.sdk.pendo.io.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.microsoft.intune.mam.client.app.MAMNotificationManagement;
import external.sdk.pendo.io.glide.request.transition.a;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, Notification notification, int i4, String str) {
        super(i, i2);
        this.context = (Context) k.a(context, "Context must not be null!");
        this.notification = (Notification) k.a(notification, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) k.a(remoteViews, "RemoteViews object can not be null!");
        this.viewId = i3;
        this.notificationId = i4;
        this.notificationTag = str;
    }

    private void setBitmap(Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    private void update() {
        MAMNotificationManagement.notify((NotificationManager) k.a((NotificationManager) this.context.getSystemService("notification")), this.notificationTag, this.notificationId, this.notification);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        setBitmap(null);
    }

    public void onResourceReady(Bitmap bitmap, a<? super Bitmap> aVar) {
        setBitmap(bitmap);
    }

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2) {
        this(context, i, remoteViews, notification, i2, null);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, a aVar) {
        onResourceReady((Bitmap) obj, (a<? super Bitmap>) aVar);
    }

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, notification, i2, str);
    }
}
