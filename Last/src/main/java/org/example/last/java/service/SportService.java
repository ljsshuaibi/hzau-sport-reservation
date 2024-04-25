package org.example.last.java.service;

import org.example.last.java.entity.SportDto;

import java.util.List;

public interface SportService {
    SportDto getSportStatus(SportDto sportDto);
    List<SportDto> SelectAllymq();
    List<SportDto> SelectAllppq();
    List<SportDto> SelectAllwq();
    int UpdateSportymq(int id,int time);
    int CancleUpdateSportymq(int id,int time);

    public int UpdateSportppq(int id, int time);

    int CancleUpdateSportppq(int id, int time);



    public int UpdateSportwq(int id, int time);
    public int CancleUpdateSportwq(int id,int time);


}
