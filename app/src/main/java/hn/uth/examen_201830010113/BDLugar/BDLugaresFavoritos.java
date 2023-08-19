package hn.uth.examen_201830010113.BDLugar;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import hn.uth.examen_201830010113.DAO.ContactoDAO;
import hn.uth.examen_201830010113.DAO.LugarDAO;
import hn.uth.examen_201830010113.Entities.Contacto;
import hn.uth.examen_201830010113.Entities.Lugar;
import hn.uth.examen_201830010113.ui.DateConverter;

@Database(version = 1, exportSchema = false, entities = {Lugar.class, Contacto.class})
@TypeConverters(DateConverter.class)
public abstract class BDLugaresFavoritos extends RoomDatabase {
    public abstract LugarDAO lugarDao();
    public abstract ContactoDAO contactoDAO();


    private static volatile BDLugaresFavoritos INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BDLugaresFavoritos getDataBase(final Context context){
        if(INSTANCE == null){
            synchronized (BDLugaresFavoritos.class){
                if (INSTANCE == null){
                    Callback callback = new Callback(){
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db){
                            super.onCreate(db);
                            databaseWriteExecutor.execute(() -> {
                                LugarDAO testDao = INSTANCE.lugarDao();
                                testDao.deleteAll();

                                testDao.insert(new Lugar("San Pedro Sula",new Date(),23.23,23.2,"Moises Torres","88990077","Alejandra Ayala","77665544"));
                                testDao.insert(new Lugar("San Pedro Sula",new Date(),23.23,23.2,"Moises Torres","88990077","Moises Torres","77665544"));


                                ContactoDAO contactoDao = INSTANCE.contactoDAO();
                                contactoDao.deleteAll();
                                contactoDao.insert(new Contacto("Moises Torres","722435631","moises.torres@gmail.com","San Pedro Sula"));
                                contactoDao.insert(new Contacto("Alejandra Ayala","722435631","ale.torres@gmail.com","San Pedro Sula"));
                                contactoDao.insert(new Contacto("Moises Torres","722435631","moises.torres@gmail.com","San Pedro Sula"));
                                contactoDao.insert(new Contacto("Moises Torres","722435631","moises.torres@gmail.com","San Pedro Sula"));




                            });
                        }
                    };
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),BDLugaresFavoritos.class,"db_lugaresfavoritos").addCallback(callback).build();

                }
            }
        }
        return INSTANCE;
    }
}
