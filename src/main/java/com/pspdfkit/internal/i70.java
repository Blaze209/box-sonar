package com.pspdfkit.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
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
public final class i70 extends h70 {
    public static final b Companion = new b();
    public final ob c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<i70> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.UpdateInfoEssentials", aVar, 1);
            pluginGeneratedSerialDescriptor.addElement("contentRect", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{ob.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            ob obVar;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            ob obVar2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                obVar = (ob) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ob.a.a, null);
            } else {
                boolean z = true;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else {
                        if (iDecodeElementIndex != 0) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        obVar2 = (ob) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ob.a.a, obVar2);
                        i2 = 1;
                    }
                }
                obVar = obVar2;
                i = i2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new i70(i, obVar);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            i70 i70Var = (i70) obj;
            encoder.getClass();
            i70Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, ob.a.a, i70Var.c);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<i70> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ i70(int i, ob obVar) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, a.a.getDescriptor());
        }
        this.c = obVar;
    }

    @Override // com.pspdfkit.internal.h70
    public final ob a() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.h70
    public final String c() {
        return "UpdateInfoEssentials doesn't have text. Use UpdateInfo instead.";
    }
}
