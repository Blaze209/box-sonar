package com.box.android.base.presentation.utilities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SupportedFileExtensionIcons.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/utilities/SupportedFileExtensionIcons;", "", "<init>", "()V", "extensionCache", "", "", "Lcom/box/android/base/presentation/utilities/FileTypeIcon;", "initializeCache", "", "findFolderIcon", "Lcom/box/android/base/presentation/utilities/FolderTypeIcon;", "isCollaborated", "", "isExternal", "findFileIcon", "fileExtension", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SupportedFileExtensionIcons {
    public static final int $stable;
    public static final SupportedFileExtensionIcons INSTANCE;
    private static final Map<String, FileTypeIcon> extensionCache;

    private SupportedFileExtensionIcons() {
    }

    static {
        SupportedFileExtensionIcons supportedFileExtensionIcons = new SupportedFileExtensionIcons();
        INSTANCE = supportedFileExtensionIcons;
        extensionCache = new LinkedHashMap();
        supportedFileExtensionIcons.initializeCache();
        $stable = 8;
    }

    private final void initializeCache() {
        for (FileTypeIcon fileTypeIcon : FileTypeIcon.getEntries()) {
            List extensions = fileTypeIcon.getExtensions();
            if (extensions == null) {
                extensions = CollectionsKt.emptyList();
            }
            for (String str : extensions) {
                Map<String, FileTypeIcon> map = extensionCache;
                map.containsKey(str);
                map.put(str, fileTypeIcon);
            }
        }
    }

    public final FolderTypeIcon findFolderIcon(boolean isCollaborated, boolean isExternal) {
        if (isCollaborated) {
            return isExternal ? FolderTypeIcon.EXTERNAL : FolderTypeIcon.COLLABORATED;
        }
        return FolderTypeIcon.PERSONAL;
    }

    public final FileTypeIcon findFileIcon(String fileExtension) {
        String str = fileExtension;
        if (str == null || str.length() == 0) {
            return FileTypeIcon.DEFAULT;
        }
        Map<String, FileTypeIcon> map = extensionCache;
        String lowerCase = fileExtension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        FileTypeIcon fileTypeIcon = map.get(lowerCase);
        return fileTypeIcon == null ? FileTypeIcon.DEFAULT : fileTypeIcon;
    }
}
