package hn.uth.examen_201830010113.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import hn.uth.examen_201830010113.BDLugar.BDLugaresFavoritos;
import hn.uth.examen_201830010113.DAO.LugarDAO;
import hn.uth.examen_201830010113.Entities.Lugar;

public class LugarRepository {
    private LugarDAO lugarDao;
    private LiveData<List<Lugar>> dataset;


    public LugarRepository(Application app ) {
        BDLugaresFavoritos db = BDLugaresFavoritos.getDataBase(app);
        this.lugarDao = db.lugarDao();
        this.dataset = lugarDao.getLugar();

    }

    public LiveData<List<Lugar>> getAllLugares()
    {
        return dataset;
    }

    public void insertLugar(Lugar lugar) {
        BDLugaresFavoritos.databaseWriteExecutor.execute(() -> {
            lugarDao.insert(lugar);
        });
    }

    public void updateLugar(Lugar lugar) {
        BDLugaresFavoritos.databaseWriteExecutor.execute(() -> {
            lugarDao.update(lugar);
        });
    }

    public void deleteLugar(Lugar lugar) {
        BDLugaresFavoritos.databaseWriteExecutor.execute(() -> {
            lugarDao.delete(lugar);
        });
    }
}
