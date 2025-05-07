package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import datos.Contacto;


public class ContactoDao {

    public Contacto traerContactoPorId(long idContacto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Contacto contacto = null;
        try {
            contacto = session.get(Contacto.class, idContacto);
        } finally {
            session.close();
        }
        return contacto;
    }

    public List<Contacto> traerTodosLosContactos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contacto> lista = null;
        try {
            lista = session.createQuery("from Contacto", Contacto.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public void guardarContacto(Contacto contacto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(contacto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void actualizarContacto(Contacto contacto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(contacto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void eliminarContacto(Contacto contacto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(contacto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
