package com.pspdfkit.internal;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UInt;
import kotlin.jvm.functions.Function0;
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
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class g70 extends h70 {
    public static final b Companion = new b();
    public final ob c;
    public dc d;
    public tc e;
    public final nn f;
    public final int g;
    public t00 h;
    public final Lazy i;
    public final Lazy j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<g70> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.UpdateInfo", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement("contentRect", false);
            pluginGeneratedSerialDescriptor.addElement("cursor", false);
            pluginGeneratedSerialDescriptor.addElement("detectedStyle", false);
            pluginGeneratedSerialDescriptor.addElement("layoutView", false);
            pluginGeneratedSerialDescriptor.addElement("version", false);
            pluginGeneratedSerialDescriptor.addElement("selection", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{ob.a.a, dc.a.a, tc.a.a, nn.a.a, UIntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(t00.a.a)};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            UInt uInt;
            t00 t00Var;
            tc tcVar;
            nn nnVar;
            ob obVar;
            dc dcVar;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 5;
            ob obVar2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                ob obVar3 = (ob) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ob.a.a, null);
                dc dcVar2 = (dc) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, dc.a.a, null);
                tc tcVar2 = (tc) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, tc.a.a, null);
                nn nnVar2 = (nn) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, nn.a.a, null);
                UInt uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, UIntSerializer.INSTANCE, null);
                obVar = obVar3;
                t00Var = (t00) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, t00.a.a, null);
                nnVar = nnVar2;
                uInt = uInt2;
                tcVar = tcVar2;
                dcVar = dcVar2;
                i = 63;
            } else {
                boolean z = true;
                int i3 = 0;
                dc dcVar3 = null;
                tc tcVar3 = null;
                nn nnVar3 = null;
                UInt uInt3 = null;
                t00 t00Var2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 5;
                            break;
                        case 0:
                            obVar2 = (ob) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ob.a.a, obVar2);
                            i3 |= 1;
                            i2 = 5;
                            break;
                        case 1:
                            dcVar3 = (dc) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, dc.a.a, dcVar3);
                            i3 |= 2;
                            break;
                        case 2:
                            tcVar3 = (tc) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, tc.a.a, tcVar3);
                            i3 |= 4;
                            break;
                        case 3:
                            nnVar3 = (nn) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, nn.a.a, nnVar3);
                            i3 |= 8;
                            break;
                        case 4:
                            uInt3 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, UIntSerializer.INSTANCE, uInt3);
                            i3 |= 16;
                            break;
                        case 5:
                            t00Var2 = (t00) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, t00.a.a, t00Var2);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                uInt = uInt3;
                t00Var = t00Var2;
                tcVar = tcVar3;
                nnVar = nnVar3;
                obVar = obVar2;
                dcVar = dcVar3;
                i = i3;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new g70(i, obVar, dcVar, tcVar, nnVar, uInt, t00Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            g70 g70Var = (g70) obj;
            encoder.getClass();
            g70Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, ob.a.a, g70Var.c);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, dc.a.a, g70Var.d);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, tc.a.a, g70Var.e);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, nn.a.a, g70Var.f);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, UIntSerializer.INSTANCE, UInt.m14869boximpl(g70Var.g));
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || g70Var.h != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, t00.a.a, g70Var.h);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<g70> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ g70(int i, ob obVar, dc dcVar, tc tcVar, nn nnVar, UInt uInt, t00 t00Var) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, a.a.getDescriptor());
        }
        this.c = obVar;
        this.d = dcVar;
        this.e = tcVar;
        this.f = nnVar;
        this.g = uInt.getData();
        if ((i & 32) == 0) {
            this.h = null;
        } else {
            this.h = t00Var;
        }
        this.i = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.g70$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g70.a(this.f$0);
            }
        });
        this.j = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.g70$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(g70.b(this.f$0));
            }
        });
    }

    public static final float b(g70 g70Var) {
        return ip.a(20.0f, ((Number) g70Var.f.b.getValue()).floatValue());
    }

    @Override // com.pspdfkit.internal.h70
    public final ob a() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.h70
    public final String c() {
        return (String) this.i.getValue();
    }

    public static final String a(g70 g70Var) {
        return (String) g70Var.f.c.getValue();
    }

    public final int a(List<qn> list) {
        int iIntValue;
        int iIntValue2;
        list.getClass();
        List<qn> list2 = this.f.a;
        if (list2.size() != list.size()) {
            iIntValue = list2.size();
            iIntValue2 = list.size();
        } else {
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                qn qnVar = list2.get(i);
                qn qnVar2 = list.get(i);
                if (((Number) qnVar.d.getValue()).intValue() != ((Number) qnVar2.d.getValue()).intValue()) {
                    iIntValue = ((Number) qnVar.d.getValue()).intValue();
                    iIntValue2 = ((Number) qnVar2.d.getValue()).intValue();
                }
            }
            return 0;
        }
        return iIntValue - iIntValue2;
    }

    @Override // com.pspdfkit.internal.h70
    public final float b() {
        return ((Number) this.j.getValue()).floatValue();
    }
}
