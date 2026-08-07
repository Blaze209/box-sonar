package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxIteratorUsers;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.models.BoxVoid;
import com.eclipsesource.json.JsonObject;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestsUser {

    public static class GetUserInfo extends BoxRequestItem<BoxUser, GetUserInfo> implements BoxCacheableRequest<BoxUser> {
        public GetUserInfo(String str, BoxSession boxSession) {
            super(BoxUser.class, null, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxUser sendForCachedResult() throws BoxException {
            return (BoxUser) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxUser> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class GetEnterpriseUsers extends BoxRequestItem<BoxIteratorUsers, GetEnterpriseUsers> implements BoxCacheableRequest<BoxIteratorUsers> {
        protected static final String QUERY_FILTER_TERM = "filter_term";
        protected static final String QUERY_LIMIT = "limit";
        protected static final String QUERY_OFFSET = "offset";
        private static final long serialVersionUID = 8123965031279971528L;

        public GetEnterpriseUsers(String str, BoxSession boxSession) {
            super(BoxIteratorUsers.class, null, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.GET;
        }

        public String getFilterTerm() {
            return this.mQueryMap.get(QUERY_FILTER_TERM);
        }

        public GetEnterpriseUsers setFilterTerm(String str) {
            this.mQueryMap.put(QUERY_FILTER_TERM, str);
            return this;
        }

        public long getLimit() {
            return Long.valueOf(this.mQueryMap.get("limit")).longValue();
        }

        public GetEnterpriseUsers setLimit(long j) {
            this.mQueryMap.put("limit", Long.toString(j));
            return this;
        }

        public long getOffset() {
            return Long.valueOf(this.mQueryMap.get("offset")).longValue();
        }

        public GetEnterpriseUsers setOffset(long j) {
            this.mQueryMap.put("offset", Long.toString(j));
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorUsers sendForCachedResult() throws BoxException {
            return (BoxIteratorUsers) super.handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorUsers> toTaskForCachedResult() throws BoxException {
            return super.handleToTaskForCachedResult();
        }
    }

    public static class CreateEnterpriseUser extends BoxRequestUserUpdate<BoxUser, CreateEnterpriseUser> {
        private static final long serialVersionUID = 8123965031279971511L;

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ String getName() {
            return super.getName();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ double getSpaceAmount() {
            return super.getSpaceAmount();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ BoxRequest setName(String str) {
            return super.setName(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ BoxRequest setSpaceAmount(double d) {
            return super.setSpaceAmount(d);
        }

        public CreateEnterpriseUser(String str, BoxSession boxSession, String str2, String str3) {
            super(BoxUser.class, null, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            setLogin(str2);
            setName(str3);
        }

        public String getLogin() {
            return (String) this.mBodyMap.get("login");
        }

        public CreateEnterpriseUser setLogin(String str) {
            this.mBodyMap.put("login", str);
            return this;
        }
    }

    public static class UpdateUserInformation extends BoxRequestUserUpdate<BoxUser, UpdateUserInformation> {
        protected static final String FIELD_IS_PASSWORD_RESET_REQUIRED = "is_password_reset_required";
        private static final long serialVersionUID = 8123965031279971510L;

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ String getName() {
            return super.getName();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ double getSpaceAmount() {
            return super.getSpaceAmount();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ BoxRequest setName(String str) {
            return super.setName(str);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequestUserUpdate
        public /* bridge */ /* synthetic */ BoxRequest setSpaceAmount(double d) {
            return super.setSpaceAmount(d);
        }

        public UpdateUserInformation(String str, BoxSession boxSession, String str2, String str3) {
            super(BoxUser.class, null, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.PUT;
        }

        public String getEnterprise() {
            return (String) this.mBodyMap.get("enterprise");
        }

        public UpdateUserInformation setEnterprise(String str) {
            this.mBodyMap.put("enterprise", str);
            return this;
        }

        public String getIsPasswordResetRequired() {
            return (String) this.mBodyMap.get(FIELD_IS_PASSWORD_RESET_REQUIRED);
        }

        public UpdateUserInformation setIsPasswordResetRequired(boolean z) {
            this.mBodyMap.put(FIELD_IS_PASSWORD_RESET_REQUIRED, Boolean.valueOf(z));
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void parseHashMapEntry(JsonObject jsonObject, Map.Entry<String, Object> entry) {
            if (entry.getKey().equals("enterprise")) {
                jsonObject.add(entry.getKey(), entry.getValue() == null ? null : (String) entry.getValue());
            } else {
                super.parseHashMapEntry(jsonObject, entry);
            }
        }
    }

    public static class DeleteEnterpriseUser extends BoxRequest<BoxVoid, DeleteEnterpriseUser> {
        protected static final String QUERY_FORCE = "force";
        protected static final String QUERY_NOTIFY = "notify";
        private static final long serialVersionUID = 8123965031279971503L;
        protected String mId;

        public DeleteEnterpriseUser(String str, BoxSession boxSession, String str2) {
            super(BoxVoid.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.DELETE;
            this.mId = str2;
        }

        public String getId() {
            return this.mId;
        }

        public Boolean getShouldNotify() {
            return Boolean.valueOf(this.mQueryMap.get(QUERY_NOTIFY));
        }

        public DeleteEnterpriseUser setShouldNotify(Boolean bool) {
            this.mQueryMap.put(QUERY_NOTIFY, Boolean.toString(bool.booleanValue()));
            return this;
        }

        public Boolean getShouldForce() {
            return Boolean.valueOf(this.mQueryMap.get(QUERY_FORCE));
        }

        public DeleteEnterpriseUser setShouldForce(Boolean bool) {
            this.mQueryMap.put(QUERY_FORCE, Boolean.toString(bool.booleanValue()));
            return this;
        }
    }
}
