package com.microsoft.intune.mam.client.view;

import android.content.Context;
import android.view.LayoutInflater;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMLayoutInflater extends LayoutInflater implements HookedLayoutInflater {
    final LayoutInflaterBehavior mBehavior;

    protected MAMLayoutInflater(Context context) {
        super(context);
        LayoutInflaterBehavior layoutInflaterBehavior = (LayoutInflaterBehavior) MAMComponents.get(LayoutInflaterBehavior.class);
        this.mBehavior = layoutInflaterBehavior;
        if (layoutInflaterBehavior != null) {
            layoutInflaterBehavior.initialize(this);
        }
    }

    protected MAMLayoutInflater(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
        LayoutInflaterBehavior layoutInflaterBehavior = (LayoutInflaterBehavior) MAMComponents.get(LayoutInflaterBehavior.class);
        this.mBehavior = layoutInflaterBehavior;
        if (layoutInflaterBehavior != null) {
            layoutInflaterBehavior.initialize(this);
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory factory) {
        LayoutInflaterBehavior layoutInflaterBehavior = this.mBehavior;
        if (layoutInflaterBehavior != null) {
            layoutInflaterBehavior.setFactory(factory);
        } else {
            super.setFactory(factory);
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        LayoutInflaterBehavior layoutInflaterBehavior = this.mBehavior;
        if (layoutInflaterBehavior != null) {
            layoutInflaterBehavior.setFactory2(factory2);
        } else {
            super.setFactory2(factory2);
        }
    }

    @Override // com.microsoft.intune.mam.client.view.HookedLayoutInflater
    public void realSetFactory(LayoutInflater.Factory factory) {
        super.setFactory(factory);
    }

    @Override // com.microsoft.intune.mam.client.view.HookedLayoutInflater
    public void realSetFactory(LayoutInflater.Factory2 factory2) {
        super.setFactory2(factory2);
    }
}
