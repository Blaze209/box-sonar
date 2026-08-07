package expo.modules.nativeelementsexpo;

import android.content.Context;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import com.box.android.observability.DiagnosisParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ExpoView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SubmenuNativeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u000e\u00102\u001a\u00020*2\u0006\u00100\u001a\u00020\u001dR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00063"}, d2 = {"Lexpo/modules/nativeelementsexpo/SubmenuNativeView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/nativeelementsexpo/MenuAction;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "actions", "", "getActions", "()Ljava/util/List;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", DiagnosisParams.DIAGNOSIS_MODE, "getMode", "setMode", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "sectionTitleColor", "", "getSectionTitleColor", "()Ljava/lang/Integer;", "setSectionTitleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentMenuUpdatable", "Lexpo/modules/nativeelementsexpo/MenuUpdatable;", "getParentMenuUpdatable", "()Lexpo/modules/nativeelementsexpo/MenuUpdatable;", "setParentMenuUpdatable", "(Lexpo/modules/nativeelementsexpo/MenuUpdatable;)V", "configureSubMenu", "", "subMenu", "Landroid/view/SubMenu;", "addChild", "view", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "removeChild", "removeChildAt", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmenuNativeView extends ExpoView implements MenuAction {
    public static final int $stable = 8;
    private final List<MenuAction> actions;
    private boolean disabled;
    private String mode;
    private MenuUpdatable parentMenuUpdatable;
    private Integer sectionTitleColor;
    private String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmenuNativeView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.actions = new ArrayList();
        this.title = "";
        this.mode = "expandable";
    }

    @Override // expo.modules.nativeelementsexpo.MenuAction
    public void parseActions(Menu menu, List<? extends MenuAction> list, int i) {
        MenuAction.DefaultImpls.parseActions(this, menu, list, i);
    }

    public final List<MenuAction> getActions() {
        return this.actions;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mode = str;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final void setDisabled(boolean z) {
        this.disabled = z;
    }

    public final Integer getSectionTitleColor() {
        return this.sectionTitleColor;
    }

    public final void setSectionTitleColor(Integer num) {
        this.sectionTitleColor = num;
    }

    public final MenuUpdatable getParentMenuUpdatable() {
        return this.parentMenuUpdatable;
    }

    public final void setParentMenuUpdatable(MenuUpdatable menuUpdatable) {
        this.parentMenuUpdatable = menuUpdatable;
    }

    public final void configureSubMenu(SubMenu subMenu) {
        Intrinsics.checkNotNullParameter(subMenu, "subMenu");
        subMenu.setHeaderTitle(this.title);
        subMenu.getItem().setTitle(this.title);
        subMenu.getItem().setEnabled(!this.disabled);
        MenuAction.DefaultImpls.parseActions$default(this, subMenu, this.actions, 0, 4, null);
    }

    public final void addChild(View view, int index) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof MenuAction) {
            this.actions.add(RangesKt.coerceIn(index, 0, this.actions.size()), view);
        }
        addView(view, index);
        MenuUpdatable menuUpdatable = this.parentMenuUpdatable;
        if (menuUpdatable != null) {
            menuUpdatable.updateMenu();
        }
    }

    public final void removeChild(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof MenuAction) {
            this.actions.remove(view);
        }
        removeView(view);
        MenuUpdatable menuUpdatable = this.parentMenuUpdatable;
        if (menuUpdatable != null) {
            menuUpdatable.updateMenu();
        }
    }

    public final void removeChildAt(int index) {
        View childAt = getChildAt(index);
        if (childAt instanceof MenuAction) {
            this.actions.remove(childAt);
        }
        removeViewAt(index);
        MenuUpdatable menuUpdatable = this.parentMenuUpdatable;
        if (menuUpdatable != null) {
            menuUpdatable.updateMenu();
        }
    }
}
