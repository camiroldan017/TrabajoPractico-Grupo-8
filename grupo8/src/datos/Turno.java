package datos;

import java.sql.Date;
import java.time.LocalTime;

public class Turno {
    private long idTurno;
    private Date fecha;
    private LocalTime hora;
    private String estado;
    private Cliente cliente;
    private Empleado empleado;
    private Servicio servicio;
    private Sucursal sucursal;

    public Turno() {
    }

    public Turno(Date fecha, LocalTime hora, String estado, Cliente cliente, Empleado empleado,
            Servicio servicio, Sucursal sucursal) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.sucursal = sucursal;
    }

    public long getIdTurno() {
        return idTurno;
    }
    public void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    @Override
    public String toString() {
        return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + "]";
    }
}
