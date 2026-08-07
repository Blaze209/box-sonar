package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AttributesProcessor {
    public abstract Attributes process(Attributes attributes, Context context);

    public abstract boolean usesContext();

    AttributesProcessor() {
    }

    public AttributesProcessor then(AttributesProcessor attributesProcessor) {
        if (attributesProcessor == NoopAttributesProcessor.NOOP) {
            return this;
        }
        if (this == NoopAttributesProcessor.NOOP) {
            return attributesProcessor;
        }
        if (attributesProcessor instanceof JoinedAttributesProcessor) {
            return ((JoinedAttributesProcessor) attributesProcessor).prepend(this);
        }
        return new JoinedAttributesProcessor(Arrays.asList(this, attributesProcessor));
    }

    public static AttributesProcessor noop() {
        return NoopAttributesProcessor.NOOP;
    }

    public static AttributesProcessor filterByKeyName(final Predicate<String> predicate) {
        return simple(new UnaryOperator() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Attributes) obj).toBuilder().removeIf(new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda4
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return AttributesProcessor.lambda$filterByKeyName$0(predicate, (AttributeKey) obj2);
                    }
                }).build();
            }
        });
    }

    static /* synthetic */ boolean lambda$filterByKeyName$0(Predicate predicate, AttributeKey attributeKey) {
        return !predicate.test(attributeKey.getKey());
    }

    public static AttributesProcessor appendBaggageByKeyName(final Predicate<String> predicate) {
        return onBaggage(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AttributesProcessor.lambda$appendBaggageByKeyName$3(predicate, (Attributes) obj, (Baggage) obj2);
            }
        });
    }

    static /* synthetic */ Attributes lambda$appendBaggageByKeyName$3(final Predicate predicate, Attributes attributes, Baggage baggage) {
        final AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        baggage.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AttributesProcessor.lambda$appendBaggageByKeyName$2(predicate, attributesBuilderBuilder, (String) obj, (BaggageEntry) obj2);
            }
        });
        attributesBuilderBuilder.putAll(attributes);
        return attributesBuilderBuilder.build();
    }

    static /* synthetic */ void lambda$appendBaggageByKeyName$2(Predicate predicate, AttributesBuilder attributesBuilder, String str, BaggageEntry baggageEntry) {
        if (predicate.test(str)) {
            attributesBuilder.put(str, baggageEntry.getValue());
        }
    }

    public static AttributesProcessor append(final Attributes attributes) {
        return simple(new UnaryOperator() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return attributes.toBuilder().putAll((Attributes) obj).build();
            }
        });
    }

    static AttributesProcessor simple(final UnaryOperator<Attributes> unaryOperator) {
        return new AttributesProcessor() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor.1
            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public boolean usesContext() {
                return false;
            }

            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public Attributes process(Attributes attributes, Context context) {
                return (Attributes) unaryOperator.apply(attributes);
            }
        };
    }

    static AttributesProcessor onBaggage(final BiFunction<Attributes, Baggage, Attributes> biFunction) {
        return new AttributesProcessor() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor.2
            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public boolean usesContext() {
                return true;
            }

            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public Attributes process(Attributes attributes, Context context) {
                return (Attributes) biFunction.apply(attributes, Baggage.fromContext(context));
            }
        };
    }

    static final class JoinedAttributesProcessor extends AttributesProcessor {
        private final Collection<AttributesProcessor> processors;
        private final boolean usesContextCache;

        JoinedAttributesProcessor(Collection<AttributesProcessor> collection) {
            this.processors = collection;
            this.usesContextCache = ((Boolean) collection.stream().map(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$JoinedAttributesProcessor$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((AttributesProcessor) obj).usesContext());
                }
            }).reduce(false, new BinaryOperator() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$JoinedAttributesProcessor$$ExternalSyntheticLambda1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Boolean.valueOf(((Boolean) obj).booleanValue() || ((Boolean) obj2).booleanValue());
                }
            })).booleanValue();
        }

        @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public Attributes process(Attributes attributes, Context context) {
            Iterator<AttributesProcessor> it = this.processors.iterator();
            while (it.hasNext()) {
                attributes = it.next().process(attributes, context);
            }
            return attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public boolean usesContext() {
            return this.usesContextCache;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public AttributesProcessor then(AttributesProcessor attributesProcessor) {
            ArrayList arrayList = new ArrayList(this.processors);
            if (attributesProcessor instanceof JoinedAttributesProcessor) {
                arrayList.addAll(((JoinedAttributesProcessor) attributesProcessor).processors);
            } else {
                arrayList.add(attributesProcessor);
            }
            return new JoinedAttributesProcessor(arrayList);
        }

        AttributesProcessor prepend(AttributesProcessor attributesProcessor) {
            ArrayList arrayList = new ArrayList(this.processors.size() + 1);
            arrayList.add(attributesProcessor);
            arrayList.addAll(this.processors);
            return new JoinedAttributesProcessor(arrayList);
        }
    }
}
