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
public final class n50 extends m50 {
    public static final b Companion = new b();
    public static final Lazy<KSerializer<Object>>[] g = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.pspdfkit.internal.n50$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Alignment.INSTANCE.serializer();
        }
    }), null, null, null, null};
    public final t70 a;
    public final Alignment b;
    public final aj c;
    public final Float d;
    public final Float e;
    public final Float f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<n50> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.TextBlockStateEssentials", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement("anchor", false);
            pluginGeneratedSerialDescriptor.addElement("alignment", false);
            pluginGeneratedSerialDescriptor.addElement("globalEffects", false);
            pluginGeneratedSerialDescriptor.addElement("lineSpacingFactor", true);
            pluginGeneratedSerialDescriptor.addElement("firstLineOffsetFromBody", true);
            pluginGeneratedSerialDescriptor.addElement(ViewProps.MAX_WIDTH, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            Lazy<KSerializer<Object>>[] lazyArr = n50.g;
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            return new KSerializer[]{t70.a.a, lazyArr[1].getValue(), aj.a.a, BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer)};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            t70 t70Var;
            Alignment alignment;
            aj ajVar;
            Float f;
            Float f2;
            Float f3;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = n50.g;
            int i2 = 5;
            t70 t70Var2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                t70Var = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, t70.a.a, null);
                Alignment alignment2 = (Alignment) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), null);
                aj ajVar2 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aj.a.a, null);
                FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
                Float f4 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, floatSerializer, null);
                Float f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, floatSerializer, null);
                alignment = alignment2;
                i = 63;
                f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, floatSerializer, null);
                f = f4;
                ajVar = ajVar2;
                f2 = f5;
            } else {
                boolean z = true;
                int i3 = 0;
                Alignment alignment3 = null;
                aj ajVar3 = null;
                Float f6 = null;
                Float f7 = null;
                Float f8 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 5;
                            break;
                        case 0:
                            t70Var2 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, t70.a.a, t70Var2);
                            i3 |= 1;
                            i2 = 5;
                            break;
                        case 1:
                            alignment3 = (Alignment) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), alignment3);
                            i3 |= 2;
                            break;
                        case 2:
                            ajVar3 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aj.a.a, ajVar3);
                            i3 |= 4;
                            break;
                        case 3:
                            f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, f6);
                            i3 |= 8;
                            break;
                        case 4:
                            f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, f7);
                            i3 |= 16;
                            break;
                        case 5:
                            f8 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, FloatSerializer.INSTANCE, f8);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                i = i3;
                t70Var = t70Var2;
                alignment = alignment3;
                ajVar = ajVar3;
                f = f6;
                f2 = f7;
                f3 = f8;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new n50(i, t70Var, alignment, ajVar, f, f2, f3);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            n50 n50Var = (n50) obj;
            encoder.getClass();
            n50Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = n50.g;
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, t70.a.a, n50Var.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), n50Var.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, aj.a.a, n50Var.c);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || n50Var.d != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, n50Var.d);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || n50Var.e != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, n50Var.e);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || n50Var.f != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, FloatSerializer.INSTANCE, n50Var.f);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<n50> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ n50(int i, t70 t70Var, Alignment alignment, aj ajVar, Float f, Float f2, Float f3) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
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
