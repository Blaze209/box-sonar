package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lio/nutrient/data/models/Parameters;", "", "input", "", "context", "Lio/nutrient/data/models/AdditionalContext;", "<init>", "(Ljava/lang/String;Lio/nutrient/data/models/AdditionalContext;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lio/nutrient/data/models/AdditionalContext;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInput", "()Ljava/lang/String;", "getContext", "()Lio/nutrient/data/models/AdditionalContext;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Parameters {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdditionalContext context;
    private final String input;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/Parameters$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/Parameters;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Parameters> serializer() {
            return Parameters$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Parameters() {
        this((String) null, (AdditionalContext) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ Parameters copy$default(Parameters parameters, String str, AdditionalContext additionalContext, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parameters.input;
        }
        if ((i & 2) != 0) {
            additionalContext = parameters.context;
        }
        return parameters.copy(str, additionalContext);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(Parameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.input != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.input);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.context == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, AdditionalContext$$serializer.INSTANCE, self.context);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AdditionalContext getContext() {
        return this.context;
    }

    public final Parameters copy(String input, AdditionalContext context) {
        return new Parameters(input, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Parameters)) {
            return false;
        }
        Parameters parameters = (Parameters) other;
        return Intrinsics.areEqual(this.input, parameters.input) && Intrinsics.areEqual(this.context, parameters.context);
    }

    public final AdditionalContext getContext() {
        return this.context;
    }

    public final String getInput() {
        return this.input;
    }

    public int hashCode() {
        String str = this.input;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        AdditionalContext additionalContext = this.context;
        return iHashCode + (additionalContext != null ? additionalContext.hashCode() : 0);
    }

    public String toString() {
        return "Parameters(input=" + this.input + ", context=" + this.context + ")";
    }

    public /* synthetic */ Parameters(int i, String str, AdditionalContext additionalContext, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.input = null;
        } else {
            this.input = str;
        }
        if ((i & 2) == 0) {
            this.context = null;
        } else {
            this.context = additionalContext;
        }
    }

    public Parameters(String str, AdditionalContext additionalContext) {
        this.input = str;
        this.context = additionalContext;
    }

    public /* synthetic */ Parameters(String str, AdditionalContext additionalContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : additionalContext);
    }
}
