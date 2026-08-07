package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.utils.Size;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
public final class pk extends ha<a> {
    public final NativeContentEditingCommand d;
    public final SerializationStrategy<a> e;
    public final a f;

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public final String a;
        public final ng b;
        public final String c;
        public final Integer d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.pk$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0282a implements GeneratedSerializer<a> {
            public static final C0282a a;
            private static final SerialDescriptor descriptor;

            static {
                C0282a c0282a = new C0282a();
                a = c0282a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.InsertText.Input", c0282a, 4);
                pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
                pluginGeneratedSerialDescriptor.addElement("externalControlState", false);
                pluginGeneratedSerialDescriptor.addElement("text", false);
                pluginGeneratedSerialDescriptor.addElement("cursor", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                KSerializer<?> nullable = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                return new KSerializer[]{stringSerializer, ng.a.a, stringSerializer, nullable};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String str;
                ng ngVar;
                String str2;
                Integer num;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                String strDecodeStringElement = null;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    ng ngVar2 = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ng.a.a, null);
                    String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    str = strDecodeStringElement2;
                    num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, null);
                    str2 = strDecodeStringElement3;
                    ngVar = ngVar2;
                    i = 15;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    ng ngVar3 = null;
                    String strDecodeStringElement4 = null;
                    Integer num2 = null;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else if (iDecodeElementIndex == 0) {
                            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else if (iDecodeElementIndex == 1) {
                            ngVar3 = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ng.a.a, ngVar3);
                            i2 |= 2;
                        } else if (iDecodeElementIndex == 2) {
                            strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                            i2 |= 4;
                        } else {
                            if (iDecodeElementIndex != 3) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num2);
                            i2 |= 8;
                        }
                    }
                    i = i2;
                    str = strDecodeStringElement;
                    ngVar = ngVar3;
                    str2 = strDecodeStringElement4;
                    num = num2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new a(i, str, ngVar, str2, num);
            }

            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                a aVar = (a) obj;
                encoder.getClass();
                aVar.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
                compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, aVar.a);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, ng.a.a, aVar.b);
                compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, aVar.c);
                if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || aVar.d != null) {
                    compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, aVar.d);
                }
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0282a.a;
            }
        }

        public /* synthetic */ a(int i, String str, ng ngVar, String str2, Integer num) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, C0282a.a.getDescriptor());
            }
            this.a = str;
            this.b = ngVar;
            this.c = str2;
            if ((i & 8) == 0) {
                this.d = null;
            } else {
                this.d = num;
            }
        }

        public a(String str, ng ngVar, String str2, Integer num) {
            str.getClass();
            str2.getClass();
            this.a = str;
            this.b = ngVar;
            this.c = str2;
            this.d = num;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk(i50 i50Var, Size size, String str, Integer num) {
        super(i50Var, size);
        i50Var.getClass();
        str.getClass();
        this.d = NativeContentEditingCommand.INSERT_TEXT;
        this.e = a.Companion.serializer();
        this.f = new a(i50Var.c, i50Var.e(), str, num);
    }

    @Override // com.pspdfkit.internal.ga
    public final Object b() {
        return this.f;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy<a> c() {
        return this.e;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.d;
    }
}
