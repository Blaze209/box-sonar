package com.pspdfkit.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.microsoft.intune.mam.client.widget.MAMPopupWindow;
import com.pspdfkit.R;
import com.pspdfkit.internal.sw;
import com.pspdfkit.ui.toolbar.popup.PopupToolbarMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\f\b\u0017\u0018\u0000 I2\u00020\u0001:\u0004JKLIB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\bJ%\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\t8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R0\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001e0A2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0A8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010G\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/pspdfkit/ui/PopupToolbar;", "", "Lcom/pspdfkit/ui/PdfFragment;", "pdfFragment", "<init>", "(Lcom/pspdfkit/ui/PdfFragment;)V", "", "restorePopupWindowWrapContentSizing", "()V", "", "screenWidth", "floatingToolbarPadding", "resolvePopupMaxWidth", "(II)I", "Lcom/pspdfkit/ui/PopupToolbar$OnPopupToolbarItemClickedListener;", "onPopupToolbarItemClickedListener", "setOnPopupToolbarItemClickedListener", "(Lcom/pspdfkit/ui/PopupToolbar$OnPopupToolbarItemClickedListener;)V", "showAgain", "pageIndex", "", "x", "y", "show", "(IFF)V", BoxAnalyticsParams.ACTION_DISMISS, "Lcom/pspdfkit/ui/PopupToolbar$DefaultItemHandler;", "handler", "setDefaultItemHandler", "(Lcom/pspdfkit/ui/PopupToolbar$DefaultItemHandler;)V", "Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;", "item", "", "onItemClicked", "(Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;)Z", "Lcom/pspdfkit/ui/PdfFragment;", "getPdfFragment", "()Lcom/pspdfkit/ui/PdfFragment;", "Lcom/pspdfkit/internal/sw;", "popupToolbarView", "Lcom/pspdfkit/internal/sw;", "Landroid/widget/PopupWindow;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "value", "Lcom/pspdfkit/ui/PopupToolbar$OnPopupToolbarItemClickedListener;", "getOnPopupToolbarItemClickedListener", "()Lcom/pspdfkit/ui/PopupToolbar$OnPopupToolbarItemClickedListener;", "Landroid/view/View$OnLayoutChangeListener;", "lastOnLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "currentX", "F", "currentY", "currentPageIndex", "I", "isDismissed", "Z", "defaultItemHandler", "Lcom/pspdfkit/ui/PopupToolbar$DefaultItemHandler;", "getViewId", "()I", "viewId", "", "getMenuItems", "()Ljava/util/List;", "setMenuItems", "(Ljava/util/List;)V", "menuItems", "isShowing", "()Z", "Companion", "OnPopupToolbarItemClickedListener", "DefaultItemHandler", "OnPopupToolbarViewItemClickedListener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PopupToolbar {
    private int currentPageIndex;
    private float currentX;
    private float currentY;
    private DefaultItemHandler defaultItemHandler;
    private boolean isDismissed;
    private View.OnLayoutChangeListener lastOnLayoutChangeListener;
    private OnPopupToolbarItemClickedListener onPopupToolbarItemClickedListener;
    private final PdfFragment pdfFragment;
    private final sw popupToolbarView;
    private final PopupWindow popupWindow;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J.\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lcom/pspdfkit/ui/PopupToolbar$Companion;", "", "<init>", "()V", "hasSizeChanged", "", "oldWidth", "", "oldHeight", "newWidth", "newHeight", "shouldRecreatePopupWindowForSizeChange", "isFirstPopupLayoutPass", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean hasSizeChanged(int oldWidth, int oldHeight, int newWidth, int newHeight) {
            return (oldWidth == newWidth && oldHeight == newHeight) ? false : true;
        }

        public final boolean shouldRecreatePopupWindowForSizeChange(boolean isFirstPopupLayoutPass, int oldWidth, int oldHeight, int newWidth, int newHeight) {
            return hasSizeChanged(oldWidth, oldHeight, newWidth, newHeight) && !isFirstPopupLayoutPass;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/PopupToolbar$DefaultItemHandler;", "", "onItemClicked", "", "item", "Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface DefaultItemHandler {
        boolean onItemClicked(PopupToolbarMenuItem item);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/PopupToolbar$OnPopupToolbarItemClickedListener;", "", "onItemClicked", "", "popupToolbarMenuItem", "Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnPopupToolbarItemClickedListener {
        boolean onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/pspdfkit/ui/PopupToolbar$OnPopupToolbarViewItemClickedListener;", "Lcom/pspdfkit/internal/sw$a;", "<init>", "(Lcom/pspdfkit/ui/PopupToolbar;)V", "Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;", "popupToolbarMenuItem", "", "onItemClicked", "(Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;)V", "onOverflowItemClicked", "()V", "onBackItemClicked", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class OnPopupToolbarViewItemClickedListener implements sw.a {
        public OnPopupToolbarViewItemClickedListener() {
        }

        @Override // com.pspdfkit.internal.sw.a
        public void onBackItemClicked() {
            PopupToolbar.this.popupToolbarView.a();
        }

        @Override // com.pspdfkit.internal.sw.a
        public void onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem) {
            popupToolbarMenuItem.getClass();
            PopupToolbar.this.onItemClicked(popupToolbarMenuItem);
        }

        @Override // com.pspdfkit.internal.sw.a
        public void onOverflowItemClicked() {
            PopupToolbar.this.popupToolbarView.d();
        }
    }

    public PopupToolbar(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        this.pdfFragment = pdfFragment;
        sw swVar = new sw(pdfFragment.getContext());
        swVar.setId(getViewId());
        swVar.setOnPopupToolbarViewItemClickedListener(new OnPopupToolbarViewItemClickedListener());
        this.popupToolbarView = swVar;
        MAMPopupWindow mAMPopupWindow = new MAMPopupWindow(swVar, -2, -2);
        mAMPopupWindow.setAnimationStyle(R.style.PSPDFKit_PopupToolbarAnimation);
        mAMPopupWindow.setElevation(2 * Resources.getSystem().getDisplayMetrics().density);
        this.popupWindow = mAMPopupWindow;
    }

    private final int resolvePopupMaxWidth(int screenWidth, int floatingToolbarPadding) {
        Resources resources;
        int iMax = Math.max(0, screenWidth - (floatingToolbarPadding * 2));
        Context context = this.pdfFragment.getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        float dimension = resources.getDimension(R.dimen.pspdf__popup_toolbar_max_width);
        return dimension > 0.0f ? Math.min(iMax, (int) dimension) : iMax;
    }

    private final void restorePopupWindowWrapContentSizing() {
        this.popupWindow.setWidth(-2);
        this.popupWindow.setHeight(-2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(PopupToolbar popupToolbar, PointF pointF, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean[] zArr, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        view.getClass();
        if (popupToolbar.isDismissed) {
            return;
        }
        int i16 = i14 - i12;
        int i17 = i15 - i13;
        int i18 = i10 - i8;
        int i19 = i11 - i9;
        int i20 = i2 - i;
        int iMax = Math.max(i, Math.min(((int) pointF.x) - (i18 / 2), (i20 - i18) + i3));
        int i21 = i4 - i;
        int iMax2 = Math.max(i, Math.min(((int) pointF.y) - i19, (i21 - i19) + i5));
        if (view.getParent() == popupToolbar.pdfFragment.getView()) {
            int iMax3 = Math.max(i, Math.min(((int) pointF.x) - (i6 / 2), (i20 - i6) + i3));
            int iMax4 = Math.max(i, Math.min(((int) pointF.y) - i7, (i21 - i7) + i5));
            View view2 = popupToolbar.pdfFragment.getView();
            view2.getClass();
            ((ViewGroup) view2).removeView(view);
            view.setVisibility(0);
            popupToolbar.popupWindow.setWidth(i6);
            popupToolbar.popupWindow.setHeight(i7);
            popupToolbar.popupWindow.showAtLocation(popupToolbar.pdfFragment.getView(), 0, iMax3, iMax4);
            zArr[0] = true;
            return;
        }
        boolean z = zArr[0];
        zArr[0] = false;
        Companion companion = INSTANCE;
        if (!companion.hasSizeChanged(i16, i17, i18, i19)) {
            popupToolbar.popupWindow.update(iMax, iMax2, -1, -1, true);
            if (z) {
                popupToolbar.restorePopupWindowWrapContentSizing();
                return;
            }
            return;
        }
        boolean zShouldRecreatePopupWindowForSizeChange = companion.shouldRecreatePopupWindowForSizeChange(z, i16, i17, i18, i19);
        PopupWindow popupWindow = popupToolbar.popupWindow;
        if (zShouldRecreatePopupWindowForSizeChange) {
            popupWindow.setAnimationStyle(0);
            popupToolbar.popupWindow.dismiss();
            popupToolbar.popupWindow.showAtLocation(popupToolbar.pdfFragment.getView(), 0, iMax, iMax2);
            popupToolbar.popupWindow.setAnimationStyle(R.style.PSPDFKit_PopupToolbarAnimation);
            return;
        }
        popupWindow.update(iMax, iMax2, i18, i19, true);
        if (z) {
            popupToolbar.restorePopupWindowWrapContentSizing();
        }
    }

    public void dismiss() {
        this.popupWindow.dismiss();
        this.isDismissed = true;
    }

    public final List<PopupToolbarMenuItem> getMenuItems() {
        List<PopupToolbarMenuItem> menuItems = this.popupToolbarView.getMenuItems();
        menuItems.getClass();
        return menuItems;
    }

    public final OnPopupToolbarItemClickedListener getOnPopupToolbarItemClickedListener() {
        return this.onPopupToolbarItemClickedListener;
    }

    public final PdfFragment getPdfFragment() {
        return this.pdfFragment;
    }

    public final PopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    public int getViewId() {
        return R.id.pspdf__popup_toolbar;
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    public boolean onItemClicked(PopupToolbarMenuItem item) {
        item.getClass();
        OnPopupToolbarItemClickedListener onPopupToolbarItemClickedListener = this.onPopupToolbarItemClickedListener;
        if (onPopupToolbarItemClickedListener != null && onPopupToolbarItemClickedListener.onItemClicked(item)) {
            return true;
        }
        DefaultItemHandler defaultItemHandler = this.defaultItemHandler;
        if (defaultItemHandler != null) {
            return defaultItemHandler.onItemClicked(item);
        }
        return false;
    }

    public final void setDefaultItemHandler(DefaultItemHandler handler) {
        this.defaultItemHandler = handler;
    }

    public final void setMenuItems(List<? extends PopupToolbarMenuItem> list) {
        list.getClass();
        sw swVar = this.popupToolbarView;
        swVar.f = false;
        swVar.setOrientation(0);
        swVar.a(false);
        swVar.requestLayout();
        this.popupToolbarView.setMenuItems(list);
    }

    public final void setOnPopupToolbarItemClickedListener(OnPopupToolbarItemClickedListener onPopupToolbarItemClickedListener) {
        this.onPopupToolbarItemClickedListener = onPopupToolbarItemClickedListener;
    }

    public final void show(int pageIndex, float x, float y) {
        Context context;
        Resources resources;
        if (this.popupWindow.isShowing()) {
            return;
        }
        this.isDismissed = false;
        this.currentPageIndex = pageIndex;
        this.currentX = x;
        this.currentY = y;
        final PointF pointF = new PointF(x, y);
        this.pdfFragment.getViewProjection().toViewPoint(pointF, pageIndex);
        View view = this.pdfFragment.getView();
        if (view == null || (context = this.pdfFragment.getContext()) == null || (resources = context.getResources()) == null) {
            return;
        }
        final int dimension = (int) resources.getDimension(R.dimen.pspdf__popup_toolbar_edge_padding);
        final int width = view.getWidth();
        final int height = view.getHeight();
        int iResolvePopupMaxWidth = resolvePopupMaxWidth(width, dimension);
        int iMax = Math.max(0, height - (dimension * 2));
        this.popupToolbarView.setMaxWidthPx(iResolvePopupMaxWidth);
        final boolean[] zArr = new boolean[1];
        View.OnLayoutChangeListener onLayoutChangeListener = this.lastOnLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            this.popupToolbarView.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int i = iArr[1];
        final int i2 = iArr[0];
        pointF.y += i;
        pointF.x += i2;
        this.popupToolbarView.measure(View.MeasureSpec.makeMeasureSpec(iResolvePopupMaxWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iMax, Integer.MIN_VALUE));
        final int measuredWidth = this.popupToolbarView.getMeasuredWidth();
        final int measuredHeight = this.popupToolbarView.getMeasuredHeight();
        View.OnLayoutChangeListener onLayoutChangeListener2 = new View.OnLayoutChangeListener() { // from class: com.pspdfkit.ui.PopupToolbar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                PopupToolbar.show$lambda$0(this.f$0, pointF, dimension, width, i2, height, i, measuredWidth, measuredHeight, zArr, view2, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        };
        this.lastOnLayoutChangeListener = onLayoutChangeListener2;
        this.popupToolbarView.addOnLayoutChangeListener(onLayoutChangeListener2);
        this.popupWindow.setAnimationStyle(R.style.PSPDFKit_PopupToolbarAnimation);
        this.popupToolbarView.setVisibility(4);
        ViewParent parent = this.popupToolbarView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.popupToolbarView);
        }
        View view2 = this.pdfFragment.getView();
        ViewGroup viewGroup2 = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if (viewGroup2 != null) {
            viewGroup2.addView(this.popupToolbarView, -2, -2);
        }
    }

    public final void showAgain() {
        show(this.currentPageIndex, this.currentX, this.currentY);
    }
}
