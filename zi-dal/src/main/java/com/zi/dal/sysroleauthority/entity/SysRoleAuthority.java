package com.zi.dal.sysroleauthority.entity;

public class SysRoleAuthority {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_authority.id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_authority.role_id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_authority.authority_id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    private String authorityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_authority.id
     *
     * @return the value of sys_role_authority.id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_authority.id
     *
     * @param id the value for sys_role_authority.id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_authority.role_id
     *
     * @return the value of sys_role_authority.role_id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_authority.role_id
     *
     * @param roleId the value for sys_role_authority.role_id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_authority.authority_id
     *
     * @return the value of sys_role_authority.authority_id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_authority.authority_id
     *
     * @param authorityId the value for sys_role_authority.authority_id
     *
     * @mbggenerated Thu Jan 05 15:18:39 CST 2017
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }
}