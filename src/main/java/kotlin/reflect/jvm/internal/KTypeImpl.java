package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\bH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0001H\u0016J\u0013\u00103\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u000104H\u0096\u0002J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0016\u0010*\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010 R\u0014\u0010/\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010 R\u0014\u00100\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010 ¨\u00069²\u0006\u0010\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/jvm/internal/AbstractKType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "isAbbreviation", "", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;Z)V", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "convert", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "isMarkedNullable", "()Z", "annotations", "", "getAnnotations", "isSubtypeOf", "other", "makeNullableAsSpecified", "nullable", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "abbreviation", "Lkotlin/reflect/KType;", "getAbbreviation", "()Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "isNothingType", "isMutableCollectionType", "lowerBoundIfFlexible", "upperBoundIfFlexible", "equals", "", "hashCode", "", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeImpl extends AbstractKType {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: arguments$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal arguments;

    /* JADX INFO: renamed from: classifier$delegate, reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal classifier;
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    private final boolean isAbbreviation;
    private final KotlinType type;

    /* JADX INFO: compiled from: KTypeImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KTypeImpl(KotlinType type, final Function0<? extends Type> function0, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.isAbbreviation = z;
        ReflectProperties.LazySoftVal<Type> lazySoftValLazySoft = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = function0 instanceof ReflectProperties.LazySoftVal ? (ReflectProperties.LazySoftVal) function0 : null;
        if (lazySoftVal != null) {
            lazySoftValLazySoft = lazySoftVal;
        } else if (function0 != null) {
            lazySoftValLazySoft = ReflectProperties.lazySoft(function0);
        }
        this.computeJavaType = lazySoftValLazySoft;
        this.classifier = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$0
            private final KTypeImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KTypeImpl.classifier_delegate$lambda$0(this.arg$0);
            }
        });
        this.arguments = ReflectProperties.lazySoft(new Function0(this, function0) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$1
            private final KTypeImpl arg$0;
            private final Function0 arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KTypeImpl.arguments_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
    }

    public final KotlinType getType() {
        return this.type;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KTypeImpl(KotlinType type, Function0<? extends Type> function0) {
        this(type, function0, false);
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier classifier_delegate$lambda$0(KTypeImpl kTypeImpl) {
        return kTypeImpl.convert(kTypeImpl.type);
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.classifier.getValue(this, $$delegatedProperties[0]);
    }

    private final KClassifier convert(KotlinType type) {
        KotlinType type2;
        if (this.isAbbreviation) {
            ClassifierDescriptor classifierDescriptorMo16080getDeclarationDescriptor = type.getConstructor().mo16080getDeclarationDescriptor();
            NotFoundClasses.MockClassDescriptor mockClassDescriptor = classifierDescriptorMo16080getDeclarationDescriptor instanceof NotFoundClasses.MockClassDescriptor ? (NotFoundClasses.MockClassDescriptor) classifierDescriptorMo16080getDeclarationDescriptor : null;
            if (mockClassDescriptor != null) {
                return new KTypeAliasImpl(DescriptorUtilsKt.getFqNameSafe(mockClassDescriptor));
            }
        }
        ClassifierDescriptor classifierDescriptorMo16080getDeclarationDescriptor2 = type.getConstructor().mo16080getDeclarationDescriptor();
        if (classifierDescriptorMo16080getDeclarationDescriptor2 instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) classifierDescriptorMo16080getDeclarationDescriptor2);
            if (javaClass == null) {
                return null;
            }
            if (KotlinBuiltIns.isArray(type)) {
                TypeProjection typeProjection = (TypeProjection) CollectionsKt.singleOrNull((List) type.getArguments());
                if (typeProjection == null || (type2 = typeProjection.getType()) == null) {
                    return new KClassImpl(javaClass);
                }
                KClassifier kClassifierConvert = convert(TypeUtilsKt.makeNullable(type2));
                if (kClassifierConvert == null) {
                    throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(kClassifierConvert))));
            }
            if (!TypeUtils.isNullableType(type)) {
                Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                if (primitiveByWrapper != null) {
                    javaClass = primitiveByWrapper;
                }
                return new KClassImpl(javaClass);
            }
            return new KClassImpl(javaClass);
        }
        if (classifierDescriptorMo16080getDeclarationDescriptor2 instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) classifierDescriptorMo16080getDeclarationDescriptor2);
        }
        return null;
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        T value = this.arguments.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$0(final KTypeImpl kTypeImpl, Function0 function0) {
        KTypeProjection kTypeProjectionInvariant;
        List<TypeProjection> arguments = kTypeImpl.type.getArguments();
        if (arguments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(kTypeImpl) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$2
            private final KTypeImpl arg$0;

            {
                this.arg$0 = kTypeImpl;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KTypeImpl.arguments_delegate$lambda$0$0(this.arg$0);
            }
        });
        List<TypeProjection> list = arguments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        final int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                kTypeProjectionInvariant = KTypeProjection.INSTANCE.getSTAR();
            } else {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                KTypeImpl kTypeImpl2 = new KTypeImpl(type, function0 == null ? null : new Function0(kTypeImpl, i, lazy) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$3
                    private final KTypeImpl arg$0;
                    private final int arg$1;
                    private final Lazy arg$2;

                    {
                        this.arg$0 = kTypeImpl;
                        this.arg$1 = i;
                        this.arg$2 = lazy;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        return KTypeImpl.arguments_delegate$lambda$0$2$0(this.arg$0, this.arg$1, this.arg$2);
                    }
                });
                int i3 = WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i3 == 1) {
                    kTypeProjectionInvariant = KTypeProjection.INSTANCE.invariant(kTypeImpl2);
                } else if (i3 == 2) {
                    kTypeProjectionInvariant = KTypeProjection.INSTANCE.contravariant(kTypeImpl2);
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    kTypeProjectionInvariant = KTypeProjection.INSTANCE.covariant(kTypeImpl2);
                }
            }
            arrayList.add(kTypeProjectionInvariant);
            i = i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$0$0(KTypeImpl kTypeImpl) {
        Type javaType = kTypeImpl.getJavaType();
        Intrinsics.checkNotNull(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }

    private static final List<Type> arguments_delegate$lambda$0$1(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type arguments_delegate$lambda$0$2$0(KTypeImpl kTypeImpl, int i, Lazy<? extends List<? extends Type>> lazy) {
        Type javaType = kTypeImpl.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNull(componentType);
            return componentType;
        }
        if (javaType instanceof GenericArrayType) {
            if (i != 0) {
                throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + kTypeImpl);
            }
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkNotNull(genericComponentType);
            return genericComponentType;
        }
        if (javaType instanceof ParameterizedType) {
            Type type = arguments_delegate$lambda$0$1(lazy).get(i);
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "getLowerBounds(...)");
            Type type2 = (Type) ArraysKt.firstOrNull(lowerBounds);
            if (type2 == null) {
                Type[] upperBounds = wildcardType.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                type2 = (Type) ArraysKt.first(upperBounds);
            }
            Intrinsics.checkNotNull(type2);
            return type2;
        }
        throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + kTypeImpl);
    }

    @Override // kotlin.reflect.KType
    /* JADX INFO: renamed from: isMarkedNullable */
    public boolean getIsMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isSubtypeOf(AbstractKType other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return TypeUtilsKt.isSubtypeOf(this.type, ((KTypeImpl) other).type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType makeNullableAsSpecified(boolean nullable) {
        if (!FlexibleTypesKt.isFlexible(this.type) && getIsMarkedNullable() == nullable) {
            return this;
        }
        KotlinType kotlinTypeMakeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.type, nullable);
        Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNullableAsSpecified, "makeNullableAsSpecified(...)");
        return new KTypeImpl(kotlinTypeMakeNullableAsSpecified, this.computeJavaType);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull) {
        SimpleType simpleType;
        SimpleType original;
        if (isDefinitelyNotNull) {
            DefinitelyNotNullType definitelyNotNullTypeMakeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, this.type.unwrap(), true, false, 4, null);
            simpleType = definitelyNotNullTypeMakeDefinitelyNotNull$default != null ? definitelyNotNullTypeMakeDefinitelyNotNull$default : this.type;
        } else {
            KotlinType kotlinType = this.type;
            DefinitelyNotNullType definitelyNotNullType = kotlinType instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) kotlinType : null;
            simpleType = (definitelyNotNullType == null || (original = definitelyNotNullType.getOriginal()) == null) ? this.type : original;
        }
        return new KTypeImpl(simpleType, this.computeJavaType);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public KType getAbbreviation() {
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(this.type);
        return abbreviation != null ? new KTypeImpl(abbreviation, this.computeJavaType, true) : null;
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isDefinitelyNotNullType() {
        return SpecialTypesKt.isDefinitelyNotNullType(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isNothingType() {
        return KotlinBuiltIns.isNothingOrNullableNothing(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isMutableCollectionType() {
        ClassifierDescriptor classifierDescriptorMo16080getDeclarationDescriptor = this.type.getConstructor().mo16080getDeclarationDescriptor();
        ClassDescriptor classDescriptor = classifierDescriptorMo16080getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo16080getDeclarationDescriptor : null;
        return classDescriptor != null && JavaToKotlinClassMapper.INSTANCE.isMutable(classDescriptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType lowerBoundIfFlexible() {
        UnwrappedType unwrappedTypeUnwrap = this.type.unwrap();
        Function0 function0 = null;
        Object[] objArr = 0;
        if (unwrappedTypeUnwrap instanceof FlexibleType) {
            return new KTypeImpl(((FlexibleType) unwrappedTypeUnwrap).getLowerBound(), function0, 2, objArr == true ? 1 : 0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType upperBoundIfFlexible() {
        UnwrappedType unwrappedTypeUnwrap = this.type.unwrap();
        Function0 function0 = null;
        Object[] objArr = 0;
        if (unwrappedTypeUnwrap instanceof FlexibleType) {
            return new KTypeImpl(((FlexibleType) unwrappedTypeUnwrap).getUpperBound(), function0, 2, objArr == true ? 1 : 0);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (!(other instanceof KTypeImpl)) {
            return false;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) other;
        return Intrinsics.areEqual(this.type, kTypeImpl.type) && Intrinsics.areEqual(getClassifier(), kTypeImpl.getClassifier()) && Intrinsics.areEqual(getArguments(), kTypeImpl.getArguments());
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        KClassifier classifier = getClassifier();
        return ((iHashCode + (classifier != null ? classifier.hashCode() : 0)) * 31) + getArguments().hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this);
    }
}
