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
public final class zq {
    public static final b Companion = new b();
    public final int a;
    public final jo b;
    public final c7 c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<zq> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.ModificationsCharacterStyle", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("color", false);
            pluginGeneratedSerialDescriptor.addElement("effects", false);
            pluginGeneratedSerialDescriptor.addElement("fontRef", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{ColorSerializer.INSTANCE, jo.a.a, c7.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int iIntValue;
            int i;
            jo joVar;
            c7 c7Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, 0)).intValue();
                joVar = (jo) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, jo.a.a, null);
                c7Var = (c7) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, c7.a.a, null);
                i = 7;
            } else {
                boolean z = true;
                iIntValue = 0;
                jo joVar2 = null;
                c7 c7Var2 = null;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue))).intValue();
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        joVar2 = (jo) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, jo.a.a, joVar2);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        c7Var2 = (c7) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, c7.a.a, c7Var2);
                        i2 |= 4;
                    }
                }
                i = i2;
                joVar = joVar2;
                c7Var = c7Var2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new zq(i, iIntValue, joVar, c7Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            zq zqVar = (zq) obj;
            encoder.getClass();
            zqVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, Integer.valueOf(zqVar.a));
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, jo.a.a, zqVar.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, c7.a.a, zqVar.c);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<zq> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ zq(int i, int i2, jo joVar, c7 c7Var) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
        }
        this.a = i2;
        this.b = joVar;
        this.c = c7Var;
    }

    public zq(int i, jo joVar, c7 c7Var) {
        this.a = i;
        this.b = joVar;
        this.c = c7Var;
    }
}
