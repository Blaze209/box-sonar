package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.PreviewUtils_androidKt;
import androidx.compose.ui.tooling.data.Group;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationSearch.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\b\u0012\u0004\u0012\u00020\r0\fH\u0082\b\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\rH\u0082\b\u001a&\u0010\u000e\u001a\u0004\u0018\u0001H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0082\b¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"UPDATE_TRANSITION", "", "ANIMATED_CONTENT", "ANIMATED_VISIBILITY", "ANIMATE_VALUE_AS_STATE", "REMEMBER", "REMEMBER_INFINITE_TRANSITION", "REMEMBER_UPDATED_STATE", "SIZE_ANIMATION_MODIFIER", "findRememberedData", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/ui/tooling/data/Group;", "findData", "includeGrandchildren", "", "(Landroidx/compose/ui/tooling/data/Group;Z)Ljava/lang/Object;", "ui-tooling"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationSearch_androidKt {
    private static final String ANIMATED_CONTENT = "AnimatedContent";
    private static final String ANIMATED_VISIBILITY = "AnimatedVisibility";
    private static final String ANIMATE_VALUE_AS_STATE = "animateValueAsState";
    private static final String REMEMBER = "remember";
    private static final String REMEMBER_INFINITE_TRANSITION = "rememberInfiniteTransition";
    private static final String REMEMBER_UPDATED_STATE = "rememberUpdatedState";
    private static final String SIZE_ANIMATION_MODIFIER = "androidx.compose.animation.SizeAnimationModifierElement";
    private static final String UPDATE_TRANSITION = "updateTransition";

    private static final /* synthetic */ <T> List<T> findRememberedData(Collection<? extends Group> collection) {
        T next;
        Collection<? extends Group> collection2 = collection;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection2.iterator();
        while (true) {
            T t = null;
            if (!it.hasNext()) {
                break;
            }
            for (T t2 : ((Group) it.next()).getData()) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (t2 instanceof Object) {
                    t = t2;
                    break;
                }
            }
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            if (t != null) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = collection2.iterator();
        while (it2.hasNext()) {
            Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it2.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
            if (groupFirstOrNull != null) {
                arrayList3.add(groupFirstOrNull);
            }
        }
        ArrayList arrayList4 = arrayList2;
        ArrayList arrayList5 = new ArrayList();
        Iterator<T> it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            Iterator<T> it4 = ((Group) it3.next()).getData().iterator();
            do {
                if (!it4.hasNext()) {
                    next = null;
                    break;
                }
                next = it4.next();
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            } while (!(next instanceof Object));
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            if (next != null) {
                arrayList5.add(next);
            }
        }
        return CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5);
    }

    private static final /* synthetic */ <T> List<T> findRememberedData(Group group) {
        T next;
        List listEmptyList;
        T next2;
        T next3;
        Iterator<T> it = group.getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        } while (!(next instanceof Object));
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        if (next == null || (listEmptyList = CollectionsKt.listOf(next)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = listEmptyList;
        Collection<Group> children = group.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = children.iterator();
        while (it2.hasNext()) {
            Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
            do {
                if (!it3.hasNext()) {
                    next3 = null;
                    break;
                }
                next3 = it3.next();
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            } while (!(next3 instanceof Object));
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            if (next3 != null) {
                arrayList.add(next3);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it4 = children.iterator();
        while (it4.hasNext()) {
            Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
            if (groupFirstOrNull != null) {
                arrayList3.add(groupFirstOrNull);
            }
        }
        ArrayList arrayList4 = arrayList2;
        ArrayList arrayList5 = new ArrayList();
        Iterator<T> it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            Iterator<T> it6 = ((Group) it5.next()).getData().iterator();
            do {
                if (!it6.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it6.next();
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            } while (!(next2 instanceof Object));
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            if (next2 != null) {
                arrayList5.add(next2);
            }
        }
        return CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5));
    }

    private static final /* synthetic */ <T> T findData(Group group, boolean z) {
        Collection<Object> data = group.getData();
        List children = group.getChildren();
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Group) it.next()).getChildren());
            }
            children = CollectionsKt.plus((Collection) children, (Iterable) arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = children.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((Group) it2.next()).getData());
        }
        for (T t : CollectionsKt.plus((Collection) data, (Iterable) arrayList2)) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (t instanceof Object) {
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return t;
            }
        }
        t = null;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    static /* synthetic */ Object findData$default(Group group, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Collection<Object> data = group.getData();
        List children = group.getChildren();
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Group) it.next()).getChildren());
            }
            children = CollectionsKt.plus((Collection) children, (Iterable) arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = children.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((Group) it2.next()).getData());
        }
        for (Object obj2 : CollectionsKt.plus((Collection) data, (Iterable) arrayList2)) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj2 instanceof Object) {
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return obj2;
            }
        }
        obj2 = null;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return obj2;
    }
}
