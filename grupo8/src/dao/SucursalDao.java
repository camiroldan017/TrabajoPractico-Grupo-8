package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contacto;
import datos.Sucursal;
import java.util.List;

public class SucursalDao {

    public Sucursal traerSucursalPorId(long idSucursal) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Sucursal.class, idSucursal);
        }
    }

    public List<Sucursal> traerTodasLasSucursales() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Sucursal", Sucursal.class).list();
        }
    }

    public void guardarSucursal(Sucursal sucursal) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.save(sucursal);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void actualizarSucursal(Sucursal sucursal) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.update(sucursal);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void eliminarSucursal(Sucursal sucursal) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.delete(sucursal);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void agregarContactoASucursal(long idSucursal, Contacto contacto) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Transaction tx = session.beginTransaction();
        try {
            Sucursal sucursal = session.get(Sucursal.class, idSucursal);
            if (sucursal != null) {
                sucursal.setContacto(contacto);
                session.update(sucursal);
                tx.commit();
            } else {
                throw new RuntimeException("Sucursal no encontrada con id: " + idSucursal);
            }
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
    /* 
        public void eliminarContactoDeSucursal(long idSucursal) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                try {
                    Sucursal sucursal = session.get(Sucursal.class, idSucursal);
                    if (sucursal != null) {
                        sucursal.setContacto(null);
                        session.update(sucursal);
                        tx.commit();
                    } else {
                        throw new RuntimeException("Sucursal no encontrada con id: " + idSucursal);
                    }
                } catch (Exception e) {
                    tx.rollback();
                    throw e;
                }
            }
        } */

}