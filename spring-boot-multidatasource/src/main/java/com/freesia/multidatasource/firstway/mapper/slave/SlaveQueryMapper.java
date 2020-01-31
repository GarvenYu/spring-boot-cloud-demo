package com.freesia.multidatasource.firstway.mapper.slave;

import com.freesia.multidatasource.firstway.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yukaibo
 */
@Repository
public interface SlaveQueryMapper {

    @Select("select * from user")
    List<User> selectUserFromSlave();
}
