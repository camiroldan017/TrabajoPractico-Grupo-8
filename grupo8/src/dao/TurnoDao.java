package dao;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import datos.Turno;

public class TurnoDao {

    public Turno traerTurnoPorId(long idTurno) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Turno.class, idTurno);
        }
    }

    public List<Turno> traerTodosLosTurnos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Turno", Turno.class).list();
        }
    }

    public boolean existeTurnoEnFechaYHoraYServicio(Date fecha, LocalTime hora, Servicio servicio) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Turno t WHERE t.fecha = :fecha AND t.hora = :hora AND t.servicio = :servicio";
            Optional<Turno> resultado = session
                    .createQuery(hql, Turno.class)
                    .setParameter("fecha", fecha)
                    .setParameter("hora", hora)
                    .setParameter("servicio", servicio)
                    .uniqueResultOptional();
            return resultado.isPresent();
        }
    }

    public boolean clienteTieneTurnoEnFechaYHora(Cliente cliente, Date fecha, LocalTime hora) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Turno t WHERE t.cliente = :cliente AND t.fecha = :fecha AND t.hora = :hora";
            Optional<Turno> resultado = session
                    .createQuery(hql, Turno.class)
                    .setParameter("cliente", cliente)
                    .setParameter("fecha", fecha)
                    .setParameter("hora", hora)
                    .uniqueResultOptional();
            return resultado.isPresent();
        }
    }

    public boolean empleadoTieneTurnoAsignadoEnFechaYHora(Empleado empleado, Date fecha, LocalTime hora) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Turno t WHERE t.empleado = :empleado AND t.fecha = :fecha AND t.hora = :hora";
            Optional<Turno> resultado = session
                    .createQuery(hql, Turno.class)
                    .setParameter("empleado", empleado)
                    .setParameter("fecha", fecha)
                    .setParameter("hora", hora)
                    .uniqueResultOptional();
            return resultado.isPresent();
        }
    }

    public void guardarTurno(Turno turno) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.save(turno);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void actualizarTurno(Turno turno) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.update(turno);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    public void eliminarTurno(Turno turno) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.delete(turno);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

}
