package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loginUser", schema="public")
public class LoginUser implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
    private String password;

    public LoginUser() {
    }

    public LoginUser(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    @Id
    @Column(name = "name")
    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
