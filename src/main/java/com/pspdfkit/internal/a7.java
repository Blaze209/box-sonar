package com.pspdfkit.internal;

import com.facebook.hermes.intl.Constants;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class a7 {
    public static final b Companion = new b();
    public final String a;
    public final qg b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<a7> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.AvailableFaceRef", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("family", false);
            pluginGeneratedSerialDescriptor.addElement(Constants.SENSITIVITY_VARIANT, false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, qg.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String strDecodeStringElement;
            qg qgVar;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            String strDecodeStringElement2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                qgVar = (qg) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, qg.a.a, null);
                i = 3;
            } else {
                boolean z = true;
                int i2 = 0;
                qg qgVar2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        qgVar2 = (qg) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, qg.a.a, qgVar2);
                        i2 |= 2;
                    }
                }
                i = i2;
                strDecodeStringElement = strDecodeStringElement2;
                qgVar = qgVar2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new a7(i, strDecodeStringElement, qgVar);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            a7 a7Var = (a7) obj;
            encoder.getClass();
            a7Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, a7Var.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, qg.a.a, a7Var.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<a7> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ a7(int i, String str, qg qgVar) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = str;
        this.b = qgVar;
    }

    public a7(String str, qg qgVar) {
        str.getClass();
        this.a = str;
        this.b = qgVar;
    }
}
