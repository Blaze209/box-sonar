package com.microsoft.intune.mam.client.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedFragmentBase {
    void onActivityCreatedReal(Bundle bundle);

    void onActivityResultReal(int i, int i2, Intent intent);

    void onAttachReal(Activity activity);

    void onAttachReal(Context context);

    Animator onCreateAnimatorReal(int i, boolean z, int i2);

    void onCreateContextMenuReal(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void onCreateOptionsMenuReal(Menu menu, MenuInflater menuInflater);

    void onCreateReal(Bundle bundle);

    View onCreateViewReal(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onDestroyOptionsMenuReal();

    void onDestroyReal();

    void onDestroyViewReal();

    void onDetachReal();

    void onMAMActivityCreated(Bundle bundle);

    void onMAMActivityResult(int i, int i2, Intent intent);

    void onMAMAttach(Activity activity);

    void onMAMAttach(Context context);

    void onMAMCreate(Bundle bundle);

    Animator onMAMCreateAnimator(int i, boolean z, int i2);

    void onMAMCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void onMAMCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    View onMAMCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onMAMDestroy();

    void onMAMDestroyOptionsMenu();

    void onMAMDestroyView();

    void onMAMDetach();

    void onMAMPause();

    void onMAMResume();

    void onMAMSaveInstanceState(Bundle bundle);

    void onMAMStart();

    void onMAMStop();

    void onMAMViewCreated(View view, Bundle bundle);

    void onMAMViewStateRestored(Bundle bundle);

    void onPauseReal();

    void onResumeReal();

    void onSaveInstanceStateReal(Bundle bundle);

    void onStartReal();

    void onStopReal();

    void onViewCreatedReal(View view, Bundle bundle);

    void onViewStateRestoredReal(Bundle bundle);
}
