package com.box.android.browse.cpl.browse.fab.newfile;

import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.base.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: NewFileType.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileType;", "", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "", "ext", "menuId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getAssetName", "()Ljava/lang/String;", "getExt", "getMenuId", "()I", "Word", "Ppt", "Spreadsheet", "Text", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum NewFileType {
    Word("newdocument.docx", "docx", R.id.word_doc),
    Ppt("newpresentation.pptx", "pptx", R.id.powerpoint_doc),
    Spreadsheet("newspreadsheet.xlsx", "xlsx", R.id.spreadsheet_doc),
    Text("text.txt", "txt", R.id.text_doc);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String assetName;
    private final String ext;
    private final int menuId;

    public static EnumEntries<NewFileType> getEntries() {
        return $ENTRIES;
    }

    NewFileType(String str, String str2, int i) {
        this.assetName = str;
        this.ext = str2;
        this.menuId = i;
    }

    public final String getAssetName() {
        return this.assetName;
    }

    public final String getExt() {
        return this.ext;
    }

    public final int getMenuId() {
        return this.menuId;
    }
}
