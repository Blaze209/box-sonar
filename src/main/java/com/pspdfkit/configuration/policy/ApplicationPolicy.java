package com.pspdfkit.configuration.policy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ApplicationPolicy {

    public enum PolicyEvent {
        TEXT_COPY_PASTE,
        ANNOTATION_COPY_PASTE_SYSTEM_INTEGRATION
    }

    public abstract boolean hasPermissionForEvent(PolicyEvent policyEvent);
}
