package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class EntityType extends BaseBO{

    //region PROPERTIES
    private int EntityTypeId;
    private String EntityTypeName;
    private int EntityId;
    //endregion



    //region CONSTRUCTORS
    public EntityType(){}
    public EntityType(String entityTypeName){
        this.setEntityTypeName(entityTypeName);
    }
    //endregion

    //region GETTERS/SETTERS

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }
    //endregion

    public String test_method() {
        return "sub method";
    }
}
