package sdk.pendo.io.listeners.views;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.constants.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x6.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\t\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u000fR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "drawerLayoutReference", "Ljava/lang/ref/WeakReference;", "drawerState", "Ljava/util/concurrent/atomic/AtomicInteger;", "isDrawerOpened", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDrawerLayoutRef", "getDrawerState", "", "isDrawerOpen", "", "drawer", "isDrawerOpenedAndRelatesToCurrentScreen", "activity", "Landroid/app/Activity;", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "onDrawerStateChanged", "newState", "setDrawerLayoutReference", "setDrawerState", "state", "setIsDrawerOpened", "opened", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoDrawerListener implements DrawerLayout.DrawerListener {
    private static final String TAG = "PendoDrawerListener";
    private WeakReference<DrawerLayout> drawerLayoutReference;
    private final AtomicInteger drawerState = new AtomicInteger(0);
    private final AtomicBoolean isDrawerOpened;

    public PendoDrawerListener(DrawerLayout drawerLayout) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.isDrawerOpened = atomicBoolean;
        this.drawerLayoutReference = new WeakReference<>(drawerLayout);
        atomicBoolean.set(isDrawerOpen(drawerLayout == null ? null : drawerLayout));
    }

    private final boolean isDrawerOpen(DrawerLayout drawer) {
        if (drawer != null) {
            return drawer.isDrawerOpen(GravityCompat.START) || drawer.isDrawerOpen(GravityCompat.END);
        }
        return false;
    }

    public final WeakReference<DrawerLayout> getDrawerLayoutRef() {
        return this.drawerLayoutReference;
    }

    public final synchronized int getDrawerState() {
        return this.drawerState.get();
    }

    public final synchronized boolean isDrawerOpened() {
        return this.isDrawerOpened.get();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    public final synchronized boolean isDrawerOpenedAndRelatesToCurrentScreen(Activity activity) {
        View decorView;
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                } else {
                    decorView = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            decorView = null;
        }
        boolean z = false;
        if (decorView == null) {
            PendoLogger.w(TAG, " isDrawerOpenedAndRelatesToCurrentScreen -> Current activity or activity's window is null");
            return false;
        }
        DrawerLayout drawerLayout = this.drawerLayoutReference.get();
        View rootView = drawerLayout != null ? drawerLayout.getRootView() : null;
        if (rootView == null) {
            PendoLogger.w(TAG, " isDrawerOpenedAndRelatesToCurrentScreen -> Drawer Layout ref is null");
            return false;
        }
        if (decorView == rootView && this.isDrawerOpened.get()) {
            z = true;
        }
        return z;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        if (StepSeenManager.getInstance().isBannerGuideStep()) {
            PendoLogger.d(TAG, "Displayed guide is of type Banner, won't dismiss guide");
        } else {
            VisualGuidesManager.getInstance().removeShowingGuide();
        }
        this.isDrawerOpened.set(false);
        PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_DRAWER_CLOSED);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        this.isDrawerOpened.set(true);
        PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_DRAWER_OPENED);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        Float DRAWER_CLOSE_SLIDE_OFFSET = b.a;
        Intrinsics.checkNotNullExpressionValue(DRAWER_CLOSE_SLIDE_OFFSET, "DRAWER_CLOSE_SLIDE_OFFSET");
        if (slideOffset < DRAWER_CLOSE_SLIDE_OFFSET.floatValue()) {
            this.isDrawerOpened.set(false);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int newState) {
        DrawerLayout drawerLayout;
        this.drawerState.set(newState);
        if (newState != 0 || (drawerLayout = this.drawerLayoutReference.get()) == null) {
            return;
        }
        this.isDrawerOpened.set(isDrawerOpen(drawerLayout instanceof DrawerLayout ? drawerLayout : null));
        PendoInternal.z().onGlobalLayoutChangeEvent(g.ON_SCREEN_CHANGED);
    }

    public final void setDrawerLayoutReference(DrawerLayout drawerLayout) {
        DrawerLayout drawerLayout2 = this.drawerLayoutReference.get();
        if (drawerLayout2 != null) {
            drawerLayout2.removeDrawerListener(this);
        }
        this.drawerLayoutReference = new WeakReference<>(drawerLayout);
    }

    public final synchronized void setDrawerState(int state) {
        this.drawerState.set(state);
    }

    public final synchronized void setIsDrawerOpened(boolean opened) {
        this.isDrawerOpened.set(opened);
    }
}
