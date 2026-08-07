package com.box.android.data.service.impl;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.search.NoteSearchItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchService$searchNotes$2$1 extends FunctionReferenceImpl implements Function2<FileModel, String, NoteSearchItem> {
    public static final SearchService$searchNotes$2$1 INSTANCE = new SearchService$searchNotes$2$1();

    SearchService$searchNotes$2$1() {
        super(2, NoteSearchItem.class, "<init>", "<init>(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final NoteSearchItem invoke(FileModel p0, String str) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new NoteSearchItem(p0, str);
    }
}
