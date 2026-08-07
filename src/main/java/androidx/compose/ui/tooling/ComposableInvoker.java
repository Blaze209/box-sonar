package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: ComposableInvoker.jvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "Use androidx.compose.runtime.reflect.ComposableMethodInvoker instead")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00072\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0002¢\u0006\u0002\u0010\nJ;\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\"\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0007\"\u0006\b\u0000\u0010\u0012\u0018\u0001*\u0002H\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082\b¢\u0006\u0002\u0010\u0015J7\u0010\u0016\u001a\u0004\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u000e2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\bH\u0002J=\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u001eJ\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0002J=\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010(R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", "", "<init>", "()V", "areParameterTypesCompatible", "", "composableMethodTypes", "", "Ljava/lang/Class;", "previewParameterTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "findCompatibleComposeMethod", "Ljava/lang/reflect/Method;", "methodName", "", "args", "([Ljava/lang/reflect/Method;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "dup", ExifInterface.GPS_DIRECTION_TRUE, "count", "", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findComposableMethod", "previewParamArgs", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "composer", "Landroidx/compose/runtime/Composer;", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "SLOTS_PER_INT", "BITS_PER_INT", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "invokeComposable", "", "className", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposableInvoker {
    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 10;

    private ComposableInvoker() {
    }

    private final boolean areParameterTypesCompatible(Class<?>[] composableMethodTypes, Class<?>[] previewParameterTypes) {
        if (composableMethodTypes.length == previewParameterTypes.length) {
            ArrayList arrayList = new ArrayList(composableMethodTypes.length);
            int length = composableMethodTypes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i >= length) {
                    break;
                }
                Class<?> cls = composableMethodTypes[i];
                int i3 = i2 + 1;
                Class<?> cls2 = previewParameterTypes[i2];
                if (!Intrinsics.areEqual(JvmClassMappingKt.getKotlinClass(cls), JvmClassMappingKt.getKotlinClass(cls2)) && !cls.isAssignableFrom(cls2)) {
                    z = false;
                }
                arrayList.add(Boolean.valueOf(z));
                i++;
                i2 = i3;
            }
            ArrayList arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> T[] dup(T t, int i) {
        IntRange intRangeUntil = RangesKt.until(0, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(t);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) arrayList.toArray(new Object[0]);
    }

    private final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        if (name == null) {
            return null;
        }
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                return !name.equals("int") ? null : 0;
            case 3039496:
                return !name.equals("byte") ? null : (byte) 0;
            case 3052374:
                return !name.equals("char") ? null : (char) 0;
            case 3327612:
                return !name.equals("long") ? null : 0L;
            case 64711720:
                return !name.equals(TypedValues.Custom.S_BOOLEAN) ? null : false;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                return !name.equals("short") ? null : (short) 0;
            default:
                return null;
        }
    }

    private final Object invokeComposableMethod(Method method, Object obj, Composer composer, Object... objArr) {
        Object defaultValue;
        Class<?>[] parameterTypes = method.getParameterTypes();
        int i = -1;
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (Intrinsics.areEqual(parameterTypes[length], Composer.class)) {
                    i = length;
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        int i3 = i + 1;
        int iChangedParamCount = changedParamCount(i, obj != null ? 1 : 0) + i3;
        int length2 = method.getParameterTypes().length;
        if ((length2 != iChangedParamCount ? defaultParamCount(i) : 0) + iChangedParamCount != length2) {
            throw new IllegalStateException("params don't add up to total params".toString());
        }
        Object[] objArr2 = new Object[length2];
        int i4 = 0;
        while (i4 < length2) {
            if (i4 >= 0 && i4 < i) {
                defaultValue = (i4 < 0 || i4 >= objArr.length) ? INSTANCE.getDefaultValue(method.getParameterTypes()[i4]) : objArr[i4];
            } else if (i4 == i) {
                defaultValue = composer;
            } else if (i3 <= i4 && i4 < iChangedParamCount) {
                defaultValue = 0;
            } else {
                if (iChangedParamCount > i4 || i4 >= length2) {
                    throw new IllegalStateException("Unexpected index".toString());
                }
                defaultValue = 2097151;
            }
            objArr2[i4] = defaultValue;
            i4++;
        }
        return method.invoke(obj, Arrays.copyOf(objArr2, length2));
    }

    private final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (realValueParams + thisParams)) / 10.0d);
    }

    private final int defaultParamCount(int realValueParams) {
        return (int) Math.ceil(((double) realValueParams) / 31.0d);
    }

    public final void invokeComposable(String className, String methodName, Composer composer, Object... args) throws Exception {
        try {
            Class<?> cls = Class.forName(className);
            Method methodFindComposableMethod = findComposableMethod(cls, methodName, Arrays.copyOf(args, args.length));
            if (methodFindComposableMethod == null) {
                throw new NoSuchMethodException("Composable " + className + '.' + methodName + " not found");
            }
            methodFindComposableMethod.setAccessible(true);
            if (Modifier.isStatic(methodFindComposableMethod.getModifiers())) {
                invokeComposableMethod(methodFindComposableMethod, null, composer, Arrays.copyOf(args, args.length));
            } else {
                invokeComposableMethod(methodFindComposableMethod, cls.getConstructor(new Class[0]).newInstance(new Object[0]), composer, Arrays.copyOf(args, args.length));
            }
        } catch (Exception e) {
            PreviewLogger.Companion.logWarning$ui_tooling$default(PreviewLogger.INSTANCE, "Failed to invoke Composable Method '" + className + '.' + methodName + '\'', null, 2, null);
            throw e;
        }
    }

    private final Method findCompatibleComposeMethod(Method[] methodArr, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        int length = methodArr.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methodArr[i];
            if ((Intrinsics.areEqual(str, method2.getName()) || StringsKt.startsWith$default(method2.getName(), str + Soundex.SILENT_MARKER, false, 2, (Object) null)) && INSTANCE.areParameterTypesCompatible(method2.getParameterTypes(), (Class[]) Arrays.copyOf(clsArr, clsArr.length))) {
                method = method2;
                break;
            }
            i++;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(str + " not found");
    }

    private final Method findComposableMethod(Class<?> cls, String str, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Object obj = objArr[i];
            Class<?> cls2 = obj != null ? obj.getClass() : null;
            if (cls2 != null) {
                arrayList.add(cls2);
            }
            i++;
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        try {
            try {
                int iChangedParamCount = changedParamCount(clsArr.length, 0);
                Class cls3 = Integer.TYPE;
                IntRange intRangeUntil = RangesKt.until(0, iChangedParamCount);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    arrayList2.add(cls3);
                }
                Class[] clsArr2 = (Class[]) arrayList2.toArray(new Class[0]);
                Method[] declaredMethods = cls.getDeclaredMethods();
                SpreadBuilder spreadBuilder = new SpreadBuilder(3);
                spreadBuilder.addSpread(clsArr);
                spreadBuilder.add(Composer.class);
                spreadBuilder.addSpread(clsArr2);
                return findCompatibleComposeMethod(declaredMethods, str, (Class[]) spreadBuilder.toArray(new Class[spreadBuilder.size()]));
            } catch (ReflectiveOperationException unused) {
                return null;
            }
        } catch (ReflectiveOperationException unused2) {
            for (Method method : cls.getDeclaredMethods()) {
                if (Intrinsics.areEqual(method.getName(), str) || StringsKt.startsWith$default(method.getName(), str + Soundex.SILENT_MARKER, false, 2, (Object) null)) {
                    return method;
                }
            }
            return null;
        }
    }
}
