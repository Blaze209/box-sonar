package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.exceptions.RedoEditFailedException;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public interface y60<E extends Edit> {
    Object a(Edit edit, ContinuationImpl continuationImpl) throws RedoEditFailedException;

    boolean a(E e);

    default <T extends E> boolean a(Class<T> cls) {
        return false;
    }

    Object b(Edit edit, ContinuationImpl continuationImpl) throws UndoEditFailedException;

    boolean b(E e);
}
