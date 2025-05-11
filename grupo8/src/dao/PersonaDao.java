package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Contacto;
import datos.Empleado;
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

    public Persona traerPersonaPorDni(int dni) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Persona persona = null;
        try {
            persona = session.createQuery("from Persona where dni = :dni", Persona.class)
                    .setParameter("dni", dni).uniqueResult();
        } finally {
            session.close();
        }
        return persona;
    }

    public List<Persona> traerTodasLasPersonas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Persona p LEFT JOIN FETCH p.contacto", Persona.class).list();
        }
    }

    public void guardarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // Reatachar contacto si no es nuevo
            if (persona.getContacto() != null && persona.getContacto().getIdContacto() != 0) {
                Contacto contacto = session.get(Contacto.class, persona.getContacto().getIdContacto());
                persona.setContacto(contacto);
            }
            session.save(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
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
            if (persona.getContacto() != null && persona.getContacto().getIdContacto() != 0) {
                Contacto contacto = session.get(Contacto.class, persona.getContacto().getIdContacto());
                persona.setContacto(contacto);
            }
            session.update(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
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
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Empleado traerEmpleadoPorId(long idEmpleado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Empleado empleado = null;
        try {
            empleado = session.get(Empleado.class, idEmpleado);
        } finally {
            session.close();
        }
        return empleado;
    }

    public Cliente traerClientePorId(long idCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = null;
        try {
            cliente = session.get(Cliente.class, idCliente);
        } finally {
            session.close();
        }
        return cliente;
    }

    public Persona traerEmpleadoPorLegajo(String legajo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Persona empleado = null;
        try {
            empleado = session.createQuery("from Empleado where legajo = :legajo", Persona.class)
                    .setParameter("legajo", legajo).uniqueResult();
        } finally {
            session.close();
        }
        return empleado;
    }

    public Persona traerPersonaYContactoPorId(long idPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Persona persona = null;
        try {
            persona = session
                    .createQuery("from Persona p left join fetch p.contacto where p.idPersona = :idPersona",
                            Persona.class)
                    .setParameter("idPersona", idPersona).uniqueResult();
        } finally {
            session.close();
        }
        return persona;
    }

}
