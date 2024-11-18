package com.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
//@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile getProfile(int personId) {
        ProfileNotFoundException vEx = new ProfileNotFoundException(personId);
        return profileRepository.getProfileById(personId)
                .orElseThrow(vEx.fEx());
    }
}