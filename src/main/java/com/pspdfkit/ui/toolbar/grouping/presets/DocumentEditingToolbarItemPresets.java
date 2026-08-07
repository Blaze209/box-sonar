package com.pspdfkit.ui.toolbar.grouping.presets;

import com.pspdfkit.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentEditingToolbarItemPresets {
    public static final List<MenuItem> ALL_ITEMS_GROUPING;
    public static final List<MenuItem> FIVE_ITEMS_GROUPING;
    public static final List<MenuItem> FOUR_ITEMS_GROUPING;
    public static final List<MenuItem> SIX_ITEMS_GROUPING;

    static {
        ArrayList arrayList = new ArrayList(4);
        FOUR_ITEMS_GROUPING = arrayList;
        ArrayList arrayList2 = new ArrayList(5);
        FIVE_ITEMS_GROUPING = arrayList2;
        ArrayList arrayList3 = new ArrayList(6);
        SIX_ITEMS_GROUPING = arrayList3;
        ArrayList arrayList4 = new ArrayList(7);
        ALL_ITEMS_GROUPING = arrayList4;
        arrayList.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_remove_pages));
        arrayList.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_duplicate_pages));
        arrayList.add(new MenuItem(R.id.pspdf__document_editing_toolbar_group_more, new int[]{R.id.pspdf__document_editing_toolbar_item_rotate_pages, R.id.pspdf__document_editing_toolbar_item_import_document, R.id.pspdf__document_editing_toolbar_item_export_pages, R.id.pspdf__document_editing_toolbar_item_undo, R.id.pspdf__document_editing_toolbar_item_redo}));
        arrayList.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_done));
        arrayList2.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_remove_pages));
        arrayList2.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_duplicate_pages));
        arrayList2.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_rotate_pages));
        arrayList2.add(new MenuItem(R.id.pspdf__document_editing_toolbar_group_more, new int[]{R.id.pspdf__document_editing_toolbar_item_import_document, R.id.pspdf__document_editing_toolbar_item_export_pages, R.id.pspdf__document_editing_toolbar_item_undo, R.id.pspdf__document_editing_toolbar_item_redo}));
        arrayList2.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_done));
        arrayList3.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_remove_pages));
        arrayList3.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_duplicate_pages));
        arrayList3.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_rotate_pages));
        arrayList3.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_import_document));
        arrayList3.add(new MenuItem(R.id.pspdf__document_editing_toolbar_group_more, new int[]{R.id.pspdf__document_editing_toolbar_item_export_pages, R.id.pspdf__document_editing_toolbar_item_undo, R.id.pspdf__document_editing_toolbar_item_redo}));
        arrayList3.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_done));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_remove_pages));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_duplicate_pages));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_rotate_pages));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_import_document));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_export_pages));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_undo));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_redo));
        arrayList4.add(new MenuItem(R.id.pspdf__document_editing_toolbar_item_done));
    }
}
