package org.example.last.java.service.impl;

import org.example.last.java.entity.SportDto;
import org.example.last.java.mapper.SportMapper;
import org.example.last.java.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceimpl implements SportService {
    @Autowired
    SportMapper sportMapper;
    public SportDto getSportStatus(SportDto sportDto) {
        int id = sportDto.getId();
        SportDto sportDto1 = sportMapper.getSportStatus(id);
        return sportDto1;
    }

    @Override
    public List<SportDto> SelectAllymq() {
        List<SportDto> Result=new ArrayList<>();
        Result=sportMapper.SelectAllymq();
        return Result;
    }
    @Override
    public List<SportDto> SelectAllppq() {
        List<SportDto> Result=new ArrayList<>();
        Result=sportMapper.SelectAllppq();
        return Result;
    }
    @Override
    public List<SportDto> SelectAllwq() {
        List<SportDto> Result=new ArrayList<>();
        Result=sportMapper.SelectAllwq();
        return Result;
    }
    @Override

    public int UpdateSportymq(int id, int time) {
        synchronized (this) {
            if (time == 1) {
                sportMapper.UpdateSport1y(id);
                return 1;
            }
            if (time == 2) {
                sportMapper.UpdateSport2y(id);
                return 1;
            }
            if (time == 3) {
                sportMapper.UpdateSport3y(id);
                return 1;
            }
            if (time == 4) {
                sportMapper.UpdateSport4y(id);
                return 1;
            }
            if (time == 5) {
                sportMapper.UpdateSport5y(id);
                return 1;
            }
            if (time == 6) {
                sportMapper.UpdateSport6y(id);
                return 1;
            }
            if (time == 7) {
                sportMapper.UpdateSport7y(id);
                return 1;
            }
            if (time == 8) {
                sportMapper.UpdateSport8y(id);
                return 1;
            }
            if (time == 9) {
                sportMapper.UpdateSport9y(id);
                return 1;
            }
            if (time == 10) {
                sportMapper.UpdateSport10y(id);
                return 1;
            }
            if (time == 11) {
                sportMapper.UpdateSport11y(id);
                return 1;
            }
            if (time == 12) {
                sportMapper.UpdateSport12y(id);
                return 1;
            }
            return 0;
        }
    }
    public int UpdateSportppq(int id, int time) {
        synchronized (this) {
            if (time == 1) {
                sportMapper.UpdateSport1p(id);
                return 1;
            }
            if (time == 2) {
                sportMapper.UpdateSport2p(id);
                return 1;
            }
            if (time == 3) {
                sportMapper.UpdateSport3p(id);
                return 1;
            }
            if (time == 4) {
                sportMapper.UpdateSport4p(id);
                return 1;
            }
            if (time == 5) {
                sportMapper.UpdateSport5p(id);
                return 1;
            }
            if (time == 6) {
                sportMapper.UpdateSport6p(id);
                return 1;
            }
            if (time == 7) {
                sportMapper.UpdateSport7p(id);
                return 1;
            }
            if (time == 8) {
                sportMapper.UpdateSport8p(id);
                return 1;
            }
            if (time == 9) {
                sportMapper.UpdateSport9p(id);
                return 1;
            }
            if (time == 10) {
                sportMapper.UpdateSport10p(id);
                return 1;
            }
            if (time == 11) {
                sportMapper.UpdateSport11p(id);
                return 1;
            }
            if (time == 12) {
                sportMapper.UpdateSport12p(id);
                return 1;
            }
            return 0;
        }
    }
    public int UpdateSportwq(int id, int time) {
        synchronized (this) {
            if (time == 1) {
                sportMapper.UpdateSport1w(id);
                return 1;
            }
            if (time == 2) {
                sportMapper.UpdateSport2w(id);
                return 1;
            }
            if (time == 3) {
                sportMapper.UpdateSport3w(id);
                return 1;
            }
            if (time == 4) {
                sportMapper.UpdateSport4w(id);
                return 1;
            }
            if (time == 5) {
                sportMapper.UpdateSport5w(id);
                return 1;
            }
            if (time == 6) {
                sportMapper.UpdateSport6w(id);
                return 1;
            }
            if (time == 7) {
                sportMapper.UpdateSport7w(id);
                return 1;
            }
            if (time == 8) {
                sportMapper.UpdateSport8w(id);
                return 1;
            }
            if (time == 9) {
                sportMapper.UpdateSport9w(id);
                return 1;
            }
            if (time == 10) {
                sportMapper.UpdateSport10w(id);
                return 1;
            }
            if (time == 11) {
                sportMapper.UpdateSport11w(id);
                return 1;
            }
            if (time == 12) {
                sportMapper.UpdateSport12w(id);
                return 1;
            }
            return 0;
        }
    }

    @Override
    public int CancleUpdateSportwq(int id, int time) {
        synchronized (this) {
            if (time == 1) {
                sportMapper.CancleUpdateSport1w(id);
                return 1;
            }
            if (time == 2) {
                sportMapper.CancleUpdateSport2w(id);
                return 1;
            }
            if (time == 3) {
                sportMapper.CancleUpdateSport3w(id);
                return 1;
            }
            if (time == 4) {
                sportMapper.CancleUpdateSport4w(id);
                return 1;
            }
            if (time == 5) {
                sportMapper.CancleUpdateSport5w(id);
                return 1;
            }
            if (time == 6) {
                sportMapper.CancleUpdateSport6w(id);
                return 1;
            }
            if (time == 7) {
                sportMapper.CancleUpdateSport7w(id);
                return 1;
            }
            if (time == 8) {
                sportMapper.CancleUpdateSport8w(id);
                return 1;
            }
            if (time == 9) {
                sportMapper.CancleUpdateSport9w(id);
                return 1;
            }
            if (time == 10) {
                sportMapper.CancleUpdateSport10w(id);
                return 1;
            }
            if (time == 11) {
                sportMapper.CancleUpdateSport11w(id);
                return 1;
            }
            if (time == 12) {
                sportMapper.CancleUpdateSport12w(id);
                return 1;
            }
            return 0;
        }
    }

    @Override
    public int CancleUpdateSportppq(int id, int time) {
        synchronized (this) {
            if (time == 1) {
                sportMapper.CancleUpdateSport1p(id);
                return 1;
            }
            if (time == 2) {
                sportMapper.CancleUpdateSport2p(id);
                return 1;
            }
            if (time == 3) {
                sportMapper.CancleUpdateSport3p(id);
                return 1;
            }
            if (time == 4) {
                sportMapper.CancleUpdateSport4p(id);
                return 1;
            }
            if (time == 5) {
                sportMapper.CancleUpdateSport5p(id);
                return 1;
            }
            if (time == 6) {
                sportMapper.CancleUpdateSport6p(id);
                return 1;
            }
            if (time == 7) {
                sportMapper.CancleUpdateSport7p(id);
                return 1;
            }
            if (time == 8) {
                sportMapper.CancleUpdateSport8p(id);
                return 1;
            }
            if (time == 9) {
                sportMapper.CancleUpdateSport9p(id);
                return 1;
            }
            if (time == 10) {
                sportMapper.CancleUpdateSport10p(id);
                return 1;
            }
            if (time == 11) {
                sportMapper.CancleUpdateSport11p(id);
                return 1;
            }
            if (time == 12) {
                sportMapper.CancleUpdateSport12p(id);
                return 1;
            }
            return 0;
        }
    }

    @Override
    public int CancleUpdateSportymq(int id, int time) {
        synchronized (this) {
            if (time == 1) {
                sportMapper.CancleUpdateSport1y(id);
                return 1;
            }
            if (time == 2) {
                sportMapper.CancleUpdateSport2y(id);
                return 1;
            }
            if (time == 3) {
                sportMapper.CancleUpdateSport3y(id);
                return 1;
            }
            if (time == 4) {
                sportMapper.CancleUpdateSport4y(id);
                return 1;
            }
            if (time == 5) {
                sportMapper.CancleUpdateSport5y(id);
                return 1;
            }
            if (time == 6) {
                sportMapper.CancleUpdateSport6y(id);
                return 1;
            }
            if (time == 7) {
                sportMapper.CancleUpdateSport7y(id);
                return 1;
            }
            if (time == 8) {
                sportMapper.CancleUpdateSport8y(id);
                return 1;
            }
            if (time == 9) {
                sportMapper.CancleUpdateSport9y(id);
                return 1;
            }
            if (time == 10) {
                sportMapper.CancleUpdateSport10y(id);
                return 1;
            }
            if (time == 11) {
                sportMapper.CancleUpdateSport11y(id);
                return 1;
            }
            if (time == 12) {
                sportMapper.CancleUpdateSport12y(id);
                return 1;
            }
            return 0;
        }

    }

}
