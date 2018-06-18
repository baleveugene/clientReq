package com.springapp.mvc.model;

import java.io.Serializable;
import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "", catalog = "req_db")
public class Role implements Serializable {
    private Long id;
    private String name;
    private Set<User> users = new HashSet();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {       
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.name == null && other.name != null) || 
                (this.name != null && !this.name.equals(other.name))) {
            return false;       
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.model.Role[ name=" + name + " ]";
    } 
}
