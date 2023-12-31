package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.UserRequest;
import com.woodpecker.backend.dtos.UserResponse;
import com.woodpecker.backend.model.*;
import com.woodpecker.backend.repository.UserRepository;
import com.woodpecker.backend.service.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    SettingsService settingsService;
    @Autowired
    ProgressService progressService;
    @Autowired
    PreferencesService preferencesService;
    @Autowired
    PerformanceService performanceService;
    @Autowired
    CategoryService categoryService;

    private static final UserResponse USER_NOT_FOUND = null;

    public UserResponse create(UserRequest request){

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPsw(request.getPsw());
        user.setPhone(request.getPhone());
        user.setEntryDate(new Date());
        user.setGender(request.getGender());

        Settings settings = settingsService.initialize();
        user.setSettings(settings);

        Progress progress = progressService.initialize();
        user.setProgress(progress);

        Preference preference = preferencesService.initialize();
        user.setPreferences(preference);

        Performance performance = performanceService.initialize();
        user.setPerformance(performance);

        repository.save(user);
        Optional<User> userSaved = repository.findByEmail(user.getEmail());

        categoryService.initialize(userSaved.get().getUid());

        return createResponse(user);

        //poderia fazer uma try catch para tratar erro, caso venha falhar a operacao de criacao.
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public UserResponse findByUid(String uid){
        return createResponse(repository.findByUid(uid));
    }

    public UserResponse findByEmail(String email){
        Optional<User> user = repository.findByEmail(email);
        return user.map(this::createResponse).orElse(USER_NOT_FOUND);
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public UserResponse update(String uid, UserRequest request){

        User user = repository.findByUid(uid);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPsw(request.getPsw());
        user.setPhone(request.getPhone());
        user.setEntryDate(new Date());
        user.setGender(request.getGender());

        repository.save(user);
        return createResponse(user);
    }

    public boolean delete(String uid){
        try{
            repository.deleteById(uid);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    private UserResponse createResponse(User user){

        UserResponse response = new UserResponse();
        response.setUid(user.getUid());
        response.setEmail(user.getEmail());
        response.setPsw(user.getPsw());
        response.setName(user.getName());
        response.setGender(user.getGender());
        response.setPhone(user.getPhone());
        response.setEntryDate(user.getEntryDate());

        return response;
    }
}
