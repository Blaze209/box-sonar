package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.internal.ThrowableUtil;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes4.dex */
public final class CallbackRegistration {
    private static final Logger logger = Logger.getLogger(CallbackRegistration.class.getName());
    private final Runnable callback;
    private final boolean hasStorages;
    private final List<InstrumentDescriptor> instrumentDescriptors;
    private final List<SdkObservableMeasurement> observableMeasurements;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);

    private CallbackRegistration(List<SdkObservableMeasurement> list, Runnable runnable) {
        this.observableMeasurements = list;
        this.callback = runnable;
        List<InstrumentDescriptor> list2 = (List) list.stream().map(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SdkObservableMeasurement) obj).getInstrumentDescriptor();
            }
        }).collect(Collectors.toList());
        this.instrumentDescriptors = list2;
        if (list2.size() == 0) {
            throw new IllegalStateException("Callback with no instruments is not allowed");
        }
        this.hasStorages = list.stream().flatMap(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SdkObservableMeasurement) obj).getStorages().stream();
            }
        }).findAny().isPresent();
    }

    public static CallbackRegistration create(List<SdkObservableMeasurement> list, Runnable runnable) {
        return new CallbackRegistration(list, runnable);
    }

    public String toString() {
        return "CallbackRegistration{instrumentDescriptors=" + this.instrumentDescriptors + "}";
    }

    void invokeCallback(final RegisteredReader registeredReader) {
        List<SdkObservableMeasurement> list;
        Consumer consumer;
        if (this.hasStorages) {
            this.observableMeasurements.forEach(new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((SdkObservableMeasurement) obj).setActiveReader(registeredReader);
                }
            });
            try {
                this.callback.run();
                list = this.observableMeasurements;
                consumer = new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((SdkObservableMeasurement) obj).setActiveReader(null);
                    }
                };
            } catch (Throwable th) {
                try {
                    ThrowableUtil.propagateIfFatal(th);
                    this.throttlingLogger.log(Level.WARNING, "An exception occurred invoking callback for " + this + ".", th);
                    list = this.observableMeasurements;
                    consumer = new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda1
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((SdkObservableMeasurement) obj).setActiveReader(null);
                        }
                    };
                } catch (Throwable th2) {
                    this.observableMeasurements.forEach(new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda1
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((SdkObservableMeasurement) obj).setActiveReader(null);
                        }
                    });
                    throw th2;
                }
            }
            list.forEach(consumer);
        }
    }
}
