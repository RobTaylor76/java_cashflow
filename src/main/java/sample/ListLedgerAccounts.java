package sample;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Filter;
import org.hibernate.engine.FilterDefinition;

import sample.entity.LedgerAccount;
import sample.entity.User;

public class ListLedgerAccounts {

  public static void main(String[] args) {
    SessionFactory factory =
      new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();

    List users = session.createQuery("from User").list();

    Iterator i = users.iterator();
    while(i.hasNext()) {
      User user = (User)i.next();
      System.out.println(user.getEmail());
      // Filter by user
      Filter filter = session.enableFilter("userFilter");
      
      filter.setParameter("userParam", user.getId());
      
      List bank_accounts = session.createQuery("from LedgerAccount").list();
      System.out.println("Found " + bank_accounts.size() + " bank account(s):");

      Iterator il = bank_accounts.iterator();
      while(il.hasNext()) {
        LedgerAccount bank_account = (LedgerAccount)il.next();
        System.out.println(bank_account.getName());
      }
    }

    session.close();
  }
}

