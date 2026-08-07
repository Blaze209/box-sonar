package com.pspdfkit.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfFocusRelativeLayout extends MAMRelativeLayout {
    private static final int[] focusableIds = {R.id.pspdf__toolbar_coordinator, R.id.pspdf__activity_tab_bar, R.id.pspdf__activity_fragment_container, R.id.pspdf__redaction_view, R.id.pspdf__navigate_back, R.id.pspdf__navigate_forward, R.id.pspdf__activity_thumbnail_bar};
    private List<ViewGroup> focusList;
    private final Rect tempRect;

    public PdfFocusRelativeLayout(Context context) {
        super(context);
        this.tempRect = new Rect();
    }

    private void buildFocusList() {
        if (this.focusList == null) {
            this.focusList = new ArrayList();
            for (int i : focusableIds) {
                ViewGroup viewGroup = (ViewGroup) findViewById(i);
                if (viewGroup != null) {
                    this.focusList.add(viewGroup);
                }
            }
        }
    }

    private ViewGroup findDirectChildView(View view) {
        for (ViewGroup viewGroup : this.focusList) {
            if (isChildOfParent(view, viewGroup)) {
                return viewGroup;
            }
        }
        return null;
    }

    private boolean isChildOfParent(View view, View view2) {
        if (view == view2) {
            return true;
        }
        while (view.getParent() != null && (view.getParent() instanceof View)) {
            if (view.getParent() == view2) {
                return true;
            }
            view = (View) view.getParent();
        }
        return false;
    }

    private boolean isViewVisible(View view) {
        if (view.getVisibility() == 0 && view.getAlpha() != 0.0f) {
            return view.getGlobalVisibleRect(this.tempRect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        buildFocusList();
        ViewGroup viewGroupFindDirectChildView = findDirectChildView(view);
        if (viewGroupFindDirectChildView == null) {
            return super.focusSearch(view, i);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pspdf__activity_fragment_container);
        if (viewFindNextFocus == null && viewGroup != null && (i == 33 || i == 130 || i == 17 || i == 66)) {
            return FocusFinder.getInstance().findNextFocus(viewGroup, null, 2);
        }
        int size = 1;
        if (i != 2) {
            if (i != 1) {
                return super.focusSearch(view, i);
            }
            size = this.focusList.size() - 1;
        }
        int iIndexOf = this.focusList.indexOf(viewGroupFindDirectChildView);
        int size2 = (iIndexOf + size) % this.focusList.size();
        while (size2 != iIndexOf) {
            ViewGroup viewGroup2 = this.focusList.get(size2);
            if (isViewVisible(viewGroup2)) {
                if (viewGroup2.getId() == R.id.pspdf__activity_fragment_container) {
                    return super.focusSearch(view, i);
                }
                View viewFindNextFocus2 = FocusFinder.getInstance().findNextFocus(viewGroup2, null, i);
                if (viewFindNextFocus2 != null) {
                    return viewFindNextFocus2;
                }
            }
            size2 = (size2 + size) % this.focusList.size();
        }
        return super.focusSearch(view, i);
    }

    public PdfFocusRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect = new Rect();
    }

    public PdfFocusRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tempRect = new Rect();
    }

    public PdfFocusRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.tempRect = new Rect();
    }
}
