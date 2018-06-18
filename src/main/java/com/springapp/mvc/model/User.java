package com.springapp.mvc.model;

import java.io.Serializable;
import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users", schema = "", catalog = "req_db")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles = new HashSet();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Request> requests = new HashSet<>();

    public User() {       
    }
    
    public User(String username) {
        this.username = username;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
    @JoinTable(name = "user_role", 
            joinColumns = @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }
    
    public void addRole(Role role){
        System.out.println(role.getName());
        getRoles().add(role);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {       
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.username == null && other.username != null) || 
                (this.username != null && !this.username.equals(other.username))) {
            return false;       
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.model.User[ name=" + username + " ]";
    } 
}
