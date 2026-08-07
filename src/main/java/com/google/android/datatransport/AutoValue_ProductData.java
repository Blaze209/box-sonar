package com.google.android.datatransport;

/* JADX INFO: loaded from: classes13.dex */
final class AutoValue_ProductData extends ProductData {
    private final Integer productId;

    AutoValue_ProductData(Integer num) {
        this.productId = num;
    }

    @Override // com.google.android.datatransport.ProductData
    public Integer getProductId() {
        return this.productId;
    }

    public String toString() {
        return "ProductData{productId=" + this.productId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductData)) {
            return false;
        }
        ProductData productData = (ProductData) obj;
        Integer num = this.productId;
        if (num == null) {
            return productData.getProductId() == null;
        }
        return num.equals(productData.getProductId());
    }

    public int hashCode() {
        Integer num = this.productId;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }
}
