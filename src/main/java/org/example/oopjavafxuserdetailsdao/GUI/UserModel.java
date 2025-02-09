package org.example.oopjavafxuserdetailsdao.GUI;     // Feb 2025

import org.example.oopjavafxuserdetailsdao.DTOs.User;

/**
 * The UserModel class stores the underlying data.
 * In this case the Model has a reference to a User object.
 * The User object is known as a "Domain Object".
 * A number of Property fields are maintained - which are OBSERVABLE objects
 * that are bound to UI Controls in the view, so that when the  property fields are
 * updated, then the corresponding UI Controls will automatically
 * update.
 * The Controller updates the Property fields in order to
 * chang ethe UI display.
 * When this class is instantiated, it is passed into the Controller
 * so that the Controller can access the user data.
 */
public class UserModel {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    ///  In a Reactive set-up, the above fields would be Properties
    ///  (i.e. State variables that are Observables).  We are not
    ///  doing this here in order to keep things simple.

    /**
     * Constructor accepts a reference to a User (Domain Object) and
     * extracts the field data into the fields in this UserModel.
     * The UserModel object is a separate object from the User object.
     * (Aside: this may seem strange, but it is somewhat structurally in line
     * with the concept of a View Model, where there a Model of the data
     * that is directly associate with the View.)
     */
    public UserModel(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
