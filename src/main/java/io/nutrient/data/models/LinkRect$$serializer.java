package io.nutrient.data.models;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.JsonIgnoreUnknownKeys;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/nutrient/data/models/LinkRect.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/nutrient/data/models/LinkRect;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LinkRect$$serializer implements GeneratedSerializer<LinkRect> {
    public static final int $stable;
    public static final LinkRect$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LinkRect$$serializer linkRect$$serializer = new LinkRect$$serializer();
        INSTANCE = linkRect$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.nutrient.data.models.LinkRect", linkRect$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(ViewProps.TOP, false);
        pluginGeneratedSerialDescriptor.addElement("left", false);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        pluginGeneratedSerialDescriptor.pushClassAnnotation(new JsonIgnoreUnknownKeys() { // from class: io.nutrient.data.models.LinkRect$$serializer$annotationImpl$kotlinx_serialization_json_JsonIgnoreUnknownKeys$0
            @Override // java.lang.annotation.Annotation
            public final /* synthetic */ Class annotationType() {
                return JsonIgnoreUnknownKeys.class;
            }

            @Override // java.lang.annotation.Annotation
            public final boolean equals(Object obj) {
                return obj instanceof JsonIgnoreUnknownKeys;
            }

            @Override // java.lang.annotation.Annotation
            public final int hashCode() {
                return 0;
            }

            @Override // java.lang.annotation.Annotation
            public final String toString() {
                return "@kotlinx.serialization.json.JsonIgnoreUnknownKeys()";
            }
        });
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LinkRect$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{doubleSerializer, doubleSerializer, doubleSerializer, doubleSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LinkRect deserialize(Decoder decoder) {
        int i;
        double dDecodeDoubleElement;
        double d;
        double d2;
        double d3;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            double dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 0);
            double dDecodeDoubleElement3 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 1);
            double dDecodeDoubleElement4 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 2);
            dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 3);
            d = dDecodeDoubleElement4;
            d2 = dDecodeDoubleElement2;
            d3 = dDecodeDoubleElement3;
            i = 15;
        } else {
            double dDecodeDoubleElement5 = 0.0d;
            boolean z = true;
            int i2 = 0;
            double dDecodeDoubleElement6 = 0.0d;
            double dDecodeDoubleElement7 = 0.0d;
            double dDecodeDoubleElement8 = 0.0d;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    dDecodeDoubleElement7 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    dDecodeDoubleElement8 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    dDecodeDoubleElement6 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    dDecodeDoubleElement5 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            i = i2;
            dDecodeDoubleElement = dDecodeDoubleElement5;
            d = dDecodeDoubleElement6;
            d2 = dDecodeDoubleElement7;
            d3 = dDecodeDoubleElement8;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LinkRect(i, d2, d3, d, dDecodeDoubleElement, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LinkRect value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        LinkRect.write$Self$sdk_nutrient(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
