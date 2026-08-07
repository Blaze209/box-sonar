package com.box.android.base.cpl;

import com.box.android.common.utilities.CommonBoxUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IItemNameValidator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/cpl/ItemNameValidator;", "Lcom/box/android/base/cpl/IItemNameValidator;", "<init>", "()V", "isItemNameValidForSD", "", "name", "", "getItemIncorrectCharacter", "", "(Ljava/lang/String;)Ljava/lang/Character;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemNameValidator implements IItemNameValidator {
    public static final int $stable = 0;

    @Inject
    public ItemNameValidator() {
    }

    @Override // com.box.android.base.cpl.IItemNameValidator
    public boolean isItemNameValidForSD(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CommonBoxUtil.isFilenameValidForSD(name);
    }

    @Override // com.box.android.base.cpl.IItemNameValidator
    public Character getItemIncorrectCharacter(String name) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(name, "name");
        String str = name;
        int length = str.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            cCharAt = str.charAt(length);
            if (cCharAt == '/' || cCharAt == '\\') {
                break;
            }
            if (i < 0) {
                return null;
            }
            length = i;
        }
        return Character.valueOf(cCharAt);
    }
}
