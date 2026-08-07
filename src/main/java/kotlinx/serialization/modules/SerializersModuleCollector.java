package kotlinx.serialization.modules;

import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import sdk.pendo.io.actions.GuideActionConfiguration;

/* JADX INFO: compiled from: SerializersModuleCollector.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0096\u0080\u0004JS\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062/\u0010\t\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\nH¦\u0080\u0004JH\u0010\u000f\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u0001\"\b\b\u0001\u0010\u0011*\u0002H\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\bH¦\u0080\u0004JM\u0010\u0015\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062)\u0010\u0016\u001a%\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u00180\nH¦\u0080\u0004JO\u0010\u0019\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u001d0\nH¦\u0080\u0004JO\u0010\u001e\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u001d0\nH\u0097\u0080\u0004¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleCollector;", "", "contextual", "", ExifInterface.GPS_DIRECTION_TRUE, "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "typeArgumentsSerializers", "polymorphic", GuideActionConfiguration.GUIDE_WIDGET_BASE_BUILDING_BLOCK_NAME, "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "", "className", "Lkotlinx/serialization/DeserializationStrategy;", "polymorphicDefault", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public interface SerializersModuleCollector {
    /* JADX INFO: Access modifiers changed from: private */
    static KSerializer contextual$lambda$0(KSerializer kSerializer, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return kSerializer;
    }

    <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider);

    <Base, Sub extends Base> void polymorphic(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer);

    <Base> void polymorphicDefaultDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider);

    <Base> void polymorphicDefaultSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider);

    /* JADX INFO: compiled from: SerializersModuleCollector.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> void contextual(SerializersModuleCollector serializersModuleCollector, KClass<T> kClass, KSerializer<T> serializer) {
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            SerializersModuleCollector.super.contextual(kClass, serializer);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
        @Deprecated
        public static <Base> void polymorphicDefault(SerializersModuleCollector serializersModuleCollector, KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
            Intrinsics.checkNotNullParameter(baseClass, "baseClass");
            Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
            SerializersModuleCollector.super.polymorphicDefault(baseClass, defaultDeserializerProvider);
        }
    }

    default <T> void contextual(KClass<T> kClass, final KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        contextual(kClass, new Function1() { // from class: kotlinx.serialization.modules.SerializersModuleCollector$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SerializersModuleCollector.contextual$lambda$0(serializer, (List) obj);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
    default <Base> void polymorphicDefault(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider);
    }
}
