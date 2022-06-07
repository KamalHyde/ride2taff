package com.example.ride2taff.service;

import com.example.ride2taff.dto.UserGoogleDto;

public interface IAuthService {
    UserGoogleDto tokenToDto(String id_token);
}
