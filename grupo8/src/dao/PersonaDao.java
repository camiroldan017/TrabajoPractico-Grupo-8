package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Persona;
import java.util.List;

public class PersonaDao {

    public Persona traerPersonaPorId(long idPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Persona persona = null;
        try {
            persona = session.get(Persona.class, idPersona);
        } finally {
            session.close();
        }
        return persona;
    }

    public List<Persona> traerTodasLasPersonas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Persona> lista = null;
        try {
            lista = session.createQuery("from Persona", Persona.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public void guardarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void actualizarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void eliminarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
