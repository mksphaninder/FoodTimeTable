package com.Eficens.FoodTimeTable.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class FoodType {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String foodType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodType")
    private List<ItemSchedule> itemSchedules;

    public FoodType() {}

    public FoodType(long id, String foodType) {
        this.id = id;
        this.foodType = foodType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", foodType='" + foodType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodType foodType1 = (FoodType) o;
        return id == foodType1.id &&
                Objects.equals(foodType, foodType1.foodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodType);
    }
}
