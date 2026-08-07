package com.pspdfkit.annotations.measurements;

import android.content.Context;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001!J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H&J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u000bH&J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH&R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/annotations/measurements/MeasurementValueConfigurationEditor;", "", Gen204FileActivityEventLogger.ACTION_MODIFY, "", "context", "Landroid/content/Context;", "oldValue", "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "newValue", "onSelectedExistingConfiguration", "Lcom/pspdfkit/ui/inspector/views/MeasurementValueConfigurationPickerListener;", "", "modifyAssociatedAnnotations", "addToUndo", "remove", "value", "deleteAssociatedAnnotations", "add", "configurations", "", "getConfigurations", "()Ljava/util/List;", "startCalibrationTool", "getUsageCount", "", "configuration", "(Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnnotationsForConfiguration", "Lcom/pspdfkit/annotations/Annotation;", "addChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfigurationEditor$ChangeListener;", "removeChangeListener", "ChangeListener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface MeasurementValueConfigurationEditor {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/annotations/measurements/MeasurementValueConfigurationEditor$ChangeListener;", "", "onMeasurementValueConfigurationChanged", "", "oldConfiguration", "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "newConfiguration", "onMeasurementValueConfigurationAdded", "configuration", "onMeasurementValueConfigurationDeleted", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface ChangeListener {
        void onMeasurementValueConfigurationAdded(MeasurementValueConfiguration configuration);

        void onMeasurementValueConfigurationChanged(MeasurementValueConfiguration oldConfiguration, MeasurementValueConfiguration newConfiguration);

        void onMeasurementValueConfigurationDeleted(MeasurementValueConfiguration configuration);
    }

    void add(MeasurementValueConfiguration value, boolean addToUndo);

    boolean add(Context context, MeasurementValueConfiguration value, MeasurementValueConfigurationPickerListener onSelectedExistingConfiguration);

    void addChangeListener(ChangeListener listener);

    Object getAnnotationsForConfiguration(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super List<? extends Annotation>> continuation);

    List<MeasurementValueConfiguration> getConfigurations();

    Object getUsageCount(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super Integer> continuation);

    void modify(MeasurementValueConfiguration oldValue, MeasurementValueConfiguration newValue, boolean modifyAssociatedAnnotations, boolean addToUndo);

    boolean modify(Context context, MeasurementValueConfiguration oldValue, MeasurementValueConfiguration newValue, MeasurementValueConfigurationPickerListener onSelectedExistingConfiguration);

    void remove(Context context, MeasurementValueConfiguration value);

    void remove(MeasurementValueConfiguration value, boolean deleteAssociatedAnnotations, boolean addToUndo);

    void removeChangeListener(ChangeListener listener);

    void startCalibrationTool();
}
