package com.Eficens.FoodTimeTable.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class FoodItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String foodItem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodItem")
    List<ItemSchedule> itemSchedule;

    public FoodItem() {}

    public FoodItem(long id, String foodItem) {
        this.id = id;
        this.foodItem = foodItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem1 = (FoodItem) o;
        return id == foodItem1.id &&
                Objects.equals(foodItem, foodItem1.foodItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodItem);
    }
}
