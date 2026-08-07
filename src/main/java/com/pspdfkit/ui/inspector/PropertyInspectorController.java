package com.pspdfkit.ui.inspector;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface PropertyInspectorController extends PropertyInspectorTitleButtonListener {
    void ensureFullyVisible(PropertyInspectorView propertyInspectorView);

    View getVisibleDetailView();

    void hideDetailView(boolean z);

    void showDetailView(View view, String str, boolean z);
}
