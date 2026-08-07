package com.box.android.preview.integration.nutrient;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import kotlin.Metadata;

/* JADX INFO: compiled from: NutrientPdfFragmentBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/preview/integration/nutrient/NutrientPdfFragmentBuilder;", "Landroid/os/Parcelable;", "build", "Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NutrientPdfFragmentBuilder extends Parcelable {
    PdfUIFragmentWrapper build(Context context, Uri uri);
}
