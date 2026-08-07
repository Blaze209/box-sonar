package io.opentelemetry.api.baggage.propagation;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.internal.PercentEscaper;
import io.opentelemetry.api.internal.StringUtils;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.context.propagation.TextMapSetter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class W3CBaggagePropagator implements TextMapPropagator {
    private static final String FIELD = "baggage";
    private static final List<String> FIELDS = Collections.singletonList(FIELD);
    private static final W3CBaggagePropagator INSTANCE = new W3CBaggagePropagator();
    private static final PercentEscaper URL_ESCAPER = PercentEscaper.create();

    private static boolean isValidBaggageValue(String str) {
        return str != null;
    }

    public static W3CBaggagePropagator getInstance() {
        return INSTANCE;
    }

    private W3CBaggagePropagator() {
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        return FIELDS;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
        if (context == null || textMapSetter == null) {
            return;
        }
        Baggage baggageFromContext = Baggage.fromContext(context);
        if (baggageFromContext.isEmpty()) {
            return;
        }
        String strBaggageToString = baggageToString(baggageFromContext);
        if (strBaggageToString.isEmpty()) {
            return;
        }
        textMapSetter.set(c, FIELD, strBaggageToString);
    }

    private static String baggageToString(Baggage baggage) {
        final StringBuilder sb = new StringBuilder();
        baggage.forEach(new BiConsumer() { // from class: io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                W3CBaggagePropagator.lambda$baggageToString$0(sb, (String) obj, (BaggageEntry) obj2);
            }
        });
        if (sb.length() == 0) {
            return "";
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    static /* synthetic */ void lambda$baggageToString$0(StringBuilder sb, String str, BaggageEntry baggageEntry) {
        if (baggageIsInvalid(str, baggageEntry)) {
            return;
        }
        sb.append(str).append(SimpleComparison.EQUAL_TO_OPERATION).append(encodeValue(baggageEntry.getValue()));
        String value = baggageEntry.getMetadata().getValue();
        if (value != null && !value.isEmpty()) {
            sb.append(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER).append(encodeValue(value));
        }
        sb.append(",");
    }

    private static String encodeValue(String str) {
        return URL_ESCAPER.escape(str);
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        String str;
        if (context == null) {
            return Context.root();
        }
        if (textMapGetter == null || (str = textMapGetter.get(c, FIELD)) == null || str.isEmpty()) {
            return context;
        }
        BaggageBuilder baggageBuilderBuilder = Baggage.builder();
        try {
            extractEntries(str, baggageBuilderBuilder);
            return context.with(baggageBuilderBuilder.build());
        } catch (RuntimeException unused) {
            return context;
        }
    }

    private static void extractEntries(String str, BaggageBuilder baggageBuilder) {
        new Parser(str).parseInto(baggageBuilder);
    }

    private static boolean baggageIsInvalid(String str, BaggageEntry baggageEntry) {
        return (isValidBaggageKey(str) && isValidBaggageValue(baggageEntry.getValue())) ? false : true;
    }

    private static boolean isValidBaggageKey(String str) {
        return (str == null || str.isEmpty() || !StringUtils.isPrintableString(str)) ? false : true;
    }

    public String toString() {
        return "W3CBaggagePropagator";
    }
}
