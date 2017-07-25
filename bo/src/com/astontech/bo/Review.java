package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Review extends BaseBO{
    private int ReviewId;
    private String ReviewName;
    private Date ReviewDate;
    private int EmployeeId;
    private ReviewData Data;

    public Review(){
        this.setData(new ReviewData());
    }
    public Review(int reviewId, String reviewName, int employeeId){
        this.setReviewId(reviewId);
        this.setReviewName(reviewName);
        this.setEmployeeId(employeeId);
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public String getReviewName() {
        return ReviewName;
    }

    public void setReviewName(String reviewName) {
        ReviewName = reviewName;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public ReviewData getData() {
        return Data;
    }

    public void setData(ReviewData data) {
        Data = data;
    }
}
