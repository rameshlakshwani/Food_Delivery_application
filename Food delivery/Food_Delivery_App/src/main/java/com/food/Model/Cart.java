package com.food.Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items;
    
    private int restaurantId;
    
    public Cart() {
        items = new HashMap<>();
    }
    
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // Add Item
    public void addItem(CartItem item) {

        int menuId = item.getMenuId();

        if (items.containsKey(menuId)) {

            CartItem existing = items.get(menuId);

            existing.setQuantity(existing.getQuantity() + item.getQuantity());

        } else {

            items.put(menuId, item);
        }
    }

    // Update Quantity
    public void updateItem(int menuId, int quantity) {

        if (items.containsKey(menuId)) {

            if (quantity <= 0) {

                items.remove(menuId);

            } else {

                items.get(menuId).setQuantity(quantity);
            }
        }
    }

    // Remove Item
    public void removeItem(int menuId) {

        items.remove(menuId);
    }

    // Clear Cart
    public void clearCart() {

        items.clear();
    }

    // Grand Total
    public double getGrandTotal() {

        double total = 0;

        for (CartItem item : items.values()) {

            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }

    // Total Quantity
    public int getTotalItems() {

        int total = 0;

        for (CartItem item : items.values()) {

            total += item.getQuantity();
        }

        return total;
    }

}