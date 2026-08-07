package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.Size;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.DeserializationStrategy;
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

/* JADX INFO: loaded from: classes3.dex */
public class zi extends ga<b, List<? extends k50>> {
    public final Size a;
    public final String b;
    public final KSerializer<b> c;
    public final b d;

    public zi(int i, Size size) {
        size.getClass();
        this.a = size;
        this.b = "(page " + i + ")";
        this.c = b.Companion.serializer();
        this.d = new b(i);
    }

    @Override // com.pspdfkit.internal.ga
    public final void a(List<? extends k50> list, NativeContentEditingResult nativeContentEditingResult) {
        List<? extends k50> list2 = list;
        list2.getClass();
        nativeContentEditingResult.getClass();
        a.a(this.a).invoke(list2, nativeContentEditingResult);
    }

    @Override // com.pspdfkit.internal.ga
    public final b b() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy<b> c() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ga
    public final DeserializationStrategy<List<? extends k50>> f() {
        return BuiltinSerializersKt.ListSerializer(k50.Companion.serializer());
    }

    @Serializable
    public static final class b {
        public static final C0297b Companion = new C0297b();
        public final int a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class a implements GeneratedSerializer<b> {
            public static final a a;
            private static final SerialDescriptor descriptor;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.GetTextBlocks.Input", aVar, 1);
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
                return new b(i, iDecodeIntElement);
            }

            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                b bVar = (b) obj;
                encoder.getClass();
                bVar.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
                compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, bVar.a);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        /* JADX INFO: renamed from: com.pspdfkit.internal.zi$b$b, reason: collision with other inner class name */
        public static final class C0297b {
            public final KSerializer<b> serializer() {
                return a.a;
            }
        }

        public b(int i) {
            this.a = i;
        }

        public /* synthetic */ b(int i, int i2) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, a.a.getDescriptor());
            }
            this.a = i2;
        }
    }

    @Override // com.pspdfkit.internal.ga
    public final String a() {
        return this.b;
    }

    public static final class a {
        public static final Unit a(Size size, List list, NativeContentEditingResult nativeContentEditingResult) {
            list.getClass();
            nativeContentEditingResult.getClass();
            list.getClass();
            size.getClass();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((j50) it.next()).a(size);
            }
            return Unit.INSTANCE;
        }

        public static Function2 a(final Size size) {
            size.getClass();
            return new Function2() { // from class: com.pspdfkit.internal.zi$a$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return zi.a.a(size, (List) obj, (NativeContentEditingResult) obj2);
                }
            };
        }
    }
}
