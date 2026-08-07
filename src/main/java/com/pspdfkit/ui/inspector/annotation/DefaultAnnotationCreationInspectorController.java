package com.pspdfkit.ui.inspector.annotation;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.measurements.SecondaryMeasurementUnit;
import com.pspdfkit.internal.e60;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.m1;
import com.pspdfkit.internal.n1;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.o00;
import com.pspdfkit.internal.p0;
import com.pspdfkit.internal.p1;
import com.pspdfkit.internal.p10;
import com.pspdfkit.internal.qk;
import com.pspdfkit.internal.rk;
import com.pspdfkit.internal.ww;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView;
import com.pspdfkit.ui.inspector.views.ScaleNameInspectorView;
import com.pspdfkit.ui.inspector.views.ScalePickerInspectorView;
import com.pspdfkit.ui.inspector.views.SwitchInspectorView;
import com.pspdfkit.ui.inspector.views.UnitsPickerInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAnnotationCreationInspectorController extends AbstractAnnotationInspectorController<p1> implements PropertyInspectorTitleButtonListener {
    private final OnAnnotatingModeChangeListener annotationCreationModeChangeListener;
    private boolean configDirty;
    private MeasurementValueConfiguration measurementValueConfiguration;
    private final PropertyInspector.ItemDecoration previewDivider;

    public DefaultAnnotationCreationInspectorController(Context context, PropertyInspectorCoordinatorLayoutController propertyInspectorCoordinatorLayoutController) {
        super(context, propertyInspectorCoordinatorLayoutController);
        this.measurementValueConfiguration = e60.a;
        this.configDirty = false;
        this.annotationCreationModeChangeListener = new OnAnnotatingModeChangeListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController.1
            @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
            public void onChangeAnnotatingMode(AnnotatingController annotatingController) {
                DefaultAnnotationCreationInspectorController.this.resetMeasurementConfigCache();
                DefaultAnnotationCreationInspectorController.this.applyControllerChanges();
            }

            @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
            public void onEnterAnnotatingMode(AnnotatingController annotatingController) {
                DefaultAnnotationCreationInspectorController.this.resetMeasurementConfigCache();
            }

            @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
            public void onExitAnnotatingMode(AnnotatingController annotatingController) {
                DefaultAnnotationCreationInspectorController.this.cancel();
            }
        };
        getPropertyInspector().setId(R.id.pspdf__annotation_creation_inspector);
        this.previewDivider = new m1(context);
    }

    private SecondaryMeasurementUnit getCurrentSecondaryUnitOrDefault() {
        lm lmVar;
        AnnotatingController controller = getController();
        return (controller == null || (lmVar = (lm) controller.getFragment().getDocument()) == null || lmVar.getSecondaryMeasurementUnit() == null) ? SecondaryMeasurementUnit.getDefault() : lmVar.getSecondaryMeasurementUnit();
    }

    private List<PropertyInspectorView> getSecondaryMeasurementUnitInspectorViews() {
        p1 annotationInspectorFactory = getAnnotationInspectorFactory();
        AnnotatingController controller = getController();
        if (annotationInspectorFactory == null || controller == null) {
            return new ArrayList();
        }
        final lm lmVar = (lm) controller.getFragment().getDocument();
        if (lmVar == null) {
            return new ArrayList();
        }
        final ArrayList arrayList = new ArrayList();
        qk qkVar = new qk(getContext());
        SecondaryMeasurementUnit currentSecondaryUnitOrDefault = getCurrentSecondaryUnitOrDefault();
        Context context = getContext();
        boolean z = lmVar.getSecondaryMeasurementUnit() != null;
        SwitchInspectorView.SwitchListener switchListener = new SwitchInspectorView.SwitchListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.ui.inspector.views.SwitchInspectorView.SwitchListener
            public final void onSwitchValueChange(boolean z2) {
                this.f$0.lambda$getSecondaryMeasurementUnitInspectorViews$3(lmVar, arrayList, z2);
            }
        };
        context.getClass();
        SwitchInspectorView switchInspectorView = new SwitchInspectorView(context, no.a(context, R.string.pspdf__secondary_units, null), z, switchListener);
        switchInspectorView.setId(R.id.pspdf__measurement_scale_view_secondary_units_switch);
        final PrecisionPickerInspectorView precisionPickerInspectorViewA = annotationInspectorFactory.a(currentSecondaryUnitOrDefault.getPrecision(), currentSecondaryUnitOrDefault.getUnit(), new PrecisionPickerInspectorView.PrecisionPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView.PrecisionPickerListener
            public final void onPrecisionPicked(MeasurementPrecision measurementPrecision) {
                this.f$0.lambda$getSecondaryMeasurementUnitInspectorViews$4(lmVar, measurementPrecision);
            }
        });
        Scale.UnitTo unit = currentSecondaryUnitOrDefault.getUnit();
        UnitsPickerInspectorView.UnitPickerListener unitPickerListener = new UnitsPickerInspectorView.UnitPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda6
            @Override // com.pspdfkit.ui.inspector.views.UnitsPickerInspectorView.UnitPickerListener
            public final void onUnitPicked(Scale.UnitTo unitTo) {
                this.f$0.lambda$getSecondaryMeasurementUnitInspectorViews$5(precisionPickerInspectorViewA, lmVar, unitTo);
            }
        };
        unit.getClass();
        UnitsPickerInspectorView unitsPickerInspectorView = new UnitsPickerInspectorView(n1.a(annotationInspectorFactory.b), no.a(n1.a(annotationInspectorFactory.b), R.string.pspdf__measurement_unit, null), unit, unitPickerListener);
        arrayList.add(qkVar);
        arrayList.add(switchInspectorView);
        arrayList.add(unitsPickerInspectorView);
        arrayList.add(precisionPickerInspectorViewA);
        Iterator it = arrayList.subList(arrayList.size() - 2, arrayList.size()).iterator();
        while (it.hasNext()) {
            ((PropertyInspectorView) it.next()).getView().setVisibility(lmVar.getSecondaryMeasurementUnit() != null ? 0 : 4);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMeasurementFabInspectorViews$0(MeasurementValueConfiguration measurementValueConfiguration, String str) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.measurementValueConfiguration;
        if (measurementValueConfiguration2 != null) {
            measurementValueConfiguration = measurementValueConfiguration2;
        }
        onConfigurationUpdated(new MeasurementValueConfiguration(str, measurementValueConfiguration.getScale(), measurementValueConfiguration.getPrecision()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMeasurementFabInspectorViews$1(MeasurementValueConfiguration measurementValueConfiguration, MeasurementPrecision measurementPrecision) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.measurementValueConfiguration;
        if (measurementValueConfiguration2 != null) {
            measurementValueConfiguration = measurementValueConfiguration2;
        }
        onConfigurationUpdated(new MeasurementValueConfiguration(measurementValueConfiguration.getName(), measurementValueConfiguration.getScale(), measurementPrecision));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMeasurementFabInspectorViews$2(MeasurementValueConfiguration measurementValueConfiguration, PrecisionPickerInspectorView precisionPickerInspectorView, Scale scale) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.measurementValueConfiguration;
        if (measurementValueConfiguration2 != null) {
            measurementValueConfiguration = measurementValueConfiguration2;
        }
        MeasurementValueConfiguration measurementValueConfiguration3 = new MeasurementValueConfiguration(measurementValueConfiguration.getName(), scale, measurementValueConfiguration.getPrecision());
        precisionPickerInspectorView.onUnitChanged(scale.unitTo);
        onConfigurationUpdated(measurementValueConfiguration3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSecondaryMeasurementUnitInspectorViews$3(lm lmVar, ArrayList arrayList, boolean z) {
        lmVar.b(z);
        toggleSecondaryUI(arrayList, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSecondaryMeasurementUnitInspectorViews$4(lm lmVar, MeasurementPrecision measurementPrecision) {
        lmVar.setSecondaryMeasurementUnit(new SecondaryMeasurementUnit(measurementPrecision, getCurrentSecondaryUnitOrDefault().getUnit()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSecondaryMeasurementUnitInspectorViews$5(PrecisionPickerInspectorView precisionPickerInspectorView, lm lmVar, Scale.UnitTo unitTo) {
        SecondaryMeasurementUnit secondaryMeasurementUnit = new SecondaryMeasurementUnit(getCurrentSecondaryUnitOrDefault().getPrecision(), unitTo);
        precisionPickerInspectorView.onUnitChanged(unitTo);
        lmVar.setSecondaryMeasurementUnit(secondaryMeasurementUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfigurationUpdated(MeasurementValueConfiguration measurementValueConfiguration) {
        if (measurementValueConfiguration == null || measurementValueConfiguration.equalsAll(this.measurementValueConfiguration)) {
            return;
        }
        this.configDirty = true;
        this.measurementValueConfiguration = measurementValueConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetMeasurementConfigCache() {
        this.configDirty = false;
        this.measurementValueConfiguration = e60.a;
    }

    private void toggleSecondaryUI(ArrayList<PropertyInspectorView> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        for (PropertyInspectorView propertyInspectorView : arrayList.subList(arrayList.size() - 2, arrayList.size())) {
            if (z) {
                p0.b(propertyInspectorView.getView(), true);
            } else {
                p0.a(propertyInspectorView.getView(), true);
            }
        }
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public void applyControllerChanges() {
        AnnotatingController controller = getController();
        p1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (!isAnnotationInspectorVisible() || controller == null || controller.getActiveAnnotationTool() == null || controller.getActiveAnnotationToolVariant() == null || annotationInspectorFactory == null) {
            cancel();
            return;
        }
        if (controller.getActiveAnnotationTool() == AnnotationTool.MEASUREMENT_SCALE_CALIBRATION) {
            cancel();
            return;
        }
        List<PropertyInspectorView> listA = annotationInspectorFactory.a(controller.getActiveAnnotationTool(), controller.getActiveAnnotationToolVariant());
        if (listA.isEmpty()) {
            cancel();
            return;
        }
        PropertyInspector propertyInspector = getPropertyInspector();
        propertyInspector.addItemDecoration(this.previewDivider);
        propertyInspector.setInspectorViews(listA, true);
        propertyInspector.setTitle(ww.a(controller.getActiveAnnotationTool()));
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public boolean canDisplayScalePicker() {
        AnnotatingController controller = getController();
        if (!super.canDisplayScalePicker() || controller == null || controller.getActiveAnnotationTool() == null || controller.getActiveAnnotationToolVariant() == null) {
            return false;
        }
        AnnotationTool activeAnnotationTool = controller.getActiveAnnotationTool();
        activeAnnotationTool.getClass();
        int i = p10.a.b[activeAnnotationTool.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController
    public void cancel() {
        super.cancel();
        resetMeasurementConfigCache();
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void displayScalePicker(boolean z) {
        super.displayScalePicker(z);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public OnAnnotatingModeChangeListener getAnnotatingModeChangeListener() {
        return this.annotationCreationModeChangeListener;
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public List<PropertyInspectorView> getMeasurementFabInspectorViews() {
        p1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (annotationInspectorFactory == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        MeasurementValueConfiguration measurementValueConfiguration = e60.a;
        if (measurementValueConfiguration != null) {
            arrayList.add(new rk(getContext()));
            arrayList.add(annotationInspectorFactory.a(measurementValueConfiguration, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
                public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                    this.f$0.onConfigurationUpdated(measurementValueConfiguration2);
                }
            }));
        } else {
            this.measurementValueConfiguration = null;
            this.configDirty = true;
            final MeasurementValueConfiguration measurementValueConfigurationDefaultConfiguration = MeasurementValueConfiguration.defaultConfiguration();
            String name = measurementValueConfigurationDefaultConfiguration.getName();
            ScaleNameInspectorView.NameChangeListener nameChangeListener = new ScaleNameInspectorView.NameChangeListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda1
                @Override // com.pspdfkit.ui.inspector.views.ScaleNameInspectorView.NameChangeListener
                public final void onNameChanged(String str) {
                    this.f$0.lambda$getMeasurementFabInspectorViews$0(measurementValueConfigurationDefaultConfiguration, str);
                }
            };
            Context contextRequireContext = annotationInspectorFactory.a().getFragment().requireContext();
            contextRequireContext.getClass();
            ScaleNameInspectorView scaleNameInspectorView = new ScaleNameInspectorView(contextRequireContext, name, nameChangeListener);
            final PrecisionPickerInspectorView precisionPickerInspectorViewA = annotationInspectorFactory.a(measurementValueConfigurationDefaultConfiguration.getPrecision(), measurementValueConfigurationDefaultConfiguration.getScale().unitTo, new PrecisionPickerInspectorView.PrecisionPickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda2
                @Override // com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView.PrecisionPickerListener
                public final void onPrecisionPicked(MeasurementPrecision measurementPrecision) {
                    this.f$0.lambda$getMeasurementFabInspectorViews$1(measurementValueConfigurationDefaultConfiguration, measurementPrecision);
                }
            });
            Scale scale = measurementValueConfigurationDefaultConfiguration.getScale();
            ScalePickerInspectorView.ScalePickerListener scalePickerListener = new ScalePickerInspectorView.ScalePickerListener() { // from class: com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController$$ExternalSyntheticLambda3
                @Override // com.pspdfkit.ui.inspector.views.ScalePickerInspectorView.ScalePickerListener
                public final void onScalePicked(Scale scale2) {
                    this.f$0.lambda$getMeasurementFabInspectorViews$2(measurementValueConfigurationDefaultConfiguration, precisionPickerInspectorViewA, scale2);
                }
            };
            scale.getClass();
            Context contextRequireContext2 = annotationInspectorFactory.a().getFragment().requireContext();
            contextRequireContext2.getClass();
            Context contextRequireContext3 = annotationInspectorFactory.a().getFragment().requireContext();
            contextRequireContext3.getClass();
            ScalePickerInspectorView scalePickerInspectorView = new ScalePickerInspectorView(contextRequireContext2, no.a(contextRequireContext3, R.string.pspdf__picker_scale, null), scale, scalePickerListener);
            scalePickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_scale_picker);
            arrayList.add(scaleNameInspectorView);
            arrayList.add(scalePickerInspectorView);
            arrayList.add(precisionPickerInspectorViewA);
        }
        arrayList.addAll(getSecondaryMeasurementUnitInspectorViews());
        return arrayList;
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public PropertyInspectorTitleButtonListener getScalePickerTitleButtonListener() {
        return this;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public boolean hasAnnotationInspector() {
        AnnotatingController controller = getController();
        p1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (annotationInspectorFactory == null || controller == null || controller.getActiveAnnotationTool() == null) {
            return false;
        }
        AnnotationTool activeAnnotationTool = controller.getActiveAnnotationTool();
        AnnotationToolVariant activeAnnotationToolVariant = controller.getActiveAnnotationToolVariant();
        activeAnnotationTool.getClass();
        activeAnnotationToolVariant.getClass();
        if (activeAnnotationTool == AnnotationTool.SIGNATURE || activeAnnotationTool == AnnotationTool.NOTE) {
            return false;
        }
        for (AnnotationProperty annotationProperty : p1.a.a) {
            float f = ww.a;
            annotationProperty.getClass();
            if (annotationProperty != AnnotationProperty.ANNOTATION_NOTE) {
                AnnotationConfigurationRegistry annotationConfiguration = annotationInspectorFactory.b.getFragment().getAnnotationConfiguration();
                annotationConfiguration.getClass();
                if (annotationConfiguration.isAnnotationPropertySupported(activeAnnotationTool, activeAnnotationToolVariant, annotationProperty)) {
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

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onBackButtonClicked() {
        resetMeasurementConfigCache();
        return onCloseButtonClicked();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onCloseButtonClicked() {
        o00 o00Var;
        p1 annotationInspectorFactory = getAnnotationInspectorFactory();
        if (!this.configDirty || this.measurementValueConfiguration == null) {
            return false;
        }
        MeasurementValueConfigurationEditor measurementValueConfigurationEditor = annotationInspectorFactory != null ? annotationInspectorFactory.b.getFragment().getMeasurementValueConfigurationEditor() : null;
        if (measurementValueConfigurationEditor != null && !measurementValueConfigurationEditor.getConfigurations().contains(this.measurementValueConfiguration)) {
            measurementValueConfigurationEditor.add(this.measurementValueConfiguration, true);
        }
        MeasurementValueConfiguration measurementValueConfiguration = this.measurementValueConfiguration;
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
        resetMeasurementConfigCache();
        return false;
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public /* bridge */ /* synthetic */ void onPreparePropertyInspector(PropertyInspector propertyInspector) {
        super.onPreparePropertyInspector(propertyInspector);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void showAnnotationInspector(boolean z) {
        super.showAnnotationInspector(z);
    }

    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController, com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController
    public /* bridge */ /* synthetic */ void toggleAnnotationInspector(boolean z) {
        super.toggleAnnotationInspector(z);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.pspdfkit.ui.inspector.annotation.AbstractAnnotationInspectorController
    public p1 createInspectorFactory(AnnotatingController annotatingController) {
        return new p1(annotatingController);
    }
}
