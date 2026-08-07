package sdk.pendo.io.z1;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import sdk.pendo.io.w1.d;
import sdk.pendo.io.w1.e;
import sdk.pendo.io.w1.h;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static final WildcardType a = a().a(Object.class).a();

    public static class b {
        private Type[] a;
        private Type[] b;

        private b() {
        }

        public WildcardType a() {
            return new c(this.a, this.b);
        }

        public b a(Type... typeArr) {
            this.a = typeArr;
            return this;
        }
    }

    private static final class c implements WildcardType {
        private final Type[] a;
        private final Type[] b;

        private c(Type[] typeArr, Type[] typeArr2) {
            Type[] typeArr3 = sdk.pendo.io.w1.b.w;
            this.a = (Type[]) e.a(typeArr, typeArr3);
            this.b = (Type[]) e.a(typeArr2, typeArr3);
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                return (obj instanceof WildcardType) && a.b((WildcardType) this, (Type) obj);
            }
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return (Type[]) this.b.clone();
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return (Type[]) this.a.clone();
        }

        public int hashCode() {
            return Arrays.hashCode(this.b) | ((Arrays.hashCode(this.a) | 18688) << 8);
        }

        public String toString() {
            return a.a((Type) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(WildcardType wildcardType, Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType2 = (WildcardType) type;
            if (a(a(wildcardType), a(wildcardType2)) && a(b(wildcardType), b(wildcardType2))) {
                return true;
            }
        }
        return false;
    }

    private static String c(ParameterizedType parameterizedType) {
        StringBuilder sb = new StringBuilder();
        Type ownerType = parameterizedType.getOwnerType();
        Class cls = (Class) parameterizedType.getRawType();
        if (ownerType == null) {
            sb.append(cls.getName());
        } else {
            sb.append(ownerType instanceof Class ? ((Class) ownerType).getName() : ownerType.toString());
            sb.append('.').append(cls.getSimpleName());
        }
        int[] iArrA = a(parameterizedType);
        if (iArrA.length > 0) {
            a(sb, iArrA, parameterizedType.getActualTypeArguments());
        } else {
            a(sb.append(Typography.less), ", ", parameterizedType.getActualTypeArguments()).append(Typography.greater);
        }
        return sb.toString();
    }

    private static <T> StringBuilder a(StringBuilder sb, String str, T... tArr) {
        h.b(h.a((Object[]) tArr));
        if (tArr.length > 0) {
            sb.append(a(tArr[0]));
            for (int i = 1; i < tArr.length; i++) {
                sb.append(str).append(a(tArr[i]));
            }
        }
        return sb;
    }

    public static Type[] b(WildcardType wildcardType) {
        h.a(wildcardType, "wildcardType", new Object[0]);
        Type[] upperBounds = wildcardType.getUpperBounds();
        return upperBounds.length == 0 ? new Type[]{Object.class} : a(upperBounds);
    }

    private static String c(WildcardType wildcardType) {
        StringBuilder sbAppend = new StringBuilder().append('?');
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (lowerBounds.length > 1 || (lowerBounds.length == 1 && lowerBounds[0] != null)) {
            a(sbAppend.append(" super "), " & ", lowerBounds);
        } else if (upperBounds.length > 1 || (upperBounds.length == 1 && !Object.class.equals(upperBounds[0]))) {
            a(sbAppend.append(" extends "), " & ", upperBounds);
        }
        return sbAppend.toString();
    }

    private static void a(StringBuilder sb, int[] iArr, Type[] typeArr) {
        for (int i = 0; i < iArr.length; i++) {
            a(sb.append(Typography.less), ", ", typeArr[i].toString()).append(Typography.greater);
        }
        Type[] typeArr2 = (Type[]) sdk.pendo.io.w1.b.a((Object[]) typeArr, iArr);
        if (typeArr2.length > 0) {
            a(sb.append(Typography.less), ", ", typeArr2).append(Typography.greater);
        }
    }

    private static Class<?> b(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
    }

    private static String a(Class<?> cls) {
        if (cls.isArray()) {
            return a((Type) cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        if (cls.getEnclosingClass() != null) {
            sb.append(a(cls.getEnclosingClass())).append('.').append(cls.getSimpleName());
        } else {
            sb.append(cls.getName());
        }
        if (cls.getTypeParameters().length > 0) {
            sb.append(Typography.less);
            a(sb, ", ", cls.getTypeParameters());
            sb.append(Typography.greater);
        }
        return sb.toString();
    }

    private static boolean b(Type type, Class<?> cls) {
        if (type == null) {
            return cls == null || !cls.isPrimitive();
        }
        if (cls == null) {
            return false;
        }
        if (cls.equals(type)) {
            return true;
        }
        if (type instanceof Class) {
            return d.a((Class) type, cls);
        }
        if (type instanceof ParameterizedType) {
            return b((Type) b((ParameterizedType) type), cls);
        }
        if (!(type instanceof TypeVariable)) {
            if (type instanceof GenericArrayType) {
                return cls.equals(Object.class) || (cls.isArray() && b(((GenericArrayType) type).getGenericComponentType(), cls.getComponentType()));
            }
            if (type instanceof WildcardType) {
                return false;
            }
            throw new IllegalStateException("found an unhandled type: " + type);
        }
        for (Type type2 : ((TypeVariable) type).getBounds()) {
            if (b(type2, cls)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(TypeVariable<?> typeVariable, ParameterizedType parameterizedType) {
        return sdk.pendo.io.w1.b.b(typeVariable.getBounds(), parameterizedType);
    }

    public static boolean b(Type type, Type type2) {
        return a(type, type2, (Map<TypeVariable<?>, Type>) null);
    }

    private static boolean a(GenericArrayType genericArrayType, Type type) {
        return (type instanceof GenericArrayType) && a(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType());
    }

    private static String b(TypeVariable<?> typeVariable) {
        StringBuilder sb = new StringBuilder(typeVariable.getName());
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0 && (bounds.length != 1 || !Object.class.equals(bounds[0]))) {
            sb.append(" extends ");
            a(sb, " & ", typeVariable.getBounds());
        }
        return sb.toString();
    }

    private static boolean a(ParameterizedType parameterizedType, Type type) {
        if (!(type instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) type;
        if (a(parameterizedType.getRawType(), parameterizedType2.getRawType()) && a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
            return a(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        return false;
    }

    public static boolean a(Type type, Type type2) {
        if (Objects.equals(type, type2)) {
            return true;
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type, type2);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type, type2);
        }
        if (type instanceof WildcardType) {
            return b((WildcardType) type, type2);
        }
        return false;
    }

    private static boolean a(Type[] typeArr, Type[] typeArr2) {
        if (typeArr.length != typeArr2.length) {
            return false;
        }
        for (int i = 0; i < typeArr.length; i++) {
            if (!a(typeArr[i], typeArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(ParameterizedType parameterizedType) {
        Type[] typeArr = (Type[]) Arrays.copyOf(parameterizedType.getActualTypeArguments(), parameterizedType.getActualTypeArguments().length);
        int[] iArrA = new int[0];
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if ((type instanceof TypeVariable) && a((TypeVariable<?>) type, parameterizedType)) {
                iArrA = sdk.pendo.io.w1.b.a(iArrA, i);
            }
        }
        return iArrA;
    }

    private static String a(GenericArrayType genericArrayType) {
        return String.format("%s[]", a(genericArrayType.getGenericComponentType()));
    }

    private static Type a(Class<?> cls, Class<?> cls2) {
        Class<?> clsB;
        if (cls2.isInterface()) {
            Type type = null;
            for (Type type2 : cls.getGenericInterfaces()) {
                if (type2 instanceof ParameterizedType) {
                    clsB = b((ParameterizedType) type2);
                } else {
                    if (!(type2 instanceof Class)) {
                        throw new IllegalStateException("Unexpected generic interface type found: " + type2);
                    }
                    clsB = (Class) type2;
                }
                if (b((Type) clsB, cls2) && b(type, (Type) clsB)) {
                    type = type2;
                }
            }
            if (type != null) {
                return type;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static Type[] a(TypeVariable<?> typeVariable) {
        h.a(typeVariable, "typeVariable", new Object[0]);
        Type[] bounds = typeVariable.getBounds();
        return bounds.length == 0 ? new Type[]{Object.class} : a(bounds);
    }

    public static Type[] a(WildcardType wildcardType) {
        h.a(wildcardType, "wildcardType", new Object[0]);
        Type[] lowerBounds = wildcardType.getLowerBounds();
        return lowerBounds.length == 0 ? new Type[]{null} : lowerBounds;
    }

    private static Map<TypeVariable<?>, Type> a(Class<?> cls, Class<?> cls2, Map<TypeVariable<?>, Type> map) {
        if (!b((Type) cls, cls2)) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (cls2.isPrimitive()) {
                return new HashMap();
            }
            cls = d.d(cls);
        }
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        return cls2.equals(cls) ? map2 : a(a(cls, cls2), cls2, (Map<TypeVariable<?>, Type>) map2);
    }

    private static Map<TypeVariable<?>, Type> a(ParameterizedType parameterizedType, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Map<TypeVariable<?>, Type> map2;
        Class<?> clsB = b(parameterizedType);
        if (!b((Type) clsB, cls)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            map2 = a(parameterizedType2, b(parameterizedType2), map);
        } else {
            map2 = map == null ? new HashMap<>() : new HashMap(map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable<Class<?>>[] typeParameters = clsB.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            Type type = actualTypeArguments[i];
            map2.put(typeParameters[i], map2.getOrDefault(type, type));
        }
        return cls.equals(clsB) ? map2 : a(a(clsB, cls), cls, map2);
    }

    public static Map<TypeVariable<?>, Type> a(Type type, Class<?> cls) {
        return a(type, cls, (Map<TypeVariable<?>, Type>) null);
    }

    private static Map<TypeVariable<?>, Type> a(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        if (type instanceof Class) {
            return a((Class<?>) type, cls, map);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type, cls, map);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return a(genericComponentType, cls, map);
        }
        int i = 0;
        if (type instanceof WildcardType) {
            Type[] typeArrB = b((WildcardType) type);
            int length = typeArrB.length;
            while (i < length) {
                Type type2 = typeArrB[i];
                if (b(type2, cls)) {
                    return a(type2, cls, map);
                }
                i++;
            }
            return null;
        }
        if (!(type instanceof TypeVariable)) {
            throw new IllegalStateException("found an unhandled type: " + type);
        }
        Type[] typeArrA = a((TypeVariable<?>) type);
        int length2 = typeArrA.length;
        while (i < length2) {
            Type type3 = typeArrA[i];
            if (b(type3, cls)) {
                return a(type3, cls, map);
            }
            i++;
        }
        return null;
    }

    private static boolean a(Type type, GenericArrayType genericArrayType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (genericArrayType == null) {
            return false;
        }
        if (genericArrayType.equals(type)) {
            return true;
        }
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() && a(cls.getComponentType(), genericComponentType, map);
        }
        if (type instanceof GenericArrayType) {
            return a(((GenericArrayType) type).getGenericComponentType(), genericComponentType, map);
        }
        if (type instanceof WildcardType) {
            for (Type type2 : b((WildcardType) type)) {
                if (b(type2, genericArrayType)) {
                    return true;
                }
            }
            return false;
        }
        if (!(type instanceof TypeVariable)) {
            if (type instanceof ParameterizedType) {
                return false;
            }
            throw new IllegalStateException("found an unhandled type: " + type);
        }
        for (Type type3 : a((TypeVariable<?>) type)) {
            if (b(type3, genericArrayType)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Type type, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (parameterizedType == null || (type instanceof GenericArrayType)) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> clsB = b(parameterizedType);
        Map<TypeVariable<?>, Type> mapA = a(type, clsB, (Map<TypeVariable<?>, Type>) null);
        if (mapA == null) {
            return false;
        }
        if (mapA.isEmpty()) {
            return true;
        }
        Map<TypeVariable<?>, Type> mapA2 = a(parameterizedType, clsB, map);
        for (TypeVariable<?> typeVariable : mapA2.keySet()) {
            Type typeA = a(typeVariable, mapA2);
            Type typeA2 = a(typeVariable, mapA);
            if (typeA != null || !(typeA2 instanceof Class)) {
                if (typeA2 != null && typeA != null && !typeA.equals(typeA2) && (!(typeA instanceof WildcardType) || !a(typeA2, typeA, map))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean a(Type type, Type type2, Map<TypeVariable<?>, Type> map) {
        if (type2 == null || (type2 instanceof Class)) {
            return b(type, (Class<?>) type2);
        }
        if (type2 instanceof ParameterizedType) {
            return a(type, (ParameterizedType) type2, map);
        }
        if (type2 instanceof GenericArrayType) {
            return a(type, (GenericArrayType) type2, map);
        }
        if (type2 instanceof WildcardType) {
            return a(type, (WildcardType) type2, map);
        }
        if (type2 instanceof TypeVariable) {
            return a(type, (TypeVariable<?>) type2, map);
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    private static boolean a(Type type, TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (typeVariable == null) {
            return false;
        }
        if (typeVariable.equals(type)) {
            return true;
        }
        if (type instanceof TypeVariable) {
            for (Type type2 : a((TypeVariable<?>) type)) {
                if (a(type2, typeVariable, map)) {
                    return true;
                }
            }
        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    private static boolean a(Type type, WildcardType wildcardType, Map<TypeVariable<?>, Type> map) {
        if (type == null) {
            return true;
        }
        if (wildcardType == null) {
            return false;
        }
        if (wildcardType.equals(type)) {
            return true;
        }
        Type[] typeArrB = b(wildcardType);
        Type[] typeArrA = a(wildcardType);
        if (!(type instanceof WildcardType)) {
            for (Type type2 : typeArrB) {
                if (!a(type, a(type2, map), map)) {
                    return false;
                }
            }
            for (Type type3 : typeArrA) {
                if (!a(a(type3, map), type, map)) {
                    return false;
                }
            }
            return true;
        }
        WildcardType wildcardType2 = (WildcardType) type;
        Type[] typeArrB2 = b(wildcardType2);
        Type[] typeArrA2 = a(wildcardType2);
        for (Type type4 : typeArrB) {
            Type typeA = a(type4, map);
            for (Type type5 : typeArrB2) {
                if (!a(type5, typeA, map)) {
                    return false;
                }
            }
        }
        for (Type type6 : typeArrA) {
            Type typeA2 = a(type6, map);
            for (Type type7 : typeArrA2) {
                if (!a(typeA2, type7, map)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Type[] a(Type[] typeArr) {
        h.a(typeArr, "bounds", new Object[0]);
        if (typeArr.length < 2) {
            return typeArr;
        }
        HashSet hashSet = new HashSet(typeArr.length);
        for (Type type : typeArr) {
            int length = typeArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    hashSet.add(type);
                    break;
                }
                Type type2 = typeArr[i];
                if (type != type2 && a(type2, type, (Map<TypeVariable<?>, Type>) null)) {
                    break;
                }
                i++;
            }
        }
        return (Type[]) hashSet.toArray(sdk.pendo.io.w1.b.w);
    }

    private static Type a(Type type, Map<TypeVariable<?>, Type> map) {
        if (!(type instanceof TypeVariable) || map == null) {
            return type;
        }
        Type type2 = map.get(type);
        if (type2 != null) {
            return type2;
        }
        throw new IllegalArgumentException("missing assignment type for type variable " + type);
    }

    private static <T> String a(T t) {
        return t instanceof Type ? a((Type) t) : t.toString();
    }

    public static String a(Type type) {
        h.a(type);
        if (type instanceof Class) {
            return a((Class<?>) type);
        }
        if (type instanceof ParameterizedType) {
            return c((ParameterizedType) type);
        }
        if (type instanceof WildcardType) {
            return c((WildcardType) type);
        }
        if (type instanceof TypeVariable) {
            return b((TypeVariable<?>) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        throw new IllegalArgumentException(e.a(type));
    }

    private static Type a(TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> map) {
        Type type;
        while (true) {
            type = map.get(typeVariable);
            if (!(type instanceof TypeVariable) || type.equals(typeVariable)) {
                break;
            }
            typeVariable = (TypeVariable) type;
        }
        return type;
    }

    public static b a() {
        return new b();
    }
}
