package com.pspdfkit.annotations.configuration;

import com.pspdfkit.annotations.measurements.MeasurementPrecision;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationPrecisionConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setDefaultPrecision(MeasurementPrecision measurementPrecision);
    }

    MeasurementPrecision getDefaultPrecision();
}
