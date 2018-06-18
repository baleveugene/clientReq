package com.springapp.mvc.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="request", schema = "", catalog = "req_db")
public class Request extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")   
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "request_text")
    private String text;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )   
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )   
    @JoinColumn(name = "status_id", nullable = false)
    private ReqStatus status;
    @Column(name = "bid")   
    private long bid;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    
    public Request() {       
    }
    
    public Request(String text, long bid) {
        this.text = text;
        this.bid = bid;
    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = getFormatedString(url);
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public ReqStatus getStatus() {
        return status;
    }

    public void setStatus(ReqStatus status) {
        this.status = status;
    }
    
    public long getBid() {
        return bid;
    }
    
    public void setBId(long bid) {
        this.bid = bid;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (text != null ? text.hashCode() : 0);                
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.text == null && other.text != null) || 
                (this.text != null && !this.text.equals(other.text))) {
            return false;       
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springapp.mvc.domain.Request[ text=" + text + " ]";
    }
    
    private String getFormatedString(String str){
        if(str.length()>20){
            String substr = str.substring(0, 19);
            str = substr.substring(0, substr.lastIndexOf(" ")).toLowerCase();          
        }            
        String modifiedStr = str.replaceAll(" ", "-")
            .replaceAll("'", "-")
            .replaceAll("\"", "-")
            .replaceAll(",", "-")
            .replaceAll(":", "-")
            .replaceAll(";", "-")
            .replaceAll("\\.", "-")
            .replaceAll("&", "-") 
            .replaceAll("/", "-") 
            .replaceAll("\\|", "-")
            .replaceAll("!", "-")
            .replaceAll("\\?", "-")
            .replaceAll("\\(", "-")
            .replaceAll("\\)", "-")
            .replaceAll("---", "-") 
            .replaceAll("--", "-")
            .replaceAll("--", "-") ; 
        return modifiedStr;
    }
}
