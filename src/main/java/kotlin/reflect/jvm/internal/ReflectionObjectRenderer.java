package kotlin.reflect.jvm.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.KClassesJvm;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006*\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\t\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u001c\u0010\r\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u0018\u0010\u000e\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u00102\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014J\u0012\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0012\u0010\u0018\u001a\u00020\u00102\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0017J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020!2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0002J\u0018\u0010$\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J:\u0010%\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010&\u001a\u00020 2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+H\u0002J&\u0010,\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002¨\u00061"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "<init>", "()V", "appendReceiverType", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/KParameter;", "appendReceivers", "", "callable", "Lkotlin/reflect/KCallable;", "appendContexts", "appendName", "name", "", "renderCallable", "renderProperty", "property", "Lkotlin/reflect/KProperty;", "renderFunction", "function", "Lkotlin/reflect/KFunction;", "renderLambda", "lambda", "renderParameter", "parameter", "renderType", "type", "Lkotlin/reflect/KType;", "getTypeClassFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqNameUnsafe;", "Lkotlin/reflect/jvm/internal/AbstractKType;", "klass", "Lkotlin/reflect/KClass;", "renderFunctionType", "renderSimpleType", "classFqName", "allArguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "renderTypeArgumentsAndNullability", "typeArguments", "renderFlexibleType", "lowerRendered", "upperRendered", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();

    /* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            try {
                iArr[KParameter.Kind.INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KParameter.Kind.CONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KParameter.Kind.VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final StringBuilder appendReceiverType(StringBuilder sb, KParameter kParameter) {
        StringBuilder sbAppend = sb.append(renderType(kParameter.getType())).append(".");
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    private final void appendReceivers(StringBuilder sb, KCallable<?> kCallable) {
        Intrinsics.checkNotNull(kCallable, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KCallableImpl<*>");
        List<KParameter> receiverParameters = ((KCallableImpl) kCallable).getReceiverParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : receiverParameters) {
            KParameter kParameter = (KParameter) obj;
            if (kParameter.getKind() == KParameter.Kind.INSTANCE || kParameter.getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        KParameter kParameter2 = (KParameter) CollectionsKt.getOrNull(arrayList2, 0);
        if (kParameter2 != null) {
            INSTANCE.appendReceiverType(sb, kParameter2);
        }
        KParameter kParameter3 = (KParameter) CollectionsKt.getOrNull(arrayList2, 1);
        if (kParameter3 != null) {
            ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
            StringBuilder sbAppend = sb.append("(");
            Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
            reflectionObjectRenderer.appendReceiverType(sbAppend, kParameter3).append(")");
        }
    }

    private final void appendContexts(StringBuilder sb, KCallable<?> kCallable) {
        List<KParameter> contextParameters = KCallables.getContextParameters(kCallable);
        if (contextParameters.isEmpty()) {
            return;
        }
        CollectionsKt.joinTo(contextParameters, sb, (112 & 2) != 0 ? ", " : null, (112 & 4) != 0 ? "" : "context(", (112 & 8) != 0 ? "" : ") ", (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ReflectionObjectRenderer.appendContexts$lambda$0((KParameter) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendContexts$lambda$0(KParameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        String name = parameter.getName();
        if (name == null) {
            name = "_";
        }
        return sb.append(name).append(": ").append(parameter.getType()).toString();
    }

    private final void appendName(StringBuilder sb, String str) {
        Name nameIdentifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        sb.append(RenderingUtilsKt.render(nameIdentifier));
    }

    private final String renderCallable(KCallable<?> callable) {
        if (callable instanceof KProperty) {
            return renderProperty((KProperty) callable);
        }
        if (callable instanceof KFunction) {
            return renderFunction((KFunction) callable);
        }
        throw new IllegalStateException(("Illegal callable: " + callable).toString());
    }

    public final String renderProperty(KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        KProperty<?> kProperty = property;
        reflectionObjectRenderer.appendContexts(sb, kProperty);
        sb.append(property instanceof KMutableProperty ? "var " : "val ");
        reflectionObjectRenderer.appendReceivers(sb, kProperty);
        reflectionObjectRenderer.appendName(sb, property.getName());
        sb.append(": ");
        sb.append(reflectionObjectRenderer.renderType(property.getReturnType()));
        return sb.toString();
    }

    public final String renderFunction(KFunction<?> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        KFunction<?> kFunction = function;
        reflectionObjectRenderer.appendContexts(sb, kFunction);
        sb.append("fun ");
        reflectionObjectRenderer.appendReceivers(sb, kFunction);
        reflectionObjectRenderer.appendName(sb, function.getName());
        CollectionsKt.joinTo(KCallables.getValueParameters(kFunction), sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : "(", (112 & 8) != 0 ? "" : ")", (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ReflectionObjectRenderer.renderFunction$lambda$0$0((KParameter) obj);
            }
        });
        sb.append(": ");
        sb.append(reflectionObjectRenderer.renderType(function.getReturnType()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderFunction$lambda$0$0(KParameter it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.renderType(it.getType());
    }

    public final String renderLambda(KFunction<?> lambda) {
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        StringBuilder sb = new StringBuilder();
        KFunction<?> kFunction = lambda;
        KParameter extensionReceiverParameter = KCallables.getExtensionReceiverParameter(kFunction);
        if (extensionReceiverParameter != null) {
            sb.append(INSTANCE.renderType(extensionReceiverParameter.getType()));
            sb.append(".");
        }
        CollectionsKt.joinTo(KCallables.getValueParameters(kFunction), sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : "(", (112 & 8) != 0 ? "" : ")", (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ReflectionObjectRenderer.renderLambda$lambda$0$1((KParameter) obj);
            }
        });
        sb.append(" -> ");
        sb.append(INSTANCE.renderType(lambda.getReturnType()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderLambda$lambda$0$1(KParameter it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.renderType(it.getType());
    }

    public final String renderParameter(KParameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        int i = WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()];
        if (i == 1) {
            sb.append("instance parameter");
        } else if (i == 2) {
            sb.append("context parameter " + parameter.getName());
        } else if (i == 3) {
            sb.append("extension receiver parameter");
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            sb.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb.append(" of ");
        sb.append(INSTANCE.renderCallable(((KParameterImpl) parameter).getCallable()));
        return sb.toString();
    }

    public final String renderType(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        AbstractKType abstractKType = (AbstractKType) type;
        AbstractKType abstractKTypeLowerBoundIfFlexible = abstractKType.lowerBoundIfFlexible();
        AbstractKType abstractKTypeUpperBoundIfFlexible = abstractKType.upperBoundIfFlexible();
        if (abstractKTypeLowerBoundIfFlexible != null && abstractKTypeUpperBoundIfFlexible != null) {
            return renderFlexibleType(renderType(abstractKTypeLowerBoundIfFlexible), renderType(abstractKTypeUpperBoundIfFlexible));
        }
        StringBuilder sb = new StringBuilder();
        KType abbreviation = abstractKType.getAbbreviation();
        if (abbreviation != null) {
            sb.append(abbreviation);
            sb.append(" /* = ");
        }
        KClassifier classifier = type.getClassifier();
        if (classifier instanceof KTypeParameter) {
            INSTANCE.appendName(sb, ((KTypeParameter) classifier).getName());
            if (type.getIsMarkedNullable()) {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
            } else if (abstractKType.isDefinitelyNotNullType()) {
                sb.append(" & Any");
            }
        } else if (classifier instanceof KClass) {
            ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
            KClass<?> kClass = (KClass) classifier;
            FqNameUnsafe typeClassFqName = reflectionObjectRenderer.getTypeClassFqName(abstractKType, kClass);
            if (typeClassFqName == null) {
                typeClassFqName = new FqNameUnsafe(KClassesJvm.getJvmName(kClass));
            }
            FqNameUnsafe fqNameUnsafe = typeClassFqName;
            if (FunctionTypesKt.isNumberedFunctionClassFqName(fqNameUnsafe) && !type.getArguments().contains(KTypeProjection.INSTANCE.getSTAR())) {
                reflectionObjectRenderer.renderFunctionType(sb, type);
            } else {
                reflectionObjectRenderer.renderSimpleType(sb, kClass, fqNameUnsafe, type.getArguments(), type.getIsMarkedNullable());
            }
        } else if (!(classifier instanceof KTypeAliasImpl)) {
            sb.append("???");
        } else {
            CollectionsKt.joinTo(((KTypeAliasImpl) classifier).getFqName().pathSegments(), sb, (112 & 2) != 0 ? ", " : ".", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ReflectionObjectRenderer.renderType$lambda$0$1((Name) obj);
                }
            });
            INSTANCE.renderTypeArgumentsAndNullability(sb, type.getArguments(), type.getIsMarkedNullable());
        }
        if (abstractKType.getAbbreviation() != null) {
            sb.append(" */");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderType$lambda$0$1(Name it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return RenderingUtilsKt.render(it);
    }

    private final FqNameUnsafe getTypeClassFqName(AbstractKType type, KClass<?> klass) {
        if (type.isNothingType()) {
            return StandardNames.FqNames.nothing;
        }
        String qualifiedName = klass.getQualifiedName();
        if (qualifiedName == null) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = new FqNameUnsafe(qualifiedName);
        if (!type.isMutableCollectionType()) {
            return fqNameUnsafe;
        }
        FqName onlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(fqNameUnsafe);
        if (onlyToMutable != null) {
            return onlyToMutable.toUnsafe();
        }
        return null;
    }

    private final void renderFunctionType(StringBuilder sb, KType kType) {
        if (kType.getIsMarkedNullable()) {
            sb.append("(");
        }
        CollectionsKt.joinTo(CollectionsKt.dropLast(kType.getArguments(), 1), sb, (112 & 2) != 0 ? ", " : null, (112 & 4) != 0 ? "" : "(", (112 & 8) != 0 ? "" : ") -> ", (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null);
        sb.append(CollectionsKt.last((List) kType.getArguments()));
        if (kType.getIsMarkedNullable()) {
            sb.append(")?");
        }
    }

    private final void renderSimpleType(StringBuilder sb, KClass<?> kClass, FqNameUnsafe fqNameUnsafe, List<KTypeProjection> list, boolean z) {
        ReflectionObjectRenderer reflectionObjectRenderer;
        StringBuilder sb2;
        if (kClass.getTypeParameters().size() < list.size() && JvmClassMappingKt.getJavaClass((KClass) kClass).getDeclaringClass() != null) {
            Class<?> declaringClass = JvmClassMappingKt.getJavaClass((KClass) kClass).getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            reflectionObjectRenderer = this;
            sb2 = sb;
            reflectionObjectRenderer.renderSimpleType(sb2, JvmClassMappingKt.getKotlinClass(declaringClass), fqNameUnsafe.parent(), CollectionsKt.drop(list, kClass.getTypeParameters().size()), false);
            sb2.append(".");
            sb2.append(RenderingUtilsKt.render(fqNameUnsafe.shortName()));
        } else {
            reflectionObjectRenderer = this;
            sb2 = sb;
            sb2.append(RenderingUtilsKt.render(fqNameUnsafe));
        }
        reflectionObjectRenderer.renderTypeArgumentsAndNullability(sb2, CollectionsKt.take(list, kClass.getTypeParameters().size()), z);
    }

    private final void renderTypeArgumentsAndNullability(StringBuilder sb, List<KTypeProjection> list, boolean z) {
        if (!list.isEmpty()) {
            CollectionsKt.joinTo(list, sb, (112 & 2) != 0 ? ", " : null, (112 & 4) != 0 ? "" : SimpleComparison.LESS_THAN_OPERATION, (112 & 8) != 0 ? "" : SimpleComparison.GREATER_THAN_OPERATION, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null);
        }
        if (z) {
            sb.append(MsalUtils.QUERY_STRING_SYMBOL);
        }
    }

    private final String renderFlexibleType(final String lowerRendered, String upperRendered) {
        if (Intrinsics.areEqual(lowerRendered, StringsKt.replace$default(upperRendered, MsalUtils.QUERY_STRING_SYMBOL, "", false, 4, (Object) null))) {
            return StringsKt.replace$default(upperRendered, MsalUtils.QUERY_STRING_SYMBOL, "!", false, 4, (Object) null);
        }
        if (StringsKt.endsWith$default(upperRendered, MsalUtils.QUERY_STRING_SYMBOL, false, 2, (Object) null) && Intrinsics.areEqual(lowerRendered + '?', upperRendered)) {
            return lowerRendered + '!';
        }
        if (Intrinsics.areEqual("(" + lowerRendered + ")?", upperRendered)) {
            return "(" + lowerRendered + ")!";
        }
        String strRenderFlexibleMutabilityOrArrayElementVarianceType$default = RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$default(lowerRendered, upperRendered, new Function0(lowerRendered) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$4
            private final String arg$0;

            {
                this.arg$0 = lowerRendered;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionObjectRenderer.renderFlexibleType$lambda$0(this.arg$0);
            }
        }, new Function0(lowerRendered) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$5
            private final String arg$0;

            {
                this.arg$0 = lowerRendered;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionObjectRenderer.renderFlexibleType$lambda$1(this.arg$0);
            }
        }, null, 16, null);
        return strRenderFlexibleMutabilityOrArrayElementVarianceType$default == null ? "(" + lowerRendered + ".." + upperRendered + ')' : strRenderFlexibleMutabilityOrArrayElementVarianceType$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$0(String str) {
        String str2 = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.asString() + '.';
        if (!StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$1(String str) {
        String str2 = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.asString() + '.';
        if (!StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }
}
