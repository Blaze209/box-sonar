package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes4.dex */
public class MeterSharedState {
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Map<RegisteredReader, MetricStorageRegistry> readerStorageRegistries;
    private final Object collectLock = new Object();
    private final Object callbackLock = new Object();
    private final List<CallbackRegistration> callbackRegistrations = new ArrayList();

    private MeterSharedState(InstrumentationScopeInfo instrumentationScopeInfo, List<RegisteredReader> list) {
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.readerStorageRegistries = (Map) list.stream().collect(Collectors.toMap(Function.identity(), new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.MeterSharedState$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MeterSharedState.lambda$new$0((RegisteredReader) obj);
            }
        }));
    }

    static /* synthetic */ MetricStorageRegistry lambda$new$0(RegisteredReader registeredReader) {
        return new MetricStorageRegistry();
    }

    public static MeterSharedState create(InstrumentationScopeInfo instrumentationScopeInfo, List<RegisteredReader> list) {
        return new MeterSharedState(instrumentationScopeInfo, list);
    }

    public void removeCallback(CallbackRegistration callbackRegistration) {
        synchronized (this.callbackLock) {
            this.callbackRegistrations.remove(callbackRegistration);
        }
    }

    public final void registerCallback(CallbackRegistration callbackRegistration) {
        synchronized (this.callbackLock) {
            this.callbackRegistrations.add(callbackRegistration);
        }
    }

    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    public List<MetricData> collectAll(RegisteredReader registeredReader, MeterProviderSharedState meterProviderSharedState, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        synchronized (this.callbackLock) {
            arrayList = new ArrayList(this.callbackRegistrations);
        }
        synchronized (this.collectLock) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((CallbackRegistration) it.next()).invokeCallback(registeredReader);
            }
            Collection<MetricStorage> storages = ((MetricStorageRegistry) Objects.requireNonNull(this.readerStorageRegistries.get(registeredReader))).getStorages();
            arrayList2 = new ArrayList(storages.size());
            Iterator<MetricStorage> it2 = storages.iterator();
            while (it2.hasNext()) {
                long j2 = j;
                MetricData metricDataCollectAndReset = it2.next().collectAndReset(meterProviderSharedState.getResource(), getInstrumentationScopeInfo(), meterProviderSharedState.getStartEpochNanos(), j2);
                if (!metricDataCollectAndReset.isEmpty()) {
                    arrayList2.add(metricDataCollectAndReset);
                }
                j = j2;
            }
        }
        return arrayList2;
    }

    public void resetForTest() {
        synchronized (this.collectLock) {
            synchronized (this.callbackLock) {
                this.callbackRegistrations.clear();
            }
            this.readerStorageRegistries.values().forEach(new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.MeterSharedState$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((MetricStorageRegistry) obj).resetForTest();
                }
            });
        }
    }

    public final WriteableMetricStorage registerSynchronousMetricStorage(InstrumentDescriptor instrumentDescriptor, MeterProviderSharedState meterProviderSharedState) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<RegisteredReader, MetricStorageRegistry> entry : this.readerStorageRegistries.entrySet()) {
            RegisteredReader key = entry.getKey();
            MetricStorageRegistry value = entry.getValue();
            for (RegisteredView registeredView : key.getViewRegistry().findViews(instrumentDescriptor, getInstrumentationScopeInfo())) {
                if (Aggregation.drop() != registeredView.getView().getAggregation()) {
                    arrayList.add((SynchronousMetricStorage) value.register(SynchronousMetricStorage.create(key, registeredView, instrumentDescriptor, meterProviderSharedState.getExemplarFilter())));
                }
            }
        }
        if (arrayList.size() == 1) {
            return (WriteableMetricStorage) arrayList.get(0);
        }
        return new MultiWritableMetricStorage(arrayList);
    }

    public final SdkObservableMeasurement registerObservableMeasurement(InstrumentDescriptor instrumentDescriptor) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<RegisteredReader, MetricStorageRegistry> entry : this.readerStorageRegistries.entrySet()) {
            RegisteredReader key = entry.getKey();
            MetricStorageRegistry value = entry.getValue();
            for (RegisteredView registeredView : key.getViewRegistry().findViews(instrumentDescriptor, getInstrumentationScopeInfo())) {
                if (Aggregation.drop() != registeredView.getView().getAggregation()) {
                    arrayList.add((AsynchronousMetricStorage) value.register(AsynchronousMetricStorage.create(key, registeredView, instrumentDescriptor)));
                }
            }
        }
        return SdkObservableMeasurement.create(this.instrumentationScopeInfo, instrumentDescriptor, arrayList);
    }
}
