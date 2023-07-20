package com.zmslabs.minet.service.impl;

import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.exception.DataNotFoundException;
import com.zmslabs.minet.model.UserDTO;
import com.zmslabs.minet.repository.UserRepository;
import com.zmslabs.minet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;
    private  final ModelMapper modelMapper;
    @Override
    public UserDTO postUser(UserDTO userDto) {
        User user=modelMapper.map(userDto,User.class);
        user=userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public User getUserDetails(Long id){
       return userRepository.findById(id).orElseThrow(()->new DataNotFoundException("user details not present"));
    }
}
