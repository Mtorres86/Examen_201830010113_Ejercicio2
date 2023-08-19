package hn.uth.examen_201830010113.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import hn.uth.examen_201830010113.BDLugar.BDLugaresFavoritos;
import hn.uth.examen_201830010113.DAO.ContactoDAO;
import hn.uth.examen_201830010113.Entities.Contacto;

public class ContactoRepository {
    private ContactoDAO contactoDao;

    private LiveData<List<Contacto>> dataset;
    public ContactoRepository(Application app ) {
        BDLugaresFavoritos db = BDLugaresFavoritos.getDataBase(app);
        this.contactoDao = db.contactoDAO();
        this.dataset = contactoDao.getContacto();

    }

    public ContactoRepository(ContactoDAO contactoDao) {
        this.contactoDao = contactoDao;
    }

    public LiveData<List<Contacto>> getAllContactos() {
        return contactoDao.getContacto();
    }


    public void insertContacto(Contacto contacto) {
        BDLugaresFavoritos.databaseWriteExecutor.execute(() -> {
            contactoDao.insert(contacto);
        });
    }

    public void updateContacto(Contacto contacto) {
        BDLugaresFavoritos.databaseWriteExecutor.execute(() -> {
            contactoDao.update(contacto);
        });
    }

    public void deleteContacto(Contacto contacto) {
        BDLugaresFavoritos.databaseWriteExecutor.execute(() -> {
            contactoDao.delete(contacto);
        });
    }
}