package com.apollographql.apollo3.api.test;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNamedType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledType;
import com.apollographql.apollo3.api.CustomScalarType;
import com.apollographql.apollo3.api.EnumType;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.facebook.react.devsupport.StackTraceHelper;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TestResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0002JW\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c2$\u0010\u001d\u001a \u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001f0\u001e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016JM\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\"\u0010\u001d\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001f0\u001e0\rH\u0016¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016J$\u0010&\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH\u0016J\u0016\u0010'\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016J\u0016\u0010(\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016JW\u0010)\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c2$\u0010\u001d\u001a \u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001f0\u001e\u0018\u00010\rH\u0002¢\u0006\u0002\u0010 J\u0016\u0010*\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016J\u0016\u0010+\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/apollographql/apollo3/api/test/DefaultTestResolver;", "Lcom/apollographql/apollo3/api/test/TestResolver;", "()V", "MAX_STACK_SIZE", "", "booleanCounter", "", "compositeCounter", "enumCounter", "floatCounter", "", "intCounter", StackTraceHelper.STACK_KEY, "", "", "[Ljava/lang/Object;", "stackSize", TokenRequest.TokenType.POP, "", "push", "v", Gen204FileActivityEventLogger.ACTION_RESOLVE, ExifInterface.GPS_DIRECTION_TRUE, "responseName", "", "compiledType", "Lcom/apollographql/apollo3/api/CompiledType;", "enumValues", "", "ctors", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lcom/apollographql/apollo3/api/CompiledType;Ljava/util/List;[Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolveBoolean", "path", "resolveComposite", "(Ljava/util/List;[Lkotlin/jvm/functions/Function0;)Ljava/util/Map;", "resolveCustomScalar", "resolveEnum", "resolveFloat", "resolveInt", "resolveInternal", "resolveListSize", "resolveString", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DefaultTestResolver implements TestResolver {
    private final int MAX_STACK_SIZE = 256;
    private boolean booleanCounter;
    private int compositeCounter;
    private int enumCounter;
    private double floatCounter;
    private int intCounter;
    private final Object[] stack;
    private int stackSize;

    public int resolveListSize(List<? extends Object> path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return 3;
    }

    public DefaultTestResolver() {
        Object[] objArr = new Object[256];
        for (int i = 0; i < 256; i++) {
            objArr[i] = 0;
        }
        this.stack = objArr;
        this.floatCounter = 0.5d;
    }

    public int resolveInt(List<? extends Object> path) {
        Intrinsics.checkNotNullParameter(path, "path");
        int i = this.intCounter;
        this.intCounter = i + 1;
        return i;
    }

    public double resolveFloat(List<? extends Object> path) {
        Intrinsics.checkNotNullParameter(path, "path");
        double d = this.floatCounter;
        this.floatCounter = 1.0d + d;
        return d;
    }

    public boolean resolveBoolean(List<? extends Object> path) {
        Intrinsics.checkNotNullParameter(path, "path");
        boolean z = this.booleanCounter;
        this.booleanCounter = !z;
        return z;
    }

    public String resolveEnum(List<? extends Object> path, List<String> enumValues) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(enumValues, "enumValues");
        int i = this.enumCounter;
        this.enumCounter = i + 1;
        return enumValues.get(i % enumValues.size());
    }

    public Map<String, Object> resolveComposite(List<? extends Object> path, Function0<? extends Map<String, ? extends Object>>[] ctors) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(ctors, "ctors");
        int i = this.compositeCounter;
        this.compositeCounter = i + 1;
        return ctors[i % ctors.length].invoke();
    }

    public String resolveCustomScalar(List<? extends Object> path) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IllegalStateException(("Cannot resolve custom scalar at " + path).toString());
    }

    private final void push(Object v) {
        int i = this.stackSize;
        if (i >= this.MAX_STACK_SIZE) {
            throw new IllegalStateException(("Nesting too deep at " + ArraysKt.joinToString$default(this.stack, ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString());
        }
        Object[] objArr = this.stack;
        this.stackSize = i + 1;
        objArr[i] = v;
    }

    private final void pop() {
        int i = this.stackSize - 1;
        this.stackSize = i;
        this.stack[i] = 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final <T> T resolveInternal(String responseName, CompiledType compiledType, List<String> enumValues, Function0<? extends Map<String, ? extends Object>>[] ctors) {
        List<? extends Object> list = CollectionsKt.toList(ArraysKt.take(this.stack, this.stackSize));
        if (compiledType instanceof CompiledNotNullType) {
            return (T) resolve(responseName, ((CompiledNotNullType) compiledType).getOfType(), enumValues, ctors);
        }
        if (compiledType instanceof CompiledListType) {
            IntRange intRangeUntil = RangesKt.until(0, resolveListSize(list));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                push(Integer.valueOf(((IntIterator) it).nextInt()));
                Object objResolveInternal = resolveInternal(responseName, ((CompiledListType) compiledType).getOfType(), enumValues, ctors);
                pop();
                arrayList.add(objResolveInternal);
            }
            return (T) arrayList;
        }
        if (!(compiledType instanceof CustomScalarType)) {
            if (compiledType instanceof EnumType) {
                return (T) resolveEnum(list, enumValues);
            }
            if (!(compiledType instanceof CompiledNamedType)) {
                throw new NoWhenBranchMatchedException();
            }
            if (ctors != null) {
                return (T) resolveComposite(list, ctors);
            }
            throw new IllegalStateException(("no ctors for " + responseName).toString());
        }
        String name = ((CustomScalarType) compiledType).getName();
        switch (name.hashCode()) {
            case -1808118735:
                if (name.equals("String")) {
                    return (T) resolveString(list);
                }
                break;
            case 2331:
                if (name.equals("ID")) {
                    return (T) resolveString(list);
                }
                break;
            case 73679:
                if (name.equals("Int")) {
                    return (T) Integer.valueOf(resolveInt(list));
                }
                break;
            case 67973692:
                if (name.equals("Float")) {
                    return (T) Double.valueOf(resolveFloat(list));
                }
                break;
            case 1729365000:
                if (name.equals("Boolean")) {
                    return (T) Boolean.valueOf(resolveBoolean(list));
                }
                break;
        }
        return (T) resolveCustomScalar(list);
    }

    @Override // com.apollographql.apollo3.api.test.TestResolver
    public <T> T resolve(String responseName, CompiledType compiledType, List<String> enumValues, Function0<? extends Map<String, ? extends Object>>[] ctors) {
        Intrinsics.checkNotNullParameter(responseName, "responseName");
        Intrinsics.checkNotNullParameter(compiledType, "compiledType");
        Intrinsics.checkNotNullParameter(enumValues, "enumValues");
        push(responseName);
        T t = (T) resolveInternal(responseName, compiledType, enumValues, ctors);
        pop();
        return t;
    }

    public String resolveString(List<? extends Object> path) {
        int iNextIndex;
        Intrinsics.checkNotNullParameter(path, "path");
        ListIterator<? extends Object> listIterator = path.listIterator(path.size());
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() instanceof String) {
                iNextIndex = listIterator.nextIndex();
                return CollectionsKt.joinToString$default(path.subList(iNextIndex, path.size()), "", null, null, 0, null, null, 62, null);
            }
        }
        iNextIndex = -1;
        return CollectionsKt.joinToString$default(path.subList(iNextIndex, path.size()), "", null, null, 0, null, null, 62, null);
    }
}
