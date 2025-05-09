package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Contacto;
import datos.Empleado;
import datos.Persona;
import datos.Sucursal;

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
            return session.createQuery("from Persona", Persona.class).list();
        }
    }

    public List<Empleado> traerTodosLosEmpleados(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Empleado", Empleado.class).list();
        }
    }

    public List<Cliente> traerTodosLosClientes(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Cliente", Cliente.class).list();
        }
    }

    public void guardarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
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
 

}
