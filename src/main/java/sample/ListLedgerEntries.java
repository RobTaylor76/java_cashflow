package sample;


import java.util.Iterator;
import java.util.List;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Filter;

import sample.entity.LedgerAccount;
import sample.entity.LedgerEntry;

public class ListLedgerEntries {

  @SuppressWarnings("unchecked")
public static void main(String[] args) {
    SessionFactory factory =
      new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();

    // Filter by user
    Filter userFilter = session.enableFilter("userFilter");
    userFilter.setParameter("userId", new Long(2));

    // Filter by Ledger Account 
    //      Filter ledgerFilter = session.enableFilter("ledgerFilter");
    //      ledgerFilter.setParameter("ledgerId", 2);


    GregorianCalendar fromDate = new GregorianCalendar(2013,9,25);
    GregorianCalendar toDate = new GregorianCalendar(2013,9,30);

    // Filter by Date Range 
    Filter dateRangeFilter = session.enableFilter("dateRangeFilter");
    dateRangeFilter.setParameter("fromDate", fromDate.getTime());
    dateRangeFilter.setParameter("toDate", toDate.getTime());

	List<LedgerEntry> entries = session.createQuery("from LedgerEntry").list();
    System.out.println("Found " + entries.size() + " ledger Entry(s):");

    Iterator<LedgerEntry> il = entries.iterator();
    while(il.hasNext()) {
      LedgerEntry entry = il.next();
 //     LedgerAccount ledger_account = entry.getLedgerAccount();
 //     System.out.print(ledger_account.getName());
      System.out.println(entry.getDate());
    }
    session.close();
  }
}

