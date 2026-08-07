package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregationUtil;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewRegistry {
    static final RegisteredView DEFAULT_REGISTERED_VIEW;
    static final View DEFAULT_VIEW;
    private static final Logger logger;
    private final Map<InstrumentType, RegisteredView> instrumentDefaultRegisteredView = new HashMap();
    private final List<RegisteredView> registeredViews;

    static /* synthetic */ boolean lambda$toGlobPatternPredicate$1(String str) {
        return true;
    }

    static {
        View viewBuild = View.builder().build();
        DEFAULT_VIEW = viewBuild;
        DEFAULT_REGISTERED_VIEW = RegisteredView.create(InstrumentSelector.builder().setName("*").build(), viewBuild, NoopAttributesProcessor.NOOP, SourceInfo.noSourceInfo());
        logger = Logger.getLogger(ViewRegistry.class.getName());
    }

    ViewRegistry(DefaultAggregationSelector defaultAggregationSelector, List<RegisteredView> list) {
        for (InstrumentType instrumentType : InstrumentType.values()) {
            this.instrumentDefaultRegisteredView.put(instrumentType, RegisteredView.create(InstrumentSelector.builder().setName("*").build(), View.builder().setAggregation(defaultAggregationSelector.getDefaultAggregation(instrumentType)).build(), AttributesProcessor.noop(), SourceInfo.noSourceInfo()));
        }
        this.registeredViews = list;
    }

    public static ViewRegistry create(DefaultAggregationSelector defaultAggregationSelector, List<RegisteredView> list) {
        return new ViewRegistry(defaultAggregationSelector, new ArrayList(list));
    }

    public static ViewRegistry create() {
        return create(new DefaultAggregationSelector() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public final Aggregation getDefaultAggregation(InstrumentType instrumentType) {
                return Aggregation.defaultAggregation();
            }
        }, Collections.emptyList());
    }

    public List<RegisteredView> findViews(InstrumentDescriptor instrumentDescriptor, InstrumentationScopeInfo instrumentationScopeInfo) {
        ArrayList arrayList = new ArrayList();
        for (RegisteredView registeredView : this.registeredViews) {
            if (matchesSelector(registeredView.getInstrumentSelector(), instrumentDescriptor, instrumentationScopeInfo)) {
                if (((AggregatorFactory) registeredView.getView().getAggregation()).isCompatibleWithInstrument(instrumentDescriptor)) {
                    arrayList.add(registeredView);
                } else {
                    logger.log(Level.WARNING, "View aggregation " + AggregationUtil.aggregationName(registeredView.getView().getAggregation()) + " is incompatible with instrument " + instrumentDescriptor.getName() + " of type " + instrumentDescriptor.getType());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return Collections.unmodifiableList(arrayList);
        }
        RegisteredView registeredView2 = (RegisteredView) Objects.requireNonNull(this.instrumentDefaultRegisteredView.get(instrumentDescriptor.getType()));
        if (((AggregatorFactory) registeredView2.getView().getAggregation()).isCompatibleWithInstrument(instrumentDescriptor)) {
            return Collections.singletonList(registeredView2);
        }
        logger.log(Level.WARNING, "Instrument default aggregation " + AggregationUtil.aggregationName(registeredView2.getView().getAggregation()) + " is incompatible with instrument " + instrumentDescriptor.getName() + " of type " + instrumentDescriptor.getType());
        return Collections.singletonList(DEFAULT_REGISTERED_VIEW);
    }

    private static boolean matchesSelector(InstrumentSelector instrumentSelector, InstrumentDescriptor instrumentDescriptor, InstrumentationScopeInfo instrumentationScopeInfo) {
        if (instrumentSelector.getInstrumentType() != null && instrumentSelector.getInstrumentType() != instrumentDescriptor.getType()) {
            return false;
        }
        if (instrumentSelector.getInstrumentName() == null || toGlobPatternPredicate(instrumentSelector.getInstrumentName()).test(instrumentDescriptor.getName())) {
            return matchesMeter(instrumentSelector, instrumentationScopeInfo);
        }
        return false;
    }

    private static boolean matchesMeter(InstrumentSelector instrumentSelector, InstrumentationScopeInfo instrumentationScopeInfo) {
        if (instrumentSelector.getMeterName() != null && !instrumentSelector.getMeterName().equals(instrumentationScopeInfo.getName())) {
            return false;
        }
        if (instrumentSelector.getMeterVersion() == null || instrumentSelector.getMeterVersion().equals(instrumentationScopeInfo.getVersion())) {
            return instrumentSelector.getMeterSchemaUrl() == null || instrumentSelector.getMeterSchemaUrl().equals(instrumentationScopeInfo.getSchemaUrl());
        }
        return false;
    }

    static Predicate<String> toGlobPatternPredicate(final String str) {
        if (str.equals("*")) {
            return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ViewRegistry.lambda$toGlobPatternPredicate$1((String) obj);
                }
            };
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '*' || cCharAt == '?') {
                final Pattern regexPattern = toRegexPattern(str);
                return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda2
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return regexPattern.matcher((String) obj).matches();
                    }
                };
            }
        }
        Objects.requireNonNull(str);
        return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equalsIgnoreCase((String) obj);
            }
        };
    }

    private static Pattern toRegexPattern(String str) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '*' || cCharAt == '?') {
                if (i != -1) {
                    sb.append(Pattern.quote(str.substring(i, i2)));
                    i = -1;
                }
                if (cCharAt == '*') {
                    sb.append(".*");
                } else {
                    sb.append(".");
                }
            } else if (i == -1) {
                i = i2;
            }
        }
        if (i != -1) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        return Pattern.compile(sb.toString());
    }
}
