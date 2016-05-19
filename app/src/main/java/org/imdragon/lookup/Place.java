package org.imdragon.lookup;


import java.util.ArrayList;

public class Place {
    String title;
    String tags;
    String photos;

    // TODO: 5/18/2016 Later look into allowing multiple tags and photos in constructor
//    Place(String title, ArrayList<String> tags, ArrayList<String> photos) {
    Place(String title, String tags, String photos) {
        this.title = title;
        this.tags = tags;
        this.photos = photos;
    }




}
