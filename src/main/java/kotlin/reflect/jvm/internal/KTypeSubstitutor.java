package kotlin.reflect.jvm.internal;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;

/* JADX INFO: compiled from: KTypeSubstitutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\f\u0010\r\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\u000e\u001a\u00020\u0005*\u00020\u0005H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeSubstitutor;", "", "substitution", "", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KTypeProjection;", "<init>", "(Ljava/util/Map;)V", "substitute", "type", "Lkotlin/reflect/KType;", "withNullabilityOf", "other", "lowerBoundIfFlexible", "upperBoundIfFlexible", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeSubstitutor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<KTypeParameter, KTypeProjection> substitution;

    public KTypeSubstitutor(Map<KTypeParameter, KTypeProjection> substitution) {
        Intrinsics.checkNotNullParameter(substitution, "substitution");
        this.substitution = substitution;
    }

    public final KTypeProjection substitute(KType type) {
        KTypeProjection star;
        Intrinsics.checkNotNullParameter(type, "type");
        boolean z = type instanceof AbstractKType;
        AbstractKType abstractKType = z ? (AbstractKType) type : null;
        AbstractKType abstractKTypeLowerBoundIfFlexible = abstractKType != null ? abstractKType.lowerBoundIfFlexible() : null;
        AbstractKType abstractKType2 = z ? (AbstractKType) type : null;
        AbstractKType abstractKTypeUpperBoundIfFlexible = abstractKType2 != null ? abstractKType2.upperBoundIfFlexible() : null;
        if (abstractKTypeLowerBoundIfFlexible != null && abstractKTypeUpperBoundIfFlexible != null) {
            KTypeProjection kTypeProjectionLowerBoundIfFlexible = lowerBoundIfFlexible(substitute(abstractKTypeLowerBoundIfFlexible));
            KTypeProjection kTypeProjectionUpperBoundIfFlexible = upperBoundIfFlexible(substitute(abstractKTypeUpperBoundIfFlexible));
            KVariance variance = kTypeProjectionLowerBoundIfFlexible.getVariance();
            KType type2 = kTypeProjectionLowerBoundIfFlexible.getType();
            Intrinsics.checkNotNull(type2);
            KType type3 = kTypeProjectionUpperBoundIfFlexible.getType();
            Intrinsics.checkNotNull(type3);
            return new KTypeProjection(variance, TypeOfImplKt.createPlatformKType(type2, type3));
        }
        KClassifier classifier = type.getClassifier();
        if (classifier == null) {
            return KTypeProjection.INSTANCE.invariant(type);
        }
        KTypeProjection kTypeProjection = this.substitution.get(classifier);
        if (kTypeProjection != null) {
            KVariance variance2 = kTypeProjection.getVariance();
            KType type4 = kTypeProjection.getType();
            return type4 == null ? kTypeProjection : new KTypeProjection(variance2, withNullabilityOf(type4, type));
        }
        KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
        List<KTypeProjection> arguments = type.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            KType type5 = ((KTypeProjection) it.next()).getType();
            if (type5 == null || (star = substitute(type5)) == null) {
                star = KTypeProjection.INSTANCE.getSTAR();
            }
            arrayList.add(star);
        }
        return companion.invariant(KClassifiers.createType$default(classifier, arrayList, type.getIsMarkedNullable(), null, 4, null));
    }

    private final KType withNullabilityOf(KType kType, KType kType2) {
        Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.AbstractKType");
        AbstractKType abstractKType = (AbstractKType) kType;
        boolean z = false;
        AbstractKType abstractKTypeMakeNullableAsSpecified = abstractKType.makeNullableAsSpecified(kType2.getIsMarkedNullable() || kType.getIsMarkedNullable());
        Intrinsics.checkNotNull(kType2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.AbstractKType");
        if (((AbstractKType) kType2).isDefinitelyNotNullType() || (abstractKType.isDefinitelyNotNullType() && !kType2.getIsMarkedNullable())) {
            z = true;
        }
        return abstractKTypeMakeNullableAsSpecified.makeDefinitelyNotNullAsSpecified(z);
    }

    private final KTypeProjection lowerBoundIfFlexible(KTypeProjection kTypeProjection) {
        AbstractKType abstractKTypeLowerBoundIfFlexible;
        KType type = kTypeProjection.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (abstractKTypeLowerBoundIfFlexible = abstractKType.lowerBoundIfFlexible()) == null) ? kTypeProjection : new KTypeProjection(kTypeProjection.getVariance(), abstractKTypeLowerBoundIfFlexible);
    }

    private final KTypeProjection upperBoundIfFlexible(KTypeProjection kTypeProjection) {
        AbstractKType abstractKTypeUpperBoundIfFlexible;
        KType type = kTypeProjection.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (abstractKTypeUpperBoundIfFlexible = abstractKType.upperBoundIfFlexible()) == null) ? kTypeProjection : new KTypeProjection(kTypeProjection.getVariance(), abstractKTypeUpperBoundIfFlexible);
    }

    /* JADX INFO: compiled from: KTypeSubstitutor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeSubstitutor$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lkotlin/reflect/jvm/internal/KTypeSubstitutor;", "klass", "Lkotlin/reflect/KClass;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KTypeSubstitutor create(KClass<?> klass, List<KTypeProjection> arguments) {
            Intrinsics.checkNotNullParameter(klass, "klass");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            return new KTypeSubstitutor(MapsKt.toMap(CollectionsKt.zip(klass.getTypeParameters(), arguments)));
        }
    }
}
