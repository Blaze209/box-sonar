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
public final class t70 {
    public static final b Companion = new b();
    public final float a;
    public final float b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<t70> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.Vec2", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("x", false);
            pluginGeneratedSerialDescriptor.addElement("y", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            return new KSerializer[]{floatSerializer, floatSerializer};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            float fDecodeFloatElement;
            float fDecodeFloatElement2;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 0);
                fDecodeFloatElement2 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 1);
                i = 3;
            } else {
                fDecodeFloatElement = 0.0f;
                float fDecodeFloatElement3 = 0.0f;
                boolean z = true;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        fDecodeFloatElement3 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 1);
                        i2 |= 2;
                    }
                }
                fDecodeFloatElement2 = fDecodeFloatElement3;
                i = i2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new t70(i, fDecodeFloatElement, fDecodeFloatElement2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            t70 t70Var = (t70) obj;
            encoder.getClass();
            t70Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 0, t70Var.a);
            compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 1, t70Var.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<t70> serializer() {
            return a.a;
        }
    }

    public t70(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final String toString() {
        return "Vec2(" + this.a + ", " + this.b + ")";
    }

    public /* synthetic */ t70(int i, float f, float f2) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = f;
        this.b = f2;
    }
}
