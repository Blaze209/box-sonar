package com.pspdfkit.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.UInt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class qb {
    public static final b Companion = new b();
    public final String a;
    public final int b;
    public final b9 c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<qb> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.ContentRef", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
            pluginGeneratedSerialDescriptor.addElement("version", false);
            pluginGeneratedSerialDescriptor.addElement("range", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, UIntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(b9.a.a)};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String strDecodeStringElement;
            UInt uInt;
            b9 b9Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            String strDecodeStringElement2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                uInt = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, null);
                b9Var = (b9) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, b9.a.a, null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                UInt uInt2 = null;
                b9 b9Var2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, uInt2);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        b9Var2 = (b9) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, b9.a.a, b9Var2);
                        i2 |= 4;
                    }
                }
                i = i2;
                strDecodeStringElement = strDecodeStringElement2;
                uInt = uInt2;
                b9Var = b9Var2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new qb(i, strDecodeStringElement, uInt, b9Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            qb qbVar = (qb) obj;
            encoder.getClass();
            qbVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, qbVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, UInt.m14869boximpl(qbVar.b));
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || qbVar.c != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, b9.a.a, qbVar.c);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<qb> serializer() {
            return a.a;
        }
    }

    public qb(String str, int i, b9 b9Var) {
        str.getClass();
        this.a = str;
        this.b = i;
        this.c = b9Var;
    }

    public /* synthetic */ qb(int i, String str, UInt uInt, b9 b9Var) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = str;
        this.b = uInt.getData();
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = b9Var;
        }
    }
}
