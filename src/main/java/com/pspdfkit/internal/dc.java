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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class dc {
    public static final b Companion = new b();
    public final int a;
    public final ao b;
    public final t70 c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<dc> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.Cursor", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("cluster", false);
            pluginGeneratedSerialDescriptor.addElement("lineSpacing", false);
            pluginGeneratedSerialDescriptor.addElement("offset", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{IntSerializer.INSTANCE, ao.a.a, t70.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int iDecodeIntElement;
            int i;
            ao aoVar;
            t70 t70Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                aoVar = (ao) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ao.a.a, null);
                t70Var = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, t70.a.a, null);
                i = 7;
            } else {
                boolean z = true;
                iDecodeIntElement = 0;
                ao aoVar2 = null;
                t70 t70Var2 = null;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        aoVar2 = (ao) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ao.a.a, aoVar2);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        t70Var2 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, t70.a.a, t70Var2);
                        i2 |= 4;
                    }
                }
                i = i2;
                aoVar = aoVar2;
                t70Var = t70Var2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new dc(i, iDecodeIntElement, aoVar, t70Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            dc dcVar = (dc) obj;
            encoder.getClass();
            dcVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, dcVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, ao.a.a, dcVar.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, t70.a.a, dcVar.c);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<dc> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ dc(int i, int i2, ao aoVar, t70 t70Var) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
        }
        this.a = i2;
        this.b = aoVar;
        this.c = t70Var;
    }

    public final String toString() {
        return "Cursor(cluster=" + this.a + ", offset=" + this.c + ")";
    }
}
