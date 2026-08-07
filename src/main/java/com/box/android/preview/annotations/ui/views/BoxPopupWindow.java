package com.box.android.preview.annotations.ui.views;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.core.content.res.ResourcesCompat;
import com.box.android.preview.R;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.intune.mam.client.widget.MAMPopupWindow;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPopupWindow.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/BoxPopupWindow;", "Landroid/widget/PopupWindow;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/View;", "menuItemStateMap", "", "", "Lcom/box/android/preview/annotations/ui/views/MenuItemState;", "onClickListener", "Lkotlin/Function2;", "", "<init>", "(Landroid/view/View;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "updateButtonStates", ViewProps.ON_CLICK, "v", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BoxPopupWindow extends MAMPopupWindow implements View.OnClickListener {
    public static final int $stable = 8;
    private final Function2<View, PopupWindow, Unit> onClickListener;
    private final View root;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BoxPopupWindow(View root, Map<Integer, MenuItemState> menuItemStateMap, Function2<? super View, ? super PopupWindow, Unit> onClickListener) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(menuItemStateMap, "menuItemStateMap");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.root = root;
        this.onClickListener = onClickListener;
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(true);
        Resources resources = root.getContext().getResources();
        setElevation(resources.getDimension(R.dimen.box_previewsdk_popup_menu_elevation));
        setBackgroundDrawable(ResourcesCompat.getDrawable(resources, R.drawable.popup_rectangle_rounded, null));
        updateButtonStates(menuItemStateMap);
    }

    public final void updateButtonStates(Map<Integer, MenuItemState> menuItemStateMap) {
        Intrinsics.checkNotNullParameter(menuItemStateMap, "menuItemStateMap");
        LinearLayout linearLayout = (LinearLayout) this.root.findViewById(R.id.popup_menu_container);
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            MenuItemState menuItemState = menuItemStateMap.get(Integer.valueOf(childAt.getId()));
            int i2 = 8;
            if (menuItemState != null) {
                childAt.setOnClickListener(this);
                childAt.setEnabled(menuItemState.isEnabled());
                if (menuItemState.isVisible()) {
                    i2 = 0;
                }
            }
            childAt.setVisibility(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.onClickListener.invoke(v, this);
    }
}
