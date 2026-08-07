package com.pspdfkit.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class sy {
    public static final b Companion = new b();
    public final t70 a;
    public final ob b;
    public final t70 c;
    public final aj d;
    public final ec e;
    public final r00 f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<sy> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.RenderTextBlockParams", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement("pixelPageSize", false);
            pluginGeneratedSerialDescriptor.addElement("pixelViewport", false);
            pluginGeneratedSerialDescriptor.addElement("pixelAnchor", false);
            pluginGeneratedSerialDescriptor.addElement("globalEffects", false);
            pluginGeneratedSerialDescriptor.addElement("cursor", true);
            pluginGeneratedSerialDescriptor.addElement("selection", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(ec.a.a);
            KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(r00.a.a);
            t70.a aVar = t70.a.a;
            return new KSerializer[]{aVar, ob.a.a, aVar, aj.a.a, nullable, nullable2};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            ec ecVar;
            r00 r00Var;
            t70 t70Var;
            aj ajVar;
            t70 t70Var2;
            ob obVar;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 5;
            t70 t70Var3 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                t70.a aVar = t70.a.a;
                t70 t70Var4 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, aVar, null);
                ob obVar2 = (ob) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ob.a.a, null);
                t70 t70Var5 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aVar, null);
                aj ajVar2 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, aj.a.a, null);
                ec ecVar2 = (ec) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ec.a.a, null);
                t70Var = t70Var5;
                r00Var = (r00) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, r00.a.a, null);
                ajVar = ajVar2;
                ecVar = ecVar2;
                i = 63;
                obVar = obVar2;
                t70Var2 = t70Var4;
            } else {
                boolean z = true;
                int i3 = 0;
                ob obVar3 = null;
                t70 t70Var6 = null;
                aj ajVar3 = null;
                ec ecVar3 = null;
                r00 r00Var2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 5;
                            break;
                        case 0:
                            t70Var3 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, t70.a.a, t70Var3);
                            i3 |= 1;
                            i2 = 5;
                            break;
                        case 1:
                            obVar3 = (ob) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ob.a.a, obVar3);
                            i3 |= 2;
                            break;
                        case 2:
                            t70Var6 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, t70.a.a, t70Var6);
                            i3 |= 4;
                            break;
                        case 3:
                            ajVar3 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, aj.a.a, ajVar3);
                            i3 |= 8;
                            break;
                        case 4:
                            ecVar3 = (ec) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ec.a.a, ecVar3);
                            i3 |= 16;
                            break;
                        case 5:
                            r00Var2 = (r00) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, r00.a.a, r00Var2);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                ecVar = ecVar3;
                r00Var = r00Var2;
                t70Var = t70Var6;
                ajVar = ajVar3;
                t70Var2 = t70Var3;
                obVar = obVar3;
                i = i3;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new sy(i, t70Var2, obVar, t70Var, ajVar, ecVar, r00Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            sy syVar = (sy) obj;
            encoder.getClass();
            syVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            t70.a aVar = t70.a.a;
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, aVar, syVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, ob.a.a, syVar.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, aVar, syVar.c);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, aj.a.a, syVar.d);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || syVar.e != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, ec.a.a, syVar.e);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || syVar.f != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, r00.a.a, syVar.f);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<sy> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ sy(int i, t70 t70Var, ob obVar, t70 t70Var2, aj ajVar, ec ecVar, r00 r00Var) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, a.a.getDescriptor());
        }
        this.a = t70Var;
        this.b = obVar;
        this.c = t70Var2;
        this.d = ajVar;
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = ecVar;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = r00Var;
        }
    }

    public sy(t70 t70Var, ob obVar, t70 t70Var2, aj ajVar, ec ecVar, r00 r00Var) {
        ajVar.getClass();
        this.a = t70Var;
        this.b = obVar;
        this.c = t70Var2;
        this.d = ajVar;
        this.e = ecVar;
        this.f = r00Var;
    }
}
