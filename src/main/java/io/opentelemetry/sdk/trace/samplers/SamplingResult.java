package io.opentelemetry.sdk.trace.samplers;

import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.TraceState;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public interface SamplingResult {
    Attributes getAttributes();

    SamplingDecision getDecision();

    default TraceState getUpdatedTraceState(TraceState traceState) {
        return traceState;
    }

    /* JADX INFO: renamed from: io.opentelemetry.sdk.trace.samplers.SamplingResult$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision;

        static {
            int[] iArr = new int[SamplingDecision.values().length];
            $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision = iArr;
            try {
                iArr[SamplingDecision.RECORD_AND_SAMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision[SamplingDecision.RECORD_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision[SamplingDecision.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static SamplingResult create(SamplingDecision samplingDecision) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$trace$samplers$SamplingDecision[samplingDecision.ordinal()];
        if (i == 1) {
            return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
        }
        if (i == 2) {
            return ImmutableSamplingResult.EMPTY_RECORDED_SAMPLING_RESULT;
        }
        if (i == 3) {
            return ImmutableSamplingResult.EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT;
        }
        throw new AssertionError("unrecognised samplingResult");
    }

    static SamplingResult create(SamplingDecision samplingDecision, Attributes attributes) {
        Objects.requireNonNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
        if (attributes.isEmpty()) {
            return create(samplingDecision);
        }
        return ImmutableSamplingResult.createSamplingResult(samplingDecision, attributes);
    }

    static SamplingResult recordAndSample() {
        return ImmutableSamplingResult.EMPTY_RECORDED_AND_SAMPLED_SAMPLING_RESULT;
    }

    static SamplingResult recordOnly() {
        return ImmutableSamplingResult.EMPTY_RECORDED_SAMPLING_RESULT;
    }

    static SamplingResult drop() {
        return ImmutableSamplingResult.EMPTY_NOT_SAMPLED_OR_RECORDED_SAMPLING_RESULT;
    }
}
