package expo.modules.kotlin.records;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.allocators.ObjectConstructor;
import expo.modules.kotlin.allocators.ObjectConstructorFactory;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.FieldCastException;
import expo.modules.kotlin.exception.FieldRequiredException;
import expo.modules.kotlin.exception.RecordCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00011B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001eJ'\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J'\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010'J;\u0010(\u001a\u00028\u00002\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0004\b+\u0010,J&\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00010.\"\b\b\u0001\u0010\u0001*\u00020\u00112\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u000100H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00120\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00062"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "type", "Lkotlin/reflect/KType;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "objectConstructorFactory", "Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "propertyDescriptors", "", "Lkotlin/reflect/KProperty1;", "", "Lexpo/modules/kotlin/records/RecordTypeConverter$PropertyDescriptor;", "getPropertyDescriptors", "()Ljava/util/Map;", "propertyDescriptors$delegate", "Lkotlin/Lazy;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/AppContext;Z)Lexpo/modules/kotlin/records/Record;", "convertFromAny", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;Z)Lexpo/modules/kotlin/records/Record;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;Lexpo/modules/kotlin/AppContext;Z)Lexpo/modules/kotlin/records/Record;", "convertFromMap", "map", "", "convertFromMap$expo_modules_core_release", "(Ljava/util/Map;Lexpo/modules/kotlin/AppContext;Z)Lexpo/modules/kotlin/records/Record;", "getObjectConstructor", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", "clazz", "Lkotlin/reflect/KClass;", "PropertyDescriptor", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordTypeConverter<T extends Record> extends DynamicAwareTypeConverters<T> {
    public static final int $stable = 8;
    private final TypeConverterProvider converterProvider;
    private final ObjectConstructorFactory objectConstructorFactory;

    /* JADX INFO: renamed from: propertyDescriptors$delegate, reason: from kotlin metadata */
    private final Lazy propertyDescriptors;
    private final KType type;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public final KType getType() {
        return this.type;
    }

    public RecordTypeConverter(TypeConverterProvider converterProvider, KType type) {
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(type, "type");
        this.converterProvider = converterProvider;
        this.type = type;
        this.objectConstructorFactory = new ObjectConstructorFactory();
        this.propertyDescriptors = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.records.RecordTypeConverter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RecordTypeConverter.propertyDescriptors_delegate$lambda$1(this.f$0);
            }
        });
    }

    private final Map<KProperty1<? extends Object, ?>, PropertyDescriptor> getPropertyDescriptors() {
        return (Map) this.propertyDescriptors.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map propertyDescriptors_delegate$lambda$1(RecordTypeConverter recordTypeConverter) {
        Object obj;
        Object next;
        KClassifier classifier = recordTypeConverter.type.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        Collection<KProperty1> memberProperties = KClasses.getMemberProperties((KClass) classifier);
        ArrayList arrayList = new ArrayList();
        for (KProperty1 kProperty1 : memberProperties) {
            KProperty1 kProperty2 = kProperty1;
            Iterator<T> it = kProperty2.getAnnotations().iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((Annotation) next) instanceof Field));
            Field field = (Field) next;
            if (field != null) {
                TypeConverter<?> typeConverterObtainTypeConverter = recordTypeConverter.converterProvider.obtainTypeConverter(kProperty1.getReturnType());
                for (Object obj2 : kProperty2.getAnnotations()) {
                    if (((Annotation) obj2) instanceof Required) {
                        obj = obj2;
                        break;
                    }
                }
                obj = TuplesKt.to(kProperty1, new PropertyDescriptor(typeConverterObtainTypeConverter, field, ((Required) obj) != null));
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public T convertFromDynamic(Dynamic value, AppContext context, boolean forceConversion) throws RecordCastException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            ReadableMap readableMapAsMap = value.asMap();
            if (readableMapAsMap != null) {
                return (T) convertFromReadableMap(readableMapAsMap, context, forceConversion);
            }
            throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableMap.class));
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                String code = codedException.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new RecordCastException(getType(), unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public T convertFromAny(Object value, AppContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof ReadableMap) {
            return (T) convertFromReadableMap((ReadableMap) value, context, forceConversion);
        }
        if (value instanceof Map) {
            return (T) convertFromMap$expo_modules_core_release((Map) value, context, forceConversion);
        }
        return (T) value;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.READABLE_MAP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T convertFromReadableMap(ReadableMap jsMap, AppContext context, boolean forceConversion) throws FieldRequiredException {
        UnexpectedException unexpectedException;
        KClassifier classifier = this.type.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        T tConstruct = getObjectConstructor((KClass) classifier).construct();
        for (Map.Entry<KProperty1<? extends Object, ?>, PropertyDescriptor> entry : getPropertyDescriptors().entrySet()) {
            KProperty1<? extends Object, ?> key = entry.getKey();
            PropertyDescriptor value = entry.getValue();
            String strKey = value.getFieldAnnotation().key();
            if (StringsKt.isBlank(strKey)) {
                strKey = null;
            }
            if (strKey == null) {
                strKey = key.getName();
            }
            if (!jsMap.hasKey(strKey)) {
                if (value.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Dynamic dynamic = jsMap.getDynamic(strKey);
                try {
                    java.lang.reflect.Field javaField = ReflectJvmMapping.getJavaField(key);
                    Intrinsics.checkNotNull(javaField);
                    try {
                        Object objConvert = value.getTypeConverter().convert(dynamic, context, forceConversion);
                        javaField.setAccessible(true);
                        javaField.set(tConstruct, objConvert);
                        Unit unit = Unit.INSTANCE;
                        dynamic.recycle();
                    } catch (Throwable th) {
                        if (th instanceof CodedException) {
                            unexpectedException = (CodedException) th;
                        } else if (th instanceof expo.modules.core.errors.CodedException) {
                            String code = ((expo.modules.core.errors.CodedException) th).getCode();
                            Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                            unexpectedException = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                        } else {
                            unexpectedException = new UnexpectedException(th);
                        }
                        throw new FieldCastException(key.getName(), key.getReturnType(), dynamic.getType(), unexpectedException);
                    }
                } catch (Throwable th2) {
                    dynamic.recycle();
                    throw th2;
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.RecordTypeConverter");
        return tConstruct;
    }

    public static /* synthetic */ Record convertFromMap$expo_modules_core_release$default(RecordTypeConverter recordTypeConverter, Map map, AppContext appContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            appContext = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return recordTypeConverter.convertFromMap$expo_modules_core_release(map, appContext, z);
    }

    public final T convertFromMap$expo_modules_core_release(Map<String, ? extends Object> map, AppContext context, boolean forceConversion) throws IllegalAccessException, FieldCastException, FieldRequiredException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(map, "map");
        KClassifier classifier = this.type.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        T tConstruct = getObjectConstructor((KClass) classifier).construct();
        for (Map.Entry<KProperty1<? extends Object, ?>, PropertyDescriptor> entry : getPropertyDescriptors().entrySet()) {
            KProperty1<? extends Object, ?> key = entry.getKey();
            PropertyDescriptor value = entry.getValue();
            String strKey = value.getFieldAnnotation().key();
            if (StringsKt.isBlank(strKey)) {
                strKey = null;
            }
            if (strKey == null) {
                strKey = key.getName();
            }
            if (!map.containsKey(strKey)) {
                if (value.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Double dValueOf = map.get(strKey);
                if (dValueOf instanceof Number) {
                    KClassifier classifier2 = key.getReturnType().getClassifier();
                    if (Intrinsics.areEqual(classifier2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        dValueOf = Integer.valueOf(((Number) dValueOf).intValue());
                    } else if (Intrinsics.areEqual(classifier2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        dValueOf = Long.valueOf(((Number) dValueOf).longValue());
                    } else if (Intrinsics.areEqual(classifier2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        dValueOf = Float.valueOf(((Number) dValueOf).floatValue());
                    } else {
                        dValueOf = Intrinsics.areEqual(classifier2, Reflection.getOrCreateKotlinClass(Double.TYPE)) ? Double.valueOf(((Number) dValueOf).doubleValue()) : (Number) dValueOf;
                    }
                }
                java.lang.reflect.Field javaField = ReflectJvmMapping.getJavaField(key);
                Intrinsics.checkNotNull(javaField);
                try {
                    Object objConvert = value.getTypeConverter().convert(dValueOf, context, forceConversion);
                    javaField.setAccessible(true);
                    javaField.set(tConstruct, objConvert);
                } catch (Throwable th) {
                    if (th instanceof CodedException) {
                        unexpectedException = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                        String code = codedException.getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th);
                    }
                    throw new FieldCastException(key.getName(), key.getReturnType(), getType(), unexpectedException);
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.RecordTypeConverter");
        return tConstruct;
    }

    private final <T> ObjectConstructor<T> getObjectConstructor(KClass<T> clazz) {
        return this.objectConstructorFactory.get(clazz);
    }

    /* JADX INFO: compiled from: RecordTypeConverter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter$PropertyDescriptor;", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "fieldAnnotation", "Lexpo/modules/kotlin/records/Field;", "isRequired", "", "<init>", "(Lexpo/modules/kotlin/types/TypeConverter;Lexpo/modules/kotlin/records/Field;Z)V", "getTypeConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "getFieldAnnotation", "()Lexpo/modules/kotlin/records/Field;", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class PropertyDescriptor {
        private final Field fieldAnnotation;
        private final boolean isRequired;
        private final TypeConverter<?> typeConverter;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PropertyDescriptor copy$default(PropertyDescriptor propertyDescriptor, TypeConverter typeConverter, Field field, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                typeConverter = propertyDescriptor.typeConverter;
            }
            if ((i & 2) != 0) {
                field = propertyDescriptor.fieldAnnotation;
            }
            if ((i & 4) != 0) {
                z = propertyDescriptor.isRequired;
            }
            return propertyDescriptor.copy(typeConverter, field, z);
        }

        public final TypeConverter<?> component1() {
            return this.typeConverter;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Field getFieldAnnotation() {
            return this.fieldAnnotation;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRequired() {
            return this.isRequired;
        }

        public final PropertyDescriptor copy(TypeConverter<?> typeConverter, Field fieldAnnotation, boolean isRequired) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(fieldAnnotation, "fieldAnnotation");
            return new PropertyDescriptor(typeConverter, fieldAnnotation, isRequired);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PropertyDescriptor)) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) other;
            return Intrinsics.areEqual(this.typeConverter, propertyDescriptor.typeConverter) && Intrinsics.areEqual(this.fieldAnnotation, propertyDescriptor.fieldAnnotation) && this.isRequired == propertyDescriptor.isRequired;
        }

        public int hashCode() {
            return (((this.typeConverter.hashCode() * 31) + this.fieldAnnotation.hashCode()) * 31) + Boolean.hashCode(this.isRequired);
        }

        public String toString() {
            return "PropertyDescriptor(typeConverter=" + this.typeConverter + ", fieldAnnotation=" + this.fieldAnnotation + ", isRequired=" + this.isRequired + ")";
        }

        public PropertyDescriptor(TypeConverter<?> typeConverter, Field fieldAnnotation, boolean z) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(fieldAnnotation, "fieldAnnotation");
            this.typeConverter = typeConverter;
            this.fieldAnnotation = fieldAnnotation;
            this.isRequired = z;
        }

        public final TypeConverter<?> getTypeConverter() {
            return this.typeConverter;
        }

        public final Field getFieldAnnotation() {
            return this.fieldAnnotation;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }
    }
}
