package com.freesia.multidatasource.firstway.mapper.master;

import com.freesia.multidatasource.firstway.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yukaibo
 */
@Repository
public interface MasterQueryMapper {

    @Select("select * from user")
    List<User> selectUserFromMaster();
}
