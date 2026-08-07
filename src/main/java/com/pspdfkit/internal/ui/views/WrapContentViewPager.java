package com.pspdfkit.internal.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/pspdfkit/internal/ui/views/WrapContentViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "getPagingEnabled", "()Z", "setPagingEnabled", "(Z)V", "pagingEnabled", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WrapContentViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public boolean pagingEnabled;

    public static final class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            WrapContentViewPager.this.requestLayout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentViewPager(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        context.getClass();
    }

    public final boolean getPagingEnabled() {
        return this.pagingEnabled;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int i, int i2) {
        if (getChildCount() == 0) {
            super.onMeasure(i, i2);
        }
        int childCount = getChildCount();
        int iMax = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            iMax = Math.max(iMax, childAt.getMeasuredHeight());
            if (i3 == getCurrentItem()) {
                iMax = childAt.getMeasuredHeight();
            }
        }
        if (iMax != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        if (this.pagingEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void setPagingEnabled(boolean z) {
        this.pagingEnabled = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        this.pagingEnabled = true;
        addOnPageChangeListener(new a());
    }

    public /* synthetic */ WrapContentViewPager(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
