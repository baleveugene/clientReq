package com.springapp.mvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="req_status", schema = "", catalog = "req_db")
public class ReqStatus implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "status_name")
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "status")
    private Set<Request> requests = new HashSet<>();
    
    public ReqStatus() {       
    }
    
    public ReqStatus(String statusName) {
        this.name = statusName;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }
       
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {       
        if (!(object instanceof ReqStatus)) {
            return false;
        }
        ReqStatus other = (ReqStatus) object;
        if ((this.name == null && other.name != null) || 
                (this.name != null && !this.name.equals(other.name))) {
            return false;       
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.model.ReqStatus[ name=" + name + " ]";
    } 
}
