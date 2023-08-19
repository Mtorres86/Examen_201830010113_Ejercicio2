package hn.uth.examen_201830010113.ui.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import hn.uth.examen_201830010113.Entities.Contacto;
import hn.uth.examen_201830010113.Repositories.ContactoRepository;

public class DashboardViewModel extends AndroidViewModel {


    private LiveData<List<Contacto>> dataset;
    private ContactoRepository repository;
    public DashboardViewModel(@NonNull Application app) {
        super(app);
        repository = new ContactoRepository(app);
        dataset=repository.getAllContactos();

    }

    public LiveData<List<Contacto>> getAllContactos(){return dataset;
    }

    public void insert(Contacto contacto){
        repository.insertContacto(contacto);

    }
}