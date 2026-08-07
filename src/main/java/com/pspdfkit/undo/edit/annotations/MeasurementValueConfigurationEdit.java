package com.pspdfkit.undo.edit.annotations;

import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.undo.edit.Edit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit;", "Lcom/pspdfkit/undo/edit/Edit;", "configuration", "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "<init>", "(Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;)V", "getConfiguration", "()Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "Add", "Delete", "Modify", "Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit$Add;", "Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit$Delete;", "Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit$Modify;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class MeasurementValueConfigurationEdit implements Edit {
    public static final int $stable = 0;
    private final MeasurementValueConfiguration configuration;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit$Add;", "Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit;", "addedConfiguration", "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "<init>", "(Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Add extends MeasurementValueConfigurationEdit {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Add(MeasurementValueConfiguration measurementValueConfiguration) {
            super(measurementValueConfiguration, null);
            measurementValueConfiguration.getClass();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit$Delete;", "Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit;", "deletedConfiguration", "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "<init>", "(Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Delete extends MeasurementValueConfigurationEdit {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Delete(MeasurementValueConfiguration measurementValueConfiguration) {
            super(measurementValueConfiguration, null);
            measurementValueConfiguration.getClass();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit$Modify;", "Lcom/pspdfkit/undo/edit/annotations/MeasurementValueConfigurationEdit;", "originalConfiguration", "Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "modifiedConfiguration", "<init>", "(Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;)V", "getModifiedConfiguration", "()Lcom/pspdfkit/annotations/measurements/MeasurementValueConfiguration;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Modify extends MeasurementValueConfigurationEdit {
        public static final int $stable = 0;
        private final MeasurementValueConfiguration modifiedConfiguration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Modify(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2) {
            super(measurementValueConfiguration, null);
            measurementValueConfiguration.getClass();
            measurementValueConfiguration2.getClass();
            this.modifiedConfiguration = measurementValueConfiguration2;
        }

        public final MeasurementValueConfiguration getModifiedConfiguration() {
            return this.modifiedConfiguration;
        }
    }

    public /* synthetic */ MeasurementValueConfigurationEdit(MeasurementValueConfiguration measurementValueConfiguration, DefaultConstructorMarker defaultConstructorMarker) {
        this(measurementValueConfiguration);
    }

    public final MeasurementValueConfiguration getConfiguration() {
        return this.configuration;
    }

    private MeasurementValueConfigurationEdit(MeasurementValueConfiguration measurementValueConfiguration) {
        this.configuration = measurementValueConfiguration;
    }
}
