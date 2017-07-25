package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class ReviewData extends BaseBO {
    private int EntityTypeId;
    private int ReviewId;
    private int ReviewDataId;
    private String ReviewDataValue;
    private Date CreateDate;

    public ReviewData(){}
    public ReviewData(int reviewId, String reviewDataValue){
        this.setReviewId(reviewId);
        this.setReviewDataValue(reviewDataValue);

    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public int getReviewDataId() {
        return ReviewDataId;
    }

    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public String getReviewDataValue() {
        return ReviewDataValue;
    }

    public void setReviewDataValue(String reviewDataValue) {
        ReviewDataValue = reviewDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
