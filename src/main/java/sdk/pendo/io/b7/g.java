package sdk.pendo.io.b7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003J?\u0010\u0005\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\u00032\u001a\u0010\n\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\t\"\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0005\u0010\fJ;\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u000fJ\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0003¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/b7/g;", "", "target", "", "fieldName", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/Class;", "clazz", "methodName", "", "parameterTypes", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", FirebaseAnalytics.Param.METHOD, "args", "(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "className", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class g {
    public static final g a = new g();

    private g() {
    }

    public final Object a(Object target, String fieldName) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        for (Class<?> superclass = target.getClass(); superclass != null && !Intrinsics.areEqual(superclass, Object.class); superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                return declaredField.get(target);
            } catch (NoSuchFieldException unused) {
            } catch (Throwable th) {
                PendoLogger.v("ReflectionUtils", "getFieldValue failed for field '" + fieldName + "': " + th);
                return null;
            }
        }
        return null;
    }

    public final Method a(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        while (clazz != null && !Intrinsics.areEqual(clazz, Object.class)) {
            try {
                Method declaredMethod = clazz.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                clazz = clazz.getSuperclass();
            } catch (Throwable th) {
                PendoLogger.v("ReflectionUtils", "getDeclaredMethod failed for method '" + methodName + "': " + th);
                return null;
            }
        }
        return null;
    }

    public final Object a(Method method, Object target, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (method != null) {
            try {
                return method.invoke(target, Arrays.copyOf(args, args.length));
            } catch (Throwable th) {
                PendoLogger.v("ReflectionUtils", "invokeMethod failed: " + th);
            }
        }
        return null;
    }

    public final Class<?> a(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            return Class.forName(className);
        } catch (Throwable th) {
            PendoLogger.v("ReflectionUtils", "loadClass failed for '" + className + "': " + th);
            return null;
        }
    }
}
