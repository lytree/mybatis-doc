package top.lytree;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper{
  public Role getRole(Long id);
  public Role findRole(String roleName);
  public int deleteRole(Long id);
  public int insertRole(Role role);
}
