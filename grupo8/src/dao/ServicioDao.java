package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import datos.Servicio;

public class ServicioDao {

    public Servicio traerServicioPorId(long idServicio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Servicio servicio = null;
        try {
            tx = session.beginTransaction();
            servicio = session.get(Servicio.class, idServicio);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return servicio;
    }

    public List<Servicio> traerTodosLosServicios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Servicio> lista = null;
        try {
            lista = session.createQuery("from Servicio", Servicio.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public void guardarServicio(Servicio servicio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(servicio);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

        public void actualizarServicio(Servicio servicio) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(servicio);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
               throw e;
            } finally {
                session.close();
            }
        }

        public void eliminarServicio(Servicio servicio) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.delete(servicio);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

    }
    

