package com.pspdfkit.ui.toolbar;

/* JADX INFO: loaded from: classes3.dex */
public interface ToolbarCoordinatorLayoutController {
    void attachContextualToolbar();

    void detachContextualToolbar();

    void displayContextualToolbar(ContextualToolbar contextualToolbar, boolean z);

    void onContextualToolbarChanged(ContextualToolbar contextualToolbar);

    void onContextualToolbarPositionChanged(ContextualToolbar contextualToolbar, ToolbarCoordinatorLayout.LayoutParams.Position position, ToolbarCoordinatorLayout.LayoutParams.Position position2);

    void removeContextualToolbar(boolean z);
}
