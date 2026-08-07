package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class ec {
    public static final b Companion = new b();
    public final int a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<ec> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.CursorColor", aVar, 1);
            pluginGeneratedSerialDescriptor.addElement("color", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{ColorSerializer.INSTANCE};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int iIntValue;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, 0)).intValue();
            } else {
                boolean z = true;
                iIntValue = 0;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else {
                        if (iDecodeElementIndex != 0) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue))).intValue();
                        i2 = 1;
                    }
                }
                i = i2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new ec(i, iIntValue);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            ec ecVar = (ec) obj;
            encoder.getClass();
            ecVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, Integer.valueOf(ecVar.a));
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<ec> serializer() {
            return a.a;
        }
    }

    public ec(int i) {
        this.a = i;
    }

    public /* synthetic */ ec(int i, int i2) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, a.a.getDescriptor());
        }
        this.a = i2;
    }
}
