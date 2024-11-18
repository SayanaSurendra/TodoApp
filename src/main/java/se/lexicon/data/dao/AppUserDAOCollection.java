package se.lexicon.data.dao;

import se.lexicon.model.AppUser;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class AppUserDAOCollection implements AppUserDAO{

   private  Collection<AppUser> appUsers;

    public AppUserDAOCollection(){
        this.appUsers=new HashSet<>();
    }


    @Override
    public AppUser persist(AppUser appUser) {
        if(appUser !=null && appUsers.add(appUser)){
            return appUser;
        }
        return null;
    }

    @Override
    public AppUser findByUsername(String username) {
        for(AppUser appUser:appUsers){
            if(appUser.getUsername().trim().equalsIgnoreCase(username.trim())){
                return appUser;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return Collections.unmodifiableCollection(appUsers);
    }

    @Override
    public void remove(String username) {
        AppUser user=findByUsername(username);
        if(user !=null){
            appUsers.remove(user);
        }
    }
}
