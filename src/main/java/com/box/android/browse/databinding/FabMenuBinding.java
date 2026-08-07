package com.box.android.browse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.browse.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

/* JADX INFO: loaded from: classes10.dex */
public final class FabMenuBinding implements ViewBinding {
    public final FloatingActionButton fabLibrary;
    public final FloatingActionMenu fabMenu;
    public final FloatingActionButton fabNewDocument;
    public final FloatingActionButton fabNewFolder;
    public final FloatingActionButton fabNewMedia;
    public final FloatingActionButton fabNewNote;
    private final FloatingActionMenu rootView;

    private FabMenuBinding(FloatingActionMenu floatingActionMenu, FloatingActionButton floatingActionButton, FloatingActionMenu floatingActionMenu2, FloatingActionButton floatingActionButton2, FloatingActionButton floatingActionButton3, FloatingActionButton floatingActionButton4, FloatingActionButton floatingActionButton5) {
        this.rootView = floatingActionMenu;
        this.fabLibrary = floatingActionButton;
        this.fabMenu = floatingActionMenu2;
        this.fabNewDocument = floatingActionButton2;
        this.fabNewFolder = floatingActionButton3;
        this.fabNewMedia = floatingActionButton4;
        this.fabNewNote = floatingActionButton5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FloatingActionMenu getRoot() {
        return this.rootView;
    }

    public static FabMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FabMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fab_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FabMenuBinding bind(View view) {
        int i = R.id.fab_library;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
        if (floatingActionButton != null) {
            FloatingActionMenu floatingActionMenu = (FloatingActionMenu) view;
            i = R.id.fab_new_document;
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
            if (floatingActionButton2 != null) {
                i = R.id.fab_new_folder;
                FloatingActionButton floatingActionButton3 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                if (floatingActionButton3 != null) {
                    i = R.id.fab_new_media;
                    FloatingActionButton floatingActionButton4 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                    if (floatingActionButton4 != null) {
                        i = R.id.fab_new_note;
                        FloatingActionButton floatingActionButton5 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                        if (floatingActionButton5 != null) {
                            return new FabMenuBinding(floatingActionMenu, floatingActionButton, floatingActionMenu, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
