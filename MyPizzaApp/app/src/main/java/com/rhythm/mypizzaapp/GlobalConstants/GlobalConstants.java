package com.rhythm.mypizzaapp.GlobalConstants;

/** Global Constants class stores all the constant values
 * which we can use any where in the application **/

public class GlobalConstants {


    public static final String PIZZA_DESCRIPTION = "PIZZA_DETAIL";
    public static final String MENU_BUNDLE_DATA_FOR_CART = "MENU_BUNDLE_DATA_FOR_CART";
    public static final String MENU_BUNDLE_DATA_FOR_PLACE_ORDER= "MENU_BUNDLE_DATA_FOR_PLACE_ORDER";
    public static final String MENU_BUNDLE_DATA_FOR_MY_ORDERS = "MENU_BUNDLE_DATA_FOR_MY_ORDERS";
    public static final String COMPLETE_ORDER_DATA_FOR_CART = "COMPLETE_ORDER_DATA_FOR_CART";
    public static final String COMPLETE_ORDER_DATA_FOR_MY_ORDERS = "COMPLETE_ORDER_DATA_FOR_MY_ORDERS";


    /* Fragments */
    public interface FRAGMENT_INTENT_DATA {

        String FRAGMENT_TAG = "FRAGMENT_TAG";
        String TITLE = "TITLE";
    }
    /* Shared preference keys
     * used in shared preference for storing classes and other shared pref keys */
    public interface SHARED_PREFERENCE {
        String KEY_NAME = "name", KEY_EMAIL = "email", KEY_ADDRESS = "address", KEY_PHONENUMBER = "phoneNumber",
                KEY_PASSWORD = "password", KEY_GENDER = "sex";
        String IS_LOGGED_IN = "isLoggedIn";

        public String SHARED_PREFERENCE_KEY = "MyPizzaApp";
        String KEY_LIST = "SIGNUP_DATA";

        public static final String SHARED_PREF_PAYMENT_KEY = "SHARED_PREF_PAYMENT_KEY";
        String token = "token";  // for storing token
        String CARD_HOLDER_NAME = "CARD_HOLDER_NAME";
        String GET_CARD_HOLDER_NAME = "GET_CARD_HOLDER_NAME";
        String CARD_NUMBER = "CARD_NUMBER";
        String CARD_LIST = "CARD_LIST";
        String GET_CARD_NUMBER = "GET_CARD_NUMBER";
    }

    /* Fragments TAG*/
    public interface FRAGMENT {

        String MENU = "My Pizza's Menu";
        String SETTINGS = "Settings";
        String MY_PROFILE = "My Profile";
        String LOGIN = "Login";
        String SIGN_UP = "Sign up";
        String FORGOT_PASSWORD = "Forgot Password";
        String ABOUT_US = "About us";
        String ORDER_HISTORY = "Order History";
        String MY_ORDERS = "My Orders";
        String FEEDBACK_FRAGMENT = "Feedback";
        String PLACE_ORDER_FRAGMENT = "Place Order";
        String MY_CART_FRAGMENT = "My Cart";
        String PAYMENT = "Payment";
        String ADD_CARD_FRAGMENT = "Add Card";
        String MAKE_PAYMENT = "MAKE PAYMENT";
        String CONFIRM_ORDER_FRAGMENT = "Confirm Order";
    }
}
