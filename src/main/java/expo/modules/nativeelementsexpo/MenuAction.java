package expo.modules.nativeelementsexpo;

import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MenuAction.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuAction;", "", "parseActions", "", "parent", "Landroid/view/Menu;", "actions", "", "groupId", "", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MenuAction {
    void parseActions(Menu parent, List<? extends MenuAction> actions, int groupId);

    /* JADX INFO: compiled from: MenuAction.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void parseActions$default(MenuAction menuAction, Menu menu, List list, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseActions");
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            menuAction.parseActions(menu, list, i);
        }

        public static void parseActions(MenuAction menuAction, Menu parent, List<? extends MenuAction> actions, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(actions, "actions");
            for (MenuAction menuAction2 : actions) {
                if (menuAction2 instanceof SubmenuNativeView) {
                    SubmenuNativeView submenuNativeView = (SubmenuNativeView) menuAction2;
                    if (Intrinsics.areEqual(submenuNativeView.getMode(), "inline") || Intrinsics.areEqual(submenuNativeView.getMode(), "palette")) {
                        int i2 = i + 1;
                        String string = StringsKt.trim((CharSequence) submenuNativeView.getTitle()).toString();
                        String str = string;
                        if (str.length() > 0) {
                            MenuItem menuItemAdd = parent.add(i2, 0, parent.size(), str);
                            menuItemAdd.setEnabled(false);
                            Integer sectionTitleColor = submenuNativeView.getSectionTitleColor();
                            if (sectionTitleColor != null) {
                                menuItemAdd.setTitle(MenuActionKt.getTextWithColor(string, sectionTitleColor.intValue()));
                            }
                        }
                        menuAction2.parseActions(parent, submenuNativeView.getActions(), i2);
                        i += 2;
                    } else {
                        SubMenu subMenuAddSubMenu = parent.addSubMenu(i, 0, parent.size(), "");
                        subMenuAddSubMenu.setGroupDividerEnabled(true);
                        Intrinsics.checkNotNull(subMenuAddSubMenu);
                        submenuNativeView.configureSubMenu(subMenuAddSubMenu);
                    }
                } else if (menuAction2 instanceof MenuActionNativeView) {
                    MenuItem menuItemAdd2 = parent.add(i, 0, parent.size(), "");
                    Intrinsics.checkNotNull(menuItemAdd2);
                    ((MenuActionNativeView) menuAction2).configure(menuItemAdd2);
                }
            }
        }
    }
}
