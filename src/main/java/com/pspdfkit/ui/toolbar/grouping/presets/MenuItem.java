package com.pspdfkit.ui.toolbar.grouping.presets;

import android.content.Context;
import android.util.Log;
import com.pspdfkit.R;
import com.pspdfkit.internal.n5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public class MenuItem {
    private static final List<Integer> VALID_GROUP_IDS = Arrays.asList(Integer.valueOf(R.id.pspdf__annotation_toolbar_group_markup), Integer.valueOf(R.id.pspdf__annotation_toolbar_group_measurement), Integer.valueOf(R.id.pspdf__annotation_toolbar_group_drawing), Integer.valueOf(R.id.pspdf__annotation_toolbar_group_writing), Integer.valueOf(R.id.pspdf__annotation_toolbar_group_multimedia), Integer.valueOf(R.id.pspdf__annotation_toolbar_group_undo_redo), Integer.valueOf(R.id.pspdf__annotation_popup_toolbar_group_undo_redo), Integer.valueOf(R.id.pspdf__annotation_popup_toolbar_group_copy_cut), Integer.valueOf(R.id.pspdf__annotation_popup_toolbar_group_inspector), Integer.valueOf(R.id.pspdf__annotation_popup_toolbar_group_edit_share), Integer.valueOf(R.id.pspdf__document_editing_toolbar_group_more));
    private final String LOG_TAG;
    public final int id;
    public final int[] submenuIds;

    public MenuItem(int i) {
        this(i, null);
    }

    public MenuItem(int i, int[] iArr) {
        this.LOG_TAG = "Nutri.MenuItem";
        List<Integer> list = VALID_GROUP_IDS;
        if (!list.contains(Integer.valueOf(i)) && iArr != null) {
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            String resourceEntryName = context.getResources().getResourceEntryName(i);
            StringBuilder sb = new StringBuilder("are ");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(context.getResources().getResourceEntryName(((Number) it.next()).intValue()));
            }
            String str = "Illegal id (" + resourceEntryName + ") was passed in for group MenuItem. Valid ids " + sb.append(arrayList.toString()).toString();
            Log.e("Nutri.MenuItem", str, new IllegalArgumentException(str));
        }
        this.id = i;
        this.submenuIds = iArr;
    }
}
