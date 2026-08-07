package com.pspdfkit.ui.inspector;

/* JADX INFO: loaded from: classes3.dex */
public interface PropertyInspectorCoordinatorLayoutController {

    public interface PropertyInspectorLifecycleListener {
        void onDisplayPropertyInspector(PropertyInspector propertyInspector);

        void onPreparePropertyInspector(PropertyInspector propertyInspector);

        void onRemovePropertyInspector(PropertyInspector propertyInspector);
    }

    void addPropertyInspectorLifecycleListener(PropertyInspectorLifecycleListener propertyInspectorLifecycleListener);

    boolean hideInspector(boolean z);

    boolean isInspectorVisible();

    boolean isInspectorVisible(PropertyInspector propertyInspector);

    void removePropertyInspectorLifecycleListener(PropertyInspectorLifecycleListener propertyInspectorLifecycleListener);

    void setBottomInset(int i);

    void setDrawUnderBottomInset(boolean z);

    boolean showInspector(PropertyInspector propertyInspector, boolean z);
}
