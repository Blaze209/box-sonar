package com.box.android.contentpicker;

import android.app.Activity;
import android.content.Intent;
import com.box.android.base.presentation.multiselect.ContentPickerConstants;
import com.box.android.base.presentation.multiselect.SelectionItemInfo;
import com.box.android.base.presentation.multiselect.SelectionManager;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContentPickerActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u001a*\u0010\n\u001a\u00020\u000b*\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t¨\u0006\u000f"}, d2 = {"isSessionUploadedSource", "", "itemInfo", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "initialConfiguration", "", "selectionManager", "Lcom/box/android/base/presentation/multiselect/SelectionManager;", "initialSelections", "", "buildContentPickerResultIntent", "Landroid/content/Intent;", "Landroid/app/Activity;", "selectedRemoteItems", "newLocalItems", "content-picker_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentPickerActivityKt {
    private static final boolean isSessionUploadedSource(SelectionItemInfo selectionItemInfo) {
        return StringsKt.contains$default((CharSequence) selectionItemInfo.getId(), (CharSequence) ImagesContract.LOCAL, false, 2, (Object) null) || selectionItemInfo.getBoxId() == null;
    }

    public static final void initialConfiguration(SelectionManager selectionManager, List<SelectionItemInfo> initialSelections) {
        Intrinsics.checkNotNullParameter(selectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(initialSelections, "initialSelections");
        selectionManager.setCanExit(false);
        selectionManager.setAllowFolderNavigation(true);
        ArrayList arrayList = new ArrayList();
        for (Object obj : initialSelections) {
            if (!isSessionUploadedSource((SelectionItemInfo) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            selectionManager.selectItem((SelectionItemInfo) it.next());
        }
    }

    public static /* synthetic */ Intent buildContentPickerResultIntent$default(Activity activity, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return buildContentPickerResultIntent(activity, list, list2);
    }

    public static final Intent buildContentPickerResultIntent(Activity activity, List<SelectionItemInfo> selectedRemoteItems, List<SelectionItemInfo> newLocalItems) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(selectedRemoteItems, "selectedRemoteItems");
        Intrinsics.checkNotNullParameter(newLocalItems, "newLocalItems");
        ContentPickerActivity.Companion companion = ContentPickerActivity.INSTANCE;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        List<SelectionItemInfo> initialSelections = companion.parseInitialSelections(intent);
        ArrayList arrayList = new ArrayList();
        for (Object obj : initialSelections) {
            if (!isSessionUploadedSource((SelectionItemInfo) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((SelectionItemInfo) it.next()).getId());
        }
        Set set = CollectionsKt.toSet(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : initialSelections) {
            SelectionItemInfo selectionItemInfo = (SelectionItemInfo) obj2;
            if (isSessionUploadedSource(selectionItemInfo) || set.contains(selectionItemInfo.getId())) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : selectedRemoteItems) {
            if (!set.contains(((SelectionItemInfo) obj3).getId())) {
                arrayList6.add(obj3);
            }
        }
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) newLocalItems, (Iterable) arrayList6), (Iterable) arrayList5);
        Intent intent2 = new Intent();
        intent2.putParcelableArrayListExtra(ContentPickerConstants.EXTRA_SELECTED_ITEMS, new ArrayList<>(listPlus));
        return intent2;
    }
}
