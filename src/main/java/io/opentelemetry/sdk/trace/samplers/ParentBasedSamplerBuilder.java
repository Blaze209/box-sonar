package io.opentelemetry.sdk.trace.samplers;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ParentBasedSamplerBuilder {

    @Nullable
    private Sampler localParentNotSampled;

    @Nullable
    private Sampler localParentSampled;

    @Nullable
    private Sampler remoteParentNotSampled;

    @Nullable
    private Sampler remoteParentSampled;
    private final Sampler root;

    ParentBasedSamplerBuilder(Sampler sampler) {
        this.root = sampler;
    }

    public ParentBasedSamplerBuilder setRemoteParentSampled(Sampler sampler) {
        this.remoteParentSampled = sampler;
        return this;
    }

    public ParentBasedSamplerBuilder setRemoteParentNotSampled(Sampler sampler) {
        this.remoteParentNotSampled = sampler;
        return this;
    }

    public ParentBasedSamplerBuilder setLocalParentSampled(Sampler sampler) {
        this.localParentSampled = sampler;
        return this;
    }

    public ParentBasedSamplerBuilder setLocalParentNotSampled(Sampler sampler) {
        this.localParentNotSampled = sampler;
        return this;
    }

    public Sampler build() {
        return new ParentBasedSampler(this.root, this.remoteParentSampled, this.remoteParentNotSampled, this.localParentSampled, this.localParentNotSampled);
    }
}
