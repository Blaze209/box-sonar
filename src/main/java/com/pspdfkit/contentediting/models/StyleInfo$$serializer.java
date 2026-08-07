package com.pspdfkit.contentediting.models;

import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/pspdfkit/contentediting/models/StyleInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/pspdfkit/contentediting/models/StyleInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class StyleInfo$$serializer implements GeneratedSerializer<StyleInfo> {
    public static final int $stable;
    public static final StyleInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        StyleInfo$$serializer styleInfo$$serializer = new StyleInfo$$serializer();
        INSTANCE = styleInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.contentediting.models.StyleInfo", styleInfo$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("family", true);
        pluginGeneratedSerialDescriptor.addElement("faceMismatch", true);
        pluginGeneratedSerialDescriptor.addElement("bold", true);
        pluginGeneratedSerialDescriptor.addElement("italic", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("color", true);
        pluginGeneratedSerialDescriptor.addElement("xScale", true);
        pluginGeneratedSerialDescriptor.addElement("skew", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private StyleInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(FaceMismatch$$serializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(booleanSerializer);
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(ColorSerializer.INSTANCE), BuiltinSerializersKt.getNullable(floatSerializer), BuiltinSerializersKt.getNullable(floatSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final StyleInfo deserialize(Decoder decoder) {
        Float f;
        String str;
        Boolean bool;
        Float f2;
        Integer num;
        FaceMismatch faceMismatch;
        Boolean bool2;
        Float f3;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        String str2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            FaceMismatch faceMismatch2 = (FaceMismatch) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FaceMismatch$$serializer.INSTANCE, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, booleanSerializer, null);
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, booleanSerializer, null);
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            Float f4 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, floatSerializer, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ColorSerializer.INSTANCE, null);
            Float f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, floatSerializer, null);
            f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, floatSerializer, null);
            f = f5;
            num = num2;
            bool2 = bool4;
            f2 = f4;
            bool = bool3;
            i = 255;
            faceMismatch = faceMismatch2;
            str = str3;
        } else {
            boolean z = true;
            int i3 = 0;
            Float f6 = null;
            Float f7 = null;
            Integer num3 = null;
            FaceMismatch faceMismatch3 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            Float f8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str2);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        faceMismatch3 = (FaceMismatch) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FaceMismatch$$serializer.INSTANCE, faceMismatch3);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        f8 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, FloatSerializer.INSTANCE, f8);
                        i3 |= 16;
                        break;
                    case 5:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ColorSerializer.INSTANCE, num3);
                        i3 |= 32;
                        break;
                    case 6:
                        f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FloatSerializer.INSTANCE, f7);
                        i3 |= 64;
                        break;
                    case 7:
                        f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, FloatSerializer.INSTANCE, f6);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Float f9 = f8;
            f = f7;
            str = str2;
            bool = bool5;
            f2 = f9;
            Boolean bool7 = bool6;
            num = num3;
            faceMismatch = faceMismatch3;
            bool2 = bool7;
            f3 = f6;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new StyleInfo(i, str, faceMismatch, bool, bool2, f2, num, f, f3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, StyleInfo value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        StyleInfo.write$Self$sdk_nutrient(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
