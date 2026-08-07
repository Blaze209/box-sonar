package com.pspdfkit.ui.inspector.annotation;

import android.content.Context;
import android.os.Bundle;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.wc;
import com.pspdfkit.internal.xc;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.inspector.AbstractPropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.PropertyInspectorViewTitleStyleProvider;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractAnnotationInspectorController<T> extends AbstractPropertyInspectorController implements AnnotatingInspectorController {
    private T annotationInspectorFactory;
    private AnnotatingController controller;

    public AbstractAnnotationInspectorController(Context context, PropertyInspectorCoordinatorLayoutController propertyInspectorCoordinatorLayoutController) {
        super(context, propertyInspectorCoordinatorLayoutController);
    }

    public abstract void applyControllerChanges();

    public void bindAnnotationInspectorController(AnnotatingController annotatingController) {
        annotatingController.bindAnnotationInspectorController(this);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AnnotatingInspectorController
    public final void bindController(AnnotatingController annotatingController) {
        unbindController();
        this.controller = annotatingController;
        this.annotationInspectorFactory = createInspectorFactory(annotatingController);
        bindAnnotationInspectorController(annotatingController);
        annotatingController.addOnAnnotatingModeChangeListener(getAnnotatingModeChangeListener());
        applyControllerChanges();
        onRestoreState();
    }

    public boolean canDisplayScalePicker() {
        AnnotatingController annotatingController;
        return (!isAnnotationInspectorVisible() || (annotatingController = this.controller) == null || this.annotationInspectorFactory == null || annotatingController.getFragment().getDocument() == null) ? false : true;
    }

    public abstract T createInspectorFactory(AnnotatingController annotatingController);

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public void displayScalePicker(boolean z) {
        toggleAnnotationInspector(z);
        if (!canDisplayScalePicker()) {
            cancel();
            return;
        }
        List<PropertyInspectorView> measurementFabInspectorViews = getMeasurementFabInspectorViews();
        if (measurementFabInspectorViews.isEmpty()) {
            cancel();
            return;
        }
        PropertyInspector propertyInspector = getPropertyInspector();
        propertyInspector.setInspectorViews(measurementFabInspectorViews, true, getScalePickerTitleButtonListener(), getScalePickerTitleStyleProvider());
        propertyInspector.setTitle(getContext().getString(R.string.pspdf__measurement_settings));
    }

    public abstract OnAnnotatingModeChangeListener getAnnotatingModeChangeListener();

    public final T getAnnotationInspectorFactory() {
        return this.annotationInspectorFactory;
    }

    public final AnnotatingController getController() {
        return this.controller;
    }

    public abstract List<PropertyInspectorView> getMeasurementFabInspectorViews();

    public PropertyInspectorTitleButtonListener getScalePickerTitleButtonListener() {
        return null;
    }

    public PropertyInspectorViewTitleStyleProvider getScalePickerTitleStyleProvider() {
        return new PropertyInspectorViewTitleStyleProvider() { // from class: com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.PropertyInspectorViewTitleStyleProvider
            public final wc.a getDialogTitleStyle(wc.a aVar) {
                return new xc(aVar);
            }
        };
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public void hideAnnotationInspector(boolean z) {
        hideInspector(z);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public boolean isAnnotationInspectorVisible() {
        return isInspectorVisible();
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController
    public final boolean isBoundToController() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onPreparePropertyInspector(PropertyInspector propertyInspector) {
        super.onPreparePropertyInspector(propertyInspector);
        applyControllerChanges();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public void showAnnotationInspector(boolean z) {
        showInspector(z);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public void toggleAnnotationInspector(boolean z) {
        if (isInspectorVisible()) {
            hideInspector(z);
            return;
        }
        showInspector(z);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.a(Analytics.Event.SHOW_ANNOTATION_INSPECTOR, new Bundle());
    }

    public void unbindAnnotationInspectorController(AnnotatingController annotatingController) {
        annotatingController.unbindAnnotationInspectorController();
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AnnotatingInspectorController
    public final void unbindController() {
        AnnotatingController annotatingController = this.controller;
        if (annotatingController != null) {
            annotatingController.removeOnAnnotatingModeChangeListener(getAnnotatingModeChangeListener());
            unbindAnnotationInspectorController(annotatingController);
            this.controller = null;
        }
        this.annotationInspectorFactory = null;
        cancel();
    }
}
