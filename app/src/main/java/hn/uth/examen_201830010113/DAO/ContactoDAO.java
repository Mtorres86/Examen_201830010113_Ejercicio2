package hn.uth.examen_201830010113.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hn.uth.examen_201830010113.Entities.Contacto;

@Dao
public interface ContactoDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Contacto contacto);


    @Update
    void update(Contacto contacto);
    @Delete
    void delete(Contacto contacto);

    @Query("DELETE FROM contactos_table")
    void deleteAll();

    @Query("SELECT * FROM contactos_table ORDER BY  nombre ASC")
    LiveData<List<Contacto>> getContacto();
}
