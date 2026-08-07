package external.sdk.pendo.io.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import external.sdk.pendo.io.glide.request.transition.a;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, ComponentName componentName) {
        super(i, i2);
        this.context = (Context) k.a(context, "Context can not be null!");
        this.remoteViews = (RemoteViews) k.a(remoteViews, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) k.a(componentName, "ComponentName can not be null!");
        this.viewId = i3;
        this.widgetIds = null;
    }

    private void setBitmap(Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        setBitmap(null);
    }

    public void onResourceReady(Bitmap bitmap, a<? super Bitmap> aVar) {
        setBitmap(bitmap);
    }

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.context = (Context) k.a(context, "Context can not be null!");
        this.remoteViews = (RemoteViews) k.a(remoteViews, "RemoteViews object can not be null!");
        this.widgetIds = (int[]) k.a(iArr, "WidgetIds can not be null!");
        this.viewId = i3;
        this.componentName = null;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, a aVar) {
        onResourceReady((Bitmap) obj, (a<? super Bitmap>) aVar);
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }
}
