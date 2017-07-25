package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class LoyaltyAccount extends BaseBO {
    private int LoyaltyCompanyId;
    private int EmployeeId;
    private int LoyaltyAccountId;
    private int MemberNumber;
    private LoyaltyCompany Company;

    public LoyaltyAccount(){
        this.setCompany(new LoyaltyCompany());
    }
    public LoyaltyAccount(int loyaltyCompanyId, int employeeId, int loyaltyAccountId, int memberNumber){
        this.setLoyaltyCompanyId(loyaltyCompanyId);
        this.setEmployeeId(employeeId);
        this.setLoyaltyAccountId(loyaltyAccountId);
        this.setMemberNumber(memberNumber);
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }

    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public int getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        MemberNumber = memberNumber;
    }

    public LoyaltyCompany getCompany() {
        return Company;
    }

    public void setCompany(LoyaltyCompany company) {
        Company = company;
    }
}
