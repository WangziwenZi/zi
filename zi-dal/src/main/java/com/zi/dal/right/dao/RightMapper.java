package com.zi.dal.right.dao;

import com.zi.dal.right.entity.Right;
import com.zi.dal.right.entity.RightExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int countByExample(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int deleteByExample(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int insert(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int insertSelective(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    List<Right> selectByExampleWithBLOBs(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    List<Right> selectByExample(RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    Right selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int updateByExampleSelective(@Param("record") Right record, @Param("example") RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int updateByExampleWithBLOBs(@Param("record") Right record, @Param("example") RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int updateByExample(@Param("record") Right record, @Param("example") RightExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int updateByPrimaryKeySelective(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int updateByPrimaryKeyWithBLOBs(Right record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table right
     *
     * @mbggenerated Tue Aug 16 17:48:33 ICT 2016
     */
    int updateByPrimaryKey(Right record);
}