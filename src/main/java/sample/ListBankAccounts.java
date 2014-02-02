package sample;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sample.entity.BankAccount;
public class ListBankAccounts {

  public static void main(String[] args) {
    SessionFactory factory =
      new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();

    List bank_accounts = session.createQuery("from BankAccount").list();
    System.out.println("Found " + bank_accounts.size() + " bank account(s):");

    Iterator i = bank_accounts.iterator();
    while(i.hasNext()) {
      BankAccount bank_account = (BankAccount)i.next();
      System.out.println(bank_account.getName());
    }

    session.close();
  }
}

