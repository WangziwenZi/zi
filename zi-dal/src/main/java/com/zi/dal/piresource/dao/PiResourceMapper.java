package com.zi.dal.piresource.dao;

import com.zi.dal.piresource.entity.PiResource;
import com.zi.dal.piresource.entity.PiResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PiResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int countByExample(PiResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int deleteByExample(PiResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int insert(PiResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int insertSelective(PiResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    List<PiResource> selectByExample(PiResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    PiResource selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int updateByExampleSelective(@Param("record") PiResource record, @Param("example") PiResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int updateByExample(@Param("record") PiResource record, @Param("example") PiResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int updateByPrimaryKeySelective(PiResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pi_resource
     *
     * @mbggenerated Sun Dec 18 13:40:48 CST 2016
     */
    int updateByPrimaryKey(PiResource record);
}