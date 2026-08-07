package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: PreviewUtils.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u0001*\u00020\u0003H\u0000\u001a3\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0014\u0010\u0007\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\"\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001a&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001a4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0002\u001a)\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"asPreviewProviderClass", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "", "getPreviewProviderParameters", "", "", "parameterProviderClass", "parameterProviderIndex", "", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "unwrapIfInline", "classToCheck", "firstOrNull", "Landroidx/compose/ui/tooling/data/Group;", IdentificationData.PREDICATE, "Lkotlin/Function1;", "", "findAll", "", "findGroupsThatMatchPredicate", "root", "findOnlyFirst", "toArray", "Lkotlin/sequences/Sequence;", "size", "(Lkotlin/sequences/Sequence;I)[Ljava/lang/Object;", "ui-tooling"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PreviewUtils_androidKt {
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(String str) {
        try {
            Class cls = Class.forName(str);
            if (cls instanceof Class) {
                return cls;
            }
            return null;
        } catch (ClassNotFoundException e) {
            PreviewLogger.INSTANCE.logError$ui_tooling("Unable to find PreviewProvider '" + str + '\'', e);
            return null;
        }
    }

    public static final Object[] getPreviewProviderParameters(Class<? extends PreviewParameterProvider<?>> cls, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if (cls != null) {
            try {
                Constructor<?>[] constructors = cls.getConstructors();
                int length = constructors.length;
                Constructor<?> constructor = null;
                int i2 = 0;
                boolean z = false;
                Constructor<?> constructor2 = null;
                while (true) {
                    if (i2 >= length) {
                        if (!z) {
                            break;
                        }
                        constructor = constructor2;
                        break;
                    }
                    Constructor<?> constructor3 = constructors[i2];
                    if (constructor3.getParameterTypes().length == 0) {
                        if (z) {
                            break;
                        }
                        z = true;
                        constructor2 = constructor3;
                    }
                    i2++;
                }
                if (constructor != null) {
                    constructor.setAccessible(true);
                    Object objNewInstance = constructor.newInstance(new Object[0]);
                    Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
                    PreviewParameterProvider previewParameterProvider = (PreviewParameterProvider) objNewInstance;
                    if (i < 0) {
                        return toArray(previewParameterProvider.getValues(), previewParameterProvider.getCount());
                    }
                    List listListOf = CollectionsKt.listOf(SequencesKt.elementAt(previewParameterProvider.getValues(), i));
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
                    Iterator it = listListOf.iterator();
                    while (it.hasNext()) {
                        arrayList.add(unwrapIfInline(it.next()));
                    }
                    return arrayList.toArray(new Object[0]);
                }
                throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            } catch (KotlinReflectionNotSupportedError unused) {
                throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
            }
        }
        return new Object[0];
    }

    private static final Object unwrapIfInline(Object obj) throws NoSuchFieldException {
        if (obj != null) {
            for (Annotation annotation : obj.getClass().getAnnotations()) {
                if (annotation instanceof JvmInline) {
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (field.getType().isPrimitive()) {
                            Field declaredField = obj.getClass().getDeclaredField(field.getName());
                            declaredField.setAccessible(true);
                            return declaredField.get(obj);
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }
            }
        }
        return obj;
    }

    public static final Group firstOrNull(Group group, Function1<? super Group, Boolean> function1) {
        return (Group) CollectionsKt.firstOrNull((List) findGroupsThatMatchPredicate(group, function1, true));
    }

    public static final List<Group> findAll(Group group, Function1<? super Group, Boolean> function1) {
        return findGroupsThatMatchPredicate$default(group, function1, false, 4, null);
    }

    static /* synthetic */ List findGroupsThatMatchPredicate$default(Group group, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return findGroupsThatMatchPredicate(group, function1, z);
    }

    private static final List<Group> findGroupsThatMatchPredicate(Group group, Function1<? super Group, Boolean> function1, boolean z) {
        ArrayList arrayList = new ArrayList();
        List listMutableListOf = CollectionsKt.mutableListOf(group);
        while (!listMutableListOf.isEmpty()) {
            Group group2 = (Group) CollectionsKt.removeLast(listMutableListOf);
            if (function1.invoke(group2).booleanValue()) {
                if (z) {
                    return CollectionsKt.listOf(group2);
                }
                arrayList.add(group2);
            }
            listMutableListOf.addAll(group2.getChildren());
        }
        return arrayList;
    }

    private static final Object[] toArray(Sequence<? extends Object> sequence, int i) {
        Iterator<? extends Object> it = sequence.iterator();
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = it.next();
        }
        return objArr;
    }
}
