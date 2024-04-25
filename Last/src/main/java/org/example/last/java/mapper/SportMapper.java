package org.example.last.java.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.last.java.entity.SportDto;

import java.util.List;

@Mapper
public interface SportMapper {
    @Select("select * from ymq where id=#{id}")
    SportDto getSportStatus(int id);
    @Select("select * from ymq")
    List<SportDto> SelectAllymq();
    @Select("select * from ppq")
    List<SportDto> SelectAllppq();
    @Select("select * from wq")
    List<SportDto> SelectAllwq();

    /*羽毛球*/
    @Update("update ymq set time1=1 where id=#{id}")
    int UpdateSport1y(int id);
    @Update("update ymq set time2=1 where id=#{id}")
    int UpdateSport2y(int id);
    @Update("update ymq set time3=1 where id=#{id}")
    int UpdateSport3y(int id);
    @Update("update ymq set time4=1 where id=#{id}")
    int UpdateSport4y(int id);
    @Update("update ymq set time5=1 where id=#{id}")
    int UpdateSport5y(int id);
    @Update("update ymq set time6=1 where id=#{id}")
    int UpdateSport6y(int id);
    @Update("update ymq set time7=1 where id=#{id}")
    int UpdateSport7y(int id);
    @Update("update ymq set time8=1 where id=#{id}")
    int UpdateSport8y(int id);
    @Update("update ymq set time9=1 where id=#{id}")
    int UpdateSport9y(int id);
    @Update("update ymq set time10=1 where id=#{id}")
    int UpdateSport10y(int id);
    @Update("update ymq set time11=1 where id=#{id}")
    int UpdateSport11y(int id);
    @Update("update ymq set time12=1 where id=#{id}")
    int UpdateSport12y(int id);
    @Update("update ymq set time1=0 where id=#{id}")
    int CancleUpdateSport1y(int id);
    @Update("update ymq set time2=0 where id=#{id}")
    int CancleUpdateSport2y(int id);
    @Update("update ymq set time3=0 where id=#{id}")
    int CancleUpdateSport3y(int id);
    @Update("update ymq set time4=0 where id=#{id}")
    int CancleUpdateSport4y(int id);
    @Update("update ymq set time5=0 where id=#{id}")
    int CancleUpdateSport5y(int id);
    @Update("update ymq set time6=0 where id=#{id}")
    int CancleUpdateSport6y(int id);
    @Update("update ymq set time7=0 where id=#{id}")
    int CancleUpdateSport7y(int id);
    @Update("update ymq set time8=0 where id=#{id}")
    int CancleUpdateSport8y(int id);
    @Update("update ymq set time9=0 where id=#{id}")
    int CancleUpdateSport9y(int id);
    @Update("update ymq set time10=0 where id=#{id}")
    int CancleUpdateSport10y(int id);
    @Update("update ymq set time11=0 where id=#{id}")
    int CancleUpdateSport11y(int id);
    @Update("update ymq set time12=0 where id=#{id}")
    int CancleUpdateSport12y(int id);
    /*乒乓球*/
    @Update("update ppq set time1=1 where id=#{id}")
    int UpdateSport1p(int id);
    @Update("update ppq set time2=1 where id=#{id}")
    int UpdateSport2p(int id);
    @Update("update ppq set time3=1 where id=#{id}")
    int UpdateSport3p(int id);
    @Update("update ppq set time4=1 where id=#{id}")
    int UpdateSport4p(int id);
    @Update("update ppq set time5=1 where id=#{id}")
    int UpdateSport5p(int id);
    @Update("update ppq set time6=1 where id=#{id}")
    int UpdateSport6p(int id);
    @Update("update ppq set time7=1 where id=#{id}")
    int UpdateSport7p(int id);
    @Update("update ppq set time8=1 where id=#{id}")
    int UpdateSport8p(int id);
    @Update("update ppq set time9=1 where id=#{id}")
    int UpdateSport9p(int id);
    @Update("update ppq set time10=1 where id=#{id}")
    int UpdateSport10p(int id);
    @Update("update ppq set time11=1 where id=#{id}")
    int UpdateSport11p(int id);
    @Update("update ppq set time12=1 where id=#{id}")
    int UpdateSport12p(int id);
    @Update("update ppq set time1=0 where id=#{id}")
    int CancleUpdateSport1p(int id);
    @Update("update ppq set time2=0 where id=#{id}")
    int CancleUpdateSport2p(int id);
    @Update("update ppq set time3=0 where id=#{id}")
    int CancleUpdateSport3p(int id);
    @Update("update ppq set time4=0 where id=#{id}")
    int CancleUpdateSport4p(int id);
    @Update("update ppq set time5=0 where id=#{id}")
    int CancleUpdateSport5p(int id);
    @Update("update ppq set time6=0 where id=#{id}")
    int CancleUpdateSport6p(int id);
    @Update("update ppq set time7=0 where id=#{id}")
    int CancleUpdateSport7p(int id);
    @Update("update ppq set time8=0 where id=#{id}")
    int CancleUpdateSport8p(int id);
    @Update("update ppq set time9=0 where id=#{id}")
    int CancleUpdateSport9p(int id);
    @Update("update ppq set time10=0 where id=#{id}")
    int CancleUpdateSport10p(int id);
    @Update("update ppq set time11=0 where id=#{id}")
    int CancleUpdateSport11p(int id);
    @Update("update ppq set time12=0 where id=#{id}")
    int CancleUpdateSport12p(int id);
    /*网球*/
    @Update("update wq set time1=1 where id=#{id}")
    int UpdateSport1w(int id);
    @Update("update wq set time2=1 where id=#{id}")
    int UpdateSport2w(int id);
    @Update("update wq set time3=1 where id=#{id}")
    int UpdateSport3w(int id);
    @Update("update wq set time4=1 where id=#{id}")
    int UpdateSport4w(int id);
    @Update("update wq set time5=1 where id=#{id}")
    int UpdateSport5w(int id);
    @Update("update wq set time6=1 where id=#{id}")
    int UpdateSport6w(int id);
    @Update("update wq set time7=1 where id=#{id}")
    int UpdateSport7w(int id);
    @Update("update wq set time8=1 where id=#{id}")
    int UpdateSport8w(int id);
    @Update("update wq set time9=1 where id=#{id}")
    int UpdateSport9w(int id);
    @Update("update wq set time10=1 where id=#{id}")
    int UpdateSport10w(int id);
    @Update("update wq set time11=1 where id=#{id}")
    int UpdateSport11w(int id);
    @Update("update wq set time12=1 where id=#{id}")
    int UpdateSport12w(int id);
    @Update("update wq set time1=0 where id=#{id}")
    int CancleUpdateSport1w(int id);
    @Update("update wq set time2=0 where id=#{id}")
    int CancleUpdateSport2w(int id);
    @Update("update wq set time3=0 where id=#{id}")
    int CancleUpdateSport3w(int id);
    @Update("update wq set time4=0 where id=#{id}")
    int CancleUpdateSport4w(int id);
    @Update("update wq set time5=0 where id=#{id}")
    int CancleUpdateSport5w(int id);
    @Update("update wq set time6=0 where id=#{id}")
    int CancleUpdateSport6w(int id);
    @Update("update wq set time7=0 where id=#{id}")
    int CancleUpdateSport7w(int id);
    @Update("update wq set time8=0 where id=#{id}")
    int CancleUpdateSport8w(int id);
    @Update("update wq set time9=0 where id=#{id}")
    int CancleUpdateSport9w(int id);
    @Update("update wq set time10=0 where id=#{id}")
    int CancleUpdateSport10w(int id);
    @Update("update wq set time11=0 where id=#{id}")
    int CancleUpdateSport11w(int id);
    @Update("update wq set time12=0 where id=#{id}")
    int CancleUpdateSport12w(int id);


}

