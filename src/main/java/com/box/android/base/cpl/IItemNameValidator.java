package com.box.android.base.cpl;

import kotlin.Metadata;

/* JADX INFO: compiled from: IItemNameValidator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/cpl/IItemNameValidator;", "", "isItemNameValidForSD", "", "name", "", "getItemIncorrectCharacter", "", "(Ljava/lang/String;)Ljava/lang/Character;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IItemNameValidator {
    Character getItemIncorrectCharacter(String name);

    boolean isItemNameValidForSD(String name);
}
