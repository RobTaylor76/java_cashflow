package sample;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sample.entity.User;
public class ListUsers {

  public static void main(String[] args) {
    SessionFactory factory =
      new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();

    List users = session.createQuery("from User").list();
    System.out.println("Found " + users.size() + " message(s):");

    Iterator i = users.iterator();
    while(i.hasNext()) {
      User user = (User)i.next();
      System.out.println(user.getEmail());
    }

    session.close();
  }
}

