package com.box.android.browse.cpl.browse.fab.newfile;

import android.content.Context;
import android.content.Intent;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.utils.MimeTypeHelper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewFileMenuUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileMenuUtils;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getAvailableCreateNewFileOptions", "", "Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileType;", "isIntentAvailable", "", "fileType", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewFileMenuUtils {
    public static final int $stable = 8;
    private final Context context;

    @Inject
    public NewFileMenuUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<NewFileType> getAvailableCreateNewFileOptions() {
        ArrayList arrayList = new ArrayList();
        for (NewFileType newFileType : NewFileType.getEntries()) {
            if (isIntentAvailable(newFileType, this.context)) {
                arrayList.add(newFileType);
            }
        }
        return arrayList;
    }

    private final boolean isIntentAvailable(NewFileType fileType, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setType(MimeTypeHelper.getTypeFromExt(fileType.getExt()));
        return CommonBoxUtil.isIntentAvailable(context, intent);
    }
}
