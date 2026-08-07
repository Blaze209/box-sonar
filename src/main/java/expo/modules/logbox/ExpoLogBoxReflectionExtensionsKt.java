package expo.modules.logbox;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: ExpoLogBoxReflectionExtensions.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aM\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a3\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"setProtectedDeclaredField", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "obj", "filedName", "", "newValue", "", IdentificationData.PREDICATE, "Lkotlin/Function1;", "", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "getProtectedFieldValue", "U", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "expo-log-box_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExpoLogBoxReflectionExtensionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setProtectedDeclaredField$lambda$0(Object obj) {
        return true;
    }

    public static /* synthetic */ void setProtectedDeclaredField$default(Class cls, Object obj, String str, Object obj2, Function1 function1, int i, Object obj3) throws IllegalAccessException, NoSuchFieldException {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: expo.modules.logbox.ExpoLogBoxReflectionExtensionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return Boolean.valueOf(ExpoLogBoxReflectionExtensionsKt.setProtectedDeclaredField$lambda$0(obj4));
                }
            };
        }
        setProtectedDeclaredField(cls, obj, str, obj2, function1);
    }

    public static final <T> void setProtectedDeclaredField(Class<? extends T> cls, T t, String filedName, Object newValue, Function1<Object, Boolean> predicate) throws IllegalAccessException, NoSuchFieldException {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(filedName, "filedName");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Field declaredField = cls.getDeclaredField(filedName);
        Field declaredField2 = Field.class.getDeclaredField("accessFlags");
        declaredField.setAccessible(true);
        declaredField2.setAccessible(true);
        declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
        if (predicate.invoke(declaredField.get(t)).booleanValue()) {
            declaredField.set(t, newValue);
        }
    }

    public static final <T, U> U getProtectedFieldValue(Class<? extends T> cls, T t, String filedName) throws NoSuchFieldException {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(filedName, "filedName");
        Field declaredField = cls.getDeclaredField(filedName);
        declaredField.setAccessible(true);
        return (U) declaredField.get(t);
    }
}
