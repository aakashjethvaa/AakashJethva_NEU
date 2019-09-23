/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Feeds.Feeds;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author krunal
 */
public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private int id;
    private static int count = 1;
    private ArrayList<Feeds> feedsList;

    public UserAccount() {
        //workQueue = new WorkQueue();
        this.id = count;
        this.feedsList = new ArrayList<Feeds>();
        count++;
    }

    public ArrayList<Feeds> getFeedsList() {
        return feedsList;
    }

    public void setFeedsList(ArrayList<Feeds> feedsList) {
        this.feedsList = feedsList;
    }

    public Feeds createFeeds(String message) {
        Feeds fd = new Feeds(message);
        feedsList.add(fd);
        return fd;
    }

    public void removeFeed(Feeds fd) {
        feedsList.remove(fd);
    }

    //private WorkQueue workQueue;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    /* public WorkQueue getWorkQueue() {
        return workQueue;
    }*/
    @Override
    public String toString() {
        return username;
    }

}
