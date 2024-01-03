package com.semiproject.pettales.map.dao;

import com.semiproject.pettales.map.dto.ComMarkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComMarkDAO {
    List<ComMarkDTO> selectComMarkByUserCode(int userCode);
}
