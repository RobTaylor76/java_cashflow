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
import org.hibernate.annotations.Filter;

@Entity
@Table(name = "ledger_accounts")
@Filter(name="userFilter", condition=":userParam = user_id")
public class LedgerAccount {
  private long id;
  private String name;
  private User user;

  public LedgerAccount(String name, User user) {
    this.name = name;
    this.user = user;
  }

  LedgerAccount() {
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
