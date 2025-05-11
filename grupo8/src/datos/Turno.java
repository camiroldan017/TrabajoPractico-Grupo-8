package datos;

import java.sql.Date;
import java.time.LocalDate;
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
            Servicio servicio, Sucursal sucursal) throws Exception {
        setFecha(fecha);
        setHora(hora);
        setEstado(estado);
        setCliente(cliente);
        setEmpleado(empleado);
        setServicio(servicio);
        setSucursal(sucursal);
    }

    public long getIdTurno() {
        return idTurno;
    }
    protected void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) throws Exception {
        // Verificamos que la fecha ingresada no sea nula, de ser así, lanzamos una excepción
        if(fecha == null) throw new Exception("La fecha no puede ser nula.");
        // Verificamos si la fecha ingresada ya ha pasado, de ser así, lanzamos una excepción
        if(fecha.before(Date.valueOf(LocalDate.now()))) throw new Exception("La fecha ingresada ya ha pasado, y no es válida.");
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) throws Exception {
        // Verificamos que la hora ingresada no sea nula, de ser así, lanzamos una excepción
        if(hora == null) throw new Exception("La hora no puede ser nula.");
        // En caso de que la fecha del turno sea la de hoy, verificamos si la hora ingresada ya ha pasado, de ser así, lanzamos una excepción
        if(fecha.equals(Date.valueOf(LocalDate.now())) && hora.isBefore(LocalTime.now()))
            throw new Exception("La hora ingresada ya ha pasado, y no es válida para la fecha de hoy.");
        this.hora = hora;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) throws Exception {
        // Verificamos que el estado ingresado no sea nulo, de ser así, lanzamos una excepción
        if(estado == null) throw new Exception("El estado no puede ser nulo.");
        // Verificamos que el estado ingresado sea uno de los siguientes: "PENDIENTE", "CONFIRMADO", "REPROGRAMADO",
        // "FINALIZADO" o "AUSENTE", de ser así, lanzamos una excepción
        if(!estado.equalsIgnoreCase("PENDIENTE") && !estado.equalsIgnoreCase("CONFIRMADO")
            && !estado.equalsIgnoreCase("REPROGRAMADO") && !estado.equalsIgnoreCase("FINALIZADO")
            && !estado.equalsIgnoreCase("AUSENTE"))
            throw new Exception("El estado ingresado no es válido.\nEstados válidos:\nPENDIENTE: El turno fue creado pero aún no fue confirmado.\nCONFIRMADO: El usuario confirmó el turno.\nREPROGRAMADO: El turno fue modificado y se pasó a otro día/hora.\nFINALIZADO: El turno fue atendido.\nAUSENTE: El usuario no se presentó al turno");
        this.estado = estado;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) throws Exception {
        // Verificamos que el cliente no sea nulo, de ser así, lanzamos una excepción
        if(cliente == null) throw new Exception("El cliente no puede ser nulo.");
        this.cliente = cliente;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) throws Exception {
        // Verificamos que el empleado no sea nulo, de ser así, lanzamos una excepción
        if(empleado == null) throw new Exception("El empleado no puede ser nulo.");
        this.empleado = empleado;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) throws Exception {
        // Verificamos que el servicio no sea nulo, de ser así, lanzamos una excepción
        if(servicio == null) throw new Exception("El servicio no puede ser nulo.");
        this.servicio = servicio;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) throws Exception {
        // Verificamos que la sucursal no sea nula, de ser así, lanzamos una excepción
        if(sucursal == null) throw new Exception("La sucursal no puede ser nula.");
        this.sucursal = sucursal;
    }
    @Override
    public String toString() {
        return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + "]\n";
    }
}