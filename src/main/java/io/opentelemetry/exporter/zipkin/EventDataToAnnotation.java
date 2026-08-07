package io.opentelemetry.exporter.zipkin;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.data.EventData;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes4.dex */
final class EventDataToAnnotation {
    private EventDataToAnnotation() {
    }

    static String apply(EventData eventData) {
        return "\"" + eventData.getName() + "\":" + toJson(eventData.getAttributes());
    }

    private static String toJson(Attributes attributes) {
        return (String) attributes.asMap().entrySet().stream().map(new Function() { // from class: io.opentelemetry.exporter.zipkin.EventDataToAnnotation$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return EventDataToAnnotation.lambda$toJson$0((Map.Entry) obj);
            }
        }).collect(Collectors.joining(",", "{", "}"));
    }

    static /* synthetic */ String lambda$toJson$0(Map.Entry entry) {
        return "\"" + entry.getKey() + "\":" + toValue(entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toValue(Object obj) {
        if (obj instanceof String) {
            return "\"" + obj + "\"";
        }
        if (obj instanceof List) {
            return (String) ((List) obj).stream().map(new Function() { // from class: io.opentelemetry.exporter.zipkin.EventDataToAnnotation$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return EventDataToAnnotation.toValue(obj2);
                }
            }).collect(Collectors.joining(",", "[", "]"));
        }
        return String.valueOf(obj);
    }
}
