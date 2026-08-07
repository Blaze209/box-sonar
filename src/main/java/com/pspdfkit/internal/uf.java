package com.pspdfkit.internal;

import io.split.android.grammar.Treatments;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class uf {
    public static final b Companion = new b();
    public final int a;
    public final t70 b;
    public final t70 c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final UInt h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<uf> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.Element", aVar, 8);
            pluginGeneratedSerialDescriptor.addElement("cluster", false);
            pluginGeneratedSerialDescriptor.addElement("offset", false);
            pluginGeneratedSerialDescriptor.addElement("advance", false);
            pluginGeneratedSerialDescriptor.addElement("text", false);
            pluginGeneratedSerialDescriptor.addElement("lastOfSegment", false);
            pluginGeneratedSerialDescriptor.addElement("beginOfWord", false);
            pluginGeneratedSerialDescriptor.addElement("endOfWord", false);
            pluginGeneratedSerialDescriptor.addElement(Treatments.CONTROL, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(UIntSerializer.INSTANCE);
            t70.a aVar = t70.a.a;
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            return new KSerializer[]{IntSerializer.INSTANCE, aVar, aVar, StringSerializer.INSTANCE, booleanSerializer, booleanSerializer, booleanSerializer, nullable};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int iDecodeIntElement;
            t70 t70Var;
            int i;
            String str;
            boolean z;
            t70 t70Var2;
            boolean z2;
            UInt uInt;
            boolean z3;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 7;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                t70.a aVar = t70.a.a;
                t70 t70Var3 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, aVar, null);
                t70 t70Var4 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aVar, null);
                String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 6);
                i = 255;
                uInt = (UInt) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, UIntSerializer.INSTANCE, null);
                z3 = zDecodeBooleanElement3;
                z = zDecodeBooleanElement2;
                str = strDecodeStringElement;
                z2 = zDecodeBooleanElement;
                t70Var = t70Var4;
                t70Var2 = t70Var3;
            } else {
                boolean z4 = true;
                iDecodeIntElement = 0;
                boolean zDecodeBooleanElement4 = false;
                boolean zDecodeBooleanElement5 = false;
                int i3 = 0;
                UInt uInt2 = null;
                t70 t70Var5 = null;
                String strDecodeStringElement2 = null;
                boolean zDecodeBooleanElement6 = false;
                t70 t70Var6 = null;
                while (z4) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z4 = false;
                            break;
                        case 0:
                            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                            i3 |= 1;
                            i2 = 7;
                            break;
                        case 1:
                            t70Var5 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, t70.a.a, t70Var5);
                            i3 |= 2;
                            i2 = 7;
                            break;
                        case 2:
                            t70Var6 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, t70.a.a, t70Var6);
                            i3 |= 4;
                            i2 = 7;
                            break;
                        case 3:
                            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                            i3 |= 8;
                            break;
                        case 4:
                            zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                            i3 |= 16;
                            break;
                        case 5:
                            zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                            i3 |= 32;
                            break;
                        case 6:
                            zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 6);
                            i3 |= 64;
                            break;
                        case 7:
                            uInt2 = (UInt) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, UIntSerializer.INSTANCE, uInt2);
                            i3 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                boolean z5 = zDecodeBooleanElement5;
                t70Var = t70Var6;
                i = i3;
                str = strDecodeStringElement2;
                z = zDecodeBooleanElement4;
                t70Var2 = t70Var5;
                z2 = z5;
                uInt = uInt2;
                z3 = zDecodeBooleanElement6;
            }
            int i4 = iDecodeIntElement;
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new uf(i, i4, t70Var2, t70Var, str, z2, z, z3, uInt);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            uf ufVar = (uf) obj;
            encoder.getClass();
            ufVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, ufVar.a);
            t70.a aVar = t70.a.a;
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, aVar, ufVar.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, aVar, ufVar.c);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, ufVar.d);
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 4, ufVar.e);
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 5, ufVar.f);
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 6, ufVar.g);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || ufVar.h != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, UIntSerializer.INSTANCE, ufVar.h);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<uf> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ uf(int i, int i2, t70 t70Var, t70 t70Var2, String str, boolean z, boolean z2, boolean z3, UInt uInt) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, a.a.getDescriptor());
        }
        this.a = i2;
        this.b = t70Var;
        this.c = t70Var2;
        this.d = str;
        this.e = z;
        this.f = z2;
        this.g = z3;
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = uInt;
        }
    }
}
