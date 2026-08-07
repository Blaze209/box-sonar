package com.pspdfkit.ui.inspector;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractPropertyInspectorController implements PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener {
    private static final String STATE_CONTROLLER_SAVED_STATE = "Nutrient.PropertyInspector.SavedState";
    private static final String STATE_INSPECTOR_IS_VISIBLE = "Nutrient.PropertyInspector.IsVisible";
    private static final String STATE_INSPECTOR_VIEW_STATE = "Nutrient.PropertyInspector.PropertyInspectorViewState";
    private final Context context;
    private final PropertyInspectorCoordinatorLayoutController coordinatorController;
    private boolean isRestoringState;
    private PropertyInspector propertyInspector = null;
    private Bundle savedInstanceState;

    public AbstractPropertyInspectorController(Context context, PropertyInspectorCoordinatorLayoutController propertyInspectorCoordinatorLayoutController) {
        uw.a(context, "context", null);
        uw.a(propertyInspectorCoordinatorLayoutController, "coordinatorController", null);
        this.context = context;
        this.coordinatorController = propertyInspectorCoordinatorLayoutController;
        propertyInspectorCoordinatorLayoutController.addPropertyInspectorLifecycleListener(this);
    }

    private PropertyInspector createAndInitializePropertyInspector() {
        PropertyInspector propertyInspectorCreatePropertyInspector = createPropertyInspector(this.context);
        propertyInspectorCreatePropertyInspector.setSaveEnabled(false);
        propertyInspectorCreatePropertyInspector.setSaveFromParentEnabled(false);
        return propertyInspectorCreatePropertyInspector;
    }

    public void cancel() {
        hideInspector(true);
    }

    public PropertyInspector createPropertyInspector(Context context) {
        return new PropertyInspector(context);
    }

    public Context getContext() {
        return this.context;
    }

    public PropertyInspectorCoordinatorLayoutController getCoordinatorController() {
        return this.coordinatorController;
    }

    public PropertyInspector getPropertyInspector() {
        if (this.propertyInspector == null) {
            createAndInitializePropertyInspector();
            this.propertyInspector = createAndInitializePropertyInspector();
        }
        return this.propertyInspector;
    }

    public void hideInspector(boolean z) {
        if (this.coordinatorController.isInspectorVisible(getPropertyInspector())) {
            this.coordinatorController.hideInspector(z);
        }
    }

    public boolean isBoundToController() {
        return false;
    }

    public boolean isInspectorVisible() {
        return this.coordinatorController.isInspectorVisible(getPropertyInspector());
    }

    public boolean isRestoringState() {
        return this.isRestoringState;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onDisplayPropertyInspector(PropertyInspector propertyInspector) {
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onPreparePropertyInspector(PropertyInspector propertyInspector) {
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        this.savedInstanceState = null;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.savedInstanceState = (Bundle) bundle.getParcelable(STATE_CONTROLLER_SAVED_STATE.concat(getClass().getName()));
        onRestoreState();
    }

    public boolean onRestoreState() {
        boolean z = false;
        if (this.savedInstanceState != null && isBoundToController()) {
            if (this.savedInstanceState.getBoolean(STATE_INSPECTOR_IS_VISIBLE, false)) {
                this.isRestoringState = true;
                showInspector(false);
                Parcelable parcelable = this.savedInstanceState.getParcelable(STATE_INSPECTOR_VIEW_STATE);
                if (parcelable != null) {
                    getPropertyInspector().onRestoreInstanceState(parcelable);
                }
                this.isRestoringState = false;
                z = true;
            }
            this.savedInstanceState = null;
        }
        return z;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(STATE_INSPECTOR_IS_VISIBLE, isInspectorVisible());
        if (isInspectorVisible()) {
            bundle2.putParcelable(STATE_INSPECTOR_VIEW_STATE, getPropertyInspector().onSaveInstanceState());
        }
        bundle.putParcelable(STATE_CONTROLLER_SAVED_STATE.concat(getClass().getName()), bundle2);
    }

    public void showInspector(boolean z) {
        if (this.coordinatorController.isInspectorVisible(getPropertyInspector())) {
            return;
        }
        this.coordinatorController.showInspector(getPropertyInspector(), z);
    }
}
