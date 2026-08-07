package com.box.android.tasks.addtask.cpl;

import com.box.android.domain.controller.ICommentControllerBridge;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AssigneePickerEnvironment_Factory implements Factory<AssigneePickerEnvironment> {
    private final Provider<ICommentControllerBridge> commentControllerBridgeProvider;

    private AssigneePickerEnvironment_Factory(Provider<ICommentControllerBridge> provider) {
        this.commentControllerBridgeProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AssigneePickerEnvironment get() {
        return newInstance(this.commentControllerBridgeProvider.get());
    }

    public static AssigneePickerEnvironment_Factory create(Provider<ICommentControllerBridge> provider) {
        return new AssigneePickerEnvironment_Factory(provider);
    }

    public static AssigneePickerEnvironment newInstance(ICommentControllerBridge iCommentControllerBridge) {
        return new AssigneePickerEnvironment(iCommentControllerBridge);
    }
}
