package datos;

public class Contacto {
    private long idContacto;
    private String email;
    private String telefono;
    private String direccion;

    public Contacto() {
    }

    public Contacto( String email, String telefono, String direccion) {
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public long getIdContacto() {
        return idContacto;
    }

    protected void setIdContacto(long idContacto) {
        this.idContacto = idContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Contacto [idContacto=" + idContacto + ", email=" + email + ", telefono=" + telefono + ", direccion="
                + direccion + "]\n";
    }

}