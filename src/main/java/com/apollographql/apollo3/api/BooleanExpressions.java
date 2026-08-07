package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: BooleanExpression.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00020\u0001¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\t\u001a$\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a;\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00020\u0001¢\u0006\u0002\u0010\u0006\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0005\"\u00020\t¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00012\u0006\u0010\u0012\u001a\u00020\t\u001aE\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00020\u0001¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a.\u0010\u0016\u001a\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0018\u001a*\u0010\u0016\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00190\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0007\u001a@\u0010\u0016\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00190\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 \u001a9\u0010!\u001a\u0004\u0018\u0001H\"\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\"*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$¢\u0006\u0002\u0010%\u001aE\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005\"\b\u0012\u0004\u0012\u0002H\u00020\u0001¢\u0006\u0002\u0010\u0013¨\u0006&"}, d2 = {"and", "Lcom/apollographql/apollo3/api/BooleanExpression;", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "", "([Lcom/apollographql/apollo3/api/BooleanExpression;)Lcom/apollographql/apollo3/api/BooleanExpression;", "label", "Lcom/apollographql/apollo3/api/BLabel;", "", "not", "or", "possibleTypes", "Lcom/apollographql/apollo3/api/BPossibleTypes;", "typenames", "([Ljava/lang/String;)Lcom/apollographql/apollo3/api/BooleanExpression;", "variable", "Lcom/apollographql/apollo3/api/BVariable;", "name", "(Lcom/apollographql/apollo3/api/BooleanExpression;[Lcom/apollographql/apollo3/api/BooleanExpression;)Lcom/apollographql/apollo3/api/BooleanExpression;", "containsPossibleTypes", "", "evaluate", "block", "Lkotlin/Function1;", "Lcom/apollographql/apollo3/api/BTerm;", "variables", "", "typename", "adapterContext", "Lcom/apollographql/apollo3/api/AdapterContext;", "path", "", "firstElementOfType", "U", "type", "Lkotlin/reflect/KClass;", "(Lcom/apollographql/apollo3/api/BooleanExpression;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BooleanExpressions {
    public static final <T> BooleanExpression<T> or(BooleanExpression<? extends T> booleanExpression, BooleanExpression<? extends T>... other) {
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new BooleanExpression.Or(CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends BooleanExpression<? extends T>>) ArraysKt.toList(other), booleanExpression)));
    }

    public static final <T> BooleanExpression<T> and(BooleanExpression<? extends T> booleanExpression, BooleanExpression<? extends T>... other) {
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new BooleanExpression.And(CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends BooleanExpression<? extends T>>) ArraysKt.toList(other), booleanExpression)));
    }

    public static final <T> BooleanExpression<T> or(BooleanExpression<? extends T>... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new BooleanExpression.Or(CollectionsKt.toSet(ArraysKt.toList(other)));
    }

    public static final <T> BooleanExpression<T> and(BooleanExpression<? extends T>... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new BooleanExpression.And(CollectionsKt.toSet(ArraysKt.toList(other)));
    }

    public static final <T> BooleanExpression<T> not(BooleanExpression<? extends T> other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new BooleanExpression.Not(other);
    }

    public static final BooleanExpression<BVariable> variable(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new BooleanExpression.Element(new BVariable(name));
    }

    public static final BooleanExpression<BLabel> label(String str) {
        return new BooleanExpression.Element(new BLabel(str));
    }

    public static /* synthetic */ BooleanExpression label$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return label(str);
    }

    public static final BooleanExpression<BPossibleTypes> possibleTypes(String... typenames) {
        Intrinsics.checkNotNullParameter(typenames, "typenames");
        return new BooleanExpression.Element(new BPossibleTypes((Set<String>) ArraysKt.toSet(typenames)));
    }

    public static final <T> boolean evaluate(BooleanExpression<? extends T> booleanExpression, Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(booleanExpression, BooleanExpression.True.INSTANCE)) {
            return true;
        }
        if (Intrinsics.areEqual(booleanExpression, BooleanExpression.False.INSTANCE)) {
            return false;
        }
        if (booleanExpression instanceof BooleanExpression.Not) {
            return !evaluate(((BooleanExpression.Not) booleanExpression).getOperand(), block);
        }
        if (!(booleanExpression instanceof BooleanExpression.Or)) {
            if (!(booleanExpression instanceof BooleanExpression.And)) {
                if (booleanExpression instanceof BooleanExpression.Element) {
                    return block.invoke((Object) ((BooleanExpression.Element) booleanExpression).getValue()).booleanValue();
                }
                throw new NoWhenBranchMatchedException();
            }
            Set<BooleanExpression<T>> operands = ((BooleanExpression.And) booleanExpression).getOperands();
            if ((operands instanceof Collection) && operands.isEmpty()) {
                return true;
            }
            Iterator<T> it = operands.iterator();
            while (it.hasNext()) {
                if (!evaluate((BooleanExpression) it.next(), block)) {
                    return false;
                }
            }
            return true;
        }
        Set<BooleanExpression<T>> operands2 = ((BooleanExpression.Or) booleanExpression).getOperands();
        if ((operands2 instanceof Collection) && operands2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = operands2.iterator();
        while (it2.hasNext()) {
            if (evaluate((BooleanExpression) it2.next(), block)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated(message = "Kept for binary compatibility with generated code from older versions")
    public static final boolean evaluate(BooleanExpression<? extends BTerm> booleanExpression, final Set<String> variables, final String str) {
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        Intrinsics.checkNotNullParameter(variables, "variables");
        return evaluate(booleanExpression, new Function1<BTerm, Boolean>() { // from class: com.apollographql.apollo3.api.BooleanExpressions.evaluate.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BTerm it) {
                boolean zContains;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof BVariable) {
                    zContains = variables.contains(((BVariable) it).getName());
                } else {
                    if (!(it instanceof BPossibleTypes)) {
                        if (it instanceof BLabel) {
                            throw new IllegalStateException("Unexpected boolean expression term type".toString());
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = CollectionsKt.contains(((BPossibleTypes) it).getPossibleTypes(), str);
                }
                return Boolean.valueOf(zContains);
            }
        });
    }

    public static final boolean evaluate(BooleanExpression<? extends BTerm> booleanExpression, final Set<String> variables, final String str, final C0868AdapterContext adapterContext, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(adapterContext, "adapterContext");
        final List listDrop = list != null ? CollectionsKt.drop(list, 1) : null;
        return evaluate(booleanExpression, new Function1<BTerm, Boolean>() { // from class: com.apollographql.apollo3.api.BooleanExpressions.evaluate.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BTerm it) {
                boolean zContains;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof BVariable) {
                    zContains = !variables.contains(((BVariable) it).getName());
                } else if (it instanceof BLabel) {
                    C0868AdapterContext c0868AdapterContext = adapterContext;
                    List<? extends Object> list2 = listDrop;
                    Intrinsics.checkNotNull(list2);
                    zContains = c0868AdapterContext.hasDeferredFragment(list2, ((BLabel) it).getLabel());
                } else {
                    if (!(it instanceof BPossibleTypes)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = CollectionsKt.contains(((BPossibleTypes) it).getPossibleTypes(), str);
                }
                return Boolean.valueOf(zContains);
            }
        });
    }

    public static final <T> boolean containsPossibleTypes(BooleanExpression<? extends T> booleanExpression) {
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        if (Intrinsics.areEqual(booleanExpression, BooleanExpression.True.INSTANCE) || Intrinsics.areEqual(booleanExpression, BooleanExpression.False.INSTANCE)) {
            return false;
        }
        if (booleanExpression instanceof BooleanExpression.Not) {
            return containsPossibleTypes(((BooleanExpression.Not) booleanExpression).getOperand());
        }
        if (!(booleanExpression instanceof BooleanExpression.Or)) {
            if (!(booleanExpression instanceof BooleanExpression.And)) {
                if (booleanExpression instanceof BooleanExpression.Element) {
                    return ((BooleanExpression.Element) booleanExpression).getValue() instanceof BPossibleTypes;
                }
                throw new NoWhenBranchMatchedException();
            }
            Set<BooleanExpression<T>> operands = ((BooleanExpression.And) booleanExpression).getOperands();
            if ((operands instanceof Collection) && operands.isEmpty()) {
                return false;
            }
            Iterator<T> it = operands.iterator();
            while (it.hasNext()) {
                if (containsPossibleTypes((BooleanExpression) it.next())) {
                    return true;
                }
            }
            return false;
        }
        Set<BooleanExpression<T>> operands2 = ((BooleanExpression.Or) booleanExpression).getOperands();
        if ((operands2 instanceof Collection) && operands2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = operands2.iterator();
        while (it2.hasNext()) {
            if (containsPossibleTypes((BooleanExpression) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static final <T, U> U firstElementOfType(BooleanExpression<? extends T> booleanExpression, KClass<U> type) {
        T next;
        T next2;
        Intrinsics.checkNotNullParameter(booleanExpression, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(booleanExpression, BooleanExpression.True.INSTANCE) || Intrinsics.areEqual(booleanExpression, BooleanExpression.False.INSTANCE)) {
            return null;
        }
        if (booleanExpression instanceof BooleanExpression.Element) {
            BooleanExpression.Element element = (BooleanExpression.Element) booleanExpression;
            if (!type.isInstance(element.getValue())) {
                return null;
            }
            U u = (U) element.getValue();
            Intrinsics.checkNotNull(u, "null cannot be cast to non-null type U of com.apollographql.apollo3.api.BooleanExpressions.firstElementOfType");
            return u;
        }
        if (booleanExpression instanceof BooleanExpression.Not) {
            return (U) firstElementOfType(((BooleanExpression.Not) booleanExpression).getOperand(), type);
        }
        if (!(booleanExpression instanceof BooleanExpression.And)) {
            if (!(booleanExpression instanceof BooleanExpression.Or)) {
                throw new NoWhenBranchMatchedException();
            }
            Iterator<T> it = ((BooleanExpression.Or) booleanExpression).getOperands().iterator();
            do {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
            } while (firstElementOfType((BooleanExpression) next, type) == null);
            BooleanExpression booleanExpression2 = next;
            if (booleanExpression2 != null) {
                return (U) firstElementOfType(booleanExpression2, type);
            }
            return null;
        }
        Iterator<T> it2 = ((BooleanExpression.And) booleanExpression).getOperands().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = (T) null;
                break;
            }
            next2 = it2.next();
        } while (firstElementOfType((BooleanExpression) next2, type) == null);
        BooleanExpression booleanExpression3 = next2;
        if (booleanExpression3 != null) {
            return (U) firstElementOfType(booleanExpression3, type);
        }
        return null;
    }
}
