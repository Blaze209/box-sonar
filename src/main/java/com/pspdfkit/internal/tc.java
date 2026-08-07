package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.FaceMismatch;
import com.pspdfkit.contentediting.models.FaceMismatch$$serializer;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.contentediting.models.StyleInfo$$serializer;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class tc {
    public static final b Companion = new b();
    public zq a;
    public final FaceMismatch b;
    public final StyleInfo c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<tc> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.DetectedStyle", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("modificationsCharacterStyle", true);
            pluginGeneratedSerialDescriptor.addElement("modificationsCharacterStyleFaceMismatch", true);
            pluginGeneratedSerialDescriptor.addElement("selectionStyleInfo", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(zq.a.a), BuiltinSerializersKt.getNullable(FaceMismatch$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StyleInfo$$serializer.INSTANCE)};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            zq zqVar;
            FaceMismatch faceMismatch;
            StyleInfo styleInfo;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            zq zqVar2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                zqVar = (zq) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, zq.a.a, null);
                faceMismatch = (FaceMismatch) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FaceMismatch$$serializer.INSTANCE, null);
                styleInfo = (StyleInfo) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StyleInfo$$serializer.INSTANCE, null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                FaceMismatch faceMismatch2 = null;
                StyleInfo styleInfo2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        zqVar2 = (zq) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, zq.a.a, zqVar2);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        faceMismatch2 = (FaceMismatch) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FaceMismatch$$serializer.INSTANCE, faceMismatch2);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        styleInfo2 = (StyleInfo) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StyleInfo$$serializer.INSTANCE, styleInfo2);
                        i2 |= 4;
                    }
                }
                i = i2;
                zqVar = zqVar2;
                faceMismatch = faceMismatch2;
                styleInfo = styleInfo2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new tc(i, zqVar, faceMismatch, styleInfo);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            tc tcVar = (tc) obj;
            encoder.getClass();
            tcVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || tcVar.a != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, zq.a.a, tcVar.a);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || tcVar.b != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, FaceMismatch$$serializer.INSTANCE, tcVar.b);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || tcVar.c != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StyleInfo$$serializer.INSTANCE, tcVar.c);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<tc> serializer() {
            return a.a;
        }
    }

    public tc() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public /* synthetic */ tc(int i, zq zqVar, FaceMismatch faceMismatch, StyleInfo styleInfo) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = zqVar;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = faceMismatch;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = styleInfo;
        }
    }

    public tc(zq zqVar, FaceMismatch faceMismatch, StyleInfo styleInfo) {
        this.a = zqVar;
        this.b = faceMismatch;
        this.c = styleInfo;
    }
}
