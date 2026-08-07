package expo.modules.ui;

import android.view.View;
import android.view.ViewGroup;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SlotView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"isSlotWithName", "", "view", "Lexpo/modules/kotlin/views/ExpoComposeView;", "slotName", "", "isSlotView", "findChildSlotView", "Lexpo/modules/ui/SlotView;", "viewGroup", "Landroid/view/ViewGroup;", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlotViewKt {
    public static final boolean isSlotWithName(ExpoComposeView<?> view, String slotName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        return (view instanceof SlotView) && Intrinsics.areEqual(((SlotView) view).getProps().getSlotName().getValue(), slotName);
    }

    public static final boolean isSlotView(ExpoComposeView<?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view instanceof SlotView;
    }

    public static final SlotView findChildSlotView(ViewGroup viewGroup, String slotName) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i);
            SlotView slotView = childAt instanceof SlotView ? (SlotView) childAt : null;
            if (slotView != null && Intrinsics.areEqual(slotView.getProps().getSlotName().getValue(), slotName)) {
                return slotView;
            }
            i++;
        }
    }
}
