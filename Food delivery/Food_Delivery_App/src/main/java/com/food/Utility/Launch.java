//User
//package com.tap.Utility;
//
//import java.util.List;
//
//import com.tap.DAOimpl.UserDAOimpl;
//import com.tap.Model.User;
//
//public class Launch {
//
//	public static void main(String[] args) {
/*		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the UserName:");
		String username=sc.next();
		System.out.println("Enter the Password:");
		String password=sc.next();
		System.out.println("Enter the Email:");
		String email=sc.next();
		System.out.println("Enter the address:");
		String address=sc.next();
		System.out.println("Enter the role:");
		String role=sc.next();
		User u=new User(username,password,email,address,role);
*/
//		UserDAOimpl userDAO=new UserDAOimpl();
		//udao.addUser(u);
//		User u=userDAO.getUser(2);
		
//		System.out.println(u);
		
/*		User u=userDAO.getUser(1);
		u.setAddress("Mico Layout");
		userDAO.updateUser(u);
		System.out.println("User Updated");
*/
		
		
/*		userDAO.deleteUser(1);
		System.out.println("User deleted");
*/
	
//		List<User> allUser=userDAO.getAllUsers();
//		for(User user:allUser) {
//			System.out.println(user);
//		}
//	}
//
//}

//Restaurant

//package com.tap.Utility;
//
//import com.tap.DAOimpl.RestaurantDAOimpl;
//import com.tap.Model.Restaurant;
//
//public class Launch {
//
//    public static void main(String[] args) {
//
//        RestaurantDAOimpl restaurantDAO = new RestaurantDAOimpl();
//
//        // ADD RESTAURANT
//        Restaurant r = new Restaurant(
//                "Paradise Biryani",
//                "Indian",
//                30,
//                "Hyderabad",
//                1,
//                4.5,
//                true);
//
//        restaurantDAO.addRestaurant(r);
//     System.out.println("Restaurant Added");

        // GET SINGLE RESTAURANT
//      Restaurant restaurant = restaurantDAO.getRestaurant(1);
//      System.out.println(restaurant);

        // UPDATE RESTAURANT
//      Restaurant restaurant = restaurantDAO.getRestaurant(1);
//      restaurant.setRating(4.8);
//      restaurant.setDeliveryTime(25);
//      restaurantDAO.updateRestaurant(restaurant);
//      System.out.println("Restaurant Updated");

        // DELETE RESTAURANT
//      restaurantDAO.deleteRestaurant(1);
//      System.out.println("Restaurant Deleted");

        // GET ALL RESTAURANTS
//      List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurants();
//
//      for (Restaurant restaurant : allRestaurants) {
//          System.out.println(restaurant);
//      }
//    }
//}

//Menu

//package com.tap.Utility;
//
//import java.util.List;
//
//import com.tap.DAOimpl.MenuDAOimpl;
//import com.tap.Model.Menu;
//
//public class Launch {
//
//    public static void main(String[] args) {
//
//        MenuDAOimpl menuDAO = new MenuDAOimpl();

        // ================= ADD MENU =================

//        Menu menu = new Menu(
//                1, // RestaurantID
//                "Chicken Biryani",
//                "Hyderabadi Dum Biryani",
//                249.00,
//                true,
//                "Main Course");
//
//        menuDAO.addMenu(menu);
//        System.out.println("Menu Added Successfully");

        // ================= GET MENU =================

//      Menu m = menuDAO.getMenu(1);
//      System.out.println(m);

        // ================= UPDATE MENU =================

//      Menu m = menuDAO.getMenu(1);
//
//      m.setPrice(299.00);
//      m.setDescription("Special Chicken Dum Biryani");
//
//      menuDAO.updateMenu(m);
//
//      System.out.println("Menu Updated Successfully");

        // ================= DELETE MENU =================

//      menuDAO.deleteMenu(1);
//      System.out.println("Menu Deleted Successfully");

        // ================= GET ALL MENUS =================

//      List<Menu> menus = menuDAO.getAllMenus();
//
//      for(Menu m : menus) {
//          System.out.println(m);
//      }
//
//    }
//}




// OrderItem
//
//package com.tap.Utility;
//
//import java.util.List;
//
//import com.tap.DAOimpl.OrderItemDAOimpl;
//import com.tap.Model.OrderItem;
//
//public class Launch {
//
//    public static void main(String[] args) {
//
//        OrderItemDAOimpl dao =
//                new OrderItemDAOimpl();
//
//        // ADD
//
//        OrderItem item =
//                new OrderItem(
//                        2,      // OrderID
//                        2,      // MenuID
//                        3,      // Quantity
//                        498.00  // ItemTotal
//                );
//
//        dao.addOrderItem(item);
//
//        System.out.println("Order Item Added");

        // GET ONE

//      OrderItem item = dao.getOrderItem(1);
//      System.out.println(item);

        // UPDATE

//      OrderItem item = dao.getOrderItem(1);
//      item.setQuantity(3);
//      item.setItemTotal(747.00);
//      dao.updateOrderItem(item);

        // DELETE

//      dao.deleteOrderItem(1);

        // GET ALL

//      List<OrderItem> list =
//              dao.getAllOrderItems();
//
//      for(OrderItem item : list) {
//          System.out.println(item);
//      }
//    }
//}

package com.food.Utility;

import java.sql.Timestamp;

import com.food.DAOimpl.OrderTableDAOimpl;
import com.food.Model.OrderTable;

public class Launch {

    public static void main(String[] args) {

        OrderTableDAOimpl dao =
                new OrderTableDAOimpl();

        // ADD

        OrderTable order = new OrderTable(
                1,          // OrderID
                1,          // UserID
                1,          // RestaurantID
                new Timestamp(System.currentTimeMillis()),
                499.00,
                "paid",
                "online");

        dao.addOrder(order);

        // GET

//      System.out.println(dao.getOrder(1));

        // UPDATE

//      OrderTable order = dao.getOrder(1);
//      order.setStatus("pending");
//      dao.updateOrder(order);

        // DELETE

//      dao.deleteOrder(1);

        // GET ALL

//      List<OrderTable> list = dao.getAllOrders();
//      for(OrderTable o : list) {
//          System.out.println(o);
//      }
    }
}
