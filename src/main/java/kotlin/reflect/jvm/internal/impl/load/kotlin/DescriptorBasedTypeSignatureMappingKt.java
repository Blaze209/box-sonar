package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v31, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType kotlinType, JvmTypeFactory<T> factory, TypeMappingMode mode, final TypeMappingConfiguration<? extends T> typeMappingConfiguration, JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> writeGenericType) {
        T t;
        KotlinType kotlinType2;
        Object objMapType;
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        Intrinsics.checkNotNullParameter(writeGenericType, "writeGenericType");
        KotlinType kotlinTypePreprocessType = typeMappingConfiguration.preprocessType(kotlinType);
        if (kotlinTypePreprocessType != null) {
            return (T) mapType(kotlinTypePreprocessType, factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        KotlinType kotlinType3 = kotlinType;
        Object objMapBuiltInType = TypeSignatureMappingKt.mapBuiltInType(SimpleClassicTypeSystemContext.INSTANCE, kotlinType3, factory, mode);
        if (objMapBuiltInType != null) {
            ?? r8 = (Object) TypeSignatureMappingKt.boxTypeIfNeeded(factory, objMapBuiltInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, r8, mode);
            return r8;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) constructor;
            KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.mo16081getSupertypes());
            }
            return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(alternativeType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        ClassifierDescriptor classifierDescriptorMo16080getDeclarationDescriptor = constructor.mo16080getDeclarationDescriptor();
        if (classifierDescriptorMo16080getDeclarationDescriptor == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        ClassifierDescriptor classifierDescriptor = classifierDescriptorMo16080getDeclarationDescriptor;
        if (ErrorUtils.isError(classifierDescriptor)) {
            T t2 = (T) factory.createObjectType("error/NonExistentClass");
            typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor) classifierDescriptorMo16080getDeclarationDescriptor);
            if (jvmDescriptorTypeWriter != 0) {
                jvmDescriptorTypeWriter.writeClass(t2);
            }
            return t2;
        }
        boolean z = classifierDescriptorMo16080getDeclarationDescriptor instanceof ClassDescriptor;
        if (z && KotlinBuiltIns.isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            TypeProjection typeProjection = kotlinType.getArguments().get(0);
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                objMapType = factory.createObjectType("java/lang/Object");
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayType();
                    jvmDescriptorTypeWriter.writeClass(objMapType);
                    jvmDescriptorTypeWriter.writeArrayEnd();
                }
            } else {
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayType();
                }
                Variance projectionKind = typeProjection.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                objMapType = mapType(type, factory, mode.toGenericArgumentMode(projectionKind, true), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayEnd();
                }
            }
            return (T) factory.createFromString("[" + factory.toString(objMapType));
        }
        if (z) {
            if (InlineClassesUtilsKt.isInlineClass(classifierDescriptor) && !mode.getNeedInlineClassWrapping() && (kotlinType2 = (KotlinType) ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(new ClassicTypeSystemContext() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt$mapType$typeSystemContext$1
                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public List<SimpleTypeMarker> fastCorrespondingSupertypes(RigidTypeMarker rigidTypeMarker, TypeConstructorMarker constructor2) {
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    Intrinsics.checkNotNullParameter(constructor2, "constructor");
                    return null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public KotlinTypeMarker makeNullable(KotlinTypeMarker kotlinTypeMarker) {
                    RigidTypeMarker rigidTypeMarkerWithNullability;
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
                    return (rigidTypeMarkerAsRigidType == null || (rigidTypeMarkerWithNullability = withNullability(rigidTypeMarkerAsRigidType, true)) == null) ? kotlinTypeMarker : rigidTypeMarkerWithNullability;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
                    return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, typeConstructorMarker, typeConstructorMarker2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ int argumentsCount(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ SimpleTypeMarker arrayType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.arrayType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentListMarker asArgumentList(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, simpleTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ DefinitelyNotNullTypeMarker asDefinitelyNotNullType(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, flexibleTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker asRigidType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asRigidType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleType captureFromArguments(RigidTypeMarker rigidTypeMarker, CaptureStatus captureStatus) {
                    return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, rigidTypeMarker, captureStatus);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ CaptureStatus captureStatus(CapturedTypeMarker capturedTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, capturedTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
                public /* bridge */ KotlinTypeMarker createFlexibleType(RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
                    return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, rigidTypeMarker, rigidTypeMarker2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i) {
                    return ClassicTypeSystemContext.DefaultImpls.getArgument(this, kotlinTypeMarker, i);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ List<TypeArgumentMarker> getArguments(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getArguments(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i) {
                    return ClassicTypeSystemContext.DefaultImpls.getParameter(this, typeConstructorMarker, i);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ List<TypeParameterMarker> getParameters(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getParameters(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ PrimitiveType getPrimitiveArrayType(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ PrimitiveType getPrimitiveType(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, typeParameterMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getType(this, typeArgumentMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeConstructorMarker getTypeConstructor(TypeParameterMarker typeParameterMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getTypeConstructor(this, typeParameterMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, typeVariableTypeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker typeParameterMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, typeParameterMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeVariance getVariance(TypeArgumentMarker typeArgumentMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getVariance(this, typeArgumentMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeVariance getVariance(TypeParameterMarker typeParameterMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.getVariance(this, typeParameterMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean hasAnnotation(KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
                    return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, kotlinTypeMarker, fqName);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean hasRecursiveBounds(TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, typeParameterMarker, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
                public /* bridge */ boolean identicalArguments(RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2) {
                    return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, rigidTypeMarker, rigidTypeMarker2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker intersectTypes(Collection<? extends KotlinTypeMarker> collection) {
                    return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, collection);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean isArrayOrNullableArray(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isArrayOrNullableArray(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isDenotable(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isError(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isError(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean isInlineClass(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isIntersection(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext
                public /* bridge */ boolean isK2() {
                    return ClassicTypeSystemContext.DefaultImpls.isK2(this);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isNotNullTypeParameter(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isNullableType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isOldCapturedType(CapturedTypeMarker capturedTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, capturedTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isPrimitiveType(SimpleTypeMarker simpleTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, simpleTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, capturedTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isRawType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isRawType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isSingleClassifierType(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isStarProjection(TypeArgumentMarker typeArgumentMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, typeArgumentMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isStubType(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isStubType(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isStubTypeForBuilderInference(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ boolean isTypeVariableType(KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ boolean isUnderKotlinPackage(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, flexibleTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.lowerType(this, capturedTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker, boolean z2) {
                    return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, kotlinTypeMarker, z2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeCheckerProviderContext
                public /* bridge */ TypeCheckerState newTypeCheckerState(boolean z2, boolean z3, boolean z4) {
                    return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, z2, z3, z4);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ SimpleTypeMarker nullableAnyType() {
                    return ClassicTypeSystemContext.DefaultImpls.nullableAnyType(this);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker original(DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.original(this, definitelyNotNullTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ int parametersCount(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ Collection<KotlinTypeMarker> possibleIntegerTypes(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeArgumentMarker projection(CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.projection(this, capturedTypeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker safeSubstitute(TypeSubstitutorMarker typeSubstitutorMarker, KotlinTypeMarker kotlinTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.safeSubstitute(this, typeSubstitutorMarker, kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker typeConstructorMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.supertypes(this, typeConstructorMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker capturedTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, capturedTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ TypeConstructorMarker typeConstructor(RigidTypeMarker rigidTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, rigidTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
                public /* bridge */ TypeSubstitutorMarker typeSubstitutorForUnderlyingType(Map<TypeConstructorMarker, ? extends KotlinTypeMarker> map) {
                    return ClassicTypeSystemContext.DefaultImpls.typeSubstitutorForUnderlyingType(this, map);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker) {
                    return ClassicTypeSystemContext.DefaultImpls.upperBound(this, flexibleTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z2) {
                    return ClassicTypeSystemContext.DefaultImpls.withNullability(this, kotlinTypeMarker, z2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public /* bridge */ SimpleTypeMarker withNullability(RigidTypeMarker rigidTypeMarker, boolean z2) {
                    return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, rigidTypeMarker, z2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
                public KotlinBuiltIns getBuiltIns() {
                    KotlinBuiltIns builtIns = typeMappingConfiguration.getBuiltIns();
                    return builtIns == null ? ClassicTypeSystemContext.DefaultImpls.getBuiltIns(this) : builtIns;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public CapturedTypeMarker asCapturedTypeUnwrappingDnn(RigidTypeMarker rigidTypeMarker) {
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    return asCapturedType(originalIfDefinitelyNotNullable(rigidTypeMarker));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isCapturedType(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
                    return (rigidTypeMarkerAsRigidType != null ? asCapturedTypeUnwrappingDnn(rigidTypeMarkerAsRigidType) : null) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public SimpleTypeMarker originalIfDefinitelyNotNullable(RigidTypeMarker rigidTypeMarker) {
                    SimpleTypeMarker simpleTypeMarkerOriginal;
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    DefinitelyNotNullTypeMarker definitelyNotNullTypeMarkerAsDefinitelyNotNullType = asDefinitelyNotNullType(rigidTypeMarker);
                    return (definitelyNotNullTypeMarkerAsDefinitelyNotNullType == null || (simpleTypeMarkerOriginal = original(definitelyNotNullTypeMarkerAsDefinitelyNotNullType)) == null) ? (SimpleTypeMarker) rigidTypeMarker : simpleTypeMarkerOriginal;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    return makeDefinitelyNotNullOrNotNull(kotlinTypeMarker, false);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public TypeArgumentMarker getArgumentOrNull(RigidTypeMarker rigidTypeMarker, int i) {
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    if (i < 0 || i >= argumentsCount(rigidTypeMarker)) {
                        return null;
                    }
                    return getArgument(rigidTypeMarker, i);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public RigidTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
                    RigidTypeMarker rigidTypeMarkerLowerBound;
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
                    if (flexibleTypeMarkerAsFlexibleType != null && (rigidTypeMarkerLowerBound = lowerBound(flexibleTypeMarkerAsFlexibleType)) != null) {
                        return rigidTypeMarkerLowerBound;
                    }
                    RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
                    Intrinsics.checkNotNull(rigidTypeMarkerAsRigidType);
                    return rigidTypeMarkerAsRigidType;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public RigidTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
                    RigidTypeMarker rigidTypeMarkerUpperBound;
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
                    if (flexibleTypeMarkerAsFlexibleType != null && (rigidTypeMarkerUpperBound = upperBound(flexibleTypeMarkerAsFlexibleType)) != null) {
                        return rigidTypeMarkerUpperBound;
                    }
                    RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
                    Intrinsics.checkNotNull(rigidTypeMarkerAsRigidType);
                    return rigidTypeMarkerAsRigidType;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isFlexibleWithDifferentTypeConstructors(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    return !Intrinsics.areEqual(typeConstructor(lowerBoundIfFlexible(kotlinTypeMarker)), typeConstructor(upperBoundIfFlexible(kotlinTypeMarker)));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isFlexible(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    return asFlexibleType(kotlinTypeMarker) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isDynamic(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
                    return (flexibleTypeMarkerAsFlexibleType != null ? asDynamicType(flexibleTypeMarkerAsFlexibleType) : null) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
                    return (rigidTypeMarkerAsRigidType != null ? asDefinitelyNotNullType(rigidTypeMarkerAsRigidType) : null) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isDefinitelyNotNullType(RigidTypeMarker rigidTypeMarker) {
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    return asDefinitelyNotNullType(rigidTypeMarker) != null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    return isMarkedNullable(lowerBoundIfFlexible(kotlinTypeMarker)) != isMarkedNullable(upperBoundIfFlexible(kotlinTypeMarker));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
                    if (rigidTypeMarkerAsRigidType == null) {
                        rigidTypeMarkerAsRigidType = lowerBoundIfFlexible(kotlinTypeMarker);
                    }
                    return typeConstructor(rigidTypeMarkerAsRigidType);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isNothing(KotlinTypeMarker kotlinTypeMarker) {
                    Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
                    return isNothingConstructor(typeConstructor(kotlinTypeMarker)) && !isNullableType(kotlinTypeMarker);
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isClassType(RigidTypeMarker rigidTypeMarker) {
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    return isClassTypeConstructor(typeConstructor(rigidTypeMarker));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public boolean isIntegerLiteralType(RigidTypeMarker rigidTypeMarker) {
                    Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
                    return isIntegerLiteralTypeConstructor(typeConstructor(rigidTypeMarker));
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
                    Intrinsics.checkNotNullParameter(typeArgumentListMarker, "<this>");
                    if (typeArgumentListMarker instanceof SimpleTypeMarker) {
                        return getArgument((KotlinTypeMarker) typeArgumentListMarker, i);
                    }
                    if (!(typeArgumentListMarker instanceof ArgumentList)) {
                        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
                    }
                    TypeArgumentMarker typeArgumentMarker = ((ArgumentList) typeArgumentListMarker).get(i);
                    Intrinsics.checkNotNullExpressionValue(typeArgumentMarker, "get(...)");
                    return typeArgumentMarker;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
                public int size(TypeArgumentListMarker typeArgumentListMarker) {
                    Intrinsics.checkNotNullParameter(typeArgumentListMarker, "<this>");
                    if (typeArgumentListMarker instanceof RigidTypeMarker) {
                        return argumentsCount((KotlinTypeMarker) typeArgumentListMarker);
                    }
                    if (typeArgumentListMarker instanceof ArgumentList) {
                        return ((ArgumentList) typeArgumentListMarker).size();
                    }
                    throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
                }
            }, kotlinType3)) != null) {
                return (T) mapType(kotlinType2, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
            }
            if (mode.isForAnnotationParameter() && KotlinBuiltIns.isKClass((ClassDescriptor) classifierDescriptorMo16080getDeclarationDescriptor)) {
                t = (Object) factory.getJavaLangClassType();
            } else {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorMo16080getDeclarationDescriptor;
                ClassDescriptor original = classDescriptor.getOriginal();
                Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
                T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                if (predefinedTypeForClass == null) {
                    if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        classDescriptor = (ClassDescriptor) containingDeclaration;
                    }
                    ClassDescriptor original2 = classDescriptor.getOriginal();
                    Intrinsics.checkNotNullExpressionValue(original2, "getOriginal(...)");
                    t = (Object) factory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                } else {
                    t = (Object) predefinedTypeForClass;
                }
            }
            writeGenericType.invoke(kotlinType, t, mode);
            return t;
        }
        if (classifierDescriptorMo16080getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            KotlinType representativeUpperBound = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) classifierDescriptorMo16080getDeclarationDescriptor);
            if (kotlinType.isMarkedNullable()) {
                representativeUpperBound = TypeUtilsKt.makeNullable(representativeUpperBound);
            }
            T t3 = (T) mapType(representativeUpperBound, factory, mode, typeMappingConfiguration, null, FunctionsKt.getDO_NOTHING_3());
            if (jvmDescriptorTypeWriter != 0) {
                Name name = classifierDescriptorMo16080getDeclarationDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                jvmDescriptorTypeWriter.writeTypeVariable(name, t3);
            }
            return t3;
        }
        if ((classifierDescriptorMo16080getDeclarationDescriptor instanceof TypeAliasDescriptor) && mode.getMapTypeAliases()) {
            return (T) mapType(((TypeAliasDescriptor) classifierDescriptorMo16080getDeclarationDescriptor).getExpandedType(), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        throw new UnsupportedOperationException("Unknown type " + kotlinType);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        if (!KotlinBuiltIns.isUnit(returnType)) {
            return false;
        }
        KotlinType returnType2 = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType2);
        return (TypeUtils.isNullableType(returnType2) || (descriptor instanceof PropertyGetterDescriptor)) ? false : true;
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final String computeInternalName(ClassDescriptor klass, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = klass.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        String identifier = SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            return fqName.isRoot() ? identifier : StringsKt.replace$default(fqName.asString(), '.', '/', false, 4, (Object) null) + '/' + identifier;
        }
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + klass);
        }
        String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor);
        if (predefinedInternalNameForClass == null) {
            predefinedInternalNameForClass = computeInternalName(classDescriptor, typeMappingConfiguration);
        }
        return predefinedInternalNameForClass + '$' + identifier;
    }
}
