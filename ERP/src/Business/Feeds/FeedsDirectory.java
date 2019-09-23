/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Feeds;

import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class FeedsDirectory {

    private ArrayList<Feeds> feedsList;

    public FeedsDirectory() {
        feedsList = new ArrayList<>();
    }

    public ArrayList<Feeds> getFeedsList() {
        return feedsList;
    }

}
