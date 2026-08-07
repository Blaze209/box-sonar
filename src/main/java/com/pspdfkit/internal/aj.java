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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class aj {
    public static final b Companion = new b();
    public final float a;
    public final boolean b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<aj> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.GlobalEffects", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("rotation", false);
            pluginGeneratedSerialDescriptor.addElement("flipY", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{FloatSerializer.INSTANCE, BooleanSerializer.INSTANCE};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            float fDecodeFloatElement;
            boolean zDecodeBooleanElement;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 0);
                zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                i = 3;
            } else {
                fDecodeFloatElement = 0.0f;
                boolean z = true;
                boolean zDecodeBooleanElement2 = false;
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
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i2 |= 2;
                    }
                }
                zDecodeBooleanElement = zDecodeBooleanElement2;
                i = i2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new aj(i, fDecodeFloatElement, zDecodeBooleanElement);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            aj ajVar = (aj) obj;
            encoder.getClass();
            ajVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 0, ajVar.a);
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 1, ajVar.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<aj> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ aj(int i, float f, boolean z) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = f;
        this.b = z;
    }
}
