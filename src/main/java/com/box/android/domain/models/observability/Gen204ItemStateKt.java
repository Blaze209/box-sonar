package com.box.android.domain.models.observability;

import com.box.android.domain.models.item.FileModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204ItemState.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"gen204ItemState", "", "Lcom/box/android/domain/models/item/FileModel;", "getGen204ItemState", "(Lcom/box/android/domain/models/item/FileModel;)Ljava/lang/String;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Gen204ItemStateKt {
    public static final String getGen204ItemState(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (FileModel.INSTANCE.isWatermarked(fileModel)) {
            listCreateListBuilder.add(Gen204ItemState.WATERMARKED);
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        if (listBuild.isEmpty()) {
            listBuild = null;
        }
        if (listBuild != null) {
            return CollectionsKt.joinToString$default(listBuild, ",", null, null, 0, null, new Function1() { // from class: com.box.android.domain.models.observability.Gen204ItemStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Gen204ItemStateKt._get_gen204ItemState_$lambda$2((Gen204ItemState) obj);
                }
            }, 30, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _get_gen204ItemState_$lambda$2(Gen204ItemState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getValue();
    }
}
