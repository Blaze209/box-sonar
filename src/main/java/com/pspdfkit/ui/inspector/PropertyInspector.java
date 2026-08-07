package com.pspdfkit.ui.inspector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.R;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.ip;
import com.pspdfkit.internal.o8;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wc;
import com.pspdfkit.internal.y70;
import com.pspdfkit.internal.yq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyInspector extends MAMViewGroup implements o8, PropertyInspectorController, View.OnClickListener, PropertyInspectorTitleButtonListener {
    private static final int DETAIL_VIEW_ANIMATION_DURATION_MS = 250;
    private static final int FADE_ANIMATION_DURATION_MS = 300;
    private View activeDetailView;
    private int bottomInset;
    private OnCancelListener cancelListener;
    private boolean cancelOnTouchOutside;
    private final FrameLayout containerSwitcher;
    private PropertyInspectorTitleButtonListener currentInspectorTitleButtonListener;
    private wc.a currentInspectorTitleStyle;
    private final wc.a defaultTitleStyle;
    private NestedScrollView detailScrollView;
    private final NestedScrollView inspectorScrollView;
    private InspectorViewsContainer inspectorViewsContainer;
    private final List<ItemDecoration> itemDecorations;
    private int maximumHeight;
    private int minimumHeight;
    private wc propertyInspectorTitle;
    private boolean showingDetailView;
    private final dx style;
    private int suggestedHeight;
    private final List<PropertyInspectorView> views;

    public enum DetailViewAnimation {
        NONE,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public static class InspectorNestedScrollView extends NestedScrollView {
        public InspectorNestedScrollView(Context context) {
            super(context);
        }

        @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
        public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
            if ((view instanceof ScrollingView) && i2 < 0 && view.canScrollVertically(-1)) {
                return;
            }
            super.onNestedPreScroll(view, i, i2, iArr, i3);
        }
    }

    public static abstract class ItemDecoration {
        public void getItemOffsets(Rect rect, PropertyInspectorView propertyInspectorView, PropertyInspector propertyInspector) {
            rect.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas canvas, PropertyInspector propertyInspector) {
        }

        public void onDrawOver(Canvas canvas, PropertyInspector propertyInspector) {
        }
    }

    public interface OnCancelListener {
        void onCancel(PropertyInspector propertyInspector);
    }

    public interface OnInspectorTitleButtonClickListener {
        void onBackButtonClicked();

        void onCloseButtonClicked();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.inspector.PropertyInspector.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        SparseArray<Parcelable> inspectorViewsState;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSparseArray(this.inspectorViewsState);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.inspectorViewsState = parcel.readSparseArray(PropertyInspector.class.getClassLoader());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyInspector(Context context) {
        super(new ContextThemeWrapper(context, f60.b(context, ex.b, ex.c)));
        int[] iArr = ex.a;
        context.getClass();
        this.currentInspectorTitleButtonListener = null;
        this.currentInspectorTitleStyle = null;
        this.views = new ArrayList();
        this.itemDecorations = new ArrayList();
        this.suggestedHeight = Integer.MAX_VALUE;
        this.minimumHeight = 0;
        this.maximumHeight = 0;
        this.cancelOnTouchOutside = false;
        this.defaultTitleStyle = new yq(getContext());
        this.style = new dx(getContext());
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        createTitleView();
        this.inspectorViewsContainer = createContainerLayout();
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.containerSwitcher = frameLayout;
        frameLayout.addView(this.inspectorViewsContainer);
        InspectorNestedScrollView inspectorNestedScrollView = new InspectorNestedScrollView(getContext());
        this.inspectorScrollView = inspectorNestedScrollView;
        inspectorNestedScrollView.setFillViewport(true);
        inspectorNestedScrollView.addView(frameLayout);
        inspectorNestedScrollView.setNestedScrollingEnabled(true);
        addView(inspectorNestedScrollView);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void applyEnterAnimation(View view, DetailViewAnimation detailViewAnimation) {
        uw.a(detailViewAnimation, "animationType", null);
        view.animate().cancel();
        view.setVisibility(0);
        if (detailViewAnimation == DetailViewAnimation.NONE) {
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
            return;
        }
        view.animate().setInterpolator(new DecelerateInterpolator()).setDuration(250L);
        int width = getWidth() / 2;
        if (detailViewAnimation == DetailViewAnimation.LEFT_TO_RIGHT) {
            width = -width;
        }
        view.setTranslationX(width);
        view.animate().translationX(0.0f);
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f);
    }

    private void applyLeaveAnimation(final View view, DetailViewAnimation detailViewAnimation) {
        uw.a(detailViewAnimation, "animationType", null);
        view.animate().cancel();
        if (detailViewAnimation == DetailViewAnimation.NONE) {
            view.setVisibility(8);
            return;
        }
        view.animate().setInterpolator(new DecelerateInterpolator()).setDuration(250L);
        int width = getWidth() / 2;
        view.setTranslationX(0.0f);
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        if (detailViewAnimation != DetailViewAnimation.LEFT_TO_RIGHT) {
            width = -width;
        }
        viewPropertyAnimatorAnimate.translationX(width);
        view.setAlpha(1.0f);
        view.animate().alpha(0.0f);
        view.animate().withEndAction(new Runnable() { // from class: com.pspdfkit.ui.inspector.PropertyInspector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PropertyInspector.lambda$applyLeaveAnimation$2(view);
            }
        });
    }

    private InspectorViewsContainer createContainerLayout() {
        InspectorViewsContainer inspectorViewsContainer = new InspectorViewsContainer(getContext(), this);
        inspectorViewsContainer.setPadding(0, 0, 0, this.style.f / 2);
        inspectorViewsContainer.setClickable(false);
        return inspectorViewsContainer;
    }

    private void createTitleView() {
        wc wcVar = new wc(getContext(), this.defaultTitleStyle);
        this.propertyInspectorTitle = wcVar;
        wcVar.setId(R.id.pspdf__bottom_sheet_drag_to_resize_view);
        this.propertyInspectorTitle.setBackButtonOnClickListener(this);
        this.propertyInspectorTitle.setCloseButtonOnClickListener(this);
        this.propertyInspectorTitle.setCloseButtonVisible(true);
        this.propertyInspectorTitle.setClickable(true);
        this.propertyInspectorTitle.setFocusable(true);
        addView(this.propertyInspectorTitle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$applyLeaveAnimation$2(View view) {
        view.setVisibility(8);
        if (view instanceof PropertyInspectorView) {
            ((PropertyInspectorView) view).onHidden();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureFullyVisible$1(View view) {
        Rect rect = new Rect();
        this.inspectorScrollView.getDrawingRect(rect);
        if (rect.top > view.getY() || rect.bottom < view.getY() + view.getHeight()) {
            this.inspectorScrollView.smoothScrollTo(0, (int) view.getY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setInspectorViews$0(InspectorViewsContainer inspectorViewsContainer) {
        this.containerSwitcher.removeView(inspectorViewsContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateTitleStyleForDetailView(View view) {
        boolean z = view instanceof PropertyInspectorViewTitleStyleProvider;
        wc wcVar = this.propertyInspectorTitle;
        if (z) {
            wcVar.a(((PropertyInspectorViewTitleStyleProvider) view).getDialogTitleStyle(this.defaultTitleStyle));
        } else {
            wcVar.a(this.defaultTitleStyle);
        }
    }

    public void addInspectorView(PropertyInspectorView propertyInspectorView) {
        addInspectorView(propertyInspectorView, this.inspectorViewsContainer.getChildCount());
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        uw.a(itemDecoration, "decoration", null);
        if (this.itemDecorations.isEmpty()) {
            this.inspectorViewsContainer.setWillNotDraw(false);
        }
        if (this.itemDecorations.contains(itemDecoration)) {
            return;
        }
        List<ItemDecoration> list = this.itemDecorations;
        if (i < 0) {
            list.add(itemDecoration);
        } else {
            list.add(i, itemDecoration);
        }
        invalidate();
    }

    public void cancel() {
        OnCancelListener onCancelListener = this.cancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    public boolean checkDetailViewBackButtonClicked() {
        KeyEvent.Callback callback = this.activeDetailView;
        if (callback instanceof PropertyInspectorTitleButtonListener) {
            return ((PropertyInspectorTitleButtonListener) callback).onBackButtonClicked();
        }
        return false;
    }

    public boolean checkDetailViewCloseButtonClicked() {
        KeyEvent.Callback callback = this.activeDetailView;
        if (callback instanceof PropertyInspectorTitleButtonListener) {
            return ((PropertyInspectorTitleButtonListener) callback).onCloseButtonClicked();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.showingDetailView;
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            if (z) {
                hideDetailView(true);
            } else {
                cancel();
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View viewFindFocus = findFocus();
            if (viewFindFocus instanceof EditText) {
                Rect rect = new Rect();
                viewFindFocus.getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    viewFindFocus.clearFocus();
                    hn.c(viewFindFocus);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorController
    public void ensureFullyVisible(PropertyInspectorView propertyInspectorView) {
        final View view = propertyInspectorView.getView();
        getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.inspector.PropertyInspector$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.lambda$ensureFullyVisible$1(view);
            }
        }));
    }

    public PropertyInspectorView getInspectorView(int i) {
        return this.views.get(i);
    }

    public int getInspectorViewCount() {
        return this.views.size();
    }

    public List<ItemDecoration> getItemDecorations() {
        return this.itemDecorations;
    }

    @Override // com.pspdfkit.internal.o8
    public int getMaximumHeight() {
        return this.maximumHeight;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return this.minimumHeight;
    }

    public int getSuggestedHeight() {
        return this.suggestedHeight;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorController
    public View getVisibleDetailView() {
        if (this.showingDetailView) {
            return this.activeDetailView;
        }
        return null;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorController
    public void hideDetailView(boolean z) {
        if (this.activeDetailView == null || this.detailScrollView == null || !this.showingDetailView) {
            return;
        }
        this.showingDetailView = false;
        this.inspectorScrollView.bringToFront();
        this.detailScrollView.setNestedScrollingEnabled(false);
        this.inspectorScrollView.setNestedScrollingEnabled(true);
        applyLeaveAnimation(this.detailScrollView, z ? DetailViewAnimation.LEFT_TO_RIGHT : DetailViewAnimation.NONE);
        applyEnterAnimation(this.inspectorScrollView, z ? DetailViewAnimation.LEFT_TO_RIGHT : DetailViewAnimation.NONE);
        this.propertyInspectorTitle.a(this.defaultTitleStyle);
        this.propertyInspectorTitle.a(false, z);
        wc wcVar = this.propertyInspectorTitle;
        String str = wcVar.f;
        if (str != null) {
            wcVar.setTitle(str);
        }
        KeyEvent.Callback callback = this.activeDetailView;
        if (callback instanceof PropertyInspectorView) {
            ((PropertyInspectorView) callback).onHidden();
        }
    }

    public int indexOfInspectorView(PropertyInspectorView propertyInspectorView) {
        return this.views.indexOf(propertyInspectorView);
    }

    public boolean isCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onBackButtonClicked() {
        PropertyInspectorTitleButtonListener propertyInspectorTitleButtonListener;
        boolean zCheckDetailViewBackButtonClicked = checkDetailViewBackButtonClicked();
        if (!zCheckDetailViewBackButtonClicked && (propertyInspectorTitleButtonListener = this.currentInspectorTitleButtonListener) != null) {
            zCheckDetailViewBackButtonClicked = propertyInspectorTitleButtonListener.onBackButtonClicked();
        }
        if (!zCheckDetailViewBackButtonClicked) {
            hideDetailView(true);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.propertyInspectorTitle.getBackButton()) {
            onBackButtonClicked();
        } else if (view == this.propertyInspectorTitle.getCloseButton()) {
            onCloseButtonClicked();
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onCloseButtonClicked() {
        PropertyInspectorTitleButtonListener propertyInspectorTitleButtonListener;
        boolean zCheckDetailViewCloseButtonClicked = checkDetailViewCloseButtonClicked();
        if (!zCheckDetailViewCloseButtonClicked && (propertyInspectorTitleButtonListener = this.currentInspectorTitleButtonListener) != null) {
            zCheckDetailViewCloseButtonClicked = propertyInspectorTitleButtonListener.onCloseButtonClicked();
        }
        if (zCheckDetailViewCloseButtonClicked) {
            return true;
        }
        cancel();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt == this.inspectorScrollView || childAt == this.detailScrollView) {
                int measuredHeight = this.propertyInspectorTitle.getVisibility() != 8 ? this.propertyInspectorTitle.getMeasuredHeight() : 0;
                childAt.layout(0, measuredHeight, childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + measuredHeight);
            } else if (childAt == this.propertyInspectorTitle) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int suggestedHeight = 0;
        int titleHeight = this.propertyInspectorTitle.getVisibility() != 8 ? this.propertyInspectorTitle.getTitleHeight() : 0;
        int i6 = (size - titleHeight) - this.bottomInset;
        this.propertyInspectorTitle.measure(i, View.MeasureSpec.makeMeasureSpec(titleHeight, 1073741824));
        this.inspectorScrollView.measure(i, View.MeasureSpec.makeMeasureSpec(i6, mode));
        int measuredHeight2 = this.inspectorScrollView.getMeasuredHeight();
        NestedScrollView nestedScrollView = this.detailScrollView;
        if (nestedScrollView == null || !this.showingDetailView) {
            measuredHeight = 0;
        } else {
            nestedScrollView.measure(i, View.MeasureSpec.makeMeasureSpec(i6, mode));
            measuredHeight = this.detailScrollView.getMeasuredHeight();
        }
        if (this.showingDetailView) {
            KeyEvent.Callback visibleDetailView = getVisibleDetailView();
            if (visibleDetailView instanceof PropertyInspectorView) {
                PropertyInspectorView propertyInspectorView = (PropertyInspectorView) visibleDetailView;
                int propertyInspectorMinHeight = propertyInspectorView.getPropertyInspectorMinHeight();
                int propertyInspectorMaxHeight = propertyInspectorView.getPropertyInspectorMaxHeight();
                int measuredHeight3 = propertyInspectorView.getView().getMeasuredHeight();
                int suggestedHeight2 = propertyInspectorView.getSuggestedHeight();
                i3 = propertyInspectorMinHeight;
                suggestedHeight = suggestedHeight2;
                i5 = propertyInspectorMaxHeight;
                i4 = measuredHeight3;
            } else {
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
        } else {
            int measuredHeight4 = 0;
            int iMax = 0;
            int iMax2 = 0;
            for (PropertyInspectorView propertyInspectorView2 : this.views) {
                iMax2 = Math.max(propertyInspectorView2.getPropertyInspectorMinHeight(), iMax2);
                iMax = Math.max(propertyInspectorView2.getPropertyInspectorMaxHeight(), iMax);
                measuredHeight4 += propertyInspectorView2.getView().getMeasuredHeight();
                suggestedHeight += propertyInspectorView2.getSuggestedHeight();
            }
            int verticalInset = this.inspectorViewsContainer.getVerticalInset() + this.inspectorScrollView.getScrollBarSize();
            i3 = iMax2 + verticalInset;
            i5 = iMax + verticalInset;
            i4 = measuredHeight4 + verticalInset;
            suggestedHeight += verticalInset;
        }
        int iA = ip.a(titleHeight * 2, i3 + titleHeight);
        int i7 = this.bottomInset;
        int i8 = iA + i7;
        this.minimumHeight = i8;
        this.suggestedHeight = ip.a(i8, suggestedHeight + titleHeight + i7);
        this.maximumHeight = ip.a(this.minimumHeight, ip.a(i4, i5) + titleHeight + this.bottomInset, this.suggestedHeight);
        if (mode == 1073741824) {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), size);
            return;
        }
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        if (this.showingDetailView) {
            measuredHeight2 = measuredHeight;
        }
        setMeasuredDimension(defaultSize, Math.max(titleHeight + measuredHeight2 + this.bottomInset, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.inspectorViewsState != null) {
            for (int i = 0; i < getInspectorViewCount(); i++) {
                if (getInspectorView(i).isViewStateRestorationEnabled()) {
                    getInspectorView(i).getView().restoreHierarchyState(savedState.inspectorViewsState);
                }
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.inspectorViewsState = new SparseArray<>();
        for (int i = 0; i < getInspectorViewCount(); i++) {
            if (getInspectorView(i).isViewStateRestorationEnabled()) {
                getInspectorView(i).getView().saveHierarchyState(savedState.inspectorViewsState);
            }
        }
        return savedState;
    }

    public void removeAllInspectorViews() {
        for (PropertyInspectorView propertyInspectorView : this.views) {
            propertyInspectorView.onHidden();
            propertyInspectorView.unbindController();
            this.inspectorViewsContainer.removeView(propertyInspectorView.getView());
        }
        this.views.clear();
        this.suggestedHeight = Integer.MAX_VALUE;
    }

    public void removeAllItemDecorations() {
        this.itemDecorations.clear();
        this.inspectorViewsContainer.setWillNotDraw(true);
        invalidate();
    }

    public void removeInspectorView(PropertyInspectorView propertyInspectorView) {
        propertyInspectorView.onHidden();
        propertyInspectorView.unbindController();
        this.views.remove(propertyInspectorView);
        this.inspectorViewsContainer.removeView(propertyInspectorView.getView());
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        uw.a(itemDecoration, "decoration", null);
        this.itemDecorations.remove(itemDecoration);
        if (this.itemDecorations.isEmpty()) {
            this.inspectorViewsContainer.setWillNotDraw(true);
        }
        invalidate();
    }

    public void reset() {
        removeAllInspectorViews();
        removeAllItemDecorations();
        if (this.activeDetailView != null) {
            hideDetailView(false);
            NestedScrollView nestedScrollView = this.detailScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.removeView(this.activeDetailView);
            }
            this.activeDetailView = null;
        }
    }

    public void setBottomInset(int i) {
        if (this.bottomInset == i) {
            return;
        }
        this.bottomInset = i;
        requestLayout();
    }

    public void setCancelListener(OnCancelListener onCancelListener) {
        this.cancelListener = onCancelListener;
    }

    public void setCancelOnTouchOutside(boolean z) {
        this.cancelOnTouchOutside = z;
    }

    public void setInspectorViews(List<PropertyInspectorView> list, boolean z) {
        setInspectorViews(list, z, null, null);
    }

    public void setTitle(String str) {
        uw.a(str, "title", null);
        this.propertyInspectorTitle.setTitle(str);
    }

    public void setTitleBarVisible(boolean z) {
        this.propertyInspectorTitle.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pspdfkit.ui.inspector.PropertyInspectorController
    public void showDetailView(View view, String str, boolean z) {
        KeyEvent.Callback callback = this.activeDetailView;
        if (callback != view || this.detailScrollView == null) {
            if (callback != null) {
                if (callback instanceof PropertyInspectorView) {
                    ((PropertyInspectorView) callback).unbindController();
                }
                NestedScrollView nestedScrollView = this.detailScrollView;
                if (nestedScrollView != null) {
                    nestedScrollView.removeView(this.activeDetailView);
                }
            }
            if (this.detailScrollView == null) {
                InspectorNestedScrollView inspectorNestedScrollView = new InspectorNestedScrollView(getContext());
                this.detailScrollView = inspectorNestedScrollView;
                inspectorNestedScrollView.setFillViewport(true);
                addView(this.detailScrollView);
            }
            this.activeDetailView = view;
            if (view instanceof PropertyInspectorView) {
                ((PropertyInspectorView) view).bindController(this);
            }
            this.detailScrollView.addView(view);
        }
        updateTitleStyleForDetailView(view);
        this.showingDetailView = true;
        this.detailScrollView.bringToFront();
        this.detailScrollView.setNestedScrollingEnabled(true);
        this.inspectorScrollView.setNestedScrollingEnabled(false);
        applyLeaveAnimation(this.inspectorScrollView, z ? DetailViewAnimation.RIGHT_TO_LEFT : DetailViewAnimation.NONE);
        applyEnterAnimation(this.detailScrollView, z ? DetailViewAnimation.RIGHT_TO_LEFT : DetailViewAnimation.NONE);
        this.propertyInspectorTitle.a(true, z);
        if (str != null) {
            this.propertyInspectorTitle.setDetailTitle(str);
        }
        KeyEvent.Callback callback2 = this.activeDetailView;
        if (callback2 instanceof PropertyInspectorView) {
            ((PropertyInspectorView) callback2).onShown();
        }
    }

    public void addInspectorView(PropertyInspectorView propertyInspectorView, int i) {
        this.views.add(i, propertyInspectorView);
        if (propertyInspectorView.getView().getLayoutParams() != null) {
            this.inspectorViewsContainer.addView(propertyInspectorView.getView(), i);
        } else {
            this.inspectorViewsContainer.addView(propertyInspectorView.getView(), i, new LinearLayout.LayoutParams(-1, -2));
        }
        propertyInspectorView.bindController(this);
        propertyInspectorView.onShown();
    }

    public void setInspectorViews(List<PropertyInspectorView> list, boolean z, PropertyInspectorTitleButtonListener propertyInspectorTitleButtonListener, PropertyInspectorViewTitleStyleProvider propertyInspectorViewTitleStyleProvider) {
        wc.a dialogTitleStyle = this.defaultTitleStyle;
        if (propertyInspectorViewTitleStyleProvider != null) {
            dialogTitleStyle = propertyInspectorViewTitleStyleProvider.getDialogTitleStyle(dialogTitleStyle);
        }
        this.currentInspectorTitleStyle = dialogTitleStyle;
        this.propertyInspectorTitle.a(dialogTitleStyle);
        if (this.showingDetailView && this.activeDetailView != null) {
            removeAllInspectorViews();
            hideDetailView(z);
        } else if (!z || getInspectorViewCount() <= 0) {
            removeAllInspectorViews();
        } else {
            final InspectorViewsContainer inspectorViewsContainer = this.inspectorViewsContainer;
            InspectorViewsContainer inspectorViewsContainerCreateContainerLayout = createContainerLayout();
            this.inspectorViewsContainer = inspectorViewsContainerCreateContainerLayout;
            this.containerSwitcher.addView(inspectorViewsContainerCreateContainerLayout);
            inspectorViewsContainer.animate().alpha(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.inspector.PropertyInspector$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setInspectorViews$0(inspectorViewsContainer);
                }
            });
            this.inspectorViewsContainer.setAlpha(0.0f);
            this.inspectorViewsContainer.animate().alpha(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator());
            this.suggestedHeight = Integer.MAX_VALUE;
            this.views.clear();
        }
        Iterator<PropertyInspectorView> it = list.iterator();
        while (it.hasNext()) {
            addInspectorView(it.next());
        }
        this.currentInspectorTitleButtonListener = propertyInspectorTitleButtonListener;
        this.inspectorScrollView.smoothScrollTo(0, 0);
    }

    public void setTitle(int i) {
        this.propertyInspectorTitle.setTitle(i);
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }
}
