package androidx.media3.effect;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PacketConsumer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\n\u000bJ\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H¦@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\t¨\u0006\f"}, d2 = {"Landroidx/media3/effect/PacketConsumer;", ExifInterface.GPS_DIRECTION_TRUE, "", "queuePacket", "", "packet", "Landroidx/media3/effect/PacketConsumer$Packet;", "(Landroidx/media3/effect/PacketConsumer$Packet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Packet", "Factory", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PacketConsumer<T> {

    /* JADX INFO: compiled from: PacketConsumer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H&¨\u0006\u0005"}, d2 = {"Landroidx/media3/effect/PacketConsumer$Factory;", ExifInterface.GPS_DIRECTION_TRUE, "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/media3/effect/PacketConsumer;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Factory<T> {
        PacketConsumer<T> create();
    }

    Object queuePacket(Packet<? extends T> packet, Continuation<? super Unit> continuation);

    Object release(Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: PacketConsumer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u0005*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Landroidx/media3/effect/PacketConsumer$Packet;", ExifInterface.GPS_DIRECTION_TRUE, "", "Payload", "EndOfStream", "Companion", "Landroidx/media3/effect/PacketConsumer$Packet$EndOfStream;", "Landroidx/media3/effect/PacketConsumer$Packet$Payload;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Packet<T> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @JvmStatic
        static <T> Packet<T> of(T t) {
            return INSTANCE.of(t);
        }

        /* JADX INFO: compiled from: PacketConsumer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/media3/effect/PacketConsumer$Packet$Payload;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/media3/effect/PacketConsumer$Packet;", "payload", "<init>", "(Ljava/lang/Object;)V", "getPayload", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;)Landroidx/media3/effect/PacketConsumer$Packet$Payload;", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Payload<T> implements Packet<T> {
            private final T payload;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Payload copy$default(Payload payload, Object obj, int i, Object obj2) {
                if ((i & 1) != 0) {
                    obj = payload.payload;
                }
                return payload.copy(obj);
            }

            public final T component1() {
                return this.payload;
            }

            public final Payload<T> copy(T payload) {
                return new Payload<>(payload);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Payload) && Intrinsics.areEqual(this.payload, ((Payload) other).payload);
            }

            public int hashCode() {
                T t = this.payload;
                if (t == null) {
                    return 0;
                }
                return t.hashCode();
            }

            public String toString() {
                return "Payload(payload=" + this.payload + ')';
            }

            public Payload(T t) {
                this.payload = t;
            }

            public final T getPayload() {
                return this.payload;
            }
        }

        /* JADX INFO: compiled from: PacketConsumer.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Landroidx/media3/effect/PacketConsumer$Packet$EndOfStream;", "Landroidx/media3/effect/PacketConsumer$Packet;", "", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class EndOfStream implements Packet {
            public static final EndOfStream INSTANCE = new EndOfStream();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EndOfStream)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2263577;
            }

            public String toString() {
                return "EndOfStream";
            }

            private EndOfStream() {
            }
        }

        /* JADX INFO: compiled from: PacketConsumer.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0002\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Landroidx/media3/effect/PacketConsumer$Packet$Companion;", "", "<init>", "()V", "of", "Landroidx/media3/effect/PacketConsumer$Packet;", ExifInterface.GPS_DIRECTION_TRUE, "payload", "(Ljava/lang/Object;)Landroidx/media3/effect/PacketConsumer$Packet;", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @JvmStatic
            public final <T> Packet<T> of(T payload) {
                return new Payload(payload);
            }
        }
    }
}
