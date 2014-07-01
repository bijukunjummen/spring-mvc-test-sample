package mvcsample.bean;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class User {

    private int userId;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
    private String address;

    public User(){

    }


    public User(int userId, String username, String firstname,
            String lastname, String password, String role, String address) {
        super();
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.address = address;
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "username", nullable = false)
    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }

    @Column(name = "firstname", nullable = false)
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false)
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length()>=6){
            this.password = password;
        }
        else{
            throw new IllegalArgumentException("Password length must be more than 6 characters");
        }
    }

    @Column(name = "user_role", nullable = false)
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}