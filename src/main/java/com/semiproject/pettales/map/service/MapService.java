package com.semiproject.pettales.map.service;

import com.semiproject.pettales.map.dao.MapDAO;
import com.semiproject.pettales.map.dto.MapDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private MapDAO mapDAO;

    public MapService(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public List<MapDTO> comLocation() {
        List<MapDTO> locations = mapDAO.comLocation();

        return locations;
    }
}
