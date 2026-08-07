package com.pspdfkit.internal;

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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class c7 {
    public static final b Companion = new b();
    public final a7 a;
    public final float b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<c7> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.AvailableFontRef", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("faceRef", false);
            pluginGeneratedSerialDescriptor.addElement("size", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{a7.a.a, FloatSerializer.INSTANCE};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            float fDecodeFloatElement;
            int i;
            a7 a7Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                a7Var = (a7) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, a7.a.a, null);
                fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 1);
                i = 3;
            } else {
                float fDecodeFloatElement2 = 0.0f;
                boolean z = true;
                a7 a7Var2 = null;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        a7Var2 = (a7) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, a7.a.a, a7Var2);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        fDecodeFloatElement2 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 1);
                        i2 |= 2;
                    }
                }
                fDecodeFloatElement = fDecodeFloatElement2;
                i = i2;
                a7Var = a7Var2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new c7(i, a7Var, fDecodeFloatElement);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            c7 c7Var = (c7) obj;
            encoder.getClass();
            c7Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, a7.a.a, c7Var.a);
            compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 1, c7Var.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<c7> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ c7(int i, a7 a7Var, float f) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = a7Var;
        this.b = f;
    }

    public c7(a7 a7Var, float f) {
        this.a = a7Var;
        this.b = f;
    }
}
