package com.food.Model;

import java.sql.Timestamp;

public class Menu {

    private int menuId;
    private int restaurantId;
    private String itemName;
    private String description;
    private double price;
    private boolean isAvailable;
    private String category;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private String imagePath;
    private double rating;
    private int deliveryTime;

    public Menu() {
    }

    public Menu(int restaurantId, String itemName, String description,
            double price, boolean isAvailable, String category) {

        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
    }

    public Menu(int menuId,
            int restaurantId,
            String itemName,
            String description,
            double price,
            boolean isAvailable,
            String category,
            String imagePath,
            double rating,
            int deliveryTime,
            Timestamp createdAt,
            Timestamp updatedAt,
            Timestamp deletedAt) {

    this.menuId = menuId;
    this.restaurantId = restaurantId;
    this.itemName = itemName;
    this.description = description;
    this.price = price;
    this.isAvailable = isAvailable;
    this.category = category;
    this.imagePath = imagePath;
    this.rating = rating;
    this.deliveryTime = deliveryTime;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
}

    // Getters and Setters

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    @Override
    public String toString() {
        return "Menu [menuId=" + menuId
                + ", restaurantId=" + restaurantId
                + ", itemName=" + itemName
                + ", description=" + description
                + ", price=" + price
                + ", isAvailable=" + isAvailable
                + ", category=" + category
                + ", imagePath=" + imagePath
                + ", rating=" + rating
                + ", deliveryTime=" + deliveryTime
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", deletedAt=" + deletedAt
                + "]";
    }
}