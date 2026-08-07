package com.pspdfkit.ui.inspector.annotation;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.util.Pair;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.internal.e60;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.o00;
import com.pspdfkit.internal.q0;
import com.pspdfkit.internal.rk;
import com.pspdfkit.internal.u1;
import com.pspdfkit.internal.ww;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.PropertyInspectorViewTitleStyleProvider;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAnnotationEditingInspectorController extends AbstractAnnotationInspectorController<u1> {
    private final OnAnnotatingModeChangeListener annotatingModeChangeListener;
    private boolean calibrationWasConfirmed;

    /* JADX INFO: renamed from: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController$2, reason: invalid class name */
    public class AnonymousClass2 implements PropertyInspectorTitleButtonListener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:17:0x0036  */
        /* JADX WARN: Code duplicated, block: B:19:0x003c  */
        public void onCalibrationAdded(MeasurementValueConfiguration measurementValueConfiguration) {
            o00 o00Var;
            u1 annotationInspectorFactory = DefaultAnnotationEditingInspectorController.this.getAnnotationInspectorFactory();
            if (measurementValueConfiguration == null || annotationInspectorFactory == null || annotationInspectorFactory.b.getFragment().getMeasurementValueConfigurationEditor() == null) {
                return;
            }
            if (Intrinsics.areEqual(e60.a, measurementValueConfiguration)) {
                MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
                if (!Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, measurementValueConfiguration.getName())) {
                    e60.a = measurementValueConfiguration;
                    o00Var = e60.b;
                    if (o00Var != null) {
                        o00Var.a(measurementValueConfiguration);
                    }
                }
            } else {
                e60.a = measurementValueConfiguration;
                o00Var = e60.b;
                if (o00Var != null) {
                    o00Var.a(measurementValueConfiguration);
                }
            }
            DefaultAnnotationEditingInspectorController defaultAnnotationEditingInspectorController = DefaultAnnotationEditingInspectorController.this;
            defaultAnnotationEditingInspectorController.calibrationWasConfirmed = true;
            defaultAnnotationEditingInspectorController.hideInspector(true);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0059  */
        /* JADX WARN: Code duplicated, block: B:23:0x005f  */
        @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
        public boolean onCloseButtonClicked() {
            o00 o00Var;
            AnnotatingController controller = DefaultAnnotationEditingInspectorController.this.getController();
            u1 annotationInspectorFactory = DefaultAnnotationEditingInspectorController.this.getAnnotationInspectorFactory();
            if (controller != null && annotationInspectorFactory != null) {
                MeasurementValueConfiguration measurementValueConfiguration = annotationInspectorFactory.e;
                MeasurementValueConfigurationEditor measurementValueConfigurationEditor = annotationInspectorFactory.b.getFragment().getMeasurementValueConfigurationEditor();
                if (measurementValueConfigurationEditor != null) {
                    if (!measurementValueConfigurationEditor.add(DefaultAnnotationEditingInspectorController.this.getContext(), measurementValueConfiguration, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController$2$$ExternalSyntheticLambda0
                        @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
                        public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                            this.f$0.onCalibrationAdded(measurementValueConfiguration2);
                        }
                    })) {
                        return true;
                    }
                    DefaultAnnotationEditingInspectorController.this.calibrationWasConfirmed = true;
                    if (Intrinsics.areEqual(e60.a, measurementValueConfiguration)) {
                        MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
                        if (!Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null)) {
                            e60.a = measurementValueConfiguration;
                            o00Var = e60.b;
                            if (o00Var != null) {
                                o00Var.a(measurementValueConfiguration);
                            }
                        }
                    } else {
                        e60.a = measurementValueConfiguration;
                        o00Var = e60.b;
                        if (o00Var != null) {
                            o00Var.a(measurementValueConfiguration);
                        }
                    }
                    DefaultAnnotationEditingInspectorController defaultAnnotationEditingInspectorController = DefaultAnnotationEditingInspectorController.this;
                    defaultAnnotationEditingInspectorController.onRemovePropertyInspector(defaultAnnotationEditingInspectorController.getPropertyInspector());
                    new MAMAlertDialogBuilder(DefaultAnnotationEditingInspectorController.this.getContext()).setTitle(R.string.pspdf__dialog_calibration_scale_added_title).setMessage(no.a(DefaultAnnotationEditingInspectorController.this.getContext(), R.string.pspdf__dialog_calibration_scale_added_text, (View) null, measurementValueConfiguration.getNameForDisplay(false))).setCancelable(true).setPositiveButton(R.string.pspdf__ok, (DialogInterface.OnClickListener) null).show();
                }
            }
            return super.onCloseButtonClicked();
        }
    }

    public DefaultAnnotationEditingInspectorController(Context context, PropertyInspectorCoordinatorLayoutController propertyInspectorCoordinatorLayoutController) {
        super(context, propertyInspectorCoordinatorLayoutController);
        this.calibrationWasConfirmed = false;
        this.annotatingModeChangeListener = new OnAnnotatingModeChangeListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController.1
            @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
            public void onChangeAnnotatingMode(AnnotatingController annotatingController) {
                DefaultAnnotationEditingInspectorController.this.applyControllerChanges();
            }

            @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
            public void onEnterAnnotatingMode(AnnotatingController annotatingController) {
            }

            @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
            public void onExitAnnotatingMode(AnnotatingController annotatingController) {
                DefaultAnnotationEditingInspectorController.this.cancel();
            }
        };
        getPropertyInspector().setId(R.id.pspdf__annotation_editing_inspector);
        getPropertyInspector().setCancelOnTouchOutside(true);
    }

    private PropertyInspectorTitleButtonListener getPropertyInspectorTitleButtonListener(AnnotationTool annotationTool) {
        if (annotationTool != AnnotationTool.MEASUREMENT_SCALE_CALIBRATION) {
            return null;
        }
        return new AnonymousClass2();
    }

    private PropertyInspectorViewTitleStyleProvider getTitleStyleProvider(AnnotationTool annotationTool) {
        if (annotationTool != AnnotationTool.MEASUREMENT_SCALE_CALIBRATION) {
            return null;
        }
        return getScalePickerTitleStyleProvider();
    }

    private boolean isCalibrationLineSelected() {
        AnnotatingController controller = getController();
        if (controller == null) {
            return false;
        }
        Annotation currentSingleSelectedAnnotation = controller.getCurrentSingleSelectedAnnotation();
        return (currentSingleSelectedAnnotation instanceof LineAnnotation) && ((LineAnnotation) currentSingleSelectedAnnotation).isCalibration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScaleConfigurationUpdated(MeasurementValueConfiguration measurementValueConfiguration) {
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public void applyControllerChanges() {
        AnnotatingController controller = getController();
        u1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (!isAnnotationInspectorVisible() || controller == null || !controller.hasCurrentlySelectedAnnotations() || annotationInspectorFactory == null) {
            cancel();
            return;
        }
        getPropertyInspector().reset();
        ArrayList arrayListB = annotationInspectorFactory.b(controller.getCurrentlySelectedAnnotations());
        if (arrayListB.isEmpty()) {
            cancel();
            return;
        }
        AnnotationTool annotationTool = ww.c(controller.getCurrentlySelectedAnnotations().get(0)).first;
        getPropertyInspector().setInspectorViews(arrayListB, false, getPropertyInspectorTitleButtonListener(annotationTool), getTitleStyleProvider(annotationTool));
        getPropertyInspector().setTitle(ww.a(annotationTool));
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public void bindAnnotationInspectorController(AnnotatingController annotatingController) {
        if (!(annotatingController instanceof q0)) {
            super.bindAnnotationInspectorController(annotatingController);
            return;
        }
        q0 q0Var = (q0) annotatingController;
        if (q0Var.w != null) {
            q0Var.y = true;
        }
        q0Var.w = this;
        if (q0Var.y) {
            q0Var.a();
        }
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public boolean canDisplayScalePicker() {
        AnnotatingController controller = getController();
        return super.canDisplayScalePicker() && controller != null && controller.hasCurrentlySelectedAnnotations();
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void displayScalePicker(boolean z) {
        super.displayScalePicker(z);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public OnAnnotatingModeChangeListener getAnnotatingModeChangeListener() {
        return this.annotatingModeChangeListener;
    }

    public AnnotatingController getAnnotationEditingController() {
        return getController();
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public List<PropertyInspectorView> getMeasurementFabInspectorViews() {
        u1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (annotationInspectorFactory == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        MeasurementValueConfiguration measurementValueConfiguration = e60.a;
        if (measurementValueConfiguration != null) {
            arrayList.add(new rk(getContext()));
            arrayList.add(annotationInspectorFactory.a(measurementValueConfiguration, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
                public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                    this.f$0.onScaleConfigurationUpdated(measurementValueConfiguration2);
                }
            }));
            return arrayList;
        }
        MeasurementValueConfiguration measurementValueConfigurationDefaultConfiguration = MeasurementValueConfiguration.defaultConfiguration();
        arrayList.add(new rk(getContext()));
        arrayList.add(annotationInspectorFactory.a(measurementValueConfigurationDefaultConfiguration, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                this.f$0.onScaleConfigurationUpdated(measurementValueConfiguration2);
            }
        }));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public boolean hasAnnotationInspector() {
        AnnotationTool annotationTool;
        AnnotatingController controller = getController();
        u1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (annotationInspectorFactory == null || controller == null || !controller.hasCurrentlySelectedAnnotations()) {
            return false;
        }
        List<Annotation> currentlySelectedAnnotations = controller.getCurrentlySelectedAnnotations();
        currentlySelectedAnnotations.getClass();
        HashSet hashSet = new HashSet();
        Iterator<T> it = currentlySelectedAnnotations.iterator();
        while (it.hasNext()) {
            hashSet.add(ww.c((Annotation) it.next()));
        }
        Pair pair = (Pair) CollectionsKt.singleOrNull(hashSet);
        if (pair == null || (annotationTool = (AnnotationTool) pair.first) == null) {
            return false;
        }
        if (currentlySelectedAnnotations.size() > 1 && annotationTool == AnnotationTool.MEASUREMENT_SCALE_CALIBRATION) {
            return false;
        }
        for (AnnotationProperty annotationProperty : u1.b.a) {
            float f = ww.a;
            annotationProperty.getClass();
            if (annotationProperty != AnnotationProperty.ANNOTATION_NOTE) {
                AnnotationConfigurationRegistry annotationConfiguration = annotationInspectorFactory.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration.getClass();
                if (annotationConfiguration.isAnnotationPropertySupported(annotationTool, annotationProperty)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void hideAnnotationInspector(boolean z) {
        super.hideAnnotationInspector(z);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ boolean isAnnotationInspectorVisible() {
        return super.isAnnotationInspectorVisible();
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onDisplayPropertyInspector(PropertyInspector propertyInspector) {
        super.onDisplayPropertyInspector(propertyInspector);
        this.calibrationWasConfirmed = false;
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public /* bridge */ /* synthetic */ void onPreparePropertyInspector(PropertyInspector propertyInspector) {
        super.onPreparePropertyInspector(propertyInspector);
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        super.onRemovePropertyInspector(propertyInspector);
        AnnotatingController controller = getController();
        if (this.calibrationWasConfirmed && controller != null && isCalibrationLineSelected()) {
            controller.deleteCurrentlySelectedAnnotations();
        }
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void showAnnotationInspector(boolean z) {
        super.showAnnotationInspector(z);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void toggleAnnotationInspector(boolean z) {
        super.toggleAnnotationInspector(z);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public void unbindAnnotationInspectorController(AnnotatingController annotatingController) {
        if (annotatingController instanceof q0) {
            ((q0) annotatingController).w = null;
        } else {
            super.unbindAnnotationInspectorController(annotatingController);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public u1 createInspectorFactory(AnnotatingController annotatingController) {
        return new u1(annotatingController);
    }
}
