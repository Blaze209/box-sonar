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
public interface FragmentBehavior {
    void initialize(HookedFragmentBase hookedFragmentBase);

    void onActivityCreated(Bundle bundle);

    void onActivityResult(int i, int i2, Intent intent);

    void onAttach(Activity activity, HookedFragmentBase hookedFragmentBase);

    void onAttachContext(Context context, HookedFragmentBase hookedFragmentBase);

    void onCreate(Bundle bundle);

    Animator onCreateAnimator(int i, boolean z, int i2);

    void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onDestroy();

    void onDestroyOptionsMenu();

    void onDestroyView();

    void onDetach();

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

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void onViewCreated(View view, Bundle bundle);

    void onViewStateRestored(Bundle bundle);
}
