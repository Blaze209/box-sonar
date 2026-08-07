package com.microsoft.intune.mam.client.view;

import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewBehavior {
    InputConnection onCreateInputConnection(EditorInfo editorInfo);

    InputConnection onMAMCreateInputConnection(EditorInfo editorInfo);

    ActionMode startActionMode(ActionMode.Callback callback, int i);

    ActionMode startActionModeMAM(ActionMode.Callback callback, int i);
}
