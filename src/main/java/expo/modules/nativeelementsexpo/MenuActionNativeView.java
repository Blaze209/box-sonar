package expo.modules.nativeelementsexpo;

import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.content.ContextCompat;
import com.box.android.domain.metrics.hubs.HubsObservability;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.viewevent.ViewEventDelegateKt;
import expo.modules.kotlin.views.ExpoView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MenuActionNativeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010(\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u001c\u0010+\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR-\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000201000/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103¨\u0006;"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuActionNativeView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/nativeelementsexpo/MenuAction;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "checked", "getChecked", "()Ljava/lang/Boolean;", "setChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "destructive", "getDestructive", "setDestructive", "destructiveColor", "", "getDestructiveColor", "()Ljava/lang/Integer;", "setDestructiveColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColor", "getTextColor", "setTextColor", "disabledTextColor", "getDisabledTextColor", "setDisabledTextColor", HubsObservability.HUB_ASSET_ICON, "getIcon", "setIcon", "onSelected", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "", "getOnSelected", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onSelected$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "configure", "", "item", "Landroid/view/MenuItem;", "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuActionNativeView extends ExpoView implements MenuAction {
    private static final String TAG = "MenuActionNativeView";
    private Boolean checked;
    private boolean destructive;
    private Integer destructiveColor;
    private boolean disabled;
    private Integer disabledTextColor;
    private String icon;

    /* JADX INFO: renamed from: onSelected$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onSelected;
    private Integer textColor;
    private String title;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MenuActionNativeView.class, "onSelected", "getOnSelected()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuActionNativeView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.title = "";
        this.onSelected = ViewEventDelegateKt.MapEventDispatcher$default(this, null, 1, null);
    }

    @Override // expo.modules.nativeelementsexpo.MenuAction
    public void parseActions(Menu menu, List<? extends MenuAction> list, int i) {
        MenuAction.DefaultImpls.parseActions(this, menu, list, i);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final void setDisabled(boolean z) {
        this.disabled = z;
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(Boolean bool) {
        this.checked = bool;
    }

    public final boolean getDestructive() {
        return this.destructive;
    }

    public final void setDestructive(boolean z) {
        this.destructive = z;
    }

    public final Integer getDestructiveColor() {
        return this.destructiveColor;
    }

    public final void setDestructiveColor(Integer num) {
        this.destructiveColor = num;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(Integer num) {
        this.textColor = num;
    }

    public final Integer getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public final void setDisabledTextColor(Integer num) {
        this.disabledTextColor = num;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final ViewEventCallback<Map<String, Object>> getOnSelected() {
        return this.onSelected.getValue(this, $$delegatedProperties[0]);
    }

    public final void configure(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.setTitle(this.title);
        item.setEnabled(!this.disabled);
        Boolean bool = this.checked;
        item.setChecked(bool != null ? bool.booleanValue() : false);
        item.setCheckable(this.checked != null);
        if (this.disabled) {
            Integer num = this.disabledTextColor;
            if (num != null) {
                item.setTitle(MenuActionKt.getTextWithColor(this.title, num.intValue()));
            }
        } else if (this.destructive) {
            Integer num2 = this.destructiveColor;
            if (num2 != null) {
                item.setTitle(MenuActionKt.getTextWithColor(this.title, num2.intValue()));
            }
        } else {
            Integer num3 = this.textColor;
            if (num3 != null) {
                item.setTitle(MenuActionKt.getTextWithColor(this.title, num3.intValue()));
            }
        }
        String str = this.icon;
        if (str != null) {
            int identifier = getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName());
            if (identifier != 0) {
                item.setIcon(ContextCompat.getDrawable(getContext(), identifier));
            } else {
                Log.e(TAG, "Unable to resolve drawable resource '" + str + "' for menu action.");
            }
        }
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: expo.modules.nativeelementsexpo.MenuActionNativeView$$ExternalSyntheticLambda0
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MenuActionNativeView.configure$lambda$4(this.f$0, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configure$lambda$4(MenuActionNativeView menuActionNativeView, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        menuActionNativeView.getOnSelected().invoke(MapsKt.emptyMap());
        return true;
    }
}
