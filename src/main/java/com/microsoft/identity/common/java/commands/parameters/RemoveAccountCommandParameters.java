package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class RemoveAccountCommandParameters extends CommandParameters {
    private IAccountRecord account;
    private List<BrowserDescriptor> browserSafeList;

    public static abstract class RemoveAccountCommandParametersBuilder<C extends RemoveAccountCommandParameters, B extends RemoveAccountCommandParametersBuilder<C, B>> extends CommandParameters.CommandParametersBuilder<C, B> {
        private IAccountRecord account;
        private List<BrowserDescriptor> browserSafeList;

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(RemoveAccountCommandParameters removeAccountCommandParameters, RemoveAccountCommandParametersBuilder<?, ?> removeAccountCommandParametersBuilder) {
            removeAccountCommandParametersBuilder.account(removeAccountCommandParameters.account);
            removeAccountCommandParametersBuilder.browserSafeList(removeAccountCommandParameters.browserSafeList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((RemoveAccountCommandParameters) c, (RemoveAccountCommandParametersBuilder<?, ?>) this);
            return (B) self();
        }

        public B account(IAccountRecord iAccountRecord) {
            this.account = iAccountRecord;
            return (B) self();
        }

        public B browserSafeList(List<BrowserDescriptor> list) {
            this.browserSafeList = list;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public String toString() {
            return "RemoveAccountCommandParameters.RemoveAccountCommandParametersBuilder(super=" + super.toString() + ", account=" + this.account + ", browserSafeList=" + this.browserSafeList + ")";
        }
    }

    private static final class RemoveAccountCommandParametersBuilderImpl extends RemoveAccountCommandParametersBuilder<RemoveAccountCommandParameters, RemoveAccountCommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters.RemoveAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public RemoveAccountCommandParametersBuilderImpl self() {
            return this;
        }

        private RemoveAccountCommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters.RemoveAccountCommandParametersBuilder, com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public RemoveAccountCommandParameters build() {
            return new RemoveAccountCommandParameters(this);
        }
    }

    protected RemoveAccountCommandParameters(RemoveAccountCommandParametersBuilder<?, ?> removeAccountCommandParametersBuilder) {
        super(removeAccountCommandParametersBuilder);
        this.account = ((RemoveAccountCommandParametersBuilder) removeAccountCommandParametersBuilder).account;
        this.browserSafeList = ((RemoveAccountCommandParametersBuilder) removeAccountCommandParametersBuilder).browserSafeList;
    }

    public static RemoveAccountCommandParametersBuilder<?, ?> builder() {
        return new RemoveAccountCommandParametersBuilderImpl();
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public RemoveAccountCommandParametersBuilder<?, ?> toBuilder() {
        return new RemoveAccountCommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    protected boolean canEqual(Object obj) {
        return obj instanceof RemoveAccountCommandParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoveAccountCommandParameters)) {
            return false;
        }
        RemoveAccountCommandParameters removeAccountCommandParameters = (RemoveAccountCommandParameters) obj;
        if (!removeAccountCommandParameters.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        IAccountRecord account = getAccount();
        IAccountRecord account2 = removeAccountCommandParameters.getAccount();
        if (account != null ? !account.equals(account2) : account2 != null) {
            return false;
        }
        List<BrowserDescriptor> browserSafeList = getBrowserSafeList();
        List<BrowserDescriptor> browserSafeList2 = removeAccountCommandParameters.getBrowserSafeList();
        return browserSafeList != null ? browserSafeList.equals(browserSafeList2) : browserSafeList2 == null;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters
    public int hashCode() {
        int iHashCode = super.hashCode();
        IAccountRecord account = getAccount();
        int i = iHashCode * 59;
        int iHashCode2 = account == null ? 43 : account.hashCode();
        List<BrowserDescriptor> browserSafeList = getBrowserSafeList();
        return ((i + iHashCode2) * 59) + (browserSafeList != null ? browserSafeList.hashCode() : 43);
    }

    public IAccountRecord getAccount() {
        return this.account;
    }

    public List<BrowserDescriptor> getBrowserSafeList() {
        if (this.browserSafeList == null) {
            return null;
        }
        return new ArrayList(this.browserSafeList);
    }
}
