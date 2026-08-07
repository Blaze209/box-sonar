package expo.modules.nativeelementsexpo;

import android.content.Context;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.intune.mam.client.widget.MAMPopupMenu;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ExpoView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lexpo/modules/nativeelementsexpo/ContextMenuView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/nativeelementsexpo/MenuAction;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "mPopupMenu", "Landroid/widget/PopupMenu;", "mGestureDetector", "Landroid/view/GestureDetector;", "actions", "", "getActions", "()Ljava/util/List;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "prepareMenu", "", "addChild", "view", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeChild", "removeChildAt", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuView extends ExpoView implements MenuAction {
    public static final int $stable = 8;
    private final List<MenuAction> actions;
    private GestureDetector mGestureDetector;
    private final PopupMenu mPopupMenu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenuView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.mPopupMenu = new MAMPopupMenu(context, this);
        this.actions = new ArrayList();
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: expo.modules.nativeelementsexpo.ContextMenuView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                ContextMenuView.this.prepareMenu();
            }
        });
    }

    @Override // expo.modules.nativeelementsexpo.MenuAction
    public void parseActions(Menu menu, List<? extends MenuAction> list, int i) {
        MenuAction.DefaultImpls.parseActions(this, menu, list, i);
    }

    public final List<MenuAction> getActions() {
        return this.actions;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return this.mGestureDetector.onTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        this.mGestureDetector.onTouchEvent(ev);
        return true;
    }

    public final void prepareMenu() {
        int width = getRootView().getWidth();
        this.mPopupMenu.setGravity(getLeft() > width / 2 ? 5 : 3);
        this.mPopupMenu.getMenu().clear();
        this.mPopupMenu.getMenu().setGroupDividerEnabled(true);
        Menu menu = this.mPopupMenu.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        MenuAction.DefaultImpls.parseActions$default(this, menu, this.actions, 0, 4, null);
        this.mPopupMenu.setForceShowIcon(true);
        this.mPopupMenu.show();
        this.mPopupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() { // from class: expo.modules.nativeelementsexpo.ContextMenuView$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnDismissListener
            public final void onDismiss(PopupMenu popupMenu) {
                this.f$0.setAlpha(1.0f);
            }
        });
        setAlpha(0.3f);
    }

    public final void addChild(View view, int index) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof MenuAction) {
            this.actions.add(view);
        } else if (view instanceof ContextMenuPreviewView) {
            return;
        }
        addView(view, index);
    }

    public final void removeChild(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        removeView(view);
    }

    public final void removeChildAt(int index) {
        removeViewAt(index);
    }
}
