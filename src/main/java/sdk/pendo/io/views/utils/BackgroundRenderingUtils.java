package sdk.pendo.io.views.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.request.target.CustomTarget;
import external.sdk.pendo.io.glide.request.target.Target;
import external.sdk.pendo.io.glide.request.transition.a;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.c8.b;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R&\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019¨\u0006 "}, d2 = {"Lsdk/pendo/io/views/utils/BackgroundRenderingUtils;", "", "Landroid/view/View;", "view", "Lexternal/sdk/pendo/io/glide/load/resource/gif/GifDrawable;", "gifDrawable", "Lsdk/pendo/io/d8/a;", "config", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/graphics/Bitmap;", "bitmap", "c", "", "url", "b", "Lexternal/sdk/pendo/io/glide/request/target/Target;", "Landroid/graphics/drawable/Drawable;", "target", "Lkotlin/Function0;", "addExtraPadding", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "Ljava/util/WeakHashMap;", "Ljava/util/WeakHashMap;", "activeGlideTargets", "Landroid/view/View$OnAttachStateChangeListener;", "d", "detachListeners", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class BackgroundRenderingUtils {
    public static final BackgroundRenderingUtils a = new BackgroundRenderingUtils();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final WeakHashMap<View, Target<Drawable>> activeGlideTargets = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final WeakHashMap<View, View.OnAttachStateChangeListener> detachListeners = new WeakHashMap<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"sdk/pendo/io/views/utils/BackgroundRenderingUtils$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            BackgroundRenderingUtils.a.b(v);
            synchronized (BackgroundRenderingUtils.detachListeners) {
            }
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private BackgroundRenderingUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(View view) {
        Drawable background = view.getBackground();
        if (background instanceof b) {
            try {
                ((b) background).stop();
            } catch (Exception e) {
                PendoLogger.w("BackgroundRenderingUtils: Error recycling old GIF drawable: " + e.getMessage(), new Object[0]);
            }
        }
        view.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final View view) {
        final Target<Drawable> targetRemove;
        WeakHashMap<View, Target<Drawable>> weakHashMap = activeGlideTargets;
        synchronized (weakHashMap) {
            targetRemove = weakHashMap.remove(view);
        }
        if (targetRemove == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: sdk.pendo.io.views.utils.BackgroundRenderingUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundRenderingUtils.a(view, targetRemove);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            mainHandler.post(runnable);
        }
    }

    private final void b(View view, Target<Drawable> target) {
        WeakHashMap<View, Target<Drawable>> weakHashMap = activeGlideTargets;
        synchronized (weakHashMap) {
            weakHashMap.put(view, target);
            Unit unit = Unit.INSTANCE;
        }
        a aVar = new a();
        WeakHashMap<View, View.OnAttachStateChangeListener> weakHashMap2 = detachListeners;
        synchronized (weakHashMap2) {
            weakHashMap2.put(view, aVar);
            Unit unit2 = Unit.INSTANCE;
        }
        view.addOnAttachStateChangeListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view, Bitmap bitmap, sdk.pendo.io.d8.a config) {
        View view2;
        Drawable bitmapDrawable;
        Bitmap bitmap2;
        String imageFillType = config.getImageFillType();
        if (imageFillType == null || StringsKt.isBlank(imageFillType)) {
            view2 = view;
            Resources resources = view2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            bitmapDrawable = new BitmapDrawable(resources, bitmap);
        } else {
            try {
                view2 = view;
                bitmap2 = bitmap;
                try {
                    bitmapDrawable = new sdk.pendo.io.c8.a(bitmap2, view2, config.getImageFillType(), config.getBackgroundColor(), config.getCom.facebook.react.uimanager.ViewProps.BORDER_COLOR java.lang.String(), config.getCom.facebook.react.uimanager.ViewProps.BORDER_WIDTH java.lang.String(), config.d());
                } catch (IllegalArgumentException e) {
                    e = e;
                    PendoLogger.w("BackgroundRenderingUtils: Failed to create PendoBitmapDrawable, using default: " + e.getMessage(), new Object[0]);
                    Resources resources2 = view2.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                    bitmapDrawable = new BitmapDrawable(resources2, bitmap2);
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                view2 = view;
                bitmap2 = bitmap;
            }
        }
        view2.setBackground(bitmapDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final View view, GifDrawable gifDrawable, sdk.pendo.io.d8.a config) {
        final b bVar = new b(gifDrawable, config.getImageFillType(), config.getBackgroundColor(), config.getCom.facebook.react.uimanager.ViewProps.BORDER_COLOR java.lang.String(), config.getCom.facebook.react.uimanager.ViewProps.BORDER_WIDTH java.lang.String(), config.d());
        bVar.a(0);
        view.setBackground(bVar);
        bVar.setVisible(true, true);
        view.post(new Runnable() { // from class: sdk.pendo.io.views.utils.BackgroundRenderingUtils$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundRenderingUtils.a(view, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, b pendoGifDrawable) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(pendoGifDrawable, "$pendoGifDrawable");
        if (view.isAttachedToWindow() && Intrinsics.areEqual(view.getBackground(), pendoGifDrawable)) {
            try {
                pendoGifDrawable.start();
            } catch (Exception e) {
                PendoLogger.e(e, "BackgroundRenderingUtils: Error starting GIF: " + e.getMessage(), new Object[0]);
            }
        }
    }

    private final void a(View view) {
        WeakHashMap<View, View.OnAttachStateChangeListener> weakHashMap = detachListeners;
        synchronized (weakHashMap) {
            View.OnAttachStateChangeListener onAttachStateChangeListenerRemove = weakHashMap.remove(view);
            if (onAttachStateChangeListenerRemove != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListenerRemove);
                Unit unit = Unit.INSTANCE;
            }
        }
        b(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, Target target) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(target, "$target");
        try {
            external.sdk.pendo.io.glide.a.d(view.getContext().getApplicationContext()).clear((Target<?>) target);
        } catch (Exception e) {
            PendoLogger.w("BackgroundRenderingUtils: Error clearing Glide target: " + e.getMessage(), new Object[0]);
        }
    }

    public final void a(final View view, final sdk.pendo.io.d8.a config, Function0<Unit> addExtraPadding) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(addExtraPadding, "addExtraPadding");
        String imageUrl = config.getImageUrl();
        if (imageUrl == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof b) {
            b bVar = (b) background;
            if (bVar.isRunning()) {
                return;
            }
            bVar.start();
            return;
        }
        a(view);
        addExtraPadding.invoke();
        view.setVisibility(4);
        final String strA = a(imageUrl);
        Target<Drawable> targetInto = external.sdk.pendo.io.glide.a.d(view.getContext().getApplicationContext()).asDrawable().m14701load(imageUrl).override(config.getScreenSize().x, config.getScreenSize().y).diskCacheStrategy(sdk.pendo.io.h.a.c).into(new CustomTarget<Drawable>() { // from class: sdk.pendo.io.views.utils.BackgroundRenderingUtils$renderBackground$target$1
            @Override // external.sdk.pendo.io.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
                Drawable background2 = view.getBackground();
                if (background2 instanceof b) {
                    ((b) background2).stop();
                }
                view.setBackground(null);
            }

            @Override // external.sdk.pendo.io.glide.request.target.CustomTarget, external.sdk.pendo.io.glide.request.target.Target
            public void onLoadFailed(Drawable errorDrawable) {
                PendoLogger.w("BackgroundRenderingUtils: Load background failed url=" + strA, new Object[0]);
            }

            public void onResourceReady(Drawable resource, a<? super Drawable> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                BackgroundRenderingUtils backgroundRenderingUtils = BackgroundRenderingUtils.a;
                backgroundRenderingUtils.c(view);
                if (resource instanceof GifDrawable) {
                    backgroundRenderingUtils.a(view, (GifDrawable) resource, config);
                } else if (resource instanceof BitmapDrawable) {
                    View view2 = view;
                    Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                    backgroundRenderingUtils.a(view2, bitmap, config);
                } else {
                    view.setBackground(resource);
                }
                view.setVisibility(0);
            }

            @Override // external.sdk.pendo.io.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, a aVar) {
                onResourceReady((Drawable) obj, (a<? super Drawable>) aVar);
            }
        });
        Intrinsics.checkNotNullExpressionValue(targetInto, "into(...)");
        b(view, (BackgroundRenderingUtils$renderBackground$target$1) targetInto);
    }

    private final String a(String url) {
        try {
            Uri uri = Uri.parse(url);
            String host = uri.getHost();
            if (host == null) {
                host = "unknown";
            }
            String path = uri.getPath();
            if (path == null) {
                path = "";
            }
            return host + path;
        } catch (Exception unused) {
            return "[invalid_url]";
        }
    }
}
