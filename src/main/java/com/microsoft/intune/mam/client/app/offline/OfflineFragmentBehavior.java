package com.microsoft.intune.mam.client.app.offline;

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
import com.microsoft.intune.mam.client.app.FragmentBehavior;
import com.microsoft.intune.mam.client.app.HookedFragmentBase;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineFragmentBehavior implements FragmentBehavior {
    protected HookedFragmentBase mFragment;

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void initialize(HookedFragmentBase hookedFragmentBase) {
        this.mFragment = hookedFragmentBase;
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onAttach(Activity activity, HookedFragmentBase hookedFragmentBase) {
        this.mFragment.onMAMAttach(activity);
        if (this.mFragment == null) {
            this.mFragment = hookedFragmentBase;
        }
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onAttachContext(Context context, HookedFragmentBase hookedFragmentBase) {
        hookedFragmentBase.onMAMAttach(context);
        if (this.mFragment == null) {
            this.mFragment = hookedFragmentBase;
        }
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onActivityCreated(Bundle bundle) {
        this.mFragment.onMAMActivityCreated(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onCreate(Bundle bundle) {
        this.mFragment.onMAMCreate(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onDestroy() {
        this.mFragment.onMAMDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onDetach() {
        this.mFragment.onMAMDetach();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onPause() {
        this.mFragment.onMAMPause();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onResume() {
        this.mFragment.onMAMResume();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onStart() {
        this.mFragment.onMAMStart();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onStop() {
        this.mFragment.onMAMStop();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMActivityCreated(Bundle bundle) {
        this.mFragment.onActivityCreatedReal(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMAttach(Activity activity) {
        this.mFragment.onAttachReal(activity);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMAttach(Context context) {
        this.mFragment.onAttachReal(context);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMCreate(Bundle bundle) {
        this.mFragment.onCreateReal(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMDestroy() {
        this.mFragment.onDestroyReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMDetach() {
        this.mFragment.onDetachReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMPause() {
        this.mFragment.onPauseReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMResume() {
        this.mFragment.onResumeReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMStart() {
        this.mFragment.onStartReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMStop() {
        this.mFragment.onStopReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragment.onMAMActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return this.mFragment.onMAMCreateAnimator(i, z, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mFragment.onMAMCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mFragment.onMAMCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.mFragment.onMAMCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onDestroyOptionsMenu() {
        this.mFragment.onMAMDestroyOptionsMenu();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onDestroyView() {
        this.mFragment.onMAMDestroyView();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onViewCreated(View view, Bundle bundle) {
        this.mFragment.onMAMViewCreated(view, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onViewStateRestored(Bundle bundle) {
        this.mFragment.onMAMViewStateRestored(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onSaveInstanceState(Bundle bundle) {
        this.mFragment.onMAMSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        this.mFragment.onActivityResultReal(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public Animator onMAMCreateAnimator(int i, boolean z, int i2) {
        return this.mFragment.onCreateAnimatorReal(i, z, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mFragment.onCreateContextMenuReal(contextMenu, view, contextMenuInfo);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mFragment.onCreateOptionsMenuReal(menu, menuInflater);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public View onMAMCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.mFragment.onCreateViewReal(layoutInflater, viewGroup, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMDestroyOptionsMenu() {
        this.mFragment.onDestroyOptionsMenuReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMDestroyView() {
        this.mFragment.onDestroyViewReal();
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMViewCreated(View view, Bundle bundle) {
        this.mFragment.onViewCreatedReal(view, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMViewStateRestored(Bundle bundle) {
        this.mFragment.onViewStateRestoredReal(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.FragmentBehavior
    public void onMAMSaveInstanceState(Bundle bundle) {
        this.mFragment.onSaveInstanceStateReal(bundle);
    }
}
