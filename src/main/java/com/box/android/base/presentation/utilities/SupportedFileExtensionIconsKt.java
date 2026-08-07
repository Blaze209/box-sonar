package com.box.android.base.presentation.utilities;

import com.box.android.domain.utils.SupportedFileExtensions;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: SupportedFileExtensionIcons.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"documentExtensions", "", "", "imageExtensions", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SupportedFileExtensionIconsKt {
    private static final Set<String> documentExtensions = SetsKt.minus(SupportedFileExtensions.INSTANCE.getDOCUMENT_EXTENSIONS(), "pdf");
    private static final Set<String> imageExtensions = SetsKt.plus(SupportedFileExtensions.INSTANCE.getIMAGE_EXTENSIONS(), SupportedFileExtensions.GIF_EXTENSION);
}
