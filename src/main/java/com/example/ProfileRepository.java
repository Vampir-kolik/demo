package com.example;

import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> getProfileById(int id);
}