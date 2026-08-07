package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.utils.Size;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.UInt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes3.dex */
public final class kz extends ha<a> {
    public final NativeContentEditingCommand d;
    public final KSerializer<a> e;
    public final a f;

    public kz(i50 i50Var, Size size, int i, ng ngVar) {
        super(i50Var, size);
        this.d = NativeContentEditingCommand.RESTORE;
        this.e = a.Companion.serializer();
        this.f = new a(i50Var.c, i, ngVar);
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

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public final String a;
        public final int b;
        public final ng c;

        /* JADX INFO: renamed from: com.pspdfkit.internal.kz$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0276a implements GeneratedSerializer<a> {
            public static final C0276a a;
            private static final SerialDescriptor descriptor;

            static {
                C0276a c0276a = new C0276a();
                a = c0276a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.Restore.Input", c0276a, 3);
                pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
                pluginGeneratedSerialDescriptor.addElement("version", false);
                pluginGeneratedSerialDescriptor.addElement("externalControlState", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, UIntSerializer.INSTANCE, ng.a.a};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String strDecodeStringElement;
                UInt uInt;
                ng ngVar;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                String strDecodeStringElement2 = null;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    uInt = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, null);
                    ngVar = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, ng.a.a, null);
                    i = 7;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    UInt uInt2 = null;
                    ng ngVar2 = null;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else if (iDecodeElementIndex == 0) {
                            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else if (iDecodeElementIndex == 1) {
                            uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, uInt2);
                            i2 |= 2;
                        } else {
                            if (iDecodeElementIndex != 2) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            ngVar2 = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, ng.a.a, ngVar2);
                            i2 |= 4;
                        }
                    }
                    i = i2;
                    strDecodeStringElement = strDecodeStringElement2;
                    uInt = uInt2;
                    ngVar = ngVar2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new a(i, strDecodeStringElement, uInt, ngVar);
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
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, UInt.m14869boximpl(aVar.b));
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, ng.a.a, aVar.c);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0276a.a;
            }
        }

        public a(String str, int i, ng ngVar) {
            str.getClass();
            this.a = str;
            this.b = i;
            this.c = ngVar;
        }

        public /* synthetic */ a(int i, String str, UInt uInt, ng ngVar) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, C0276a.a.getDescriptor());
            }
            this.a = str;
            this.b = uInt.getData();
            this.c = ngVar;
        }
    }
}
