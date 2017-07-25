package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class LoyaltyCompany extends BaseBO {
    private int LoyaltyCompanyId;
    private String CompanyName;
    private int EntityTypeId;

    public LoyaltyCompany(){}
    public LoyaltyCompany(int loyaltyCompanyId, String companyName){
        this.setLoyaltyCompanyId(loyaltyCompanyId);
        this.setCompanyName(companyName);
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }
}
