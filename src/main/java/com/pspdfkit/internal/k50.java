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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class k50 extends j50 {
    public static final b Companion = new b();
    public final String c;
    public final n50 d;
    public final i70 e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<k50> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.TextBlockEssentials", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("id", false);
            pluginGeneratedSerialDescriptor.addElement("textBlock", false);
            pluginGeneratedSerialDescriptor.addElement("updateInfo", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, n50.a.a, i70.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String strDecodeStringElement;
            n50 n50Var;
            i70 i70Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            String strDecodeStringElement2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                n50Var = (n50) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, n50.a.a, null);
                i70Var = (i70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, i70.a.a, null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                n50 n50Var2 = null;
                i70 i70Var2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        n50Var2 = (n50) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, n50.a.a, n50Var2);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        i70Var2 = (i70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, i70.a.a, i70Var2);
                        i2 |= 4;
                    }
                }
                i = i2;
                strDecodeStringElement = strDecodeStringElement2;
                n50Var = n50Var2;
                i70Var = i70Var2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new k50(i, strDecodeStringElement, n50Var, i70Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            k50 k50Var = (k50) obj;
            encoder.getClass();
            k50Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, k50Var.c);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, n50.a.a, k50Var.d);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, i70.a.a, k50Var.e);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<k50> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ k50(int i, String str, n50 n50Var, i70 i70Var) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
        }
        this.c = str;
        this.d = n50Var;
        this.e = i70Var;
    }

    @Override // com.pspdfkit.internal.j50
    public final String a() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.j50
    public final m50 b() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.j50
    public final h70 c() {
        return this.e;
    }
}
