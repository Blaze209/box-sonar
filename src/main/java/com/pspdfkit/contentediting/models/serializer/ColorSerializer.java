package com.pspdfkit.contentediting.models.serializer;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u001b\u0012\u0017\u0012\u00150\u0002j\u0002`\u0005¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0019\u0010\u0010\u001a\u00150\u0002j\u0002`\u0005¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u0000H\u0096\u0080\u0004J*\u0010\u0011\u001a\u00150\u0002j\u0002`\u0005¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\t0\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0014R\u0015\u0010\b\u001a\u00020\tX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0015\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/contentediting/models/serializer/ColorSerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/Serializable;", "with", "Lcom/pspdfkit/contentediting/models/ContentColor;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Integer;", "BASE", "PREFIX", "", "SUPPORTED_DIGITS", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ColorSerializer implements KSerializer<Integer> {
    public static final int BASE = 16;
    public static final char PREFIX = '#';
    public static final int SUPPORTED_DIGITS = 6;
    public static final ColorSerializer INSTANCE = new ColorSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Color", PrimitiveKind.STRING.INSTANCE);
    public static final int $stable = 8;

    private ColorSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        serialize(encoder, ((Number) obj).intValue());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Integer deserialize(Decoder decoder) {
        decoder.getClass();
        return Integer.valueOf(Integer.parseInt(StringsKt.takeLast(decoder.decodeString(), 6), CharsKt.checkRadix(16)) | (-16777216));
    }

    public void serialize(Encoder encoder, int value) {
        encoder.getClass();
        encoder.encodeString(new StringBuilder(7).append(PREFIX).append(StringsKt.padStart(StringsKt.takeLast(UStringsKt.m16142toStringV7xB4Y4(UInt.m14875constructorimpl(value), 16), 6), 6, '0')).toString());
    }
}
