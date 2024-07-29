package com.example.TacoCloud.data;

import com.example.TacoCloud.security.UserData;
import org.springframework.data.repository.CrudRepository;

/**
 * @author aleksandrov_maksim
 */
public interface UserDataRepository 
        extends CrudRepository<UserData, Long>{
    
    UserData findByUsername(String username);

}
