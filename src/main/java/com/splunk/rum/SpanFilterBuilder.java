package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public final class SpanFilterBuilder {
    private Predicate<String> rejectSpanNamesPredicate = new Predicate() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda5
        @Override // java.util.function.Predicate
        public final boolean test(Object obj) {
            return SpanFilterBuilder.lambda$new$0((String) obj);
        }
    };
    private final Map<AttributeKey<?>, Predicate<?>> rejectSpanAttributesPredicates = new HashMap();
    private final Map<AttributeKey<?>, Function<?, ?>> spanAttributeReplacements = new HashMap();

    static /* synthetic */ boolean lambda$new$0(String str) {
        return false;
    }

    static /* synthetic */ boolean lambda$removeSpanAttribute$2(Object obj) {
        return true;
    }

    SpanFilterBuilder() {
    }

    public SpanFilterBuilder rejectSpansByName(Predicate<String> predicate) {
        this.rejectSpanNamesPredicate = this.rejectSpanNamesPredicate.or(predicate);
        return this;
    }

    public <T> SpanFilterBuilder rejectSpansByAttributeValue(AttributeKey<T> attributeKey, final Predicate<? super T> predicate) {
        this.rejectSpanAttributesPredicates.compute(attributeKey, new BiFunction() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SpanFilterBuilder.lambda$rejectSpansByAttributeValue$1(predicate, (AttributeKey) obj, (Predicate) obj2);
            }
        });
        return this;
    }

    static /* synthetic */ Predicate lambda$rejectSpansByAttributeValue$1(Predicate predicate, AttributeKey attributeKey, Predicate predicate2) {
        return predicate2 == null ? predicate : predicate2.or(predicate);
    }

    public <T> SpanFilterBuilder removeSpanAttribute(AttributeKey<T> attributeKey) {
        return removeSpanAttribute(attributeKey, new Predicate() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SpanFilterBuilder.lambda$removeSpanAttribute$2(obj);
            }
        });
    }

    public <T> SpanFilterBuilder removeSpanAttribute(AttributeKey<T> attributeKey, final Predicate<? super T> predicate) {
        return replaceSpanAttribute(attributeKey, new Function() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SpanFilterBuilder.lambda$removeSpanAttribute$3(predicate, obj);
            }
        });
    }

    static /* synthetic */ Object lambda$removeSpanAttribute$3(Predicate predicate, Object obj) {
        if (predicate.test(obj)) {
            return null;
        }
        return obj;
    }

    public <T> SpanFilterBuilder replaceSpanAttribute(AttributeKey<T> attributeKey, final Function<? super T, ? extends T> function) {
        this.spanAttributeReplacements.compute(attributeKey, new BiFunction() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SpanFilterBuilder.lambda$replaceSpanAttribute$4(function, (AttributeKey) obj, (Function) obj2);
            }
        });
        return this;
    }

    static /* synthetic */ Function lambda$replaceSpanAttribute$4(Function function, AttributeKey attributeKey, Function function2) {
        return function2 == null ? function : function2.andThen(function);
    }

    Function<SpanExporter, SpanExporter> build() {
        final Predicate<String> predicate = this.rejectSpanNamesPredicate;
        final HashMap map = new HashMap(this.rejectSpanAttributesPredicates);
        final HashMap map2 = new HashMap(this.spanAttributeReplacements);
        return new Function() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SpanFilterBuilder.lambda$build$5(predicate, map, map2, (SpanExporter) obj);
            }
        };
    }

    static /* synthetic */ SpanExporter lambda$build$5(Predicate predicate, Map map, Map map2, SpanExporter spanExporter) {
        return new SpanDataModifier(spanExporter, predicate, map, map2);
    }
}
