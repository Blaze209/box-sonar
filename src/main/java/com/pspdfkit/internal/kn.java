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
public class kn extends ha<a> {
    public final NativeContentEditingCommand d;
    public final KSerializer<a> e;
    public final a f;

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public final String a;
        public final ng b;
        public final Integer c;
        public final b9 d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.kn$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0275a implements GeneratedSerializer<a> {
            public static final C0275a a;
            private static final SerialDescriptor descriptor;

            static {
                C0275a c0275a = new C0275a();
                a = c0275a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.Layout.Input", c0275a, 4);
                pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
                pluginGeneratedSerialDescriptor.addElement("externalControlState", false);
                pluginGeneratedSerialDescriptor.addElement("cursor", true);
                pluginGeneratedSerialDescriptor.addElement("selection", true);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, ng.a.a, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(b9.a.a)};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String str;
                ng ngVar;
                Integer num;
                b9 b9Var;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                String strDecodeStringElement = null;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    ng ngVar2 = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ng.a.a, null);
                    Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, null);
                    str = strDecodeStringElement2;
                    b9Var = (b9) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, b9.a.a, null);
                    num = num2;
                    ngVar = ngVar2;
                    i = 15;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    ng ngVar3 = null;
                    Integer num3 = null;
                    b9 b9Var2 = null;
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
                            num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num3);
                            i2 |= 4;
                        } else {
                            if (iDecodeElementIndex != 3) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            b9Var2 = (b9) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, b9.a.a, b9Var2);
                            i2 |= 8;
                        }
                    }
                    i = i2;
                    str = strDecodeStringElement;
                    ngVar = ngVar3;
                    num = num3;
                    b9Var = b9Var2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new a(i, str, ngVar, num, b9Var);
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
                if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || aVar.c != null) {
                    compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, aVar.c);
                }
                if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || aVar.d != null) {
                    compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, b9.a.a, aVar.d);
                }
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0275a.a;
            }
        }

        public /* synthetic */ a(int i, String str, ng ngVar, Integer num, b9 b9Var) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, C0275a.a.getDescriptor());
            }
            this.a = str;
            this.b = ngVar;
            if ((i & 4) == 0) {
                this.c = null;
            } else {
                this.c = num;
            }
            if ((i & 8) == 0) {
                this.d = null;
            } else {
                this.d = b9Var;
            }
        }

        public a(String str, ng ngVar, Integer num, b9 b9Var) {
            str.getClass();
            this.a = str;
            this.b = ngVar;
            this.c = num;
            this.d = b9Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn(i50 i50Var, Size size, Integer num, b9 b9Var, ng ngVar) {
        super(i50Var, size);
        i50Var.getClass();
        this.d = NativeContentEditingCommand.LAYOUT;
        this.e = a.Companion.serializer();
        this.f = new a(i50Var.c, ngVar, num, b9Var);
    }

    @Override // com.pspdfkit.internal.ga
    public final Object b() {
        return this.f;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy c() {
        return this.e;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.d;
    }
}
