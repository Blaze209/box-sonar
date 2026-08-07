package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.internal.cq;
import com.pspdfkit.internal.e60;
import com.pspdfkit.internal.m2;
import com.pspdfkit.internal.o00;
import com.pspdfkit.internal.qx;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wc;
import com.pspdfkit.internal.xc;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.PropertyInspectorViewTitleStyleProvider;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
class ScaleListPickerInspectorDetailView extends FrameLayout implements PropertyInspectorView, PropertyInspectorViewTitleStyleProvider, PropertyInspectorTitleButtonListener, MeasurementValueConfigurationEditor.ChangeListener {
    private static final String LOG_TAG = "Nutri.ScaleListPIDView";
    private final Annotation annotationBeingEdited;
    private final AnnotationProvider.OnAnnotationUpdatedListener annotationListener;
    private boolean annotationWasDeleted;
    private final MeasurementValueConfigurationEditor editor;
    private final m2 inspectorFactory;
    private final String label;
    private boolean listenerRegistered;
    private PropertyInspector parentInspector;
    private MeasurementValueConfiguration pendingScaleToSelect;
    private RecyclerView recyclerView;
    final ScalesAdapter scalesAdapter;

    public static class ScalesAdapter extends RecyclerView.Adapter<ScalesViewHolder> {
        private final ArrayList<MeasurementValueConfiguration> availableScales;
        private final MeasurementValueConfigurationEditor editor;
        final MeasurementValueConfigurationPickerListener listener;
        private final cq theme;

        public static class DiffUtilCallback extends DiffUtil.Callback {
            final List<MeasurementValueConfiguration> newList;
            final List<MeasurementValueConfiguration> oldList;

            public DiffUtilCallback(List<MeasurementValueConfiguration> list, List<MeasurementValueConfiguration> list2) {
                this.oldList = list;
                this.newList = list2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                return configurationsEqualCompletely(this.oldList.get(i), this.newList.get(i2));
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                return Objects.equals(this.oldList.get(i), this.newList.get(i2));
            }

            public boolean configurationsEqualCompletely(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2) {
                if (measurementValueConfiguration == null && measurementValueConfiguration2 == null) {
                    return true;
                }
                return Objects.equals(measurementValueConfiguration, measurementValueConfiguration2) && Objects.equals(measurementValueConfiguration.getName(), measurementValueConfiguration2.getName());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return this.newList.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return this.oldList.size();
            }
        }

