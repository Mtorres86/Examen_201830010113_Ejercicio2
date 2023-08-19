package hn.uth.examen_201830010113.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import hn.uth.examen_201830010113.ui.DateConverter;

@Entity(tableName = "lugar_table")
public class Lugar {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idlugar")
    private int idlugar;
    @NonNull
    @ColumnInfo(name = "lugar")
    private String lugar;

    @NonNull
    @ColumnInfo(name = "fecha")
    @TypeConverters(DateConverter.class)
    private Date fecha;
    @NonNull
    @ColumnInfo(name = "longitud")
    private Double longitud;
    @NonNull
    @ColumnInfo(name = "latitud")
    private Double latitud;
    @NonNull
    @ColumnInfo(name = "contacto")
    private String  contacto;
    @NonNull
    @ColumnInfo(name = "telefono")
    private String telefono;
    @NonNull
    @ColumnInfo(name = "contactouv")
    private String  contactouv;
    @NonNull
    @ColumnInfo(name = "telefonouv")
    private String telefonouv;

    public Lugar(@NonNull String lugar, @NonNull Date fecha, @NonNull Double longitud, @NonNull Double latitud, @NonNull String contacto, @NonNull String telefono, @NonNull String contactouv, @NonNull String telefonouv) {
        this.lugar = lugar;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
        this.contacto = contacto;
        this.telefono = telefono;
        this.contactouv = contactouv;
        this.telefonouv = telefonouv;
    }

    public int getIdlugar() {
        return idlugar;
    }

    public void setIdlugar(int idlugar) {
        this.idlugar = idlugar;
    }

    @NonNull
    public String getLugar() {
        return lugar;
    }

    public void setLugar(@NonNull String lugar) {
        this.lugar = lugar;
    }

    @NonNull
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull Date fecha) {
        this.fecha = fecha;
    }

    @NonNull
    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(@NonNull Double longitud) {
        this.longitud = longitud;
    }

    @NonNull
    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(@NonNull Double latitud) {
        this.latitud = latitud;
    }

    @NonNull
    public String getContacto() {
        return contacto;
    }

    public void setContacto(@NonNull String contacto) {
        this.contacto = contacto;
    }

    @NonNull
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NonNull String telefono) {
        this.telefono = telefono;
    }

    @NonNull
    public String getContactouv() {
        return contactouv;
    }

    public void setContactouv(@NonNull String contactouv) {
        this.contactouv = contactouv;
    }

    @NonNull
    public String getTelefonouv() {
        return telefonouv;
    }

    public void setTelefonouv(@NonNull String telefonouv) {
        this.telefonouv = telefonouv;
    }
}
