package com.box.android.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.repo.ShareRepo;
import com.box.androidsdk.content.models.BoxCollaborationItem;

/* JADX INFO: loaded from: classes13.dex */
public class ShareVMFactory implements ViewModelProvider.Factory {
    private final BoxCollaborationItem mShareItem;
    private final ShareRepo mShareRepo;

    public ShareVMFactory(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo = shareRepo;
        this.mShareItem = boxCollaborationItem;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        if (cls.isAssignableFrom(InviteCollaboratorsShareVM.class)) {
            return new InviteCollaboratorsShareVM(this.mShareRepo, this.mShareItem);
        }
        if (cls.isAssignableFrom(SharedLinkVM.class)) {
            return new SharedLinkVM(this.mShareRepo, this.mShareItem);
        }
        if (cls.isAssignableFrom(CollaborationsShareVM.class)) {
            return new CollaborationsShareVM(this.mShareRepo, this.mShareItem);
        }
        if (cls.isAssignableFrom(CollaboratorsInitialsVM.class)) {
            return new CollaboratorsInitialsVM(this.mShareRepo, this.mShareItem);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
