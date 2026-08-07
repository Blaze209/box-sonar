package com.box.android.domain.di;

import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: compiled from: DomainModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H!¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/di/ObservabilityModule;", "", "<init>", "()V", "provideFileWithRepresentationsFetchObservability", "Lcom/box/android/domain/metrics/preview/units/FileWithRepresentationsFetchObservability;", "previewObservability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "provideFileWithRepresentationsFetchObservability$domain_prodRelease", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class ObservabilityModule {
    @Binds
    public abstract FileWithRepresentationsFetchObservability provideFileWithRepresentationsFetchObservability$domain_prodRelease(PreviewObservability previewObservability);
}
