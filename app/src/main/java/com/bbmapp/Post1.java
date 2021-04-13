package com.bbmapp;

import android.widget.EditText;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;



@ParseClassName("Posts")
public class Post1 extends ParseObject {

    public static final String KEY_BUSINESS = "Business";
    public static final String KEY_IMAGE = "Image";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_CATEGORY = "Category";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_USER = "User";
    public static final String KEY_CREATED_KEY = "createdAt";


    public String getBusiness() {
        return getString(KEY_BUSINESS);
    }

    public void setBusiness(String business) {
        put(KEY_BUSINESS, business);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public String getLocation(){
        return getString(KEY_LOCATION);
    }
    public void setLocation (String location){
        put(KEY_LOCATION, location);
    }
    public String getCategory(){
        return getString(KEY_CATEGORY);
    }
    public void setCategory (String category){
        put(KEY_CATEGORY, category);
    }

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

}