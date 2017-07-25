package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class TrainingData extends BaseBO {
    private int TrainingId;
    private int EntityTypeId;
    private int TrainingDateId;
    private String TrainingDataValue;
    private Date CreateDate;

    public TrainingData(){}
    public TrainingData(int trainingId, String trainingDataValue){
        this.setTrainingId(trainingId);
        this.setTrainingDataValue(trainingDataValue);
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getTrainingDateId() {
        return TrainingDateId;
    }

    public void setTrainingDateId(int trainingDateId) {
        TrainingDateId = trainingDateId;
    }

    public String getTrainingDataValue() {
        return TrainingDataValue;
    }

    public void setTrainingDataValue(String trainingDataValue) {
        TrainingDataValue = trainingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
