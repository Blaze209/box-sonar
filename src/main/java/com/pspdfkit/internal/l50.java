package com.pspdfkit.internal;

import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.contentediting.models.Alignment;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class l50 extends m50 {
    public static final b Companion = new b();
    public static final Lazy<KSerializer<Object>>[] h = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.pspdfkit.internal.l50$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Alignment.INSTANCE.serializer();
        }
    }), null, null, null, null, null};
    public t70 a;
    public Alignment b;
    public final aj c;
    public Float d;
    public final Float e;
    public Float f;
    public final zq g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<l50> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.TextBlockState", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("anchor", false);
            pluginGeneratedSerialDescriptor.addElement("alignment", false);
            pluginGeneratedSerialDescriptor.addElement("globalEffects", false);
            pluginGeneratedSerialDescriptor.addElement("lineSpacingFactor", true);
            pluginGeneratedSerialDescriptor.addElement("firstLineOffsetFromBody", true);
            pluginGeneratedSerialDescriptor.addElement(ViewProps.MAX_WIDTH, true);
            pluginGeneratedSerialDescriptor.addElement("modificationsCharacterStyle", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            Lazy<KSerializer<Object>>[] lazyArr = l50.h;
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            return new KSerializer[]{t70.a.a, lazyArr[1].getValue(), aj.a.a, BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), zq.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            Alignment alignment;
            aj ajVar;
            Float f;
            Float f2;
            zq zqVar;
            Float f3;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = l50.h;
            int i2 = 6;
            t70 t70Var = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                t70 t70Var2 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, t70.a.a, null);
                Alignment alignment2 = (Alignment) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), null);
                aj ajVar2 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aj.a.a, null);
                FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
                Float f4 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, floatSerializer, null);
                Float f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, floatSerializer, null);
                Float f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, floatSerializer, null);
                alignment = alignment2;
                t70Var = t70Var2;
                zqVar = (zq) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, zq.a.a, null);
                f3 = f6;
                f = f4;
                f2 = f5;
                ajVar = ajVar2;
                i = 127;
            } else {
                int i3 = 1;
                boolean z = true;
                int i4 = 0;
                zq zqVar2 = null;
                Float f7 = null;
                alignment = null;
                ajVar = null;
                f = null;
                f2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i3 = 1;
                            i2 = 6;
                            break;
                        case 0:
                            t70Var = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, t70.a.a, t70Var);
                            i4 |= 1;
                            i3 = 1;
                            i2 = 6;
                            break;
                        case 1:
                            alignment = (Alignment) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, lazyArr[i3].getValue(), alignment);
                            i4 |= 2;
                            i2 = 6;
                            break;
                        case 2:
                            ajVar = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aj.a.a, ajVar);
                            i4 |= 4;
                            i2 = 6;
                            break;
                        case 3:
                            f = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, f);
                            i4 |= 8;
                            break;
                        case 4:
                            f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, f2);
                            i4 |= 16;
                            break;
                        case 5:
                            f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, FloatSerializer.INSTANCE, f7);
                            i4 |= 32;
                            break;
                        case 6:
                            zqVar2 = (zq) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i2, zq.a.a, zqVar2);
                            i4 |= 64;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                zqVar = zqVar2;
                f3 = f7;
                i = i4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new l50(i, t70Var, alignment, ajVar, f, f2, f3, zqVar);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            l50 l50Var = (l50) obj;
            encoder.getClass();
            l50Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = l50.h;
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, t70.a.a, l50Var.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), l50Var.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, aj.a.a, l50Var.c);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || l50Var.d != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, l50Var.d);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || l50Var.e != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, l50Var.e);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || l50Var.f != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, FloatSerializer.INSTANCE, l50Var.f);
            }
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 6, zq.a.a, l50Var.g);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<l50> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ l50(int i, t70 t70Var, Alignment alignment, aj ajVar, Float f, Float f2, Float f3, zq zqVar) {
        if (71 != (i & 71)) {
            PluginExceptionsKt.throwMissingFieldException(i, 71, a.a.getDescriptor());
        }
        this.a = t70Var;
        this.b = alignment;
        this.c = ajVar;
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = f;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = f2;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = f3;
        }
        this.g = zqVar;
    }

    @Override // com.pspdfkit.internal.m50
    public final Alignment a() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.m50
    public final t70 b() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.m50
    public final Float c() {
        return this.f;
    }
}
