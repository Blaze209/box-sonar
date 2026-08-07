package sdk.pendo.io.views.custom;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J4\u0010%\u001a\u00020&2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u001bJ\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0006\u00101\u001a\u00020\u001eJ\u0006\u00102\u001a\u00020&J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u001bH\u0002J\u0016\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020)J\b\u00108\u001a\u00020&H\u0002J\u000e\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\fJ\u0016\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020.J\u000e\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020&H\u0002J\u0018\u0010B\u001a\u00020&2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020)H\u0002R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lsdk/pendo/io/views/custom/PendoCarouselLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "actionCallback", "sdk/pendo/io/views/custom/PendoCarouselLayout$actionCallback$1", "Lsdk/pendo/io/views/custom/PendoCarouselLayout$actionCallback$1;", "indicatorBlockContainer", "Lsdk/pendo/io/views/custom/PendoLinearLayout;", "getIndicatorBlockContainer", "()Lsdk/pendo/io/views/custom/PendoLinearLayout;", "setIndicatorBlockContainer", "(Lsdk/pendo/io/views/custom/PendoLinearLayout;)V", "indicatorContainer", "Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;", "getIndicatorContainer$annotations", "()V", "getIndicatorContainer", "()Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;", "setIndicatorContainer", "(Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;)V", "mStepViewList", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "mViewPagerAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "<set-?>", "pagesContainer", "getPagesContainer", "()Landroid/widget/FrameLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "addFocusables", "", GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS, "direction", "", "focusableMode", "addStepView", "stepView", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "getAdapter", "init", "makeAccessibilityViewsFocusable", "view", "onPageSelected", "previousSelectedPage", "currentSelectedPage", "setAndActivateIndicator", "setAndActivateIndicatorContainerBlock", "viewLayout", "setCurrentItem", FirebaseAnalytics.Param.INDEX, "smoothScroll", "setOnPageChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "setupIndicatorFocusOrder", "updatePageSelectedIndicator", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoCarouselLayout extends FrameLayout {
    private final PendoCarouselLayout$actionCallback$1 actionCallback;
    private PendoLinearLayout indicatorBlockContainer;
    private PendoMultipleRowViewGroup indicatorContainer;
    private final ArrayList<View> mStepViewList;
    private final PagerAdapter mViewPagerAdapter;
    private FrameLayout pagesContainer;
    private ViewPager viewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1] */
    public PendoCarouselLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionCallback = new b1.a() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1
            @Override // sdk.pendo.io.s7.b1.a
            public boolean performActionOnView(View view, Bundle oBundle) {
                BaseIFrameVideoPlayer baseIFrameVideoPlayer = view instanceof BaseIFrameVideoPlayer ? (BaseIFrameVideoPlayer) view : null;
                if (baseIFrameVideoPlayer == null) {
                    return false;
                }
                baseIFrameVideoPlayer.stopVideo();
                return false;
            }
        };
        this.mStepViewList = new ArrayList<>();
        this.mViewPagerAdapter = new PagerAdapter() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$mViewPagerAdapter$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup container, int position, Object object) {
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(object, "object");
                container.removeView((View) this.this$0.mStepViewList.get(position));
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return this.this$0.mStepViewList.size();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public Object instantiateItem(ViewGroup container, int position) {
                Intrinsics.checkNotNullParameter(container, "container");
                container.addView((View) this.this$0.mStepViewList.get(position));
                Object obj = this.this$0.mStepViewList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return obj;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(View view, Object object) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(object, "object");
                return view == object;
            }
        };
        init();
    }

    public static /* synthetic */ void getIndicatorContainer$annotations() {
    }

    private final void makeAccessibilityViewsFocusable(View view) {
        TextView textView;
        CharSequence text;
        CharSequence contentDescription;
        if (view.getImportantForAccessibility() == 1 || (view.getImportantForAccessibility() == 0 && (view instanceof TextView) && !(view instanceof Button) && (((text = (textView = (TextView) view).getText()) != null && !StringsKt.isBlank(text)) || ((contentDescription = textView.getContentDescription()) != null && !StringsKt.isBlank(contentDescription))))) {
            view.setFocusable(true);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                makeAccessibilityViewsFocusable(childAt);
            }
        }
    }

    private final void setAndActivateIndicator() {
        View childAt;
        PendoMultipleRowViewGroup pendoMultipleRowViewGroup = this.indicatorContainer;
        if (pendoMultipleRowViewGroup == null || (childAt = pendoMultipleRowViewGroup.getChildAt(0)) == null) {
            return;
        }
        Intrinsics.checkNotNull(childAt);
        ((PendoCarouselIndicatorView) childAt).setChecked(true);
    }

    private final void setupIndicatorFocusOrder() {
        PendoMultipleRowViewGroup pendoMultipleRowViewGroup = this.indicatorContainer;
        if (pendoMultipleRowViewGroup != null) {
            int childCount = pendoMultipleRowViewGroup.getChildCount();
            for (final int i = 0; i < childCount; i++) {
                View childAt = pendoMultipleRowViewGroup.getChildAt(i);
                PendoCarouselIndicatorView pendoCarouselIndicatorView = childAt instanceof PendoCarouselIndicatorView ? (PendoCarouselIndicatorView) childAt : null;
                if (pendoCarouselIndicatorView != null) {
                    pendoCarouselIndicatorView.setFocusable(true);
                    pendoCarouselIndicatorView.setFocusableInTouchMode(false);
                    pendoCarouselIndicatorView.setOnClickListener(new View.OnClickListener() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PendoCarouselLayout.setupIndicatorFocusOrder$lambda$4$lambda$2(this.f$0, i, view);
                        }
                    });
                    pendoCarouselIndicatorView.setOnKeyListener(new View.OnKeyListener() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                            return PendoCarouselLayout.setupIndicatorFocusOrder$lambda$4$lambda$3(this.f$0, i, view, i2, keyEvent);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIndicatorFocusOrder$lambda$4$lambda$2(PendoCarouselLayout this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setCurrentItem(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupIndicatorFocusOrder$lambda$4$lambda$3(PendoCarouselLayout this$0, int i, View view, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 1) {
            return false;
        }
        if (i2 != 66 && i2 != 62 && i2 != 23) {
            return false;
        }
        this$0.setCurrentItem(i, true);
        return true;
    }

    private final void updatePageSelectedIndicator(int previousSelectedPage, int currentSelectedPage) {
        PendoMultipleRowViewGroup pendoMultipleRowViewGroup = this.indicatorContainer;
        if (pendoMultipleRowViewGroup != null) {
            View childAt = pendoMultipleRowViewGroup.getChildAt(previousSelectedPage);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoCarouselIndicatorView");
            View childAt2 = pendoMultipleRowViewGroup.getChildAt(currentSelectedPage);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoCarouselIndicatorView");
            ((PendoCarouselIndicatorView) childAt).setChecked(false);
            ((PendoCarouselIndicatorView) childAt2).setChecked(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        if (views == null) {
            return;
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.addFocusables(views, direction, focusableMode);
        }
        PendoLinearLayout pendoLinearLayout = this.indicatorBlockContainer;
        if (pendoLinearLayout != null) {
            pendoLinearLayout.addFocusables(views, direction, focusableMode);
        }
    }

    public final void addStepView(View stepView) {
        Intrinsics.checkNotNullParameter(stepView, "stepView");
        this.mStepViewList.add(stepView);
        makeAccessibilityViewsFocusable(stepView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event != null && event.getKeyCode() == 61) {
            int action = event.getAction();
            if (action == 0) {
                View viewFindFocus = findFocus();
                int i = event.isShiftPressed() ? 1 : 2;
                View viewFocusSearch = focusSearch(viewFindFocus, i);
                if (viewFocusSearch == null) {
                    return super.dispatchKeyEvent(event);
                }
                viewFocusSearch.requestFocus(i);
                return true;
            }
            if (action == 1) {
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    /* JADX INFO: renamed from: getAdapter, reason: from getter */
    public final PagerAdapter getMViewPagerAdapter() {
        return this.mViewPagerAdapter;
    }

    public final PendoLinearLayout getIndicatorBlockContainer() {
        return this.indicatorBlockContainer;
    }

    public final PendoMultipleRowViewGroup getIndicatorContainer() {
        return this.indicatorContainer;
    }

    public final FrameLayout getPagesContainer() {
        return this.pagesContainer;
    }

    public final void init() {
        ViewPager viewPager = new ViewPager(getContext());
        this.viewPager = viewPager;
        Intrinsics.checkNotNull(viewPager);
        viewPager.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.pagesContainer = frameLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewPager viewPager2 = this.viewPager;
        Intrinsics.checkNotNull(viewPager2);
        viewPager2.addView(this.pagesContainer);
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.setAdapter(this.mViewPagerAdapter);
        }
        addView(this.viewPager);
    }

    public final void onPageSelected(int previousSelectedPage, int currentSelectedPage) {
        updatePageSelectedIndicator(previousSelectedPage, currentSelectedPage);
        b1 b1Var = b1.a;
        View view = this.mStepViewList.get(previousSelectedPage);
        Intrinsics.checkNotNullExpressionValue(view, "get(...)");
        b1Var.a(view, this.actionCallback, BaseIFrameVideoPlayer.class);
    }

    public final void setAndActivateIndicatorContainerBlock(PendoLinearLayout viewLayout) {
        View childAt;
        Intrinsics.checkNotNullParameter(viewLayout, "viewLayout");
        this.indicatorBlockContainer = viewLayout;
        if (viewLayout != null && (childAt = viewLayout.getChildAt(0)) != null) {
            Intrinsics.checkNotNull(childAt);
            PendoMultipleRowViewGroup pendoMultipleRowViewGroup = (PendoMultipleRowViewGroup) childAt;
            pendoMultipleRowViewGroup.setSingleRow(true);
            this.indicatorContainer = pendoMultipleRowViewGroup;
            setAndActivateIndicator();
            setupIndicatorFocusOrder();
        }
        addView(this.indicatorBlockContainer);
    }

    public final void setCurrentItem(int index, boolean smoothScroll) {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(index, smoothScroll);
        }
    }

    public final void setIndicatorBlockContainer(PendoLinearLayout pendoLinearLayout) {
        this.indicatorBlockContainer = pendoLinearLayout;
    }

    public final void setIndicatorContainer(PendoMultipleRowViewGroup pendoMultipleRowViewGroup) {
        this.indicatorContainer = pendoMultipleRowViewGroup;
    }

    public final void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1] */
    public PendoCarouselLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionCallback = new b1.a() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$actionCallback$1
            @Override // sdk.pendo.io.s7.b1.a
            public boolean performActionOnView(View view, Bundle oBundle) {
                BaseIFrameVideoPlayer baseIFrameVideoPlayer = view instanceof BaseIFrameVideoPlayer ? (BaseIFrameVideoPlayer) view : null;
                if (baseIFrameVideoPlayer == null) {
                    return false;
                }
                baseIFrameVideoPlayer.stopVideo();
                return false;
            }
        };
        this.mStepViewList = new ArrayList<>();
        this.mViewPagerAdapter = new PagerAdapter() { // from class: sdk.pendo.io.views.custom.PendoCarouselLayout$mViewPagerAdapter$1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup container, int position, Object object) {
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(object, "object");
                container.removeView((View) this.this$0.mStepViewList.get(position));
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return this.this$0.mStepViewList.size();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public Object instantiateItem(ViewGroup container, int position) {
                Intrinsics.checkNotNullParameter(container, "container");
                container.addView((View) this.this$0.mStepViewList.get(position));
                Object obj = this.this$0.mStepViewList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return obj;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(View view, Object object) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(object, "object");
                return view == object;
            }
        };
        init();
    }
}