        public ScalesAdapter(MeasurementValueConfigurationEditor measurementValueConfigurationEditor, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener, cq cqVar) {
            this.availableScales = new ArrayList<>(measurementValueConfigurationEditor.getConfigurations());
            this.editor = measurementValueConfigurationEditor;
            this.listener = measurementValueConfigurationPickerListener;
            this.theme = cqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getSelectedPosition() {
            MeasurementValueConfiguration measurementValueConfiguration = e60.a;
            if (measurementValueConfiguration == null) {
                return -1;
            }
            return this.availableScales.indexOf(measurementValueConfiguration);
        }

        private boolean isDuplicateScale(MeasurementValueConfiguration measurementValueConfiguration) {
            ArrayList<MeasurementValueConfiguration> arrayList = this.availableScales;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                MeasurementValueConfiguration measurementValueConfiguration2 = arrayList.get(i);
                i++;
                MeasurementValueConfiguration measurementValueConfiguration3 = measurementValueConfiguration2;
                if (measurementValueConfiguration3.getScale().equals(measurementValueConfiguration.getScale()) && measurementValueConfiguration3.getPrecision() != measurementValueConfiguration.getPrecision()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.availableScales.size();
        }

        public MeasurementValueConfiguration getScaleAtPosition(int i) {
            if (i < 0 || i >= this.availableScales.size()) {
                return null;
            }
            return this.availableScales.get(i);
        }

        public void refreshScales() {
            refreshScales(true);
        }

        public void setSelectedPosition(int i) {
            if (i < 0 || i >= this.availableScales.size() || getSelectedPosition() == i) {
                return;
            }
            setSelectedScale(this.availableScales.get(i));
        }

        /* JADX WARN: Code duplicated, block: B:17:0x002f  */
        /* JADX WARN: Code duplicated, block: B:19:0x0035  */
        public void setSelectedScale(MeasurementValueConfiguration measurementValueConfiguration) {
            o00 o00Var;
            if (this.availableScales.contains(measurementValueConfiguration) || measurementValueConfiguration == null) {
                int selectedPosition = getSelectedPosition();
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
                if (!Objects.equals(getScaleAtPosition(selectedPosition), measurementValueConfiguration)) {
                    this.listener.onConfigurationPicked(measurementValueConfiguration);
                }
                int selectedPosition2 = getSelectedPosition();
                if (selectedPosition >= 0) {
                    notifyItemChanged(selectedPosition);
                }
                if (selectedPosition2 >= 0) {
                    notifyItemChanged(selectedPosition2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ScalesViewHolder scalesViewHolder, int i) {
            MeasurementValueConfiguration measurementValueConfiguration = this.availableScales.get(i);
            scalesViewHolder.updateScaleData(measurementValueConfiguration, isDuplicateScale(measurementValueConfiguration));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ScalesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pspdf__view_inspector_scale_list_item, viewGroup, false);
            View viewFindViewById = viewInflate.findViewById(R.id.pspdf__item_data_layer);
            if (viewFindViewById == null) {
                PdfLog.e(ScaleListPickerInspectorDetailView.LOG_TAG, "Can't find swipe card view with ID `R.id.pspdf__item_data_layer`.", new Object[0]);
            } else {
                viewFindViewById.setBackgroundColor(this.theme.a);
            }
            return new ScalesViewHolder(viewInflate, this.theme);
        }

        public void refreshScales(boolean z) {
            List<MeasurementValueConfiguration> configurations = this.editor.getConfigurations();
            MeasurementValueConfiguration measurementValueConfiguration = e60.a;
            if (measurementValueConfiguration != null && !configurations.contains(measurementValueConfiguration)) {
                this.editor.add(measurementValueConfiguration, false);
            }
            refreshScales(this.editor.getConfigurations(), z);
        }

        public void refreshScales(List<MeasurementValueConfiguration> list) {
            refreshScales(list, true);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x007f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0085  */
        public void refreshScales(List<MeasurementValueConfiguration> list, boolean z) {
            o00 o00Var;
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtilCallback(this.availableScales, list));
            MeasurementValueConfiguration measurementValueConfiguration = e60.a;
            this.availableScales.clear();
            this.availableScales.addAll(list);
            diffResultCalculateDiff.dispatchUpdatesTo(this);
            if (this.availableScales.isEmpty()) {
                setSelectedScale(null);
                return;
            }
            if (this.availableScales.contains(measurementValueConfiguration)) {
                setSelectedScale(measurementValueConfiguration);
                return;
            }
            if (z) {
                if (measurementValueConfiguration == null) {
                    PdfLog.d(ScaleListPickerInspectorDetailView.LOG_TAG, "No scale selected. Auto-selecting first scale.", new Object[0]);
                } else {
                    PdfLog.d(ScaleListPickerInspectorDetailView.LOG_TAG, "Selected scale not found in list: " + measurementValueConfiguration + ". Auto-selecting first scale.", new Object[0]);
                }
                MeasurementValueConfiguration scaleAtPosition = getScaleAtPosition(0);
                if (Intrinsics.areEqual(e60.a, scaleAtPosition)) {
                    MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
                    if (!Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, scaleAtPosition != null ? scaleAtPosition.getName() : null)) {
                        e60.a = scaleAtPosition;
                        o00Var = e60.b;
                        if (o00Var != null) {
                            o00Var.a(scaleAtPosition);
                        }
                    }
                } else {
                    e60.a = scaleAtPosition;
                    o00Var = e60.b;
                    if (o00Var != null) {
                        o00Var.a(scaleAtPosition);
                    }
                }
                setSelectedPosition(0);
                return;
            }
            if (measurementValueConfiguration == null) {
                PdfLog.d(ScaleListPickerInspectorDetailView.LOG_TAG, "No scale selected. Keeping selection null.", new Object[0]);
            } else {
                PdfLog.d(ScaleListPickerInspectorDetailView.LOG_TAG, "Selected scale not found in list: " + measurementValueConfiguration + ". Clearing selection.", new Object[0]);
            }
            setSelectedScale(null);
        }
    }

    public static class ScalesViewHolder extends RecyclerView.ViewHolder {
        private final ImageView selectionIndicator;
        private final TextView txtScaleDescription;
        private final TextView txtScaleName;

        public ScalesViewHolder(View view, cq cqVar) {
            super(view);
            this.txtScaleName = (TextView) view.findViewById(R.id.pspdf__scale_name);
            this.txtScaleDescription = (TextView) view.findViewById(R.id.pspdf__scale_description);
            ImageView imageView = (ImageView) view.findViewById(R.id.pspdf__selection_indicator);
            this.selectionIndicator = imageView;
            imageView.setColorFilter(cqVar.b);
        }

        public void updateScaleData(MeasurementValueConfiguration measurementValueConfiguration, boolean z) {
            this.txtScaleName.setText(measurementValueConfiguration.getNameForDisplay(z));
            String name = measurementValueConfiguration.getName();
            TextView textView = this.txtScaleDescription;
            if (name == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(measurementValueConfiguration.getDefaultName(z));
                this.txtScaleDescription.setVisibility(0);
            }
            this.selectionIndicator.setVisibility(measurementValueConfiguration.equals(e60.a) ? 0 : 4);
        }
    }

    public ScaleListPickerInspectorDetailView(Context context, String str, m2 m2Var, MeasurementValueConfigurationEditor measurementValueConfigurationEditor, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener, Annotation annotation) {
        super(context);
        this.parentInspector = null;
        this.annotationWasDeleted = false;
        this.pendingScaleToSelect = null;
        this.listenerRegistered = false;
        this.annotationListener = new AnnotationProvider.OnAnnotationUpdatedListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView.1
            @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
            public void onAnnotationCreated(Annotation annotation2) {
            }

            @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
            public void onAnnotationRemoved(Annotation annotation2) {
                Annotation annotation3 = ScaleListPickerInspectorDetailView.this.annotationBeingEdited;
                if (annotation3 == null || !annotation3.equals(annotation2)) {
                    return;
                }
                ScaleListPickerInspectorDetailView.this.annotationWasDeleted = true;
            }

            @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
            public void onAnnotationUpdated(Annotation annotation2) {
            }

            @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
            public void onAnnotationZOrderChanged(int i, List<Annotation> list, List<Annotation> list2) {
            }
        };
        uw.a(context, "context", null);
        uw.a(str, "label", null);
        uw.a(m2Var, "inspectorFactory", null);
        uw.a(measurementValueConfigurationEditor, "editor", null);
        this.editor = measurementValueConfigurationEditor;
        this.label = str;
        this.inspectorFactory = m2Var;
        this.annotationBeingEdited = annotation;
        this.scalesAdapter = new ScalesAdapter(measurementValueConfigurationEditor, measurementValueConfigurationPickerListener, new cq(getContext()));
        init();
    }

    private ScaleConfigurationPickerInspectorDetailView createEditScaleDetailView(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        return ScaleConfigurationPickerInspectorDetailView.createEditExistingScaleDetailView(getContext(), measurementValueConfiguration, this.inspectorFactory, this, this.label, measurementValueConfigurationPickerListener);
    }

    private ScaleConfigurationPickerInspectorDetailView createNewScaleDetailView(MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        return ScaleConfigurationPickerInspectorDetailView.createNewScaleDetailView(getContext(), this.inspectorFactory, this, this.label, measurementValueConfigurationPickerListener);
    }

    private void init() {
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__view_inspector_scale_list_picker, null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.pspdf__scales_recycler_view);
        this.recyclerView = recyclerView;
        recyclerView.setAdapter(this.scalesAdapter);
        qx qxVar = new qx(this.recyclerView);
        qx.c cVar = new qx.c() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView.2
            @Override // com.pspdfkit.internal.qx.c
            public void onIndependentViewClicked(int i, int i2) {
            }

            @Override // com.pspdfkit.internal.qx.c
            public void onRowClicked(int i) {
                ScaleListPickerInspectorDetailView.this.scalesAdapter.setSelectedPosition(i);
            }
        };
        qxVar.F = true;
        qxVar.D = cVar;
        int[] iArr = {R.id.pspdf__button_delete_scale, R.id.pspdf__button_edit_scale};
        ArrayList arrayList = qxVar.d;
        arrayList.clear();
        arrayList.addAll(ArraysKt.toList(iArr));
        int i = R.id.pspdf__item_data_layer;
        int i2 = R.id.pspdf__item_menu_layer;
        qx.e eVar = new qx.e() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.internal.qx.e
            public final void a(int i3, int i4) {
                this.f$0.lambda$init$0(i3, i4);
            }
        };
        qxVar.G = true;
        int i3 = qxVar.A;
        if (i3 != 0 && i != i3) {
            throw new IllegalArgumentException("foregroundID does not match previously set ID");
        }
        qxVar.A = i;
        qxVar.B = i2;
        qxVar.E = eVar;
        this.recyclerView.addOnItemTouchListener(qxVar);
        ((Button) viewInflate.findViewById(R.id.pspdf__add_new_scale)).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$1(view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.pspdf__use_calibration_tool)).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$2(view);
            }
        });
        addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(int i, int i2) {
        if (i == R.id.pspdf__button_delete_scale) {
            onDeleteScale(i2);
        } else if (i == R.id.pspdf__button_edit_scale) {
            onEditScale(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        onCreateNewScale();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view) {
        this.editor.startCalibrationTool();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateNewScale$4(MeasurementValueConfiguration measurementValueConfiguration) {
        if (measurementValueConfiguration != null) {
            this.pendingScaleToSelect = measurementValueConfiguration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEditScale$3(boolean z, MeasurementValueConfiguration measurementValueConfiguration) {
        if (!z || measurementValueConfiguration == null) {
            return;
        }
        this.pendingScaleToSelect = measurementValueConfiguration;
    }

    private void onCreateNewScale() {
        showScaleConfigurationPicker(MeasurementValueConfiguration.defaultConfiguration(), true, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration) {
                this.f$0.lambda$onCreateNewScale$4(measurementValueConfiguration);
            }
        });
    }

    private void onDeleteScale(int i) {
        MeasurementValueConfiguration scaleAtPosition = this.scalesAdapter.getScaleAtPosition(i);
        if (scaleAtPosition != null) {
            this.editor.remove(getContext(), scaleAtPosition);
        }
    }

    private void onEditScale(int i) {
        MeasurementValueConfiguration scaleAtPosition = this.scalesAdapter.getScaleAtPosition(i);
        if (scaleAtPosition == null) {
            return;
        }
        final boolean z = this.scalesAdapter.getSelectedPosition() == i;
        showScaleConfigurationPicker(scaleAtPosition, false, new MeasurementValueConfigurationPickerListener() { // from class: com.pspdfkit.ui.inspector.views.ScaleListPickerInspectorDetailView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener
            public final void onConfigurationPicked(MeasurementValueConfiguration measurementValueConfiguration) {
                this.f$0.lambda$onEditScale$3(z, measurementValueConfiguration);
            }
        });
    }

    private void showScaleConfigurationPicker(MeasurementValueConfiguration measurementValueConfiguration, boolean z, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        if (this.parentInspector != null) {
            this.parentInspector.showDetailView(z ? createNewScaleDetailView(measurementValueConfigurationPickerListener) : createEditScaleDetailView(measurementValueConfiguration, measurementValueConfigurationPickerListener), null, true);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.parentInspector = propertyInspectorController instanceof PropertyInspector ? (PropertyInspector) propertyInspectorController : null;
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.listenerRegistered) {
            this.editor.addChangeListener(this);
            this.listenerRegistered = true;
        }
        if (this.annotationBeingEdited != null) {
            this.inspectorFactory.a().getFragment().addOnAnnotationUpdatedListener(this.annotationListener);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
    public boolean onBackButtonClicked() {
        MeasurementValueConfiguration measurementValueConfiguration = e60.a;
        if (!this.annotationWasDeleted) {
            this.scalesAdapter.listener.onConfigurationPicked(measurementValueConfiguration);
            return super.onBackButtonClicked();
        }
        PropertyInspector propertyInspector = this.parentInspector;
        if (propertyInspector == null) {
            return true;
        }
        propertyInspector.onCloseButtonClicked();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.listenerRegistered) {
            this.editor.removeChangeListener(this);
            this.listenerRegistered = false;
        }
        if (this.annotationBeingEdited != null) {
            this.inspectorFactory.a().getFragment().removeOnAnnotationUpdatedListener(this.annotationListener);
        }
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor.ChangeListener
    public void onMeasurementValueConfigurationAdded(MeasurementValueConfiguration measurementValueConfiguration) {
        this.scalesAdapter.refreshScales();
        MeasurementValueConfiguration measurementValueConfiguration2 = this.pendingScaleToSelect;
        if (measurementValueConfiguration2 == null || !Objects.equals(measurementValueConfiguration2, measurementValueConfiguration)) {
            return;
        }
        setSelectedScale(measurementValueConfiguration);
        this.pendingScaleToSelect = null;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor.ChangeListener
    public void onMeasurementValueConfigurationChanged(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2) {
        this.scalesAdapter.refreshScales();
        MeasurementValueConfiguration measurementValueConfiguration3 = this.pendingScaleToSelect;
        if (measurementValueConfiguration3 == null || !Objects.equals(measurementValueConfiguration3, measurementValueConfiguration2)) {
            return;
        }
        setSelectedScale(measurementValueConfiguration2);
        this.pendingScaleToSelect = null;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor.ChangeListener
    public void onMeasurementValueConfigurationDeleted(MeasurementValueConfiguration measurementValueConfiguration) {
        this.scalesAdapter.refreshScales(false);
    }

    public void refreshScales() {
        this.annotationWasDeleted = false;
        this.scalesAdapter.refreshScales();
    }

    public void setSelectedScale(MeasurementValueConfiguration measurementValueConfiguration) {
        this.scalesAdapter.setSelectedScale(measurementValueConfiguration);
        this.recyclerView.scrollToPosition(this.scalesAdapter.getSelectedPosition());
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.parentInspector = null;
    }
}
