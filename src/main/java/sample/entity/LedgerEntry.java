package sample.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;

@Entity
@Table(name = "ledger_entries")
@Filters({@Filter(name="userFilter", condition=":userId = user_id"),
          @Filter(name="ledgerFilter", condition=":ledgerId = ledger_account_id"),
          @Filter(name="dateRangeFilter", condition="(date >= :fromDate ) AND (date <= :toDate)")})
public class LedgerEntry {
  private long id;
  private User user;
  private LedgerAccount ledgerAccount;
  private java.util.Date date;

  public LedgerEntry(String name, User user) {
    this.user = user;
  }

  LedgerEntry() {
  }


  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="user_id")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="ledger_account_id")
  public LedgerAccount getLedgerAccount() {
    return ledgerAccount;
  }

  public void setLedgerAccount(LedgerAccount ledgerAccount) {
    this.ledgerAccount = ledgerAccount;
  }

  @Temporal(javax.persistence.TemporalType.DATE)
  public java.util.Date getDate() {
    return date;
  }

  public void setDate(java.util.Date date) {
    this.date = date;
  }

  @Id
  @GeneratedValue
  public long getId() {
    return id;
  }

  protected void setId(long id) {
    this.id = id;
  }
}
