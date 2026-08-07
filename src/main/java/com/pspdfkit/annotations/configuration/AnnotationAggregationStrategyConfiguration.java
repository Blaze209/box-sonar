package com.pspdfkit.annotations.configuration;

import com.pspdfkit.configuration.annotations.AnnotationAggregationStrategy;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationAggregationStrategyConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setAnnotationAggregationStrategy(AnnotationAggregationStrategy annotationAggregationStrategy);
    }

    AnnotationAggregationStrategy getAnnotationAggregationStrategy();
}
