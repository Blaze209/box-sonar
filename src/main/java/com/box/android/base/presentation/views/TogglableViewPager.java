package com.box.android.base.presentation.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes9.dex */
public class TogglableViewPager extends ViewPager {
    private static final String EXTRA_ORIGINAL_SAVED_INSTANCE = "com.box.extraOriginalSavedInstance";
    private static final String EXTRA_VIEW_PAGING_ENABLED = "com.box.extraViewPagingEnabled";
    private boolean mEnabled;

    public TogglableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnabled = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPagingEnabled(boolean z) {
        this.mEnabled = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ORIGINAL_SAVED_INSTANCE, parcelableOnSaveInstanceState);
        bundle.putBoolean(EXTRA_VIEW_PAGING_ENABLED, this.mEnabled);
        return bundle;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mEnabled = bundle.getBoolean(EXTRA_VIEW_PAGING_ENABLED);
            super.onRestoreInstanceState(bundle.getParcelable(EXTRA_ORIGINAL_SAVED_INSTANCE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
