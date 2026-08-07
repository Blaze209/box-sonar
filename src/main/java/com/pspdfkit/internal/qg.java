package com.pspdfkit.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class qg {
    public static final b Companion = new b();
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<qg> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.FaceVariant", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("bold", false);
            pluginGeneratedSerialDescriptor.addElement("italic", false);
            pluginGeneratedSerialDescriptor.addElement("postScriptName", true);
            pluginGeneratedSerialDescriptor.addElement("fontFilePath", true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
            KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(stringSerializer);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            return new KSerializer[]{booleanSerializer, booleanSerializer, nullable, nullable2};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            boolean zDecodeBooleanElement;
            boolean z;
            int i;
            String str;
            String str2;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
                boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
                str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
                str = str3;
                z = zDecodeBooleanElement2;
                i = 15;
            } else {
                boolean z2 = true;
                zDecodeBooleanElement = false;
                int i2 = 0;
                String str4 = null;
                String str5 = null;
                boolean zDecodeBooleanElement3 = false;
                while (z2) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z2 = false;
                    } else if (iDecodeElementIndex == 0) {
                        zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str4);
                        i2 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str5);
                        i2 |= 8;
                    }
                }
                z = zDecodeBooleanElement3;
                i = i2;
                str = str4;
                str2 = str5;
            }
            boolean z3 = zDecodeBooleanElement;
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new qg(i, z3, z, str, str2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            qg qgVar = (qg) obj;
            encoder.getClass();
            qgVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 0, qgVar.a);
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 1, qgVar.b);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || qgVar.c != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, qgVar.c);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || qgVar.d != null) {
                compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, qgVar.d);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<qg> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ qg(int i, boolean z, boolean z2, String str, String str2) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = z;
        this.b = z2;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str2;
        }
    }

    public static final CharSequence a(Pair pair) {
        pair.getClass();
        return (CharSequence) pair.getFirst();
    }

    public final String toString() {
        List listListOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("bold", Boolean.valueOf(this.a)), TuplesKt.to("italic", Boolean.valueOf(this.b))});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((Boolean) ((Pair) obj).getSecond()).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, Marker.ANY_NON_NULL_MARKER, "(", ")", 0, null, new Function1() { // from class: com.pspdfkit.internal.qg$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return qg.a((Pair) obj2);
            }
        }, 24, null);
    }

    public qg(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = null;
        this.d = null;
    }
}
