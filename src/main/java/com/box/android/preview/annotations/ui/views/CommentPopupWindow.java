package com.box.android.preview.annotations.ui.views;

import android.view.View;
import android.widget.PopupWindow;
import com.box.android.preview.R;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CommentPopupWindow.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/CommentPopupWindow;", "Lcom/box/android/preview/annotations/ui/views/BoxPopupWindow;", "view", "Landroid/view/View;", "undoOperation", "Lkotlin/Function0;", "", "redoOperation", "removeOperation", "Lkotlin/Function1;", "Landroid/widget/PopupWindow;", "saveOperation", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentPopupWindow extends BoxPopupWindow {
    public static final int $stable = 8;

    public CommentPopupWindow(View view, final Function0<Unit> undoOperation, final Function0<Unit> redoOperation, final Function1<? super PopupWindow, Unit> removeOperation, final Function1<? super PopupWindow, Unit> saveOperation) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(undoOperation, "undoOperation");
        Intrinsics.checkNotNullParameter(redoOperation, "redoOperation");
        Intrinsics.checkNotNullParameter(removeOperation, "removeOperation");
        Intrinsics.checkNotNullParameter(saveOperation, "saveOperation");
        HashSet hashSetHashSetOf = SetsKt.hashSetOf(Integer.valueOf(R.id.redo), Integer.valueOf(R.id.undo), Integer.valueOf(R.id.save_comment), Integer.valueOf(R.id.remove));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(hashSetHashSetOf, 10)), 16));
        for (Object obj : hashSetHashSetOf) {
            ((Number) obj).intValue();
            linkedHashMap.put(obj, new MenuItemState(false, false, 3, null));
        }
        super(view, linkedHashMap, new Function2() { // from class: com.box.android.preview.annotations.ui.views.CommentPopupWindow$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return CommentPopupWindow._init_$lambda$1(undoOperation, redoOperation, saveOperation, removeOperation, (View) obj2, (PopupWindow) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(Function0 function0, Function0 function1, Function1 function2, Function1 function3, View v, PopupWindow popupWindow) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
        int id = v.getId();
        if (id == R.id.undo) {
            function0.invoke();
        } else if (id == R.id.redo) {
            function1.invoke();
        } else if (id == R.id.save_comment) {
            function2.invoke(popupWindow);
        } else if (id == R.id.remove) {
            function3.invoke(popupWindow);
        }
        return Unit.INSTANCE;
    }
}
