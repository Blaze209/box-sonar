package com.pspdfkit.ui.inspector;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface PropertyInspectorView {
    void bindController(PropertyInspectorController propertyInspectorController);

    int getPropertyInspectorMaxHeight();

    int getPropertyInspectorMinHeight();

    int getSuggestedHeight();

    View getView();

    default boolean isViewStateRestorationEnabled() {
        return false;
    }

    default void onHidden() {
    }

    default void onShown() {
    }

    void unbindController();
}
