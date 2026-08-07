package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.MeasurementValueConfigurationEdit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class hq extends q7<MeasurementValueConfigurationEdit> {
    public final PdfFragment e;

    public hq(PdfFragment pdfFragment) {
        super(MeasurementValueConfigurationEdit.class, null, 4);
        this.e = pdfFragment;
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        ((MeasurementValueConfigurationEdit) edit).getClass();
        return this.e.getMeasurementValueConfigurationEditor() != null;
    }

    @Override // com.pspdfkit.internal.y60
    public final <T extends MeasurementValueConfigurationEdit> boolean a(Class<T> cls) {
        return true;
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        ((MeasurementValueConfigurationEdit) edit).getClass();
        return this.e.getMeasurementValueConfigurationEditor() != null;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, s7 s7Var) {
        MeasurementValueConfigurationEdit measurementValueConfigurationEdit = (MeasurementValueConfigurationEdit) edit;
        if (measurementValueConfigurationEdit instanceof MeasurementValueConfigurationEdit.Add) {
            MeasurementValueConfiguration configuration = measurementValueConfigurationEdit.getConfiguration();
            MeasurementValueConfigurationEditor measurementValueConfigurationEditor = this.e.getMeasurementValueConfigurationEditor();
            if (measurementValueConfigurationEditor != null) {
                measurementValueConfigurationEditor.add(configuration, false);
            }
        } else if (measurementValueConfigurationEdit instanceof MeasurementValueConfigurationEdit.Delete) {
            MeasurementValueConfiguration configuration2 = measurementValueConfigurationEdit.getConfiguration();
            MeasurementValueConfigurationEditor measurementValueConfigurationEditor2 = this.e.getMeasurementValueConfigurationEditor();
            if (measurementValueConfigurationEditor2 != null) {
                measurementValueConfigurationEditor2.remove(configuration2, false, false);
            }
        } else {
            if (!(measurementValueConfigurationEdit instanceof MeasurementValueConfigurationEdit.Modify)) {
                throw new NoWhenBranchMatchedException();
            }
            MeasurementValueConfiguration configuration3 = measurementValueConfigurationEdit.getConfiguration();
            MeasurementValueConfiguration modifiedConfiguration = ((MeasurementValueConfigurationEdit.Modify) measurementValueConfigurationEdit).getModifiedConfiguration();
            MeasurementValueConfigurationEditor measurementValueConfigurationEditor3 = this.e.getMeasurementValueConfigurationEditor();
            if (measurementValueConfigurationEditor3 != null) {
                measurementValueConfigurationEditor3.modify(configuration3, modifiedConfiguration, false, false);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.q7
    public final Object a(Edit edit, t7 t7Var) {
        MeasurementValueConfigurationEdit measurementValueConfigurationEdit = (MeasurementValueConfigurationEdit) edit;
        if (measurementValueConfigurationEdit instanceof MeasurementValueConfigurationEdit.Add) {
            MeasurementValueConfiguration configuration = measurementValueConfigurationEdit.getConfiguration();
            MeasurementValueConfigurationEditor measurementValueConfigurationEditor = this.e.getMeasurementValueConfigurationEditor();
            if (measurementValueConfigurationEditor != null) {
                measurementValueConfigurationEditor.remove(configuration, false, false);
            }
        } else if (measurementValueConfigurationEdit instanceof MeasurementValueConfigurationEdit.Delete) {
            MeasurementValueConfiguration configuration2 = measurementValueConfigurationEdit.getConfiguration();
            MeasurementValueConfigurationEditor measurementValueConfigurationEditor2 = this.e.getMeasurementValueConfigurationEditor();
            if (measurementValueConfigurationEditor2 != null) {
                measurementValueConfigurationEditor2.add(configuration2, false);
            }
        } else {
            if (!(measurementValueConfigurationEdit instanceof MeasurementValueConfigurationEdit.Modify)) {
                throw new NoWhenBranchMatchedException();
            }
            MeasurementValueConfiguration modifiedConfiguration = ((MeasurementValueConfigurationEdit.Modify) measurementValueConfigurationEdit).getModifiedConfiguration();
            MeasurementValueConfiguration configuration3 = measurementValueConfigurationEdit.getConfiguration();
            MeasurementValueConfigurationEditor measurementValueConfigurationEditor3 = this.e.getMeasurementValueConfigurationEditor();
            if (measurementValueConfigurationEditor3 != null) {
                measurementValueConfigurationEditor3.modify(modifiedConfiguration, configuration3, false, false);
            }
        }
        return Unit.INSTANCE;
    }
}
