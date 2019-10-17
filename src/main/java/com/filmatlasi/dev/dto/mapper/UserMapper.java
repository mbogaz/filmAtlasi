package com.filmatlasi.dev.dto.mapper;

import com.filmatlasi.dev.dto.model.RoleDto;
import com.filmatlasi.dev.dto.model.UserDto;
import com.filmatlasi.dev.model.Role;
import com.filmatlasi.dev.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel  = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);

    RoleDto toDto(Role role);
}
