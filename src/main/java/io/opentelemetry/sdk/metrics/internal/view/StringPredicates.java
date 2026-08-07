package io.opentelemetry.sdk.metrics.internal.view;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class StringPredicates {
    public static final Predicate<String> ALL = new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.StringPredicates$$ExternalSyntheticLambda1
        @Override // java.util.function.Predicate
        public final boolean test(Object obj) {
            return StringPredicates.lambda$static$0((String) obj);
        }
    };

    static /* synthetic */ boolean lambda$static$0(String str) {
        return true;
    }

    private StringPredicates() {
    }

    public static Predicate<String> exact(final String str) {
        Objects.requireNonNull(str);
        return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.StringPredicates$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals((String) obj);
            }
        };
    }

    static /* synthetic */ boolean lambda$regex$1(Pattern pattern, String str) {
        return str != null && pattern.matcher(str).matches();
    }

    public static Predicate<String> regex(final Pattern pattern) {
        return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.StringPredicates$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return StringPredicates.lambda$regex$1(pattern, (String) obj);
            }
        };
    }
}
