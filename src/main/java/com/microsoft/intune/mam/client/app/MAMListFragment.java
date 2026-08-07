package com.microsoft.intune.mam.client.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
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
public class MAMListFragment extends ListFragment implements HookedFragment {
    private final FragmentBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.app.HookedFragment
    public final Fragment asFragment() {
        return this;
    }

    public MAMListFragment() {
        FragmentBehavior fragmentBehavior = (FragmentBehavior) MAMComponents.get(FragmentBehavior.class);
        this.mBehavior = fragmentBehavior;
        fragmentBehavior.initialize(this);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        this.mBehavior.onAttach(activity, this);
    }

    @Override // android.app.Fragment
    public final void onAttach(Context context) {
        this.mBehavior.onAttachContext(context, this);
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        this.mBehavior.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        this.mBehavior.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        this.mBehavior.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        this.mBehavior.onDetach();
    }

    @Override // android.app.Fragment
    public final void onPause() {
        this.mBehavior.onPause();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        this.mBehavior.onResume();
    }

    @Override // android.app.Fragment
    public final void onStart() {
        this.mBehavior.onStart();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        this.mBehavior.onStop();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        this.mBehavior.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Fragment
    public final Animator onCreateAnimator(int i, boolean z, int i2) {
        return this.mBehavior.onCreateAnimator(i, z, i2);
    }

    @Override // android.app.Fragment, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mBehavior.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mBehavior.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.mBehavior.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroyOptionsMenu() {
        this.mBehavior.onDestroyOptionsMenu();
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public void onDestroyView() {
        this.mBehavior.onDestroyView();
    }

    @Override // android.app.ListFragment, android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        this.mBehavior.onViewCreated(view, bundle);
    }

    @Override // android.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        this.mBehavior.onViewStateRestored(bundle);
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        this.mBehavior.onSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMActivityCreated(Bundle bundle) {
        this.mBehavior.onMAMActivityCreated(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onActivityCreatedReal(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMAttach(Activity activity) {
        this.mBehavior.onMAMAttach(activity);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onAttachReal(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMCreate(Bundle bundle) {
        this.mBehavior.onMAMCreate(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onCreateReal(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMDestroy() {
        this.mBehavior.onMAMDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onDestroyReal() {
        super.onDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMDetach() {
        this.mBehavior.onMAMDetach();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onDetachReal() {
        super.onDetach();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMPause() {
        this.mBehavior.onMAMPause();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onPauseReal() {
        super.onPause();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMResume() {
        this.mBehavior.onMAMResume();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onResumeReal() {
        super.onResume();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMStart() {
        this.mBehavior.onMAMStart();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onStartReal() {
        super.onStart();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMStop() {
        this.mBehavior.onMAMStop();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onStopReal() {
        super.onStop();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        this.mBehavior.onMAMActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onActivityResultReal(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public Animator onMAMCreateAnimator(int i, boolean z, int i2) {
        return this.mBehavior.onMAMCreateAnimator(i, z, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final Animator onCreateAnimatorReal(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mBehavior.onMAMCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onCreateContextMenuReal(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mBehavior.onMAMCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onCreateOptionsMenuReal(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public View onMAMCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.mBehavior.onMAMCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final View onCreateViewReal(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMDestroyOptionsMenu() {
        this.mBehavior.onMAMDestroyOptionsMenu();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onDestroyOptionsMenuReal() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMDestroyView() {
        this.mBehavior.onMAMDestroyView();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onDestroyViewReal() {
        super.onDestroyView();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMViewCreated(View view, Bundle bundle) {
        this.mBehavior.onMAMViewCreated(view, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onViewCreatedReal(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMViewStateRestored(Bundle bundle) {
        this.mBehavior.onMAMViewStateRestored(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onViewStateRestoredReal(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMSaveInstanceState(Bundle bundle) {
        this.mBehavior.onMAMSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public final void onSaveInstanceStateReal(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMAttach(Context context) {
        this.mBehavior.onMAMAttach(context);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onAttachReal(Context context) {
        super.onAttach(context);
    }
}
