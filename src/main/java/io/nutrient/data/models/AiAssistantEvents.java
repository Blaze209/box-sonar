package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00162\u00020\u0001:\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u0082\u0001\u0006\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Chat", "Success", "Error", "Loading", "SocketConnected", "SocketDisconnected", "Companion", "Lio/nutrient/data/models/AiAssistantEvents$Chat;", "Lio/nutrient/data/models/AiAssistantEvents$Error;", "Lio/nutrient/data/models/AiAssistantEvents$Loading;", "Lio/nutrient/data/models/AiAssistantEvents$SocketConnected;", "Lio/nutrient/data/models/AiAssistantEvents$SocketDisconnected;", "Lio/nutrient/data/models/AiAssistantEvents$Success;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public abstract class AiAssistantEvents {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.nutrient.data.models.AiAssistantEvents$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AiAssistantEvents._init_$_anonymous_();
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$Chat;", "Lio/nutrient/data/models/AiAssistantEvents;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Chat extends AiAssistantEvents {
        public static final int $stable = 0;
        public static final Chat INSTANCE = new Chat();

        private Chat() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Chat);
        }

        public int hashCode() {
            return -633117386;
        }

        public String toString() {
            return "Chat";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/AiAssistantEvents;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) AiAssistantEvents.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<AiAssistantEvents> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$Error;", "Lio/nutrient/data/models/AiAssistantEvents;", "message", "", "errorStates", "Lio/nutrient/data/models/DocumentErrorStates;", "retryEnabled", "", "<init>", "(Ljava/lang/String;Lio/nutrient/data/models/DocumentErrorStates;Z)V", "getMessage", "()Ljava/lang/String;", "getErrorStates", "()Lio/nutrient/data/models/DocumentErrorStates;", "getRetryEnabled", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Error extends AiAssistantEvents {
        public static final int $stable = 0;
        private final DocumentErrorStates errorStates;
        private final String message;
        private final boolean retryEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String str, DocumentErrorStates documentErrorStates, boolean z) {
            super(null);
            str.getClass();
            documentErrorStates.getClass();
            this.message = str;
            this.errorStates = documentErrorStates;
            this.retryEnabled = z;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, DocumentErrorStates documentErrorStates, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            if ((i & 2) != 0) {
                documentErrorStates = error.errorStates;
            }
            if ((i & 4) != 0) {
                z = error.retryEnabled;
            }
            return error.copy(str, documentErrorStates, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DocumentErrorStates getErrorStates() {
            return this.errorStates;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getRetryEnabled() {
            return this.retryEnabled;
        }

        public final Error copy(String message, DocumentErrorStates errorStates, boolean retryEnabled) {
            message.getClass();
            errorStates.getClass();
            return new Error(message, errorStates, retryEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.message, error.message) && this.errorStates == error.errorStates && this.retryEnabled == error.retryEnabled;
        }

        public final DocumentErrorStates getErrorStates() {
            return this.errorStates;
        }

        public final String getMessage() {
            return this.message;
        }

        public final boolean getRetryEnabled() {
            return this.retryEnabled;
        }

        public int hashCode() {
            return Boolean.hashCode(this.retryEnabled) + ((this.errorStates.hashCode() + (this.message.hashCode() * 31)) * 31);
        }

        public String toString() {
            return "Error(message=" + this.message + ", errorStates=" + this.errorStates + ", retryEnabled=" + this.retryEnabled + ")";
        }

        public /* synthetic */ Error(String str, DocumentErrorStates documentErrorStates, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, documentErrorStates, (i & 4) != 0 ? true : z);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$Loading;", "Lio/nutrient/data/models/AiAssistantEvents;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Loading extends AiAssistantEvents {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Loading);
        }

        public int hashCode() {
            return 1893948062;
        }

        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$SocketConnected;", "Lio/nutrient/data/models/AiAssistantEvents;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SocketConnected extends AiAssistantEvents {
        public static final int $stable = 0;
        public static final SocketConnected INSTANCE = new SocketConnected();

        private SocketConnected() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof SocketConnected);
        }

        public int hashCode() {
            return 177249336;
        }

        public String toString() {
            return "SocketConnected";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$SocketDisconnected;", "Lio/nutrient/data/models/AiAssistantEvents;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SocketDisconnected extends AiAssistantEvents {
        public static final int $stable = 0;
        public static final SocketDisconnected INSTANCE = new SocketDisconnected();

        private SocketDisconnected() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof SocketDisconnected);
        }

        public int hashCode() {
            return -1380203860;
        }

        public String toString() {
            return "SocketDisconnected";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/nutrient/data/models/AiAssistantEvents$Success;", "Lio/nutrient/data/models/AiAssistantEvents;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Success extends AiAssistantEvents {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Success);
        }

        public int hashCode() {
            return -309872283;
        }

        public String toString() {
            return "Success";
        }
    }

    public /* synthetic */ AiAssistantEvents(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("io.nutrient.data.models.AiAssistantEvents", Reflection.getOrCreateKotlinClass(AiAssistantEvents.class), new KClass[0], new KSerializer[0], new Annotation[0]);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(AiAssistantEvents self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    private AiAssistantEvents() {
    }

    public /* synthetic */ AiAssistantEvents(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }
}
