package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.Size;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.DeserializationStrategy;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class cc extends ga<a, i50> {
    public final Size a;
    public final a c;
    public final KSerializer<a> b = a.Companion.serializer();
    public final KSerializer<i50> d = i50.Companion.serializer();

    public cc(int i, Size size) {
        this.a = size;
        this.c = new a(i);
    }

    @Override // com.pspdfkit.internal.ga
    public final void a(i50 i50Var, NativeContentEditingResult nativeContentEditingResult) {
        i50 i50Var2 = i50Var;
        i50Var2.getClass();
        nativeContentEditingResult.getClass();
        i50Var2.a(this.a);
    }

    @Override // com.pspdfkit.internal.ga
    public final a b() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy<a> c() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return NativeContentEditingCommand.CREATE_TEXT_BLOCK;
    }

    @Override // com.pspdfkit.internal.ga
    public final DeserializationStrategy<i50> f() {
        return this.d;
    }

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public final int a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.cc$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0258a implements GeneratedSerializer<a> {
            public static final C0258a a;
            private static final SerialDescriptor descriptor;

            static {
                C0258a c0258a = new C0258a();
                a = c0258a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.CreateTextBlock.Input", c0258a, 1);
                pluginGeneratedSerialDescriptor.addElement("pageIndex", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{IntSerializer.INSTANCE};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int iDecodeIntElement;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                int i = 1;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                } else {
                    boolean z = true;
                    iDecodeIntElement = 0;
                    int i2 = 0;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else {
                            if (iDecodeElementIndex != 0) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                            i2 = 1;
                        }
                    }
                    i = i2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new a(i, iDecodeIntElement);
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
                compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, aVar.a);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0258a.a;
            }
        }

        public a(int i) {
            this.a = i;
        }

        public /* synthetic */ a(int i, int i2) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, C0258a.a.getDescriptor());
            }
            this.a = i2;
        }
    }
}
