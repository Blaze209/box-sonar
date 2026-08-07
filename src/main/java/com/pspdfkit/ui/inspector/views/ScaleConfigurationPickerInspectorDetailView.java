package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.pspdfkit.R;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.l2;
import com.pspdfkit.internal.m2;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.wc;
import com.pspdfkit.internal.xc;
import com.pspdfkit.ui.inspector.InspectorViewsContainer;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.PropertyInspectorViewTitleStyleProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ScaleConfigurationPickerInspectorDetailView extends InspectorViewsContainer implements PropertyInspectorView, PropertyInspectorTitleButtonListener, PropertyInspectorViewTitleStyleProvider {
    private PropertyInspectorController controller;
    private MeasurementValueConfiguration editedValueConfiguration;
    private MeasurementValueConfigurationEditor.ChangeListener externalChangeListener;
    private final m2 inspectorFactory;
    private boolean isDataValid;
    MeasurementValueConfigurationPickerListener listener;
    private final MeasurementValueConfiguration originalValueConfiguration;
    private final View viewToNavigateBack;
    private final String viewToNavigateBackTitle;

    private ScaleConfigurationPickerInspectorDetailView(Context context, MeasurementValueConfiguration measurementValueConfiguration, m2 m2Var, View view, String str, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        super(context);
        this.controller = null;
        this.isDataValid = false;
        this.externalChangeListener = null;
        this.originalValueConfiguration = measurementValueConfiguration;
        this.editedValueConfiguration = measurementValueConfiguration == null ? MeasurementValueConfiguration.defaultConfiguration() : measurementValueConfiguration;
        this.inspectorFactory = m2Var;
        this.viewToNavigateBack = view;
        this.viewToNavigateBackTitle = str;
        this.listener = measurementValueConfigurationPickerListener;
    }

    private void addChildViews() {
        Iterator<PropertyInspectorView> it = getCreateNewConfigurationInspectorViews().iterator();
        while (it.hasNext()) {
            addInspectorView(it.next());
        }
    }

    private boolean addNewMeasurementValueConfigurationToDocument(final boolean z, MeasurementValueConfiguration measurementValueConfiguration) {
        MeasurementValueConfigurationEditor measurementValueConfigurationEditor = this.inspectorFactory.a().getFragment().getMeasurementValueConfigurationEditor();
        if (measurementValueConfigurationEditor == null) {
            return true;
        }
        return measurementValueConfigurationEditor.add(getContext(), measurementValueConfiguration, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleConfigurationPickerInspectorDetailView$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration2) {
                this.f$0.lambda$addNewMeasurementValueConfigurationToDocument$1(z, measurementValueConfiguration2);
            }
        });
    }

    private boolean applyMeasurementValueConfigurationChangesToDocument(final boolean z, MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2) {
        MeasurementValueConfigurationEditor measurementValueConfigurationEditor = this.inspectorFactory.a().getFragment().getMeasurementValueConfigurationEditor();
        if (measurementValueConfigurationEditor == null) {
            return true;
        }
        return measurementValueConfigurationEditor.modify(getContext(), measurementValueConfiguration, measurementValueConfiguration2, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleConfigurationPickerInspectorDetailView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration3) {
                this.f$0.lambda$applyMeasurementValueConfigurationChangesToDocument$0(z, measurementValueConfiguration3);
            }
        });
    }

    private void closeInspectorAfterPositiveDialogButton(boolean z) {
        this.isDataValid = true;
        PropertyInspectorController propertyInspectorController = this.controller;
        if (propertyInspectorController != null) {
            if (z) {
                propertyInspectorController.onBackButtonClicked();
            } else {
                propertyInspectorController.onCloseButtonClicked();
            }
        }
    }

    public static ScaleConfigurationPickerInspectorDetailView createEditExistingScaleDetailView(Context context, MeasurementValueConfiguration measurementValueConfiguration, m2 m2Var, View view, String str, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        return new ScaleConfigurationPickerInspectorDetailView(context, measurementValueConfiguration, m2Var, view, str, measurementValueConfigurationPickerListener);
    }

    public static ScaleConfigurationPickerInspectorDetailView createNewScaleDetailView(Context context, m2 m2Var, View view, String str, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        return new ScaleConfigurationPickerInspectorDetailView(context, null, m2Var, view, str, measurementValueConfigurationPickerListener);
    }

    private List<PropertyInspectorView> getCreateNewConfigurationInspectorViews() {
        final MeasurementValueConfiguration measurementValueConfiguration = this.editedValueConfiguration;
        m2 m2Var = this.inspectorFactory;
        String name = measurementValueConfiguration.getName();
        ScaleNameInspectorView.NameChangeListener nameChangeListener = new ScaleNameInspectorView.NameChangeListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleConfigurationPickerInspectorDetailView$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.ui.inspector.views.ScaleNameInspectorView.NameChangeListener
            public final void onNameChanged(String str) {
                this.f$0.lambda$getCreateNewConfigurationInspectorViews$2(measurementValueConfiguration, str);
            }
        };
        m2Var.getClass();
        ScaleNameInspectorView scaleNameInspectorView = new ScaleNameInspectorView(l2.a(m2Var), name, nameChangeListener);
        final PrecisionPickerInspectorView precisionPickerInspectorViewA = this.inspectorFactory.a(measurementValueConfiguration.getPrecision(), measurementValueConfiguration.getScale().unitTo, new PrecisionPickerInspectorView.PrecisionPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleConfigurationPickerInspectorDetailView$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.ui.inspector.views.PrecisionPickerInspectorView.PrecisionPickerListener
            public final void onPrecisionPicked(MeasurementPrecision measurementPrecision) {
                this.f$0.lambda$getCreateNewConfigurationInspectorViews$3(measurementValueConfiguration, measurementPrecision);
            }
        });
        m2 m2Var2 = this.inspectorFactory;
        Scale scale = measurementValueConfiguration.getScale();
        ScalePickerInspectorView.ScalePickerListener scalePickerListener = new ScalePickerInspectorView.ScalePickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleConfigurationPickerInspectorDetailView$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.ui.inspector.views.ScalePickerInspectorView.ScalePickerListener
            public final void onScalePicked(Scale scale2) {
                this.f$0.lambda$getCreateNewConfigurationInspectorViews$4(measurementValueConfiguration, precisionPickerInspectorViewA, scale2);
            }
        };
        m2Var2.getClass();
        scale.getClass();
        ScalePickerInspectorView scalePickerInspectorView = new ScalePickerInspectorView(l2.a(m2Var2), no.a(l2.a(m2Var2), R.string.pspdf__picker_scale, null), scale, scalePickerListener);
        scalePickerInspectorView.setId(R.id.pspdf__annotation_inspector_view_scale_picker);
        ArrayList arrayList = new ArrayList();
        arrayList.add(scaleNameInspectorView);
        arrayList.add(scalePickerInspectorView);
        arrayList.add(precisionPickerInspectorViewA);
        return arrayList;
    }

    private boolean isCreateNewScaleMode() {
        return this.originalValueConfiguration == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addNewMeasurementValueConfigurationToDocument$1(boolean z, MeasurementValueConfiguration measurementValueConfiguration) {
        this.editedValueConfiguration = measurementValueConfiguration;
        closeInspectorAfterPositiveDialogButton(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyMeasurementValueConfigurationChangesToDocument$0(boolean z, MeasurementValueConfiguration measurementValueConfiguration) {
        this.editedValueConfiguration = measurementValueConfiguration;
        closeInspectorAfterPositiveDialogButton(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCreateNewConfigurationInspectorViews$2(MeasurementValueConfiguration measurementValueConfiguration, String str) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.editedValueConfiguration;
        if (measurementValueConfiguration2 != null) {
            measurementValueConfiguration = measurementValueConfiguration2;
        }
        onScaleChanged(new MeasurementValueConfiguration(str, measurementValueConfiguration.getScale(), measurementValueConfiguration.getPrecision()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCreateNewConfigurationInspectorViews$3(MeasurementValueConfiguration measurementValueConfiguration, MeasurementPrecision measurementPrecision) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.editedValueConfiguration;
        if (measurementValueConfiguration2 != null) {
            measurementValueConfiguration = measurementValueConfiguration2;
        }
        onScaleChanged(new MeasurementValueConfiguration(measurementValueConfiguration.getName(), measurementValueConfiguration.getScale(), measurementPrecision));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCreateNewConfigurationInspectorViews$4(MeasurementValueConfiguration measurementValueConfiguration, PrecisionPickerInspectorView precisionPickerInspectorView, Scale scale) {
        MeasurementValueConfiguration measurementValueConfiguration2 = this.editedValueConfiguration;
        if (measurementValueConfiguration2 != null) {
            measurementValueConfiguration = measurementValueConfiguration2;
        }
        MeasurementValueConfiguration measurementValueConfiguration3 = new MeasurementValueConfiguration(measurementValueConfiguration.getName(), scale, measurementValueConfiguration.getPrecision());
        precisionPickerInspectorView.onUnitChanged(scale.unitTo);
        onScaleChanged(measurementValueConfiguration3);
    }

    private boolean mayCloseDetailView(boolean z) {
        return validateAndPersistChanges(z);
    }

    private void onScaleChanged(MeasurementValueConfiguration measurementValueConfiguration) {
        this.editedValueConfiguration = measurementValueConfiguration;
    }

    private void unregisterExternalChangeListener() {
        if (this.externalChangeListener == null || this.inspectorFactory.a().getFragment().getMeasurementValueConfigurationEditor() == null) {
            return;
        }
        this.inspectorFactory.a().getFragment().getMeasurementValueConfigurationEditor().removeChangeListener(this.externalChangeListener);
        this.externalChangeListener = null;
    }

    private boolean validateAndPersistChanges(boolean z) {
        if (!this.isDataValid) {
            if (isCreateNewScaleMode()) {
                this.isDataValid = addNewMeasurementValueConfigurationToDocument(z, this.editedValueConfiguration);
            } else {
                this.isDataValid = applyMeasurementValueConfigurationChangesToDocument(z, this.originalValueConfiguration, this.editedValueConfiguration);
            }
        }
        return this.isDataValid;
    }

    public void addInspectorView(PropertyInspectorView propertyInspectorView) {
        if (propertyInspectorView == null) {
            return;
        }
        if (propertyInspectorView.getView().getLayoutParams() != null) {
            addView(propertyInspectorView.getView());
        } else {
            addView(propertyInspectorView.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        PropertyInspectorController propertyInspectorController = this.controller;
        if (propertyInspectorController == null) {
            throw new NullPointerException("parentInspector");
        }
        propertyInspectorView.bindController(propertyInspectorController);
        propertyInspectorView.onShown();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.controller = propertyInspectorController;
        if ((propertyInspectorController instanceof PropertyInspector ? (PropertyInspector) propertyInspectorController : null) == null) {
            throw new NullPointerException("parentInspector");
        }
        setParentInspector((PropertyInspector) propertyInspectorController);
        if (getChildCount() == 0) {
            addChildViews();
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorViewTitleStyleProvider
    public wc.a getDialogTitleStyle(wc.a aVar) {
        return new xc(aVar);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onBackButtonClicked() {
        PropertyInspectorController propertyInspectorController;
        onCloseButtonClicked();
        View view = this.viewToNavigateBack;
        if (view == null || (propertyInspectorController = this.controller) == null) {
            return false;
        }
        propertyInspectorController.showDetailView(view, null, true);
        return true;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onCloseButtonClicked() {
        if (!mayCloseDetailView(false)) {
            return true;
        }
        unregisterExternalChangeListener();
        this.listener.onConfigurationPicked(this.editedValueConfiguration);
        return false;
    }

    public void setExternalChangeListener(MeasurementValueConfigurationEditor.ChangeListener changeListener) {
        unregisterExternalChangeListener();
        this.externalChangeListener = changeListener;
        if (changeListener == null || this.inspectorFactory.a().getFragment().getMeasurementValueConfigurationEditor() == null) {
            return;
        }
        this.inspectorFactory.a().getFragment().getMeasurementValueConfigurationEditor().addChangeListener(this.externalChangeListener);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.controller = null;
    }
}
