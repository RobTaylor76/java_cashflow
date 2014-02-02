package sample.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
  private long id;
  private String name;
  private User user;

  public BankAccount(String name, User user) {
    this.name = name;
    this.user = user;
  }

  BankAccount() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne
  @JoinColumn(name="user_id")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Id
  @GeneratedValue
  protected long getId() {
    return id;
  }

  protected void setId(long id) {
    this.id = id;
  }
}
