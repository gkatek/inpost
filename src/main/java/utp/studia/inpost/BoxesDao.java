/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp.studia.inpost;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Gracjan Katek
 */
public class BoxesDao {
    public Boxes insert(Boxes box) {
        try (Session session = JpaUtils.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(box);
            t.commit();
            return box;
        }
    }   
}
