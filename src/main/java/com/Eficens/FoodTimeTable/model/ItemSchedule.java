package com.Eficens.FoodTimeTable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class ItemSchedule {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FoodItem.class) @JsonIgnore
    private FoodItem foodItem;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FoodType.class) @JsonIgnore

    private FoodType foodType;

    @Temporal(TemporalType.DATE)
    private Date scheduledDate;

    public ItemSchedule() {
    }

    public ItemSchedule(long id, FoodItem item, FoodType foodType, Date scheduledDate) {
        this.id = id;
        this.foodItem = item;
        this.foodType = foodType;
        this.scheduledDate = scheduledDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "ItemSchedule{" +
                "id=" + id +
                ", foodItem=" + foodItem +
                ", foodType=" + foodType +
                ", scheduledDate=" + scheduledDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSchedule that = (ItemSchedule) o;
        return id == that.id &&
                Objects.equals(foodItem, that.foodItem) &&
                Objects.equals(foodType, that.foodType) &&
                Objects.equals(scheduledDate, that.scheduledDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodItem, foodType, scheduledDate);
    }
}
