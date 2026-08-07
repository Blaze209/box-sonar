package com.microsoft.identity.common.java.authscheme;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractAuthenticationScheme implements INameable {
    private static final long serialVersionUID = -2437270903389813253L;

    @SerializedName("name")
    private final String mName;

    public static class SerializedNames {
        public static final String NAME = "name";
    }

    public static abstract class AbstractAuthenticationSchemeBuilder<C extends AbstractAuthenticationScheme, B extends AbstractAuthenticationSchemeBuilder<C, B>> {
        private String name;

        public abstract C build();

        protected abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(AbstractAuthenticationScheme abstractAuthenticationScheme, AbstractAuthenticationSchemeBuilder<?, ?> abstractAuthenticationSchemeBuilder) {
            abstractAuthenticationSchemeBuilder.name(abstractAuthenticationScheme.mName);
        }

        protected B $fillValuesFrom(C c) {
            $fillValuesFromInstanceIntoBuilder(c, this);
            return (B) self();
        }

        public B name(String str) {
            this.name = str;
            return (B) self();
        }

        public String toString() {
            return "AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder(name=" + this.name + ")";
        }
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof AbstractAuthenticationScheme;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractAuthenticationScheme)) {
            return false;
        }
        AbstractAuthenticationScheme abstractAuthenticationScheme = (AbstractAuthenticationScheme) obj;
        if (!abstractAuthenticationScheme.canEqual(this)) {
            return false;
        }
        String name = getName();
        String name2 = abstractAuthenticationScheme.getName();
        return name != null ? name.equals(name2) : name2 == null;
    }

    public int hashCode() {
        String name = getName();
        return 59 + (name == null ? 43 : name.hashCode());
    }

    protected AbstractAuthenticationScheme(AbstractAuthenticationSchemeBuilder<?, ?> abstractAuthenticationSchemeBuilder) {
        this.mName = ((AbstractAuthenticationSchemeBuilder) abstractAuthenticationSchemeBuilder).name;
    }

    @Override // com.microsoft.identity.common.java.authscheme.INameable
    public String getName() {
        return this.mName;
    }

    public AbstractAuthenticationScheme(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mName = str;
    }

    public String toString() {
        return "AbstractAuthenticationScheme{mName='" + this.mName + "'}";
    }
}
