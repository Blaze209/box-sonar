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
public final class ng {
    public static final b Companion = new b();
    public static final Lazy<KSerializer<Object>>[] f = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.pspdfkit.internal.ng$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Alignment.INSTANCE.serializer();
        }
    }), null, null, null};
    public final Float a;
    public final Alignment b;
    public final zq c;
    public final Float d;
    public final Float e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<ng> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.ExternalControlState", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement(ViewProps.MAX_WIDTH, true);
            pluginGeneratedSerialDescriptor.addElement("alignment", false);
            pluginGeneratedSerialDescriptor.addElement("modificationsCharacterStyle", false);
            pluginGeneratedSerialDescriptor.addElement("lineSpacingFactor", true);
            pluginGeneratedSerialDescriptor.addElement("firstLineOffsetFromBody", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            Lazy<KSerializer<Object>>[] lazyArr = ng.f;
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(floatSerializer), lazyArr[1].getValue(), zq.a.a, BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer)};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            Float f;
            Alignment alignment;
            zq zqVar;
            Float f2;
            Float f3;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = ng.f;
            Float f4 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
                Float f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, floatSerializer, null);
                Alignment alignment2 = (Alignment) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), null);
                zq zqVar2 = (zq) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, zq.a.a, null);
                Float f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, floatSerializer, null);
                alignment = alignment2;
                f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, floatSerializer, null);
                f2 = f6;
                i = 31;
                zqVar = zqVar2;
                f = f5;
            } else {
                boolean z = true;
                int i2 = 0;
                Alignment alignment3 = null;
                zq zqVar3 = null;
                Float f7 = null;
                Float f8 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        f4 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, f4);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        alignment3 = (Alignment) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), alignment3);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        zqVar3 = (zq) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, zq.a.a, zqVar3);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, f7);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        f8 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, f8);
                        i2 |= 16;
                    }
                }
                i = i2;
                f = f4;
                alignment = alignment3;
                zqVar = zqVar3;
                f2 = f7;
                f3 = f8;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new ng(i, f, alignment, zqVar, f2, f3);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            ng ngVar = (ng) obj;
            encoder.getClass();
            ngVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = ng.f;
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || ngVar.a != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, FloatSerializer.INSTANCE, ngVar.a);
            }
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), ngVar.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, zq.a.a, ngVar.c);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || ngVar.d != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, ngVar.d);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || ngVar.e != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, ngVar.e);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<ng> serializer() {
            return a.a;
        }
    }

    public ng(Float f2, Alignment alignment, zq zqVar, Float f3) {
        alignment.getClass();
        zqVar.getClass();
        this.a = f2;
        this.b = alignment;
        this.c = zqVar;
        this.d = f3;
        this.e = null;
    }

    public /* synthetic */ ng(int i, Float f2, Alignment alignment, zq zqVar, Float f3, Float f4) {
        if (6 != (i & 6)) {
            PluginExceptionsKt.throwMissingFieldException(i, 6, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = f2;
        }
        this.b = alignment;
        this.c = zqVar;
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = f3;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = f4;
        }
    }
}
